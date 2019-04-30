SELECT
  jest(event_data, 'item_id') itemId,
  cast(jest(event_data, 'quantity') as int) newValuesQty,
  cast(jest(event_data, 'previous_quantity') as int) oldValuesQty,
  jest(event_data, 'hierarchy') hierarchy,
  substr(jest(event_data, 'category_domain'), 5) domain,
  application.site_id site,
  substr(ds,1,10) AS ds
FROM tracks
WHERE path = '/seller_central/modify/technical_specifications/multivalue'
AND application.business = 'mercadolibre'
    AND ds >= '@param01'
    AND ds < '@param02'
    AND type = 'event';
