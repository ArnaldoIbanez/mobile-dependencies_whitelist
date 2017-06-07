select substr(ds,1,10) as ds, 
application.site_id as Site,
device.platform AS Plataforma,
get_json_object(others['fragment'], '$.size') AS size,
get_json_object(others['fragment'], '$.banner_name') AS banner_name,
get_json_object(others['fragment'], '$.sellerid') AS SellerID,
get_json_object(others['fragment'], '$.dealID') AS	dealID,
count(1) as totalClicks
from tracks
where 	   ds >='2017-04-01'
and 	   ds < '2017-04-12'
and others['fragment'] like '%deal%'
and get_json_object(others['fragment'], '$.dealID') IS NOT NULL
group by substr(ds,1,10), 
application.site_id, 
device.platform, 
get_json_object(others['fragment'], '$.size') ,
get_json_object(others['fragment'], '$.banner_name') ,
get_json_object(others['fragment'], '$.sellerid') ,
get_json_object(others['fragment'], '$.dealID')