SELECT c.platform, c.site, c.is_carrito, sum(c.bt_orders) as bt_orders_presence, sum(c.entities) as entities_presence, sum(c.checkouts)as checkouts_presence, count(DISTINCT c.entity_id) as total_entities, c.track_date FROM(
SELECT b.entity_id, b.platform, b.site, b.is_carrito, sum(IF(bt_orders >= 1, 1, 0)) bt_orders, sum(IF(orders >= 1, 1, 0)) entities, sum(IF(checkouts >= 1, 1, 0)) checkouts, track_date FROM (
  SELECT entity_id, platform, site, is_carrito, sum(if(source = 'bt_order', 1, 0)) as bt_orders, sum(if(source = 'entity', 1, 0)) as orders, sum(if(source = 'checkout', 1, 0)) as checkouts, track_date FROM (
    SELECT if(get_json_object(event_data, '$.order_id') IS NULL, get_json_object(event_data, '$.purchase_id'), get_json_object(event_data, '$.order_id')) as entity_id,
          CASE path
               WHEN '/checkout/congrats' THEN 'checkout'
               ELSE 'entity'
           END as source,
          CASE device.platform
               WHEN '/mobile/android' THEN 'android'
               WHEN '/mobile/ios' THEN 'ios'
               ELSE 'web'
           END as platform,
           CASE path
             WHEN '/purchases/purchasecreated' THEN 'true'
             ELSE 'false'
             END as is_carrito,
    application.site_id as site, substr(ds,1,10) as track_date FROM tracks
    WHERE ds >= '@param01'
      AND ds < '@param02'
    AND
    (
      (
        path = '/checkout/congrats'
        AND get_json_object(event_data, '$.order_id') IS NOT NULL
        AND get_json_object(event_data, '$.congrats_seq') = '1'
      )
    OR
      (
        path = '/orders/ordercreated'
        AND get_json_object(event_data, '$.is_carrito') = 'false'
        AND get_json_object(event_data, '$.order_id') IS NOT NULL
      )
    OR
      (
        path = '/purchases/purchasecreated'
        AND get_json_object(event_data, '$.purchase_id') IS NOT NULL
      )
    )
    AND array_contains(array('/mobile/android', '/mobile/ios', '/web/mobile', '/web/desktop'), device.platform)
    GROUP BY if(get_json_object(event_data, '$.order_id') IS NULL, get_json_object(event_data, '$.purchase_id'), get_json_object(event_data, '$.order_id')),
          CASE path
               WHEN '/checkout/congrats' THEN 'checkout'
               ELSE 'entity'
           END,
          CASE device.platform
               WHEN '/mobile/android' THEN 'android'
               WHEN '/mobile/ios' THEN 'ios'
               ELSE 'web'
           END,
           CASE path
             WHEN '/purchases/purchasecreated' THEN 'true'
             ELSE 'false'
             END,
    application.site_id, substr(ds,1,10)
    UNION ALL
    select DISTINCT(CAST(ord_order_id as string)) as entity_id, 'bt_order' as source, CASE ORD_APP_ID
               WHEN 7092 THEN 'android'
               WHEN 1505 THEN 'ios'
               ELSE 'web'
           END as platform,
           'false' as is_carrito,
           sit_site_id as site,
           '@param01' as track_date
      from melilake.bt_odr_purchase_orders o
      where substring(from_unixtime(unix_timestamp(o.ord_created_dt, 'MMM dd, yyyy')),1,10) = '@param01'
      AND pck_pack_id IS NULL
    UNION ALL
    SELECT DISTINCT(get_json_object(event_data, '$.purchase_id')) as entity_id, 'checkout' as source, CASE device.platform
               WHEN '/mobile/android' THEN 'android'
               WHEN '/mobile/ios' THEN 'ios'
               ELSE 'web'
           END as platform,
          'true' as is_carrito,
    application.site_id as site, substr(ds,1,10) as track_date FROM tracks
      WHERE ds >= '@param01'
      AND ds < '@param02'
      AND path = '/cart/checkout/congrats'
      AND get_json_object(event_data, '$.congrats_seq') = '1'
      AND get_json_object(event_data, '$.purchase_id') IS NOT NULL
  ) a
  GROUP BY entity_id, platform, site, is_carrito, track_date
) b
GROUP BY entity_id, platform, site, is_carrito, track_date) c
GROUP BY platform, site, is_carrito, track_date
