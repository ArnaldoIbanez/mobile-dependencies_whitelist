SELECT 
    device.platform AS platform,
    application.site_id AS site_id,application.version as version, path ,
    get_json_object(event_data, '$.content_id') as content,
    get_json_object(event_data, '$.position') as position,
    get_json_object(event_data, '$.audience') as audience,
    count(distinct usr.uid) as taps,
    count(usr.user_id) as total,
    substr(ds,1,10) as ds
FROM default.tracks
    WHERE ds >= '@param01'
    AND   ds < '@param02'
    AND type='event'
    AND application.site_id IN ('MLA','MLB','MLM','MLC','MCO','MLU','MPE')
    AND application.business = 'mercadopago'
    AND path = '/wallet_home/section/tap/cross_selling'
GROUP BY substr(ds,1,10) , device.platform, application.site_id,application.version,path,
get_json_object(event_data, '$.content_id'),get_json_object(event_data, '$.position'),get_json_object(event_data, '$.audience')
UNION ALL
SELECT  
    device.platform AS platform,
    application.site_id AS site_id,application.version as version, path ,
    get_json_object(event_data, '$.component_id') as content,
    get_json_object(event_data, '$.position') as position,
    get_json_object(event_data, '$.from') as audience,
    count(distinct usr.uid) as taps, 
    count(usr.uid) as total,
    substr(ds,1,10) as ds
FROM default.tracks
    WHERE ds >= '@param01'
    AND   ds < '@param02'
    AND type = 'event'
    AND application.site_id IN ('MLA','MLB','MLM','MLC','MCO','MLU','MPE')
    AND application.business = 'mercadopago'
    AND path in ('/wallet_home/section/tap/shortcuts')
GROUP BY substr(ds,1,10) , device.platform, application.version,path,application.site_id,
get_json_object(event_data, '$.component_id'),get_json_object(event_data, '$.from'),
get_json_object(event_data, '$.position')