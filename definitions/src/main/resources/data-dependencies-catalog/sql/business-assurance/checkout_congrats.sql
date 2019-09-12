select 
  substr(ds, 1, 10) as fecha,
  application.site_id as site, 
  device.platform as platform,
  jest(event_data, 'payments[0].payment_type') as payment_type,
  jest(event_data, 'payments[0].payment_method') as payment_method,
  jest(event_data, 'payments[0].status') as payment_status,
  jest(event_data, 'payments[0].status_detail') as payment_status_detail,
  jest(event_data, 'payments[0].bank') as payment_bank,
  jest(event_data, 'payments[0].installments') as installments,
  jest(event_data, 'vertical') as vertical,
  jest(event_data, 'resolution') as resolution,
  application.server_poolname as server_poolname,
  jest(event_data, 'loyaltyLevel') as loyalty_level,
  jest(event_data, 'free_shipping_benefit') as free_shipping_benefit,
  jest(event_data, 'buy_equal_pay') as buy_equal_pay,
  jest(event_data, 'shipping[0].shipping_type') as shipping_type,
  jest(event_data, 'shipping[0].shipping_mode') as shipping_mode,
  jest(event_data, 'recovery_flow') as recovery_flow,
  jest(event_data, 'precharged_cards') as precharged_cards,
  jest(event_data, 'checkout_version') as checkout_version,
  jest(event_data, 'items[0].item.condition') as item_condition,
  jest(event_data, 'items[0].item.buying_mode') as item_buying_mode,  
  jest(event_data, 'items[0].item.listing_type') as item_listing_type_id, 
  jest(event_data, 'items[0].currency_id') as item_currency, 
  sum(CAST(jest(event_data, 'items[0].unit_price_usd') as DOUBLE)) as item_unit_price_usd,
  sum(CAST(jest(event_data, 'total_amount') as DOUBLE)) as total_amount,
  sum(CAST(jest(event_data, 'total_amount_with_shipping') as DOUBLE)) as total_amount_with_shipping,
  sum(CAST(jest(event_data, 'total_amount_usd') as DOUBLE)) as total_amount_usd,
  count(*)
from 
  tracks 
where
  ds >= '2017-11-11 08:00:00'
  and ds < '2017-12-11 08:00:00'
  and path = '/checkout/congrats' 
  and CAST(jest(event_data, 'total_amount_usd') as DOUBLE) <= 10000
  and jest(event_data, 'congrats_seq') = '1'
group by 
substr(ds, 1, 10),
  application.site_id, 
  device.platform,
  jest(event_data, 'payments[0].installments'),
  jest(event_data, 'items[0].currency_id'),
  jest(event_data, 'payments[0].payment_type'),
  jest(event_data, 'payments[0].payment_method'),
  jest(event_data, 'payments[0].status'),
  jest(event_data, 'payments[0].status_detail'),
  jest(event_data, 'payments[0].bank'),
  jest(event_data, 'vertical'),
  jest(event_data, 'resolution'),
  application.server_poolname,
  jest(event_data, 'loyaltyLevel'),
  jest(event_data, 'free_shipping_benefit'),
  jest(event_data, 'buy_equal_pay'),
  jest(event_data, 'shipping[0].shipping_type'),
  jest(event_data, 'shipping[0].shipping_mode'),
  jest(event_data, 'recovery_flow'),
  jest(event_data, 'precharged_cards'),
  jest(event_data, 'checkout_version'),
  jest(event_data, 'items[0].item.condition'),
  jest(event_data, 'items[0].item.buying_mode'),  
  jest(event_data, 'items[0].item.listing_type')