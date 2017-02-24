select substr(ds,1,10) as ds,
tracks.path as path, 
device.platform as platform,
count(distinct usr.user_id) as users
from tracks
where ds >= '@param01'
and ds < '@param02' 
and tracks.path in ('/home','/navigation','/notification_center','/vip','/search','/questions','/questions/answer/post','/notification/questions_new')
and device.platform in ('/mobile/android', '/mobile/ios')
and usr.user_id in (
  select
  distinct usr.user_id
  from tracks as t
  where t.ds >= '@param03'
  and t.ds < '@param04' 
  and type = 'event'
  and t.path = '/notification/campaigns_suggested_discounts_seller'
  and device.platform in ('/mobile/android', '/mobile/ios')
  and get_json_object(t.event_data,'$.context') = 'notification'
  and get_json_object(t.event_data,'$.event_type') = 'open'
)
group by substr(ds,1,10),tracks.path,device.platform; 