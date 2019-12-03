SELECT site_deal, platform_deal, deal_Label, deal_Source, deal_Position, deal_Type, deal_id,clics_totales,order_id as Order,
successfullitem AS SI,unit_price AS GMV,fecha_clic
FROM 

(

SELECT site_deal, platform_deal, deal_Label, deal_Source, deal_Position, deal_Type, deal_id, uid_deal,clics_totales,fecha_clic

FROM(
Select *,
ROW_NUMBER() OVER(PARTITION BY fecha_clic,deal_id,uid_deal ORDER BY deal_Source) AS NumeroFila

from 

(select 
 site_deal, 
 platform_deal, 
 deal_Label, 
 deal_Source, 
 deal_Position, 
 deal_Type, 
 deal_id,
 uid_deal,
 count(1) As clics_totales,
 fecha_clic
from (
		 
			 select distinct
			 substr(ds,1,10) as fecha_clic, 
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
group by 	site_deal,  platform_deal,  deal_Label,  deal_Source,  deal_Position,deal_Type, deal_id,uid_deal, fecha_clic
	
) clicks	

	) clicks1 WHERE NumeroFila=1 ) T1

LEFT JOIN

(
select distinct
			substr(ds,1,10) as fecha_order, 
			 application.site_id as site_order, 
			 device.platform AS platform_order, 
			 usr.uid as uid_order, 
			 jest(event_data, 'items[0].item.id') AS ItemID,
			 jest(event_data, 'order_id') AS order_id,
			 dealID as dealID,
			 jest(event_data,'total_amount_usd') as sum_dol_amount,
			 jest(event_data,'items[0].quantity') as successfullitem,
			 jest(event_data,'items[0].unit_price') as unit_price
			from tracks 
			LATERAL VIEW explode(SPLIT(regexp_replace(jest(event_data, 'items[0].item.deal_ids'),'\\[|\\]|"',''),',')) dealTable AS dealID
			WHERE ds>='@param01' AND ds<'@param02'
			and path = '/orders/ordercreated'
			and jest(event_data, 'items[0].item.deal_ids') != '[]' 



) T2

ON ( T1.fecha_clic = T2.fecha_order  AND T1.deal_id = T2.dealID AND T1.uid_deal= T2.uid_order)
