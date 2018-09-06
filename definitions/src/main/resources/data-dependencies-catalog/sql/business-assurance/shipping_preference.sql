SELECT  vip.fecha as fecha, 
        vip.site_id as site, 
        vip.platform as platform, 
        vip.l1 as l1,
        vip.l1_name as l1_name,
        vip.shipping_preference_vip as shipping_preference_vip, 
        sum(vip.quantity_unique) as quantity_vip_unique, 
        sum(vip.quantity_total) as quantity_vip_total, 
        congrats.shipping_preference_congrats as shipping_preference_congrats, 
        sum(congrats.quantity_unique) as quantity_congrats_unique
FROM
(
  SELECT  item.fecha AS fecha, 
          item.shipping_preference_vip as shipping_preference_vip, 
          item.platform as platform, 
          item.site_id as site_id, 
          item.uid as uid, 
          item.item_id as item_id, 
          item.quantity_total as quantity_total, 
          item.quantity_unique as quantity_unique, 
          categories.L1 as L1, 
          categories.L1_name as L1_name
  FROM
  (
    SELECT  substr(ds,1,10) as fecha, 
            jest(event_data, 'shipping_preference') as shipping_preference_vip, 
            device.platform as platform,
            application.site_id,
            usr.user_id as uid, 
            jest(event_data, 'item_id') as item_id, 
            count(*) as quantity_total,
            count(distinct (concat(usr.user_id,'-',jest(event_data,'item_id')))) as quantity_unique,
            jest(event_data, 'category_id') as category
      FROM TRACKS 
      WHERE
        path = '/vip'
        AND application.site_id IN ('MCO', 'MLA', 'MLB', 'MLC', 'MLM', 'MLU', 'MLV')
        AND ds >= '@param01'
        AND ds < '@param02'
        AND device.platform LIKE '/web/%'
        AND jest(event_data, 'shipping_preference') IS NOT NULL
      GROUP BY  jest(event_data, 'shipping_preference'), 
                device.platform, 
                application.site_id, 
                jest(event_data, 'item_id'), 
                usr.user_id, 
                substr(ds,1,10), 
                jest(event_data, 'category_id')    
  ) as item
  LEFT JOIN
  ( 
    select id as id,
           split(path_from_root,'->')[0] as L1,
           split(full_name,'->')[0] as L1_name
    from categories 
  ) AS categories  
  ON categories.id = item.category
) AS vip
LEFT JOIN
(
  SELECT  substr(ds,1,10) as fecha, 
        jest(event_data, 'shipping[0].shipping_option.name') as shipping_preference_congrats, 
        device.platform as platform,
        application.site_id,
        usr.user_id as uid, 
        jest(event_data, 'items[0].item.id') as item_id, 
        jest(event_data,'items[0].item.category_path[0]') as l1,
        count(distinct jest(event_data, 'order_id')) as quantity_unique
  FROM TRACKS 
  WHERE
    path = '/checkout/congrats'
    AND application.site_id IN ('MCO', 'MLA', 'MLB', 'MLC', 'MLM', 'MLU', 'MLV')
    AND ds >= '@param01'
    AND ds < '@param02'
    AND device.platform LIKE '/web/%'
    AND jest(event_data, 'congrats_seq') = 1
  GROUP BY  jest(event_data, 'shipping[0].shipping_option.name'),
            device.platform, 
            application.site_id, 
            jest(event_data, 'items[0].item.id'), 
            jest(event_data,'items[0].item.category_path[0]'),
            usr.user_id, 
            substr(ds,1,10)
) AS congrats
ON vip.fecha = congrats.fecha 
   AND vip.platform = congrats.platform
   AND vip.site_id = congrats.site_id
   AND vip.item_id = congrats.item_id  
   AND vip.uid = congrats.uid
GROUP BY  vip.fecha, 
          vip.platform, 
          vip.site_id, 
          vip.shipping_preference_vip, 
          congrats.shipping_preference_congrats, 
          vip.l1, 
          vip.l1_name