SELECT COUNT(DISTINCT t1.usr.user_id) AS Quantity
, t1.application.site_id AS Site_id
, (CASE WHEN t1.path LIKE '/collaborators_admin' AND jest(t1.event_data, 'source') LIKE '%SC-SETTINGS%' THEN 'Optin'
        WHEN t1.path LIKE '/collaborators_admin/congrats'
            AND t1.platform.http.http_referer LIKE '%/collaborators/select_role%'
            AND t1.platform.http.http_url LIKE '%mercadoli%' THEN 'Congrats' ELSE 'Otro' END) AS Step
, substr(t1.ds,1,10) AS ds
FROM TRACKS AS t1
WHERE t1.ds >= '@param01' AND t1.ds < '@param02'
    AND t1.path IN ('/collaborators_admin', '/collaborators_admin/congrats')
    AND t1.usr.user_id IN (SELECT t2.usr.user_id FROM TRACKS AS t2
        WHERE t2.path LIKE '/collaborators_admin' AND jest(t2.event_data, 'source') LIKE '%SC-SETTINGS%'
        AND t2.ds >= '@param01' AND t2.ds < '@param02')
GROUP BY t1.application.site_id
, CASE WHEN t1.path LIKE '/collaborators_admin' AND jest(t1.event_data, 'source') LIKE '%SC-SETTINGS%' THEN 'Optin'
       WHEN t1.path LIKE '/collaborators_admin/congrats' AND t1.platform.http.http_referer LIKE '%/collaborators/select_role%' AND t1.platform.http.http_url LIKE '%mercadoli%' THEN 'Congrats'
       ELSE 'Otro' END
, substr(t1.ds,1,10)