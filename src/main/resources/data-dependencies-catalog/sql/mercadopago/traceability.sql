SELECT  CASE
          WHEN Count(CASE
                        WHEN ( path = '/flow/init' AND Get_json_object(event_data, '$.flow_name') IS NOT NULL )
                        THEN context.flow_id END) >= 1
          THEN '1'
        END                                        AS flow_init,
        CASE
          WHEN Count(CASE
                        WHEN ( path = '/flow/end' AND Get_json_object(event_data, '$.flow_name') IS NOT NULL )
                        THEN context.flow_id END) >= 1
          THEN '1'
        END                                        AS flow_end,
        Substring(device.platform, 9, 16)          AS platform,
        application.site_id                        AS site,
        application.business                       AS business,
        Get_json_object(event_data, '$.flow_name') AS flow,
        Get_json_object (event_data, '$.from')     AS flow_from,
        Substr(ds, 1, 10)                          AS fecha
FROM   default.tracks
WHERE  ds >= '@param01'
       AND ds < '@param02'
       AND type = 'event'
       AND ( path = '/flow/init'
              OR path = '/flow/end' )
       AND ( device.platform = '/mobile/android'
              OR device.platform = '/mobile/ios' )
       AND Get_json_object(event_data, '$.flow_name') IS NOT NULL
GROUP  BY Get_json_object(event_data, '$.flow_name'),
          Substring(device.platform, 9, 16),
          application.site_id,
          Get_json_object(event_data, '$.from'),
          application.business,
          Substr(ds, 1, 10)