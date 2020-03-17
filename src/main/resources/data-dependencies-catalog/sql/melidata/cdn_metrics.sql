SELECT
jest(event_data, 'duration') as Duration,
jest(event_data, 'connection') as ConnectionType,
jest(event_data, 'filename') as Filename,
jest(event_data, 'cache_status') as CacheStatus,
jest(event_data, 'cdn_provider') as CDNProvider,
jest(event_data, 'size') as FileSize,
application.site_id as SiteId,
device.platform as DevicePlatform,
remote_ip as RemoteIP,
substr(ds, 1, 10) as DS
FROM tracks
WHERE path = '/cdn/profiler'
AND type = 'event'
AND ds >= '@dateFROM' and ds < '@dateTO'
