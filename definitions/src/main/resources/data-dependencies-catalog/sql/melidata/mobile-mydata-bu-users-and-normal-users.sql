select count (distinct usr) as total,
device.platform as platform,
path as path,
application.site_id as country,
substr(ds,1,10) as ds
from tracks 
  where (path = '/myml/company_profile' or path = '/myml/profile')
    AND ds >= '@param01'
    AND ds <= '@param02'
group by substr(ds,1,10), device.platform, application.site_id, path
order by substr(ds,1,10)