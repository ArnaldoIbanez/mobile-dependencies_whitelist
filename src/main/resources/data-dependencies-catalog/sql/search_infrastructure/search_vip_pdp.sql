SELECT  
d.site_id AS site_id,
d.platform AS platform,
COUNT(d.tracking_id) AS search_total,
SUM(d.clicks) AS click_total,
SUM(d.total_query_track) AS total_query,
SUM(d.total_zrp_track) AS total_zrp,
FROM_UNIXTIME(d.search_ts, 'yyyy-MM-dd') AS ds
FROM (
  SELECT 
    s.site_id AS site_id,
    s.platform AS platform,
    s.tracking_id AS tracking_id,
    COUNT(vp.item_id) AS clicks,
    MAX(s.total_query_track) AS total_query_track,
    MAX(s.total_zrp_track) AS total_zrp_track,
    MAX(s.search_ts) AS search_ts
  FROM
  (
    SELECT
      s.site_id AS site_id,
      s.platform AS platform,
      s.tracking_id AS tracking_id,
      MAX(s.search_ts) AS search_ts,
      SUM(CASE WHEN s.query IS NOT NULL AND s.path = '/search' THEN 1 ELSE 0 END) AS total_query_track,
      SUM(CASE WHEN s.results = '[]' AND s.path = '/search' THEN 1 ELSE 0 END ) AS total_zrp_track
    FROM 
    (
      SELECT
        application.site_id AS site_id,
        device.platform AS platform,
        ed.tracking_id AS tracking_id,
        UNIX_TIMESTAMP(REGEXP_REPLACE(user_timestamp, '(T|-\\d+$)', ' '), 'yyyy-MM-dd HH:mm:ss.SSS') AS search_ts,
        SUBSTRING_INDEX(REGEXP_REPLACE(ed.category_path, '[\\[\\]]', ''), ',', 1) AS categ_id,
        ed.query AS query ,
        ed.results AS results,
        path
      FROM default.tracks
      LATERAL VIEW JSON_TUPLE(event_data, 'tracking_id', 'category_path', 'query', 'results') ed AS tracking_id, category_path, query, results
      WHERE 
        ds >= '@param01 00'
        AND ds < '@param02 00'
        AND type = 'view'
        AND NOT is_bot(device.user_agent)
        AND ed.tracking_id IS NOT NULL
        ) s 
        LEFT JOIN default.categories cat ON s.categ_id = cat.id
    WHERE cat.name NOT IN ('Autos, Motos y Otros', 'Carros, Motos e Outros', 'Carros, Motos y Otros', 'Imóveis', 'Inmuebles', 'Servicios', 'Serviços') OR cat.name IS NULL
    GROUP BY s.site_id, s.platform, s.tracking_id
  ) s LEFT JOIN (
    SELECT 
      vp.tracking_id AS tracking_id,
      vp.item_id AS item_id
    FROM
    (
      SELECT 
        get_json_object(platform.fragment, '$.tracking_id') AS tracking_id,
        CASE WHEN path = '/vip' THEN ed.item_id ELSE ed.catalog_product_id END AS item_id
      FROM default.tracks
      LATERAL VIEW JSON_TUPLE(event_data, 'item_id', 'catalog_product_id') ed AS item_id, catalog_product_id
      WHERE 
        ds >= '@param01 00'
        AND ds < '@param02 00'
        AND path IN ('/vip', '/pdp')
    ) vp
    WHERE vp.tracking_id IS NOT NULL
    GROUP BY vp.tracking_id, vp.item_id
  ) vp ON s.tracking_id = vp.tracking_id
  GROUP BY  s.site_id, s.platform, s.tracking_id
)d GROUP BY d.site_id, FROM_UNIXTIME(d.search_ts, 'yyyy-MM-dd'), d.platform