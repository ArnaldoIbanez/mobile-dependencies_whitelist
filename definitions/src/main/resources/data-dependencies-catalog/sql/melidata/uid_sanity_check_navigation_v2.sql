SELECT business, platform, (AVG(average_uids_quantity) * 1000000000) AS average_uids_quantity, SUM(paths_quantity) AS paths_quantity, ds FROM (
SELECT user_id, user_second_id, business, platform, AVG(uids_quantity) AS average_uids_quantity, COUNT(*) AS paths_quantity, ds FROM
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
AND ' ' NOT IN (application.business)
  AND (CASE WHEN device.platform IN ('/web/mobile','/web/desktop') THEN is_bot(device.user_agent) = false AND device.user_agent IS NOT NULL
            WHEN device.platform IN ('/mobile/android', '/mobile/ios') THEN device.device_id IS NOT NULL
            END)
GROUP BY substr(ds,1,10), usr.user_id, (CASE WHEN device.platform IN ('/web/mobile','/web/desktop') THEN device.user_agent
            WHEN device.platform IN ('/mobile/android', '/mobile/ios') THEN device.device_id
            END)
, path, application.business, device.platform
) AS t2
GROUP BY user_id, user_second_id, business, platform, ds) as t3
GROUP BY business, platform, ds