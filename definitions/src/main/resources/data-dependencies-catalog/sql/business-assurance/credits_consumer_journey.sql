SELECT
  distinct jest(event_data, 'email_id')             as  email_id,
  substr(ds, 1, 10)                        as  fecha,
  path,
  jest(event_data, 'email_template')       as  template,
  jest(event_data, 'event_type')           as  event_type,
  jest(event_data, 'track_data.milestone') as  milestone,
  jest(event_data, 'track_data.bucket')    as  bucket,
  substr(jest(event_data, 'sent_date'), 1, 10) sent_date
FROM tracks
where type = 'event'
      and path = '/email/generic'
      and (ds >= '@param01' and ds < '@param02')
      and jest(event_data, 'email_template') = 'CONS_COLLECTION'
      and jest(event_data, 'event_type') = 'send'
      and application.site_id = 'MLA'
UNION
SELECT distinct
  jest(event_data, 'email_id')             as  email_id,
  substr(ds, 1, 10)                        as  fecha,
  path,
  jest(event_data, 'email_template')       as  template,
  jest(event_data, 'event_type')           as  event_type,
  jest(event_data, 'track_data.milestone') as  milestone,
  jest(event_data, 'track_data.bucket')    as  bucket,
  substr(jest(event_data, 'sent_date'), 1, 10) sent_date
FROM tracks
WHERE
  type = 'event'
  and path = '/email/generic'
  and (ds >= '@param01' and ds < '@param02')
  and jest(event_data, 'email_template') = 'CONS_COLLECTION'
  and jest(event_data, 'event_type') = 'open'
  and application.site_id = 'MLA'