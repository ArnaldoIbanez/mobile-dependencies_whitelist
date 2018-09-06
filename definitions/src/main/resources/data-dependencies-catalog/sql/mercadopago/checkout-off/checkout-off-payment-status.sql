SELECT jest(event_data, 'payment_status') as payment_status, 
jest(event_data, 'payment_status_detail') as payment_status_detail, 
count(*) as ocurrences, 
device.platform as platform, 
application.site_id as site_id, 
application.version as version, 
jest(event_data, 'collector_nickname') as collector, 
jest(event_data, 'environment') as environment, 
substr(ds, 1, 10) as ds_date
FROM tracks
WHERE path = '/checkout_off/v1/payment_created'
AND ds >= '@param01' 
AND ds < '@param02'
GROUP BY jest(event_data, 'payment_status'), 
jest(event_data, 'payment_status_detail'), 
device.platform, 
application.version, 
substr(ds, 1, 10), 
jest(event_data, 'collector_nickname'), 
application.site_id, 
jest(event_data, 'environment')