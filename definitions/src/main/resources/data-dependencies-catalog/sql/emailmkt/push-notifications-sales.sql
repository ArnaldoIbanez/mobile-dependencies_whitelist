select	t1.ds as ds,
		get_json_object(t2.event_data,'$.campaign_id') as campaign_id,
		t1.device.platform as platform,
		count(distinct t1.usr.user_id) as users,
		count(distinct get_json_object (t1.event_data,'$.order_id')) as orders,
		sum(cast(get_json_object (t1.event_data,'$.order_items[0].quantity') as BIGINT)) as si,
		sum(cast(get_json_object (t1.event_data,'$.total_amount_usd') as DOUBLE)) as gmv
from	tracks t1, tracks t2
where	t1.ds >= '@param02'
		and t1.ds < '@param03'
		and t1.TYPE = 'event'
		and t1.path = '/orders/ordercreated'
		and cast(get_json_object (t1.event_data,'\$.total_amount_usd') AS DOUBLE) < 10000
		and t2.ds >= '@param01'
		and t2.ds < '@param03'
		and t2.TYPE = 'event'
		and t2.path = '/notification/campaigns_deals'
		and ((get_json_object(t2.event_data,'$.context')) is null or (get_json_object(t2.event_data,'$.context')) = 'notification')
		and (get_json_object(t2.event_data,'$.event_type')) = 'open'
		and t2.user_local_timestamp >= '@param01'
		and t2.user_local_timestamp < '@param03'
		and t1.usr.user_id = t2.usr.user_id
		and t1.ds >= t2.ds
group by	t1.ds,
			(get_json_object(t2.event_data,'$.campaign_id')),
			t1.device.platform,
			get_json_object (t1.event_data,'$.order_id');