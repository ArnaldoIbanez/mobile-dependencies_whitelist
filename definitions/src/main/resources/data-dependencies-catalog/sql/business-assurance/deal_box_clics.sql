select 
application.site_id as Site, 
device.platform AS Platform, 
jest(others['fragment'],'L') AS deal_Label,
jest(others['fragment'],'S') AS deal_Source, 
jest(others['fragment'],'V') AS deal_Position,
jest(others['fragment'], 'DEAL_ID') as deal_id, 
count(1) as clics_totales, 
count(distinct(usr.uid)) as Usuarios_Unicos, 
substr(ds,1,10) as Fecha
from tracks
where  ds >= '@param01' and ds < '@param02' and others['fragment'] like '%DEAL_ID%'
group by  substr(ds,1,10),application.site_id, device.platform, jest(others['fragment'],'L') , jest(others['fragment'],'S'),
jest(others['fragment'],'V'),jest(others['fragment'], 'DEAL_ID') 