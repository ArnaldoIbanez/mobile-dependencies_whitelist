SELECT '@param03' AS fecha, COUNT(1) as total, temporal.notification_type, 'android', temporal.site_id, temporal.marketplace
FROM (SELECT shown_table.notification_type,
             shown_table.platform,
             shown_table.site_id,
             shown_table.marketplace,
             shown_table.device_id,
             shown_table.ds
      FROM (SELECT s1.device.device_id AS device_id_purge
            FROM tracks AS s1
            WHERE s1.ds >= '@param03'
            AND   s1.ds < '@param01'
            AND   s1.path LIKE '/notification/%'
            AND   jest(s1.event_data,'event_type') = 'purged_token'
            AND   s1.device.platform = '/mobile/android') AS purged_table,
           (SELECT split(path,'/')[2] AS notification_type,
                   split(device.platform,'/')[2] AS platform,
                   application.site_id AS site_id,
                   application.business AS marketplace,
                   jest(s2.event_data,'device_id') AS device_id,
                   ds
            FROM tracks s2
            WHERE s2.ds >= '@param03'
            AND   s2.ds < '@param02'
            AND   s2.path LIKE '/notification/%'
            AND   jest(s2.event_data,'event_type') = 'shown'
            AND   (jest(s2.event_data,'test_notification') = 'false' OR jest(s2.event_data,'test_notification') is NULL)
            AND   s2.device.platform = '/mobile/android') shown_table
      WHERE purged_table.device_id_purge = shown_table.device_id) AS temporal
WHERE ds in (SELECT MAX(t.ds)
            FROM tracks t
            WHERE t.ds >= '@param03'
            AND   t.ds < '@param02'
            AND   t.path LIKE '/notification/%'
            AND   jest(t.event_data,'event_type') = 'shown'
            AND   t.device.platform = '/mobile/android'
            AND   jest(t.event_data,'device_id') = temporal.device_id)
GROUP BY temporal.notification_type, temporal.platform, temporal.site_id, temporal.marketplace
