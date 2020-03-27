SELECT P.site AS site,
      P.device_platform AS device_platform,
      C.origin AS filter_origin,
      C.filter AS filter,
      C.clicks AS clicks,
      P.prints AS prints,
      CAST (C.clicks AS DOUBLE)/P.prints*100 AS ctr,
      P.track_date AS track_date
FROM
(
  SELECT
    application.site_id AS site,
    device.platform AS device_platform,
    count(*) AS prints,
    substr(ds,1,10) AS track_date
  FROM tracks
  WHERE path = '/promotions'
    AND ds >= '@param01'
    AND ds < '@param02'
    AND application.site_id in ('MLA','MLB','MLM')
    AND (NOT (jest(platform.fragment, 'origin') = 'reach-promotions-cat')
      OR jest(platform.fragment, 'origin') IS NULL)
  GROUP BY application.site_id, device.platform, substr(ds,1,10)
) P
JOIN
(
  SELECT
    application.site_id AS site,
    device.platform AS device_platform,
    jest(jest(event_data, 'selected_filters'),jest(event_data, 'filter_applied')) AS filter,
    jest(event_data, 'origin') AS origin,
    count(*) AS clicks,
    substr(ds,1,10) AS track_date
  FROM tracks
  WHERE path = '/promotions'
    AND ds >= '@param01'
    AND ds < '@param02'
    AND application.site_id in ('MLA','MLB','MLM')
    AND (jest(event_data, 'origin') = 'scut' OR jest(event_data, 'origin') = 'qcat')
    AND jest(event_data, 'filter_applied') IS NOT NULL
    AND (NOT (jest(platform.fragment, 'origin') = 'reach-promotions-cat')
      OR jest(platform.fragment, 'origin') IS NULL)
  GROUP BY application.site_id,
    device.platform,
    jest(jest(event_data, 'selected_filters'),jest(event_data, 'filter_applied')),
    jest(event_data, 'origin'),
    substr(ds,1,10)
) C
ON P.site=C.site AND P.device_platform=C.device_platform AND P.track_date=C.track_date;