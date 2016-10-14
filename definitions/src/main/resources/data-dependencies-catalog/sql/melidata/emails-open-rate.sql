SELECT substr(get_json_object(tracks.event_data,'$.sent_date') ,1,10),
  get_json_object(tracks.event_data,'$.email_template') AS Template,
  get_json_object(tracks.event_data,'$.event_type') AS Event_Type,
  tracks.path AS PATH,
  COUNT(1) AS Count
FROM tracks
WHERE ((ds >= '@param01'
    AND ds < '@param02'
    AND substr(get_json_object(tracks.event_data,'$.sent_date') ,1,10) >= '@param01'
    AND substr(get_json_object(tracks.event_data,'$.sent_date') ,1,10) < '@param02'
    AND get_json_object(tracks.event_data,'$.event_type') = 'send')
  OR    (ds >= '@param01'
    AND ds < '@param03'
    AND substr(get_json_object(tracks.event_data,'$.sent_date') ,1,10) >= '@param01'
    AND substr(get_json_object(tracks.event_data,'$.sent_date') ,1,10) < '@param02'
    AND get_json_object(tracks.event_data,'$.event_type') = 'open'))
GROUP BY substr(get_json_object(tracks.event_data,'$.sent_date') ,1,10),
  get_json_object(tracks.event_data,'$.email_template'),
  get_json_object(tracks.event_data,'$.event_type'),
  path
ORDER BY ds, Template, Event_Type