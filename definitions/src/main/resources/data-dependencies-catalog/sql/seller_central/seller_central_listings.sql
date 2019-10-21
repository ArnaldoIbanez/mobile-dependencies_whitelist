SELECT  jest(event_data,'id') as id,
        jest(event_data,'action') as accion,
        jest(event_data,'type') as tipo,
        device.platform as plataforma,
        count(1) as cantidad,
        substr(ds,1,10) as ds
FROM tracks
WHERE ds >= '@param01'
AND ds < '@param02'
AND path = '/seller_central/listings/communication'
GROUP BY substr(ds,1,10),
          device.platform,
          jest(event_data,'id'),
          jest(event_data,'action'),
          jest(event_data,'type')
