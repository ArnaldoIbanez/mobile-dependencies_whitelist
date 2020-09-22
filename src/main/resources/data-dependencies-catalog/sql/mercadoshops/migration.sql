SELECT
    application.site_id,
    path,
    usr.uid as uid,
    usr.user_id as user_id,
    get_json_object(event_data, '$.index') as optin_card,
    get_json_object(event_data, '$.shop_domain') as shop_domain,
    substr(ds,1,10) AS ds
FROM
    default.tracks
WHERE
    (
        path = '/mercado_shops/optin/step'
        or path = '/mercado_shops/admin/confirm_migration'
        or path = '/mercado_shops/optin'
        or (path = '/mercado_shops/admin/welcome'  and platform.http.http_referer like '%/mercadoshops/optin')
        or (path = '/mercado_shops/hub/onboarding' and platform.http.http_referer like '%/mercadoshops/optin')
    )
    and ds >= '@param01' and ds < '@param02'
