SELECT 
    device.platform AS platform,application.business as business, path,
    application.site_id AS site_id,
    get_json_object(event_data, '$.level') as level,
    get_json_object(event_data, '$.origin') as origin,
    get_json_object(event_data, '$.title') as title,
    get_json_object(event_data, '$.item_number') as item_number,
    get_json_object(event_data, '$.type')as type ,
    get_json_object(event_data, '$.subscription_status') as subscription_status,
    get_json_object(event_data, '$.subscription_partner') as subscription_partner,
    get_json_object(event_data, '$.content') as content,
    get_json_object(event_data, '$.discount_percent') as discount_percent,
    get_json_object(event_data, '$.position') as position,
    get_json_object(event_data, '$.is_free_trial') as is_free_trial,
    get_json_object(event_data, '$.payment_status') as payment_status,
    get_json_object(platform.fragment,'origin') origen,
    count(usr.user_id) as total,
    count(distinct usr.user_id) as distincts,
    count(path) as paths,
    substr(ds,1,10) as ds
FROM default.tracks
WHERE ds >= '@param01'
AND   ds < '@param02'
    AND application.site_id IN ('MLM','MLB') 
    AND not (usr.user_nick RLIKE '^(TETE|TT|TEST)[0-9]*')
    AND path in ('/loyalty/crossselling/action','/loyalty/crossselling/carousel/action',
    '/loyalty/partners/vdp','/loyalty/partners/vdp/action','/loyalty/partners/checkout/congrats',
    '/loyalty/partners/login/verified','/loyalty/partners/login/invalid','/loyalty/partners/login/code',
    '/loyalty/partners/login/verify','/loyalty/partners/login/verify/action','/loyalty/partners/login',
    '/loyalty/partners/admin','/loyalty/partners/admin/action','/loyalty/partners/checkout/congrats/action',
    '/checkout_off/review','/checkout_off/payment/select_type')
GROUP BY substr(ds,1,10) ,
    device.platform,application.business, path, application.site_id,
    get_json_object(event_data, '$.level') ,
    get_json_object(event_data, '$.origin') ,
    get_json_object(event_data, '$.title') ,
    get_json_object(event_data, '$.item_number'),
    get_json_object(event_data, '$.type'),
    get_json_object(event_data, '$.subscription_status'),
    get_json_object(event_data, '$.subscription_partner'),
    get_json_object(event_data, '$.content'),
    get_json_object(event_data, '$.discount_percent'),
    get_json_object(event_data, '$.position'),
    get_json_object(event_data, '$.is_free_trial'),
    get_json_object(platform.fragment,'origin'),
    get_json_object(event_data, '$.payment_status')
  