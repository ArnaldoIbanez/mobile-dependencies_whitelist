select 
substr(ds,1,10) as ds, 
application.site_id as Site,
device.platform AS Plataforma,
usr.uid as uid,
get_json_object(event_data, '$.seller.id') AS SellerID, 
get_json_object(event_data, '$.seller.nickname') AS SellerNickname,
get_json_object(event_data, '$.buyer.id') AS BuyerID,
get_json_object(event_data, '$.buyer.nickname') AS BuyerNickname,
get_json_object(event_data, '$.order_items[0].item.id') AS ItemID,
get_json_object(event_data, '$.order_items[0].item.category_path') AS CategoryPath,
get_json_object(event_data, '$.order_items[0].item.category_id')   AS CategoryID, 
banner.size as banner_size,
banner.banner_name as banner_name,
sum(CAST(get_json_object(event_data,'$.total_amount_usd') AS DOUBLE)) as sum_dol_amount,
count(1) as purchases_total
from tracks orders
INNER JOIN (
			select substr(ds,1,10), 
			application.site_id as Site,
			device.platform AS Plataforma,
			get_json_object(others['fragment'], '$.size') AS size,
			get_json_object(others['fragment'], '$.banner_name') AS banner_name,
			get_json_object(others['fragment'], '$.seller.id') AS SellerID,
			usr.uid as uid
			from tracks
			where ds >= '2017-01-20'
			and ds < '2017-02-09'
			and others['fragment'] like '%banner_name%'
			group by substr(ds,1,10), 
			application.site_id, 
			device.platform, 
			get_json_object(others['fragment'], '$.banner_name'), 
			get_json_object(others['fragment'], '$.size'), 
			get_json_object(others['fragment'], '$.seller.id'), 
			usr.uid
      ) banner ON (usr.uid = banner.uid)
where ds >= '2017-01-20'
and ds < '2017-02-09'
and path = '/orders/ordercreated'
and (get_json_object(others['fragment'], '$.seller.id') = banner.sellerid or get_json_object(event_data,'$.order_items[0].item.id') like concat('%',banner.sellerid,'"','%'))
group by 
substr(ds,1,10),
application.site_id,
device.platform, 
usr.uid,
get_json_object(event_data, '$.seller.id'), 

get_json_object(event_data, '$.seller.nickname'), 
get_json_object(event_data, '$.buyer.id'), 
get_json_object(event_data, '$.buyer.nickname'), 
get_json_object(event_data, '$.order_items[0].item.id'),
get_json_object(event_data, '$.order_items[0].item.category_path'), 
get_json_object(event_data, '$.order_items[0].item.category_id') , 
banner.size,
banner.banner_name