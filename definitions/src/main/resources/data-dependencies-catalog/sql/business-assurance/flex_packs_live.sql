select
   hoy.site_id as site,
    hoy.delivery_id as delivery_id,
    hoy.shipping_id as shipping_id,
    hoy.list_timestamp as list_timestamp,
    current_timestamp as server_time,
    CAST(coalesce(delivered.longitude, not_delivered.longitude,receipt.longitude, hoy.longitude) as DOUBLE) as longitude,
    CAST(coalesce(delivered.latitude, not_delivered.latitude, receipt.latitude, hoy.latitude) as DOUBLE) as latitude,
    coalesce(delivered.status, not_delivered.status, 'Pending') as pack_status,
    delivered.hora as hora,
    coalesce(delivery.delivery_status, 'pending') as delivery_status,
    hoy.ds as ds
from (
  select
    list.ds as ds,
    list.site_id as site_id,
    list.user_local_timestamp as list_timestamp,
    list.delivery_id as delivery_id,
    packs.shipping_id as shipping_id,
    packs.longitude as longitude,
    packs.latitude as latitude
  from(
    select 
          substr(ds,1,10) as ds, 
          application.site_id as site_id,
          jest(event_data,'delivery_id') as delivery_id, 
          Max(user_local_timestamp)  as user_local_timestamp 
      from tracks
  where ds >='@param01' 
        and application.business='mercadoenvios'
          and type = 'view' and path = '/flex/package/list'
    GROUP BY substr(ds,1,10), application.site_id, jest(event_data,'delivery_id')
    ) list
    inner join (
    select 
      user_local_timestamp,
      application.site_id as site_id,
      jest(packs_data,'shipping_id') as shipping_id,
      jest(event_data, 'delivery_id') as delivery_id,
      jest(packs_data, 'seller_id') as seller_id,
      jest(packs_data,'destintation_info.longitude') as longitude,
      jest(packs_data,'destintation_info.latitude') as latitude
  from tracks
  LATERAL VIEW explode(json_to_array(jest(event_data,'packs_info'))) tf as packs_data
  where ds >='@param01' 
      and application.business='mercadoenvios'
      and type = 'view' and path = '/flex/package/list'
  ) packs on packs.delivery_id = list.delivery_id and packs.site_id = list.site_id and packs.user_local_timestamp = list.user_local_timestamp 
) hoy 
left join (
  select
      last_save.ds as ds,
      last_save.site_id as site_id,
      last_save.shipping_id as shipping_id,
      save.status as status,
      save.Hora as Hora,
      save.longitude as longitude,
      save.latitude as latitude
  from(
  select 
          substr(ds,1,10) as ds, 
          application.site_id as site_id,
          jest(event_data,'packs_info[0].shipping_id') as shipping_id,
          Min(user_local_timestamp)  as user_local_timestamp 
  from tracks
  where ds >='@param01' 
        and application.business='mercadoenvios'
        and path = '/flex/package/detail/receipt/save' 
    GROUP BY substr(ds,1,10), application.site_id, jest(event_data,'packs_info[0].shipping_id')
  ) last_save
  inner join (
  select 
      substr(ds,1,10) as ds,
      user_local_timestamp,
      application.site_id as site_id,
      jest(event_data,'packs_info[0].shipping_id') as shipping_id,
      if(jest(event_data, 'packs_info[0].status')='shipped' or jest(event_data,'packs_info[0].status')='ready_to_ship','Delivered',jest(event_data,'packs_info[0].status')) as status,
      substr(user_local_timestamp,12,2) as Hora,
      jest(event_data,'longitude') as longitude,
      jest(event_data,'latitude') as latitude
    from tracks
  where ds >='@param01' 
       and application.business='mercadoenvios'
       and path = '/flex/package/detail/receipt/save'
    ) save on save.user_local_timestamp = last_save.user_local_timestamp and save.shipping_id = last_save.shipping_id and save.site_id = last_save.site_id
) delivered on delivered.ds = hoy.ds and delivered.site_id = hoy.site_id and delivered.shipping_id = hoy.shipping_id
left join(
select 
    substr(ds,1,10) as ds,
    jest(event_data,'delivery_id') as delivery_id,
    jest(event_data,'packs_info[0].shipping_id') as shipping_id,
    application.site_id as site_id,
    user_timestamp as status_time,
    'Not Delivered' as status,
      if( jest(event_data,'reason_type') <>'other_reason',jest(event_data,'reason_type'),'others_reason') as reason,
      jest(event_data,'longitude') as longitude,
      jest(event_data,'latitude') as latitude
  from tracks
  where ds >='@param01' 
    and type = 'event'
      and application.business='mercadoenvios'
    and ((path = '/flex/package/not_delivered_reason/selection' and jest(event_data,'reason_type') <>'others_reason')
        or path = '/flex/package/not_delivered_reason/form/other_reason' and lower(jest(event_data,'reason')) <> 'test')
) not_delivered on not_delivered.ds = hoy.ds and not_delivered.site_id = hoy.site_id and not_delivered.shipping_id = hoy.shipping_id and not_delivered.delivery_id = hoy.delivery_id
Left join (
select
  last_receipt.ds,
  last_receipt.site_id,
  last_receipt.delivery_id,
  last_receipt.shipping_id,
  receipt_info.longitude,
  receipt_info.latitude
from (
  select
        substr(ds,1,10) as ds,
        application.site_id as site_id,
        jest(event_data,'delivery_id') as delivery_id,
        jest(event_data,'packs_info[0].shipping_id') as shipping_id,
        max(user_timestamp) as status_time
    from tracks
  where ds >='@param01' 
      and type = 'view'
      and application.business='mercadoenvios'
      and path = '/flex/package/detail/receipt'
      group by substr(ds,1,10), application.site_id, jest(event_data,'delivery_id'), jest(event_data,'packs_info[0].shipping_id') 
  ) last_receipt
  inner join (
  select
      substr(ds,1,10) as ds,
      application.site_id as site_id,
      jest(event_data,'delivery_id') as delivery_id,
      jest(event_data,'packs_info[0].shipping_id') as shipping_id,
      user_timestamp as status_time,
      jest(event_data,'longitude') as longitude,
      jest(event_data,'latitude') as latitude
  from tracks
  where ds >='@param01' 
    and type = 'view'
    and application.business='mercadoenvios'
    and path = '/flex/package/detail/receipt'
  ) receipt_info on receipt_info.ds = last_receipt.ds and receipt_info.site_id = last_receipt.site_id and receipt_info.shipping_id = last_receipt.shipping_id and receipt_info.delivery_id = last_receipt.delivery_id
) receipt on receipt.ds = hoy.ds and receipt.site_id = hoy.site_id and receipt.shipping_id = hoy.shipping_id and receipt.delivery_id = hoy.delivery_id
left join
(
  select
      status.ds as ds,
      status.site_id as site_id,
      status.Delivery_id as delivery_id,
      status.DeliveryStatus as delivery_status
  from (
      select
         substr(ds,1,10) as ds,
         application.site_id as site_id,
         jest(event_data,'delivery_id') as Delivery_id,
         Max(user_timestamp) as Delivery_Time
      from tracks 
  where ds >='@param01' 
          and path ='/flex/package/finish_delivery'
          and application.business='mercadoenvios'
          and not isnull(jest(event_data,'delivery_id'))
      GROUP BY substr(ds,1,10), application.site_id, jest(event_data,'delivery_id')
      ) delivery
      inner join (
        select
          substr(ds,1,10) as ds,
          application.site_id as site_id,
          jest(event_data,'delivery_id') as Delivery_id,
          jest(event_data,'delivery_status') as DeliveryStatus,
          user_timestamp as Delivery_Time
        from tracks
  where ds >='@param01' 
          and path ='/flex/package/finish_delivery'
          and application.business='mercadoenvios'
          and not isnull(jest(event_data,'delivery_id'))
      ) status on status.ds = delivery.ds and status.Delivery_id = delivery.Delivery_id and status.Delivery_Time = delivery.Delivery_Time
) delivery on delivery.ds = hoy.ds and delivery.site_id = hoy.site_id and delivery.delivery_id = hoy.delivery_id
