SELECT 
v2.portal_source_id as source_id, 
v2.portal_content_id as content_id, 
v2.portal_has_channels_configured as has_channels,
application.business as business,  
application.site_id as site_id,
device.platform as platform,
count(t.id) as quantity,
substr(t.ds, 12, 2) AS requested_datetime_hour,
substr(t.ds, 1, 10) AS requested_datetime_day
FROM tracks t 
LATERAL VIEW json_tuple(t.event_data, 
              'portal_source_id', 
              'portal_content_id', 
              'portal_has_channels_configured') v2 as portal_source_id, portal_content_id, portal_has_channels_configured
where 
t.ds >= '@param01 23'
AND t.ds < '@param02 23'
and 
(t.path LIKE '/support/widget/faq%' OR t.path LIKE '/portal/faq%')
GROUP BY
v2.portal_source_id, 
v2.portal_content_id, 
v2.portal_has_channels_configured,
application.business,  
application.site_id,
device.platform,
substr(t.ds, 12, 2),
substr(t.ds, 1, 10)