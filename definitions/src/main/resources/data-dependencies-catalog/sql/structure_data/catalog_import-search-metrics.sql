SELECT
    t.id,
    t.event_type,
    t.server_timestamp,
    jest(t.application, 'server_poolname') as server_poolname,
    jest(t.usr, 'uid') as user_id,
    jest(t.event_data,'query_filter') as query_filter,
    jest(t.event_data,'domain_filter') as domain_filter,
    jest(t.event_data,'limit_filter') as limit_filter,
    jest(t.event_data,'product_id') as product_id,
    jest(t.event_data,'product_source') as product_source,
    jest(t.event_data,'product_external_id') as product_external_id,
    jest(t.event_data,'external_domain') as external_domain,
    jest(t.event_data,'predicted_domain') as predicted_domain,
    jest(t.event_data,'selected_domain') as selected_domain,
    jest(t.event_data,'external_attribute_key') as external_attribute_key,
    jest(t.event_data,'external_attribute_value') as external_attribute_value
FROM default.tracks t
WHERE t.path IN (
                 '/structure_data/catalog_search/query',
                 '/structure_data/catalog_search/wrong_domain_prediction',
                 '/structure_data/catalog_search/wrong_external_domain',
                 '/structure_data/catalog_search/wrong_external_attribute',
                 '/structure_data/catalog_search/copied_external_attribute'
    )
  AND ds >= '@param01' AND ds < '@param02';