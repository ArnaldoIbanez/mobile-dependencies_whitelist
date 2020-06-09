SELECT
    type,
    path,
    usr.user_id as cust_id,
    get_json_object(event_data, '$.shop_name') as shop_name,
    get_json_object(event_data, '$.shop_domain') as shop_domain,
    get_json_object(event_data, '$.sidebar_name') as opened_sidebar,
    platform.http.http_referer,
    platform.http.http_url,
    get_json_object(event_data, '$.ref') as ref_source,
    get_json_object(others['utm'], '$.utm_source') as utm_source,
    get_json_object(others['utm'], '$.utm_medium') as utm_medium,
    get_json_object(others['utm'], '$.utm_campaign') as utm_campaign,
    application.site_id,
    count(1) as interactions,
    substr(ds,1,10)
from default.tracks
where ds >= '@param01' and ds < '@param02' and path like '/mercado_shops%'
group by
    substr(ds, 1,10),
    type,
    path,
    usr.user_id,
    get_json_object(event_data, '$.shop_name'),
    get_json_object(event_data, '$.shop_domain'),
    get_json_object(event_data, '$.sidebar_name'),
    platform.http.http_referer,
    platform.http.http_url,
    get_json_object(event_data, '$.ref'),
    get_json_object(others['utm'], '$.utm_source'),
    get_json_object(others['utm'], '$.utm_medium'),
    get_json_object(others['utm'], '$.utm_campaign'),
    application.site_id
