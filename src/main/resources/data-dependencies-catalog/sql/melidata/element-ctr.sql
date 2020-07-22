SELECT
    prints.component AS `component`,
    prints.platform AS `device_type`,
    prints.site_id AS `site_id`,
    prints.element_order AS `element_order`,
    prints.campaign AS `campaign`,
    prints.brand_name AS `brand_name`,
    prints.category_id AS `category_id`,
    prints_count AS `prints`,
    clicks_count AS `clicks`,
    SUBSTR(prints.dsx, 1, 10) AS `ds`

FROM

(SELECT from_unixtime(unix_timestamp(ds, 'yyyy-MM-dd HH') - 14400, 'yyyy-MM-dd HH') AS `dsx`,
     get_json_object(event_data, '$.c_id') AS `component`,
     device.platform AS `platform`,
     application.site_id AS  `site_id`,
     get_json_object(event_data, '$.c_element_order') AS `element_order`,
     get_json_object(event_data, '$.c_campaign') AS `campaign`,
     COALESCE(get_json_object(event_data, '$.c_brand_name'), get_json_object(event_data, '$.brand_name')) AS `brand_name`,
     COALESCE(get_json_object(event_data, '$.c_category_id'), get_json_object(event_data, '$.category_id')) AS `category_id`,
     COUNT(get_json_object(event_data, '$.c_id')) AS `prints_count`
 FROM component_prints_parquet
 WHERE ds >= '@param01 04' AND ds < '@param02 04'
     AND get_json_object(event_data, '$.c_id') IS NOT NULL
     AND path = '/component'
     AND (get_json_object(event_data, '$.c_id') != '/home/exhibitors-carousel/element' OR ((get_json_object(event_data, '$.c_element_order') IS NOT NULL) AND (get_json_object(event_data, '$.c_campaign') IS NOT NULL)))
     AND (get_json_object(event_data, '$.c_id') RLIKE '.*(?<=\/element)$' OR get_json_object(event_data, '$.c_id') RLIKE '.*(?<=\/item)$')
 GROUP BY from_unixtime(unix_timestamp(ds, 'yyyy-MM-dd HH') - 14400, 'yyyy-MM-dd HH'), get_json_object(event_data, '$.c_id'), device.platform, application.site_id, get_json_object(event_data, '$.c_element_order'), get_json_object(event_data, '$.c_campaign'), COALESCE(get_json_object(event_data, '$.c_brand_name'), get_json_object(event_data, '$.brand_name')), COALESCE(get_json_object(event_data, '$.c_category_id'), get_json_object(event_data, '$.category_id'))) AS prints

LEFT JOIN

(SELECT tracks.ds AS `ds`,
    `jt`.`id` AS `component`,
    device.platform AS `platform`,
    application.site_id AS `site_id`,
    `jt`.`element_order` AS `element_order`,
    `jt`.`campaign` AS `campaign`,
    `jt`.`brand_name` AS `brand_name`,
    `jt`.`category_id` AS `category_id`,
    COUNT(DISTINCT(COALESCE(`jt`.`uid`, -1))) AS `clicks_count`
FROM tracks
LATERAL VIEW json_tuple(platform.fragment, 'c_event', 'c_id', 'c_uid', 'c_element_order', 'c_campaign', 'c_brand_name', 'c_category_id') jt AS `event`, `id`, `uid`, `element_order`, `campaign`, `brand_name`, `category_id`
WHERE ds >= '@param01' AND ds < '@param02'
    AND `type` = 'view'
    AND `path` <> '/recommendations'
    AND `jt`.`id` IS NOT NULL
    AND (`jt`.`id` != '/home/exhibitors-carousel/element' OR ((`jt`.`element_order` IS NOT NULL) AND (`jt`.`campaign` IS NOT NULL)))
    AND (device.platform LIKE '/mobile/%' OR platform.http.intersection_observer_supported = TRUE)
GROUP BY tracks.ds, device.platform, application.site_id, `jt`.`id`, `jt`.`element_order`, `jt`.`campaign`, `jt`.`brand_name`, `jt`.`category_id`) AS clicks

ON

    prints.dsx = clicks.ds AND
    prints.platform = clicks.platform AND
    prints.site_id = clicks.site_id AND
    prints.component = clicks.component AND
    COALESCE(prints.element_order, -1) = COALESCE(clicks.element_order, -1) AND
    COALESCE(prints.campaign, -1) = COALESCE(clicks.campaign, -1) AND
    COALESCE(prints.brand_name, -1) = COALESCE(clicks.brand_name, -1) AND
    COALESCE(prints.category_id, -1) = COALESCE(clicks.category_id, -1)
