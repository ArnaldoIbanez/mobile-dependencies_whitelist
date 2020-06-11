SELECT
  count(1) attributesQty,
  get_json_object(event_data, '$.type') type,
  get_json_object(event_data, '$.hierarchy') hierarchy,
  substr(get_json_object(event_data, '$.category_domain'), 5) domain,
  get_json_object(event_data, '$.attribute') attribute,
  application.site_id site,
  substr(ds,1,10) AS ds
FROM tracks
WHERE path = '/seller_central/modify/technical_specifications/suggested'
AND application.business = 'mercadolibre'
    AND ds >= '@param01'
    AND ds < '@param02'
    AND type = 'event'
group by get_json_object(event_data, '$.type'), get_json_object(event_data, '$.hierarchy'), substr(get_json_object(event_data, '$.category_domain'), 5), get_json_object(event_data, '$.attribute'), application.site_id, substr(ds,1,10);
