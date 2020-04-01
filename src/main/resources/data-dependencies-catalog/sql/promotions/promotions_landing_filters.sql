SELECT P.site AS site,
      P.device_platform AS device,
      P.sp_origin AS sp_origin,
      P.prints AS prints_device_sp_origin,
      P.users AS users_device_sp_origin,
      C.filter AS filter,
      C.origin AS filter_origin,
      C.clicks AS filter_clicks,
      C.uid AS filter_uid,
      P.track_date AS track_date
FROM
(
  SELECT
    application.site_id AS site,
    device.platform AS device_platform,
    jest(platform.fragment, 'sp_origin') AS sp_origin,
    COUNT(*) AS prints,
    COUNT(DISTINCT usr.uid) AS users,
    substr(ds,1,10) AS track_date
  FROM tracks
  WHERE path = '/promotions'
    AND ds >= '@param01'
    AND ds < '@param02'
    AND application.site_id IN ('MLA','MLB','MLM')
  GROUP BY application.site_id, device.platform, jest(platform.fragment, 'sp_origin'), substr(ds,1,10)
) P
JOIN
(
  SELECT
    application.site_id AS site,
    device.platform AS device_platform,
    jest(event_data, 'origin') AS origin,
    jest(platform.fragment, 'sp_origin') AS sp_origin,
    jest(jest(event_data, 'selected_filters'),jest(event_data, 'filter_applied')) AS filter,
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
    jest(platform.fragment, 'sp_origin'),
    jest(jest(event_data, 'selected_filters'),jest(event_data, 'filter_applied')),
    usr.uid,
    substr(ds,1,10)
) C
ON P.site=C.site AND P.device_platform=C.device_platform AND P.sp_origin=C.sp_origin AND P.track_date=C.track_date;