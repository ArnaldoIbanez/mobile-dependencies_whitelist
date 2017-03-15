select substr(ds,1,10) as ds,
application.site_id as siteId,
tracks.path as path,
device.platform as platform,
usr.user_id as userId,
type as type,
get_json_object(tracks.event_data,'$.item_id') as item_id,
get_json_object(tracks.event_data,'$.selected_discount') as selected_discount,
get_json_object(tracks.event_data,'$.discount_status') as discount_status,
get_json_object(tracks.event_data,'$.action') as action,
get_json_object(tracks.event_data,'$.onboarding_step') as onboarding_step
from tracks
where ds >= '2017-03-13'
and ds < '2017-03-15' 
and tracks.path like '/myml/suggested_discounts%'
group by substr(ds,1,10), application.site_id, device.platform,  usr.user_id, type, tracks.path, get_json_object(tracks.event_data,'$.item_id'), get_json_object(tracks.event_data,'$.selected_discount'), get_json_object(tracks.event_data,'$.discount_status'), get_json_object(tracks.event_data,'$.action'), get_json_object(tracks.event_data,'$.onboarding_step')
order by substr(ds,1,10), application.site_id, device.platform,  usr.user_id, type, tracks.path, item_id, selected_discount, discount_status, action, onboarding_step;
