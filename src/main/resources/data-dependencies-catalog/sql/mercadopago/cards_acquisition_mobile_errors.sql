SELECT 
    Substring(device.platform, 9, 16) AS platform,
    application.site_id AS site_id,
    application.version as version,
    get_json_object(event_data, '$.screen') as screen,
    count(distinct usr.user_id) as unique_affected_users, 
    count(usr.user_id) as total,
    Substr(ds, 1, 10)  AS fecha
FROM default.tracks
WHERE ds >= '@param01'
AND   ds < '@param02'
    AND application.business = 'mercadopago'
    AND path ='/cards/acquisition/error'
GROUP BY fecha , Substring(device.platform, 9, 16), application.site_id, application.version, get_json_object(event_data, '$.screen')