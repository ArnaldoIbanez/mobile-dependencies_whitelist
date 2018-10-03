SELECT 
application.site_id as Site, 
jest(event_data, 'page') AS Page,
jest(event_data, 'domain_id') AS Domain_Id, 
path AS Path, 
jest(event_data, 'attribute_type') AS Attribute_Type, 
count(*) as Cantidad,
count(jest(event_data, 'attributes_submitted')) as Cantidad_Attr_Submited,
count(jest(event_data, 'attributes_showed')) as Cantidad_Attr_Showed,
substr(ds,1,10) as Fecha
FROM tracks 
where substr(ds,1,10) >= '@param01' AND substr(ds,1,10)< '@param02' 
and path IN ('/catalogwidget/showitem','/catalogwidget/cancel', '/catalogwidget/save', '/catalogwidget/pi','/catalogwidget/pi_save','/catalogwidget/pi_cancel') AND jest(event_data, 'page') not like '%unknown%' and jest(event_data, 'page') not like '%deals%' 
and application.business='mercadolibre' and type='event'  
group by 
substr(ds,1,10), 
application.site_id, 
jest(event_data, 'page'),
jest(event_data, 'domain_id'),
path,
jest(event_data, 'attribute_type')
