SELECT 
  application.site_id as site_id,
  SUM (CASE WHEN ed.query IS NOT NULL THEN 1 ELSE 0 END) AS total_query,
  SUM (CASE WHEN ed.results = '[]' THEN 1 ELSE 0 END ) AS total_zrp,
  MAX (substr(ds,1,10)) AS ds
FROM default.tracks
LATERAL VIEW JSON_TUPLE(event_data, 'query', 'results', 'tracking_id') ed AS query, results, tracking_id
WHERE path = '/search' 
  AND type = 'view'
  AND ds >= '@param01 00'
  AND ds < '@param02 00'
  AND NOT is_bot(device.user_agent)
  AND ed.query IS NOT NULL
  AND ed.tracking_id IS NOT NULL
GROUP BY application.site_id