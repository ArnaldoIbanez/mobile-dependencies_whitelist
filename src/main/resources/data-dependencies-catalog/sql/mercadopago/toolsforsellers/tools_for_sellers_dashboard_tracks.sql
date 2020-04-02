SELECT
  usr.user_id as user_id,
  application.site_id as site_id,
  event_data,
  path,
  type,
  substr(ds,1,10) as ds
FROM tracks
WHERE ds >= '@param01'
AND ds < '@param02'
AND path like '%tfs_dashboard%'