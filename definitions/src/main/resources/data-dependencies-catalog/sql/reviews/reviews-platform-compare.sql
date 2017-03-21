select substr(ds,1,10) as fecha,
    application.site_id as site,
    path,
    sum(case when (device.platform like '/web/desktop%') then 1 else 0 end) as web_desktop,
    sum(case when (device.platform like '/web/mobile%') then 1 else 0 end) as web_mobile,
    sum(case when (device.platform like '/mobile/android%') then 1 else 0 end) as mobile_android,
    sum(case when (device.platform like '/mobile/ios%') then 1 else 0 end) as mobile_ios
from tracks
where ds >= '@param01'
    and ds < '@param02'
    and application.site_id in ('MLA', 'MLB', 'MLC', 'MLM', 'MCO', 'MLV', 'MPE', 'MLU')
    and ((path = '/reviews/form' and get_json_object(tracks.event_data, '$.flow') = 'open') OR 
        (path = '/reviews/congrats'))
group by substr(ds,1,10), application.site_id, path
