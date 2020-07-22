select
application.sdk_version['js_version'] as js_version,
device.platform,
application.site_id,
application.business,
count(distinct get_json_object(platform.http.cookies, '$._d2id')) as qty_distinct_d2id,
count(distinct CASE WHEN substr(get_json_object(platform.http.cookies, '$._d2id'), length(get_json_object(platform.http.cookies, '$._d2id')) - 1) = '-n' THEN get_json_object(platform.http.cookies, '$._d2id') END) as qty_distinct_d2id_with_n,
date_part(ds) as day
from tracks
where ds >= '@param01' and ds < '@param02'
and get_json_object(platform.http.cookies, '$._d2id') is not null
and device.platform in ('/web/mobile', '/web/desktop')
group by application.sdk_version['js_version'],
device.platform,
application.site_id,
application.business,
date_part(ds)