SELECT substr(ds,1,10) AS ds,
       application.site_id as site,
       COUNT(1) AS total,
       device.platform AS platform,
       application.business AS business,
       jest(event_data,'expected_resolution') AS expected_resolution
FROM tracks
WHERE path = '/claims/refunded'
AND   ds < '@param02'
AND   ds >= '@param01'
GROUP BY application.site_id,
         substr(ds,1,10),
         device.platform,
         application.business,
         jest(event_data, 'expected_resolution');
