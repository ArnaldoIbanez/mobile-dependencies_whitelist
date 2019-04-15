select
  channel,
  provider,
  site_id,
  communication_id,
  communication_version,
  experiment_id,
  cast(sent_date as date) as sent_date,
  sent,
  dropped,
  delivered,
  deferred,
  bounce,
  open,
  click,
  spam_report,
  unsubscribe,
  group_unsubscribe,
  group_resubscribe,
  contacted,
  unique_click,
  unique_open,
  cast(event_date as date) as event_date
from emailmarketing.hermes_summary
WHERE event_date >= '@param01'
AND   event_date < '@param02'
