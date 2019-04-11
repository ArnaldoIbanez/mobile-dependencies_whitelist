WITH vipsView as (
select application.site_id as sit, device.platform as dev, count(*) as tvip, substr(ds,1,10) as dateS
from tracks t
WHERE ds >= '2019-04-07'
AND   ds < '2019-04-08'
AND   application.business = 'mercadolibre'
AND   application.site_id in ('MLA','MLM','MLB','MPE','MCO','MLC','MLU','MLV')
and path in ('/vip')
and jest(event_data, 'vertical') = 'core'
and ((application.version rlike '(9\.29[0-9]*\.)|(9\.[3-9][0-9]\.)|(9\.[0-9]{3,}\.)|([1-9][0-9]{1,}\.[0-9]+\.)' and device.platform = '/mobile/android') or (application.version rlike '(10\.4[3-9]\.)|(10\.[4-9][3-9]\.)|(10\.[5-9][0-9]\.)|(10\.[0-9]{3,}\.)|([0-9]{3,}\.[0-9]+\.)|([1-9][1-9]\.[0-9]{1,}\.)' and device.platform = '/mobile/ios') or (device.platform LIKE '/web/desktop') or (device.platform LIKE '/web/mobile'))
and type = 'view'
group by application.site_id, device.platform, substr(ds,1,10)),
buyI as (
select application.site_id as sit, device.platform as dev, count(*) as tvip, substr(ds,1,10) as dateS
from tracks t
WHERE ds >= '2019-04-07'
AND   ds < '2019-04-08'
AND   application.business = 'mercadolibre'
AND   application.site_id in ('MLA','MLM','MLB','MPE','MCO','MLC','MLU','MLV')
and path in ('/vip/buy_action')
and jest(event_data, 'vertical') = 'core'
and ((application.version rlike '(9\.29[0-9]*\.)|(9\.[3-9][0-9]\.)|(9\.[0-9]{3,}\.)|([1-9][0-9]{1,}\.[0-9]+\.)' and device.platform = '/mobile/android') or (application.version rlike '(10\.4[3-9]\.)|(10\.[4-9][3-9]\.)|(10\.[5-9][0-9]\.)|(10\.[0-9]{3,}\.)|([0-9]{3,}\.[0-9]+\.)|([1-9][1-9]\.[0-9]{1,}\.)' and device.platform = '/mobile/ios') or (device.platform LIKE '/web/desktop') or (device.platform LIKE '/web/mobile'))
group by application.site_id, device.platform, substr(ds,1,10)),
cartI as (
select application.site_id as sit, device.platform as dev, count(*) as tvip, substr(ds,1,10) as dateS
from tracks t
WHERE ds >= '2019-04-07'
AND   ds < '2019-04-08'
AND   application.business = 'mercadolibre'
AND   application.site_id in ('MLA','MLM','MLB','MPE','MCO','MLC','MLU','MLV')
and path in ('/vip/add_cart_action')
and jest(event_data, 'vertical') = 'core'
and ((application.version rlike '(9\.29[0-9]*\.)|(9\.[3-9][0-9]\.)|(9\.[0-9]{3,}\.)|([1-9][0-9]{1,}\.[0-9]+\.)' and device.platform = '/mobile/android') or (application.version rlike '(10\.4[3-9]\.)|(10\.[4-9][3-9]\.)|(10\.[5-9][0-9]\.)|(10\.[0-9]{3,}\.)|([0-9]{3,}\.[0-9]+\.)|([1-9][1-9]\.[0-9]{1,}\.)' and device.platform = '/mobile/ios') or (device.platform LIKE '/web/desktop') or (device.platform LIKE '/web/mobile'))
group by application.site_id, device.platform, substr(ds,1,10)),
gratsCommon as (
select application.site_id as sit, device.platform as dev, count(*) as tvip, substr(ds,1,10) as dateS
from tracks t
WHERE ds >= '2019-04-07'
AND   ds < '2019-04-08'
AND   application.business = 'mercadolibre'
AND   application.site_id in ('MLA','MLM','MLB','MPE','MCO','MLC','MLU','MLV')
and path in ('/checkout/congrats')
and ((application.version rlike '(9\.29[0-9]*\.)|(9\.[3-9][0-9]\.)|(9\.[0-9]{3,}\.)|([1-9][0-9]{1,}\.[0-9]+\.)' and device.platform = '/mobile/android') or (application.version rlike '(10\.4[3-9]\.)|(10\.[4-9][3-9]\.)|(10\.[5-9][0-9]\.)|(10\.[0-9]{3,}\.)|([0-9]{3,}\.[0-9]+\.)|([1-9][1-9]\.[0-9]{1,}\.)' and device.platform = '/mobile/ios') or (device.platform LIKE '/web/desktop') or (device.platform LIKE '/web/mobile'))
and type = 'view'
group by application.site_id, device.platform, substr(ds,1,10)),
gratsCart as (
select application.site_id as sit, device.platform as dev, count(*) as tvip, substr(ds,1,10) as dateS
from tracks t
WHERE ds >= '2019-04-07'
AND   ds < '2019-04-08'
AND   application.business = 'mercadolibre'
AND   application.site_id in ('MLA','MLM','MLB','MPE','MCO','MLC','MLU','MLV')
and path in ('/cart/checkout/congrats')
and ((application.version rlike '(9\.29[0-9]*\.)|(9\.[3-9][0-9]\.)|(9\.[0-9]{3,}\.)|([1-9][0-9]{1,}\.[0-9]+\.)' and device.platform = '/mobile/android') or (application.version rlike '(10\.4[3-9]\.)|(10\.[4-9][3-9]\.)|(10\.[5-9][0-9]\.)|(10\.[0-9]{3,}\.)|([0-9]{3,}\.[0-9]+\.)|([1-9][1-9]\.[0-9]{1,}\.)' and device.platform = '/mobile/ios') or (device.platform LIKE '/web/desktop') or (device.platform LIKE '/web/mobile'))
and type = 'view'
group by application.site_id, device.platform, substr(ds,1,10))
select v.sit as site, v.dev as device, v.tvip as total_vips, bi.tvip as amount_buy, ci.tvip as amount_cart, gCo.tvip as amount_buy_real, gCa.tvip as amount_cart_real, v.dateS as ds
from vipsView v
join buyI bi on bi.sit = v.sit and bi.dev = v.dev
left join cartI ci on ci.sit = v.sit and ci.dev = v.dev
join gratsCommon gCo on gCo.sit = v.sit and gCo.dev = v.dev
left join gratsCart gCa on gCa.sit = v.sit and gCa.dev = v.dev
;