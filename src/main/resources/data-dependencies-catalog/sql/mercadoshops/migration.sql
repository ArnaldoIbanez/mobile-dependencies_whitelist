SELECT
    application.site_id,
    path,
    usr.uid as uid,
    usr.user_id as user_id,
    jest(event_data, 'index') as optin_card,
    jest(event_data, 'shop_domain') as shop_domain,
    substr(ds,1,10) AS ds
FROM
    default.tracks
WHERE
    (
        (path = '/mercado_shops/admin/welcome' and platform.http.http_referer like '%/mercadoshops')
        or (path = '/mercado_shops/optin' and platform.http.http_url like '%/mercadoshops')
        or path = '/mercado_shops/admin/confirm_migration'
        or path = '/mercado_shops/optin/step'
    )
    and ds >= '@param01' and ds < '@param02'
