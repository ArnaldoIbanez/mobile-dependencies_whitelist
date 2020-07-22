SELECT flow,
       Count(flow_init) AS flow_init,
       Count(flow_end)  AS flow_end,
       flow_from,
       site,
       business,
       platform,
       fecha
FROM   (SELECT  context.flow_id                            AS flow_id,
                CASE
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
                device.platform                            AS platform,
                application.site_id                        AS site,
                application.business                       AS business,
                Get_json_object(event_data, '$.flow_name') AS flow,
                Get_json_object (event_data, '$.from')     AS flow_from,
                Substr(ds, 1, 10)                          AS fecha
        FROM   tracks
        WHERE  ds >= '@param01'
               AND ds < '@param02'
               AND type = 'event'
               AND ( path = '/flow/init'
                      OR path = '/flow/end' )
               AND ( device.platform = '/mobile/android'
                      OR device.platform = '/mobile/ios' )
               AND Get_json_object(event_data, '$.flow_name') IS NOT NULL
        GROUP  BY context.flow_id,
                  device.platform,
                  application.site_id,
                  Get_json_object(event_data, '$.flow_name'),
                  Get_json_object(event_data, '$.from'),
                  application.business,
                  Substr(ds, 1, 10)) t1
GROUP  BY flow,
          flow_from,
          site,
          business,
          platform,
          fecha