SELECT application.site_id as site,
	application.version as version, 
	jest(event_data, 'payment_method') as payment_method, 
	count(*) as conversions_count, 
	jest(event_data, 'environment') as environment, 
	substr(ds, 1, 10) as ds_date
FROM tracks
WHERE ds >= '@param01' and 
	ds < '@param02' and
	path = '/checkout_off/v1/checkout_confirmed' and
	jest(event_data, 'payment_method') IS NOT NULL and 
	jest(event_data, 'payment_method') != ''
GROUP BY jest(event_data, 'payment_method'),
	application.site_id, 
	jest(event_data, 'environment'), 
	application.version, 
	substr(ds, 1, 10)
ORDER BY environment, 
	version, 
	site, 
	conversions_count DESC