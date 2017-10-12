select vips_dev.site as Site_order, vips_dev.Plataforma as Plataforma_order, vips_dev.dev_option as Dev_option_order, vips_dev.ItemID as Item_order, count(1) as Cantidad_order, orders.ds as Fecha_order, orders.category_order as Category_order
from 
  (select application.site_id as Site, device.platform AS Plataforma, jest(event_data, 'item_id') as ItemID,
  usr.uid, jest(event_data, 'return_available') as dev_option
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
  device.platform, jest(event_data, 'item_id') ,
  usr.uid,jest(event_data, 'return_available'),
  substr(ds,1,10))vips_dev
  
  join 
  
(select substr(ds,1,10) as ds, application.site_id as Site_order, device.platform AS plataforma_order, usr.uid as uid_order, jest(event_data, 'items[0].item.id') AS ItemID_order, jest(event_data, 'items[0].item.category_id') as category_order
  from tracks         
  where ds >= '@param01' 
    AND ds < '@param02'
  and path = '/orders/ordercreated' 
  AND application.site_id = 'MLM') orders

  ON  (orders.site_order = vips_dev.site and orders.plataforma_order = vips_dev.Plataforma and orders.uid_order = vips_dev.uid and orders.ItemID_order = vips_dev.ItemID)

where orders.ItemID_order is not null
and vips_dev.ItemID is not null
group by vips_dev.site, vips_dev.Plataforma, vips_dev.dev_option, vips_dev.ItemID, orders.ds, orders.category_order