SELECT
application.site_id as site_id,
device.platform as device_platform,
get_json_object(event_data, '$.cdn_provider') as cdn_provider,
get_json_object(event_data, '$.connection') as connection_type,
get_json_object(event_data, '$.filename') as file_name,
get_json_object(event_data, '$.cache_status') as cache_status,
get_json_object(event_data, '$.size') as file_size,
get_json_object(event_data, '$.duration') as duration,
remote_ip as remote_ip,
substr(ds, 1, 10) as ds
FROM melidata.tracks_ml
WHERE path = '/cdn/profiler'
AND type = 'event'
AND ds >= '@dateFROM' and ds < '@dateTO'
