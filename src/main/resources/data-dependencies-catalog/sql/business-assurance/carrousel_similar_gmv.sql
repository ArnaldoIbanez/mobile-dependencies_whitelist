select 
  c.site_id as site_id, 
  c.backend_id as backend_id, 
  c.platform as platform, 
  count(*) as total_ventas, 
  sum(ammount_usd) as gmv, 
  substr(o.ds,1,10) as ds
from (
  select 
    device.platform as platform, 
    application.site_id as site_id, 
    jest(event_data, 'item_id') as item_id, 
    min(ds) as ds, 
    usr.user_id as user_id, 
    jest(event_data,'catalog_product_id') as catalog_product_id, 
    jest(platform.fragment, 'reco_backend') as backend_id
  FROM tracks 
  WHERE ds >= '@param02' and ds < '@param01'
  AND path = '/vip'
  AND application.site_id in ('MLA','MLB','MLM', 'MLC', 'MLU', 'MCO')
  AND jest(platform.fragment, 'reco_backend') in ('tagging-searchsimilar_fashion')
  GROUP BY device.platform, application.site_id, jest(event_data, 'item_id'), usr.user_id, jest(event_data,'catalog_product_id'), jest(platform.fragment, 'reco_backend')
) c
inner join (
  SELECT 
    cast(jest(event_data,'total_amount_usd') as double) as ammount_usd, 
    jest(event_data, 'items[0].item.id') as item_id, 
    ds, 
    usr.user_id as user_id, 
    jest(event_data,'items[0].item.catalog_product_id') as catalog_product_id, 
    jest(event_data,'order_id') as order_id
  FROM tracks
  WHERE ds >= '@param02' AND ds < '@param01'
    AND path = '/orders/ordercreated'
    AND application.site_id in ('MLA','MLB','MLM', 'MLC', 'MLU', 'MCO')
) o on o.item_id = c.item_id and c.ds <= o.ds and c.user_id = o.user_id
group by c.site_id, c.platform, c.backend_id, substr(o.ds,1,10);