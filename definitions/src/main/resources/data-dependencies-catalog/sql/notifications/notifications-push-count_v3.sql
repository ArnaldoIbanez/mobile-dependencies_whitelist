SELECT summary.business AS marketplace, summary.event AS event, summary.site_id AS site_id, summary.path as path, sum(summary.total) AS total, summary.fecha AS ds
FROM
( SELECT application.business AS business, '@send_date' AS fecha, jest(event_data, 'event_type') AS event, application.site_id as site_id, path, 1 AS total
  FROM tracks
  WHERE ds >= '@send_date'
  AND ds < '@one_day_after_send_date'
  AND path LIKE '/notification/%'
  AND jest(event_data, 'news_id') IS NOT null
  AND device.platform = '/mobile/android'
  AND application.business in ('mercadopago', 'mercadolibre')
  AND jest(event_data, 'event_type') IN ('sent')
  GROUP BY application.business, jest(event_data, 'news_id'), device.device_id, jest(event_data, 'event_type'), application.site_id, path
  UNION ALL
  SELECT application.business AS business, '@send_date' AS fecha, jest(event_data, 'event_type') AS event, application.site_id as site_id, path, count(*) AS total
  FROM tracks
  INNER JOIN (
      SELECT CONCAT(application.business, '-',device.device_id,'-', jest(event_data, 'news_id')) AS event_id
      FROM tracks
      WHERE ds >= '@send_date'
      AND ds < '@one_day_after_send_date'
      AND path LIKE '/notification/%'
      AND jest(event_data, 'news_id') IS NOT null
      AND device.platform = '/mobile/android'
      AND application.business IN ('mercadopago', 'mercadolibre')
      AND jest(event_data, 'event_type') IN ('sent', 'resent')
  ) sents ON sents.event_id = CONCAT(application.business, '-',jest(event_data, 'device_id'),'-', jest(event_data, 'news_id'))
  WHERE ds >= '@send_date'
  AND ds < '@three_days_after_send_date'
  AND path LIKE '/notification/%'
  AND jest(event_data, 'news_id') IS NOT null
  AND jest(event_data, 'device_id') IS NOT null
  AND device.platform = '/mobile/android'
  AND application.business IN ('mercadopago', 'mercadolibre')
  AND (
        jest(event_data, 'event_type') IN ('arrived')
        OR
        (jest(event_data, 'event_type') IN ('discarded') AND (jest(event_data, 'discard_reason') IS null OR jest(event_data, 'discard_reason') = ''))
      )
  GROUP BY application.business, '@send_date', jest(event_data, 'event_type'), application.site_id, path
  UNION ALL
  SELECT application.business AS business, '@send_date' AS fecha, 'track_without_arrived' AS event, application.site_id as site_id, path, count(*) AS total
  FROM tracks
  INNER JOIN (
      SELECT CONCAT(application.business, '-',device.device_id,'-', jest(event_data, 'news_id')) AS event_id
      FROM tracks
      WHERE ds >= '@send_date'
      AND ds < '@one_day_after_send_date'
      AND path LIKE '/notification/%'
      AND jest(event_data, 'news_id') IS NOT null
      AND device.platform = '/mobile/android'
      AND application.business IN ('mercadopago', 'mercadolibre')
      AND jest(event_data, 'event_type') IN ('sent', 'resent')
  ) sents ON sents.event_id = CONCAT(application.business, '-',jest(event_data, 'device_id'),'-', jest(event_data, 'news_id'))
  LEFT JOIN (
      SELECT CONCAT(application.business, '-',device.device_id,'-', jest(event_data, 'news_id')) AS event_id
      FROM tracks
      WHERE ds >= '@send_date'
      AND ds < '@three_days_after_send_date'
      AND path LIKE '/notification/%'
      AND jest(event_data, 'news_id') IS NOT null
      AND jest(event_data, 'device_id') IS NOT null
      AND device.platform = '/mobile/android'
      AND application.business IN ('mercadopago', 'mercadolibre')
      AND (
            jest(event_data, 'event_type') IN ('arrived')
            OR
            (jest(event_data, 'event_type') IN ('discarded') AND (jest(event_data, 'discard_reason') IS null OR jest(event_data, 'discard_reason') = ''))
          )
  ) arrives ON arrives.event_id = CONCAT(application.business, '-',device.device_id,'-', jest(event_data, 'news_id'))
  WHERE ds >= '@send_date'
  AND ds < '@three_days_after_send_date'
  AND path LIKE '/notification/%'
  AND jest(event_data, 'news_id') IS NOT null
  AND jest(event_data, 'device_id') IS NOT null
  AND device.platform = '/mobile/android'
  AND application.business IN ('mercadopago', 'mercadolibre')
  AND (
        jest(event_data, 'event_type') IN ('shown', 'auto_dismiss', 'open', 'action_open', 'swipe', 'dismiss')
        OR
        (jest(event_data, 'event_type') IN ('discarded') AND (jest(event_data, 'discard_reason') IS NOT null or jest(event_data, 'discard_reason') != ''))
      )
  AND arrives.event_id IS null
  GROUP BY application.business, '@send_date', 'track_without_arrived', application.site_id, path
  UNION ALL
  SELECT application.business AS business, '@send_date' AS fecha, jest(event_data, 'event_type') AS event, application.site_id as site_id, path, 1 AS total
  FROM tracks
  INNER JOIN (
      SELECT CONCAT(application.business, '-',device.device_id,'-', jest(event_data, 'news_id')) AS event_id
      FROM tracks
      WHERE ds >= '@send_date'
      AND ds < '@one_day_after_send_date'
      AND path LIKE '/notification/%'
      AND jest(event_data, 'news_id') IS NOT null
      AND device.platform = '/mobile/android'
      AND application.business IN ('mercadopago', 'mercadolibre')
      AND jest(event_data, 'event_type') IN ('sent')
  ) resent ON resent.event_id = CONCAT(application.business, '-',device.device_id,'-', jest(event_data, 'news_id'))
  WHERE ds >= '@send_date'
  AND ds < '@one_day_after_send_date'
  AND path LIKE '/notification/%'
  AND jest(event_data, 'news_id') IS NOT null
  AND device.platform = '/mobile/android'
  AND application.business in ('mercadopago', 'mercadolibre')
  AND jest(event_data, 'event_type') IN ('resent')
  GROUP BY application.business, jest(event_data, 'news_id'), device.device_id, jest(event_data, 'event_type'), application.site_id, path
) summary
GROUP BY summary.business, summary.event, summary.fecha, summary.site_id, summary.path