SELECT date_created,
       platform,
       site,
       SUM(counter) AS totales_segun_feed,
       SUM(faltantes) AS faltantes_en_tracking_checkout
FROM (SELECT date_created as date_created,
             site as site,
             platform as platform,
             SUM( case when checkouts_order_id IS NULL then 1 else 0 end) AS faltantes,
             COUNT(1) AS counter
      FROM (SELECT DISTINCT jest(event_data,'order_id') AS order_id,
                   application.site_id AS site,
                   substr(ds,1,10) AS date_created,
                   device.platform AS platform,
                   checkouts.order_id AS checkouts_order_id
            FROM tracks t
              LEFT JOIN (SELECT DISTINCT jest(event_data,'order_id') AS order_id
                         FROM tracks
                         WHERE ds >= '@param01'
                         AND   ds < '@param02'
                         AND   path LIKE '/checkout%'
                         ) checkouts ON (CAST (jest (event_data,'order_id') AS DOUBLE) = CAST (checkouts.order_id AS DOUBLE))
            WHERE ds >= '@param01'
            AND   ds < '@param02'
            AND   t.path = '/orders/ordercreated'
            AND   jest (event_data,'is_carrito') = 'false') a
      GROUP BY a.site,
               a.platform,
               date_created) joined
GROUP BY site,
         platform,
         date_created
