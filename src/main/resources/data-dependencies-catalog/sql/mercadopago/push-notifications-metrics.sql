SELECT ds AS ds,
       get_json_object(event_data,'$.campaign_id') AS campaign_id,
       get_json_object(event_data,'$.event_type') AS event_type,
       device.platform AS platform,
       COUNT(DISTINCT usr.user_id) AS users
FROM tracks
WHERE ds >= '@param01'
AND   ds < '@param02'
AND   TYPE = 'event'
AND   path = '/notification/mpcampaigns_campaigns'
AND   (get_json_object(event_data,'$.context') IS NULL OR get_json_object(event_data,'$.context') = 'notification')
AND   get_json_object(event_data,'$.event_type') IN ('sent', 'arrived', 'open', 'dismiss')
GROUP BY ds,
         get_json_object(event_data,'$.campaign_id'),
         get_json_object(event_data,'$.event_type'),
         device.platform