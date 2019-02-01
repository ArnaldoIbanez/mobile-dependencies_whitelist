SELECT usr.user_id as User_id,
    application.site_id as Site_id,
    jest(event_data, 'seller_profile') as Seller_profile,
    jest(event_data, 'reputation_level') as Reputation_level,
    substr(server_timestamp, 1, 10) as Fecha
FROM tracks
WHERE ds >= '@param01'
    AND ds < '@param02'
    AND path IN ('/seller_central/settings', '/seller_central/empty_settings')
GROUP BY usr.user_id,
    application.site_id,
    jest(event_data, 'seller_profile'),
    jest(event_data, 'reputation_level'),
    substr(server_timestamp, 1, 10)
