select substr(ds,1,10) as ds,
application.site_id as siteId,
tracks.path as path,
device.platform as platform,  
usr.user_id as userId, 
get_json_object(tracks.event_data,'$.event_type') AS event_type
from tracks
where ds >= '2017-02-01'
and ds < '2017-03-14' 
and type = 'event'
and tracks.path in ('/notification/campaigns_suggested_discounts_seller','/notification/campaigns_suggested_discounts_buyer')
and get_json_object(tracks.event_data,'$.context') = 'notification'
and device.platform in ('/mobile/android', '/mobile/ios')
group by substr(ds,1,10), application.site_id, tracks.path, device.platform, usr.user_id, get_json_object(tracks.event_data,'$.event_type')
order by substr(ds,1,10), application.site_id, tracks.path, device.platform, usr.user_id, event_type;

