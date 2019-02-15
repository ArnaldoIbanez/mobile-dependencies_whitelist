SELECT device.device_id AS device,
      device.platform AS platform,
      application.version AS VERSION,
      application.business AS business,
      count(DISTINCT usr.uid) AS uids_quantity,
      substr
 (ds,1,10) AS ds
FROM tracks
WHERE ds >= '2019-02-14'
 AND ds < '2019-02-15'
 AND device.platform IN ('/mobile/android', '/mobile/ios')
 AND usr.uid is not null
 AND device.device_id is not null
GROUP BY substr(ds,1,10),
        device.platform,
        application.version,
        application.business,
        device.device_id
HAVING count(DISTINCT usr.uid) > 1
