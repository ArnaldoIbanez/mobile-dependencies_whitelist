select
  substr(ds, 1, 10)              as date_sent,
  path,
  jest(event_data, 'event_type') as event_type,
  jest(event_data, 'context')    as context,
  application.site_id            as site_id,
  usr.user_id                    as user_id,
  device.platform                as platform,
  device.device_name             as device_name
from tracks
where
  ((type = 'event'
    and (device.platform = '/mobile/android' or device.platform = '/mobile/ios' or device.platform = '/web/mobile')
    and (path like '/notification/credits_consumer%' or path like '/notification/credits-consumer%')
    and (jest(event_data, 'context') = 'notification'
         or jest(event_data, 'context') = 'notification_center')
    and (jest(event_data, 'event_type') = 'shown'
         or jest(event_data, 'event_type') = 'open')))
  and (ds >= '@param01' and ds < '@param02')