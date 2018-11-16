select
jest(event_data, 'warehouse_id') as warehouse,
path,
count(*) as cantidad
from tracks
where path like '/wms/%'
and ds >= '@param01'
and ds < '@param02'
group by jest(event_data, 'warehouse_id'), path
order by cantidad desc