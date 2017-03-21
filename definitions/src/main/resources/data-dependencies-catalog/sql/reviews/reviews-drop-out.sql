select substr(ds,1,10) as fecha,
    application.site_id as site,
    case when (device.platform like '/email%') then '/email' 
        when (device.platform like '/web/desktop%') then '/web/desktop'
        when (device.platform like '/web/mobile%') then '/web/mobile'
        when (device.platform like '/mobile/android%') then '/mobile/android'
        when (device.platform like '/mobile/ios%') then '/mobile/ios'
        else '/undefined'
    end as platform,
    path,
    sum(case when (get_json_object(tracks.event_data, '$.flow') = 'open') then 1 else 0 end) as open,
    sum(case when (get_json_object(tracks.event_data, '$.flow') = 'click_star') then 1 else 0 end) as click_star,
    sum(case when (get_json_object(tracks.event_data, '$.flow') = 'description_keyup') then 1 else 0 end) as add_desc,
    sum(case when (get_json_object(tracks.event_data, '$.flow') = 'title_keyup') then 1 else 0 end) as add_title,
    sum(case when (get_json_object(tracks.event_data, '$.flow') = 'congrats') then 1 else 0 end) as congrats
from tracks
where ds >= '@param01'
    and ds < '@param02'
    and application.site_id in ('MLA', 'MLB', 'MLC', 'MLM', 'MCO', 'MLV', 'MPE', 'MLU')
    and path = '/reviews/form'
group by substr(ds,1,10), application.site_id, (case when (device.platform like '/email%') then '/email' 
        when (device.platform like '/web/desktop%') then '/web/desktop'
        when (device.platform like '/web/mobile%') then '/web/mobile'
        when (device.platform like '/mobile/android%') then '/mobile/android'
        when (device.platform like '/mobile/ios%') then '/mobile/ios'
        else '/undefined'
    end), path
