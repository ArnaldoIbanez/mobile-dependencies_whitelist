SELECT
path,
application.business AS business,
COUNT(DISTINCT usr.uid) AS uids_quantity,
(SELECT COUNT(DISTINCT usr.uid) FROM tracks WHERE ds >= '@param01' AND ds < '@param02' AND device.platform IN ('/web/desktop', '/web/mobile')) AS uids_total,
substr(ds, 1, 10) AS ds
FROM tracks
WHERE ds >= '@param01'
AND ds < '@param02'
AND device.platform IN ('/web/desktop', '/web/mobile')
AND substring(usr.uid, length(usr.uid) - 1, 2) = '-n'
GROUP BY path,application.business,substr(ds, 1, 10)