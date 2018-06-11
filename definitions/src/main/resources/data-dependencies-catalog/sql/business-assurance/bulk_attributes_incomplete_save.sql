SELECT
substr(ds,1,10) as fecha,
GET_JSON_OBJECT(tracks.event_data, '$.campaignId') as campaignId,
SUM(GET_JSON_OBJECT(tracks.event_data, '$.totalItems')) as totalItems,
SUM(GET_JSON_OBJECT(tracks.event_data, '$.updatedItems')) as updatedItems,
COUNT(distinct usr.user_id) as users,
GET_JSON_OBJECT(tracks.event_data, '$.badItems') as badItems
FROM tracks
WHERE tracks.path = '/bulk_attributes/incomplete/save'
AND ds >= '@param01' AND ds < '@param02'
AND GET_JSON_OBJECT(tracks.event_data, '$.badItems') IN ('true', 'false')
AND application.business='mercadolibre'
AND type='event'
GROUP BY GET_JSON_OBJECT(tracks.event_data, '$.campaignId'), GET_JSON_OBJECT(tracks.event_data, '$.badItems'), substr(ds, 1, 10)
