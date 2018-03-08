SELECT  ds,
        application.site_id as site_id, 
        SUM(CASE WHEN jest(event_data, 'recommendations.track_info.has_recommendations') = 'true' THEN 1 ELSE 0 END) vips_with_bundle,
        SUM(CASE WHEN jest(event_data, 'recommendations.track_info.has_recommendations') = 'true' AND
                      (
                        (application.site_id = 'MLB' AND (CAST(jest(event_data, 'recommendations.track_info.trigger.item_info.price') AS DECIMAL) >= 120)) OR
                        (application.site_id = 'MLM' AND (CAST(jest(event_data, 'recommendations.track_info.trigger.item_info.price') AS DECIMAL) >= 549))
                      ) 
                      THEN 1 ELSE 0 END) as vips_with_bundle_fvf_value,
        COUNT(1) total_vips
FROM tracks
WHERE path = '/vip'
AND jest(event_data, 'recommendations.client') = 'vip_combo'
AND ds >= '@param01'
AND ds < '@param02'
GROUP BY application.site_id
