SELECT '@param03'  as fecha, COUNT(1) as total, temporal.campaign_batch, temporal.campaign_id, temporal.batch_id, 'android' as platform, temporal.site_id, temporal.marketplace
FROM (SELECT campaign_id,
                   site_id,
                   marketplace,
                   device_id,
                   ds,
                   batch_id,
                   campaign_batch
      FROM (SELECT s1.device.device_id AS device_id_purge
            FROM tracks AS s1
            WHERE s1.ds >= '@param03' 
            AND   s1.ds < '@param01' 
            AND   s1.path LIKE '/notification/%'
            AND   jest(s1.event_data,'event_type') = 'purged_token'
            AND   s1.device.platform = '/mobile/android') AS t1,
           (SELECT application.site_id AS site_id,
                   application.business AS marketplace,
                   jest(s2.event_data,'device_id') AS device_id,
                   jest(s2.event_data,'batch_id') AS batch_id,
                   jest(s2.event_data,'campaign_id') AS campaign_id,
                   CONCAT(jest(s2.event_data,'campaign_id'), '-', jest(s2.event_data,'batch_id')) as campaign_batch,
                   ds
            FROM tracks s2
            WHERE s2.ds >= '@param03'
            AND   s2.ds < '@param02'
            AND   s2.path = '/notification/campaigns_campaigns'
            AND   jest(s2.event_data,'event_type') = 'shown'
            AND   (jest(s2.event_data,'test_notification') = 'false' OR jest(s2.event_data,'test_notification') is NULL)
            and s2.device.platform = '/mobile/android') t2
      WHERE t1.device_id_purge = t2.device_id) AS temporal
WHERE ds in (SELECT MAX(t.ds)
            FROM tracks t
            WHERE t.ds >= '@param03'
            AND   t.ds < '@param02'
            AND   jest(t.event_data,'event_type') = 'shown'
            AND   t.path = '/notification/campaigns_campaigns'
            AND   jest(t.event_data,'device_id') = temporal.device_id
            AND   t.device.platform = '/mobile/android') 
GROUP BY temporal.campaign_batch, temporal.campaign_id, temporal.batch_id, temporal.site_id, temporal.marketplace