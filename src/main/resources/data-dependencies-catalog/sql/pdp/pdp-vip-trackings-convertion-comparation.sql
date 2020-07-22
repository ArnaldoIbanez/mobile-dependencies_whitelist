SELECT
site as site,
pdp_and_vips.domain as domain,
platform as platform,
view as view,
condition,
'todo' as reputation_level,
'todo' as loyalty_level,
count(distinct CONCAT(pdp_and_vips.uid, pdp_and_vips.product_or_item)) as total_users,
count(distinct if(orders_pdp_and_vip.uid is not null,CONCAT(orders_pdp_and_vip.uid, pdp_and_vips.product_or_item),null)) as orders,
count(distinct if(view_has_carrito = 'true' , CONCAT(pdp_and_vips.uid, pdp_and_vips.product_or_item),null)) as total_users_carrito,
count(distinct if(orders_pdp_and_vip.uid is not null and orders_carrito = 'true' , CONCAT(orders_pdp_and_vip.uid, pdp_and_vips.product_or_item),null)) as orders_carrito,
cast(pdp_and_vips.ds as date) as ds
FROM
  ( select usr.uid uid, 
 substr(ds,1,10) as ds, 
 application.site_id site, 
 device.platform platform,
 if(path='/pdp', get_json_object(event_data,'$.catalog_product_id'),  get_json_object(event_data,'$.item_id') ) as product_or_item,
 get_json_object(event_data,'$.domain_id') as domain,
 if(path='/pdp', 'PDP', 'VIP') as view,
 'new' as condition,
  CASE 
    when (get_json_object(event_data,'$.cart_content') = '1' or  get_json_object(event_data,'$.cart_content') = 'true') then 'true'
    else 'false' 
  END as view_has_carrito
from melidata.tracks_ml
where 
ds >= '@param01' AND ds < '@param02'
and site in ('MLA','MLB','MLM')
AND NOT is_bot(device.user_agent)
and ((path = '/pdp') or (path = '/vip' and get_json_object(event_data, '$.item_condition') = 'new' and get_json_object(event_data, '$.vertical') = 'core'  ))
and substr(get_json_object(event_data,'$.domain_id'),1,3)  = site
and bu = 'mercadolibre'
) as pdp_and_vips
left JOIN (
  select usr.uid as uid,
  substr(ds,1,10) as ds,
  if(get_json_object(event_data, '$.is_pdp') = 'true', get_json_object(event_data, '$.items[0].item.catalog_product_id'),  get_json_object(event_data, '$.items[0].item.id')) as product_or_item,
  get_json_object(event_data, '$.is_carrito') as orders_carrito
  FROM melidata.tracks_ml
  WHERE  
    ds >= '@param01' AND ds < '@param02'
    and site in ('MLA','MLB','MLM')              
    and path = '/orders/ordercreated'
    and bu = 'mercadolibre'
  group by usr.uid,  substr(ds,1,10), get_json_object(event_data, '$.is_carrito'), if(get_json_object(event_data, '$.is_pdp') = 'true',get_json_object(event_data, '$.items[0].item.catalog_product_id'),  get_json_object(event_data, '$.items[0].item.id'))) AS orders_pdp_and_vip
 on pdp_and_vips.uid = orders_pdp_and_vip.uid and pdp_and_vips.ds = orders_pdp_and_vip.ds and pdp_and_vips.product_or_item = orders_pdp_and_vip.product_or_item
group by cast(pdp_and_vips.ds as date), site, pdp_and_vips.domain, platform, view, condition
