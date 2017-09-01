select 
substr(ds,1,10) as ds, 
application.site_id as Site,
device.platform AS Plataforma,
usr.uid as uid,
jest(event_data, 'buyer.id') AS BuyerID,
jest(event_data, 'buyer.nickname') AS BuyerNickname,
jest(event_data, 'items[0].item.id') AS ItemID, 
jet(event_data, 'items[0].item.category_path') AS CategoryPath,
jest(event_data,'items[0].item.category_id')   AS CategoryID, 
deal.deal_Label as  deal_Label,
deal.deal_Source as deal_Source,
deal.deal_Position as deal_Position,
deal.deal_Type as deal_Type,
jest(event_data, 'items[0].item.deal_ids') as eventdata_dealID,
sum(CAST(jest(event_data,'total_amount_usd') AS DOUBLE)) as sum_dol_amount,
count(1) as purchases_total
from tracks orders
INNER JOIN (
			select  application.site_id as Site,
device.platform AS Plataforma,
others_dealID,
jest(others['fragment'],'L') AS deal_Label,
jest(others['fragment'],'S') AS deal_Source,
jest(others['fragment'],'V') AS deal_Position,
jest(others['fragment'],'T') AS deal_Type,
jest(others['fragment'], 'DEAL_ID'),
usr.uid
from tracks
LATERAL VIEW explode(SPLIT(jest(others['fragment'], 'DEAL_ID'),'"')) dealTable AS others_dealID
where ds >= '@param01'
and   ds <  '@param02'
and others['fragment'] like '%DEAL_ID%'
and jest(others['fragment'], 'DEAL_ID')!= ''
group by  application.site_id, 
device.platform, 
jest(others['fragment'], 'size') , 
others_dealID,
jest(others['fragment'], 'L') ,
jest(others['fragment'],'S') ,
jest(others['fragment'],'V') ,
jest(others['fragment'],'T') ,
jest(others['fragment'], 'DEAL_ID'),
usr.uid
)deal ON (jest(event_data, 'items[0].item.deal_ids') like ('%M%') and usr.uid = deal.uid)
where ds >= '@param01'
and   ds <  '@param02'
and path = '/orders/ordercreated'
group by substr(ds,1,10),
application.site_id,
device.platform, 
usr.uid,
jest(event_data, 'buyer.id'), 
jest(event_data, 'buyer.nickname'), 
jest(event_data, 'items[0].item.id') , 
jet(event_data, 'items[0].item.category_path') ,
jest(event_data, 'items[0].item.category_id'),
deal.deal_Label,
deal.deal_Source,
deal.deal_Position,
deal.deal_Type,
jest(event_data, 'items[0].item.deal_ids'),
others_dealID