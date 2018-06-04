SELECT
substr(ds,1,10) as fecha,
GET_JSON_OBJECT(tracks.event_data, '$.campaignId') as campaignId,
GET_JSON_OBJECT(tracks.event_data, '$.totalItems') as totalItems,
GET_JSON_OBJECT(tracks.event_data, '$.updatedItems') as updatedItems,
GET_JSON_OBJECT(tracks.event_data, '$.badItems') as badItems
FROM tracks
WHERE tracks.path = '/bulk_attributes/incomplete/save'
AND ds >= '@param01' AND ds < '@param02'
AND application.business='mercadolibre'
AND type='event'