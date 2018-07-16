SELECT  application.site_id as site_id,
        COUNT(1) total_vips,
        jest(event_data, 'recommendations.client') as client_id,
        jest(event_data, 'recommendations.backend_id') as backend_id,
        SUM(CASE WHEN jest(event_data, 'recommendations.track_info.has_recommendations') = 'true' THEN 1 ELSE 0 END) vips_with_bundle,
        SUM(CASE WHEN jest(event_data, 'recommendations.track_info.combo_type') = 'certified_in_fallback' THEN 1 ELSE 0 END) vips_with_certified_bundle,
        SUM(CASE WHEN jest(event_data, 'recommendations.track_info.combo_free_shipping') = 'true' THEN 1 ELSE 0 END) bundle_with_fs,
        SUM(CASE WHEN jest(event_data, 'recommendations.track_info.combo_free_shipping') = 'false' THEN 1 ELSE 0 END) bundle_with_saving,
        SUM(CASE WHEN jest(event_data, 'recommendations.track_info.has_recommendations') = 'true' AND
                      (
                        (application.site_id = 'MLB' AND (CAST(jest(event_data, 'recommendations.track_info.trigger.item_info.price') AS DECIMAL) >= 120)) OR
                        (application.site_id = 'MLM' AND (CAST(jest(event_data, 'recommendations.track_info.trigger.item_info.price') AS DECIMAL) >= 549)) OR
                        (application.site_id = 'MLA' AND (CAST(jest(event_data, 'recommendations.track_info.trigger.item_info.price') AS DECIMAL) >= 1400))
                      )
                      THEN 1 ELSE 0 END) as vips_with_bundle_fvf_value,
substr(ds,1,10) AS ds
FROM tracks
WHERE (path = '/vip' or path = '/cart/item_add' or path = '/recommendations')
and ds >= '@param01'
AND ds < '@param02'
and type = 'view'
and application.site_id IN ('MLM','MLB','MLA')
and jest(event_data,'cart_content') = 'true'
and jest(event_data, 'item_status') = 'active'
and jest(event_data, 'buying_mode') = 'buy_it_now'
and jest(event_data, 'shipping_mode') = 'me2'
and application.business = 'mercadolibre'
and not is_bot(device.user_agent)
GROUP BY application.site_id, ds, jest(event_data, 'recommendations.client'), jest(event_data, 'recommendations.backend_id')
ORDER BY substr(ds,1,10)
