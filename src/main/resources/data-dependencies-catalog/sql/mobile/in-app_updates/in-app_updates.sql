SELECT  application.business,
        application.site_id AS site,
        CASE
          WHEN path = '/in_app_updates/updatable/showed' THEN 'showed'
          WHEN path = '/in_app_updates/inactive/showed' THEN 'showed'
          WHEN path = '/in_app_updates/updatable/accepted' THEN 'accepted'
          WHEN path = '/in_app_updates/inactive/accepted' THEN 'accepted'
          WHEN path = '/in_app_updates/inactive/installed' THEN 'installed'
          WHEN path = '/in_app_updates/updatable/installed' THEN 'installed'
          WHEN path = '/in_app_updates/updatable/update_failed' THEN 'failed'
          WHEN path = '/in_app_updates/inactive/update_failed' THEN 'failed'          
          ELSE 'rejected'
        END AS Action,
        CASE 
          WHEN instr(path, 'inactive') <> 0 THEN 'inactive'
          WHEN instr(path, 'updatable') <> 0 THEN 'updatable' 
          ELSE 'unexpected'
        END AS update_type,
        get_json_object(event_data, '$.type') AS Flow_type,
        COUNT(1) AS How_Many,
        CASE 
          WHEN instr(device.platform, 'android') <> 0 THEN 'android' 
          WHEN instr(device.platform, 'ios') <> 0 THEN 'ios' 
          ELSE 'unexpected'
        END AS platform,
        substr(ds,1,10) AS ds
FROM tracks
WHERE ds >= '@param01'
  AND ds < '@param02'
  AND (path = '/in_app_updates/updatable/showed'
      or path = '/in_app_updates/updatable/postponed'
      or path = '/in_app_updates/updatable/accepted'
      or path = '/in_app_updates/inactive/showed'
      or path = '/in_app_updates/inactive/accepted'
      or path = '/in_app_updates/inactive/installed'
      or path = '/in_app_updates/updatable/installed'
      or path = '/in_app_updates/inactive/update_failed'
      or path = '/in_app_updates/updatable/update_failed')
  AND (device.platform = '/mobile/android'
      or device.platform = '/mobile/ios')
GROUP BY substr(ds,1,10),
         application.business,
         get_json_object(event_data, '$.type'),
         path,
         application.site_id,
         device.platform
