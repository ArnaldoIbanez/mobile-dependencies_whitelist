SELECT COUNT(1) AS total, *
FROM (
 SELECT '@param01' AS fecha,
        split(path,'/')[2] AS notification_type,
        jet(event_data,'event_type') AS event_type,
        split(device.platform,'/')[2] AS platform,
        device.os_version AS os_version,
        application.site_id AS site,
        application.business AS marketplace,
        application.version AS app_version,
        jet(event_data,'action_type') AS action_type
 FROM tracks
 WHERE path LIKE '/notification/%'
 AND   ds >= '@param01'
 AND   ds < '@param02'
 AND (jest(event_data,'context') is null OR jest(event_data,'context') != 'notification_center')
) t
GROUP BY t.fecha, t.notification_type, t.event_type, t.platform, t.os_version, t.site, t.marketplace, t.app_version, t.action_type