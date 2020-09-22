SELECT summary.business AS marketplace,
  summary.site_id AS site_id,
  summary.path as path,
  sum(summary.sent) AS sent,
  sum(summary.arrived) AS arrived,
  sum(summary.discarded) AS discarded,
  sum(summary.resent) AS resent,
  sum(summary.track_without_arrived) AS track_without_arrived,
  summary.fecha AS ds
FROM( SELECT DISTINCT SUBSTR(ds, 1, 10) AS fecha,
       application.business AS business,
       path,
       application.site_id as site_id,
       jest(event_data, 'news_id') as news_id,
       device.device_id as device_id,
       1 AS sent,
       (CASE WHEN app_event.arrived != 0 THEN 1 ELSE 0 END) as arrived,
       (CASE WHEN app_event.discarded != 0 AND app_event.arrived = 0 THEN 1 ELSE 0 END) as discarded,
       (CASE WHEN app_event.usr_interaction != 0 AND app_event.arrived = 0 AND app_event.discarded = 0 THEN 1 ELSE 0 END) as track_without_arrived,
       (CASE WHEN app_event.resent != 0 THEN 1 ELSE 0 END) as resent
  FROM tracks
    LEFT JOIN (
        SELECT CONCAT(jest(event_data, 'device_id'), '-', jest(event_data, 'news_id')) AS event_id,
        SUM ( CASE WHEN jest(event_data, 'event_type') IN ('arrived') THEN 1 ELSE 0 END ) as arrived,
        SUM ( CASE WHEN jest(event_data, 'event_type') IN ('discarded') AND (jest(event_data, 'discard_reason') IS null OR jest(event_data, 'discard_reason') = '')  THEN 1 ELSE 0 END ) as discarded,
        SUM ( CASE WHEN
                    jest(event_data, 'event_type') IN ('shown', 'auto_dismiss', 'open', 'action_open', 'swipe', 'dismiss')
                    OR (
                      jest(event_data, 'event_type') IN ('discarded') AND
                      (jest(event_data, 'discard_reason') IS NOT null OR jest(event_data, 'discard_reason') != '')
        ) THEN 1 ELSE 0 END ) as usr_interaction,
        SUM ( CASE WHEN jest(event_data, 'event_type') IN ('resent') THEN 1 ELSE 0 END ) as resent
        FROM tracks
        WHERE ds >= '@send_date'
        AND ds < '@three_days_after_send_date'
        AND path LIKE '/notification/%'
        AND jest(event_data, 'news_id') IS NOT null
        AND jest(event_data, 'device_id') IS NOT null
        AND device.platform = '/mobile/android'
        AND application.business IN ('mercadopago', 'mercadolibre')
        AND jest(event_data, 'event_type') NOT IN ('sent')
        GROUP BY jest(event_data, 'device_id'), jest(event_data, 'news_id')
  ) app_event ON app_event.event_id = CONCAT(device.device_id, '-', jest(event_data, 'news_id'))
  WHERE ds >= '@send_date'
  AND ds < '@one_day_after_send_date'
  AND path LIKE '/notification/%'
  AND jest(event_data, 'news_id') IS NOT null
  AND device.platform = '/mobile/android'
  AND application.business in ('mercadopago', 'mercadolibre')
  AND jest(event_data, 'event_type') IN ('sent')
) summary
GROUP BY summary.business, summary.fecha, summary.site_id, summary.path
