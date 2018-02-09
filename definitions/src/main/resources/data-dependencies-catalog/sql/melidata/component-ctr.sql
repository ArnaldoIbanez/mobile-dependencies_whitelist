SET hive.tez.java.opts = -Xmx5000m;
SELECT
    t1.dsx AS `ds`,
    t1.platform AS `device_type`,
    t1.site_id AS `site_id`,
    t1.component AS `component`,
    prints,
    clicks

FROM

(SELECT from_unixtime(unix_timestamp(ds, 'yyyy-MM-dd HH') + 14400, 'yyyy-MM-dd HH') AS `dsx`,
    `jt2`.`platform` AS `platform`,
    `jt3`.`site_id` AS  `site_id`,
    `jt`.`id` AS `component`,
    COUNT(`jt`.`id`) AS `prints`
FROM component_prints
LATERAL VIEW json_tuple(`data`, 'event_data') ed AS `event_data`
LATERAL VIEW json_tuple(ed.`event_data`, 'c_event', 'c_id') jt AS `event`, `id`
LATERAL VIEW json_tuple(`data`, 'device') dev AS `device`
LATERAL VIEW json_tuple(dev.`device`, 'platform') jt2 AS `platform`
LATERAL VIEW json_tuple(`data`, 'application') app AS `application`
LATERAL VIEW json_tuple(app.`application`, 'site_id') jt3 AS `site_id`
WHERE ds >= '@param03 20' AND ds < '@param04 20'
    AND `jt`.`event` = 'print'
    AND `jt`.`id` IS NOT NULL
GROUP BY from_unixtime(unix_timestamp(ds, 'yyyy-MM-dd HH') + 14400, 'yyyy-MM-dd HH'), `jt2`.`platform`,`jt3`.`site_id`, `jt`.`id`) AS t1

LEFT JOIN

(SELECT ds,
    application.site_id AS `site_id`,
    device.platform AS `platform`,
    regexp_extract(`jt`.`id`, '^(\/.*)\/.*$', 1) AS `component`,
    COUNT(`jt`.`id`) AS `clicks`
FROM tracks
LATERAL VIEW json_tuple(others['fragment'], 'c_event', 'c_id') jt AS `event`, `id`
WHERE ds>= '@param01' AND ds < '@param02'
    AND `type` = 'view'
    AND `path` <> '/recommendations'
    AND `jt`.`id` IS NOT NULL
    AND others['intersection_observer_supported'] = 'true'
GROUP BY ds, application.site_id, device.platform, regexp_extract(`jt`.`id`, '^(\/.*)\/.*$', 1)) AS t2

ON

    t1.dsx = t2.ds AND
    t1.platform = t2.platform AND
    t1.site_id = t2.site_id AND
    t1.component = t2.component
