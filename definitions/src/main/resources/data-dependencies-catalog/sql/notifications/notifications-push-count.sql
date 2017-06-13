SELECT
    count(*) AS total,
    current_date AS fecha,
    split(path,'/')[3] AS notification_type,
    jet(event_data,'event_type') AS event_type,
    split(device.platform,'/')[3] AS platform,
    device.os_version,
    application.site_id,
    application.business AS marketplace,
    application.version AS app_version
FROM tracks
WHERE
    path LIKE '/notification/%'
    AND ds >= '@param01'
    and ds < '@param02'
GROUP BY 3,4,5,6,7,8,9