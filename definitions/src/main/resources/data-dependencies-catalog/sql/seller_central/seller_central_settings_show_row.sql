SELECT usr.user_id as User_id,
    application.site_id as Site_id,
    jest(event_data, 'row_id') as Row_id,
    jest(event_data, 'ui_type') as Ui_type,
    jest(event_data, 'section_id') as Section_id,
    substr(server_timestamp, 1, 10) as ds
FROM tracks
WHERE ds >= '@param01'
    AND ds < '@param02'
    AND path = '/seller_central/settings/show_row'
GROUP BY usr.user_id,
    application.site_id,
    jest(event_data, 'row_id'),
    jest(event_data, 'ui_type'),
    jest(event_data, 'section_id'),
    substr(server_timestamp, 1, 10)
