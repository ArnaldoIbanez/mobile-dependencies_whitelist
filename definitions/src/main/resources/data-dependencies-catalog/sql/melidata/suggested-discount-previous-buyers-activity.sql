select substr(ds,1,10) as ds,
application.site_id as siteId,
tracks.path as path, 
device.platform as platform,
usr.user_id as userId,  
get_json_object(tracks.event_data,'$.item_id') as itemId
from tracks
where ds >= '2017-02-28'
and ds < '2017-03-01' 
and path in ('/orders/ordercreated', '/questions/ask/post', '/bookmarks/action/post', '/vip/buy_intention', '/home', '/search', '/vip')
and device.platform in ('/mobile/android', '/mobile/ios')
and usr.user_id in (
  select distinct usr.user_id
  from tracks as t
  where t.ds >= '2017-03-01'
  and t.ds < '2017-03-02' 
  and type = 'event' 
  and device.platform in ('/mobile/android', '/mobile/ios')
  and t.path = '/notification/campaigns_suggested_discounts_buyer'
  and get_json_object(t.event_data,'$.context') = 'notification'
  and get_json_object(t.event_data,'$.event_type') = 'open'
)
group by ds,application.site_id,tracks.path,device.platform,usr.user_id,get_json_object(tracks.event_data,'$.item_id')