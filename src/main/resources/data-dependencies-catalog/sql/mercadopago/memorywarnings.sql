SELECT DISTINCT(warnings),
      state,
      sum(incidents) as incidents,
      platform,
      version,
      business,
      fecha
FROM (SELECT  DISTINCT(Jest(event_data, 'view_controller')) AS warnings,
              Jest(event_data, 'application_state') AS state
              count(Jest(event_data, 'view_controller')) AS incidents,
              device.platform AS platform,
              concat(split_part(application.version, '.',1),'.', split_part(application.version, '.',2)) AS version,
              application.business AS business,
              Substr(ds, 1, 10)  AS fecha
        FROM tracks
        WHERE ds >= '@param01'
        AND ds < '@param02'
        AND path = '/memory_warning'
        GROUP BY  Jest(event_data, 'view_controller'),
                  Jest(event_data, 'application_state'),
                  device.platform,
                  application.version,
                  application.business,
                  ds)
GROUP BY warnings, state, platform,version,business,fecha
ORDER BY version, state, warnings
