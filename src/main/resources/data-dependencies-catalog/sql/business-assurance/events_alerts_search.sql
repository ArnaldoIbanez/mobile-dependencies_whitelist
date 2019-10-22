SELECT 
substr(ds,1,10) as ds,
type AS Type,
path AS Path,
application.site_id AS Site,
application.business AS Business,
usr.uid AS UserUid,
usr.user_id AS UserId,
device.platform AS Platform,
platform.http.http_referer AS Referer,
platform.http.http_url as Url,
jest(event_data, 'vertical') AS Vertical
FROM tracks
WHERE ds >= '@param01' AND ds < '@param02'
AND 
path IN ('/vip','/vip/contact_seller', '/vip/show_phone', '/vip/call_seller')
AND (platform.fragment  LIKE '%SA:true,SID%'  OR platform.http.http_referer LIKE '%searchAlertsMail_true%')