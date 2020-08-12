SELECT  Get_json_object(event_data, '$.type_track') AS type_track,
        count(Get_json_object(event_data, '$.type_track')) AS count_track,
        application.site_id AS site,
        Substring(device.platform, 9, 16) AS platform,
        substring_index(application.version, '.',2) AS version,
        Substr(ds, 1, 10)  AS fecha
FROM default.tracks
WHERE ds >= '2020-07-30'
AND ds < '2020-07-31'
AND path LIKE '%/apprater%'
AND application.business = 'mercadopago'
AND (device.platform = '/mobile/ios'
  OR device.platform = '/mobile/android' )
GROUP BY  Get_json_object(event_data, '$.type_track'),
          application.site_id,
          Substring(device.platform, 9, 16),
          substring_index(application.version, '.',2),
          Substr(ds, 1, 10)
