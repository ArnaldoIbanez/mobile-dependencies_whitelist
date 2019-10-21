SELECT 
       substr(ds,1,10) as fecha, 
       application.site_id as Site, 
       jest(event_data, 'page') AS Page,
       count(*) as Cantidad_Save
FROM tracks
where  tracks.path like '/catalogwidget/save'
AND  jest(event_data, 'page') not like '%unknown%' and jest(event_data, 'page') not like '%deals%'
and application.business='mercadolibre'
and type='event'
AND ds >= '@param01 02' AND ds < '@param02 02'    
group by substr(ds,1,10), application.site_id, jest(event_data, 'page')
