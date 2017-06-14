SELECT COUNT(1) AS total, *
FROM (
 SELECT '@param01' AS fecha,
        split(path,'/')[3] AS notification_type,
        jet(event_data,'event_type') AS event_type,
        split(device.platform,'/')[3] AS platform,
        device.os_version AS os_version,
        application.site_id AS site,
        application.business AS marketplace,
        application.version AS app_version
 FROM tracks
 WHERE path LIKE '/notification/%'
 AND   ds >= '@param01'
 AND   ds < '@param02'
) t
GROUP BY t.notification_type, t.event_type, t.platform, t.os_version, t.site, t.marketplace, t.app_version, t.fecha