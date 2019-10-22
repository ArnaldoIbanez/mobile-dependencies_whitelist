SELECT jest(event_data, 'banner.deal_id') AS deal_id,
  jest(event_data, 'banner.exhibitors_id') AS exhibitor_id,
  device.platform AS platform,
  device.device_type AS device_type,
  device.vendor AS device_vendor,
  substr(ds,1,10) as track_date,
  count(*) as total_views
FROM tracks
WHERE path LIKE '/search'
  AND jest(event_data, 'banner.exhibitors_id') IS NOT NULL
  AND ds>='@param01' AND ds<'@param02'
GROUP BY jest(event_data, 'banner.deal_id'),
  jest(event_data, 'banner.exhibitors_id'),
  device.platform,
  device.device_type,
  device.vendor,
  substr(ds,1,10);

