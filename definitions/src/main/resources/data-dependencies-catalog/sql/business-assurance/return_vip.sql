select application.site_id as Site_vip, device.platform AS Plataforma_vip, jest(event_data, 'return_available') as Dev_option_vip, jest(event_data, 'item_id') as Item_vip,
  count(distinct usr.uid) as Cantidad_vip, substr(ds,1,10) as Fecha_vip 
  from tracks
  where ds >= '@param01' 
    AND ds < '@param02'
    AND usr.user_id != '' 
    and usr.user_id != '0' 
    AND usr.user_nick != '' 
    AND usr.user_nick != '0'
    AND NOT is_bot(device.user_agent)
    and path = '/vip'
    AND application.site_id = 'MLM'
    AND ( jest(event_data, 'return_available') = 'Yes' or jest(event_data, 'return_available') = 'No')
  group by  application.site_id, 
  device.platform, jest(event_data, 'item_id'),
  jest(event_data, 'return_available'), substr(ds,1,10)
