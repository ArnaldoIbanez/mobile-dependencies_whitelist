SELECT ds,
       application.site_id site_id, 
       avg(size(json_to_array(jest(event_data,'recommendations.track_info.recommended_items')))) avg_items_quantity
FROM tracks 
WHERE path = '/vip'
AND jest(event_data, 'recommendations.client') = 'vip_combo'
AND jest(event_data, 'recommendations.track_info.has_recommendations') = 'true'
AND ds >= '@param01'
AND ds < '@param02'
GROUP BY application.site_id, ds
