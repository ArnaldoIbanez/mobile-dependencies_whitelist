SELECT
sum(if(path='/vip',1,0)) as vips,
    sum(if(path='/vip/buy_action',1,0)) as buy,
    sum(if(path='/vip/add_cart_action',1,0)) as add_to_cart,
    substr(ds, 1 , 10) AS a_sent_date,
    device.platform AS a_device
FROM tracks
WHERE ds >= '@param01'
AND ds < '@param02'
and application.site_id in ('MLA', 'MLB', 'MLC', 'MLM', 'MCO', 'MLV', 'MPE', 'MLU')
and jest(event_data, 'vertical') = 'core'
and jest(event_data, 'item_id') like 'MLB%'
and (((regexp_like(application.version, '(9\.2[8-9][0-9]*\.)|(9\.[3-9][0-9]\.)|(9\.[0-9]{3,}\.)|([1-9][0-9]{1,}\.[0-9]+\.)'))
  and device.platform = '/mobile/android') or ((regexp_like(application.version, '(10\.4[1-9]\.)|(10\.[4-9][2-9]\.)|(10\.[5-9][0-9]\.)|(10\.[0-9]{3,}\.)|([0-9]{3,}\.[0-9]+\.)'))
  and device.platform = '/mobile/ios') or (device.platform LIKE '/web%'))
GROUP BY application.site_id, device.platform, substr(ds, 1, 10);