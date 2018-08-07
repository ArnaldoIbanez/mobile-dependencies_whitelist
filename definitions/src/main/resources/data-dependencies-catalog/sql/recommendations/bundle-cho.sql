select 
application.site_id site_id, 
device.platform platform,  
sum(CASE WHEN jest(event_data, 'context') = 'vip_combo' THEN 1 ELSE 0 END) buy_intentions_from_combo,
count(1) total_buy_intentions,
substr(ds,1,10) ds
from tracks
where path = '/buy_intention'
and ds >= '@param01'
and ds < '@param02'
and application.site_id IN ('MLB', 'MLM', 'MLA')
and application.business = 'mercadolibre'
and not is_bot(device.user_agent)
group by application.site_id, device.platform, substr(ds,1,10)
