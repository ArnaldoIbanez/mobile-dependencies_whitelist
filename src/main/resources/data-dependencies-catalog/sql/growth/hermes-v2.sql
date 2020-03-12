select
  site_id,
  path,
  platform,
  campaign_id,
  batch_id,
  communication_id,
  cast(sent_date as date) as sent_date,
  sum(sent) sent,
  cast(event_date as date) as event_date
from emailmarketing.hermes_summary_push
WHERE event_date >= '@param01'
AND   event_date < '@param02'
group by site_id, path, platform, campaign_id, batch_id, communication_id, sent_date, event_date
