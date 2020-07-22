SELECT warnings,
      state,
      sum(incidents) as incidents,
      platform,
      version,
      business,
      fecha
FROM (SELECT  Get_json_object(event_data, '$.view_controller') AS warnings,
              Get_json_object(event_data, '$.application_state') AS state,
              count(Get_json_object(event_data, '$.view_controller')) AS incidents,
              Substring(device.platform, 9, 16) AS platform,
              substring_index(application.version, '.',2) AS version,
              application.business AS business,
              Substr(ds, 1, 10)  AS fecha
        FROM tracks
        WHERE ds >= '@param01'
        AND ds < '@param02'
        AND path = '/memory_warning'
        AND ( device.platform = '/mobile/ios'
          OR device.platform = '/mobile/android' )
        GROUP BY  Get_json_object(event_data, '$.view_controller'),
                  Get_json_object(event_data, '$.application_state'),
                  device.platform,
                  application.version,
                  application.business,
                  ds) t1
GROUP BY warnings, state, platform,version,business,fecha
ORDER BY version, state, warnings