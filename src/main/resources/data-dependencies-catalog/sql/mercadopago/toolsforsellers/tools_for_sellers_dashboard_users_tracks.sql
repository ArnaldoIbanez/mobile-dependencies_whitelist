SELECT
  usr.user_id as user_id,
  application.site_id as site_id,
  substr(ds,1,10) as ds
FROM melidata.tracks_mp
WHERE ds >= '@param01'
AND ds < '@param02'
AND path like '%tfs_dashboard%'
group by usr.user_id, substr(ds,1,10), application.site_id