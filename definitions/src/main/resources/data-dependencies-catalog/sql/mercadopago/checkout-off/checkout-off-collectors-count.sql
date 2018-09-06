SELECT 
	application.site_id as site, 
	application.version as version, 
	count(DISTINCT jest(event_data, 'collector_id')) as collectors_count, 
	jest(event_data, 'environment') as environment,
	substr(ds, 1, 10) as ds_date
FROM tracks
WHERE ds >= '@param01' and 
	ds < '@param02' and
	path like '/checkout_off/v1/%'
GROUP BY application.site_id, 
	jest(event_data, 'environment'), 
	application.version, 
	substr(ds, 1, 10)
ORDER BY environment, 
	version,
	collectors_count DESC