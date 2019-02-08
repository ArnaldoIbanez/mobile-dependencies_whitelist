SELECT t1.usr.user_id as User_id,
    t1.application.site_id as Site_id,
    substr(server_timestamp, 1, 10) as ds
FROM tracks as t1
INNER JOIN tracks as t2 ON (t1.usr.user_id=t2.usr.user_id AND t1.application.site_id=t2.application.site_id)
INNER JOIN tracks as t3 ON (t2.usr.user_id=t3.usr.user_id AND t2.application.site_id=t3.application.site_id)
WHERE t1.ds >= '@param01' AND t1.ds < '@param02'
    AND t1.path='/seller_central/settings/show_row'
    AND jest(t1.event_data, 'row_id') LIKE '%row_operators%'
    AND jest(t1.event_data, 'ui_type') LIKE '%row_disabled%'
    AND t2.ds >= '@param01' AND t2.ds < '@param02'
    AND jest(t2.event_data, 'source') LIKE '%SC-SETTINGS%'
    AND t2.path='/collaborators_admin'
    AND t3.ds >= '@param01' AND t3.ds < '@param02'
    AND t3.path='/collaborators_admin/congrats'
    AND t3.platform.http.http_referer like '%/collaborators/select_role%'
    AND t3.platform.http.http_url like '%mercadoli%'
GROUP BY t1.usr.user_id,
    t1.application.site_id,
    substr(t1.server_timestamp, 1, 10)
