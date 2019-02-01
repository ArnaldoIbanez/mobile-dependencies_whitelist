SELECT usr.user_id as User_id,
    application.site_id as Site_id,
    jest(event_data, 'seller_profile') as Seller_profile,
    jest(event_data, 'reputation_level') as Reputation_level,
    CASE WHEN path LIKE '%/settings%' THEN 'SETTINGS'
         WHEN path LIKE '%/empty_settings%' THEN 'EMPTY_SETTINGS' END as Page,
    substr(server_timestamp, 1, 10) as ds
FROM tracks
WHERE ds >= '@param01'
    AND ds < '@param02'
    AND path IN ('/seller_central/settings', '/seller_central/empty_settings')
GROUP BY usr.user_id,
    application.site_id,
    jest(event_data, 'seller_profile'),
    jest(event_data, 'reputation_level'),
    CASE WHEN path LIKE '%/settings%' THEN 'SETTINGS'
         WHEN path LIKE '%/empty_settings%' THEN 'EMPTY_SETTINGS' END,
    substr(server_timestamp, 1, 10)
