select 
substr(ds,1,10) as ds, 
application.site_id as Site,
device.platform AS Plataforma,
usr.uid as uid,
jest(event_data, 'seller[0].id') AS SellerID, 
jest(event_data, 'seller.nickname') AS SellerNickname,
jest(event_data, 'buyer.id') AS BuyerID,
jest(event_data, 'buyer.nickname') AS BuyerNickname,
jest(event_data, 'items[0].item.id') AS ItemID, 
jet(event_data, 'items[0].item.category_path') AS CategoryPath,
jest(event_data,'items[0].item.category_id')   AS CategoryID, 
deal.size as banner_size,
deal.banner_name as banner_name,
jet(event_data, 'items[0].item.deal_ids') as eventdata_dealID,
jest(others['fragment'], 'dealID') as others_dealID,
sum(CAST(jest(event_data,'total_amount_usd') AS DOUBLE)) as sum_dol_amount,
count(1) as purchases_total
from tracks orders
INNER JOIN (
			select  application.site_id as Site,
device.platform AS Plataforma,
jest(others['fragment'], 'size') AS size,
jest(others['fragment'], 'banner_name') AS banner_name,
jest(others['fragment'], 'sellerid') AS SellerID,
jest(others['fragment'], 'dealID') AS	others_dealID,
usr.uid
from tracks
where 	   ds >='2017-04-01'
and 	   ds < '2017-04-10'
and others['fragment'] like '%deal%'
and json_format(jet(others['fragment'], 'dealID')) != '[]'
group by  application.site_id, 
device.platform, jest(others['fragment'], 'banner_name'), 
jest(others['fragment'], 'size') , 
jest(others['fragment'], 'sellerid'),
jest(others['fragment'], 'dealID'),
usr.uid
			) deal ON ((json_format(jet(event_data, 'items[0].item.deal_ids')) LIKE concat('%',deal.others_dealID,'"','%'))  and usr.uid = deal.uid)
where 	   ds >='2017-04-01'
and 	   ds < '2017-04-10'
and path = '/orders/ordercreated' 
and application.site_id= 'MLA'
group by substr(ds,1,10),
application.site_id,
device.platform, 
usr.uid,
jest(event_data, 'seller[0].id'), 
jest(event_data, 'seller.nickname'), 
jest(event_data, 'buyer.id'), 
jest(event_data, 'buyer.nickname'), 
jest(event_data, 'items[0].item.id') , 
jet(event_data, 'items[0].item.category_path') ,
jest(event_data, 'items[0].item.category_id'),
deal.size,
deal.banner_name,
jet(event_data, 'items[0].item.deal_ids'),
jest(others['fragment'], 'dealID')