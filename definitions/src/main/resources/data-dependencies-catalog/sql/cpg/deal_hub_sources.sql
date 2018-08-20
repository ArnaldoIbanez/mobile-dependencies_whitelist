WITH a AS ( SELECT others['deal_id'] AS deal_id,
    CASE WHEN others['fragment'] RLIKE '.*EI:\d+.*' THEN 'search'
         WHEN jest(others['fragment'], 'c_id') RLIKE '.*/home/.*' THEN 'home'
         WHEN jest(others['fragment'], 'menu') RLIKE 'categories|notifications' THEN 'menu'
         WHEN jest(others['fragment'], 'origin') RLIKE 'page_x' THEN 'page_x'
    END AS source,
    CASE WHEN others['fragment'] RLIKE '.*EI:\d+.*' THEN regexp_extract(others['fragment'], '.*EI:(\d+).*', 1)
         WHEN jest(others['fragment'], 'c_id') RLIKE '.*/home/exhibitors-carousel.*' THEN 'main_slider'
         WHEN jest(others['fragment'], 'c_id') RLIKE '.*/home/discovery.*' THEN 'discovery_module'
         WHEN jest(others['fragment'], 'c_id') RLIKE '.*/home/categories-carousel.*' THEN 'categories_carousel'
         WHEN jest(others['fragment'], 'menu') RLIKE 'categories' THEN 'categories_menu'
         WHEN jest(others['fragment'], 'menu') RLIKE 'notifications' THEN 'notifications_menu'
         WHEN jest(others['fragment'], 'origin') RLIKE 'page_x' THEN 'page_x'
    END AS placement,
    device.platform AS platform,
    device.device_type AS device_type,
    device.vendor AS device_vendor,
    substr(ds,1,10) as track_date
  FROM tracks
  WHERE path LIKE '/deals/landing'
    AND ds>='@param01' AND ds<'@param02'
    AND others['deal_id'] is not null
)
SELECT deal_id, source, placement, platform, device_type, device_vendor, track_date, count(*) as total
FROM a
GROUP BY deal_id, source, placement, platform, device_type, device_vendor, track_date;