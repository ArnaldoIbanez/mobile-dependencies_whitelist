select substr(ds,1,10) as fecha,
    application.site_id as site,
    platform_level(device.platform,2) AS platform,
    path,
    get_json_object(tracks.event_data, '$.flow') as step,
    count(1) as cant
from tracks
where ds >= '@param01 02' 
	and ds < '@param02 02'
    and application.site_id in ('MLA', 'MLB', 'MLC', 'MLM', 'MCO', 'MLV', 'MPE', 'MLU')
    and path = '/reviews/form'
group by substr(ds,1,10), application.site_id, platform_level(device.platform,2), path, get_json_object(tracks.event_data, '$.flow')
