SELECT count(*) AS total,
             'expressView' AS eventname,
             device.platform,
             jest
  (event_data, 'environment') AS environment,
             application.version, substr(ds, 1, 10) as ds_date
FROM default.tracks
WHERE path = '/checkout_off/v1/express'
  AND ds >= '@param01'
  AND ds < '@param02'
  AND application.site_id = 'MLA'
  AND device.platform LIKE '/mobile/%'
GROUP BY jest
  (event_data, 'environment'),
         device.platform,
         application.version, substr(ds, 1, 10)
UNION ALL
SELECT count(*) AS total,
             'openSummary' AS eventname,
             device.platform,
             jest
  (event_data, 'environment') AS environment,
             application.version, substr(ds, 1, 10) as ds_date
FROM default.tracks
WHERE path = '/checkout_off/v1/express'
  AND ds >= '@param01'
  AND ds < '@param02'
  AND application.site_id = 'MLA'
  AND device.platform LIKE '/mobile/%'
  AND jest
    (event_data, 'checkout_flow_id') IN
    (SELECT jest
       (event_data, 'checkout_flow_id')
     FROM default.tracks
     WHERE path = '/checkout_off/v1/open_summary_detail'
       AND ds >= '@param01'
       AND ds < '@param02'
       AND application.site_id = 'MLA'
       AND device.platform LIKE '/mobile/%')
GROUP BY jest
  (event_data, 'environment'),
         device.platform,
         application.version, substr(ds, 1, 10)
UNION ALL
SELECT count(*) AS total,
             'backAction' AS eventname,
             device.platform,
             jest
  (event_data, 'environment') AS environment,
             application.version, substr(ds, 1, 10) as ds_date
FROM default.tracks
WHERE path = '/checkout_off/v1/express'
  AND ds >= '@param01'
  AND ds < '@param02'
  AND application.site_id = 'MLA'
  AND device.platform LIKE '/mobile/%'
  AND jest
    (event_data, 'checkout_flow_id') IN
    (SELECT jest
       (event_data, 'checkout_flow_id')
     FROM default.tracks
     WHERE path = '/checkout_off/v1/back_action'
       AND ds >= '@param01'
       AND ds < '@param02'
       AND application.site_id = 'MLA'
       AND device.platform LIKE '/mobile/%')
GROUP BY jest
  (event_data, 'environment'),
         device.platform,
         application.version, substr(ds, 1, 10)
UNION ALL
SELECT count(*) AS total,
             'checkoutConfirmed' AS eventname,
             device.platform,
             jest
  (event_data, 'environment') AS environment,
             application.version, substr(ds, 1, 10) as ds_date
FROM default.tracks
WHERE path = '/checkout_off/v1/express'
  AND ds >= '@param01'
  AND ds < '@param02'
  AND application.site_id = 'MLA'
  AND device.platform LIKE '/mobile/%'
  AND jest
    (event_data, 'checkout_flow_id') IN
    (SELECT jest
       (event_data, 'checkout_flow_id')
     FROM default.tracks
     WHERE path = '/checkout_off/v1/checkout_confirmed'
       AND jest
         (event_data, 'screen_name') = '/express'
       AND ds >= '@param01'
       AND ds < '@param02'
       AND application.site_id = 'MLA'
       AND device.platform LIKE '/mobile/%')
GROUP BY jest
  (event_data, 'environment'),
         device.platform,
         application.version, substr(ds, 1, 10)
UNION ALL
SELECT count(*) AS total,
             'changePaymentMethod' AS eventname,
             device.platform,
             jest
  (event_data, 'environment') AS environment,
             application.version, substr(ds, 1, 10) as ds_date
FROM default.tracks
WHERE path = '/checkout_off/v1/express'
  AND ds >= '@param01'
  AND ds < '@param02'
  AND application.site_id = 'MLA'
  AND device.platform LIKE '/mobile/%'
  AND jest
    (event_data, 'checkout_flow_id') IN
    (SELECT jest
       (event_data, 'checkout_flow_id')
     FROM default.tracks
     WHERE path = '/checkout_off/v1/payment_option'
       AND ds >= '@param01'
       AND ds < '@param02'
       AND application.site_id = 'MLA'
       AND device.platform LIKE '/mobile/%')
GROUP BY jest
  (event_data, 'environment'),
         device.platform,
         application.version, substr(ds, 1, 10)