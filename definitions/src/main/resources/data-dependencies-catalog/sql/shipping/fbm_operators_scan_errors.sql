select jest(event_data, 'first_name') as nombre,
jest(event_data, 'last_name') as apellido,
count(jest(event_data, 'first_name')) as cantidad
from tracks 
where path = '/wms/put_away'
and jest(event_data, 'feedback_type') = 'ERROR'
and jest(event_data, 'warehouse_id') = 'BRSP01' 
and ds >= '@param01'
and ds < '@param02'
group by jest(event_data, 'first_name'),
jest(event_data, 'last_name')
order by cantidad desc
