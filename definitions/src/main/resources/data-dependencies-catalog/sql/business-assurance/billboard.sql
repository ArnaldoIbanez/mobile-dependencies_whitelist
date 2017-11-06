SELECT 
substr(ds,1,10) as ds,
application.site_id as site,
application.business AS business,
(CASE (substr(jest (event_data, 'category_id'),4,8))  WHEN '1459' THEN 'REAL ESTATE' 
                                    WHEN '1743' THEN 'MOTORS'
                                    WHEN '1540' THEN 'SERVICE'
                                    ELSE '' END ) as vertical,
(CASE device.platform  WHEN '/web/desktop' THEN '/web/desktop' 
                                    WHEN '/web/desktop/forced' THEN '/web/desktop'
                                    WHEN '/web/desktop/forced/static' THEN '/web/desktop'
                                    WHEN '/web/desktop/static' THEN '/web/desktop'
                                    WHEN '/web/mobile' THEN '/web/mobile'
                                    WHEN '/web/mobile/forced' THEN '/web/mobile'
                                    WHEN '/web/mobile/forced/static' THEN '/web/mobile'
                                    WHEN '/web/mobile/static' THEN '/web/mobile'
                                    ELSE '' END ) as plataforma,
path as path,
jest (event_data, 'position_shown') as posicion,
count(*) as cantidad
FROM tracks
WHERE ds >= '@param01' AND ds < '@param02'
AND path = '/search/billboard'
AND jest (event_data, 'category_id') IS NOT NULL 
AND device.platform IN ('/web/desktop', '/web/desktop/forced', '/web/desktop/forced/static', '/web/desktop/static', '/web/mobile', '/web/mobile/forced', '/web/mobile/forced/static', '/web/mobile/static')
AND application.site_id IN ('MCO', 'MLA', 'MLB', 'MLC', 'MLM', 'MLU', 'MLV')
group by substr(ds,1,10), 
application.site_id, 
application.business,
path,
(CASE (substr(jest (event_data, 'category_id'),4,8))  WHEN '1459' THEN 'REAL ESTATE' 
                                    WHEN '1743' THEN 'MOTORS'
                                    WHEN '1540' THEN 'SERVICE'
                                    ELSE '' END ),
jest (event_data, 'position_shown'), 
(CASE device.platform  WHEN '/web/desktop' THEN '/web/desktop' 
                                    WHEN '/web/desktop/forced' THEN '/web/desktop'
                                    WHEN '/web/desktop/forced/static' THEN '/web/desktop'
                                    WHEN '/web/desktop/static' THEN '/web/desktop'
                                    WHEN '/web/mobile' THEN '/web/mobile'
                                    WHEN '/web/mobile/forced' THEN '/web/mobile'
                                    WHEN '/web/mobile/forced/static' THEN '/web/mobile'
                                    WHEN '/web/mobile/static' THEN '/web/mobile'
                                    ELSE '' END )