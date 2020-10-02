SELECT COUNT(*) ocurrencias,
        device.platform as platform,
        get_json_object(event_data, '$.like') as feedback_value,
        platform.http.http_url as url,
        get_json_object(event_data, '$.site') as site,
        get_json_object(event_data, '$.lang') as lang,
        SUBSTRING(ds,1,10) as date_created
        FROM tracks
        WHERE ds >= '@param01'
        AND   ds < '@param02'
        AND path = '/devsite/feedback'
        GROUP BY
        device.platform, 
        get_json_object(event_data, '$.like'),
        platform.http.http_url, 
        get_json_object(event_data, '$.site'),
        get_json_object(event_data, '$.lang'),
        SUBSTRING(ds,1,10)