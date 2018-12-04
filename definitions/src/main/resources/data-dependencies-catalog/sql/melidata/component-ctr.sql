SELECT
    SUBSTR(prints.dsx, 1, 10) AS `ds`,
    prints.component AS `component`,
    prints.platform AS `device_type`,
    prints.site_id AS `site_id`,
    prints.element_order AS `element_order`,
    prints.campaign AS `campaign`,
    prints.brand_name AS `brand_name`,
    prints.category_id AS `category_id`,
    prints_count as `prints`,
    clicks_count as `clicks`

FROM

(SELECT from_unixtime(unix_timestamp(ds, 'yyyy-MM-dd HH') + 14400, 'yyyy-MM-dd HH') AS `dsx`,
    `jt`.`id` AS `component`,
    `jt2`.`platform` AS `platform`,
    `jt3`.`site_id` AS  `site_id`,
    `jt`.`element_order` AS `element_order`,
    `jt`.`campaign` AS `campaign`,
    `jt`.`brand_name` AS `brand_name`,
    `jt`.`category_id` AS `category_id`,
    COUNT(`jt`.`id`) AS `prints_count`
FROM component_prints
LATERAL VIEW json_tuple(`data`, 'event_data') ed AS `event_data`
LATERAL VIEW json_tuple(ed.`event_data`, 'c_event', 'c_id', 'c_element_order', 'c_campaign', 'c_brand_name', 'c_category_id') jt AS `event`, `id`, `element_order`, `campaign`, `brand_name`, `category_id`
LATERAL VIEW json_tuple(`data`, 'device') dev AS `device`
LATERAL VIEW json_tuple(dev.`device`, 'platform') jt2 AS `platform`
LATERAL VIEW json_tuple(`data`, 'application') app AS `application`
LATERAL VIEW json_tuple(app.`application`, 'site_id') jt3 AS `site_id`
WHERE ds >= '@param03 20' AND ds < '@param04 20'
    AND `jt`.`event` = 'print'
    AND `jt`.`id` IS NOT NULL
GROUP BY from_unixtime(unix_timestamp(ds, 'yyyy-MM-dd HH') + 14400, 'yyyy-MM-dd HH'), `jt2`.`platform`,`jt3`.`site_id`, `jt`.`id`, `jt`.`element_order`, `jt`.`campaign`, `jt`.`brand_name`, `jt`.`category_id`) AS prints

LEFT JOIN

(SELECT ds,
    regexp_extract(`jt`.`id`, '^(\/.*)\/.*$', 1) AS `component`,
    device.platform AS `platform`,
    application.site_id AS `site_id`,
    `jt`.`element_order` AS `element_order`,
    `jt`.`campaign` AS `campaign`,
    `jt`.`brand_name` AS `brand_name`,
    `jt`.`category_id` AS `category_id`,
    COUNT(`jt`.`id`) AS `clicks_count`
FROM tracks
LATERAL VIEW json_tuple(others['fragment'], 'c_event', 'c_id', 'c_element_order', 'c_campaign', 'c_brand_name', 'c_category_id') jt AS `event`, `id`, `element_order`, `campaign`, `brand_name`, `category_id`
WHERE ds >= '@param01' AND ds < '@param02'
    AND `type` = 'view'
    AND `path` <> '/recommendations'
    AND `jt`.`id` IS NOT NULL
    AND others['intersection_observer_supported'] = 'true'
GROUP BY ds, device.platform, application.site_id, regexp_extract(`jt`.`id`, '^(\/.*)\/.*$', 1), `jt`.`element_order`, `jt`.`campaign`, `jt`.`brand_name`, `jt`.`category_id`) AS clicks

ON

    prints.dsx = clicks.ds AND
    prints.platform = clicks.platform AND
    prints.site_id = clicks.site_id AND
    prints.component = clicks.component AND
    COALESCE(prints.element_order, -1) = COALESCE(clicks.element_order, -1) AND
    COALESCE(prints.campaign, -1) = COALESCE(clicks.campaign, -1) AND
    COALESCE(prints.brand_name, -1) = COALESCE(clicks.brand_name, -1) AND
    COALESCE(prints.category_id, -1) = COALESCE(clicks.category_id, -1)
