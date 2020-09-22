SELECT usr.user_id as user_id,
  device.platform as platform,
  substr(ds,1,10) AS track_date
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
SELECT usr.user_id as user_id,
  device.platform as platform,
  substr(ds,1,10) AS track_date
FROM
  tracks 
WHERE
  ds >= '@param01'
  AND ds < '@param02'
  AND path = '/home/supermarket'
group by 
  substr(ds,1,10),
  usr.user_id,
  device.platform