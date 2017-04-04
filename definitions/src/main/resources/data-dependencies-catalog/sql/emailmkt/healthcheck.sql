SELECT ds,
       get_json_object(tracks.event_data,'$.campaign_id') AS campaign_id,
       get_json_object(tracks.event_data,'$.event_type') AS event_type,
       device.platform,
       COUNT(DISTINCT usr.user_id) AS users
FROM tracks
WHERE ds >= '@param01'
AND   ds <= '@param02'
AND   path = '/notification/campaigns_health_check'
GROUP BY ds,
         get_json_object(tracks.event_data,'$.campaign_id'),
         device.platform,
         get_json_object(tracks.event_data,'$.event_type')
