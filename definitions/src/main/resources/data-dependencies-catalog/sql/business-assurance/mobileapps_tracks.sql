select substr(ds,1,10) as date_utc_4,
       application.site_id as site_id,
       path as path,
       application.version as app_version,
       application.business as business,
       device.platform as platform , count (*) as count_
from tracks
where type = 'view'
   AND (device.platform like '/mobile/android' or device.platform like '/mobile/ios')
   and ds >= '@param01'
   and ds < '@param02'
GROUP BY substr(ds,1,10), application.site_id, path, application.version, application.business, device.platform