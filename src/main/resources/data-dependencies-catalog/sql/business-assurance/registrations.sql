SELECT 
count(distinct usr.uid) as UID ,
substr(ds,1,10) as DS,  
get_json_object(event_data, '$.app') as App,
Path as Path,
application.Site_Id as Site,
Type as Types,
device.platform as Platform
FROM tracks 
where path like '/register/%' 
and ds >= '@param01' and ds < '@param02'
group by substr(ds,1,10) , get_json_object(event_data, '$.app') , Path,  application.Site_Id, type, device.platform