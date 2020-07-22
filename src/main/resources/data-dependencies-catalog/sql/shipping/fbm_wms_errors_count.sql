select
jest(event_data, 'warehouse_id') as warehouse,
path,
count(*) as cantidad,
jest(event_data, 'feedback_type') as feedback_type,
jest(event_data, 'error_type') as error_type,
substr(ds,1,10) as fecha
from melidata.tracks_me
where path like '/wms/%'
and ds >= '@param01'
and ds < '@param02'
and site in ('MLB','MLA','MLM','MLC','MCO')
and device.platform = '/mobile/android'
and (jest(event_data, 'feedback_type') is not null or jest(event_data, 'error_type') is not null)
group by path, jest(event_data, 'feedback_type'), jest(event_data, 'error_type'), jest(event_data, 'warehouse_id'), substr(ds,1,10)
