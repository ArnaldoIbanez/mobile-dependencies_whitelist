SELECT path AS track,
       application.version AS version,
       count(*) AS count_tracks,
       count(DISTINCT usr) AS count_unique_users,
       count(DISTINCT jest(event_data,'flow_id')) AS count_flow_id
FROM tracks
WHERE ds >= '@param01' AND ds < '@param02'
AND.  usr.user_id IS NOT NULL
AND.  device.platform IN ('/mobile/android')
AND.  application.business = 'mercadopago'
AND.  path LIKE '/point_payment/%'
AND.  jest(event_data,'flow_id') IS NOT NULL
GROUP BY path, application.version