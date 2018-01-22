SELECT substr(ds,1,10) AS ds,
       COUNT(1) AS total,
       jest(event_data,'reason') AS reason,
       jest(event_data,'expected_resolution') AS expected_resolution,
       device.platform AS platform,
       application.business AS business
FROM tracks
WHERE path = '/claims/stale'
AND   ds < '@param02'
AND   ds >= '@param01'
GROUP BY substr(ds,1,10),
         device.platform,
         jest(event_data,'reason'),
         jest(event_data,'expected_resolution'),
         application.business;
