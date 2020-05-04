SELECT  count(Jest(event_data, 'view_controller')) AS incidents,
        Jest(event_data, 'view_controller') AS warnings,
        application.site_id AS site,
        device.platform AS platform,
        application.version AS version,
        application.business AS business,
        Substr(ds, 1, 10)  AS fecha
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
GROUP BY  Jest(event_data, 'view_controller'),
          application.site_id,
          device.platform,
          application.version,
          application.business,
          ds
ORDER BY 1 DESC