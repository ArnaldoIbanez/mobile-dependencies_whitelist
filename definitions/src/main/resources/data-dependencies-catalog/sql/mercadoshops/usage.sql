SELECT
    substr(ds,1,10),
    type,
    path,
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
    application.site_id,
    count(1) as interactions
from default.tracks
where ds >= '@param01' and ds < '@param02' and path like '/mercado_shops%'
group by 1,2,3,4,5,6,7,8,9,10,11,12,13,14
