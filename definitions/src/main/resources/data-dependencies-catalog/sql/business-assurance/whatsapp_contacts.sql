WITH
  views AS (
  	SELECT
  	substr(ds,1,10) as ds, 
  	application.site_id as site, 
  	application.business AS business,
  	jest(event_data,'seller_id') as seller_id,
  	jest(event_data,'listing_type_id') as listing_type_id,
  	jest(event_data,'item_id') as item_id,
  	jest(event_data,'item_condition') as item_condition ,
  	count(1) as vips_whit_whatsapp 
  	FROM tracks 
  	WHERE 
  	ds >= '@param01'
  	AND ds < '@param02'
  	AND path IN ('/vip')
  	AND application.site_id IN ('MLA')
  	AND device.platform IN ('/web/mobile', '/web/mobile/static')
  	AND jest(event_data,'whatsapp_available') = 'true'
  	GROUP BY ( 
  	substr(ds,1,10), 
  	application.site_id, 
  	application.business,
  	jest(event_data,'seller_id'),
  	jest(event_data,'listing_type_id'),
  	jest(event_data,'item_id'),
  	jest(event_data,'item_condition')
  	)
  	),
  contacts AS (
  	SELECT 
  	substr(ds,1,10) as ds, 
  	jest(event_data,'item_id') as item_id,
  	count(1) as whatsapp_contact
  	FROM tracks
  	WHERE
  	ds >= '@param01'
  	AND ds < '@param02'
  	AND path IN ('/vip/contact_whatsapp')
  	AND application.site_id IN ('MLA')
  	AND device.platform IN ('/web/mobile', '/web/mobile/static')
  	AND jest(event_data,'whatsapp_available') = 'true'
  	GROUP BY ( 
  	substr(ds,1,10), 
  	jest(event_data,'item_id')
  	))
SELECT
views.*,
contacts.whatsapp_contact
FROM views
LEFT JOIN contacts ON views.ds = contacts.ds and views.item_id = contacts.item_id;