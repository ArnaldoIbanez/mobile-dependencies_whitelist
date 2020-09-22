SELECT
  COUNT(1)          AS total,
  r.site_id         AS site,
  r.item_reputation AS reputation,
  t.ds              AS ds
FROM (
  SELECT
    item_id AS item_id,
    ds      AS ds
  FROM (
    SELECT
      DISTINCT(id) AS track_id,
      ds           AS ds,
      SPLIT(SUBSTRING_INDEX(REGEXP_REPLACE(event_data.results, '\"+|\\[|\\]$', ""), ',', 5), ',') AS top_5_items
    FROM
      default.tracks
    LATERAL VIEW JSON_TUPLE(event_data, 'results', 'query', 'offset') event_data AS results, query, off
    WHERE
      ds >= '@param01 00'
      AND ds < '@param02 00'
      AND application.business = 'mercadolibre'
      AND path = '/search'
      AND type = 'view'
      AND TRIM(event_data.query) != ''
      AND off = 0
      AND NOT IS_BOT(device.user_agent)
  ) tracks
  LATERAL VIEW EXPLODE(tracks.top_5_items) top_5_items as item_id
  WHERE
    item_id IS NOT NULL 
    AND LENGTH(item_id) > 0
) t
  JOIN (
    SELECT
      CONCAT(site_id,item_id) AS item_id,
      site_id                 AS site_id,
      item_reputation         AS item_reputation
    FROM
      external_data ed
      LATERAL VIEW JSON_TUPLE(ed.data, 'item_id', 'site_id', 'reputation') ext_data AS item_id, site_id, item_reputation
    WHERE
      usr = 'searchdatainfra'
      AND tb = 'items_reputation'
  ) r ON (
  r.item_id = t.item_id
)
GROUP BY 
  r.site_id, r.item_reputation, t.ds
