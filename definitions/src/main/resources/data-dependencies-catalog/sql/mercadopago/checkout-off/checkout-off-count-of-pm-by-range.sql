select
checkout_confirmed.site_id as site_id,
checkout_confirmed.environment as environment,
checkout_confirmed.version as version,
checkout_confirmed.platform as platform,
checkout_confirmed.collector_id as collector,
checkout_confirmed.payment_type as payment_type,
count(CASE WHEN confirmcheckout_confirmedation.purchase_amount >='0' AND checkout_confirmed.purchase_amount <= '600' THEN 1 END) as monto_rango1,
count(CASE WHEN checkout_confirmed.purchase_amount >'600' AND checkout_confirmed.purchase_amount <= '1000' THEN 1 END) as monto_rango2,
count(CASE WHEN checkout_confirmed.purchase_amount >'1000' AND checkout_confirmed.purchase_amount <= '5000' THEN 1 END) as monto_rango3,
count(CASE WHEN checkout_confirmed.purchase_amount >'5000' THEN 1 END) as monto_rango4
from(
  select jest(event_data, 'options') as options, jest(event_data, 'checkout_flow_id') flow_id, application.site_id, application.version, jest(event_data, 'environment') as environment, device.platform as platform, jest(event_data, 'collector_id') as collector_id
  from tracks
  WHERE ds>='@param01' and 
        ds<='@param02' and
        path like '/checkout_off/v1/test/payment_option%' and
        (jest(event_data, 'options') like '%credit_card%' and 
         jest(event_data, 'options') like '%debit_card%' and 
          jest(event_data, 'options') like '%account_money%')
         ) payment_option
  JOIN (
    SELECT jest(event_data, 'payment_method') payment_method, jest(event_data, 'payment_type') payment_type, jest(event_data, 'card_id') card_id, jest(event_data, 'installments') installments, jest(event_data, 'checkout_flow_id') flow_id, jest(event_data, 'purchase_amount') purchase_amount, application.site_id, application.version, jest(event_data, 'environment') as environment, device.platform as platform, jest(event_data, 'collector_id') as collector_id
    FROM tracks
    WHERE
      ds>='@param01' and 
      ds<='@param02' and
      path = '/checkout_off/v1/test/checkout_confirmed'   
      ) checkout_confirmed
  ON payment_option.flow_id = checkout_confirmed.flow_id
  GROUP BY confirmation.payment_type, confirmation.site_id, confirmation.version, confirmation.environment, confirmation.platform, confirmation.collector_id