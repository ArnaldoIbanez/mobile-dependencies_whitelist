SELECT 
substr(ds,1,10) as ds,
REPLACE (application.site_id,'#','') AS Site,
REPLACE (device.platform,'#','') AS Platform,
REPLACE (application.business,'#','') AS Business,
jest(event_data, 'vertical') AS Vertical,
sum(if(path = '/search/save',1,0)) AS total_save_alert_email,
sum(if((path = '/vip') and (others['fragment'] LIKE '%SA:true%'),1,0)) AS total_clics_email_vip,
sum(if((path = '/vip') and (platform.http.http_referer LIKE '%searchAlertsMail_true%'),1,0)) AS total_clics_email_search_vip,
sum(if((path = '/vip/contact_seller') and (others['fragment'] LIKE '%SA:true%'),1,0)) AS total_contact_seller_email_vip,
sum(if((path = '/vip/contact_seller') and (platform.http.http_referer LIKE '%searchAlertsMail_true%'),1,0)) AS total_contact_seller_email_search_vip,
sum(if((path = '/vip/show_phone') and (others['fragment'] LIKE '%SA:true%'),1,0)) AS total_show_phone_email_vip,
sum(if((path = '/vip/show_phone') and (platform.http.http_referer LIKE '%searchAlertsMail_true%'),1,0)) AS total_show_phone_email_search_vip,
sum(if((path = '/vip/call_seller') and (others['fragment'] LIKE '%SA:true%'),1,0)) AS total_call_seller_email_vip,
sum(if((path = '/vip/call_seller') and (platform.http.http_referer LIKE '%searchAlertsMail_true%'),1,0)) AS total_call_seller_email_search_vip
FROM tracks
WHERE ds >= '2017-04-21' AND ds < '2017-05-10'
GROUP BY substr(ds,1,10), application.site_id, device.platform, jest(event_data, 'vertical'), application.business