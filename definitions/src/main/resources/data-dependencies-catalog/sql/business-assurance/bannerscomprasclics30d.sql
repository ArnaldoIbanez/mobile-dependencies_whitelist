select 
substr(user_timestamp,1,10) as orderDate,
substr(banner.last_click_date,1,10) as lastClickDate,
date_diff('day', CAST(substr(user_timestamp,1,10) as date), CAST(substr(banner.last_click_date,1,10) as date)) as day_difference,
application.site_id as Site,
device.platform AS Plataforma,
usr.uid as uid,
jest(event_data, 'seller[0].id') AS SellerID, 
jest(event_data, 'seller.nickname') AS SellerNickname,
jest(event_data, 'buyer.id') AS BuyerID,
jest(event_data, 'buyer.nickname') AS BuyerNickname,
jest(event_data, 'items[0].item.id') AS ItemID, 
jet(event_data,  'items[0].item.category_path') AS CategoryPath,
jest(event_data, 'items[0].item.category_id')   AS CategoryID,
banner.size as banner_size,
banner.banner_name as banner_name,
sum(CAST(jest(event_data,'total_amount_usd') AS DOUBLE)) as sum_dol_amount,
count(1) as purchases_total
from tracks orders
INNER JOIN (
Select Site, Plataforma, size, banner_name, SellerId, uid, max(bds) as last_click_date
From (
			select user_timestamp as bds, 
			application.site_id as Site,
			device.platform AS Plataforma,
			jest(others['fragment'], 'size') AS size,
			jest(others['fragment'], 'banner_name') AS banner_name,
			jest(others['fragment'], 'sellerid') AS SellerID,
			usr.uid as uid
			from tracks
			where ds >= '@param3'
			and ds < '@param2'
			and others['fragment'] like '%banner_name%'
		  )
Group by 	Site, Plataforma, size, banner_name, SellerId, uid
			) banner ON (jest(event_data, 'seller[0].id') = banner.SellerId and usr.uid = banner.uid)
where ds >= '@param1'
and   ds <  '@param2'
and path = '/orders/ordercreated'
group by substr(user_timestamp,1,10),
substr(banner.last_click_date,1,10),
date_diff('day', CAST(substr(user_timestamp,1,10) as date), CAST(substr(banner.last_click_date,1,10) as date)),
application.site_id,
device.platform, 
usr.uid,
jest(event_data, 'seller[0].id'), 
jest(event_data, 'seller.nickname'), 
jest(event_data, 'buyer.id'), 
jest(event_data, 'buyer.nickname'), 
jest(event_data, 'items[0].item.id'),
jet(event_data, 'items[0].item.category_path'),
jest(event_data,'items[0].item.category_id'),
banner.size,
banner.banner_name