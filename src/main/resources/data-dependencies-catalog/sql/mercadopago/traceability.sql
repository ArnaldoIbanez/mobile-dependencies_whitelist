SELECT  DISTINCT(flow),
        count(flow_init)                                        AS flow_init,
        count(flow_end)                                           AS flow_end,
        flow_from,
        site,
        business,
        platform,
        fecha
FROM (  SELECT  DISTINCT( context.flow_id )                     AS flow_id,
                CASE
                    WHEN Count( CASE
                                  WHEN ( path = '/flow/init' AND Jest(event_data, 'flow_name') IS NOT NULL )
                                  THEN context.flow_id
                                END) >= 1
                    THEN '1'
                END                                             AS flow_init,
                CASE
                    WHEN Count( CASE
                                  WHEN ( path = '/flow/end' AND Jest(event_data, 'flow_name') IS NOT NULL )
                                  THEN context.flow_id
                                END) >= 1
                    THEN '1'
                END                                             AS flow_end,
                device.platform                                 AS platform,
                application.site_id                             AS site,
                -- application.version                             AS version,
                application.business                            AS business,
                Jest(event_data, 'flow_name')                   AS flow,
                Jest (event_data, 'from')                       AS flow_from,
                Substr(ds, 1, 10)                               AS fecha
        FROM    tracks
        WHERE  ds >= '@param01'
        AND ds < '@param02'
        AND type = 'event'
        AND ( path = '/flow/init'
          OR path = '/flow/end' )
        AND ( device.platform = '/mobile/android'
          OR device.platform = '/mobile/ios' )
        AND Jest(event_data, 'flow_name') IS NOT NULL
        GROUP  BY context.flow_id,
                  device.platform,
                  application.site_id,
                  Jest(event_data, 'flow_name'),
                  Jest(event_data, 'from'),
                  application.business,
                  Substr(ds, 1, 10)
)
GROUP BY  flow, flow_from, site, business, platform, fecha