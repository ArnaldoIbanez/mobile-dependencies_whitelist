SELECT usr.user_id AS user_id,
       (CASE WHEN device.platform IN ('/web/mobile','/web/desktop') THEN device.user_agent
            WHEN device.platform IN ('/mobile/android', '/mobile/ios') THEN device.device_id
            END) AS user_second_id,
       device.platform AS platform,
       (CASE WHEN device.platform IN ('/web/mobile','/web/desktop') THEN NULL
            WHEN device.platform IN ('/mobile/android', '/mobile/ios') THEN application.version
            END) AS version,
       application.business AS business,
       application.site_id AS site,
       count(DISTINCT usr.uid) AS uids_quantity,
       substr(ds,1,10) AS ds
FROM tracks
WHERE ds >= '@param01'
  AND ds < '@param02'
  AND device.platform IN ('/web/mobile','/web/desktop', '/mobile/android', '/mobile/ios')
  AND usr.uid IS NOT NULL
  AND usr.user_id IS NOT NULL
  AND usr.user_id != '-1'
  AND path != '/mobile/bugsnag'
  AND (CASE WHEN device.platform IN ('/web/mobile','/web/desktop') THEN (is_bot(device.user_agent) = false AND device.user_agent IS NOT NULL)
            WHEN device.platform IN ('/mobile/android', '/mobile/ios') THEN device.device_id is not null
            END)
GROUP BY substr(ds,1,10),
         device.platform,
         application.business,
         usr.user_id,
         (CASE WHEN device.platform IN ('/web/mobile','/web/desktop') THEN device.user_agent
            WHEN device.platform IN ('/mobile/android', '/mobile/ios') THEN device.device_id
            END),
         application.site_id,
         application.version
HAVING count(DISTINCT usr.uid) > 1
