SELECT 
TempTable.device.platform as platform,
TempTable.feedback_value as feedback_value,
TempTable.url as url,
TempTable.site as site,
TempTable.lang as lang,
TempTable.date_created as date_created
FROM (
        SELECT SUBSTRING(ds,1,10) as date_created,
        device.platform,
        jest(event_data, 'like') as feedback_value,
        platform.http.http_url as url,
        jest(event_data, 'site') as site,
        jest(event_data, 'lang') as lang
        FROM tracks
        WHERE ds >= '@param01'
        AND   ds < '@param02'
        AND path LIKE '/devsite/feedback'
        GROUP BY 1,2,3,4,5,6
) as TempTable
