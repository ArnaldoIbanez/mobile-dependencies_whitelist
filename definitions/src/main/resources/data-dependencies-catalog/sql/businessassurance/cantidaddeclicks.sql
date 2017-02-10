select substr(ds,1,10) as ds, 
application.site_id as Site,
device.platform AS Plataforma,
get_json_object(others['fragment'], '$.size') AS size,
get_json_object(others['fragment'], '$.banner_name') AS banner_name,
get_json_object(others['fragment'], '$.sellerid') AS SellerID,
count(1) as total
from tracks
where 	   ds >='2017-01-20'
and 	   ds <'2017-02-09'
and others['fragment'] like '%banner_name%'
group by substr(ds,1,10), 
application.site_id, 
device.platform, 
get_json_object(others['fragment'], '$.banner_name'), 
get_json_object(others['fragment'], '$.size') , 
get_json_object(others['fragment'], '$.sellerid') 