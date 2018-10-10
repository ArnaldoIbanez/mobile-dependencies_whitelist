SELECT tracks.usr.user_id as seller_id, get_json_object(tracks.event_data,'$.email_template') as Template, ds as open_date
FROM tracks
WHERE (ds >= '@param01'
        AND ds < '@param02'
        AND path = '/email/generic'
        AND get_json_object(tracks.event_data,'$.email_template') = 'TEMP_LOW_1_SJ'
        AND substr(get_json_object(tracks.event_data,'$.sent_date') ,1,10) >= '@param03'
        AND get_json_object(tracks.event_data,'$.event_type') = 'open'
        )