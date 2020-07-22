SELECT P.site AS site,
      P.device_platform AS device,
      P.prints AS prints_device,
      P.users AS users_device,
      C.filter_applied AS filter_applied,
      C.filter_value AS filter_value,
      C.filter_position AS filter_position,
      C.origin AS filter_origin,
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
    AND application.site_id IN ('MLA','MLB','MLM')
  GROUP BY application.site_id, device.platform, substr(ds,1,10)
) P
JOIN
(
  SELECT
    application.site_id AS site,
    device.platform AS device_platform,
    jest(event_data, 'origin') AS origin,
    jest(event_data, 'filter_applied') AS filter_applied,
    jest(jest(event_data, 'selected_filters'),jest(event_data, 'filter_applied')) AS filter_value,
    jest(event_data, 'filter_position') AS filter_position,
    usr.uid AS uid,
    COUNT(*) AS clicks,
    substr(ds,1,10) AS track_date
  FROM tracks
  WHERE path = '/promotions'
    AND ds >= '@param01'
    AND ds < '@param02'
    AND application.site_id IN ('MLA','MLB','MLM')
    AND jest(event_data, 'filter_applied') IS NOT NULL
  GROUP BY application.site_id,
    device.platform,
    jest(event_data, 'origin'),
    jest(event_data, 'filter_applied'),
    jest(jest(event_data, 'selected_filters'),jest(event_data, 'filter_applied')),
    jest(event_data, 'filter_position'),
    usr.uid,
    substr(ds,1,10)
) C
ON P.site=C.site AND P.device_platform=C.device_platform AND P.track_date=C.track_date;