SELECT
  get_json_object(event_data, '$.item_id') itemId,
  cast(get_json_object(event_data, '$.quantity') as int) newValuesQty,
  cast(get_json_object(event_data, '$.previous_quantity') as int) oldValuesQty,
  get_json_object(event_data, '$.hierarchy') hierarchy,
  substr(get_json_object(event_data, '$.category_domain'), 5) domain,
  application.site_id site,
  substr(ds,1,10) AS ds
FROM tracks
WHERE path = '/seller_central/modify/technical_specifications/multivalue'
AND application.business = 'mercadolibre'
    AND ds >= '@param01'
    AND ds < '@param02'
    AND type = 'event';
