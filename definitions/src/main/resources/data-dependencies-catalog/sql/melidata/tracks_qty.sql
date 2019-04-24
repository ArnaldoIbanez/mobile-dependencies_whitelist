select 
application.sdk_version['js_version'] as js_version,
application.sdk_version['node_version'] as node_version,
application.sdk_version['grails_version'] as grails_version,
application.server_poolname,
device.platform,
application.site_id,
application.business,
count(0) as qty_tracks,
date_part(ds) as day
from tracks
where ds >= '@param01' and ds < '@param02'
and device.platform in ('/web/mobile', '/web/desktop')
group by
application.sdk_version['js_version'],
application.server_poolname,
application.sdk_version['node_version'],
application.sdk_version['grails_version'],
device.platform,
application.site_id,
application.business,
date_part(ds)
