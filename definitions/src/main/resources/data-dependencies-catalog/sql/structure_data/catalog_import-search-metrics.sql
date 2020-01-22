SELECT
    t.id,
    t.path,
    application.server_poolname,
    usr.uid user_id,
    jest(event_data, 'query_filter') as query_filter,
    jest(event_data, 'domain_filter') as domain_filter,
    jest(event_data, 'limit_filter') as limit_filter,
    jest(event_data, 'product_id') as product_id,
    jest(event_data, 'product_source') as product_source,
    jest(event_data, 'product_external_id') as product_external_id,
    jest(event_data, 'external_domain') as external_domain,
    jest(event_data, 'predicted_domain') as predicted_domain,
    jest(event_data, 'selected_domain') as selected_domain,
    jest(event_data, 'external_attribute_key') as external_attribute_key,
    jest(event_data, 'external_attribute_value') as external_attribute_value,
    ds
FROM default.tracks t
WHERE t.path IN (
                 '/structure_data/catalog_search/query',
                 '/structure_data/catalog_search/wrong_domain_prediction',
                 '/structure_data/catalog_search/wrong_external_domain',
                 '/structure_data/catalog_search/wrong_external_attribute',
                 '/structure_data/catalog_search/copied_external_attribute'
    )
  AND ds >= '@param01' AND ds < '@param02';