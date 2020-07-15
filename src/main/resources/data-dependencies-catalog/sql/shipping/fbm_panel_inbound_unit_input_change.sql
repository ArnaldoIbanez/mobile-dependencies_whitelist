SELECT 
	usr.user_id AS seller,
	application.site_id AS site,
	get_json_object(event_data,'$.warning_type') as warning_type,
	get_json_object(event_data,'$.warning_value') as warning_value,
	get_json_object(event_data,'$.inbound_id') as inbound_id,
	get_json_object(event_data,'$.inventory_id') as inventory_id,
	get_json_object(event_data,'$.input_value') as input_value,
	substr(ds,1,10) AS ds
FROM melidata.tracks_ml
WHERE ds >= '@param01'
AND   ds < '@param02'
AND path = '/fbm/panel/inbound/units/input_change'
AND bu = 'mercadolibre'