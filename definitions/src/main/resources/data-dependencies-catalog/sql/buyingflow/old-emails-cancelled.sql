SELECT ds, site, email_template, COUNT(1) as quantity
FROM (
  SELECT
    substr(ds,1,10) as ds,
    application.site_id as site,
    json_extract_scalar(event_data,'$.email_template') as email_template
  FROM 
    tracks 
  WHERE 
    ds >= '@param01' 
  	AND ds < '@param02'
    ds >= '2018-03-01 10' 
    AND ds < '2018-03-02 00'
    AND path like '%/email/orders%'
    AND json_extract_scalar(event_data,'$.event_type') = 'cancel_old_emails'
)  
GROUP BY ds, site, email_template;
