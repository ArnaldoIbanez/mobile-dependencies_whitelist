SELECT  vips.uid as uid, 
        congrats.user_id as user_id, 
        vips.fecha as fecha, 
        vips.item_id as item, 
        vips.freeshipping as freeshipping, 
        vips.shipping_preference_vip as shipping_preference_vip, 
        vips.cantidad as cantidad_vip, 
        congrats.method_id as method_id_congrats, 
        congrats.shipping_option as shipping_name_congrats, 
        congrats.cantidad as cantidad_congrats, 
        congrats.platform as platform, 
        congrats.site as site, 
        congrats.l1 as l1, 
        congrats.l2 as l2
FROM
(
  SELECT substr(ds,1,10) as fecha, jest(event_data, 'item_id') as item_id, jest(event_data, 'shipping_preference') as shipping_preference_vip, jest(event_data, 'free_shipping_benefit') as freeshipping, count(*) as cantidad, usr.uid as uid, device.platform as platform
  FROM TRACKS 
  WHERE
  path = '/vip'
  AND application.site_id IN ('MCO', 'MLA', 'MLB', 'MLC', 'MLM', 'MLU', 'MLV')
  AND ds >= '@param01'
  AND ds < '@param02'
  AND jest(event_data, 'shipping_preference') IS NOT NULL
  GROUP BY jest(event_data, 'shipping_preference'), jest(event_data, 'item_id'), substr(ds,1,10), jest(event_data, 'free_shipping_benefit'), usr.uid, device.platform
) AS vips
INNER JOIN
(
  SELECT substr(ds,1,10) as fecha, jest(event_data, 'items[0].item.id') as item_id, jest(event_data, 'shipping[0].shipping_option.shipping_method_id') as method_id, jest(event_data, 'shipping[0].shipping_option.name') as shipping_option, count(distinct jest(event_data, 'order_id')) as cantidad, usr.uid as uid, usr.user_id as user_id, device.platform as platform, application.site_id as site, 
  jest(event_data,'items[0].item.category_path[0]') as l1,
  jest(event_data,'items[0].item.category_path[1]') as l2
  FROM TRACKS 
  WHERE
  path = '/checkout/congrats'
  AND application.site_id IN ('MCO', 'MLA', 'MLB', 'MLC', 'MLM', 'MLU', 'MLV')
  AND ds >= '@param01'
  AND ds < '@param02'
  GROUP BY jest(event_data, 'shipping[0].shipping_option.name'), substr(ds,1,10), jest(event_data, 'shipping[0].shipping_option.shipping_method_id'), jest(event_data, 'items[0].item.id'), usr.uid, usr.user_id, device.platform, application.site_id, jest(event_data,'items[0].item.category_path[0]'), jest(event_data,'items[0].item.category_path[1]')
) AS congrats
ON vips.item_id = congrats.item_id and vips.fecha = congrats.fecha and vips.uid = congrats.uid and vips.platform = congrats.platform