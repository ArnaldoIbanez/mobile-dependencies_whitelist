select substr(ds,1,10) as ds,
application.site_id as Site,
device.platform as Device,
jest(event_data,'vertical') as Vertical,
jest(event_data,'items[0].item.condition') as Item_condition,
jest(event_data,'items[0].item.listing_type_id') as Listing_type,
jest(event_data,'payments[0].payment_method') as Payment_method,
jest(event_data,'payments[0].payment_type') as Payment_type, 
jest(event_data,'total_amount_usd') as Total_amount_usd,
jest(event_data,'reservation_price') as Reservation_price_local_currency,
jest(event_data,'order_id') as Order_id
from tracks
WHERE ds >= '@param01'
AND   ds < '@param02'
and path = '/checkout/congrats'
and jest(event_data,'items[0].item.buying_mode') = 'classified'
and jest(event_data,'reservation_price') is not null