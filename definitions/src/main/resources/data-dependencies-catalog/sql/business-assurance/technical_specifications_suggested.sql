SELECT
  count(1) attributesQty,
  jest(event_data, 'type') type,
  jest(event_data, 'hierarchy') hierarchy,
  substr(jest(event_data, 'category_domain'), 5) domain,
  jest(event_data, 'attribute') attribute,
  application.site_id site,
  substr(ds,1,10) AS ds
FROM tracks
WHERE path = '/seller_central/modify/technical_specifications/suggested'
AND application.business = 'mercadolibre'
    AND ds >= '@param01'
    AND ds < '@param02'
    AND type = 'event'
group by jest(event_data, 'type'), jest(event_data, 'hierarchy'), substr(jest(event_data, 'category_domain'), 5), jest(event_data, 'attribute'), application.site_id, substr(ds,1,10);
