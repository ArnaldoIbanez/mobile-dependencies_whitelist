SELECT
    ds,
    type,
    server_timestamp,
    path,
    usr.uid,
    usr.user_id as cust_id,
    jest(event_data, 'shop_name') as shop_name,
    jest(event_data, 'shop_domain') as shop_domain,
    jest(event_data, 'sidebar_name') as opened_sidebar,
    platform.http.http_referer,
    platform.http.http_url,
    jest(event_data, 'ref') as ref_source,
    jest(others['utm'], 'utm_source') as utm_source,
    jest(others['utm'], 'utm_medium') as utm_medium,
    jest(others['utm'], 'utm_campaign') as utm_campaign,
    application.site_id
from default.tracks
where ds >= '@param01' and ds < '@param02'
and path like '/mercado_shops%'
