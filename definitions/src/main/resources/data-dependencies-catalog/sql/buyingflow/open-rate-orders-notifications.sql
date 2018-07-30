SELECT
  Sent.sent_date as sent_date, 
  Sent.site_id as site_id,
  Sent.email_id as email_id,
  Sent.payment_method_id as payment_method_id,
  Sent.payment_type as payment_type,
  Sent.payment_status as payment_status,
  Sent.status as status,
  count (Sent.order_id) as count_send, 
  sum(if(Open.order_id IS NOT NULL, 1, 0)) as count_open,
  if(count (Sent.order_id) <> 0,
  sum(if(Open.order_id IS NOT NULL, 1, 0)) * 100 / count (Sent.order_id),
  0) as percentage
FROM (
  SELECT 
    distinct substr(ds,1,10) AS sent_date,
    application.site_id as site_id,
    jest(event_data,'order_id') as order_id,
    jest(event_data,'email_template') as email_id,
    jest(event_data, 'payments[0].method_id') as payment_method_id,
    jest(event_data, 'payments[0].type') as payment_type,
    jest(event_data, 'payments[0].status') as payment_status,
    jest(event_data,'order_status') as status
  FROM tracks
  WHERE 
    ds >= '@param01' 
    AND ds < '@param02'
    AND jest(event_data,'event_type') = 'send'
    AND path = '/email/orders'
        ) AS Sent
LEFT OUTER JOIN
(
  SELECT
    distinct substr(ds,1,10) as open_date,
    jest(event_data,'order_id') as order_id,
    jest(event_data, 'payments[0].method_id') as payment_method_id,
    jest(event_data,'email_template') as email_id
  FROM tracks
  WHERE   
    ds >= '@param01' 
    AND ds < '@param03'
    AND jest(event_data,'event_type') = 'open'
    AND path = '/email/orders' ) AS Open
ON Sent.order_id = Open.order_id
AND Sent.email_id = Open.email_id
GROUP BY Sent.sent_date,
         Sent.email_id,
         Sent.site_id,
         Sent.payment_method_id,
         Sent.payment_type,
         Sent.payment_status,
         Sent.status
;