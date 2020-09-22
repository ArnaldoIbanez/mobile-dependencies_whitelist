select event_data, path, type, application.site_id as site_id, substr(ds,1,10) as ds
from melidata.tracks_mp
where path in ('/tfs_dashboard/home/general', '/tfs_dashboard/home/offline','/tfs_dashboard/home/online','/tfs_dashboard/home/meli', '/tfs_dashboard/tab_selection', '/tfs_dashboard/compare')
AND ds >= '@param01'
AND ds < '@param02'
