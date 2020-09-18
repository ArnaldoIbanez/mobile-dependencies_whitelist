SELECT
 t1.site_id AS site_id, 
 t1.platform AS platform, 
 t1.path AS path, 
 t1.event_type as event_type,
 COUNT(*) AS total, 
 t1.date_sent as date_sent
FROM
 (
   SELECT
     application.site_id       AS site_id,
     usr.user_id               AS user_id,
     device.platform           AS platform,
     path,
     SUBSTR(ds, 1, 10)         AS date_sent,
     get_json_object(event_data, '$.event_type') as event_type
   FROM tracks
   WHERE (ds >= '@param01' and ds < '@param02')
     AND (path like '/notification_center/credits-consumer%' or path like '/notification/credits_consumer%')
     AND (application.site_id = 'MLA' or application.site_id = 'MLB' or application.site_id = 'MLM')
     AND (get_json_object(event_data, '$.event_type') = 'shown' or get_json_object(event_data, '$.event_type') = 'open')
   GROUP BY
     usr.user_id,
     SUBSTR(ds, 1, 10),
     application.site_id,
     device.platform,
     path,
     get_json_object(event_data, '$.event_type')
 ) AS t1
GROUP BY
 t1.site_id, t1.date_sent, t1.platform, t1.path, t1.event_type