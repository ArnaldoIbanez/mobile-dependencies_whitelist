select  
      from_unixtime(unix_timestamp(regexp_replace(v1.user_timestamp, 'T',' ')), 'yyyy-MM-dd HH') as requested_datetime, 
      v2.site_id as site_id , 
      v3.problem_type as problem_type,
      v3.reason as reason, 
      v3.origin as origin, 
      v3.is_available as is_available, 
      v3.segment as segment, 
      v2.business as business, 
      v2.app_id as app_id,
      v3.queue_id as queue_id,
      count(*)
      
from cx_help_channels tj
LATERAL VIEW 
      json_tuple(tj.data,'application', 'event_data', 'user_timestamp') v1 
      as application, event_data, user_timestamp
LATERAL VIEW 
      json_tuple(v1.application, 'app_id', 'business', 'site_id') v2 
      as app_id, business, site_id
LATERAL VIEW 
      json_tuple(v1.event_data, 'problem_type', 'reason', 'origin', 'is_available', 'segment', 'queue_id') v3 
      as problem_type, reason, origin, is_available, segment, queue_id
WHERE
      tj.ds >=  '@param01 02' 
      AND tj.ds < '@param02 05'
      AND from_unixtime(unix_timestamp(regexp_replace(v1.user_timestamp, 'T',' ')), 'yyyy-MM-dd HH') >= '@param03 23'  
      AND from_unixtime(unix_timestamp(regexp_replace(v1.user_timestamp, 'T',' ')), 'yyyy-MM-dd HH') <  '@param04 23' 
      AND jest(data, 'path')='/availability/requested'
      AND jest(data, 'event_data.environment') = 'PRODUCTION'

GROUP BY
      from_unixtime(unix_timestamp(regexp_replace(v1.user_timestamp, 'T',' ')), 'yyyy-MM-dd HH'), 
      site_id,
      problem_type,
      reason,
      origin,
      is_available,
      segment,
      business,
      app_id,
      queue_id
