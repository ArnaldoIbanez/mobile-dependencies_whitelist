select
device.platform AS Plataforma,
get_json_object(event_data, '$.seller[0].id') AS SellerID,
get_json_object(COALESCE(platform.fragment, others['fragment']), '$.DEAL_ID') AS	Deals,
banner.banner_name as banner_name,
sum(CAST(get_json_object(event_data,'$.total_amount_usd') AS DOUBLE)) as sum_dol_amount,
count(1) as purchases_total,
substr(ds,1,10) as ds
from tracks orders
INNER JOIN (
select substr(ds,1,10) ,
device.platform AS Plataforma,
get_json_object(COALESCE(platform.fragment, others['fragment']), '$.size') AS size,
get_json_object(COALESCE(platform.fragment, others['fragment']), '$.banner_name') AS banner_name,
get_json_object(COALESCE(platform.fragment, others['fragment']), '$.sellerid') AS SellerID,
get_json_object(COALESCE(platform.fragment, others['fragment']), '$.DEAL_ID') AS	Deals,
usr.uid as uid
from tracks
where ds >= '@param01' 
and ds < '@param02' 
and get_json_object(COALESCE(platform.fragment, others['fragment']), '$.banner_name') like 'ADV%'
group by substr(ds,1,10), device.platform, get_json_object(COALESCE(platform.fragment, others['fragment']), '$.banner_name'),
get_json_object(COALESCE(platform.fragment, others['fragment']), '$.size'), get_json_object(COALESCE(platform.fragment, others['fragment']), '$.sellerid'),
get_json_object(COALESCE(platform.fragment, others['fragment']), '$.DEAL_ID'),
usr.uid
) banner ON (get_json_object(event_data, '$.seller[0].id') = banner.sellerid and usr.uid = banner.uid)
where ds >= '@param01' 
and ds < '@param02' 
and path = '/orders/ordercreated'
group by substr(ds,1,10),
device.platform,
get_json_object(event_data, '$.seller[0].id'),
get_json_object(COALESCE(platform.fragment, others['fragment']), '$.DEAL_ID'),
banner.banner_name
