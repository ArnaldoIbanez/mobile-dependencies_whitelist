SELECT COALESCE(Sent.sent_date, Open.sent_date) AS sent_date, COALESCE(Sent.Template,Open.Template) as template, COALESCE(Sent.Path,'/email/generic') as path,
COALESCE(Sent.Count_send,CAST(0 AS BIGINT)) as count_send, COALESCE(Open.Count_open,CAST(0 AS BIGINT)) as count_open
FROM (
SELECT substr(get_json_object(tracks.event_data,'$.sent_date') ,1,10) AS sent_date,
       get_json_object(tracks.event_data,'$.email_template') AS Template,
       get_json_object(tracks.event_data,'$.event_type') AS Event_Type,
       tracks.path AS PATH,
       COUNT(1) AS Count_Send
FROM tracks
WHERE (ds >= '@param01'
        AND ds < '@param03'
        AND substr(get_json_object(tracks.event_data,'$.sent_date') ,1,10) >= '@param01'
        AND substr(get_json_object(tracks.event_data,'$.sent_date') ,1,10) < '@param02'
        AND get_json_object(tracks.event_data,'$.event_type') in ( 'send', 'delivered' )
GROUP BY substr(get_json_object(tracks.event_data,'$.sent_date') ,1,10),
         get_json_object(tracks.event_data,'$.email_template'),
         get_json_object(tracks.event_data,'$.event_type'),
         path) AS Sent
FULL OUTER JOIN
(SELECT substr(get_json_object(tracks.event_data,'$.sent_date') ,1,10) AS sent_date,
       get_json_object(tracks.event_data,'$.email_template') AS Template,
       get_json_object(tracks.event_data,'$.event_type') AS Event_Type,
       COUNT(1) AS Count_Open
FROM tracks
WHERE    (ds >= '@param01'
        AND ds < '@param03'
        AND substr(get_json_object(tracks.event_data,'$.sent_date') ,1,10) >= '@param01'
        AND substr(get_json_object(tracks.event_data,'$.sent_date') ,1,10) < '@param02'
        AND get_json_object(tracks.event_data,'$.event_type') = 'open')
GROUP BY substr(get_json_object(tracks.event_data,'$.sent_date') ,1,10),
         get_json_object(tracks.event_data,'$.email_template'),
         get_json_object(tracks.event_data,'$.event_type'))  AS Open
ON Open.Template = Sent.template AND Sent.sent_date = Open.sent_date
