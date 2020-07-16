SELECT deal_id, source, placement, platform, device_type, device_vendor, count(*) as total, track_date
FROM (
 SELECT others['deal_id'] AS deal_id,
    CASE WHEN COALESCE(platform.fragment, others['fragment']) RLIKE 'EI:[0-9]+' THEN 'search'
         WHEN jest(COALESCE(platform.fragment, others['fragment']), 'c_id') RLIKE '.*/home/.*' THEN 'home'
         WHEN jest(COALESCE(platform.fragment, others['fragment']), 'menu') RLIKE 'categories|notifications' THEN 'menu'
         WHEN jest(COALESCE(platform.fragment, others['fragment']), 'origin') RLIKE 'page_x' THEN 'page_x'
         WHEN jest(COALESCE(platform.fragment, others['fragment']), 'origin') RLIKE 'vip' THEN 'vip'
    END AS source,
    CASE WHEN COALESCE(platform.fragment, others['fragment']) RLIKE 'EI:[0-9]+' THEN regexp_extract(COALESCE(platform.fragment, others['fragment']), 'EI:([0-9]+)', 1)
         WHEN jest(COALESCE(platform.fragment, others['fragment']), 'c_id') RLIKE '/home/exhibitors-carousel' THEN 'main_slider'
         WHEN jest(COALESCE(platform.fragment, others['fragment']), 'c_id') RLIKE '/home/discovery' THEN 'discovery_module'
         WHEN jest(COALESCE(platform.fragment, others['fragment']), 'c_id') RLIKE '/home/categories-carousel' THEN 'categories_carousel'
         WHEN jest(COALESCE(platform.fragment, others['fragment']), 'menu') RLIKE 'categories' THEN 'categories_menu'
         WHEN jest(COALESCE(platform.fragment, others['fragment']), 'menu') RLIKE 'notifications' THEN 'notifications_menu'
         WHEN jest(COALESCE(platform.fragment, others['fragment']), 'origin') RLIKE 'page_x' THEN 'link_page_x'
         WHEN jest(COALESCE(platform.fragment, others['fragment']), 'origin') RLIKE 'vip' THEN 'link_vip'
    END AS placement,
    device.platform AS platform,
    device.device_type AS device_type,
    device.vendor AS device_vendor,
    substr(ds,1,10) as track_date
  FROM tracks
  WHERE path LIKE '/deals/landing'
    AND ds>='@param01' AND ds<'@param02'
    AND others['deal_id'] is not null) a
GROUP BY deal_id, source, placement, platform, device_type, device_vendor, track_date;