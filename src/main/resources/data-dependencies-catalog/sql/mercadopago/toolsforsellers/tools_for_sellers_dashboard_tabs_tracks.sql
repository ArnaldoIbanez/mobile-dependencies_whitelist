select case when path = '/tfs_dashboard/home/general' then 'General'
            when path = '/tfs_dashboard/home/offline' then 'Offline'
            when path = '/tfs_dashboard/home/online' then 'Online'
            when path = '/tfs_dashboard/home/meli' then 'Meli'
            when substring(event_data, 13) = 'general"}' then 'General'
            when substring(event_data, 13) = 'offline"}' then 'Offline'
            when substring(event_data, 13) = 'online"}' then 'Online'
            when substring(event_data, 13) = 'meli"}' then 'Meli' end as path,
            application.site_id as site_id,
            substr(ds,1,10) as ds
from tracks
where path in ('/tfs_dashboard/home/general', '/tfs_dashboard/home/offline','/tfs_dashboard/home/online','/tfs_dashboard/home/meli', '/tfs_dashboard/tab_selection')
AND ds >= '@param01'
AND ds < '@param02'
AND type = 'view'