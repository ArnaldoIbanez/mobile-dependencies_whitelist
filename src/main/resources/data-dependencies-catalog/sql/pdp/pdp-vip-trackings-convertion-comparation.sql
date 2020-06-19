SELECT 
site as site,
pdp_and_vips.domain as domain,
platform as platform,
view as view,
condition,
count(distinct CONCAT(pdp_and_vips.uid, pdp_and_vips.product_or_item)) as total_users,
count(distinct if(orders_pdp_and_vip.uid is not null,CONCAT(orders_pdp_and_vip.uid, pdp_and_vips.product_or_item),null)) as orders,
cast(pdp_and_vips.ds as date) as ds
FROM
  ( select usr.uid uid, 
 substr(ds,1,10) as ds, 
 application.site_id site, 
 device.platform platform,
 if(path='/pdp', jest(event_data,'catalog_product_id'),  jest(event_data,'item_id') ) as product_or_item,
 jest(event_data,'domain_id') as domain,
 if(path='/pdp', 'PDP', 'VIP') as view,
 'new' as condition
from tracks
where 
ds >= '@param01' AND ds < '@param02'
and application.site_id in ('MLA','MLB','MLM')
AND NOT is_bot(device.user_agent)
and ((path = '/pdp') or (path = '/vip' and jest(event_data, 'item_condition') = 'new' and jest(event_data, 'vertical') = 'core'  ))
and substr(jest(event_data,'domain_id'),1,3)  = application.site_id
) as pdp_and_vips
left JOIN (
  select usr.uid as uid,
  substr(ds,1,10) as ds,
  if(jest(event_data, 'is_pdp') = 'true', jest(event_data, 'items[0].item.catalog_product_id'),  jest(event_data, 'items[0].item.id')) as product_or_item
  FROM tracks
  WHERE  
     ds >= '@param01' AND ds < '@param02'
    and application.site_id in ('MLA','MLB','MLM')              
    and path = '/orders/ordercreated'
  group by usr.uid,  substr(ds,1,10), if(jest(event_data, 'is_pdp') = 'true', jest(event_data, 'items[0].item.catalog_product_id'),  jest(event_data, 'items[0].item.id'))) AS orders_pdp_and_vip 
 on pdp_and_vips.uid = orders_pdp_and_vip.uid and pdp_and_vips.ds = orders_pdp_and_vip.ds and pdp_and_vips.product_or_item = orders_pdp_and_vip.product_or_item
group by cast(pdp_and_vips.ds as date), site, pdp_and_vips.domain, platform, view, condition 