SELECT 
substr(ds,1,10) as ds,
type AS Type,
path AS Path,
event_data as Event_Data,
application.site_id AS Site,
application.business AS Business,
usr.uid AS UserUid,
usr.user_id AS UserId,
device.platform AS Platform,
device.device_name AS Platform_Device,
device.device_type AS Platform_Device_Type,
platform.http.http_referer AS Referer,
platform.http.http_url as Url
FROM tracks
WHERE ds >= '@param01' 
AND ds < '@param02' 
AND  path  like '%/credits/merchant%'

