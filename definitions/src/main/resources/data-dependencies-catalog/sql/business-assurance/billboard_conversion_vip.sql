SELECT bb.ds as Fecha, bb.site as Site, bb.business as Business, bb.vertical as Vertical, bb.plataforma as Plataforma, bb.item as Item, bb.path as Path, bb.cantidad as Cant_bb, notbb.cantidad as Cant_notbb FROM
(
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
jest(event_data,'item_id') as item, 
path,
count(*) as cantidad 
FROM TRACKS
WHERE
path = '/vip'
AND jest(event_data, 'vertical') IN ('REAL_ESTATE', 'real_estate', 'realEstate', 'RE', 'MOTOR', 'MOTORCYCLE', 'motors', 'SERVICE', 'services')
AND others['fragment'] LIKE '%BB:%'
AND path = '/vip'
AND device.platform IN ('/web/desktop', '/web/desktop/forced', '/web/desktop/forced/static', '/web/desktop/static', '/web/mobile', '/web/mobile/forced', '/web/mobile/forced/static', '/web/mobile/static')
AND application.site_id IN ('MCO', 'MLA', 'MLB', 'MLC', 'MLM', 'MLU', 'MLV')
AND ds >= '@param01' and ds < '@param02'
GROUP BY substr(ds,1,10),
application.site_id,
application.business,
(CASE jest(event_data, 'vertical')  WHEN 'MOTOR' THEN 'MOTORS' 
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
jest(event_data,'item_id'),
path
) AS bb
LEFT JOIN
(
SELECT substr(ds,1,10) as ds, 
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
jest(event_data,'item_id') as item, 
path,
count(*) as cantidad 
FROM TRACKS
WHERE
path = '/vip'
AND jest(event_data, 'vertical') IN ('REAL_ESTATE', 'real_estate', 'realEstate', 'RE', 'MOTOR', 'MOTORCYCLE', 'motors', 'SERVICE', 'services')
AND jest(event_data,'billboard_clicked_position') IS NULL
AND path = '/vip'
AND device.platform IN ('/web/desktop', '/web/desktop/forced', '/web/desktop/forced/static', '/web/desktop/static', '/web/mobile', '/web/mobile/forced', '/web/mobile/forced/static', '/web/mobile/static')
AND application.site_id IN ('MCO', 'MLA', 'MLB', 'MLC', 'MLM', 'MLU', 'MLV')
AND ds >= '@param01' and ds < '@param02'
GROUP BY substr(ds,1,10), 
application.site_id,
application.business,
(CASE jest(event_data, 'vertical')  WHEN 'MOTOR' THEN 'MOTORS' 
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
jest(event_data,'item_id'),
path
) AS notbb
ON bb.ds = notbb.ds 
AND bb.item = notbb.item 
AND bb.site = notbb.site
AND bb.business = notbb.business 
AND bb.vertical = notbb.vertical
AND bb.plataforma = notbb.plataforma
AND bb.path = notbb.path