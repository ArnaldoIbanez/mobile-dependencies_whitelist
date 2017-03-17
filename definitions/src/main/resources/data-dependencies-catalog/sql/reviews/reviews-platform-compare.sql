select substr(ds,1,10) as fecha,
    application.site_id as site,
    path,
    count_if(device.platform like '/web/desktop%') as web_desktop,
    count_if(device.platform like '/web/mobile%') as web_mobile
from tracks
where ds >= '@param01'
    and ds < '@param02'
    and application.site_id in ('MLA', 'MLB', 'MLC', 'MLM', 'MCO', 'MLV', 'MPE', 'MLU')
    and ((path = '/reviews/form' and json2txt(jet(event_data, 'flow')) = '"open"') OR 
        (path = '/reviews/congrats'))
group by 1, 2, 3
