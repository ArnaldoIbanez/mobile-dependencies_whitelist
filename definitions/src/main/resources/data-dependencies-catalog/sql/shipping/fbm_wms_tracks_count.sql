select
jest(event_data, 'warehouse_id') as warehouse,
path,
count(*) as cantidad,
substr(ds,1,10) as fecha
from tracks
where path like '/wms/%'
and ds >= '@param01'
and ds < '@param02'
group by path, jest(event_data, 'warehouse_id'), substr(ds,1,10)