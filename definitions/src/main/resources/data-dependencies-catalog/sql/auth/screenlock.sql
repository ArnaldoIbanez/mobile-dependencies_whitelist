select
  device.platform as device_platform,
  application.site_id as site_id,
  application.version as app_version,
  application.business as business,
  flow_id,
  os_status,
  count(distinct (case when path = '/screenlock/validation_start' then usr.user_id else null end)) as cant_validaciones_tot,
  count(distinct (case when path = '/screenlock/validation_start' and enrollment_status = 'enabled' then usr.user_id else null end)) as cant_enabled,
  count(distinct (case when path = '/screenlock/validation_end' and enrollment_status = 'enabled' and result = 'success' then usr.user_id else null end)) as cant_enabled_success,
  count(distinct (case when flow_id = 'security-settings' and path = '/screenlock/validation_end' and result = 'success' and enrollment_status = 'disabled' and application.version < '2.99.0' then usr.user_id  else null end)) as cant_enrollments_legacy_android,
    count(distinct (case when flow_id = 'security-settings' and path = '/screenlock/validation_end' and result = 'success' and enrollment_status = 'enabled' then usr.user_id  else null end)) as cant_enrollments,
  count(distinct (case when flow_id = 'security-settings' and path = '/screenlock/validation_end' and result = 'success' and enrollment_status = 'enabled' and application.version < '2.99.0' then usr.user_id  else null end)) as cant_unenrollments_legacy_android,
  count(distinct (case when flow_id = 'security-settings' and path = '/screenlock/validation_end' and result = 'success' and enrollment_status = 'disabled' then usr.user_id  else null end)) as cant_unenrollments,
  count(distinct (case when flow_id is null and enrollment_status = 'enabled' then usr.user_id else null end)) as cant_enrollments_legacy_ios,
  count(distinct (case when flow_id is null and enrollment_status = 'disabled' and path = '/screenlock/validation_end' and elapsed_time >= '1' then usr.user_id else null end)) as cant_unenrollments_legacy_ios,
  count(distinct (case when path = '/security_settings' then usr.user_id else null end)) as cant_ss_views,
  count(distinct (case when path = '/security_settings/screenlock' then usr.user_id else null end)) as cant_ss_biometrics_views,
  ds
from
   (
     select
       ds,
       device,
       usr,
       path,
       application,
       get_json_object(event_data, '$.flow_id') as flow_id,
       get_json_object(event_data, '$.enrollment_status') as enrollment_status,
       get_json_object(event_data, '$.result') as result,
       get_json_object(event_data, '$.os_status') as os_status,
       get_json_object(event_data, '$.elapsed_time') as elapsed_time
     from tracks
     where 1 = 1
       and ds >= '@param01'
       and ds < '@param02'
       and device.platform in ('/mobile/android','/mobile/ios')
       and path in (
         '/security_settings/screenlock',
         '/security_settings',
         '/screenlock/validation_end',
         '/screenlock/validation_start',
         '/security_settings/screenlock/toggle'
       )
       and application.version >= '2.93.0'
       and application.business = 'mercadopago'
       and application.site_id in ('MLA','MLM','MLB')
   ) t1
group by
  device.platform,
  application.site_id,
  application.version,
  application.business,
  flow_id,
  os_status,
  ds
