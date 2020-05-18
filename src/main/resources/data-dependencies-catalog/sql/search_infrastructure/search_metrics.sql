SELECT 
  s.site_id,
  COUNT(s.tracking_id) AS search_total,
  SUM(s.click_total) AS click_total,
  SUM(s.checkout_total) AS checkout_total,
  SUM(s.is_zrp) AS zrp_total,
  FROM_UNIXTIME(s.search_ts, 'yyyy-MM-dd') AS time
FROM (
  SELECT 
    s.site_id AS site_id,
    s.tracking_id AS tracking_id,
    SUM(CASE WHEN vp.item_id IS NOT NULL AND LENGTH(vp.item_id) > 0 THEN 1 ELSE 0 END) AS click_total,
    MAX(CASE WHEN s.item_id IS NULL OR LENGTH(s.item_id) = 0 THEN s.is_zrp ELSE 0 END) AS is_zrp,
    SUM(CASE WHEN co.checkout_id IS NOT NULL THEN 1 ELSE 0 END) AS checkout_total,
    MAX(s.search_ts) AS search_ts
  FROM
  (
    SELECT 
      s.site_id AS site_id,
      s.user_id AS user_id,
      s.tracking_id AS tracking_id,
      r.item_id AS item_id,
      s.is_zrp AS is_zrp,
      s.search_ts AS search_ts
    FROM (
      SELECT
        s.site_id AS site_id,
        s.user_id AS user_id,
        s.tracking_id AS tracking_id,
        MAX(s.top_5_items) AS top_5_items,
        MAX(s.is_zrp) AS is_zrp,
        MAX(s.search_ts) AS search_ts
      FROM 
      (
        SELECT
          application.site_id AS site_id,
          usr.user_id AS user_id,
          ed.tracking_id AS tracking_id,
          UNIX_TIMESTAMP(REGEXP_REPLACE(user_timestamp, '(T|-\\d+$)', ' '), 'yyyy-MM-dd HH:mm:ss.SSS') AS search_ts,
          SUBSTRING_INDEX(REGEXP_REPLACE(ed.category_path, '[\\[\\]]', ''), ',', 1) AS categ_id,
          SPLIT(substring_index(regexp_replace(ed.results, '\"+|\\[|\\]$', ""), ',', 5), ',') AS top_5_items,
          CASE WHEN ed.total = 0 THEN 1 ELSE 0 END AS is_zrp
        FROM default.tracks
        LATERAL VIEW JSON_TUPLE(event_data, 'results', 'tracking_id', 'category_path', 'offset', 'total') ed AS results, tracking_id, category_path, offst, total
        WHERE 
          ds >= '@param01 00'
          AND ds < '@param02 00'
          AND path = '/search'
          AND type = 'view'
          AND NOT is_bot(device.user_agent)
          AND ed.tracking_id IS NOT NULL
          AND ed.offst = 0
      ) s
      LEFT JOIN default.categories cat ON s.categ_id = cat.id
      WHERE (cat.name NOT IN ('Autos, Motos y Otros', 'Carros, Motos e Outros', 'Carros, Motos y Otros', 'Imóveis', 'Inmuebles', 'Servicios', 'Serviços') OR cat.name IS NULL)
      GROUP BY s.site_id, s.user_id, s.tracking_id
    ) s
    LATERAL VIEW EXPLODE(s.top_5_items) r AS item_id
  ) s 
  LEFT JOIN (
    SELECT 
      vp.tracking_id AS tracking_id,
      vp.item_id AS item_id
    FROM
    (
      SELECT 
        GET_JSON_OBJECT(platform.fragment, '$.tracking_id') AS tracking_id,
        ed.item_id AS item_id
      FROM default.tracks
      LATERAL VIEW JSON_TUPLE(event_data, 'item_id') ed AS item_id
      WHERE 
        ds >= '@param01 00'
        AND ds < '@param02 00'
        AND path IN ('/vip', '/pdp')
        AND ed.item_id IS NOT NULL
    ) vp
    WHERE vp.tracking_id IS NOT NULL
    GROUP BY vp.tracking_id, vp.item_id
  ) vp ON s.tracking_id = vp.tracking_id 
    AND s.item_id = vp.item_id
  LEFT JOIN (
    SELECT
      co.site_id,
      co.user_id,
      GET_JSON_OBJECT(i.item,'$.item.id') as item_id,
      co.checkout_ts AS checkout_ts,
      CONCAT(co.checkout_id, '-', i.index) AS checkout_id
    FROM
    (
      SELECT
        application.site_id AS site_id,
        usr.user_id AS user_id,
        UNIX_TIMESTAMP(REGEXP_REPLACE(user_timestamp, '(T|-\\d+$)', ' '), 'yyyy-MM-dd HH:mm:ss.SSS') AS checkout_ts,
        SPLIT(ed.items, '((?=^)\\[)|(\\](?=$))|((?!\\})\\s*,\\s*(?=\\{))') AS items,
        CASE ed.checkout_flow 
          WHEN 'cart' THEN purchase_id
          ELSE ed.order_id
          END AS checkout_id
      FROM default.tracks
      LATERAL VIEW JSON_TUPLE(event_data, 'items', 'checkout_flow', 'order_id', 'purchase_id', 'congrats_status', 'congrats_seq') ed AS items, checkout_flow, order_id, purchase_id, congrats_status, congrats_seq
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
    AND s.user_id = co.user_id
    AND s.item_id = co.item_id
    AND co.checkout_ts - s.search_ts BETWEEN 0 AND 3600*24
  GROUP BY s.site_id, s.tracking_id
) s
GROUP BY FROM_UNIXTIME(s.search_ts, 'yyyy-MM-dd'), s.site_id;

