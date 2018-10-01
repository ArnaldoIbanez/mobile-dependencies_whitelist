SELECT 
v2.portal_source_id as source_id, 
v2.portal_has_channels_configured as has_channels,  
application.site_id as site_id,
application.business as business,
substr(t.ds, 12, 2) AS requested_datetime_hour,
substr(t.ds, 1, 10) AS requested_datetime_day,
count(t.id)
FROM tracks t 
LATERAL VIEW json_tuple(t.event_data, 
              'portal_source_id',
              'portal_has_channels_configured') v2 as portal_source_id, portal_has_channels_configured
where 
t.ds >= '@param01 23'
AND t.ds < '@param02 23'
AND 
(t.path LIKE '/support/widget/faq%' OR t.path LIKE '/support/widget/problem%' OR t.path LIKE '/support/widget/form%' OR t.path LIKE '/support/widget/folder%')
GROUP BY
v2.portal_source_id, 
v2.portal_has_channels_configured,  
application.site_id,
application.business,
substr(t.ds, 12, 2),
substr(t.ds, 1, 10)