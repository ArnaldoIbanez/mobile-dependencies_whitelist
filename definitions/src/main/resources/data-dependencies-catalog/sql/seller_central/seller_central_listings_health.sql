SELECT  jest(event_data,'health_id') as id,
        device.platform as plataforma,
        count(1) as cantidad,
        substr(ds,1,10) as ds
FROM tracks
WHERE ds >= '@param01'
AND ds < '@param02'
AND path = '/seller_central/listings/list/health'
GROUP BY substr(ds,1,10),
          device.platform,
          jest(event_data,'health_id');