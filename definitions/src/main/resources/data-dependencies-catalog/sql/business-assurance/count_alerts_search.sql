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
WHERE ds >= '2017-04-21' AND ds <= '@param01'
AND 
path LIKE '/search/save'