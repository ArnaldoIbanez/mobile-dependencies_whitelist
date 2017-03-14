select substr(ds,1,10) as ds,
application.site_id as siteId,
tracks.path as path, 
device.platform as platform,
usr.user_id as userId,  
get_json_object(tracks.event_data,'$.item_id') as itemId
from tracks
where ds >= '2017-03-02'
and ds < '2017-03-03' 
and path in ('/home', '/search', '/vip', '/vip/buy_intention', '/notification_center', '/notification/questions_new', '/questions/answer/post', '/orders/ordercreated', '/bookmarks/action/post')
and device.platform in ('/mobile/android', '/mobile/ios')
and usr.user_id in (
  select distinct usr.user_id
  from tracks as t
  where t.ds >= '2017-03-01'
  and t.ds < '2017-03-02' 
  and t.path = '/myml/suggested_discounts/landing'
)
group by ds,application.site_id,tracks.path,device.platform,usr.user_id,get_json_object(tracks.event_data,'$.item_id');