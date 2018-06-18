select substr(ds,1,10) as date_sent,
  path,
  get_json_object(event_data, '$.event_type') as event_type,
       application.site_id as site_id,
       usr.user_id as user_id
from tracks
where (ds >= '@param01' and ds <= '@param02')
      and device.platform = '/web/desktop'
      and path like '/notification_center/credits-consumer'