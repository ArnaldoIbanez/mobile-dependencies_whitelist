SELECT substr(ds,1,10) AS date, 
  usr.user_id as user_id,
  device.platform as platform
FROM
  tracks 
WHERE
  ds >= '@param01'
  AND ds < '@param02'
  AND path like '/search'
  AND jest(event_data, 'filters.deal') = 'MLM525'
group by 
  substr(ds,1,10),
  usr.user_id,
  device.platform
union all
SELECT substr(ds,1,10) AS date, 
  usr.user_id as user_id,
  device.platform as platform
FROM
  tracks 
WHERE
  ds >= '@param01'
  AND ds < '@param02'
  AND path like '/home/supermarket'
group by 
  substr(ds,1,10),
  usr.user_id,
  device.platform