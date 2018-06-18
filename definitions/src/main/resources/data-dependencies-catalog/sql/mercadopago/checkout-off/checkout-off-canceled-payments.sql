SELECT regexp_replace(tracks.path, '/checkout_off/v1', '') as event_id, jest(event_data, 'payment_type') as payment_type, jest(event_data, 'payment_method') as payment_method, device.platform, application.site_id, application.version, jest(event_data, 'collector_nickname') as collector, jest(event_data, 'environment') as environment, count(*) as ocurrences, substr(ds, 1, 10) as ds_date
FROM tracks
WHERE ds >= '@param01'
AND ds < '@param02'
AND ((path = '/checkout_off/v1/payment_canceled')
OR (path = '/checkout_off/v1/payment_created'))
GROUP BY path, jest(event_data, 'payment_type'), jest(event_data, 'payment_method'), device.platform, application.site_id, application.version, jest(event_data, 'collector_nickname'), jest(event_data, 'environment'), substr(ds, 1, 10)