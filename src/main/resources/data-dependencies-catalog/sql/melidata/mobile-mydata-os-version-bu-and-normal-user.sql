select count (distinct usr.user_id) as total,
device.platform as platform,
path as path,
device.os_version as osversion,
application.site_id as country,
substr(ds,1,10) as ds
from tracks 
  where (path = '/myml/company_profile' or path = '/myml/profile')
    AND ds >= '@param01'
    AND ds <= '@param02'
group by substr(ds,1,10), device.platform, application.site_id, device.os_version, path