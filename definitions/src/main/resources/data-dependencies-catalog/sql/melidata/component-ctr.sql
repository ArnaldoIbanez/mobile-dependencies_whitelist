SELECT
    prints.component AS `component`,
    prints.platform AS `device_type`,
    prints.site_id AS `site_id`,
    prints_count as `prints`,
    clicks_count as `clicks`,
    SUBSTR(prints.dsx, 1, 10) AS `ds`

FROM

(SELECT from_unixtime(unix_timestamp(ds, 'yyyy-MM-dd HH') + 14400, 'yyyy-MM-dd HH') AS `dsx`,
    `jt`.`id` AS `component`,
    `jt2`.`platform` AS `platform`,
    `jt3`.`site_id` AS  `site_id`,
    COUNT(`jt`.`id`) AS `prints_count`
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
    AND `jt`.`id` RLIKE '.*(?<!\/element)$'
    AND `jt`.`id` RLIKE '.*(?<!\/item)$'
GROUP BY from_unixtime(unix_timestamp(ds, 'yyyy-MM-dd HH') + 14400, 'yyyy-MM-dd HH'), `jt2`.`platform`,`jt3`.`site_id`, `jt`.`id`) AS prints

LEFT JOIN

(SELECT ds,
    regexp_extract(`jt`.`id`, '^(\/.*)\/.*$', 1) AS `component`,
    device.platform AS `platform`,
    application.site_id AS `site_id`,
    COUNT(`jt`.`id`) AS `clicks_count`
FROM tracks
LATERAL VIEW json_tuple(others['fragment'], 'c_event', 'c_id') jt AS `event`, `id`
WHERE ds >= '@param01' AND ds < '@param02'
    AND `type` = 'view'
    AND `path` <> '/recommendations'
    AND `jt`.`id` IS NOT NULL
    AND others['intersection_observer_supported'] = 'true'
GROUP BY ds, device.platform, application.site_id, regexp_extract(`jt`.`id`, '^(\/.*)\/.*$', 1)) AS clicks

ON

    prints.dsx = clicks.ds AND
    prints.platform = clicks.platform AND
    prints.site_id = clicks.site_id AND
    prints.component = clicks.component
