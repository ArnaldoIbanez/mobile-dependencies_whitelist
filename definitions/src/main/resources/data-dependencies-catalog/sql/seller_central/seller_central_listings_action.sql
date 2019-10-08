SELECT  jest(event_data,'action_id') as id,
        jest(event_data, 'view_id') as view,
        device.platform as plataforma,
        count(1) as cantidad,
        substr(ds,1,10) as ds
FROM tracks
WHERE ds >= '@param01'
AND ds < '@param02'
AND path = '/seller_central/listings/action'
GROUP BY substr(ds,1,10),
          device.platform,
          jest(event_data,'view_id'),
          jest(event_data,'action_id');
