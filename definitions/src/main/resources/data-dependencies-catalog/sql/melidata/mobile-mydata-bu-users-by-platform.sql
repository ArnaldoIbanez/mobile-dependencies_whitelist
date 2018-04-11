SELECT count(DISTINCT usr) as total ,
       substr(ds,1,10) as ds,
       device.platform as platform
FROM tracks
WHERE path = '/myml/company_profile'
  AND ds >= '@param01'
  AND ds <= '@param02'
group by substr(ds,1,10), device.platform
order by substr(ds,1,10)
