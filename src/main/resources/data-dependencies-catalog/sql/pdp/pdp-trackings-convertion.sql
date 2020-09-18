SELECT
      site, platform,
      SUM(IF(pdp > 0, 1, 0))         AS total_pdp,
      SUM(IF(pdp_cart > 0, 1, 0))    AS total_pdp_cart,
      SUM(IF(a2c_actions > 0, 1, 0)) AS total_a2c_actions,
      SUM(IF(buy_actions > 0, 1, 0)) AS total_buy_actions,
      SUM(IF(orders > 0, 1, 0))      AS total_orders,
      SUM(IF(orders_cart > 0, 1, 0)) AS total_orders_cart,
      cast(ds as date) AS ds
FROM (
      SELECT
            ds, site, platform, CONCAT(uid, product_id) AS UniqueKey,
            SUM(IF(pathName = '/pdp', 1, 0)) AS pdp,
            SUM(IF(pathName = '/pdp' AND cart_flag = 'true', 1, 0)) AS pdp_cart,
            SUM(IF(pathName IN ('/pdp/add_to_cart_action',
                            '/pdp/sellers/add_to_cart_action',
                            '/pdp/alternative_buying_options/add_to_cart_action'),
                             1, 0)) AS a2c_actions,
            SUM(IF(pathName IN ('/pdp/buy_action',
                            '/pdp/sellers/buy_action',
                            '/pdp/alternative_buying_options/buy_action'),
                            1, 0)) AS buy_actions,
            SUM(IF(pathName = '/orders/ordercreated' AND cart_flag = 'false', 1, 0)) AS orders,
            SUM(IF(pathName = '/orders/ordercreated' AND cart_flag = 'true', 1, 0)) AS orders_cart
      FROM (
            SELECT
            substr(ds,1,10)     AS ds,
            application.site_id AS site,
            device.platform     AS platform,
            usr.uid             AS uid,
            COALESCE(jest(event_data,'catalog_product_id'),jest(event_data,'items[0].item.catalog_product_id')) AS product_id,
            COALESCE(jest(event_data,'cart_content'),jest(event_data,'is_carrito')) AS cart_flag,
            path                AS pathName
            FROM tracks
            WHERE ds >= '@param01' AND ds < '@param02'
                  AND application.site_id in ('MLB','MLA','MLM')
                  AND device.platform in ('/web/desktop','/web/mobile','/mobile/android','/mobile/ios')
                  AND usr.uid IS NOT NULL
                  AND NOT is_bot(device.user_agent)
                  AND COALESCE(jest(event_data,'catalog_product_id'),jest(event_data,'items[0].item.catalog_product_id')) IS NOT NULL
                  AND (
                       path in ('/pdp', '/pdp/add_to_cart_action', '/pdp/buy_action','/pdp/sellers/add_to_cart_action','/pdp/sellers/buy_action', '/pdp/alternative_buying_options/add_to_cart_action', '/pdp/alternative_buying_options/buy_action')
                    OR (path = '/orders/ordercreated' AND jest(event_data,'is_pdp') = 'true')
                      )
           ) temp0
      GROUP BY ds, site, platform, CONCAT(uid, product_id)
     ) temp1
GROUP BY cast(ds as date), site, platform