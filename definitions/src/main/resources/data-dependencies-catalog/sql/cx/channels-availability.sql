select  
      tj.ds as requested_datetime, 
      v2.site_id as site_id , 
      v3.problem_type as problem_type, 
      v3.reason as reason, 
      v3.origin as origin, 
      v3.is_available as is_available, 
      v3.segment as segment, 
      v2.business as business, 
      v2.app_id as app_id,
      v3.queue_id as queue_id, 
      count(*) as quantity
from cx_help_channels tj
LATERAL VIEW 
      json_tuple(tj.data,'application', 'event_data') v1 
      as application, event_data
LATERAL VIEW 
      json_tuple(v1.application, 'app_id', 'business', 'site_id') v2 
      as app_id, business, site_id
LATERAL VIEW 
      json_tuple(v1.event_data, 'problem_type', 'reason', 'origin', 'is_available', 'segment', 'queue_id') v3 
      as problem_type, reason, origin, is_available, segment, queue_id
WHERE
      tj.ds >= '2017-11-28 00' AND tj.ds < '2017-11-28 08'
      and jest(data, 'path')='/availability/requested'
      and jest(data, 'event_data.environment') = 'PRODUCTION'
GROUP BY
      tj.ds, 
      site_id,
      problem_type,
      reason,
      origin,
      is_available,
      segment,
      business,
      app_id,
      queue_id

