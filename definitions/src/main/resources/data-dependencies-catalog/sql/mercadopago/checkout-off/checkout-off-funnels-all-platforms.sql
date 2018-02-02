SELECT regexp_replace(tracks.path, '/checkout_off/v1', '') as event_id, complete_flows.flow as flow, device.platform as platform, application.site_id as site_id, application.version as version, jest(event_data, 'collector_nickname') as collector, jest(event_data, 'environment') as environment, substr(ds, 1, 10) as ds_date, count(*) as ocurrences
FROM tracks
LEFT JOIN
(
  SELECT flow_id, concat_ws(',', sort_array(collect_list(regexp_replace(path, '/checkout_off/v1', '')))) as flow
  FROM (
    SELECT path, jest(event_data, 'checkout_flow_id') as flow_id, user_timestamp
    FROM tracks
    WHERE ds>='@param01' and
    ds<'@param02' and
    path like '/checkout_off/v1%' 
  ) as all_tracks
  GROUP BY flow_id
) as complete_flows
ON jest(event_data, 'checkout_flow_id') = complete_flows.flow_id
WHERE ds>='@param01' and
ds<'@param02' and
path like '/checkout_off/v1%'
GROUP BY tracks.path, complete_flows.flow, device.platform, application.site_id, application.version, jest(event_data, 'collector_nickname'), jest(event_data, 'environment'), substr(ds, 1, 10)
HAVING count(*) > 1
ORDER BY ocurrences DESC