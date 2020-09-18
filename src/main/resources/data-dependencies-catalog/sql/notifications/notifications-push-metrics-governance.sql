SELECT summary.business AS marketplace,
  summary.site_id AS site_id,
  summary.path as path,
  summary.device_status as device_status,
  summary.has_user as has_user,
  summary.app_version as app_version,
  sum(summary.sent) AS sent,
  sum(summary.arrived) AS arrived,
  sum(summary.no_reason_discarded) AS no_reason_discarded,
  sum(summary.track_without_arrived) AS track_without_arrived,
  sum(summary.shown) AS shown,
  sum(summary.discarded) AS discarded,
  sum(summary.open) AS open,
  sum(summary.action_open) AS action_open,
  sum(summary.dismiss) AS dismiss,
  sum(summary.auto_dismiss) AS auto_dismiss,
  summary.fecha AS ds
FROM( SELECT DISTINCT SUBSTR(ds, 1, 10) AS fecha,
       application.business AS business,
       path,
       application.site_id as site_id,
       get_json_object(event_data, '$.news_id') as news_id,
       device.device_id as device_id,
       UPPER(COALESCE(get_json_object(event_data, '$.device_status'), 'ACTIVE')) as device_status,
       (CASE WHEN usr.user_id is not null OR TRIM(usr.user_id) <> '' THEN 'SI' ELSE 'NO' END) as has_user,
       CONCAT(regexp_extract(application.version, '(^[0-9]+\.[0-9]+)'), '|', device.platform) as app_version,
       1 AS sent,
       (CASE WHEN app_event.arrived != 0 THEN 1 ELSE 0 END) as arrived,
       (CASE WHEN app_event.no_reason_discarded != 0 AND app_event.arrived = 0 THEN 1 ELSE 0 END) as no_reason_discarded,
       (CASE WHEN app_event.usr_interaction != 0 AND app_event.arrived = 0 AND app_event.no_reason_discarded = 0 THEN 1 ELSE 0 END) as track_without_arrived,
       (CASE WHEN app_event.shown != 0 THEN 1 ELSE 0 END) as shown,
       (CASE WHEN app_event.discarded != 0 THEN 1 ELSE 0 END) as discarded,
       (CASE WHEN app_event.open != 0 THEN 1 ELSE 0 END) as open,
       (CASE WHEN app_event.action_open != 0 THEN 1 ELSE 0 END) as action_open,
       (CASE WHEN app_event.dismiss != 0 THEN 1 ELSE 0 END) as dismiss,
       (CASE WHEN app_event.auto_dismiss != 0 THEN 1 ELSE 0 END) as auto_dismiss
  FROM tracks
    LEFT JOIN (
        SELECT CONCAT(get_json_object(event_data, '$.device_id'), '-', get_json_object(event_data, '$.news_id')) AS event_id,
        SUM ( CASE WHEN get_json_object(event_data, '$.event_type') IN ('arrived') THEN 1 ELSE 0 END ) as arrived,
        SUM ( CASE WHEN get_json_object(event_data, '$.event_type') IN ('discarded') AND device.platform in ('/mobile/android') AND (get_json_object(event_data, '$.discard_reason') IS NULL OR TRIM(get_json_object(event_data, '$.discard_reason')) = '')  THEN 1 ELSE 0 END ) as no_reason_discarded,
        SUM ( CASE WHEN
                    get_json_object(event_data, '$.event_type') IN ('shown', 'auto_dismiss', 'open', 'action_open', 'swipe', 'dismiss')
                    OR (
                      get_json_object(event_data, '$.event_type') IN ('discarded') AND ( device.platform in ('/mobile/ios') OR
                      (get_json_object(event_data, '$.discard_reason') IS NOT NULL OR TRIM(get_json_object(event_data, '$.discard_reason')) <> ''))
        ) THEN 1 ELSE 0 END ) as usr_interaction,
        SUM ( CASE WHEN get_json_object(event_data, '$.event_type') IN ('shown') THEN 1 ELSE 0 END ) as shown,
        SUM ( CASE WHEN get_json_object(event_data, '$.event_type') IN ('discarded') AND ( device.platform in ('/mobile/ios') OR (get_json_object(event_data, '$.discard_reason') IS NOT NULL AND TRIM(get_json_object(event_data, '$.discard_reason')) <> '')) THEN 1 ELSE 0 END ) as discarded,
        SUM ( CASE WHEN get_json_object(event_data, '$.event_type') IN ('open') AND (get_json_object(event_data, '$.action_type') IS NULL OR TRIM(get_json_object(event_data, '$.action_type')) = '') THEN 1 ELSE 0 END ) as open,
        SUM ( CASE WHEN get_json_object(event_data, '$.event_type') IN ('action_open') OR (get_json_object(event_data, '$.event_type') IN ('open') AND get_json_object(event_data, '$.action_type') IS NOT NULL AND TRIM(get_json_object(event_data, '$.action_type')) <> '') THEN 1 ELSE 0 END ) as action_open,
        SUM ( CASE WHEN get_json_object(event_data, '$.event_type') IN ('dismiss') THEN 1 ELSE 0 END ) as dismiss,
        SUM ( CASE WHEN get_json_object(event_data, '$.event_type') IN ('auto_dismiss') THEN 1 ELSE 0 END ) as auto_dismiss
        FROM tracks
        WHERE ds >= '@send_date'
        AND ds < '@three_days_after_send_date'
        AND path LIKE '/notification/%'
        AND get_json_object(event_data, '$.news_id') IS NOT null
        AND get_json_object(event_data, '$.device_id') IS NOT null
        AND device.platform in ('/mobile/android', '/mobile/ios')
        AND application.business in ('mercadolibre', 'mercadopago', 'mercadoenvios')
        AND get_json_object(event_data, '$.event_type') NOT IN ('sent')
        GROUP BY get_json_object(event_data, '$.device_id'), get_json_object(event_data, '$.news_id')
  ) app_event ON app_event.event_id = CONCAT(device.device_id, '-', get_json_object(event_data, '$.news_id'))
  WHERE ds >= '@send_date'
  AND ds < '@one_day_after_send_date'
  AND path LIKE '/notification/%'
  AND get_json_object(event_data, '$.news_id') IS NOT null
  AND device.platform in ('/mobile/android', '/mobile/ios')
  AND application.business in ('mercadolibre', 'mercadopago', 'mercadoenvios')
  AND get_json_object(event_data, '$.event_type') IN ('sent')
) summary
GROUP BY summary.business, summary.fecha, summary.site_id, summary.path, summary.device_status, summary.has_user, summary.app_version