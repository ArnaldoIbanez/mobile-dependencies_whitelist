SELECT
    t1.dsx AS `ds`,
    t1.component AS `component`,
    t1.component_order AS `component_order`,
    t1.campaign AS `campaign`,
    t1.brand_name AS `brand_name`,
    t1.category_id AS `category_id`,
    t1.platform AS `device_type`,
    t1.site_id AS `site_id`,
    prints,
    clicks

FROM

(SELECT from_unixtime(unix_timestamp(ds, 'yyyy-MM-dd HH') + 14400, 'yyyy-MM-dd HH') AS `dsx`,
    `jt`.`id` AS `component`,
    `jt2`.`platform` AS `platform`,
    `jt3`.`site_id` AS  `site_id`,
    `jt`.`c_order` AS `component_order`,
    `jt`.`campaign` AS `campaign`,
    `jt`.`brand_name` AS `brand_name`,
    `jt`.`category_id` AS `category_id`,
    COUNT(`jt`.`id`) AS `prints`
FROM component_prints
LATERAL VIEW json_tuple(`data`, 'event_data') ed AS `event_data`
LATERAL VIEW json_tuple(ed.`event_data`, 'c_event', 'c_id', 'c_order', 'campaign', 'brand_name', 'category_id') jt AS `event`, `id`, `c_order`, `campaign`, `brand_name`, `category_id`
LATERAL VIEW json_tuple(`data`, 'device') dev AS `device`
LATERAL VIEW json_tuple(dev.`device`, 'platform') jt2 AS `platform`
LATERAL VIEW json_tuple(`data`, 'application') app AS `application`
LATERAL VIEW json_tuple(app.`application`, 'site_id') jt3 AS `site_id`
WHERE ds >= '@param03 20' AND ds < '@param04 20'
    AND `jt`.`event` = 'print'
    AND `jt`.`id` IS NOT NULL
GROUP BY from_unixtime(unix_timestamp(ds, 'yyyy-MM-dd HH') + 14400, 'yyyy-MM-dd HH'), `jt2`.`platform`,`jt3`.`site_id`, `jt`.`id`, `jt`.`c_order`, `jt`.`campaign`, `jt`.`brand_name`, `jt`.`category_id`) AS t1

LEFT JOIN

(SELECT ds,
    regexp_extract(`jt`.`id`, '^(\/.*)\/.*$', 1) AS `component`,
    device.platform AS `platform`,
    application.site_id AS `site_id`,
    `jt`.`c_order` AS `component_order`,
    `jt`.`campaign` AS `campaign`,
    `jt`.`brand_name` AS `brand_name`,
    `jt`.`category_id` AS `category_id`,
    COUNT(`jt`.`id`) AS `clicks`
FROM tracks
LATERAL VIEW json_tuple(others['fragment'], 'c_event', 'c_id', 'c_order', 'campaign', 'brand_name', 'category_id') jt AS `event`, `id`, `c_order`, `campaign`, `brand_name`, `category_id`
WHERE ds>= '@param01' AND ds < '@param02'
    AND `type` = 'view'
    AND `path` <> '/recommendations'
    AND `jt`.`id` IS NOT NULL
    AND others['intersection_observer_supported'] = 'true'
GROUP BY ds, device.platform, application.site_id, regexp_extract(`jt`.`id`, '^(\/.*)\/.*$', 1), `jt`.`c_order`, `jt`.`campaign`, `jt`.`brand_name`, `jt`.`category_id`) AS t2

ON

    t1.dsx = t2.ds AND
    t1.platform = t2.platform AND
    t1.site_id = t2.site_id AND
    t1.component = t2.component AND
    t1.component_order = t2.component_order AND
    t1.campaign = t2.campaign AND
    t1.brand_name = t2.brand_name AND
    t1.category_id = t2.category_id
