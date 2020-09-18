SELECT
  count(1) as cantidad,
  usr.user_id as user_id,
  filters,
  get_json_object(event_data, '$.seller_profile') as seller_profile,
  get_json_object(event_data, '$.seller_reputation') as seller_reputation,
  get_json_object(event_data, '$.mercado_lider') as mercado_lider,
  get_json_object(event_data, '$.seller_segment') as seller_segment,
  get_json_object(event_data, '$.user_type') as user_type,
  application.site_id as site_id,
  substr(ds,1,10) as ds
FROM default.tracks
lateral view explode(json_to_array(jet(event_data, 'filters'))) tf as filters
WHERE ds >= '@param01'
AND ds < '@param02'
AND path in ('/seller_central/sales/list/action/primary')
AND jest(event_data, 'id') = 'DOWNLOAD_EXCEL_BUTTON'
GROUP BY usr.user_id,
  filters,
  get_json_object(event_data, '$.seller_profile'),
  get_json_object(event_data, '$.seller_reputation'),
  get_json_object(event_data, '$.mercado_lider'),
  get_json_object(event_data, '$.seller_segment'),
  get_json_object(event_data, '$.user_type'),
  substr(ds,1,10),
  application.site_id
