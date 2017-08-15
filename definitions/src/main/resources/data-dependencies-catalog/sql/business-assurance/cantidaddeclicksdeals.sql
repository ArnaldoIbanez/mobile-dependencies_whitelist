select  substr(ds,1,10) as ds,
application.site_id as Site,
device.platform AS Plataforma,
jest(others['fragment'], 'DEAL_ID') AS	others_dealID,
jest(others['fragment'],'L') AS deal_Label,
jest(others['fragment'],'S') AS deal_Source,
jest(others['fragment'],'V') AS deal_Position,
jest(others['fragment'],'T') AS deal_Type,
usr.uid,
count(1) as total_clicks
from tracks
where 	   ds >='2017-08-13'
and 	   ds < '2017-08-14'
and others['fragment'] like '%DEAL%'
and jest(others['fragment'], 'DEAL_ID') != '[]'
group by 
substr(ds,1,10),
 application.site_id, 
device.platform, 
jest(others['fragment'],'DEAL_ID'),
jest(others['fragment'], 'L') ,
jest(others['fragment'],'S') ,
jest(others['fragment'],'V') ,
jest(others['fragment'],'T') ,
usr.uid