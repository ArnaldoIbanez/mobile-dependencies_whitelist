SELECT  get_json_object(event_data,'$.id') as id,
        get_json_object(event_data,'$.action') as accion,
        get_json_object(event_data,'$.type') as tipo,
        device.platform as plataforma,
        count(1) as cantidad,
        substr(ds,1,10) as ds
FROM tracks
WHERE ds >= '@param01'
AND ds < '@param02'
AND path = '/seller_central/listings/communication'
GROUP BY substr(ds,1,10),
          device.platform,
          get_json_object(event_data,'$.id'),
          get_json_object(event_data,'$.action'),
          get_json_object(event_data,'$.type')
