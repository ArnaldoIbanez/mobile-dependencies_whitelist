SELECT  
    device.platform AS platform,
    application.version,
    application.site_id AS site_id,
    get_json_object(event_data, '$.component_id') as component,
    get_json_object(event_data, '$.from') as fromto,
    get_json_object(event_data, '$.position') as position,
    count(distinct usr.uid) as taps, 
    count(usr.uid) as total,
    substr(ds,1,10) as ds
FROM default.tracks
WHERE ds >= '@param01'
AND   ds < '@param02'
    AND type = 'event'
    AND application.site_id IN ('MLA','MLB','MLC','MLM','MCO','MLU','MPE')
    AND application.business = 'mercadopago'
    AND path in ('/wallet_home/section/tap/shortcuts')
GROUP BY substr(ds,1,10) , device.platform, application.version,application.site_id,
get_json_object(event_data, '$.component_id'),get_json_object(event_data, '$.from'),
get_json_object(event_data, '$.position')