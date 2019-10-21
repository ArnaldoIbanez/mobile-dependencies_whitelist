select 
application.site_id as Site,
device.platform as Platform,
jest(others['fragment'], 'DEAL_ID') as deal_id,
count(*) as VisitasTotales,
count(Distinct usr.user_id) as UsuariosUnicos_Logueados,
count(Distinct usr.uid) as UsuariosUnicos_Totales,
substr(ds,1,10) as Fecha
from tracks 
where path='/deals/landing'
and application.business='mercadolibre'
and ds >= '@param01' and ds < '@param02'
and type='view'
AND jest(others['fragment'], 'DEAL_ID')is not null 
AND jest(others['fragment'], 'DEAL_ID') <> ''
group by substr(ds,1,10),application.site_id,device.platform,jest(others['fragment'], 'DEAL_ID')
