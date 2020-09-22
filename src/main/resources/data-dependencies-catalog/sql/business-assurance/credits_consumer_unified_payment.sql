SELECT path,
       get_json_object
           (event_data, '$.total_installments') AS quantity,
       get_json_object
           (event_data, '$.paid_installments')  AS paid_installments,
       get_json_object
           (event_data, '$.page_status')        AS status,
       count
           (*)                                AS total,
       device.platform                        AS platform,
       application.site_id                    AS site_id,
       substr
           (ds, 1, 10)                        AS date_sent
FROM tracks
WHERE path = '/credits/consumer/administrator_v2/installment_selection/payment_intention'
  AND ds >= '@param01'
  AND ds < '@param02'
GROUP BY substr
             (ds, 1, 10),
         path,
         event_data,
         device.platform,
         application.site_id
HAVING get_json_object
           (event_data, '$.total_installments') >= get_json_object
           (event_data, '$.paid_installments')
UNION ALL
SELECT path,
       ''                                   AS quantity,
       ''                                   AS paid_installments,
       get_json_object
           (event_data, '$.dashboard_status') AS status,
       count
           (*)                              AS total,
       device.platform                      AS platform,
       application.site_id                  AS site_id,
       substr
           (ds, 1, 10)                      AS date_sent
FROM tracks
WHERE path = '/credits/consumer/administrator_v2/dashboard'
  AND ds >= '@param01'
  AND ds < '@param02'
GROUP BY substr
             (ds, 1, 10),
         path,
         event_data,
         device.platform,
         application.site_id
UNION ALL
SELECT path,
       get_json_object
           (event_data, '$.installments_qty') AS quantity,
       ''                                   AS paid_installments,
       get_json_object
           (event_data, '$.dashboard_status') AS status,
       count
           (*)                              AS total,
       device.platform                      AS platform,
       application.site_id                  AS site_id,
       substr
           (ds, 1, 10)                      AS date_sent
FROM tracks
WHERE (path = '/credits/consumer/administrator_v2/payment_intention_all' or
       path = '/credits/consumer/administrator_v2/dashboard/payment_intention_all')
  AND ds >= '@param01'
  AND ds < '@param02'
GROUP BY substr
             (ds, 1, 10),
         path,
         event_data,
         device.platform,
         application.site_id
UNION ALL
SELECT path,
       ''                              AS quantity,
       ''                              AS paid_installments,
       get_json_object
           (event_data, '$.page_status') AS status,
       COUNT
           (*)                         AS total,
       device.platform                 AS platform,
       application.site_id             AS site_id,
       substr
           (ds, 1, 10)                 AS date_sent
FROM tracks
WHERE path = '/credits/consumer/administrator_v2/installment_selection'
  AND ds >= '@param01'
  AND ds < '@param02'
GROUP BY substr
             (ds, 1, 10),
         path,
         event_data,
         device.platform,
         application.site_id