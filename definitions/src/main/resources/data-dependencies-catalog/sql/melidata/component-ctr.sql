SELECT 
    t1.ds AS `ds`,
    t1.component AS `component`,
    prints,
    clicks

FROM 

(SELECT ds,
    `jt`.`id` AS `component`,
    COUNT(`jt`.`id`) AS `prints`
FROM component_prints
LATERAL VIEW json_tuple(`data`, '_event', '_id') jt AS `event`, `id`
WHERE ds >= '@param01' AND ds < '@param02' 
    AND `jt`.`event` = 'print'
GROUP BY ds, `jt`.`id`) AS t1

LEFT JOIN

(SELECT ds,
    regexp_extract(`jt`.`id`, '^(\/.*)\/.*$', 1) AS `component`,
    COUNT(`jt`.`id`) AS `clicks`
FROM tracks
LATERAL VIEW json_tuple(others['fragment'], '_id') jt AS `id`
WHERE ds >= '@param01' AND ds < '@param02' 
    AND `type` = 'view'
    AND `path` = '/vip'
    AND `jt`.`id` IS NOT NULL
GROUP BY ds, regexp_extract(`jt`.`id`, '^(\/.*)\/.*$', 1)) AS t2

ON 

    t1.ds = t2.ds AND 
    t1.component = t2.component
