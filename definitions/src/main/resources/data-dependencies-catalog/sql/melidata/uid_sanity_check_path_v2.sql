SELECT platform, business, path, SUM(uids_quantity) AS total_uids_quantity, COUNT(*) AS sessions_quantity, ds FROM
(SELECT usr.user_id, (CASE WHEN device.platform IN ('/web/mobile','/web/desktop') THEN device.user_agent
            WHEN device.platform IN ('/mobile/android', '/mobile/ios') THEN device.device_id
            END) AS user_second_id
, path, application.business, device.platform, COUNT(DISTINCT usr.uid) AS uids_quantity, substr(ds,1,10) AS ds
FROM tracks
WHERE ds >= '@param01'
AND ds < '@param02'
AND device.platform IN ('/web/desktop', '/web/mobile', '/mobile/android', '/mobile/ios')
AND usr.uid IS NOT NULL
AND usr.user_id IS NOT NULL
AND usr.user_id NOT IN ('-1', '0', 'UNKNOWN', 'WMS_USER_ID')
  AND (CASE WHEN device.platform IN ('/web/mobile','/web/desktop') THEN is_bot(device.user_agent) = false AND device.user_agent IS NOT NULL
            WHEN device.platform IN ('/mobile/android', '/mobile/ios') THEN device.device_id IS NOT NULL
            END)
GROUP BY substr(ds,1,10), usr.user_id, (CASE WHEN device.platform IN ('/web/mobile','/web/desktop') THEN device.user_agent
            WHEN device.platform IN ('/mobile/android', '/mobile/ios') THEN device.device_id
            END)
, path, application.business, device.platform
) AS t1
GROUP BY platform, business, path, ds