SELECT tracks.path as event_id, complete_flows.flow, device.platform, application.site_id, application.version, jest(event_data, 'collector_nickname') as collector, jest(event_data, 'environment') as environment, substr(ds, 1, 10) as ds_date, count() as ocurrences
FROM tracks
LEFT JOIN
(
  SELECT flow_id, array_join(array_agg(replace(path, '/checkout_off/v1')), ',', '') as flow
    FROM (
      SELECT path, jest(event_data, 'checkout_flow_id') as flow_id, user_timestamp
      FROM tracks
      WHERE ds>='@param01' and
      ds<'@param02' and
      path like '/checkout_off/v1%'
    )
  GROUP BY flow_id
) complete_flows
ON jest(event_data, 'checkout_flow_id') = complete_flows.flow_id
WHERE ds>='@param01' and
ds<'@param02' and
path like '/checkout_off/v1%'
GROUP BY tracks.path, flow, device.platform, application.site_id, application.version, jest(event_data, 'collector_nickname'), jest(event_data, 'environment'), substr(ds, 1, 10)