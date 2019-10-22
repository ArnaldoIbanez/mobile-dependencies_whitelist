SELECT q3.card_selection AS cardselection, 
       q2.cvv_screen     AS cvvscreen, 
       q1.newcard_views  AS newcardviews, 
       q4.confirm_views  AS confirmviews, 
       q1.platform       AS plataforma, 
       q1.site_id        AS site, 
       q1.ds             AS fecha 
FROM   (SELECT Count(DISTINCT usr.user_id) AS newcard_views, 
                         device.platform             AS platform, 
                         application.site_id, 
                         Substr(ds, 1, 10)           AS ds 
                  FROM   tracks 
                  WHERE  ( path = '/loyalty/freetrial/newcard' 
                            OR ( path = '/px_checkout/add_payment_method/number' 
                                 AND event_data LIKE '%isFreeTrial%' ) ) 
                         AND usr.user_nick NOT LIKE 'TETE%' 
                         AND usr.user_nick NOT LIKE 'TEST%' 
                         AND usr.user_nick NOT LIKE 'TT%' 
                         AND ds >= '@param01' 
                         AND ds <= '@param02' 
                  GROUP  BY device.platform, 
                            application.site_id, 
                            Substr(ds, 1, 10)) AS q1 
       LEFT OUTER JOIN (SELECT Count(DISTINCT usr.user_id) AS cvv_screen, 
                         device.platform             AS platform, 
                         application.site_id, 
                         Substr(ds, 1, 10)           AS ds 
                  FROM   tracks 
                  WHERE  ( path = '/loyalty/freetrial/cardselection/cvv' 
                            OR ( path = 
                           '/px_checkout/add_payment_method/credit_card/cvv' 
                                 AND event_data LIKE '%isFreeTrial%' ) ) 
                         AND usr.user_nick NOT LIKE 'TETE%' 
                         AND usr.user_nick NOT LIKE 'TEST%' 
                         AND usr.user_nick NOT LIKE 'TT%' 
                         AND ds >= '@param01' 
                         AND ds <= '@param02'
                  GROUP  BY device.platform, 
                            application.site_id, 
                            Substr(ds, 1, 10)) AS q2 
              ON (q1.ds = q2.ds and q1.platform = q2.platform) 
       LEFT OUTER JOIN (SELECT Count(DISTINCT usr.user_id) AS card_selection, 
               device.platform             AS platform, 
               application.site_id, 
               Substr(ds, 1, 10)           AS ds 
        FROM   tracks 
        WHERE  ( path = '/loyalty/freetrial/cardselection' 
                  OR ( path = '/px_checkout/payments/select_method' 
                       AND event_data LIKE '%isFreeTrial%' ) ) 
               AND usr.user_nick NOT LIKE 'TETE%' 
               AND usr.user_nick NOT LIKE 'TEST%' 
               AND usr.user_nick NOT LIKE 'TT%' 
                         AND ds >= '@param01' 
                         AND ds <= '@param02'
        GROUP  BY device.platform, 
                  application.site_id, 
                  Substr(ds, 1, 10)) AS q3 
              ON (q1.ds = q3.ds and q1.platform = q3.platform) 
       LEFT OUTER JOIN (SELECT Count(DISTINCT usr.user_id) AS confirm_views, 
                         device.platform             AS platform, 
                         application.site_id, 
                         Substr(ds, 1, 10)           AS ds 
                  FROM   tracks 
                  WHERE  path = '/loyalty/freetrial/confirm' 
                         AND usr.user_nick NOT LIKE 'TETE%' 
                         AND usr.user_nick NOT LIKE 'TEST%' 
                         AND usr.user_nick NOT LIKE 'TT%' 
                         AND ds >= '@param01' 
                         AND ds <= '@param02'
                  GROUP  BY device.platform, 
                            application.site_id, 
                            Substr(ds, 1, 10)) AS q4 
              ON (q1.ds = q4.ds and q1.platform = q4.platform)