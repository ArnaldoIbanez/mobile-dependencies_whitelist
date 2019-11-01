select  
application.site_id as Site,
device.platform AS Plataforma,
jest(COALESCE(platform.fragment, others['fragment']), 'DEAL_ID') AS	others_dealID,
jest(COALESCE(platform.fragment, others['fragment']),'L') AS deal_Label,
jest(COALESCE(platform.fragment, others['fragment']),'S') AS deal_Source,
jest(COALESCE(platform.fragment, others['fragment']),'V') AS deal_Position,
jest(COALESCE(platform.fragment, others['fragment']),'T') AS deal_Type,
usr.uid,
count(1) as total_clicks,
substr(ds,1,10) as ds
from tracks
where 	   ds >='@param01'
and 	   ds <'@param02'
and COALESCE(platform.fragment, others['fragment']) like '%DEAL_ID%'
and jest(COALESCE(platform.fragment, others['fragment']), 'DEAL_ID') != '[]'
group by 
substr(ds,1,10),
 application.site_id, 
device.platform, 
jest(COALESCE(platform.fragment, others['fragment']),'DEAL_ID'),
jest(COALESCE(platform.fragment, others['fragment']), 'L') ,
jest(COALESCE(platform.fragment, others['fragment']),'S') ,
jest(COALESCE(platform.fragment, others['fragment']),'V') ,
jest(COALESCE(platform.fragment, others['fragment']),'T') ,
usr.uid
