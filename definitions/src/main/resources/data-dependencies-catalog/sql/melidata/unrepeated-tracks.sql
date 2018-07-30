SELECT substr(ds,1,10) AS ds,
      device.platform AS platform,
      application.version AS version,
      count(distinct id) AS unrepeated,
      count(1) AS total
FROM tracks
WHERE ds >= '@param01'
AND ds < '@param02'
GROUP BY ds, device.platform, application.version
