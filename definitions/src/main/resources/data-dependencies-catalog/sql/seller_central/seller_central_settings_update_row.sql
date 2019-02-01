SELECT usr.user_id as User_id,
    application.site_id as Site_id,
    jest(event_data, 'row_id') as Row_id,
    jest(event_data, 'section_id') as Section_id,
    jest(event_data, 'from') as Prev_value,
    jest(event_data, 'to') as Actual_value,
    substr(server_timestamp, 1, 10) as Fecha
FROM tracks
WHERE ds >= '@param01'
    AND ds < '@param02'
    AND path = '/seller_central/settings/update_row'
GROUP BY usr.user_id,
    application.site_id,
    jest(event_data, 'row_id'),
    jest(event_data, 'section_id'),
    jest(event_data, 'from'),
    jest(event_data, 'to'),
    substr(server_timestamp, 1, 10)