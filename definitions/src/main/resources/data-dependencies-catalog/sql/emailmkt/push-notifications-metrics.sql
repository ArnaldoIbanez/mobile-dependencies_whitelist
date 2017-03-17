SELECT ds AS ds,
       get_json_object(tracks.event_data,'$.campaign_id') AS campaign_id,
       get_json_object(tracks.event_data,'$.event_type') AS event_type,
       device.platform AS platform,
       COUNT(DISTINCT usr.user_id) AS users
FROM tracks
WHERE ds >= '@param01'
AND   ds < '@param02'
AND   TYPE = 'event'
AND   path = '/notification/campaigns_deals'
AND   (get_json_object(tracks.event_data,'$.context') IS NULL OR get_json_object(tracks.event_data,'$.context') = 'notification')
GROUP BY ds,
         get_json_object(tracks.event_data,'$.campaign_id'),
         get_json_object(tracks.event_data,'$.event_type'),
         device.platform
ORDER BY ds,
         campaign_id,
         event_type,
         device.platform;
