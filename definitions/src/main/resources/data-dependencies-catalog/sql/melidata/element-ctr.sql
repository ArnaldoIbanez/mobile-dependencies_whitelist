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
    `jt`.`id` AS `component`,
    `jt2`.`platform` AS `platform`,
    `jt3`.`site_id` AS  `site_id`,
    `jt`.`element_order` AS `element_order`,
    `jt`.`campaign` AS `campaign`,
    COALESCE(`jt`.`brand_name`, `jt`.`legacy_brand_name`) AS `brand_name`,
    COALESCE(`jt`.`category_id`, `jt`.`legacy_category_id`) AS `category_id`,
    COUNT(`jt`.`id`) AS `prints_count`
FROM component_prints
LATERAL VIEW json_tuple(`data`, 'event_data') ed AS `event_data`
LATERAL VIEW json_tuple(ed.`event_data`, 'c_event', 'c_id', 'c_element_order', 'c_campaign', 'c_brand_name', 'brand_name', 'c_category_id', 'category_id') jt AS `event`, `id`, `element_order`, `campaign`, `brand_name`, `legacy_brand_name`, `category_id`, `legacy_category_id`
LATERAL VIEW json_tuple(`data`, 'device') dev AS `device`
LATERAL VIEW json_tuple(dev.`device`, 'platform') jt2 AS `platform`
LATERAL VIEW json_tuple(`data`, 'application') app AS `application`
LATERAL VIEW json_tuple(app.`application`, 'site_id') jt3 AS `site_id`
LATERAL VIEW json_tuple(`data`, 'path') jt4 AS `path`
WHERE ds >= '@param01 04' AND ds < '@param02 04'
    AND `jt`.`id` IS NOT NULL
    AND `jt4`.`path` = '/component'
    AND (`jt`.`id` != '/home/exhibitors-carousel/element' OR ((`jt`.`element_order` IS NOT NULL) AND (`jt`.`campaign` IS NOT NULL)))
    AND (`jt`.`id` RLIKE '.*(?<=\/element)$' OR `jt`.`id` RLIKE '.*(?<=\/item)$')
GROUP BY from_unixtime(unix_timestamp(ds, 'yyyy-MM-dd HH') - 14400, 'yyyy-MM-dd HH'), `jt2`.`platform`,`jt3`.`site_id`, `jt`.`id`, `jt`.`element_order`, `jt`.`campaign`, COALESCE(`jt`.`brand_name`, `jt`.`legacy_brand_name`), COALESCE(`jt`.`category_id`, `jt`.`legacy_category_id`)) AS prints

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
