SELECT 
tracks.path AS path, 
jest(tracks.event_data, 'user_action') action,   
jest(tracks.event_data, 'session_id') session, 
jest(tracks.event_data, 'item_id') item, 
jest(tracks.event_data, 'category_domain') domain, 
jest(tracks.event_data, 'attribute') attribute, 
jest(tracks.event_data, 'type') hintType, 
application.site_id AS site,
usr.user_id AS user,
substr(ds,1,10) AS date
FROM tracks 
WHERE tracks.path LIKE '/seller_central/%/technical_specifications/hints/%' 
AND ds >= '@from'
AND ds < '@to'
AND type = 'event'
AND application.business = 'mercadolibre';
