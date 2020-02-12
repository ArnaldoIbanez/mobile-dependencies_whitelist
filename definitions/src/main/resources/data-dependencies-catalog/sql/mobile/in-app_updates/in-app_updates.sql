  (SELECT application.business,
          application.site_id AS site,
          CASE
              WHEN path = '/in_app_updates/updatable/showed' THEN 'showed'
              WHEN path = '/in_app_updates/updatable/accepted' THEN 'accepted'
              ELSE 'rejected'
          END AS Action,
          CASE
              WHEN event_data LIKE '%flexible%' THEN 'Google Flexible'
              WHEN event_data LIKE '%immediate%' THEN 'Google Immediate'
              ELSE 'Bump'
          END AS Flow_Type,
          COUNT
     (1) AS How_Many
   FROM tracks
   WHERE ds >= '@param01'
     AND ds < '@param02'
     AND
       (path = '/in_app_updates/updatable/showed'
        OR path = '/in_app_updates/updatable/accepted'
        OR path = '/in_app_updates/updatable/postponed')
     AND device.platform = '/mobile/android'
   GROUP BY application.business,
            event_data,
            path,
            application.site_id)
UNION
  (SELECT application.business,
          'ALL' AS site,
          CASE
              WHEN path = '/in_app_updates/updatable/showed' THEN 'showed'
              WHEN path = '/in_app_updates/updatable/accepted' THEN 'accepted'
              ELSE 'rejected'
          END AS Action,
          CASE
              WHEN event_data LIKE '%flexible%' THEN 'Google Flexible'
              WHEN event_data LIKE '%immediate%' THEN 'Google Immediate'
              ELSE 'Bump'
          END AS Flow_Type,
          COUNT
     (1) AS How_Many
   FROM tracks tw
   WHERE ds >= '@param01'
     AND ds < '@param02'
     AND
       (path = '/in_app_updates/updatable/showed'
        OR path = '/in_app_updates/updatable/accepted'
        OR path = '/in_app_updates/updatable/postponed')
     AND device.platform = '/mobile/android'
   GROUP BY application.business,
            path,
            event_data)
ORDER BY Action DESC,
         How_Many DESC