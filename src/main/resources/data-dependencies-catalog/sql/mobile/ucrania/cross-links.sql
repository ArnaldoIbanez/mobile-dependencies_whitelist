SELECT  application.business AS APP,
        application.site_id AS SITE,
        application.version AS APP_VERSION,
        CASE
          WHEN device.platform = '/mobile/android' THEN 'Android'
          WHEN device.platform = '/mobile/ios' THEN 'iOS'
        END AS PLATFORM,
        CASE
          WHEN path = '/cross_app_links/dispatch' THEN 'dispatch'
          WHEN path = '/cross_app_links/fetch' THEN 'fetch'
        END AS ACTION,
        CASE 
          WHEN jest(event_data, 'reason') IS NULL THEN 'NONE'
          WHEN jest(event_data, 'reason') = 'TARGET_APP_NOT_INSTALLED' THEN 'APP_NOT_INSTALLED'
          WHEN jest(event_data, 'reason') = 'TARGET_APP_VERSION_NOT_ALLOWED' THEN 'APP_NOT_UPDATED'
          ELSE jest(event_data, 'reason')
        END AS REASON,
        CASE
          WHEN jest(event_data, 'result') = 'LINK_SUCCESS' THEN 'SUCCESS'
          WHEN jest(event_data, 'result') = 'LINK_FAILURE' THEN 'FAILURE'
          WHEN jest(event_data, 'result') IS NULL THEN 'NONE'
        END AS RESULT,
        CASE
          WHEN jest(event_data, 'from') IS NULL THEN 'NOT SPECIFIED'
          ELSE jest(event_data, 'from')
        END AS FRONTEND,
        COUNT(1) AS HOW_MANY,
        substr(ds,1,10) AS ds
FROM tracks
WHERE ds >= '@param01'
  AND ds < '@param02'
  AND (path = '/cross_app_links/dispatch'
      OR (path = '/cross_app_links/fetch' AND jest(event_data, 'provider') = 'LOCAL_PROVIDER'))
  AND (jest(event_data, 'link') LIKE 'meli:%' OR jest(event_data, 'link') LIKE 'mercadopago:%')
GROUP BY substr(ds,1,10),
         application.business,
         application.version,
         device.platform,
         path,
         jest(event_data, 'reason'),
         jest(event_data, 'result'),
         jest(event_data, 'from'),
         application.site_id