SELECT P.site AS site,
      P.device_platform AS device_platform,
      P.prints AS device_prints,
      P.users AS device_total_users,
      C.origin_event_data AS origin_event_data,
      C.filter AS filter,
      C.clicks AS filter_clicks,
      C.uid AS filter_uid,
      P.track_date AS track_date
FROM
(
  SELECT
    application.site_id AS site,
    device.platform AS device_platform,
    COUNT(*) AS prints,
    COUNT(DISTINCT usr.uid) AS users,
    substr(ds,1,10) AS track_date
  FROM tracks
  WHERE path = '/promotions'
    AND ds >= '@param01'
    AND ds < '@param02'
    AND application.site_id in ('MLA','MLB','MLM')
  GROUP BY application.site_id, device.platform, substr(ds,1,10)
) P
JOIN
(
  SELECT
    application.site_id AS site,
    device.platform AS device_platform,
    jest(event_data, 'origin') AS origin_event_data,
    jest(jest(event_data, 'selected_filters'),jest(event_data, 'filter_applied')) AS filter,
    usr.uid AS uid,
    count(*) AS clicks,
    substr(ds,1,10) AS track_date
  FROM tracks
  WHERE path = '/promotions'
    AND ds >= '@param01'
    AND ds < '@param02'
    AND application.site_id in ('MLA','MLB','MLM')
    AND jest(event_data, 'filter_applied') IS NOT NULL
  GROUP BY application.site_id,
    device.platform,
    jest(event_data, 'origin'),
    jest(jest(event_data, 'selected_filters'),jest(event_data, 'filter_applied')),
    usr.uid,
    substr(ds,1,10)
) C
ON P.site=C.site AND P.device_platform=C.device_platform AND P.track_date=C.track_date;