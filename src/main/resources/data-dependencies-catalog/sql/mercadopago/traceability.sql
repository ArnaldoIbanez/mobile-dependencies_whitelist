SELECT MP_FLOW_INIT.usuario   AS usuario,
       mp_flow_init.flow_init AS flow_init,
       mp_flow_end.flow_end   AS flow_end,
       MP_FLOW_INIT.platform  AS platform,
       MP_FLOW_INIT.site      AS site,
       MP_FLOW_INIT.version   AS version,
       MP_FLOW_INIT.flow_name AS flow,
       mp_flow_init.flow_id   AS flow_id,
       MP_FLOW_INIT.flow_from AS flow_from,
       MP_FLOW_INIT.business  AS business,
       MP_FLOW_INIT.fecha     AS fecha
FROM   (SELECT Substr(ds, 1, 10)               AS fecha,
               Count(DISTINCT context.flow_id) AS flow_init,
               context.flow_id                 AS flow_id,
               device.platform                 AS platform,
               application.site_id             AS site,
               application.version             AS version,
               get_json_object(event_data, '$.flow_name')   AS flow_name,
               get_json_object(event_data, '$.from')       AS flow_from,
               usr.user_id                     AS usuario,
               application.business            AS business
        FROM   tracks
        WHERE  ds >= '@param01'
               AND ds < '@param02'
               AND type = 'event'
               AND path = '/flow/init'
               AND application.site_id IN ( 'MLA', 'MLB', 'MLC', 'MLM',
                                            'MCO', 'MLU', 'MPE' )
        GROUP  BY Substr(ds, 1, 10),
                  context.flow_id,
                  device.platform,
                  application.site_id,
                  application.version,
                  application.business,
                  get_json_object(event_data, '$.flow_name'),
                  get_json_object(event_data, '$.from'), usr.user_id) AS mp_flow_init
       LEFT JOIN (SELECT Substr(ds, 1, 10)                AS fecha,
                         Count(DISTINCT context.flow_id)  AS flow_end,
                         context.flow_id                  AS flow_id
                  FROM   tracks
                  WHERE  ds >= '@param01'
                         AND ds < '@param02'
                         AND type = 'event'
                         AND path = '/flow/end'
                         AND application.site_id IN ( 'MLA', 'MLB', 'MLC', 'MLM',
                                                      'MCO', 'MLU', 'MPE' )
                  GROUP  BY Substr(ds, 1, 10),
                            context.flow_id) AS mp_flow_end
              ON mp_flow_init.flow_id = mp_flow_end.flow_id
GROUP  BY MP_FLOW_INIT.fecha,
          MP_FLOW_INIT.usuario,
          MP_FLOW_INIT.platform,
          MP_FLOW_INIT.site,
          MP_FLOW_INIT.version,
          MP_FLOW_INIT.flow_name,
          MP_FLOW_INIT.flow_init,
          MP_FLOW_END.flow_end,
          MP_FLOW_INIT.flow_id,
          MP_FLOW_INIT.flow_from,
          MP_FLOW_INIT.business
ORDER  BY fecha,
          usuario,
          platform,
          site,
          version,
          flow_id