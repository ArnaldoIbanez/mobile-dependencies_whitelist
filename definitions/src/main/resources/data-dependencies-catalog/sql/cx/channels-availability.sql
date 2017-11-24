select 
      ds as requested_datetime,
      jest(data, 'application.site_id') as site_id,
      jest(data, 'event_data.problem_type') as problem_type, 
      jest(data, 'event_data.reason') as reason, 
      jest(data, 'event_data.origin') as origin,
      jest(data, 'event_data.is_available') as is_available, 
      jest(data, 'event_data.segment') as segment, 
      jest(data, 'application.business') as business,
      jest(data, 'application.app_id') as app_id,
      jest(data, 'event_data.queue_id') as queue_id,
      count(*) as quantity
from cx_help_channels
where 
      ds >= '@param01' AND ds < '@param02'
      and jest(data, 'path')='/availability/requested'
      and jest(data, 'event_data.environment') = 'PRODUCTION'
GROUP BY 
      ds,
      jest(data, 'application.site_id'),
      jest(data, 'event_data.problem_type'), 
      jest(data, 'event_data.reason'), 
      jest(data, 'event_data.origin'),
      jest(data, 'event_data.is_available'), 
      jest(data, 'event_data.segment'),
      jest(data, 'application.business'),
      jest(data, 'application.app_id'),
      jest(data, 'event_data.queue_id')