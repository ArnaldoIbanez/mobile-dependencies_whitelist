SELECT P.site AS site,
      P.device_platform AS device_platform,
      C.origin AS filter_origin,
      C.users_clicks AS users_clicks,
      P.users_total AS users_total,
      CAST (C.users_clicks AS DOUBLE)/P.users_total*100 AS users_percentage,
      P.track_date AS track_date
FROM
(
    SELECT
    application.site_id AS site,
    device.platform AS device_platform,
    COUNT(DISTINCT usr.user_id) AS users_total,
    substr(ds,1,10) AS track_date
  FROM tracks
  WHERE path = '/promotions'
    AND ds >= '@param01'
    AND ds < '@param02'
    AND application.site_id in ('MLA','MLB','MLM')
    AND (NOT (jest(platform.fragment, 'origin') = 'reach-promotions-cat')
      OR jest(platform.fragment, 'origin') IS NULL)
    AND usr.user_id IS NOT NULL
  GROUP BY application.site_id, device.platform, substr(ds,1,10)
) P
JOIN
(
  SELECT
    application.site_id AS site,
    device.platform AS device_platform,
    jest(event_data, 'origin') AS origin,
    COUNT(DISTINCT usr.user_id) AS users_clicks,
    substr(ds,1,10) AS track_date
  FROM tracks
  WHERE path = '/promotions'
    AND ds >= '@param01'
    AND ds < '@param02'
    AND application.site_id in ('MLA','MLB','MLM')
    AND (jest(event_data, 'origin') = 'scut' OR jest(event_data, 'origin') = 'qcat')
    AND (NOT (jest(platform.fragment, 'origin') = 'reach-promotions-cat')
      OR jest(platform.fragment, 'origin') IS NULL)
  GROUP BY application.site_id, device.platform, jest(event_data, 'origin'), substr(ds,1,10)
) C
ON P.site=C.site AND P.device_platform=C.device_platform AND P.track_date=C.track_date;