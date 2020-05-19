select total.site_id_pds, 
       total.platform_pds, 
count(distinct concat(uid_pds,product_id_pds)) as total_pdp,
count(distinct if(cart_content_pds = 'true',concat(uid_pds,product_id_pds), null)) as total_pdp_cart,
count(distinct if(path_actions_orders in (
    '/pdp/add_to_cart_action', 
    '/pdp/sellers/add_to_cart_action',
    '/pdp/alternative_buying_options/add_to_cart_action'), 
        concat(uid_pds,product_id_pds), 
        null)) as total_a2c_actions,
count(distinct if(path_actions_orders in ( 
    '/pdp/buy_action',
    '/pdp/sellers/buy_action', 
    '/pdp/alternative_buying_options/buy_action'), 
      concat(uid_pds,product_id_pds), 
      null)) as total_buy_actions,
count(distinct if(path_actions_orders = '/orders/ordercreated' and is_carrito = 'false', concat(uid_pds,product_id_pds), null)) as total_orders,
count(distinct if(path_actions_orders = '/orders/ordercreated' and is_carrito = 'true', concat(uid_pds,product_id_pds), null)) as total_orders_cart,
cast(total.ds_pds as date) as ds

from
(
select
     product_id_pds,
     uid_pds,
     site_id_pds, 
     platform_pds,
     path_pds,
     cart_content_pds,
     ds_pds,
     path_actions_orders,
     is_carrito
from 
(
  select 
  usr.uid as uid_pds, 
  jest(event_data,'catalog_product_id') as product_id_pds, 
  application.site_id as site_id_pds,
  substr(ds,1,10) as ds_pds,
  device.platform as platform_pds,
  jest(event_data,'cart_content') as cart_content_pds,
  path as path_pds 
  from tracks
  where ds >= '@param01' AND ds < '@param02'
        AND device.platform in ('/web/desktop','/web/mobile','/mobile/android','/mobile/ios')
        AND NOT is_bot(device.user_agent)
        AND usr.uid IS NOT NULL
        AND application.site_id in ('MLB','MLA','MLM')
        and  path = '/pdp'
        --AND bu = 'mercadolibre'
        --AND site in ('MLB','MLA','MLM')
        AND jest(event_data,'catalog_product_id') IS NOT NULL
  group by usr.uid , jest(event_data,'catalog_product_id'), application.site_id, substr(ds,1,10), device.platform, jest(event_data,'cart_content'), path
) pdps
left join
(
  select usr.uid as uid_actions_orders, 
  if(jest(event_data,'catalog_product_id') is not null, jest(event_data,'catalog_product_id'), jest(event_data,'items[0].item.catalog_product_id')) as product_id_actions_orders, 
  substr(ds,1,10) as ds_actions_orders,
  path as path_actions_orders,
  jest(event_data,'is_carrito') as is_carrito
  from tracks
  where ds >= '@param01' AND ds < '@param02'
        AND device.platform in ('/web/desktop','/web/mobile','/mobile/android','/mobile/ios')
        AND NOT is_bot(device.user_agent)
        AND usr.uid IS NOT NULL
        AND application.site_id in ('MLB','MLA','MLM')
        AND (jest(event_data,'catalog_product_id') IS NOT NULL or jest(event_data,'items[0].item.catalog_product_id') is not null)
        AND (
            (path in ('/pdp/add_to_cart_action', '/pdp/buy_action','/pdp/sellers/add_to_cart_action','/pdp/sellers/buy_action', '/pdp/alternative_buying_options/add_to_cart_action', '/pdp/alternative_buying_options/buy_action'))
          OR  (path = '/orders/ordercreated' and jest(event_data,'is_pdp') = 'true')
      )   
) actions_orders
on ds_actions_orders = ds_pds and uid_actions_orders = uid_pds and product_id_actions_orders = product_id_pds
) total

group by  total.site_id_pds, 
       total.platform_pds, 
       cast(total.ds_pds as date)