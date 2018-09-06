select
checkout_confirmed.site_id as site_id,
checkout_confirmed.environment as environment,
checkout_confirmed.version as version,
checkout_confirmed.platform as platform,
checkout_confirmed.collector_id as collector,
checkout_confirmed.payment_type as payment_type,
SUM(IF(cast(checkout_confirmed.purchase_amount as decimal(18,6)) >= 0 AND cast(checkout_confirmed.purchase_amount as decimal(18,6)) <= 600, 1, 0)) as monto_rango1,
SUM(IF(cast(checkout_confirmed.purchase_amount as decimal(18,6)) > 600 AND cast(checkout_confirmed.purchase_amount as decimal(18,6)) <= 1000, 1, 0)) as monto_rango2,
SUM(IF(cast(checkout_confirmed.purchase_amount as decimal(18,6)) > 1000 AND cast(checkout_confirmed.purchase_amount as decimal(18,6)) <= 5000, 1, 0)) as monto_rango3,
SUM(IF(cast(checkout_confirmed.purchase_amount as decimal(18,6)) > 5000 , 1, 0)) as monto_rango4,
checkout_confirmed.ds_date
from(
  select jest(event_data, 'options') as options, jest(event_data, 'checkout_flow_id') flow_id, application.site_id, application.version, jest(event_data, 'environment') as environment, device.platform as platform, jest(event_data, 'collector_id') as collector_id, substr(ds, 1, 10) as ds_date
  from tracks
  WHERE ds>='@param01' and 
        ds<='@param02' and
        path like '/checkout_off/v1/payment_option%' and
        (jest(event_data, 'options') like '%credit_card%' and 
         jest(event_data, 'options') like '%debit_card%' and 
          jest(event_data, 'options') like '%account_money%')
         ) payment_option
  JOIN (
    SELECT jest(event_data, 'payment_method') payment_method, jest(event_data, 'payment_type') payment_type, jest(event_data, 'card_id') card_id, jest(event_data, 'installments') installments, jest(event_data, 'checkout_flow_id') flow_id, jest(event_data, 'purchase_amount') purchase_amount, application.site_id, application.version, jest(event_data, 'environment') as environment, device.platform as platform, jest(event_data, 'collector_id') as collector_id, substr(ds, 1, 10) as ds_date
    FROM tracks
    WHERE
      ds>='@param01' and 
      ds<='@param02' and
      path = '/checkout_off/v1/checkout_confirmed'   
      ) checkout_confirmed
  ON payment_option.flow_id = checkout_confirmed.flow_id
  GROUP BY checkout_confirmed.payment_type, checkout_confirmed.site_id, checkout_confirmed.version, checkout_confirmed.environment, checkout_confirmed.platform, checkout_confirmed.collector_id, checkout_confirmed.ds_date
