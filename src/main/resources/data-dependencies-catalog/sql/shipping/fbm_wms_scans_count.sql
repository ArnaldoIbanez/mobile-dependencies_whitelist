select
jest(event_data, 'warehouse_id') as warehouse,
path,
jest(event_data, 'context') as context,
jest(event_data, 'source') as source,
count(*) as cantidad,
substr(ds,1,10) as fecha
from melidata.tracks_me
where path = '/wms/scan'
and ds >= '@param01'
and ds < '@param02'
and site in ('MLB','MLA','MLM','MLC','MCO')
and device.platform = '/mobile/android'
group by jest(event_data, 'context'),
  jest(event_data, 'source'),
  jest(event_data, 'warehouse_id'),
  path,
  substr(ds,1,10)