select 
application.site_id as Site,
device.platform AS Plataforma,
get_json_object(COALESCE(platform.fragment, others['fragment']), '$.size') AS size,
get_json_object(COALESCE(platform.fragment, others['fragment']), '$.banner_name') AS banner_name,
get_json_object(COALESCE(platform.fragment, others['fragment']), '$.sellerid') AS SellerID,
count(1) as total,
substr(ds,1,10) as ds
from tracks
where 	   ds >='@param01'
and 	   ds <'@param02'
and COALESCE(platform.fragment, others['fragment']) like '%banner_name%'
group by substr(ds,1,10), 
application.site_id, 
device.platform, 
get_json_object(COALESCE(platform.fragment, others['fragment']), '$.banner_name'), 
get_json_object(COALESCE(platform.fragment, others['fragment']), '$.size') , 
get_json_object(COALESCE(platform.fragment, others['fragment']), '$.sellerid') 