select 
ds as fecha,
path as path,
jest(event_data, 'item_id') as item_id,
jest(event_data, 'typification') as typification,
jest(event_data, 'money_refund') as payment,
jest(event_data, 'pickup_option') as shipping,
jest(event_data, 'pickup_time') as pickup_time,
device.platform as platform,
application.site_id as site,
usr.user_id as user_id,
usr.user_nick as user_nick
from tracks 
where 
path like '/return/congrats' 
and ds >= '@param01' 
and ds < '@param02'
and usr.user_nick not like 'TETE%'
and usr.user_nick not like 'TT%'
and usr.user_nick not like 'TEST%'
and usr.user_nick not like 'BUYER%'