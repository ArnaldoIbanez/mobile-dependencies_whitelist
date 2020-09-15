SELECT
site_id,
device_platform,
cdn_provider,
connection_type,
file_name,
CASE
  WHEN file_name LIKE '%vendor.js' THEN 'JS'
  WHEN file_name LIKE '%home.desktop.css' THEN 'CSS'
END as file_type,
cache_status,
file_size,
duration,
remote_ip,
ds
FROM (
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
  AND ds >= '@dateFROM'
  AND ds < '@dateTO'
)
WHERE site_id IS NOT NULL
AND device_platform IS NOT NULL
AND connection_type IS NOT NULL
AND file_name IS NOT NULL
AND cache_status IS NOT NULL
AND file_size IS NOT NULL
AND duration IS NOT NULL
