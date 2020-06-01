SELECT 
    prints.site_id AS site_id,
    prints.query AS query,
    prints.platform AS platform,
    clicks.place AS place,
    prints.prints AS prints,
    clicks.clicks AS clicks,
    prints.track_date AS track_date
FROM 
(
  SELECT 
      application.site_id,
      trim(jest(event_data, 'query')) AS query,
      device.platform AS platform,
      substr(ds, 1, 10) AS track_date,
      count(*) AS prints
  FROM tracks
  WHERE path = '/search'
      AND ds >= '@param01'
      AND ds < '@param02'
      AND trim(jest(event_data, 'query')) IS NOT NULL
      AND trim(jest(event_data, 'query')) != ''
      AND jest(event_data, 'show_apparel_carousel') = 'true'
  GROUP BY 
      application.site_id,
      trim(jest(event_data, 'query')),
      device.platform,
      substr(ds, 1, 10)
) AS prints
LEFT JOIN
(
  SELECT 
    search_u_vip_clicks.site_id,
    search_u_vip_clicks.query AS query,
    search_u_vip_clicks.platform AS platform,
    search_u_vip_clicks.track_date AS track_date,
    search_u_vip_clicks.place AS place,
    SUM(search_u_vip_clicks.clicks) AS clicks
  FROM (
    SELECT 
      application.site_id AS site_id,
      trim(jest(event_data, 'query')) AS query,
      device.platform AS platform,
      (CASE jest(others['fragment'], 'origin')  WHEN 'apparel_tos_carousel_main_box' THEN 'main_box' 
                                    WHEN 'apparel_tos_carousel_link_box' THEN 'link_box'
                                    ELSE 'other' 
                                    END ) AS place,
      substr(ds, 1, 10) AS track_date,
      count(*) AS clicks
    FROM tracks
    WHERE 
      path = '/search'
      AND ds >= '@param01'
      AND ds < '@param02'
      AND trim(jest(event_data, 'query')) IS NOT NULL
      AND trim(jest(event_data, 'query')) != ''
      AND jest(others['fragment'], 'origin') RLIKE 'apparel_tos_carousel.*'
    GROUP BY 
      application.site_id,
      trim(jest(event_data, 'query')),
      device.platform,
      (CASE jest(others['fragment'], 'origin')  WHEN 'apparel_tos_carousel_main_box' THEN 'main_box' 
                                    WHEN 'apparel_tos_carousel_link_box' THEN 'link_box'
                                    ELSE 'other' 
                                    END ),
      substr(ds, 1, 10)
    UNION ALL
    SELECT 
      application.site_id AS site_id,
      trim(regexp_replace(jest(platform.http.cookies, 'LAST_SEARCH'), '-', ' ')) AS query,
      device.platform AS platform,
      'item' as place,
      substr(ds, 1, 10) AS track_date,
      count(*) AS clicks
    FROM tracks
    WHERE 
      path = '/vip'
      AND ds >= '@param01'
      AND ds < '@param02'
      AND jest(platform.http.cookies, 'LAST_SEARCH') IS NOT NULL
      AND jest(platform.http.cookies, 'LAST_SEARCH') != ''
      AND jest(others['fragment'], 'origin') RLIKE 'apparel_tos_carousel.*'
    GROUP BY
      application.site_id,
      trim(regexp_replace(jest(platform.http.cookies, 'LAST_SEARCH'), '-', ' ')),
      device.platform,
      substr(ds, 1, 10)
  ) search_u_vip_clicks
  GROUP BY
    search_u_vip_clicks.site_id,
    search_u_vip_clicks.query,
    search_u_vip_clicks.platform,
    search_u_vip_clicks.track_date,
    place
) AS clicks
ON 
  prints.site_id = clicks.site_id
  AND prints.query = clicks.query 
  AND prints.platform = clicks.platform
  AND prints.track_date = clicks.track_date
