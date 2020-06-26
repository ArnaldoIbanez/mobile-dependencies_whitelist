SELECT prints.query AS query,
    prints.platform AS platform,
    clicks.place AS place,
    prints.prints AS prints,
    clicks.clicks AS clicks,
    prints.track_date AS track_date
FROM 
(
  SELECT trim(jest(event_data, 'query')) AS query,
      device.platform AS platform,
      substr(ds, 1, 10) AS track_date,
      count(*) AS prints
  FROM tracks
  WHERE path LIKE '/search'
      AND ds >= '@param01'
      AND ds < '@param02'
      AND trim(jest(event_data, 'query')) IS NOT NULL
      AND trim(jest(event_data, 'query')) != ''
      AND jest(event_data, 'show_supermarket_carousel') = 'true'
  GROUP BY trim(jest(event_data, 'query')),
      device.platform,
      substr(ds, 1, 10)
) AS prints
LEFT JOIN
(
  SELECT
    search_u_vip_clicks.query AS query,
    search_u_vip_clicks.platform AS platform,
    search_u_vip_clicks.track_date as track_date,
    search_u_vip_clicks.place as place,
    SUM(search_u_vip_clicks.clicks) as clicks
  FROM (
    SELECT
      trim(jest(event_data, 'query')) AS query,
      device.platform AS platform,
      (CASE jest(COALESCE(platform.fragment, others['fragment']), 'origin')  WHEN 'supermarket_carousel_main_box' THEN 'search_filter' 
                                    WHEN 'supermarket_carousel_link_box' THEN 'search_all'
                                    WHEN 'RE' THEN 'REAL ESTATE'
                                    ELSE 'other' END ) as place,
      substr(ds, 1, 10) AS track_date,
      count(*) AS clicks
    FROM tracks
    WHERE 
      path LIKE '/search'
      AND ds >= '@param01'
      AND ds < '@param02'
      AND trim(jest(event_data, 'query')) IS NOT NULL
      AND trim(jest(event_data, 'query')) != ''
      AND jest(COALESCE(platform.fragment, others['fragment']), 'origin') RLIKE 'supermarket_carousel.*'
    GROUP BY
      trim(jest(event_data, 'query')),
      device.platform,
      (CASE jest(COALESCE(platform.fragment, others['fragment']), 'origin')  WHEN 'supermarket_carousel_main_box' THEN 'search_filter' 
                                    WHEN 'supermarket_carousel_link_box' THEN 'search_all'
                                    WHEN 'RE' THEN 'REAL ESTATE'
                                    ELSE 'other' END ),
      substr(ds, 1, 10)
    UNION ALL
    SELECT 
      trim(regexp_replace(jest(platform.http.cookies, 'LAST_SEARCH'), '-', ' ')) AS query,
      device.platform AS platform,
      'item' as place,
      substr(ds, 1, 10) AS track_date,
      count(*) AS clicks
    FROM tracks
    WHERE 
      path LIKE '/vip'
      AND ds >= '@param01'
      AND ds < '@param02'
      AND jest(platform.http.cookies, 'LAST_SEARCH') IS NOT NULL
      AND jest(platform.http.cookies, 'LAST_SEARCH') != ''
      AND jest(COALESCE(platform.fragment, others['fragment']), 'origin') RLIKE 'supermarket_carousel.*'
    GROUP BY
      trim(regexp_replace(jest(platform.http.cookies, 'LAST_SEARCH'), '-', ' ')),
      device.platform,
      substr(ds, 1, 10)
  ) search_u_vip_clicks
  GROUP BY
    search_u_vip_clicks.query,
    search_u_vip_clicks.platform,
    search_u_vip_clicks.track_date,
    place
) AS clicks
ON prints.query = clicks.query 
  AND prints.platform = clicks.platform
  AND prints.track_date = clicks.track_date

