select
coalesce(total_scans.user_id, errores.user_id) as user_id,
coalesce(total_scans.nickname, errores.nickname) as nickname,
coalesce(total_scans.warehouse, errores.warehouse) as warehouse,
coalesce(errores.counted, 0) as errores_totales,
coalesce(total_scans.counted, 0) as scans_totales,
coalesce(total_scans.fecha, errores.fecha) as fecha

from(
  select
  usr.user_id as user_id, 
  usr.user_nick as nickname,
  jest(event_data, 'warehouse_id') as warehouse,
  count(*) as counted,
  substr(ds,1,10) as fecha
  from tracks
  where path like '/wms/put_away%'
  and ds >= '@param01'
  and ds < '@param02'
  and jest(event_data, 'feedback_type') = 'ERROR'
  group by usr.user_id, usr.user_nick, jest(event_data, 'warehouse_id'), substr(ds,1,10))
  as errores

  full join

  (select
  coalesce(feedbacks.user_id, items.user_id) as user_id,
  coalesce(feedbacks.nickname, items.nickname) as nickname, 
  coalesce(feedbacks.warehouse, items.warehouse) as warehouse,
  (coalesce (feedbacks.counted, 0) + coalesce(items.counted, 0)) as counted,
  coalesce(feedbacks.fecha, items.fecha) as fecha
  from(
    select usr.user_id as user_id,
    usr.user_nick as nickname,
    jest(event_data, 'warehouse_id') as warehouse,
    count(*) as counted,
    substr(ds,1,10) as fecha
    from tracks
    where path = '/wms/put_away/item'
    and ds >= '@param01'
    and ds < '@param02'
    group by usr.user_id, usr.user_nick, jest(event_data, 'warehouse_id'), substr(ds,1,10))
    as items
    
    full join 
  
    (select usr.user_id as user_id, 
    usr.user_nick as nickname,
    jest(event_data, 'warehouse_id') as warehouse,
    count(*) as counted,
    substr(ds,1,10) as fecha
    from tracks
    where path like '/wms/put_away%'
    and ds >= '@param01'
    and ds < '@param02'
    and jest(event_data, 'feedback_type') is not null
    group by usr.user_id, usr.user_nick, jest(event_data, 'warehouse_id'), substr(ds,1,10))
    as feedbacks
  
  on items.user_id = feedbacks.user_id) 
  as total_scans

on total_scans.user_id = errores.user_id