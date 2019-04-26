SELECT
  count(1) attributesQty,
  sum(cast(jest(event_data, 'quantity') as int)) newValuesQty,
  sum(cast(jest(event_data, 'previous_quantity')as int)) oldValuesQty,
  jest(event_data, 'hierarchy') hierarchy,
  substr(jest(event_data, 'category_domain'), 5) domain,
  application.site_id site,
  substr(ds,1,10) AS ds
FROM tracks
WHERE path = '/seller_central/modify/technical_specifications/multivalue'
AND application.business = 'mercadolibre'
    AND ds >= '@param01'
    AND ds < '@param02'
    AND type = 'event'
group by jest(event_data, 'hierarchy'), substr(jest(event_data, 'category_domain'), 5), application.site_id, substr(ds,1,10);
