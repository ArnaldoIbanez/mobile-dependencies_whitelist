SELECT  device.platform                     AS platform,
        application.site_id                 AS site,
        application.version                 AS version,
        application.business                AS business,
        count(1)                            AS incidents,
        get_json_object(event_data, '$.view_controller') AS warnings,
        Substr(ds, 1, 10)                   AS fecha
FROM tracks
WHERE ds >= '@param01'
AND ds < '@param02'
AND path = '/memory_warning'
AND (application.site_id = 'MLA'
  OR application.site_id = 'MCO'
  OR application.site_id = 'MLB'
  OR application.site_id = 'MLU'
  OR application.site_id = 'MLC'
  OR application.site_id = 'MPE'
  OR application.site_id = 'MLM' )
GROUP BY  application.version,
          application.business,
          application.site_id,
          device.platform,
          get_json_object(event_data, '$.view_controller'),
          ds