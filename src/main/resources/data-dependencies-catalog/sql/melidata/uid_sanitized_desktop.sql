SELECT path, application.business AS business, COUNT(DISTINCT CASE WHEN substring(usr.uid, length(usr.uid) - 1, 2) = '-n'
THEN substring(usr.uid, 1, length(usr.uid) - 1)
ELSE NULL
END) AS uids_quantity, COUNT(DISTINCT usr.uid) AS uids_total,substr(ds, 1, 10) AS ds FROM tracks
  WHERE ds >= '@param01' AND ds < '@param02' AND device.platform IN ('/web/desktop', '/web/mobile')
  GROUP BY path,application.business,substr(ds, 1, 10)