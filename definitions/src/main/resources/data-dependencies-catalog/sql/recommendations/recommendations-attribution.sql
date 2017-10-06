select ds, site_id, platform, client, backend, count(*) orders, sum(item_quantity) sis, sum(gmv) gmv,
       sum( case when order_timestamp - vip_timestamp < 60*60 then 1 else 0 end ) orders_1h,
       sum( case when order_timestamp - vip_timestamp < 60*60 then item_quantity else 0 end ) sis_1h,
       sum( case when order_timestamp - vip_timestamp < 60*60 then gmv else 0 end ) gmv_1h
  from (

    select substr(ds, 1, 10) ds, max(vip_timestamp) vip_timestamp, max(order_timestamp) order_timestamp, site_id, user_id, platform, 
              order_id, item_id, client, backend, cast (item_quantity as double) item_quantity, cast(gmv as double) gmv, count(*) dups
        from ( 

        select o.ds, 
                unix_timestamp(regexp_replace(r.user_timestamp,'T',' ')) vip_timestamp, 
                unix_timestamp(regexp_replace(o.user_timestamp,'T',' ')) order_timestamp, 
                o.user_timestamp as order_click, 
                o.application.site_id as site_id, 
                o.usr.user_id as user_id, 
                o.device.platform as platform, 
                jest(o.event_data, 'order_id') as order_id, 
                jest(r.event_data, 'item_id') as item_id, 
                jest(r.others['fragment'], 'reco_client') as client, 
                jest(r.others['fragment'], 'reco_backend') as backend, 
                jest(o.event_data, 'items[0].quantity') item_quantity, 
                jest(o.event_data, 'total_amount_usd') gmv
          from tracks r, tracks o
         where jest(o.event_data, 'items[0].item.id') = jest(r.event_data, 'item_id')
           and r.path = '/vip'
           and jest(r.others['fragment'], 'reco_client') <> ''
           and jest(r.others['fragment'], 'reco_client') is not null
           and o.usr.user_id = r.usr.user_id
           and r.ds > '@param01' and o.ds < '@param03'
           and o.ds > '@param02' and o.ds < '@param03'
           and unix_timestamp(regexp_replace(o.user_timestamp,'T',' ')) - unix_timestamp(regexp_replace(r.user_timestamp,'T',' '))
                             < 60*60*24*7
           and o.path = '/orders/ordercreated'
           and jest(o.event_data,'total_amount_usd') < 10000
         
      ) as out1
    group by substr(ds, 1, 10), site_id, user_id, platform, order_id, item_id, client, backend, item_quantity, gmv
    
) as out2
group by ds, site_id, platform, client, backend 
