select substr(ds,1,10) as fecha,
    application.site_id as site,
    case when (device.platform like '/email%') then '/email' 
        when (device.platform like '/web/desktop%') then '/web/desktop'
        when (device.platform like '/web/mobile%') then '/web/mobile'
        when (device.platform like '/mobile/android%') then '/mobile/android'
        when (device.platform like '/mobile/ios%') then '/mobile/ios'
        else '/undefined'
    end as platform,
    get_json_object(others['fragment'],'$.entry') as entry,
    count(1) as cant
from tracks
where ds >= '@param01'
    and ds < '@param02'
    and application.site_id in ('MLA', 'MLB', 'MLC', 'MLM', 'MCO', 'MLV', 'MPE', 'MLU')
    and path = '/reviews/form' and get_json_object(tracks.event_data, '$.flow') = 'open'
group by substr(ds,1,10), application.site_id, (case when (device.platform like '/email%') then '/email' 
        when (device.platform like '/web/desktop%') then '/web/desktop'
        when (device.platform like '/web/mobile%') then '/web/mobile'
        when (device.platform like '/mobile/android%') then '/mobile/android'
        when (device.platform like '/mobile/ios%') then '/mobile/ios'
        else '/undefined'
    end), get_json_object(others['fragment'],'$.entry')
