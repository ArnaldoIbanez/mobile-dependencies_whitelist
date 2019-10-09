select
  channel,
  provider,
  site_id,
  communication_id,
  communication_version,
  segment_id,
  experiment_id,
  cast(sent_date as date) as sent_date,
  sum(sent) sent,
  sum (dropped) dropped,
  sum (delivered) delivered,
  sum (deferred) deferred,
  sum(bounce) bounce,
  sum (open) open,
  sum (click) click,
  sum (spam_report) spam_report,
  sum (unsubscribe) unsubscribe,
  sum (group_unsubscribe) group_unsubscribe,
  sum (group_resubscribe) group_resubscribe,
  sum (contacted) contacted,
  sum (unique_click) unique_click,
  sum (unique_open) unique_open,
  cast(event_date as date) as event_date
from emailmarketing.hermes_summary
WHERE event_date >= '@param01'
AND   event_date < '@param02'
group by channel, provider, site_id, communication_id, communication_version, segment_id, experiment_id, sent_date, event_date
