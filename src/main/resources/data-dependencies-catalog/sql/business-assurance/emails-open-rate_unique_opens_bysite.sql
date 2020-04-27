SELECT Sent.sent_date, Sent.Template, Sent.Path,count (Sent.email_id) as count_send, sum(if(Open.email_id IS NOT NULL, 1, 0)) as count_open, Sent.site
FROM (
SELECT distinct substr(get_json_object(tracks.event_data,'$.sent_date') ,1,10) AS sent_date,
       get_json_object(tracks.event_data,'$.email_template') AS Template,
       get_json_object(tracks.event_data,'$.event_type') AS Event_Type,
       get_json_object(tracks.event_data,'$.email_id') AS email_id,
       tracks.path AS Path,
       application.site_id as site
FROM tracks
WHERE (ds >= '@param01'
        AND ds < '@param02'
        AND substr(get_json_object(tracks.event_data,'$.sent_date') ,1,10) >= '@param01'
        AND substr(get_json_object(tracks.event_data,'$.sent_date') ,1,10) < '@param02'
        AND get_json_object(tracks.event_data,'$.event_type') in ( 'send', 'delivered' )
        AND path like '/email%'
        )
) AS Sent
LEFT OUTER JOIN
(SELECT distinct substr(get_json_object(tracks.event_data,'$.sent_date') ,1,10) AS sent_date,
       get_json_object(tracks.event_data,'$.email_template') AS Template,
       get_json_object(tracks.event_data,'$.event_type') AS Event_Type,
       get_json_object(tracks.event_data,'$.email_id') AS email_id
FROM tracks
WHERE    (ds >= '@param01'
        AND ds < '@param03'
        AND substr(get_json_object(tracks.event_data,'$.sent_date') ,1,10) >= '@param01'
        AND substr(get_json_object(tracks.event_data,'$.sent_date') ,1,10) < '@param02'
        AND get_json_object(tracks.event_data,'$.event_type') = 'open'
        AND path like '/email%'
         ))  AS Open
ON Sent.sent_date = Open.sent_date AND Sent.email_id=Open.email_id
GROUP BY Sent.sent_date,
         Sent.Template,
         Sent.Path,
         Sent.site
