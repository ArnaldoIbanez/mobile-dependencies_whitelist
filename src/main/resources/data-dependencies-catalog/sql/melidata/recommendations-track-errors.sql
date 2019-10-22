SELECT t1.ds as ds, t1.site_id as site_id, t1.client as client, t2.emptyResultCause as emptyResultCause, t1.calls as calls, t2.errors as error, t2.errors*100/cast(t1.calls as double) as error_rate
FROM
(
  SELECT ttemp1.ds as ds, ttemp1.client as client, ttemp1.site_id as site_id, count(*) as calls FROM
  (
    SELECT substr(ds, 1,10) as ds 
      , get_json_object(event_data, '$.recommendations.client') as client
      , application.site_id as site_id
    FROM tracks
    WHERE
      ds > '@param01'
      and ds < '@param02'
      and get_json_object(event_data, '$.recommendations') is not null
  ) ttemp1
  GROUP BY ttemp1.ds, ttemp1.client, ttemp1.site_id
) t1
INNER JOIN
(
  SELECT ttemp2.ds as ds, ttemp2.client as client, ttemp2.site_id as site_id, ttemp2.emptyResultCause as emptyResultCause, count(*) as errors
  FROM
  (
    SELECT substr(ds, 1,10) as ds
      , get_json_object(event_data, '$.recommendations.client') as client
      , application.site_id as site_id
      , jest(event_data, 'recommendations.track_info.empty_result_cause') as emptyResultCause
    FROM tracks
    WHERE 
      ds > '@param01' 
      AND ds < '@param02'
      AND get_json_object(event_data, '$.recommendations')is not null  
      AND get_json_object(event_data, '$.recommendations.has_errors') = 'false'
      AND get_json_object(event_data, '$.recommendations.track_info.empty_result_cause') is not null
  ) ttemp2
  GROUP BY ttemp2.ds, ttemp2.client, ttemp2.site_id, ttemp2.emptyResultCause
  UNION
  SELECT ttemp3.ds as ds, ttemp3.client as client, ttemp3.site_id as site_id, ttemp3.emptyResultCause as emptyResultCause, count(*) as errors
  FROM
  (
    SELECT substr(ds, 1,10) as ds
      , jest(event_data, 'recommendations.client') as client
      , application.site_id as site_id
      , 'HASERROR' as emptyResultCause
    FROM tracks
    WHERE 
      ds > '@param01'
      AND ds < '@param02'
      AND jest(event_data, 'recommendations.has_errors') = 'true'
  ) ttemp3
  group by ttemp3.ds, ttemp3.client, ttemp3.site_id, ttemp3.emptyResultCause
) t2 on t1.client = t2.client and t1.site_id = t2.site_id and t1.ds = t2.ds