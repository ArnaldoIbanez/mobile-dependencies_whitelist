select 
application.site_id site_id, 
device.platform platform,  
count(*) total_buy_intentions,
substr(ds,1,10) ds
from tracks
where path = '/buy_intention'
and ds >= '@param01'
and ds < '@param02'
and jest(event_data, 'context') = 'vip_combo'
and application.site_id IN ('MLB')
and application.business = 'mercadolibre'
and not is_bot(device.user_agent)
group by application.site_id, device.platform, substr(ds,1,10)
