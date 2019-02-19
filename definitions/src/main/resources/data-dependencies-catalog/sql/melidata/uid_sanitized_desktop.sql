SELECT
application.site_id AS site,
application.business AS business,
COUNT(DISTINCT usr.uid) AS uids_quantity,
substr(ds, 1, 10) AS ds
FROM tracks
WHERE ds >= '@param01'
AND ds < '@param02'
AND device.platform IN ('/web/desktop', '/web/mobile')
AND substring(usr.uid, length(usr.uid) - 1, 2) = '-n'
GROUP BY application.site_id,application.business,substr(ds, 1, 10)