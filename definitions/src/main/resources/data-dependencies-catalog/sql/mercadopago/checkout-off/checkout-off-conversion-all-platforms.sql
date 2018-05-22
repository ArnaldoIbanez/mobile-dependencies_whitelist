SELECT
  flows_started.platform,
  flows_started.site_id, 
  flows_started.version,
  flows_started.collector_id, 
  flows_started.flows_init_count as started_flows_count,
  flows_converted.flows_converted_count as converted_flows_count,
  COALESCE(replace(CAST(ROUND(((flows_converted.flows_converted_count * 100) / CAST(flows_started.flows_init_count as DOUBLE)), 2) as varchar(6)), '.', ','), '0')  as conversion,
  flows_started.environment,
  flows_started.ds_date
  
FROM
  (
    SELECT device.platform, application.site_id, application.version, jest(event_data, 'collector_id') as collector_id, jest(event_data, 'environment') as environment, substr(ds, 1, 10) as ds_date, 
                         count(DISTINCT jest(event_data, 'checkout_flow_id')) as flows_init_count
                      FROM tracks
                          WHERE type = 'event' and
                                ds>='@param01' and 
                                ds<'@param02' and
                                path = '/checkout_off/v1/init'
                              GROUP BY device.platform, application.version, substr(ds, 1, 10), jest(event_data, 'collector_id'), application.site_id, jest(event_data, 'environment')
  ) flows_started
LEFT JOIN 
  (
    SELECT device.platform, application.site_id, application.version, jest(event_data, 'collector_id') as collector_id, jest(event_data, 'environment') as environment, substr(ds, 1, 10) as ds_date, 
                         count(DISTINCT jest(event_data, 'checkout_flow_id')) as flows_converted_count
                      FROM tracks
                          WHERE type = 'event' and
                                ds>='@param01' and 
                                ds<'@param02' and
                                path = '/checkout_off/v1/checkout_confirmed'
                              GROUP BY device.platform, application.version, substr(ds, 1, 10), jest(event_data, 'collector_id'), application.site_id, jest(event_data, 'environment')
  ) flows_converted
  ON flows_started.platform = flows_converted.platform AND flows_started.site_id = flows_converted.site_id 
  AND flows_started.version = flows_converted.version AND flows_started.collector_id = flows_converted.collector_id 
  AND flows_started.ds_date = flows_converted.ds_date AND flows_started.environment  = flows_converted.environment