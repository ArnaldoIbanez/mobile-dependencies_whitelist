SELECT 
  ds,
  site_id,
  email_template,
  ROUND((open_quantity * 100.0) / sent_quantity, 2) as percentage
FROM 
(
  SELECT emails_send2.ds as ds,
    emails_send2.site as site_id,
    emails_send2.email_template as email_template,
    COUNT(*) as sent_quantity,
    SUM(CASE 
      WHEN emails_open2.email_template is null THEN 0 
      ELSE 1 
    END) as open_quantity
  FROM 
    (SELECT
      substr(ds,1,10) as ds,
      application.site_id as site,
      jest(event_data,'order_id') as order_id,
      jest(event_data,'email_template') as email_template
    FROM 
      tracks 
    WHERE 
      ds >= '@param01'
      AND ds < '@param02'
      AND path = '/email/orders'
      AND jest(event_data,'event_type') = 'send'
    ) as emails_send2
    LEFT JOIN
    (SELECT
      emails_open.ds,
      emails_open.site,
      emails_open.email_template,
      emails_open.order_id
    FROM
      (SELECT
        substr(ds,1,10) as ds,
        application.site_id as site,
        jest(event_data,'order_id') as order_id,
        jest(event_data,'email_template') as email_template
      FROM 
        tracks 
      WHERE 
        ds >= '@param01'
        AND ds < '@param02'
        AND path = '/email/orders'
        AND jest(event_data,'event_type') = 'open'
      ) as emails_open,
      (SELECT
        substr(ds,1,10) as ds,
        application.site_id as site,
        jest(event_data,'order_id') as order_id,
        jest(event_data,'email_template') as email_template
      FROM 
        tracks 
      WHERE 
        ds >= '@param01'
        AND ds < '@param02'
        AND path = '/email/orders'
        AND jest(event_data,'event_type') = 'send'
      ) as emails_send
    WHERE emails_open.order_id = emails_send.order_id
    AND emails_open.email_template = emails_send.email_template
    ) as emails_open2
  ON emails_send2.order_id = emails_open2.order_id
  GROUP BY emails_send2.ds,
    emails_send2.site,
    emails_send2.email_template
);  
