SELECT
  onetap_started.platform,
  onetap_started.site_id, 
  onetap_started.version,
  onetap_started.collector_id, 
  onetap_started.flows_init_count as started_onetap_count,
  onetap_converted.onetap_converted_count as converted_onetap_count,
  COALESCE(replace(CAST(ROUND(((onetap_converted.onetap_converted_count * 100) / CAST(onetap_started.flows_init_count as DOUBLE)), 2) as varchar(6)), '.', ','), '0')  as conversion,
  onetap_started.environment,
  onetap_started.ds_date
  
FROM
  (
    SELECT device.platform, application.site_id, application.version, jest(event_data, 'collector_id') as collector_id, jest(event_data, 'environment') as environment, substr(ds, 1, 10) as ds_date, 
                         count(DISTINCT jest(event_data, 'checkout_flow_id')) as flows_init_count
                      FROM tracks
                          WHERE type = 'view' and
                                ds>= '@param01' and 
                                ds< '@param02' and
                                path = '/checkout_off/v1/express' and
                                application.site_id = 'MLA' and
                                device.platform LIKE '/mobile/%'
                              GROUP BY device.platform, application.version, substr(ds, 1, 10), jest(event_data, 'collector_id'), application.site_id, jest(event_data, 'environment')
  ) onetap_started
LEFT JOIN 
  (
    SELECT device.platform, application.site_id, application.version, jest(event_data, 'collector_id') as collector_id, jest(event_data, 'environment') as environment, substr(ds, 1, 10) as ds_date, 
                         count(DISTINCT jest(event_data, 'checkout_flow_id')) as onetap_converted_count
                      FROM tracks
                          WHERE type = 'event' and
                                ds>= '@param01' and 
                                ds< '@param02' and
                                path = '/checkout_off/v1/checkout_confirmed' and
                                jest(event_data, 'screen_name') = '/express' and
                                application.site_id = 'MLA' and
                                device.platform LIKE '/mobile/%'
                              GROUP BY device.platform, application.version, substr(ds, 1, 10), jest(event_data, 'collector_id'), application.site_id, jest(event_data, 'environment')
  ) onetap_converted
  ON onetap_started.platform = onetap_converted.platform AND onetap_started.site_id = onetap_converted.site_id 
  AND onetap_started.version = onetap_converted.version AND onetap_started.collector_id = onetap_converted.collector_id 
  AND onetap_started.ds_date = onetap_converted.ds_date AND onetap_started.environment  = onetap_converted.environment