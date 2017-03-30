select substr(ds,1,10) as fecha,
    application.site_id as site,
    platform_level(device.platform,2) AS platform,
    get_json_object(others['fragment'],'$.entry') as entry,
    count(1) as cant
from tracks
where ds >= '@param01 02' 
	and ds < '@param02 02'
    and application.site_id in ('MLA', 'MLB', 'MLC', 'MLM', 'MCO', 'MLV', 'MPE', 'MLU')
    and path = '/reviews/form' and get_json_object(tracks.event_data, '$.flow') = 'open'
group by substr(ds,1,10), application.site_id, platform_level(device.platform,2), get_json_object(others['fragment'],'$.entry')
