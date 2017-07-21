SELECT Sent.sent_date, Sent.Template, Sent.Path,count (Sent.email_id) as count_send, sum(if(Open.email_id IS NOT NULL, 1, 0)) as count_open
FROM (
SELECT distinct substr(get_json_object(tracks.event_data,'$.sent_date') ,1,10) AS sent_date,
       get_json_object(tracks.event_data,'$.email_template') AS Template,
       get_json_object(tracks.event_data,'$.event_type') AS Event_Type,
       get_json_object(tracks.event_data,'$.email_id') AS email_id,
       tracks.path AS Path
FROM tracks
WHERE (ds >= '@param1'
        AND ds < '@param2'
        AND substr(get_json_object(tracks.event_data,'$.sent_date') ,1,10) >= '@param1'
        AND substr(get_json_object(tracks.event_data,'$.sent_date') ,1,10) < '@param2'
        AND get_json_object(tracks.event_data,'$.event_type') = 'send'
        AND path like '/email%'
        )
) AS Sent
LEFT OUTER JOIN
(SELECT distinct substr(get_json_object(tracks.event_data,'$.sent_date') ,1,10) AS sent_date,
       get_json_object(tracks.event_data,'$.email_template') AS Template,
       get_json_object(tracks.event_data,'$.event_type') AS Event_Type,
       get_json_object(tracks.event_data,'$.email_id') AS email_id
FROM tracks
WHERE    (ds >= '@param1'
        AND ds < '@param3'
        AND substr(get_json_object(tracks.event_data,'$.sent_date') ,1,10) >= '@param1'
        AND substr(get_json_object(tracks.event_data,'$.sent_date') ,1,10) < '@param2'
        AND get_json_object(tracks.event_data,'$.event_type') = 'open'
        AND path like '/email%'
         ))  AS Open
ON Sent.sent_date = Open.sent_date AND Sent.email_id=Open.email_id
GROUP BY Sent.sent_date,
         Sent.Template,
         Sent.Path
ORDER BY Sent.Template