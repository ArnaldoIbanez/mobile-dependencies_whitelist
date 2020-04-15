SELECT 
    device.platform AS platform,
    application.site_id AS site_id,application.version as version, path ,
    get_json_object(event_data, '$.component_id') as component,
    count(distinct usr.user_id) as taps, 
    count(usr.user_id) as total,
    substr(ds,1,10) as ds
FROM default.tracks
WHERE ds >= '@param01'
AND   ds < '@param02'
    AND type='event'
    AND application.site_id in ('MLA','MLB','MLM','MLC','MCO','MLU','MPE')
    AND application.business = 'mercadopago'
    AND (path in ('/wallet_home/section/tap/banking' ,'/wallet_home/section/tap/main_actions','/wallet_home/section/tap/secondary_actions','/wallet_home/section/tap/discount_center','/wallet_home/section/tap/benefits','/wallet_home/section/tap/qr_map','/wallet_home/section/tap/cross_selling','/wallet_home/section/tap/loyalty')
    OR path like '/wallet_home/section/tap/activities'
     AND  get_json_object(event_data, '$.component_id') = 'user_activities_see_more_button')
GROUP BY substr(ds,1,10) , device.platform, application.site_id,application.version,path,
get_json_object(event_data, '$.component_id')