SELECT vips.sit_site_id_group,
       vips.device_platform,
       count(*) as total_vip,
       sum(if(COALESCE(bi_amount,0)>0,1,0)) as total_buy_action,
       sum(if(COALESCE(buy_grats,0)>0,1,0)) as total_buy_grats,
       sum(if(vips.cart_content in ('true','1'),1,0)) as total_vip_cart,
       sum(if(COALESCE(atc_amount,0)>0,1,0)) as total_cart_action,
       sum(if(COALESCE(cart_grats,0)>0,1,0)) as total_cart_grats,
       cast(vips.ds_date as date) as ds

FROM
(
  (
    (
      (
SELECT sit_site_id_group,
ds_date,
device_platform,
uid,
item,
cart_content
FROM melilake.bt_vip
WHERE ds_date >= '@param01' AND ds_date < '@param02'
      AND sit_site_id_group in ('MLB','MLA','MLM')
      AND device_platform in ('/web/desktop','/web/mobile','/mobile/android','/mobile/ios')
      AND uid IS NOT NULL
      AND NOT is_bot(device_user_agent)
      AND vertical = 'core'
      AND shipping_mode is not null
      AND (((app_version rlike '(9\.29[0-9]*\.)|(9\.[3-9][0-9]\.)|(9\.[0-9]{3,}\.)|([1-9][0-9]{1,}\.[0-9]+\.)') and device_platform = '/mobile/android') or ((app_version rlike '(10\.4[3-9]\.)|(10\.[4-9][3-9]\.)|(10\.[5-9][0-9]\.)|(10\.[0-9]{3,}\.)|([0-9]{3,}\.[0-9]+\.)|([1-9][1-9]\.[0-9]{1,}\.)') and device_platform = '/mobile/ios') or (device_platform LIKE '/web/mobile') or device_platform LIKE '/web/desktop')
GROUP BY sit_site_id_group, ds_date, device_platform, uid, item, cart_content, shipping_mode, if(get_json_object(event_data, '$.logistic_type') is null,'agree_with_seller',get_json_object(event_data, '$.logistic_type')), if(lyl_level_number is null AND cus_nickname is null, 0, lyl_level_number)

      ) as vips
      
      LEFT JOIN
      
      (SELECT bvbi.sit_site_id_group as site,
        bvbi.ds_date as date_bi,
        device_platform as bi_plat,
        uid as bi_uid,
        CONCAT(bvbi.sit_site_id_group, CAST(ite_item_id as varchar(10))) as item_id,
        SUM(if(bvbi.path = '/vip/add_cart_action', 1, 0)) as atc_amount,
        SUM(if(bvbi.path = '/vip/buy_action', 1, 0)) as bi_amount
        FROM   
        ((SELECT *
        FROM melilake.bt_vip_buy_intentions bvbi
        WHERE bvbi.ds_date >= '@param01' and bvbi.ds_date < '@param02'
               AND device_platform in ('/web/desktop','/web/mobile','/mobile/android','/mobile/ios')
               AND bvbi.path in ('/vip/buy_action', '/vip/add_cart_action')
               AND bvbi.uid IS NOT NULL
               AND bvbi.sit_site_id_group in ('MLB','MLA','MLM')
        )bvbi
        INNER JOIN 
        
        (SELECT * 
        FROM melilake.lk_vip_buy_intentions_item lvbii
        WHERE lvbii.ds_date >= '@param01' and lvbii.ds_date < '@param02'
                AND lvbii.sit_site_id_group in ('MLB','MLA','MLM')
        )lvbii
        on bvbi.id = lvbii.id
        )
        group by bvbi.sit_site_id_group, bvbi.ds_date, device_platform, uid, CONCAT(bvbi.sit_site_id_group, CAST(ite_item_id as varchar(10)))
      ) as buy_int
      on vips.sit_site_id_group = buy_int.site
      and vips.ds_date = buy_int.date_bi
      and vips.device_platform = buy_int.bi_plat
      and vips.uid = buy_int.bi_uid
      and vips.item = buy_int.item_id
    )
  
  LEFT JOIN
  
    (SELECT bcc.sit_site_id_group as site, bcc.ds_date as date_cho, device_platform as cho_plat, uid as cho_uid, CONCAT(bcc.sit_site_id_group, CAST(ite_item_id as varchar(10))) as item_id,
SUM(if(path = '/cart/checkout/congrats', 1, 0)) as cart_grats,
SUM(if(path = '/checkout/congrats', 1, 0)) as buy_grats
FROM
((SELECT *
        FROM melilake.bt_cho_congrats bcc
        WHERE bcc.ds_date >= '@param01' and bcc.ds_date < '@param02'
               AND device_platform in ('/web/desktop','/web/mobile','/mobile/android','/mobile/ios')
               AND get_json_object(event_data, '$.recover') IS NULL
               AND uid IS NOT NULL
               AND path in ('/cart/checkout/congrats', '/checkout/congrats')
               AND bcc.sit_site_id_group in ('MLB','MLA','MLM')
               AND congrats_seq='1'
        )bcc
        INNER JOIN 
        (SELECT * 
        FROM melilake.lk_cho_congrats_item lcci
        WHERE lcci.ds_date >= '@param01' and lcci.ds_date < '@param02'
                AND lcci.sit_site_id_group in ('MLB','MLA','MLM')
        )lcci
        on bcc.id = lcci.id
        )
        group by bcc.sit_site_id_group, bcc.ds_date, device_platform, uid, CONCAT(bcc.sit_site_id_group, CAST(ite_item_id as varchar(10)))
     ) as grats
   
   ON
  
  vips.sit_site_id_group = grats.site
  and vips.ds_date = grats.date_cho
  and vips.device_platform = grats.cho_plat
  and vips.uid = grats.cho_uid
  and vips.item = grats.item_id
  )
  INNER JOIN
  (
   SELECT uid, ds_date
FROM 
(SELECT mv.uid, mv.ds_date, SUM(if(mv.cus_cust_id_buy is not null,1,0)) as logged_count
      FROM melilake.bt_vip mv
      WHERE ds_date >=  '@param01' and ds_date < '@param02'
            AND device_platform in ('/web/desktop','/web/mobile','/mobile/android','/mobile/ios')
            AND uid IS NOT NULL
            AND sit_site_id_group in ('MLB','MLA','MLM')
            AND NOT is_bot(device_user_agent)
      GROUP BY uid, ds_date
) mv
WHERE (logged_count = 0
      AND uid in (SELECT usr.uid as uid
                  FROM tracks
                  WHERE  ds >=   '@param01' ||' 00' and ds < '@param02' ||' 00'
                        AND application.site_id in ('MLB','MLA','MLM')
                        AND device.platform in ('/web/desktop','/web/mobile','/mobile/android','/mobile/ios')
                        AND (
                        (PATH like '/vip' and platform.fragment is not NULL)
                        OR path like '/search%'
                        OR path like '/home%'
                        OR path like '/bookmark%'
                        OR path like '/myml%'
                        ))
      )
      OR  logged_count > 1
  )as valid_uids
  ON vips.uid = valid_uids.uid and vips.ds_date = valid_uids.ds_date
)
GROUP BY vips.sit_site_id_group,
       vips.device_platform,
       cast(vips.ds_date as date)
