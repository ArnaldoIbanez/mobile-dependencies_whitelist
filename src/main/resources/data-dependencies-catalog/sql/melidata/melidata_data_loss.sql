SELECT platform, site, is_carrito, sum(if(is_carrito = 'false', bt_orders, 0)) as bt_orders_presence, sum(if(is_carrito = 'false', orders, bt_orders)) as entities_presence, sum(checkouts) as checkouts_presence, sum(if(is_carrito = 'false', orders, bt_orders)) as total_entities, date_created as track_date from 
(select entity_id, 1 as bt_orders, site, platform, is_carrito, SUM(IF(path = '/orders/ordercreated' or path = '/purchases/purchasecreated',1,0)) as orders, SUM(IF(path = '/checkout/congrats' or path = '/cart/checkout/congrats',1,0)) as checkouts,date_created
from (
  (select distinct(CAST(o.ord_order_id as string)) as entity_id, CAST(o.ord_created_dt as string) as date_created, o.sit_site_id as site, t.path as path, CASE ORD_APP_ID
               WHEN '7092' THEN 'android'
               WHEN '1505' THEN 'ios'
               ELSE 'web'
           END as platform,
  'false' as is_carrito
  from melilake.bt_odr_purchase_orders o
  left join (
    select distinct get_json_object(event_data, '$.order_id') as entity_id, path
      from melidata.tracks_ml where ds >= '2020-07-11'
        and ds < '2020-07-12'
        and (path='/orders/ordercreated' or path = '/checkout/congrats')
  ) t on (cast(o.ord_order_id as string) = t.entity_id )
  where cast(o.ord_created_dt as string) = '2020-07-11'
  AND pck_pack_id IS NULL)
  UNION ALL
  (select distinct get_json_object(event_data, '$.purchase_id') as entity_id, substr(ds,1,10) as date_created, application.site_id as site, tc.path, device.platform, 'true' as is_carrito
      from melidata.tracks_ml oc
  left join (
    select distinct jest(event_data, 'purchase_id') as entity_id, path
      from melidata.tracks_ml where ds >= '2020-07-11'
        and ds < '2020-07-12'
        and path = '/cart/checkout/congrats'
  ) tc on (get_json_object(oc.event_data, '$.order_id') = tc.entity_id)
  where ds >= '2020-07-11'
  and ds < '2020-07-12'
  and oc.path='/purchases/purchasecreated' )
) a
group by entity_id, site, platform, date_created, is_carrito) b
GROUP BY site, platform, date_created, is_carrito
