select
application.site_id as Site,
device.platform AS Plataforma,
get_json_object(event_data, '$.seller[0].id') AS SellerID,
get_json_object(event_data, '$.seller.nickname') AS SellerNickname,
get_json_object(event_data, '$.buyer.id') AS BuyerID,
get_json_object(event_data, '$.buyer.nickname') AS BuyerNickname,
get_json_object(event_data, '$.items[0].item.id') AS ItemID,
get_json_object(event_data, '$.items[0].item.category_path') AS CategoryPath,
get_json_object(event_data, '$.items[0].item.category_id') AS CategoryID,
banner.size as banner_size,
banner.banner_name as banner_name,
sum(CAST(get_json_object(event_data,'$.total_amount_usd') AS DOUBLE)) as sum_dol_amount,
count(1) as purchases_total,
substr(ds,1,10) as ds
from tracks orders
INNER JOIN (
select substr(ds,1,10),
application.site_id as Site,
device.platform AS Plataforma,
get_json_object(COALESCE(platform.fragment, others['fragment']), '$.size') AS size,
get_json_object(COALESCE(platform.fragment, others['fragment']), '$.banner_name') AS banner_name,
get_json_object(COALESCE(platform.fragment, others['fragment']), '$.sellerid') AS SellerID,
usr.uid as uid
from tracks
where ds >= '@param01' 
and ds < '@param02' 
and COALESCE(platform.fragment, others['fragment']) like '%banner_name%'
group by substr(ds,1,10), application.site_id, device.platform, get_json_object(COALESCE(platform.fragment, others['fragment']), '$.banner_name'),
get_json_object(COALESCE(platform.fragment, others['fragment']), '$.size'), get_json_object(COALESCE(platform.fragment, others['fragment']), '$.sellerid'),
usr.uid
) banner ON (get_json_object(event_data, '$.seller[0].id') = banner.sellerid and usr.uid = banner.uid)
where ds >= '@param01' 
and ds < '@param02' 
and path = '/orders/ordercreated'
group by substr(ds,1,10),
application.site_id,
device.platform,
get_json_object(event_data, '$.seller[0].id'),
get_json_object(event_data, '$.seller.nickname'),
get_json_object(event_data, '$.buyer.id'),
get_json_object(event_data, '$.buyer.nickname'),
get_json_object(event_data, '$.items[0].item.id'),
get_json_object(event_data, '$.items[0].item.category_path'),
get_json_object(event_data,'$.items[0].item.category_id'),
banner.size,
banner.banner_name
