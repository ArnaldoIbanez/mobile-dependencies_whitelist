SELECT
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
jest(event_data,'billboard_clicked_position') as posicion,
(CASE WHEN jest(event_data, 'vertical') IN ('REAL_ESTATE', 'real_estate', 'realEstate', 'RE')
  THEN jest(event_data, 'domain_id') like '%DEVELOPMENT%'
 WHEN jest(event_data, 'vertical') IN ('MOTOR', 'MOTORCYCLE', 'motors')
   THEN jest(event_data, 'item_condition') = 'new'
   END) as is_new_billboard,
count(1) as cantidad,
substr(ds,1,10) as ds
FROM tracks 
WHERE  
ds >= '@param01' 
AND ds < '@param02'
AND jest(event_data, 'vertical') IN ('REAL_ESTATE', 'real_estate', 'realEstate', 'RE', 'MOTOR', 'MOTORCYCLE', 'motors', 'SERVICE', 'services')
AND platform.fragment LIKE '%BB:%'
AND path IN ('/vip')
AND device.platform IN ('/web/desktop', '/web/desktop/forced', '/web/desktop/forced/static', '/web/desktop/static', '/web/mobile', '/web/mobile/forced', '/web/mobile/forced/static', '/web/mobile/static')
AND application.site_id IN ('MCO', 'MLA', 'MLB', 'MLC', 'MLM', 'MLU', 'MLV')
AND jest(event_data,'billboard_clicked_position') IS NOT NULL
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
         jest(event_data,'billboard_clicked_position'),
         (CASE WHEN jest(event_data, 'vertical') IN ('REAL_ESTATE', 'real_estate', 'realEstate', 'RE')
          THEN jest(event_data, 'domain_id') like '%DEVELOPMENT%'
          WHEN jest(event_data, 'vertical') IN ('MOTOR', 'MOTORCYCLE', 'motors')
          THEN jest(event_data, 'item_condition') = 'new'
          END),
         path,
         substr(ds,1,10)