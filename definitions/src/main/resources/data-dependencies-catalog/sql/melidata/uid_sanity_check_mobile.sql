SELECT device.device_id AS device,
      device.platform AS platform,
      application.version AS VERSION,
      application.business AS business,
      application.site_id AS site,
      path,
      count(DISTINCT usr.uid) AS uids_quantity,
      substr
 (ds,1,10) AS ds
FROM tracks
WHERE ds >= '@param01'
 AND ds < '@param02'
 AND device.platform IN ('/mobile/android', '/mobile/ios')
 AND usr.uid is not null
 AND device.device_id is not null
GROUP BY substr(ds,1,10),
        device.platform,
        application.version,
        application.business,
        application.site_id,
        device.device_id,
        path
HAVING count(DISTINCT usr.uid) > 1
