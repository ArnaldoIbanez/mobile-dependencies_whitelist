select substr(tb.requested_datetime_minute,1,13) as requested_datetime,
      tb.site_id as site_id,
      tb.problem_type as problem_type,
      tb.reason as reason,
      tb.origin as origin,
      tb.is_available as is_available,
      tb.segment as segment,
      tb.business as business,
      tb.app_id as app_id,
      tb.queue_id as queue_id,
      sum(tb.unique_quantity_per_minute) as unique_quantity,
      sum(tb.quantity_per_minute) as quantity
from 
(
select  
      from_unixtime(unix_timestamp(regexp_replace(v1.user_timestamp, 'T',' ')), 'yyyy-MM-dd HH:mm') as requested_datetime_minute, 
      v2.site_id as site_id , 
      v3.problem_type as problem_type,
      v3.reason as reason, 
      v3.origin as origin, 
      v3.is_available as is_available, 
      v3.segment as segment, 
      v2.business as business, 
      v2.app_id as app_id,
      v3.queue_id as queue_id,
      count(distinct v4.user_id) unique_quantity_per_minute,    
      count(distinct v1.id) quantity_per_minute    
from cx_help_channels tj
LATERAL VIEW 
      json_tuple(tj.data,'application', 'event_data', 'user_timestamp', 'user', 'id') v1 
      as application, event_data, user_timestamp, anUser, id
LATERAL VIEW 
      json_tuple(v1.application, 'app_id', 'business', 'site_id') v2 
      as app_id, business, site_id
LATERAL VIEW 
      json_tuple(v1.event_data, 'problem_type', 'reason', 'origin', 'is_available', 'segment', 'queue_id') v3 
      as problem_type, reason, origin, is_available, segment, queue_id
LATERAL VIEW
      json_tuple(v1.anUser, 'user_id') v4
      as user_id
WHERE
      tj.ds >=  '@param01 02' 
      AND tj.ds < '@param02 05'
      AND from_unixtime(unix_timestamp(regexp_replace(v1.user_timestamp, 'T',' ')), 'yyyy-MM-dd HH') >= '@param03 23'  
      AND from_unixtime(unix_timestamp(regexp_replace(v1.user_timestamp, 'T',' ')), 'yyyy-MM-dd HH') <  '@param04 23' 
      AND jest(data, 'path')='/availability/requested'
      AND jest(data, 'event_data.environment') = 'PRODUCTION'
GROUP BY
      from_unixtime(unix_timestamp(regexp_replace(v1.user_timestamp, 'T',' ')), 'yyyy-MM-dd HH:mm'), 
      site_id,
      problem_type,
      reason,
      origin,
      is_available,
      segment,
      business,
      app_id,
      queue_id
) tb
GROUP BY
substr(tb.requested_datetime_minute,1,13),
tb.site_id,
tb.problem_type,
tb.reason,
tb.origin,
tb.is_available,
tb.segment,
tb.business,
tb.app_id,
tb.queue_id
