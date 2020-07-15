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
      trim(get_json_object(event_data, '$.query')) AS query,
      device.platform AS platform,
      substr(ds, 1, 10) AS track_date,
      count(*) AS prints
  FROM melidata.tracks_ml
  WHERE path = '/search'
      AND ds >= '@param01'
      AND ds < '@param02'
      AND bu = 'mercadolibre'
      AND trim(get_json_object(event_data, '$.query')) IS NOT NULL
      AND trim(get_json_object(event_data, '$.query')) != ''
      AND get_json_object(event_data, '$.show_apparel_carousel') = 'true'
  GROUP BY
      application.site_id,
      trim(get_json_object(event_data, '$.query')),
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
          site AS site_id,
          if(path='/search', trim(get_json_object(event_data, '$.query')), trim(regexp_replace(get_json_object(platform.http.cookies, '$.LAST_SEARCH'), '-', ' '))) AS query,
          device.platform AS platform,
          if(path='/search', (CASE get_json_object(others['fragment'], '$.origin')  WHEN 'apparel_tos_carousel_main_box' THEN 'main_box'
                                        WHEN 'apparel_tos_carousel_link_box' THEN 'link_box'
                                        ELSE 'other'
                                        END ), 'item') AS place,
          substr(ds, 1, 10) AS track_date,
          count(*) AS clicks
        FROM melidata.tracks_ml
        WHERE
          ds >= '@param01'
          AND ds < '@param02'
          AND bu = 'mercadolibre'
          AND get_json_object(others['fragment'], '$.origin') RLIKE 'apparel_tos_carousel.*'
          AND (
            (path = '/search'
            AND trim(get_json_object(event_data, '$.query')) IS NOT NULL
            AND trim(get_json_object(event_data, '$.query')) != '') OR
            (path = '/vip'
            AND get_json_object(platform.http.cookies, '$.LAST_SEARCH') IS NOT NULL
            AND get_json_object(platform.http.cookies, '$.LAST_SEARCH') != '')
          )
        GROUP BY
          site,
          if(path='/search', trim(get_json_object(event_data, '$.query')), trim(regexp_replace(get_json_object(platform.http.cookies, '$.LAST_SEARCH'), '-', ' '))),
          device.platform,
          if(path='/search', (CASE get_json_object(others['fragment'], '$.origin')  WHEN 'apparel_tos_carousel_main_box' THEN 'main_box'
                                        WHEN 'apparel_tos_carousel_link_box' THEN 'link_box'
                                        ELSE 'other'
                                        END ), 'item'),
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
