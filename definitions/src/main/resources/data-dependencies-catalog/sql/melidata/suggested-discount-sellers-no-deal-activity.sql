select substr(ds,1,10) as ds, 
tracks.path as path, 
device.platform as platform,
usr.user_id as userId,  
get_json_object(tracks.event_data,'$.item_id') as itemId
from tracks
where ds >= '2017-02-26'
and ds < '2017-03-01' 
and path in ('/home','/notification_center','/vip','/search','/questions','/questions/answer/post','/notification/questions_new')
and device.platform in ('/mobile/android', '/mobile/ios')
and usr.user_id in (
  select distinct usr.user_id
  from tracks as t
  where t.ds >= '2017-02-27'
  and t.ds < '2017-02-28' 
  and t.path = '/myml/suggested_discounts/landing'
)
group by ds,tracks.path,device.platform,usr.user_id,get_json_object(tracks.event_data,'$.item_id');