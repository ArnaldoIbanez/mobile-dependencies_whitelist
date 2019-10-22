select substr(ds,1,10) as date_utc_4,
       get_json_object(event_data, '$.error_context') as context,
       get_json_object(event_data, '$.error_severity') as severity,
       application.site_id as site_id,
       '<not_yet_tracked>' as vertical,
       application.version as app_version,
       application.business as business,
       device.platform as platform,
       COUNT(*) as count_
from tracks
where ds >= '@param01'
  and ds < '@param02'
  and type = 'event'
  and path = '/mobile/bugsnag'
GROUP BY substr(ds,1,10), 
         get_json_object(event_data, '$.error_context'), 
         get_json_object(event_data, '$.error_severity'),
         application.site_id, '<not_yet_tracked>', application.version,  application.business,
         device.platform