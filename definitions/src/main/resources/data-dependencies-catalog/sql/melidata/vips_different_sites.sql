select device.platform,
application.site_id,
count(distinct usr.user_id) as qty_users,
substr(ds, 1, 10)
from tracks
where ds >= '@param01' and ds < '@param02'
and application.site_id <> substr(jest(event_data,'item_id'),1,3)
and path = '/vip'
group by device.platform,
application.site_id,
substr(ds, 1, 10)