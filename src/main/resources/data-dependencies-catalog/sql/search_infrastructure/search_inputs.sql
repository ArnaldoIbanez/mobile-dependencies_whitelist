SELECT
  r.site_id         AS site,
  r.item_reputation AS reputation,
  t.item_position   AS top_position,
  t.ds              AS ds
FROM (
  SELECT
    ROW_NUMBER() OVER (PARTITION BY track_id) AS item_position,
    item_id                                   AS item_id,
    ds                                        AS ds
  FROM (
    SELECT
      DISTINCT(id) AS track_id,
      ds           AS ds,
      SPLIT(substring_index(regexp_replace(event_data.results, '\"+|\\[|\\]$', ""), ',', 5), ',') AS top_5_items
    FROM
      default.tracks
      LATERAL VIEW JSON_TUPLE(event_data, 'results', 'query') event_data AS results, query
    WHERE
      ds >= '@param01 00'
      AND ds < '@param02 00'
      AND application.business = 'mercadolibre'
      AND path = '/search'
      AND type = 'view'
      AND trim(event_data.query) != ''
      AND NOT is_bot(device.user_agent)
  ) tracks
    LATERAL VIEW explode(tracks.top_5_items) top_5_items as item_id
) t
  LEFT JOIN (
    SELECT
      CONCAT(site_id,item_id) AS item_id,
      site_id                 AS site_id,
      item_reputation         AS item_reputation
    FROM
      external_data ed
      LATERAL VIEW JSON_TUPLE(ed.data, 'item_id', 'site_id', 'reputation') ext_data AS item_id, site_id, item_reputation
    WHERE
      usr='searchdatainfra'
      AND tb='items_reputation'
  ) r ON (
    r.item_id = t.item_id
  )