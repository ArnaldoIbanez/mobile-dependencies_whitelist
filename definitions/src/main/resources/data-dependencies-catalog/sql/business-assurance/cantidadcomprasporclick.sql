select
application.site_id as Site,
device.platform AS Plataforma,
usr.uid as uid,
jest(event_data, 'seller[0].id') AS SellerID,
jest(event_data, 'seller.nickname') AS SellerNickname,
jest(event_data, 'buyer.id') AS BuyerID,
jest(event_data, 'buyer.nickname') AS BuyerNickname,
jest(event_data, 'items[0].item.id') AS ItemID,
jet(event_data, 'items[0].item.category_path') AS CategoryPath,
jest(event_data, 'items[0].item.category_id') AS CategoryID,
banner.size as banner_size,
banner.banner_name as banner_name,
sum(CAST(jest(event_data,'total_amount_usd') AS DOUBLE)) as sum_dol_amount,
count(1) as purchases_total,
substr(ds,1,10) as ds
from tracks orders
INNER JOIN (
select substr(ds,1,10),
application.site_id as Site,
device.platform AS Plataforma,
jest(COALESCE(platform.fragment, others['fragment']), 'size') AS size,
jest(COALESCE(platform.fragment, others['fragment']), 'banner_name') AS banner_name,
jest(COALESCE(platform.fragment, others['fragment']), 'sellerid') AS SellerID,
usr.uid as uid
from tracks
where ds >= '@param01' 
and ds < '@param02' 
and COALESCE(platform.fragment, others['fragment']) like '%banner_name%'
group by substr(ds,1,10), application.site_id, device.platform, jest(COALESCE(platform.fragment, others['fragment']), 'banner_name'), 
jest(COALESCE(platform.fragment, others['fragment']), 'size'), jest(COALESCE(platform.fragment, others['fragment']), 'sellerid'), 
usr.uid
) banner ON (jest(event_data, 'seller[0].id') = banner.sellerid and usr.uid = banner.uid)
where ds >= '@param01' 
and ds < '@param02' 
and path = '/orders/ordercreated'
group by substr(ds,1,10),
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
