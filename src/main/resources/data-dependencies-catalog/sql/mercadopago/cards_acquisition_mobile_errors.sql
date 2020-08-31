SELECT 
    device.platform AS platform,
    application.site_id AS site_id,
    application.version as version,
    get_json_object(event_data, '$.screen') as screen,
    count(distinct usr.user_id) as unique_affected_users, 
    count(usr.user_id) as total,
    substr(ds,1,10) as ds
FROM default.tracks
WHERE ds >= '@param01'
AND   ds < '@param02'
    AND application.business = 'mercadopago'
    AND path ='/cards/acquisition/error'
GROUP BY substr(ds,1,10) , device.platform, application.site_id, application.version, get_json_object(event_data, '$.screen')