SELECT
substr(ds,1,10) as fecha,
GET_JSON_OBJECT(event_data, '$.category_domain') as category_domain,
GET_JSON_OBJECT(event_data, '$.category_id') as category_id,
GET_JSON_OBJECT(event_data, '$.session_id') as session_id,
GET_JSON_OBJECT(event_data, '$.is_custom_name') as is_custom_name
FROM tracks
WHERE path = '/sell/update/color_selection/custom_color'
AND ds >= '@param01' AND ds < '@param02'
AND application.business='mercadolibre'
AND type='event'
GROUP BY GET_JSON_OBJECT(event_data, '$.session_id'),GET_JSON_OBJECT(event_data, '$.is_custom_name'),
GET_JSON_OBJECT(event_data, '$.category_id'),GET_JSON_OBJECT(event_data, '$.category_domain'),
substr(ds, 1, 10)

