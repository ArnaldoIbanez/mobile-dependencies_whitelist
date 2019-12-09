select
  usr.user_id as user_id,
  path,
  device.platform as device_platform,
  application.site_id as site_id,
  application.version as app_version,
  application.business as business,
  get_json_object(event_data, '$.flow_id') as flow_id,
  get_json_object(event_data, '$.enrollment_status') as enrollment_status,
  get_json_object(event_data, '$.result') as result,
  get_json_object(event_data, '$.os_status') as os_status,
  get_json_object(event_data, '$.elapsed_time') as elapsed_time,
  ds
from
   (
     select
       ds,
       device,
       usr,
       path,
       event_data,
       application
     from tracks
     where 1 = 1
       and ds >= '@param01'
       and ds < '@param02'
       and path in (
         '/security_settings/screenlock',
         '/screenlock/validation_end',
         'screenlock/validation_start',
         '/security_settings/screenlock/toggle')
       and device.platform in ('/mobile/android', '/mobile/ios')
       and application.version >= '2.93.0'
       and application.business = 'mercadopago'
       and application.site_id in ('MLA','MLM','MLB')
   ) t1
