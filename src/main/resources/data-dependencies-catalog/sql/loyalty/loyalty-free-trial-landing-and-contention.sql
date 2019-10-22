SELECT ( q2.contention_views * 100 / q1.landing_views ) AS porcentajeIngresos, 
       q1.landing_views                                 AS ingresosLanding, 
       q2.contention_views                              AS ingresosContencion, 
       q1.platform                                      AS plataforma, 
       q1.site_id                                       AS site,
       q1.ds 											AS fecha
FROM   (SELECT Count(DISTINCT usr.user_id) AS landing_views, 
               device.platform             AS platform, 
               application.site_id, 
               Substr(ds, 1, 10)           AS ds  
        FROM   tracks 
        WHERE  path = '/loyalty/freetrial/landing' 
               AND usr.user_nick NOT LIKE 'TETE%' 
               AND usr.user_nick NOT LIKE 'TEST%'
               AND usr.user_nick NOT LIKE 'TT%'
                     AND ds >= '@param01' 
                     AND ds <= '@param02'
        GROUP  BY device.platform, 
                  application.site_id, Substr(ds, 1, 10)) AS q1 
       LEFT OUTER JOIN (SELECT Count(DISTINCT usr.user_id) AS contention_views, 
                          device.platform             AS platform, 
                          application.site_id, 
                         Substr(ds, 1, 10)           AS ds  
                   FROM   tracks 
                   WHERE  path = '/loyalty/freetrial/contention' 
                          AND usr.user_nick NOT LIKE 'TETE%' 
                          AND usr.user_nick NOT LIKE 'TEST%'
               			  AND usr.user_nick NOT LIKE 'TT%'
                     AND ds >= '@param01' 
                     AND ds <= '@param02'
                   GROUP  BY device.platform, 
                             application.site_id, Substr(ds, 1, 10)) AS q2 
               ON (q1.platform = q2.platform AND q1.ds = q2.ds)