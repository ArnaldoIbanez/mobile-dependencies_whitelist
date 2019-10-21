select 
 site_deal, 
 platform_deal, 
 deal_Label, 
 deal_Source, 
 deal_Position, 
 deal_Type, 
 deal_id,
 count(1) as clics_totales, 
 count(distinct(uid_deal)) as clics_unicos, 
 count(uid_order) as orders, 
 sum(distinct cast(sum_dol_amount as double)) as gmv,
 fecha_clic
from (
		 (
			select substr(ds,1,10) as fecha_clic, 
			 application.site_id as site_deal, 
			 device.platform AS platform_deal, 
			 jest(COALESCE(platform.fragment, others['fragment']),'L') AS deal_Label,
			 jest(COALESCE(platform.fragment, others['fragment']),'S') AS deal_Source, 
			 jest(COALESCE(platform.fragment, others['fragment']),'V') AS deal_Position, 
			 jest(COALESCE(platform.fragment, others['fragment']),'T') AS deal_Type,
			 jest(COALESCE(platform.fragment, others['fragment']), 'DEAL_ID') as deal_id, 
			 usr.uid as uid_deal
			from tracks
             WHERE ds>='@param01' AND ds<'@param02'
			 and COALESCE(platform.fragment, others['fragment']) like '%DEAL_ID%'
		)deal 
	inner join
		(
			select substr(ds,1,10) as fecha_order, 
			 application.site_id as site_order, 
			 device.platform AS platform_order, 
			 usr.uid as uid_order, 
			 jest(event_data, 'buyer.id') AS BuyerID,
			 jest(event_data, 'buyer.nickname') AS BuyerNickname, 
			 jest(event_data, 'items[0].item.id') AS ItemID, 
			 jet(event_data, 'items[0].item.category_path') AS CategoryPath,
			 jest(event_data,'items[0].item.category_id')  AS CategoryID, 
			 dealID as dealID,
			 jest(event_data,'total_amount_usd') as sum_dol_amount
			from tracks
			LATERAL VIEW explode(SPLIT(regexp_replace(jest(event_data, 'items[0].item.deal_ids'),'\\[|\\]|"',''),',')) dealTable AS dealID
			WHERE ds>='@param01' AND ds<'@param02'
			and path = '/orders/ordercreated'
			and jest(event_data, 'items[0].item.deal_ids') != '[]'
		)orders

		ON (orders.dealID = deal.deal_id and orders.uid_order = deal.uid_deal and orders.fecha_order = deal.fecha_clic)
)
group by fecha_clic, site_deal, platform_deal, deal_Label, deal_Source, deal_Position, deal_Type, deal_id