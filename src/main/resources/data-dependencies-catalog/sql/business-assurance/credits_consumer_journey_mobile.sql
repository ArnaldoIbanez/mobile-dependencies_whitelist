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
     jest(event_data, 'event_type') as event_type
   FROM tracks
   WHERE (ds >= '@param01' and ds < '@param02')
     AND (path like '/notification_center/credits-consumer%' or path like '/notification/credits_consumer%')
     AND (jest(event_data, 'event_type') = 'shown' or jest(event_data, 'event_type') = 'open')
     AND (application.site_id = 'MLA' or application.site_id = 'MLB' or application.site_id = 'MLM')
   GROUP BY
     usr.user_id,
     SUBSTR(ds, 1, 10),
     application.site_id,
     device.platform,
     path,
     jest(event_data, 'event_type')
 ) AS t1
GROUP BY
 t1.site_id, t1.date_sent, t1.platform, t1.path, t1.event_type