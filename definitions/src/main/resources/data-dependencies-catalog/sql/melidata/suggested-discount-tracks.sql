select substr(ds,1,10) as ds,
tracks.path as path,
device.platform as platform,
type as type,
get_json_object(tracks.event_data,'$.item_id') as item_id,
get_json_object(tracks.event_data,'$.selected_discount') as selected_discount,
get_json_object(tracks.event_data,'$.discount_status') as discount_status,
get_json_object(tracks.event_data,'$.action') as action,
get_json_object(tracks.event_data,'$.onboarding_step') as onboarding_step,
count(distinct usr.user_id) as distinct_user_count
from tracks
where ds >= '@param01'
and ds <= '@param02'
and tracks.path like '/myml/suggested_discounts%'
group by substr(ds,1,10), device.platform, type, tracks.path, get_json_object(tracks.event_data,'$.event_data')
order by substr(ds,1,10), device.platform, type, tracks.path, get_json_object(tracks.event_data,'$.event_data');