SELECT 
    device.platform AS platform,
    application.site_id AS site_id,application.version as version ,path,
    get_json_object(event_data, '$.content_id') as content,
    approx_count_distinct(usr.user_id) as Usuarios,
    count(usr.user_id) as total,
    substr(ds,1,10) as ds
FROM default.tracks
WHERE ds >= '@param01'
AND   ds < '@param02'
      AND application.business = 'mercadopago'
      AND application.site_id in ('MLA','MLB','MLM','MLC','MCO','MLU','MPE')
      AND path IN ('/merchengine/modal','/merchengine/modal/cta')
GROUP BY substr(ds,1,10), device.platform, application.site_id,application.version,path,get_json_object(event_data, '$.content_id')