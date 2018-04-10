select 
	substr(ds,1,10) as fecha,
	application.site_id as site, 
	if(tracks.path like '/subscriptions_landing/select_item_slide',1,0) as Select_Item, 
	if(tracks.path like '/subscriptions_landingl/subscription_myml',1,0) as Suscription_myml, 
	if(tracks.path like '/subscriptions_landing/terms_condition',1,0) as Terms, 
	if(tracks.path like '/subscriptions/select_other_product',1,0) as Select_Other_Product 
from tracks
WHERE ds>='@param01' AND ds<'@param02'
and path like '%/subscriptions_landing/%' 
AND application.site_id in('MLM','MLB') 
and application.business='mercadolibre' 
and type ='event'