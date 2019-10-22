SELECT
substr(ds,1,10) as ds,
application.site_id as site,
application.business AS business,
(CASE jest(event_data, 'vertical')  WHEN 'MOTOR' THEN 'MOTORS' 
                                    WHEN 'motors' THEN 'MOTORS'
                                    WHEN 'MOTORCYCLE' THEN 'MOTORS'
                                    WHEN 'SERVICE' THEN 'SERVICE'
                                    WHEN 'services' THEN 'SERVICE'
                                    WHEN 'realEstate' THEN 'REAL ESTATE'
                                    WHEN 'REAL_ESTATE' THEN 'REAL ESTATE'
                                    WHEN 'real_estate' THEN 'REAL ESTATE'
                                    WHEN 'RE' THEN 'REAL ESTATE'
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
count(1) as cantidad
FROM tracks 
WHERE  
ds >= '@param01' 
AND ds < '@param02'
AND jest(event_data, 'vertical') IN ('REAL_ESTATE', 'real_estate', 'realEstate', 'RE', 'MOTOR', 'MOTORCYCLE', 'motors', 'SERVICE', 'services')
AND platform.fragment  LIKE '%SA:true,SID%'
AND path IN ('/vip/show_phone', '/vip/call_seller', '/vip/contact_seller', '/quotation/congrats', '/quotation/show_price', '/checkout/congrats')
AND device.platform IN ('/web/desktop', '/web/desktop/forced', '/web/desktop/forced/static', '/web/desktop/static', '/web/mobile', '/web/mobile/forced', '/web/mobile/forced/static', '/web/mobile/static')
AND application.site_id IN ('MCO', 'MLA', 'MLB', 'MLC', 'MLM', 'MLU', 'MLV')
GROUP BY (CASE jest(event_data, 'vertical')  WHEN 'MOTOR' THEN 'MOTORS' 
                                    WHEN 'motors' THEN 'MOTORS'
                                    WHEN 'MOTORCYCLE' THEN 'MOTORS'
                                    WHEN 'SERVICE' THEN 'SERVICE'
                                    WHEN 'services' THEN 'SERVICE'
                                    WHEN 'realEstate' THEN 'REAL ESTATE'
                                    WHEN 'REAL_ESTATE' THEN 'REAL ESTATE'
                                    WHEN 'real_estate' THEN 'REAL ESTATE'
                                    WHEN 'RE' THEN 'REAL ESTATE'
                                    ELSE '' END ),
         (CASE device.platform  WHEN '/web/desktop' THEN '/web/desktop' 
                                    WHEN '/web/desktop/forced' THEN '/web/desktop'
                                    WHEN '/web/desktop/forced/static' THEN '/web/desktop'
                                    WHEN '/web/desktop/static' THEN '/web/desktop'
                                    WHEN '/web/mobile' THEN '/web/mobile'
                                    WHEN '/web/mobile/forced' THEN '/web/mobile'
                                    WHEN '/web/mobile/forced/static' THEN '/web/mobile'
                                    WHEN '/web/mobile/static' THEN '/web/mobile'
                                    ELSE '' END ),
         application.site_id,
         application.business,
         path,
         substr(ds,1,10)