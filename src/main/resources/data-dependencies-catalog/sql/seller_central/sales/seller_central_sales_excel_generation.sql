SELECT
  path,
  get_json_object(event_data, '$.seller_profile') as seller_profile,
  get_json_object(event_data, '$.seller_reputation') as seller_reputation,
  get_json_object(event_data, '$.mercado_lider') as mercado_lider,
  get_json_object(event_data, '$.seller_segment') as seller_segment,
  get_json_object(event_data, '$.user_type') as user_type,
  get_json_object(event_data, '$.id') as id_type,
  get_json_object(event_data, '$.time') as time,
  get_json_object(event_data, '$.total_sales') as total_sales,
  get_json_object(event_data, '$.total_rows') as total_rows,
  get_json_object(event_data, '$.total_packs') as total_packs,
  get_json_object(event_data, '$.total_error_cells') as total_error_cells,
  get_json_object(event_data, '$.total_error_rows') as total_error_rows,
  usr.user_id user_id,
  application.site_id as site_id,
  substr(ds,1,10) as ds
FROM melidata.tracks_ml
WHERE ds >= '@param01'
AND ds < '@param02'
AND bu = 'mercadolibre'
AND path in ('/seller_central/sales/list/excel/generation', '/seller_central/sales/list/excel/snackbar',
  '/seller_central/sales/list/excel/packs')