select substr(t.fecha,1,10) AS ds, count(*) as total, t.event_type as event_type, t.marketplace as marketplace from 
  (SELECT application.business as marketplace, SUBSTRING (ds, 1, 10) AS fecha, jest(event_data, 'event_type') as event_type
  FROM tracks
  WHERE ds >= '@param01'
  AND ds < '@param02'
  AND path like '/notification/%'
  AND jet(event_data, 'news_id') is not null
  AND path not in ('/notification/health_check', '/notification/messages_read', '/notification/campaigns-control_group', '/notification/security_event_feedback')
  and device.platform = '/mobile/android'
  and (
        jet(event_data, 'event_type') in ('sent', 'arrived') 
        or 
        (jet(event_data, 'event_type') in ('discarded') and jet(event_data, 'discard_reason') is null)
      )
  UNION ALL
  SELECT application.business as marketplace, SUBSTRING (ds, 1, 10) as fecha, 'not_arrived_track' as event_type
  FROM tracks
  WHERE ds >= '@param01'
  AND ds < '@param02'
  AND path like '/notification/%'
  AND jet(event_data, 'news_id') is not null
  AND path not in ('/notification/health_check', '/notification/messages_read', '/notification/campaigns-control_group', '/notification/security_event_feedback')
  and device.platform = '/mobile/android'
  and (
        jest(event_data, 'event_type') in ('shown', 'auto_dismiss', 'open', 'action_open', 'swipe', 'dismiss') 
        or 
        (jest(event_data, 'event_type') in ('discarded') and jet(event_data, 'discard_reason') is not null)
      ) 
  AND CONCAT(application.business, '-',device.device_id,'-', jest(event_data, 'news_id')) not in (
                                                              SELECT CONCAT(application.business, '-',device.device_id,'-', jet(event_data, 'news_id'))
                                                              FROM tracks
                                                               WHERE ds >= '@param01'
                                                               AND ds < '@param02'
                                                               AND jet(event_data, 'news_id') is not null
                                                              AND path like '/notification/%'
                                                              AND path not in ('/notification/health_check', '/notification/messages_read', '/notification/campaigns-control_group', '/notification/security_event_feedback')
                                                              and device.platform = '/mobile/android'
                                                              and (
                                                                    jest(event_data, 'event_type') in ('arrived') 
                                                                    or 
                                                                    (jest(event_data, 'event_type') in ('discarded') and jet(event_data, 'discard_reason') is null)
                                                                  )
  )
) t GROUP BY t.marketplace, t.fecha, t.event_type