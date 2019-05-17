select device.platform,
application.site_id,
application.business,
count(distinct jest(platform.http.cookies, '_d2id')) as qty_distinct_d2id,
count(distinct CASE WHEN substr(jest(platform.http.cookies, '_d2id'), length(jest(platform.http.cookies, '_d2id')) - 1) = '-n' THEN jest(platform.http.cookies, '_d2id') END) as qty_distinct_d2id_with_n,
substr(ds, 1, 10)
from tracks
where ds >= '@param01' and ds < '@param02'
and jest(platform.http.cookies, '_d2id') is not null
and device.platform in ('/web/mobile', '/web/desktop')
and path != '/traffic/inbound/matt'
group by device.platform,
application.site_id,
application.business,
substr(ds, 1, 10)
