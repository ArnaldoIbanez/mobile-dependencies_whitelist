SELECT 
    v2.portal_source_id as source_id, 
    v2.portal_content_id as content_id,
    v2.portal_content_type as content_type,
    v2.portal_has_channels_configured as has_channels,
    application.business as business,  
    application.site_id as site_id,
    device.platform as platform,
    substr(from_unixtime(unix_timestamp(t.ds, 'yyyy-MM-dd HH')+3600), 1, 10) AS requested_datetime_day,
    substr(from_unixtime(unix_timestamp(t.ds, 'yyyy-MM-dd HH')+3600), 12, 2) AS requested_datetime_hour,
    count(id) as quantity
FROM tracks t 
LATERAL VIEW json_tuple(t.event_data, 'portal_source_id', 'portal_content_id', 'portal_content_type', 'portal_has_channels_configured') v2 as 
                                       portal_source_id ,  portal_content_id ,  portal_content_type ,  portal_has_channels_configured
where 
    ds >= '@param01 23' and
    ds < '@param02 23' and 
    (
        path LIKE '/support/widget/faq%' OR
        -- path LIKE '/support/widget/folder%' OR -- Esto quedará apagado que se envíe el content type, para asegurar retrocompatibilidad
        path LIKE '/portal/faq%'
    )
GROUP BY
    v2.portal_source_id, 
    v2.portal_content_id, 
    v2.portal_content_type,
    v2.portal_has_channels_configured,
    application.business,  
    application.site_id,
    device.platform,
    substr(from_unixtime(unix_timestamp(t.ds, 'yyyy-MM-dd HH')+3600), 1, 10),
    substr(from_unixtime(unix_timestamp(t.ds, 'yyyy-MM-dd HH')+3600), 12, 2)
