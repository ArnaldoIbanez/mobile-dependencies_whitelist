SELECT
    t.id,
    t.path,
    application.server_poolname,
    usr.uid user_id,
    get_json_object(event_data, '$.query_filter') as query_filter,
    get_json_object(event_data, '$.domain_filter') as domain_filter,
    get_json_object(event_data, '$.limit_filter') as limit_filter,
    get_json_object(event_data, '$.product_id') as product_id,
    get_json_object(event_data, '$.product_source') as product_source,
    get_json_object(event_data, '$.product_external_id') as product_external_id,
    get_json_object(event_data, '$.external_domain') as external_domain,
    get_json_object(event_data, '$.predicted_domain') as predicted_domain,
    get_json_object(event_data, '$.selected_domain') as selected_domain,
    get_json_object(event_data, '$.external_attribute_key') as external_attribute_key,
    get_json_object(event_data, '$.external_attribute_value') as external_attribute_value,
    SUBSTR(ds, 1, 10) as ds
FROM default.tracks t
WHERE t.path IN (
                 '/structure_data/catalog_search/query',
                 '/structure_data/catalog_search/wrong_domain_prediction',
                 '/structure_data/catalog_search/wrong_external_domain',
                 '/structure_data/catalog_search/wrong_external_attribute',
                 '/structure_data/catalog_search/copied_external_attribute'
    )
  AND ds >= '@param01' AND ds < '@param02';