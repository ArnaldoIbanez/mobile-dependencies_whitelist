SELECT '@param01' AS fecha, COUNT(1) as total, temporal.notification_type_purge, temporal.notification_type, temporal.platform, temporal.site_id, temporal.marketplace
FROM (SELECT *
      FROM (SELECT split(path,'/')[2] AS notification_type_purge,
                   json_extract_scalar(s1.event_data,'$.device_id') AS device_id_purge
            FROM tracks AS s1
            WHERE s1.ds >= '@param03'
            AND   s1.ds < '@param02'
            AND   s1.path LIKE '/notification/%'
            AND   json_extract_scalar(s1.event_data,'$.event_type') = 'purged_token') AS t1,
           (SELECT split(path,'/')[2] AS notification_type,
                   split(device.platform,'/')[2] AS platform,
                   application.site_id AS site_id,
                   application.business AS marketplace,
                   json_extract_scalar(s2.event_data,'$.device_id') AS device_id,
                   ds
            FROM tracks s2
            WHERE s2.ds >= '@param03'
            AND   s2.ds < '@param01'
            AND   s2.path LIKE '/notification/%'
            AND   json_extract_scalar(s2.event_data,'$.event_type') = 'shown') t2
      WHERE t1.device_id_purge = t2.device_id) AS temporal
WHERE ds = (SELECT MAX(ds)
            FROM tracks
            WHERE ds >= '@param03'
            AND   ds < '@param01'
            AND   path LIKE '/notification/%'
            AND   json_extract_scalar(event_data,'$.event_type') = 'shown'
            AND   json_extract_scalar(event_data,'$.device_id') = temporal.device_id)
GROUP BY temporal.notification_type_purge, temporal.notification_type, temporal.platform, temporal.site_id, temporal.marketplace
