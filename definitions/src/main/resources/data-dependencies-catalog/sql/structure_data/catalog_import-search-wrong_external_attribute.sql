SELECT
    t.id,
    t.server_timestamp,
    jest(t.event_data,'product_id') as product_id,
    jest(t.event_data,'product_source') as product_source,
    jest(t.event_data,'product_external_id') as product_external_id,
    jest(t.event_data,'external_attribute_key') as external_attribute_key,
    jest(t.event_data,'external_attribute_value') as external_attribute_value,
    jest(t.application, 'server_poolname') as server_poolname,
    jest(t.usr, 'uid') as user_id,
FROM default.tracks t
WHERE t.path = '/structure_data/catalog_search/wrong_external_attribute'
  AND ds >= '@param01' AND ds < '@param02';