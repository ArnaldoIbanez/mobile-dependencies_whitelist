SELECT
    t.id,
    t.server_timestamp,
    jest(t.event_data,'query_filter') as query_filter,
    jest(t.event_data,'domain_filter') as domain_filter,
    jest(t.event_data,'input_filter') as input_filer,
    t.application,
    t.usr
FROM default.tracks t
WHERE t.path = '/structure_data/catalog_search/query'
  AND ds >= '@param01' AND ds < '@param02';