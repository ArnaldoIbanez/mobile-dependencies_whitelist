SELECT
  path                                  AS path,
  type                                  AS track_type,
  device.platform                       AS device_platform,
  device.device_name                    AS device_name,
  device.connectivity_type              AS device_connectivity_type,
  application.site_id                   AS application_site_id,
  jest(event_data,'seller_profile')     AS seller_profile,
  jest(event_data,'seller_reputation')  AS seller_reputation,
  jest(event_data,'seller_segment')     AS seller_segment,
  jest(event_data,'item_id')            AS item_id,
  jest(event_data,'is_catalog_listing') AS item_is_catalog_listing,
  jest(event_data,'buybox_status')      AS item_buybox_status,
  jest(event_data,'boost_id')           AS buybox_boost_id,
  jest(event_data,'boost_status')       AS buybox_boost_status,
  jest(event_data,'header_type')        AS header_type,
  jest(event_data,'value_type')         AS value_type,
  jest(event_data,'action_id')          AS action_id,
  jest(event_data,'section_id')         AS section_id,
  substr(ds,1,10)                       AS ds
FROM tracks
WHERE ds >= '@param01'
  AND ds < '@param02'
  AND application.business = 'mercadolibre'
  AND device.platform IN ('/mobile/android', '/mobile/ios')
  AND path LIKE '/sell/update/%'
  AND jest(event_data,'vertical') = 'core'
  AND usr.user_nick NOT LIKE 'TETE%'
  AND usr.user_nick NOT LIKE '%TEST%'
