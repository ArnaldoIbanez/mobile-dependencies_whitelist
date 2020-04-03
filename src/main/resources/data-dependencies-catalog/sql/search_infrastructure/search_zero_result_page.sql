select 
application.site_id as site_id,
sum (CASE When get_json_object(event_data, '$.query') is not null Then 1 Else 0 End) as total_query ,
sum (CASE When get_json_object(event_data, '$.results') = '[]' Then 1 Else 0 End ) as total_zrp,
max (substr(ds,1,10)) AS ds
from default.tracks
where path = '/search' 
and type = 'view'
and ds >= '@param1 00'
and ds < '@param2 00'
and NOT is_bot(device.user_agent)
and get_json_object(event_data, '$.query') is not null
and get_json_object(event_data, '$.tracking_id') is not null
group by application.site_id