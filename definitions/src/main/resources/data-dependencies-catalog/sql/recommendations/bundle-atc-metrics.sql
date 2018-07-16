SELECT  application.site_id as site_id,
        jest(event_data, 'recommendations.client') as client_id,
        jest(event_data, 'recommendations.backend_id') as backend_id,
        SUM(CASE WHEN usr.user_id = NULL THEN 1 ELSE 0 END) unlogged_users_add_to_cart, 
        COUNT(1) all_add_to_cart, 
        AVG(SIZE(SPLIT(recommended_items,','))) as avg_items_added_to_cart,
        substr(ds,1,10) AS ds
FROM TRACKS 
LATERAL VIEW json_tuple(event_data, 'items') v as recommended_items 
WHERE path = '/recommendations/add_to_cart' 
AND JEST(event_data,'items') is not NULL 
AND DS >= '@param01' 
AND DS < '@param02'
GROUP BY application.site_id, ds, jest(event_data, 'recommendations.client'), jest(event_data, 'recommendations.backend_id')
ORDER BY ds
