select
	  hoy.site_id as site,
	  hoy.delivery_id as delivery_id,
  	hoy.shipping_id as shipping_id,
  	hoy.seller_id as seller_id,
  	CAST(hoy.longitude as DOUBLE) as longitude,
    CAST(hoy.latitude as DOUBLE) as latitude,
  	if(lower(delivered.status)='delivered','Delivered','Not_Delivered') as pack_status,
  	delivered.hora as hora,
  	coalesce(ayer.rescanned,0) as rescanned,
  	event.event_detail as event_detail,
  	event.num_event as num_event,
  	coalesce(add_more.num_add_more,0) as num_add_more,
  	coalesce(m_address.num_missing_addresses,0) as num_missing_addresses,
  	coalesce(retry.cant_retry,0) as cant_retry,
  	delivery.delivery_status as delivery_status,
    hoy.ds as ds
from (
	select
		list.ds as ds,
		list.site_id as site_id,
		list.delivery_id as delivery_id,
		packs.shipping_id as shipping_id,
		coalesce(packs.seller_id,'N/A') as seller_id,
		packs.longitude as longitude,
		packs.latitude as latitude
	from(
		select 
      		substr(ds,1,10) as ds, 
      		application.site_id as site_id,
      		jest(event_data,'delivery_id') as delivery_id, 
      		Max(user_local_timestamp)  as user_local_timestamp 
  		from tracks
		where ds >='@param02' and ds < '@param03'
		    and application.business='mercadoenvios'
        	and path like'/flex/package/list'
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
	where ds >='@param02' and ds < '@param03'
     	and application.business='mercadoenvios'
 		and path = '/flex/package/list' 
 	) packs on packs.delivery_id = list.delivery_id and packs.site_id = list.site_id and packs.user_local_timestamp = list.user_local_timestamp 

) hoy	
left join 
(
	select 
		substr(ds,1,10) as ds,
  		application.site_id as site_id,
  		jest(packs_data,'shipping_id') as shipping_id,
  		if(jest(packs_data, 'status')='shipped' or jest(packs_data, 'status')='ready_to_ship','Delivered',jest(packs_data, 'status')) as status,
  		substr(ds,11,3) as Hora
  	from tracks
	LATERAL VIEW explode(json_to_array(jest(event_data,'packs_info'))) tf as packs_data
	where ds >='@param02' and ds < '@param03'
     	and application.business='mercadoenvios'
 		and path = '/flex/package/detail/receipt/save' 
) delivered on delivered.ds = hoy.ds and delivered.site_id = hoy.site_id and delivered.shipping_id = hoy.shipping_id
Left join(
	select distinct
  		jest(packs_data,'shipping_id') as shipping_id,
  		application.site_id as site_id,
  		1 as rescanned
	from tracks
	LATERAL VIEW explode(json_to_array(jest(event_data,'packs_info'))) tf as packs_data
	where ds >='@param01' and ds < '@param02'
    	and application.business='mercadoenvios'
 		and path = '/flex/package/list'
 ) ayer on ayer.shipping_id = hoy.shipping_id and ayer.site_id = hoy.site_id

left join (
  select 
      ds, 
      site_id,
      delivery_id,
      event_detail,
      count(*) as num_event
  from (
    select
      substr(ds,1,10) as ds, 
      application.site_id as site_id,
      jest(event_data,'delivery_id') as delivery_id,
      CASE path
          WHEN '/flex/package/detail/receipt_other_person' THEN 'receipt_other_person'
          WHEN '/flex/package/detail/call_seller' THEN 'call_seller'
          WHEN '/flex/package/detail/call_buyer' THEN 'call_buyer'
          WHEN '/flex/package/see_on_google_maps' THEN 'see_on_google_maps'
      END     as event_detail
    from tracks
	where ds >='@param02' and ds < '@param03'
        and application.business='mercadoenvios'
          and path in ('/flex/package/detail/receipt_other_person','/flex/package/detail/call_seller','/flex/package/detail/call_buyer','/flex/package/see_on_google_maps')
  ) t
  GROUP BY ds, site_id, delivery_id, event_detail
) event on event.ds = hoy.ds and event.site_id = hoy.site_id and event.delivery_id = hoy.delivery_id 
left join (
  select 
    substr(ds,1,10) as ds, 
    application.site_id as site_id,
    count(*) as num_add_more
  from tracks
  where ds >='@param02' and ds < '@param03'
      and application.business='mercadoenvios'
        and path like '/flex/package/add_more_packages/qr_detected'
        and jest(event_data,'status') = 'ok'
  GROUP BY substr(ds,1,10), application.site_id
) add_more on add_more.ds = hoy.ds and add_more.site_id = hoy.site_id 
left join (
  select 
      substr(ds,1,10) as ds, 
      application.site_id as site_id,
      jest(event_data,'delivery_id') as delivery_id, 
      count(*) as num_missing_addresses
  from tracks
  where ds >='@param02' and ds < '@param03'
        and application.business='mercadoenvios'
        and path like '/flex/package/list/map_missing_addresses'
  GROUP BY substr(ds,1,10), application.site_id, jest(event_data,'delivery_id') 
) m_address on m_address.ds = hoy.ds and m_address.site_id = hoy.site_id and m_address.delivery_id = hoy.delivery_id
left Join (
	select
			substr(ds,1,10) as ds,
			application.site_id as site_id,
			jest(event_data,'delivery_id') as Delivery_id,
			Count(*) as cant_retry
		from tracks 
		where ds>='@param02' AND ds<'@param03'
			and path ='/flex/package/retry_delivery'
    		and application.business='mercadoenvios'
    		and jest(event_data,'context') = 'list'
    	group by substr(ds,1,10),application.site_id, jest(event_data,'delivery_id')
) retry on retry.ds = hoy.ds and retry.site_id = hoy.site_id and retry.delivery_id = hoy.delivery_id
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
    	jest(event_data,'delivery_status') as DeliveryStatus,
    	user_timestamp as Delivery_Time
    from tracks
    where ds>='@param02' AND ds<'@param03'
		  and path ='/flex/package/finish_delivery'
    	and application.business='mercadoenvios'
    	and not isnull(jest(event_data,'delivery_id'))
    ) status
    inner join (
      select
			substr(ds,1,10) as ds,
			application.site_id as site_id,
			jest(event_data,'delivery_id') as Delivery_id,
			Max(user_timestamp) as Delivery_Time
		from tracks 
		where ds>='@param02' AND ds<'@param03'
			and path ='/flex/package/finish_delivery'
    		and application.business='mercadoenvios'
    		and not isnull(jest(event_data,'delivery_id'))
    	GROUP BY substr(ds,1,10), application.site_id, jest(event_data,'delivery_id')
    ) delivery on status.ds = delivery.ds and status.Delivery_id = delivery.Delivery_id and status.Delivery_Time = delivery.Delivery_Time   
) delivery on delivery.ds = hoy.ds and delivery.site_id = hoy.site_id and delivery.delivery_id = hoy.delivery_id

