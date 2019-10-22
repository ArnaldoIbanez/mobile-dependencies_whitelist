SELECT q.request_method, q.app_id, q.seller_id, q.endpoint, q.request_uri, q.status, q.ds
FROM 
(
SELECT ds, 
request_method,
regexp_extract(request_uri, 'APP_USR-([0-9]+)', 1) as app_id, 
regexp_extract(request_uri, 'APP_USR-[0-9]+-[0-9]+-X-([0-9]+)', 1) as seller_id, 
regexp_extract(request_uri, '(.*)(\?)', 1) as endpoint, 
request_uri as request_uri,
status as status
FROM traffic.access_logs_archive 
WHERE scope='pubapi' AND concern = 'api' AND ds >= '@param01T00_00_00' AND ds <= '@param01T23_00_00'
and request_uri like ('%access_token%')
) as q
GROUP BY ds, request_method, app_id, seller_id, endpoint, request_uri, status; 