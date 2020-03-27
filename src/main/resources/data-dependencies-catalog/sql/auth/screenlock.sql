select
  device.platform as device_platform,
  site as site_id,
  application.version as app_version,
  bu as business,
  flow_id,
  os_status,
  count(distinct (
    case
      when path = '/screenlock/validation_start'
          then usr.user_id
          else null
    end)) as cant_validaciones_tot,
  count(distinct (
    case
      when path = '/screenlock/validation_start'
        and enrollment_status = 'enabled'
          then usr.user_id
          else null
    end)) as cant_enabled,
  count(distinct (
    case
      when path = '/screenlock/validation_end'
        and enrollment_status = 'enabled'
        and result = 'success'
        and flow_id != 'security-settings'
          then usr.user_id
          else null
    end)) as cant_enabled_success,
  count(distinct (
    case
      when flow_id = 'security-settings'
        and path = '/screenlock/validation_end'
        and result = 'success'
        and enrollment_status = 'disabled'
        and device.platform = '/mobile/android'
        and major <= '2'
        and minor < '99'
          then usr.user_id
          else null
    end)) as cant_enrollments_legacy_android,
  count(distinct (
    case
      when flow_id in ('security-settings', 'security_settings', 'auto_enrollment')
        and path = '/screenlock/validation_end'
        and result = 'success'
        and enrollment_status = 'enabled'
          then usr.user_id
          else null
    end)) as cant_enrollments,
  count(distinct (
    case
      when flow_id in ('security-settings', 'security_settings')
        and path = '/screenlock/validation_end'
        and result = 'success'
        and enrollment_status = 'enabled'
        and device.platform = '/mobile/android'
        and major <= '2'
        and minor < '99'
          then usr.user_id
          else null
    end)) as cant_unenrollments_legacy_android,
  count(distinct (
    case
      when path = '/security_settings/screenlock/toggle'
        and toggleaction = 'disable'
        and enrollment_status = 'disabled'
        and major >= '2'
        and minor >= '99'
          then usr.user_id
          else null
    end)) as cant_unenrollments,
  count(distinct (
    case
      when flow_id is null
        and enrollment_status = 'enabled'
        and device.platform = '/mobile/ios'
          then usr.user_id
          else null
    end)) as cant_enrollments_legacy_ios,
  count(distinct (
    case
      when flow_id is null
        and enrollment_status = 'disabled'
        and path = '/screenlock/validation_end'
        and device.platform = '/mobile/ios'
        and elapsed_time >= '1'
          then usr.user_id
          else null
    end)) as cant_unenrollments_legacy_ios,
  count(distinct (
    case
      when path = '/security_settings'
          then usr.user_id
          else null
    end)) as cant_ss_views,
  count(distinct (
    case
      when path = '/security_settings/screenlock'
          then usr.user_id
          else null
    end)) as cant_ss_biometrics_views,
  substr(ds, 1, 10) as ds
FROM ( SELECT
       ds,
       device,
       usr,
       path,
       application,
       site,
       bu,
       cast(split(application.version, '\\.')[0] as integer) as major,
       cast(split(application.version, '\\.')[1] as integer) as minor,
       cast(split(application.version, '\\.')[2] as integer) as patch,
       get_json_object(event_data, '$.flow_id') as flow_id,
       get_json_object(event_data, '$.enrollment_status') as enrollment_status,
       get_json_object(event_data, '$.result') as result,
       get_json_object(event_data, '$.os_status') as os_status,
       get_json_object(event_data, '$.elapsed_time') as elapsed_time,
       get_json_object(event_data, '$.action') as toggleaction
     from melidata.tracks_mp
     where 1 = 1
       and ds >= '@param01'
       and ds < '@param02'
       and device.platform in ('/mobile/android','/mobile/ios')
       and path in (
         '/security_settings/screenlock',
         '/security_settings',
         '/screenlock/validation_end',
         '/screenlock/validation_start',
         '/security_settings/screenlock/toggle')
       and bu = 'mercadopago'
       and site in('MLA','MLM','MLB')
   ) t1
where major >= '2'
and minor >= '96'
group by
  device.platform,
  site,
  application.version,
  bu,
  flow_id,
  os_status,
  substr(ds, 1, 10)
