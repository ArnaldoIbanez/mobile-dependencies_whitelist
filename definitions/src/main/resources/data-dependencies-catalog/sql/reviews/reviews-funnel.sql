select substr(ds,1,10) as fecha,
    application.site_id as site,
    case when (device.platform like '/email%') then '/email' 
        when (device.platform like '/web/desktop%') then '/web/desktop'
        when (device.platform like '/web/mobile%') then '/web/mobile'
        else '/undefined'
    end as platform,
    count_if(path = '/reviews/email') as open_mail,
    count_if(path = '/reviews/form' and json2txt(jet(event_data, 'flow')) = '"open"') as open_form,
    count_if(path = '/reviews/congrats') as congrats
from tracks
where ds >= '@param01'
    and ds < '@param02'
    and application.site_id in ('MLA', 'MLB', 'MLC', 'MLM', 'MCO', 'MLV', 'MPE', 'MLU')
    and path in ('/reviews/email','/reviews/form','/reviews/congrats')
group by 1, 2, 3
