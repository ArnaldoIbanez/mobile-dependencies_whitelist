select 
application.site_id as site,
device.platform AS plataforma,
count(distinct id) as cantidad,
path as evento,
ds
from tracks
where 	   ds >='@param01'
and 	   ds <'@param02'
and  (path = '/vip/shipping_calculator/select' or path =  '/vip/shipping_calculator' or path = '/vip/shipping_calculator/cancel')
group by 
path,
device.platform,
application.site_id,
ds
