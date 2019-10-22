select 
	substr(ds,1,10) as fecha,
	application.site_id as site,
	count(*) as Cant_Accesos
from tracks
WHERE ds>='@param01' AND ds<'@param02'
and path like '%subscriptions_landing%'
AND application.site_id IN('MLM','MLB')
and application.business='mercadolibre'
and type ='view'
group by substr(ds,1,10),application.site_id