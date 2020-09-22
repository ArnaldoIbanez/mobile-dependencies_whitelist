SELECT 
  s.site_id,
  COUNT(s.tracking_id) AS search_total,
  SUM(s.click_total) AS click_total,
  SUM(s.is_zrp) AS zrp_total,
  FROM_UNIXTIME(s.search_ts, 'yyyy-MM-dd') AS time
FROM (
  SELECT 
    s.site_id AS site_id,
    s.tracking_id AS tracking_id,
    SUM(CASE WHEN s.item_id IS NOT NULL AND LENGTH(s.item_id) > 0 THEN 1 ELSE 0 END) AS click_total,
    MAX(CASE WHEN s.item_id IS NULL OR LENGTH(s.item_id) = 0 THEN s.is_zrp ELSE 0 END) AS is_zrp,
    MAX(s.search_ts) AS search_ts
  FROM
  (
    SELECT 
      s.site_id AS site_id,
      s.tracking_id AS tracking_id,
      r.item_id AS item_id,
      s.is_zrp AS is_zrp,
      s.search_ts AS search_ts
    FROM (
      SELECT
        s.site_id AS site_id,
        s.tracking_id AS tracking_id,
        MAX(s.top_5_items) AS top_5_items,
        MAX(s.is_zrp) AS is_zrp,
        MAX(s.search_ts) AS search_ts
      FROM 
      (
        SELECT
          application.site_id AS site_id,
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
      GROUP BY s.site_id, s.tracking_id
    ) s
    LATERAL VIEW EXPLODE(s.top_5_items) r AS item_id
  ) s LEFT JOIN (
    SELECT 
      vp.tracking_id AS tracking_id,
      vp.item_id AS item_id
    FROM
    (
      SELECT 
        get_json_object(platform.fragment, '$.tracking_id') AS tracking_id,
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
  GROUP BY s.site_id, s.tracking_id
) s
GROUP BY FROM_UNIXTIME(s.search_ts, 'yyyy-MM-dd'), s.site_id