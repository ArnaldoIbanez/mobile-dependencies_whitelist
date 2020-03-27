SELECT 
  s.site_id AS site_id,
  s.platform AS platform,
  COUNT(DISTINCT s.tracking_id) AS search_total,
  COUNT(DISTINCT co.checkout_id) AS checkout_total,
  FROM_UNIXTIME(s.search_ts, 'yyyy-MM-dd') AS ds
FROM (
  SELECT 
    site_id,
    platform,
    user_id,
    tracking_id,
    results,
    search_ts
  FROM (
    SELECT
      application.site_id AS site_id,
      device.platform AS platform,
      usr.user_id AS user_id,
      ed.tracking_id AS tracking_id,
      SPLIT(CONCAT('[', REGEXP_REPLACE(CONCAT_WS(',', REGEXP_REPLACE(ed.results, '[\\[\\]"]', ''), REGEXP_REPLACE(ed.shown_as_product, '[\\[\\]"]', '')), ',$', ''), ']'), '\\[|\\]|,') AS results,
      UNIX_TIMESTAMP(REGEXP_REPLACE(user_timestamp, '(T|-\\d+$)', ' '), 'yyyy-MM-dd HH:mm:ss.SSS') AS search_ts,
      SUBSTRING_INDEX(REGEXP_REPLACE(ed.category_path, '[\\[\\]]', ''), ',', 1) AS categ_id
    FROM default.tracks
    LATERAL VIEW JSON_TUPLE(event_data, 'tracking_id', 'results', 'shown_as_product', 'category_path') ed AS tracking_id, results, shown_as_product, category_path
    WHERE 
      path = '/search'
      AND type = 'view'
      AND ds >= '@param01 00'
      AND ds < '@param02 00'
      AND NOT is_bot(device.user_agent)
      AND ed.results <> '[]'
  ) s
  LEFT JOIN default.categories cat ON s.categ_id = cat.id
  WHERE cat.name NOT IN ('Autos, Motos y Otros', 'Carros, Motos e Outros', 'Carros, Motos y Otros', 'Imóveis', 'Inmuebles', 'Servicios', 'Serviços') OR cat.name IS NULL
) s
LEFT JOIN 
(
  SELECT
    co.site_id,
    co.platform,
    co.user_id,
    COALESCE(GET_JSON_OBJECT(i.item,'$.item.catalog_product_id'), GET_JSON_OBJECT(i.item,'$.item.id')) as item_id,
    co.checkout_ts AS checkout_ts,
    CONCAT(co.checkout_id, '-', i.index) AS checkout_id
  FROM
  (
    SELECT
      application.site_id AS site_id,
      device.platform AS platform,
      usr.user_id AS user_id,
      UNIX_TIMESTAMP(REGEXP_REPLACE(user_timestamp, '(T|-\\d+$)', ' '), 'yyyy-MM-dd HH:mm:ss.SSS') AS checkout_ts,
      SPLIT(ed.items, '((?=^)\\[)|(\\](?=$))|((?!\\})\\s*,\\s*(?=\\{))') AS items,
      CASE ed.checkout_flow 
        WHEN 'cart' THEN purchase_id
        ELSE ed.order_id
        END AS checkout_id
    FROM default.tracks
    LATERAL VIEW JSON_TUPLE(event_data, 'items', 'checkout_flow', 'order_id', 'purchase_id', 'congrats_seq') ed AS items, checkout_flow, order_id, purchase_id, congrats_seq
    WHERE
      path = '/checkout/congrats'
      AND type = 'view'
      AND ds >= '@param01 00'
      AND ds < '@param03 00'
      AND ed.congrats_seq = '1'
  ) AS co
  LATERAL VIEW POSEXPLODE(co.items) i AS index, item
  WHERE TRIM(item) <> ''
) co ON 
  s.site_id = co.site_id 
  AND s.platform = co.platform
  AND s.user_id = co.user_id
  AND ARRAY_CONTAINS(s.results, co.item_id)
  AND co.checkout_ts - s.search_ts BETWEEN 0 AND 3600*24
GROUP BY FROM_UNIXTIME(s.search_ts, 'yyyy-MM-dd'), s.site_id, s.platform