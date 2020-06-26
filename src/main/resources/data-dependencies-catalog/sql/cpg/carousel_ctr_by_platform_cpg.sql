SELECT
    prints.platform AS platform,
    prints.prints AS prints,
    clicks.clicks AS clicks,
    prints.track_date AS track_date
FROM 
(
  SELECT
      device.platform AS platform,
      substr(ds, 1, 10) AS track_date,
      count(*) AS prints
  FROM melidata.tracks_ml
  WHERE path = '/search'
      AND ds >= '@param01' 
      AND ds < '@param02'
      AND bu = 'mercadolibre'
      AND jest(event_data, 'show_supermarket_carousel') = 'true'
  GROUP BY
      device.platform,
      substr(ds, 1, 10)
) AS prints
LEFT JOIN
(
  SELECT
    search_u_vip_clicks.platform AS platform,
    search_u_vip_clicks.track_date as track_date,
    SUM(search_u_vip_clicks.clicks) as clicks
  FROM (
    SELECT
      device.platform AS platform,
      substr(ds, 1, 10) AS track_date,
      count(*) AS clicks
    FROM melidata.tracks_ml
    WHERE 
      (path = '/search' or path = '/vip') 
     AND ds >= '@param01' 
      AND ds < '@param02'
      AND bu = 'mercadolibre'
      AND jest(COALESCE(platform.fragment, others['fragment']), 'origin') RLIKE 'supermarket_carousel.*'
    GROUP BY
      device.platform,
      substr(ds, 1, 10)
  ) search_u_vip_clicks
  GROUP BY
    search_u_vip_clicks.platform,
    search_u_vip_clicks.track_date
) AS clicks
ON 
  prints.platform = clicks.platform
  AND prints.track_date = clicks.track_date