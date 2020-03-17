SELECT
json_extract(event_data, '$.duration') as Duration,
json_extract(event_data, '$.connection') as ConnectionType,
json_extract(event_data, '$.filename') as Filename,
json_extract(event_data, '$.cache_status') as CacheStatus,
json_extract(event_data, '$.cdn_provider') as CDNProvider,
json_extract(event_data, '$.size') as FileSize,
application.site_id as SiteId,
device.platform as DevicePlatform,
remote_ip as RemoteIP,
substr(ds, 1, 10) as DS
FROM tracks
WHERE path = '/cdn/profiler'
AND type = 'event'
AND ds >= '@dateFROM' and ds < '@dateTO'
