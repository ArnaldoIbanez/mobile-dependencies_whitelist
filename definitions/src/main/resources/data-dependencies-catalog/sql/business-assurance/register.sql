SELECT 
substr (ds,1,10) as ds,
type as Type, 
jest(event_data, 'app') as App, 
jest(event_data, 'source') as Source, 
jest(event_data, 'item_id') as Item_ID,
application.version as Version, 
path as Path,
application.site_id as Site, 
application.business AS Business,
usr.uid AS UserUid,
usr.user_id AS UserId,
device.platform AS Platform,
device.device_name AS Platform_Device,
device.device_type AS Platform_Device_Type,
platform.http.http_referer AS Referer,
platform.http.http_url as Url
from tracks
where path like '/register%'
and ds >= '@param01'
and ds < '@param02'
