select
  device.platform as device_platform,
  site as site_id,
  application.version as app_version,
  bu as business,
  flow_id,
  os_status,
  patot.risk_level as risk_level,
  approx_count_distinct (
    case
      when path = '/screenlock/validation_start'
          then usr.user_id
          else null
    end) as cant_validaciones_tot,
  approx_count_distinct (
    case
      when path = '/screenlock/validation_start'
        and enrollment_status = 'enabled'
          then usr.user_id
          else null
    end) as cant_enabled,
  approx_count_distinct (
    case
      when path = '/screenlock/validation_end'
        and enrollment_status = 'enabled'
        and result = 'success'
        and flow_id != 'security-settings'
          then usr.user_id
          else null
    end) as cant_enabled_success,
  approx_count_distinct (
    case
      when flow_id = 'security-settings'
        and path = '/screenlock/validation_end'
        and result = 'success'
        and enrollment_status = 'disabled'
        and device.platform = '/mobile/android'
        and (bu = 'mercadopago' and major = '2' and minor < '99')
          then usr.user_id
          else null
    end) as cant_enrollments_legacy_android,
  approx_count_distinct (
    case
      when flow_id in ('security-settings', 'security_settings', 'auto_enrollment')
        and path = '/screenlock/validation_end'
        and result = 'success'
        and enrollment_status = 'enabled'
          then usr.user_id
          else null
    end) as cant_enrollments,
  approx_count_distinct (
    case
      when flow_id in ('security-settings', 'security_settings')
        and path = '/screenlock/validation_end'
        and result = 'success'
        and enrollment_status = 'enabled'
        and device.platform = '/mobile/android'
        and (bu = 'mercadopago' and major = '2' and minor < '99')
          then usr.user_id
          else null
    end) as cant_unenrollments_legacy_android,
  approx_count_distinct (
    case
      when path = '/security_settings/screenlock/toggle'
        and toggleaction = 'disable'
        and enrollment_status = 'disabled'
        and not (bu = 'mercadopago' and major = '2' and minor < '99')
          then usr.user_id
          else null
    end) as cant_unenrollments,
  approx_count_distinct (
    case
      when flow_id is null
        and enrollment_status = 'enabled'
        and device.platform = '/mobile/ios'
          then usr.user_id
          else null
    end) as cant_enrollments_legacy_ios,
  approx_count_distinct (
    case
      when flow_id is null
        and enrollment_status = 'disabled'
        and path = '/screenlock/validation_end'
        and device.platform = '/mobile/ios'
        and elapsed_time >= '1'
          then usr.user_id
          else null
    end) as cant_unenrollments_legacy_ios,
  approx_count_distinct (
    case
      when path = '/security_settings'
          then usr.user_id
          else null
    end) as cant_ss_views,
  approx_count_distinct (
    case
      when path = '/security_settings/screenlock'
          then usr.user_id
          else null
    end) as cant_ss_biometrics_views,
  substr(ds, 1, 10) as ds
FROM ( SELECT
       ds,
       device,
       usr,
       path,
       application,
       application.site_id as site,
       application.business as bu,
       cast(split(application.version, '\\.')[0] as integer) as major,
       cast(split(application.version, '\\.')[1] as integer) as minor,
       cast(split(application.version, '\\.')[2] as integer) as patch,
       get_json_object(event_data, '$.flow_id') as flow_id,
       get_json_object(event_data, '$.enrollment_status') as enrollment_status,
       get_json_object(event_data, '$.result') as result,
       get_json_object(event_data, '$.os_status') as os_status,
       get_json_object(event_data, '$.elapsed_time') as elapsed_time,
       get_json_object(event_data, '$.action') as toggleaction
     from tracks
     where 1 = 1
       and ds >= '@param01'
       and ds < '@param02'
       and device.platform in ('/mobile/android','/mobile/ios')
       and application.business in ('mercadopago', 'mercadolibre')
       and application.site_id in('MLA','MLM','MLB','MLU','MLC','MPE','MCO')
       and path in (
         '/security_settings/screenlock',
         '/security_settings',
         '/screenlock/validation_end',
         '/screenlock/validation_start',
         '/security_settings/screenlock/toggle')
   ) t1 left outer join (
        select
          user_id,
          site_id,
          max(risk_level) as risk_level,
          max(ds) as ts
        from accountsecurity.mods_patot_users
          where ds >= '@param03'
          and ds < '@param02'
        group by
          user_id,
          site_id
      ) patot on t1.usr.user_id = patot.user_id
where not (bu = 'mercadopago' and major = '2' and minor < '96')
group by
  device.platform,
  site,
  application.version,
  bu,
  flow_id,
  os_status,
  patot.risk_level,
  substr(ds, 1, 10)
