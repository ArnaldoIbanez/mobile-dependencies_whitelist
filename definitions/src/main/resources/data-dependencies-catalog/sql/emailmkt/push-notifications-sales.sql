select	ds as ds,
		campaign_id as campaign_id,
		platform as platform,
		count(distinct user_id) as users,
		count(distinct order_id) as orders,
		sum(items_quantity) as si,
		sum(total_amount_usd) as gmv
from	emailmarketing_push_orders
where	ds >= 'param02'
		and ds < 'param01'
group by	ds,
			campaign_id,
			platform;