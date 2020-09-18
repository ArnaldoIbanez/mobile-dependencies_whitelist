SELECT
sub_prints.client_id as client_id,
sub_prints.platform as platform,
sub_prints.count_prints as prints,
NVL(sub_clicks.count_clicks, 0) as clicks,
sub_prints.ds as track_date
FROM 
( SELECT prints.ds as ds, prints.platform, prints.client_id, count(prints.client_id) as count_prints
  FROM 
  (
    SELECT
      jest(event_data, 'client_id') as client_id,
      device.platform,
      substr(ds, 1, 10) AS ds
    FROM
       tracks
    WHERE
      ds >= '@param01' 
      AND ds < '@param02'
      AND path like '/supermarket/%'
  ) as prints
  GROUP BY prints.ds, prints.platform, prints.client_id
) as sub_prints
LEFT JOIN
( SELECT clicks.ds as ds, clicks.platform, clicks.client_id, count(clicks.client_id) as count_clicks
  FROM
  (
    SELECT
      jest(COALESCE(platform.fragment, others['fragment']), 'from') as client_id,
      device.platform as platform,
      substr(ds, 1, 10) AS ds
    FROM
       tracks
    WHERE
      ds >= '@param01' 
      AND ds < '@param02'
      AND path like '/search'
      AND jest(COALESCE(platform.fragment, others['fragment']), 'origin') like 'supermarket_navigation'
      AND jest(COALESCE(platform.fragment, others['fragment']), 'from') is not null
  ) as clicks
  GROUP BY clicks.ds, clicks.platform, clicks.client_id
) as sub_clicks
ON sub_prints.client_id = sub_clicks.client_id AND sub_prints.platform = sub_clicks.platform