SELECT 
t1.ds as ds
, t1.site_id as site_id
, t1.client as client
, t1.model_id as model_id
, t1.model_version as model_version
, COALESCE(sum(t1.group_map['OK']),CAST(0 AS BIGINT)) as ok
, COALESCE(sum(t1.group_map['SELLER_NOT_FOUND']),CAST(0 AS BIGINT)) as seller_not_found
, COALESCE(sum(t1.group_map['NO_MATCHING_NGRAMS']),CAST(0 AS BIGINT)) as no_matching_ngrams
, COALESCE(sum(t1.group_map['TIMEOUT']),CAST(0 AS BIGINT)) as timeout 
, COALESCE(sum(t1.group_map['STORE_NOT_FOUND']),CAST(0 AS BIGINT)) as store_not_found 
, COALESCE(sum(t1.group_map['ITEM_NOT_FOUND']),CAST(0 AS BIGINT)) as item_not_found
, COALESCE(sum(t1.group_map['UNKNOWN']),CAST(0 AS BIGINT)) as unknown 
, COALESCE(sum(t1.group_map['HASERROR']),CAST(0 AS BIGINT)) as haserror 
, COALESCE(sum(t1.group_map['RECOMMENDATION_SIZE_LOWER_THAN_MINIMUM_REQUIRED']),CAST(0 AS BIGINT)) as recommendation_size_lower_than_minimum_required
, COALESCE(sum(t1.group_map['EMPTY_MODEL_RESPONSE']),CAST(0 AS BIGINT)) as empty_model_response
FROM
(
  SELECT t2.ds as ds, t2.client as client, t2.site_id as site_id, t2.model_id, t2.model_version, map(t2.emptyResultCause,t2.errors) as group_map
  FROM
  (
    SELECT ttemp1.ds as ds, ttemp1.client as client, ttemp1.site_id as site_id, ttemp1.model_id as model_id, ttemp1.model_version as model_version, ttemp1.emptyResultCause as emptyResultCause, count(*) as errors
    FROM
    (
      SELECT substr(ds, 1,10) as ds
        , get_json_object(event_data, '$.recommendations.client') as client
        , application.site_id as site_id
        , COALESCE(get_json_object(event_data, '$.recommendations.track_info.model_id'),'None')  as model_id
        , COALESCE(get_json_object(event_data, '$.recommendations.track_info.model_version'),'None')  as model_version
        , 'OK' as emptyResultCause
      FROM tracks
      WHERE 
        ds > '@param01' 
        AND ds < '@param02'
        AND get_json_object(event_data, '$.recommendations')is not null  
        AND get_json_object(event_data, '$.recommendations.has_errors') = 'false'
        AND get_json_object(event_data, '$.recommendations.track_info.empty_result_cause') is null
    ) ttemp1
    GROUP BY ttemp1.ds, ttemp1.client, ttemp1.site_id, ttemp1.model_id, ttemp1.model_version, ttemp1.emptyResultCause
    UNION
    SELECT ttemp2.ds as ds, ttemp2.client as client, ttemp2.site_id as site_id, ttemp2.model_id as model_id, ttemp2.model_version as model_version, ttemp2.emptyResultCause as emptyResultCause, count(*) as errors
    FROM
    (
      SELECT substr(ds, 1,10) as ds
        , get_json_object(event_data, '$.recommendations.client') as client
        , application.site_id as site_id
        , COALESCE(get_json_object(event_data, '$.recommendations.track_info.model_id'),'None')  as model_id
        , COALESCE(get_json_object(event_data, '$.recommendations.track_info.model_version'),'None')  as model_version
        , jest(event_data, 'recommendations.track_info.empty_result_cause') as emptyResultCause
      FROM tracks
      WHERE 
        ds > '@param01' 
        AND ds < '@param02'
        AND get_json_object(event_data, '$.recommendations')is not null  
        AND get_json_object(event_data, '$.recommendations.has_errors') = 'false'
        AND get_json_object(event_data, '$.recommendations.track_info.empty_result_cause') is not null
    ) ttemp2
    GROUP BY ttemp2.ds, ttemp2.client, ttemp2.site_id, ttemp2.model_id, ttemp2.model_version, ttemp2.emptyResultCause
    UNION
    SELECT ttemp3.ds as ds, ttemp3.client as client, ttemp3.site_id as site_id, ttemp3.model_id as model_id, ttemp3.model_version as model_version, ttemp3.emptyResultCause as emptyResultCause, count(*) as errors
    FROM
    (
      SELECT substr(ds, 1,10) as ds
        , jest(event_data, 'recommendations.client') as client
        , application.site_id as site_id
        , 'None' as model_id
        , 'None' as model_version
        , 'HASERROR' as emptyResultCause
      FROM tracks
      WHERE 
        ds > '@param01' 
        AND ds < '@param02'
        AND jest(event_data, 'recommendations.has_errors') = 'true'
    ) ttemp3
    group by ttemp3.ds, ttemp3.client, ttemp3.site_id, ttemp3.model_id, ttemp3.model_version, ttemp3.emptyResultCause
  ) t2 
) t1
GROUP BY t1.ds, t1.client, t1.site_id, t1.model_id, t1.model_version