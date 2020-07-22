SELECT COUNT(1) AS total, *
FROM (
 SELECT '@param01' AS fecha,
        jet(event_data,'event_type') AS event_type,
        split(device.platform,'/')[2] AS platform,
        device.os_version AS os_version,
        application.site_id AS site_id,
        application.business AS marketplace,
        application.version AS app_version,
        jet(event_data,'action_type') AS action_type,
        CONCAT(jest(event_data,'campaign_id'), '-', jest(event_data,'batch_id')) as campaign_batch,
        jest(event_data,'batch_id') as batch_id,
        jest(event_data,'campaign_id') as campaign_id
 FROM tracks
 WHERE
 ds >= '@param01'
 AND   ds < '@param02'
 AND  path = '/notification/campaigns_campaigns'
 and device.platform = '/mobile/android'
 AND (jest(event_data,'context') is null OR jest(event_data,'context') != 'notification_center')
) t
GROUP BY t.fecha, t.campaign_batch, t.campaign_id, t.batch_id, t.event_type, t.platform, t.os_version, t.site_id, t.marketplace, t.app_version, t.action_type