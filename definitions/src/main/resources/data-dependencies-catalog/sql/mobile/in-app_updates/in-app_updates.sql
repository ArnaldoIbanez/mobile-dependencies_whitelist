SELECT application.business,
       application.site_id AS site,
       CASE
           WHEN path = '/in_app_updates/updatable/showed' THEN 'showed'
           WHEN path = '/in_app_updates/updatable/accepted' THEN 'accepted'
           ELSE 'rejected'
       END AS Action,
       jest
  (event_data, 'type') AS Flow_type,
       COUNT
  (1) AS How_Many,
             substr
  (ds,1,10) AS ds
FROM tracks
WHERE ds >= '@param01'
  AND ds < '@param02'
  AND
    (path = '/in_app_updates/updatable/showed'
     OR path = '/in_app_updates/updatable/accepted'
     OR path = '/in_app_updates/updatable/postponed')
  AND device.platform = '/mobile/android'
GROUP BY substr
  (ds,1,10),
         application.business,
         jest
  (event_data, 'type'),
         path,
         application.site_id
ORDER BY Action DESC,
         How_Many DESC