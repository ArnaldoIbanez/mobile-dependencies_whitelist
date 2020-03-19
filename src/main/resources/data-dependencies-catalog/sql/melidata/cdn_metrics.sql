SELECT
application.site_id as site_id,
device.platform as device_platform,
jest(event_data, 'cdn_provider') as cdn_provider,
jest(event_data, 'connection') as connection_type,
jest(event_data, 'filename') as file_name,
jest(event_data, 'cache_status') as cache_status,
jest(event_data, 'size') as file_size,
jest(event_data, 'duration') as duration,
remote_ip as remote_ip,
substr(ds, 1, 10) as ds
FROM tracks
WHERE path = '/cdn/profiler'
AND type = 'event'
AND ds >= '@dateFROM' and ds < '@dateTO'
