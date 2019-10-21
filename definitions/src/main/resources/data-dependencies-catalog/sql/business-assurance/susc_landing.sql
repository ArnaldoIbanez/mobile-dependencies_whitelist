select
	substr(ds,1,10) as fecha,
	application.site_id as site_susc, 
	Cate.name as category_name, 
	count(*) as cantidad 
from tracks 
inner join default.categories Cate on jest(event_data, 'category_id')= Cate.id 
where ds>='@param01' and ds<'@param02'
	and path like '/subscriptions_landing/select_item_slide' 
	and application.site_id in('MLM','MLB') and application.business='mercadolibre' 
	and type ='event' 
group by substr(ds,1,10),application.site_id,Cate.name