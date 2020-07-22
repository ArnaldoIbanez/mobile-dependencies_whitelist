SELECT
    prints.component AS `component`,
    prints.platform AS `device_type`,
    prints.site_id AS `site_id`,
    prints_count AS `prints`,
    clicks_count AS `clicks`,
    SUBSTR(prints.dsx, 1, 10) AS `ds`

FROM

(SELECT from_unixtime(unix_timestamp(ds, 'yyyy-MM-dd HH') - 14400, 'yyyy-MM-dd HH') AS `dsx`,
        get_json_object(event_data, '$.c_id') as component,
        device.platform as platform,
        application.site_id as site_id,
        COUNT(get_json_object(event_data, '$.c_id')) AS prints_count

FROM component_prints_parquet
WHERE ds >= '@param01' AND ds < '@param02'
    AND get_json_object(event_data, '$.c_id') IS NOT NULL
    AND path = '/component'
    AND get_json_object(event_data, '$.c_id') RLIKE '.*(?<!\/element)$'
    AND get_json_object(event_data, '$.c_id') RLIKE '.*(?<!\/item)$'
GROUP BY from_unixtime(unix_timestamp(ds, 'yyyy-MM-dd HH') - 14400, 'yyyy-MM-dd HH'), device.platform, application.site_id, get_json_object(event_data, '$.c_id')) AS prints

LEFT JOIN

(SELECT ds,
    regexp_extract(`jt`.`id`, '^(\/.*)\/.*$', 1) AS `component`,
    device.platform AS `platform`,
    application.site_id AS `site_id`,
    COUNT(DISTINCT(COALESCE(`jt`.`uid`, -1))) AS `clicks_count`
FROM tracks
LATERAL VIEW json_tuple(platform.fragment, 'c_event', 'c_id', 'c_uid') jt AS `event`, `id`, `uid`
WHERE ds >= '@param01' AND ds < '@param02'
    AND `type` = 'view'
    AND `path` <> '/recommendations'
    AND `jt`.`id` IS NOT NULL
    AND (device.platform LIKE '/mobile/%' OR platform.http.intersection_observer_supported = TRUE)
GROUP BY ds, device.platform, application.site_id, regexp_extract(`jt`.`id`, '^(\/.*)\/.*$', 1)) AS clicks

ON

    prints.dsx = clicks.ds AND
    prints.platform = clicks.platform AND
    prints.site_id = clicks.site_id AND
    prints.component = clicks.component