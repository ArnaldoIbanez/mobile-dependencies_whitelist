SELECT substr(ds, 1, 10) as ds_date,
      device.platform, 
      application.site_id,
      substr(path, 14) as page,
      count(DISTINCT jest(event_data, 'checkout_flow_id')) as total
 FROM tracks
   WHERE type = 'view' and
         ds >= '@param01' and 
         ds < '@param02' and 
         catalog_data.is_valid = true and
         path LIKE '/checkout_off/%' and
         path <> '/checkout_off/init'
         GROUP BY substr(ds, 1, 10), device.platform, application.site_id, substr(path, 14)