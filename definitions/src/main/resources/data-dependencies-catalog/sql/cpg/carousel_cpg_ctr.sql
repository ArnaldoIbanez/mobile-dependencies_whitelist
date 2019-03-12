SELECT
sub_prints.platform as platform,
sub_prints.count_prints as prints,
NVL(sub_clicks.count_clicks, 0) as clicks,
sub_prints.ds as track_date
FROM 
( SELECT prints.ds as ds, prints.platform, count(CASE WHEN show_supermarket_carousel like 'true' THEN 1 END) as count_prints
  FROM 
  (
    SELECT
      jest(event_data, 'show_supermarket_carousel') as show_supermarket_carousel,
      device.platform,
      substr(ds, 1, 10) AS ds
    FROM
       tracks
    WHERE
      ds >= '@param01' 
      AND ds < '@param02'
      AND path like '/search'
  ) as prints
  GROUP BY prints.ds, prints.platform
) as sub_prints
LEFT JOIN
( SELECT clicks.ds as ds, clicks.platform, count(*) as count_clicks
  FROM
  (
    SELECT
      device.platform as platform,
      substr(ds, 1, 10) AS ds
    FROM
       tracks
    WHERE
      ds >= '@param01' 
      AND ds < '@param02'
      AND path like '/search'
      AND jest(others['fragment'], 'origin') like 'supermarket_carousel_main_box'
  ) as clicks
  GROUP BY clicks.ds, clicks.platform
) as sub_clicks
ON sub_prints.platform = sub_clicks.platform and sub_prints.ds = sub_clicks.ds