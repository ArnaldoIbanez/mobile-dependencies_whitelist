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
  jest(event_data, 'source') AS source,
  jest(event_data, 'last_seen') AS last_seen,
  jest(event_data, 'current_checking_day') AS current_checking_day,
  jest(event_data, 'execution_id') AS execution_id
  from tracks
  WHERE ds >= '@date'
  AND ds < '@one_day_after_date'
  AND path IN ('/application/uninstall_event', '/application/not_engaged')
  AND application.business IN ('mercadolibre', 'mercadopago')
  AND device.platform IN ('/mobile/android', '/mobile/ios')
) summary
GROUP BY summary.marketplace, summary.site_id, summary.path, summary.has_user, summary.app_version, summary.platform, summary.source, summary.last_seen, summary.current_checking_day, summary.execution_id, summary.fecha