select substr(ds,1,10) as ds,
tracks.path as path,
device.platform as platform,
get_json_object(tracks.event_data,'$.event_type') AS event_type,
count(distinct usr.user_id) as distinct_user_count
from tracks
where ds >= '@param01'
and ds <= '@param02' 
and type = 'event'
and tracks.path in ('/notification/campaigns_suggested_discounts_seller','/notification/campaigns_suggested_discounts_buyer')
and get_json_object(tracks.event_data,'$.context') = 'notification'
and device.platform in ('/mobile/android', '/mobile/ios')
group by substr(ds,1,10), tracks.path, device.platform, get_json_object(tracks.event_data,'$.event_type')
order by substr(ds,1,10), tracks.path, device.platform, get_json_object(tracks.event_data,'$.event_type');