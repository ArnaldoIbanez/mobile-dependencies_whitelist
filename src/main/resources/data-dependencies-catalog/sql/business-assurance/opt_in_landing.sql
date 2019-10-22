SELECT landing.tracking_date as tracking_date,
        landing.site_id as site_id,
        COUNT(DISTINCT landing.uid) as visits_quantity,
        COUNT(DISTINCT optin.uid) as optin_quantity,
        COUNT(DISTINCT congrats.uid) as congrats_quantity,
        COUNT(DISTINCT cancel_optin.uid) as cancel_optin_quantity,
        CASE WHEN COUNT(DISTINCT landing.uid) > 0 THEN COUNT(DISTINCT optin.uid) * 100 / CAST(COUNT(DISTINCT landing.uid) AS DOUBLE) ELSE 0 END AS conversion_optin_landing,
        CASE WHEN COUNT(DISTINCT landing.uid) > 0 THEN COUNT(DISTINCT congrats.uid) * 100 / CAST(COUNT(DISTINCT landing.uid) AS DOUBLE) ELSE 0 END AS conversion_congrats_landing,
        CASE WHEN COUNT(DISTINCT landing.uid) > 0 THEN COUNT(DISTINCT cancel_optin.uid) * 100 / CAST(COUNT(DISTINCT landing.uid) AS DOUBLE) ELSE 0 END AS conversion_cancel_landing,
        CASE WHEN COUNT(DISTINCT optin.uid) > 0 THEN COUNT(DISTINCT congrats.uid) * 100 / CAST(COUNT(DISTINCT optin.uid) AS DOUBLE) ELSE 0 END AS conversion_congrats_optin,
        CASE WHEN COUNT(DISTINCT optin.uid) > 0 THEN COUNT(DISTINCT cancel_optin.uid) * 100 / CAST(COUNT(DISTINCT optin.uid) AS DOUBLE) ELSE 0 END AS conversion_cancel_optin
FROM
    (
        SELECT SUBSTR(DS,1,10) AS tracking_date, application.site_id as site_id, usr.uid as uid
        FROM tracks
        WHERE ds >= '@param01' AND ds < '@param02'
          AND path = '/fbm/landing'
          AND application.site_id = 'MLM'
          AND usr.user_nick NOT LIKE 'TETE%'
          AND usr.user_nick NOT LIKE 'TT%'
          AND usr.user_nick NOT LIKE 'TEST%'
          AND usr.user_nick <> 'MEXICO-SELLER'
    ) as landing
 LEFT JOIN
    (
        SELECT SUBSTR(DS,1,10) AS tracking_date, application.site_id as site_id, usr.uid as uid
        FROM tracks
        WHERE ds >= '@param01' AND ds < '@param02'
          AND path = '/fbm/landing/optin'
          AND application.site_id = 'MLM'
          AND usr.user_nick NOT LIKE 'TETE%'
          AND usr.user_nick NOT LIKE 'TT%'
          AND usr.user_nick NOT LIKE 'TEST%'
          AND usr.user_nick <> 'MEXICO-SELLER'
    ) as optin
    ON landing.uid = optin.uid
    AND landing.site_id = optin.site_id
    AND landing.tracking_date = optin.tracking_date
 LEFT JOIN
    (
        SELECT SUBSTR(DS,1,10) AS tracking_date, application.site_id as site_id, usr.uid as uid
        FROM tracks
        WHERE ds >= '@param01' AND ds < '@param02'
          AND path = '/fbm/landing/congrats'
          AND application.site_id = 'MLM'
          AND usr.user_nick NOT LIKE 'TETE%'
          AND usr.user_nick NOT LIKE 'TT%'
          AND usr.user_nick NOT LIKE 'TEST%'
          AND usr.user_nick <> 'MEXICO-SELLER'
    ) as congrats
    ON optin.uid = congrats.uid
    AND optin.site_id = congrats.site_id
    AND optin.tracking_date = congrats.tracking_date
 LEFT JOIN
    (
        SELECT SUBSTR(DS,1,10) AS tracking_date, application.site_id as site_id, usr.uid as uid
        FROM tracks
        WHERE ds >= '@param01' AND ds < '@param02'
          AND path = '/fbm/landing/cancel_opt_in'
          AND application.site_id = 'MLM'
          AND usr.user_nick NOT LIKE 'TETE%'
          AND usr.user_nick NOT LIKE 'TT%'
          AND usr.user_nick NOT LIKE 'TEST%'
          AND usr.user_nick <> 'MEXICO-SELLER'
    ) as cancel_optin
    ON optin.uid = cancel_optin.uid
    AND optin.site_id = cancel_optin.site_id
    AND optin.tracking_date = cancel_optin.tracking_date

GROUP BY landing.tracking_date, landing.site_id


