SELECT
  COUNT(*) as total,
  path,
  jest(event_data, 'loan_status') AS actual_status,
  jest(event_data, 'status_from_medium') AS status_from_medium,
  jest(event_data, 'output_label') AS output_label,
  jest(event_data, 'campaign') AS campaign,
  jest(event_data, 'action_label') AS action_label,
  jest(event_data, 'next_installment_status') AS next_installment_status,
  jest(event_data, 'credits_type') AS credits_type,
  jest(event_data, 'medium') AS medium,
  jest(event_data, 'site_id') AS site,
  substr(ds,1,10) as ds
FROM tracks
WHERE path = '/credits/consumer/contacts'
  AND (ds >= '@param01' AND ds < '@param02')
GROUP BY substr(ds,1,10),
  path,
  jest(event_data, 'loan_status'),
  jest(event_data, 'status_from_medium'),
  jest(event_data, 'output_label'),
  jest(event_data, 'campaign'),
  jest(event_data, 'action_label'),
  jest(event_data, 'next_installment_status'),
  jest(event_data, 'credits_type'),
  jest(event_data, 'medium'),
  jest(event_data, 'site_id')
