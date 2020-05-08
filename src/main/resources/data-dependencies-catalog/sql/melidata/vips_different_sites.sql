select device.platform,
site,
approx_count_distinct(usr.user_id) as qty_users,
substr(ds, 1, 10)
from melidata.tracks_ml
where ds >= '@param01' and ds < '@param02'
and bu = 'mercadolibre'
and site <> substr(jest(event_data,'item_id'),1,3)
and path = '/vip'
group by device.platform,
application.site_id,
substr(ds, 1, 10)