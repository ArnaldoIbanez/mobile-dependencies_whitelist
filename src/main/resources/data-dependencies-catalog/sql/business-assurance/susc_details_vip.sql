SELECT substr(ds,1,10) as fecha, 
       application.site_id as site, 
       Cate.name as category_name,
       count(*) as Cantidad_Items
from tracks
inner join default.categories Cate on jest(event_data, 'category_id')= Cate.id 
WHERE ds>='@param01' AND ds<'@param02' 
AND path LIKE '%vip%'
and type = 'view'
and application.site_id IN('MLB','MLM')
AND application.business='mercadolibre'
and jest(event_data ,'available_subscriptions')='true' 
GROUP BY substr(ds,1,10),application.site_id,Cate.name
