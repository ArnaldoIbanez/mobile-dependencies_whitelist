SELECT 
t.path as path,
v2.portal_source_id as source_id, 
v2.portal_content_id as content_id, 
v2.portal_has_channels_configured as has_channels,  
v2.portal_form_id as form_id, 
v2.portal_problem_id as problem_id,
v2.portal_case_created as case_created,
application.site_id as site_id,
device.platform as platform,
count(t.id) as views,
substr(t.ds, 12, 2) AS requested_datetime_hour,
substr(t.ds, 1, 10) AS requested_datetime_day
FROM tracks t 
LATERAL VIEW json_tuple(t.event_data, 
              'portal_source_id', 
              'portal_content_id', 
              'portal_has_channels_configured', 
              'portal_form_id', 
              'portal_problem_id', 
              'portal_case_created') v2 as portal_source_id, portal_content_id, portal_has_channels_configured, portal_form_id, portal_problem_id, portal_case_created
where 
t.ds >= '@param01 23'
and t.ds < '@param02 23'
and 
(t.path LIKE '/support/widget/faq%' OR t.path LIKE '/support/widget/problem%' OR t.path LIKE '/support/widget/form%' OR t.path LIKE '/support/widget/folder%')
GROUP BY
t.path,
v2.portal_source_id, 
v2.portal_content_id, 
v2.portal_has_channels_configured, 
v2.portal_form_id, 
v2.portal_problem_id,
v2.portal_case_created,
application.site_id,
device.platform,
substr(t.ds, 12, 2),
substr(t.ds, 1, 10)