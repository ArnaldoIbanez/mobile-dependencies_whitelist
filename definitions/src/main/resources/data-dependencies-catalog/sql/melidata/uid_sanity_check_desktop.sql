SELECT usr.user_id AS user_id,
       path,
       device.user_agent AS user_agent,
       device.platform AS platform,
       application.business AS business,
       application.site_id AS site,
       count(DISTINCT(CASE substr(usr.uid, length(usr.uid) - 1) WHEN '-n' THEN substr(usr.uid, 1, length(usr.uid) - 2) ELSE usr.uid END)) AS uids_quantity,
       substr(ds,1,10) AS ds
FROM tracks
WHERE ds >= '@param01'
  AND ds < '@param02'
  AND device.platform IN ('/web/mobile','/web/desktop')
  AND usr.uid IS NOT NULL
  AND usr.user_id IS NOT NULL
  AND usr.user_id != '-1'
  AND is_bot(device.user_agent) = false
GROUP BY substr
  (ds,1,10),
         device.platform,
         application.business,
         usr.user_id,
         device.user_agent,
         application.site_id,
         path
HAVING count(DISTINCT(CASE substr(usr.uid, length(usr.uid) - 1) WHEN '-n' THEN substr(usr.uid, 1, length(usr.uid) - 2) ELSE usr.uid END)) > 1