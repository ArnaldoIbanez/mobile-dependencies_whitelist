SELECT 
    t1.dsx AS `ds`,
    t1.component AS `component`,
    prints,
    clicks

FROM 

(SELECT from_unixtime(unix_timestamp(ds, 'yyyy-MM-dd hh') - 14400, 'yyyy-MM-dd hh') AS `dsx`,
    `jt`.`id` AS `component`,
    COUNT(`jt`.`id`) AS `prints`
FROM component_prints
LATERAL VIEW json_tuple(`data`, 'event_data') ed AS `event_data`
LATERAL VIEW json_tuple(ed.`event_data`, 'c_event', 'c_id') jt AS `event`, `id`
WHERE ds >= '@param03 20' AND ds < '@param04 20' 
    AND `jt`.`event` = 'print'
GROUP BY from_unixtime(unix_timestamp(ds, 'yyyy-MM-dd hh') - 14400, 'yyyy-MM-dd hh'), `jt`.`id`) AS t1

LEFT JOIN

(SELECT ds,
    regexp_extract(`jt`.`id`, '^(\/.*)\/.*$', 1) AS `component`,
    COUNT(`jt`.`id`) AS `clicks`
FROM tracks
LATERAL VIEW json_tuple(others['fragment'], 'c_event', 'c_id') jt AS `event`, `id`
WHERE ds>= '@param01' AND ds < '@param02' 
    AND `type` = 'view'
    AND `jt`.`id` IS NOT NULL
GROUP BY ds, regexp_extract(`jt`.`id`, '^(\/.*)\/.*$', 1)) AS t2

ON 

    t1.dsx = t2.ds AND 
    t1.component = t2.component
