select
summary.marketplace AS marketplace,
summary.site_id AS site_id,
summary.path AS path,
summary.has_user AS has_user,
summary.app_version AS app_version,
summary.platform AS platform,
summary.source AS source,
summary.last_seen AS last_seen,
summary.current_checking_day AS current_checking_day,
summary.execution_id AS execution_id,
CASE
 WHEN (summary.free_storage*100)/summary.total_storage < 10 THEN '< 10%'
 WHEN (summary.free_storage*100)/summary.total_storage < 25 THEN '< 25%'
 WHEN (summary.free_storage*100)/summary.total_storage < 50 THEN '< 50%'
 WHEN (summary.free_storage*100)/summary.total_storage < 75 THEN '< 75%'
 ELSE '>= 75%'
END AS free_storage_percentage,
count(*) AS cantidad,
summary.fecha AS ds
from (
  SELECT DISTINCT
  SUBSTR(ds, 1, 10) AS fecha,
  application.business AS marketplace,
  application.site_id AS site_id,
  path AS path,
  device.device_id AS device_id,
  usr.advertiser_id AS advertising_id,
  (CASE WHEN usr.user_id IS NOT NULL OR TRIM(usr.user_id) <> '' THEN 'SI' ELSE 'NO' END) AS has_user,
  usr.user_id AS user_id,
  regexp_extract(application.version, '(^[0-9]+\.[0-9]+)') AS app_version,
  device.platform AS platform,
  get_json_object(event_data, '$.source') AS source,
  get_json_object(event_data, '$.last_seen') AS last_seen,
  get_json_object(event_data, '$.current_checking_day') AS current_checking_day,
  get_json_object(event_data, '$.execution_id') AS execution_id,
  CAST(get_json_object(event_data, '$.app_storage') AS BIGINT) as app_storage,
  CAST(get_json_object(event_data, '$.free_storage') AS BIGINT) as free_storage,
  CAST(get_json_object(event_data, '$.total_storage') AS BIGINT) as total_storage
  from tracks
  WHERE ds >= '@date'
  AND ds < '@one_day_after_date'
  AND path IN ('/application/uninstall_event', '/application/not_engaged')
  AND application.business IN ('mercadolibre', 'mercadopago')
  AND device.platform IN ('/mobile/android', '/mobile/ios')
  AND get_json_object(event_data, '$.app_storage') IS NOT NULL
  AND get_json_object(event_data, '$.free_storage') IS NOT NULL
  AND get_json_object(event_data, '$.total_storage') IS NOT NULL
) summary
GROUP BY summary.marketplace, summary.site_id, summary.path, summary.has_user, summary.app_version, summary.platform, summary.source, summary.last_seen, summary.current_checking_day, summary.execution_id, summary.fecha,
CASE
 WHEN (summary.free_storage*100)/summary.total_storage < 10 THEN '< 10%'
 WHEN (summary.free_storage*100)/summary.total_storage < 25 THEN '< 25%'
 WHEN (summary.free_storage*100)/summary.total_storage < 50 THEN '< 50%'
 WHEN (summary.free_storage*100)/summary.total_storage < 75 THEN '< 75%'
 ELSE '>= 75%'
END