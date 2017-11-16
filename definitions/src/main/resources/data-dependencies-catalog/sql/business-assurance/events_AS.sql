SELECT
substr(ds,1,10) as ds,
application.site_id as Site,
device.platform as Platform,
application.business AS Business,
(CASE jest(event_data, 'vertical')  WHEN 'MOTOR' THEN 'MOTORS' 
                                    WHEN 'motors' THEN 'MOTORS'
                                    WHEN 'MOTORCYCLE' THEN 'MOTORS'
                                    WHEN 'SERVICE' THEN 'SERVICE'
                                    WHEN 'services' THEN 'SERVICE'
                                    WHEN 'realEstate' THEN 'REAL ESTATE'
                                    WHEN 'REAL_ESTATE' THEN 'REAL ESTATE'
                                    WHEN 'real_estate' THEN 'REAL ESTATE'
                                    WHEN 'RE' THEN 'REAL ESTATE'
                                    ELSE '' END ) as Vertical,
SUM(IF((path = '/vip') AND (others['fragment'] LIKE '%SA:true%'),1,0)) AS vip_SA, 
SUM(IF((path = '/vip'),1,0)) AS vip_total, 
SUM(IF((path = '/vip') AND (platform.http.http_referer LIKE '%searchAlertsMail_true%'),1,0)) AS vip_by_search, 
SUM(IF((path = '/vip/show_phone') AND (others['fragment'] LIKE '%SA:true%'),1,0)) AS show_phone_SA, 
SUM(IF((path = '/vip/show_phone'),1,0)) AS show_phone_total,
SUM(IF((path = '/vip/call_seller') AND (others['fragment'] LIKE '%SA:true%'),1,0)) AS call_seller_SA, 
SUM(IF((path = '/vip/call_seller'),1,0)) AS call_seller_total,
SUM(IF((path = '/vip/contact_seller') AND (others['fragment'] LIKE '%SA:true%'),1,0)) AS contact_seller_SA,
SUM(IF((path = '/vip/contact_seller'),1,0)) AS contact_seller_total,
SUM(IF((path = '/quotation/congrats') AND (others['fragment'] LIKE '%SA:true%'),1,0)) AS quotation_SA,
SUM(IF((path = '/quotation/congrats'),1,0)) AS quotation_total,
SUM(IF((path = '/checkout/congrats') AND (others['fragment'] LIKE '%SA:true%'),1,0)) AS sena_SA,
SUM(IF((path = '/checkout/congrats'),1,0)) AS sena_total
FROM tracks 
WHERE  
ds >= '@param01' 
AND ds < '@param02'
AND jest(event_data, 'vertical') IN ('REAL_ESTATE', 'real_estate', 'realEstate', 'RE', 'MOTOR', 'MOTORCYCLE', 'motors', 'SERVICE', 'services')
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
         application.site_id,
         device.platform,
         application.business,
         substr(ds,1,10)