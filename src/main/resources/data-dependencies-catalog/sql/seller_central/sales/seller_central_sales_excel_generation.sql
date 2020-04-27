SELECT
  path,
  jest(event_data, 'seller_profile') as seller_profile,
  jest(event_data, 'seller_reputation') as seller_reputation,
  jest(event_data, 'mercado_lider') as mercado_lider,
  jest(event_data, 'seller_segment') as seller_segment,
  jest(event_data, 'user_type') as user_type,
  jest(event_data, 'id') as id_type,
  jest(event_data, 'time') as time,
  jest(event_data, 'total_sales') as total_sales,
  jest(event_data, 'total_rows') as total_rows,
  jest(event_data, 'total_packs') as total_packs,
  jest(event_data, 'total_error_cells') as total_error_cells,
  jest(event_data, 'total_error_rows') as total_error_rows,
  usr.user_id user_id,
  application.site_id as site_id,
  substr(ds,1,10) as ds
FROM default.tracks
WHERE ds >= '@param01'
AND ds < '@param02'
AND path in ('/seller_central/sales/list/excel/generation', '/seller_central/sales/list/excel/snackbar',
  '/seller_central/sales/list/excel/packs')