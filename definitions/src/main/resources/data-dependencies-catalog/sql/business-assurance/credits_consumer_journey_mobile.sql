select substr(ds,1,10) as date_sent, path, get_json_object(event_data, '$.event_type') as event_type,
  get_json_object(event_data, '$.context') as context ,
       application.site_id as site_id,
       usr.user_id as user_id,
       device.platform as platform,
       device.device_name as device_name
from tracks
where
  ((type = 'event'
    and (device.platform = '/mobile/android' or device.platform ='/mobile/ios' or device.platform = '/web/mobile')
    and (path like '/notification/credits_consumer%' or path like '/notification/credits-consumer%')
    and (get_json_object(event_data, '$.context') = 'notification'
         or get_json_object(event_data, '$.context') = 'notification_center')
    and (get_json_object(event_data, '$.event_type') = 'shown'
         or get_json_object(event_data, '$.event_type') = 'open'))
   or (path like '/credits/consumer/payinstallment/on_time' or path like '/credits/consumer/payinstallment/on_time/pay'
    or path like '/credits/consumer/payinstallment/late_pay' or path like '/credits/consumer/payinstallment/late_pay/pay'
    or path like '/credits/consumer/payinstallment/payed')) and (ds >= '@param01' and ds <= '@param02')