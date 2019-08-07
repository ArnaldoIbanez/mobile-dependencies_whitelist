SELECT 
	usr.user_id AS seller,
	application.site_id AS site,
	jest(event_data,'warning_type') as warning_type,
	jest(event_data,'warning_value') as warning_value,
	jest(event_data,'inbound_id') as inbound_id,
	jest(event_data,'inventory_id') as inventory_id,
	jest(event_data,'input_value') as input_value,
	substr(ds,1,10) AS ds
FROM default.tracks 
WHERE ds >= '@param01'
AND   ds < '@param02'
AND path = '/fbm/panel/inbound/units/input_change'