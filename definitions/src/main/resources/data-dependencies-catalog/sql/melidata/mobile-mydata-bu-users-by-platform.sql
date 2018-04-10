SELECT count(DISTINCT usr) AS total,
       substr(ds,1,10),
       device.platform AS platform
FROM tracks
WHERE path = '/myml/company_profile'
  AND ds >= '@param01'
  AND ds <= '@param02'