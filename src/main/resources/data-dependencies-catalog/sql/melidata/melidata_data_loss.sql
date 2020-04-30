SELECT b.order_id, b.platform, b.site, sum(IF(bt_orders >= 1, 1, 0)) bt_orders, sum(IF(orders >= 1, 1, 0)) orders, sum(IF(checkouts >= 1, 1, 0)) checkouts, track_date FROM (
  SELECT order_id, platform, site, sum(if(source = 'bt_order', 1, 0)) as bt_orders, sum(if(source = 'order', 1, 0)) as orders, sum(if(source = 'checkout', 1, 0)) as checkouts, track_date FROM (
    SELECT jest(event_data, 'order_id') as order_id,
          CASE path
               WHEN '/checkout/congrats' THEN 'checkout'
               ELSE 'order'
           END as source,
          CASE device.platform
               WHEN '/mobile/android' THEN 'android'
               WHEN '/mobile/ios' THEN 'ios'
               ELSE 'web'
           END as platform
    , application.site_id as site,
     substr(ds,1,10) as track_date FROM tracks
    WHERE ds >= '@param01'
    AND ds < '@param02'
    AND
    (
      (
        path = '/checkout/congrats'
        AND jest(event_data, 'congrats_seq') = '1'
      )
    OR
      (
        path = '/orders/ordercreated'
        AND jest(event_data, 'is_carrito') = 'false'
      )
    )
    AND jest(event_data, 'order_id') IS NOT NULL
    AND array_contains(array('/mobile/android', '/mobile/ios', '/web/mobile', '/web/desktop'), device.platform)
    GROUP BY jest(event_data, 'order_id'), path,
          CASE device.platform
               WHEN '/mobile/android' THEN 'android'
               WHEN '/mobile/ios' THEN 'ios'
               ELSE 'web'
           END
    , application.site_id, substr(ds,1,10)
    UNION ALL
    select DISTINCT(CAST(ord_order_id as string)), 'bt_order' as source, CASE ORD_APP_ID
               WHEN 7092 THEN 'android'
               WHEN 1505 THEN 'ios'
               ELSE 'web'
           END as platform,
           sit_site_id as site,
           '@param01' as track_date
      from melilake.bt_odr_purchase_orders o
      where substring(from_unixtime(unix_timestamp(o.ord_created_dt, 'MMM dd, yyyy')),1,10) = '@param01'
      AND pck_pack_id IS NULL
  ) a
  GROUP BY order_id, platform, site, track_date
) b
GROUP BY order_id, platform, site, track_date