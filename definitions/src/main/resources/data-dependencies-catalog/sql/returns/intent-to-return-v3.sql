SELECT
  fecha, platform, site_id, user_id, loyalty_level, is_cart_order, item_category, item_category_l1
FROM
  (
    SELECT
      fecha,
      platform,
      site site_id,
      user_id,
      MAX(loyalty_level) AS loyalty_level,
      MAX(cart_order)  AS is_cart_order,
      MAX(item_category) AS item_category,
      MAX(item_category_l1) AS item_category_l1,
      MAX(llega_a_claims) AS claims,
      MAX(apreto_el_boton) AS button
    FROM (
           SELECT
             SUBSTR(ds,1,10) AS fecha,
             1 AS llega_a_claims,
             0 AS apreto_el_boton,
             device.platform AS platform,
             application.site_id AS site,
             usr.user_id AS user_id,
             SUBSTR(jest(event_data, 'loyalty_level'),1,1) AS loyalty_level,
             jest(event_data, 'cart_order') AS cart_order,
             jest(event_data, 'item_category') AS item_category,
             jest(event_data, 'item_category_l1') AS item_category_l1
           FROM tracks t1
           WHERE ds >= '@param01'
                 AND ds < '@param02'
                 AND application.site_id IN ('MLM', 'MLB', 'MLA')
                 AND path IN ('/return/external', '/return/external/claims')
                 AND type = 'view'
           GROUP BY
             usr.user_id,
             SUBSTR(ds,1,10),
             application.site_id,
             device.platform,
             t1.event_data
           UNION ALL
           SELECT
             SUBSTR(ds,1,10) AS fecha,
             0 AS llega_a_claims,
             1 AS apreto_el_boton,
             device.platform AS platform,
             application.site_id AS site,
             usr.user_id AS user_id,
             '0' AS loyalty_level,
             'false' AS cart_order,
             '' AS item_category,
             '' AS item_category_l1
           FROM tracks t2
           WHERE ds >= '@param01'
                 AND ds < '@param02'
                 AND application.site_id IN ('MLM', 'MLB', 'MLA')
                 AND t2.path = '/return/typifications'
                 AND (jest(t2.event_data, 'typification') IN ('go_to_claim', 'gtc_other_problem', 'other_reaseon_gtc', 'other_reason_gtc') OR jest(t2.event_data, 'dictionary_data.typification') IN ('go_to_claim', 'gtc_other_problem', 'other_reaseon_gtc', 'other_reason_gtc'))

           GROUP BY
             usr.user_id,
             SUBSTR(ds,1,10),
             application.site_id,
             device.platform
         ) RS
    GROUP BY
      RS.user_id,
      RS.fecha,
      RS.platform,
      RS.site) RS2
WHERE
  claims - button > 0