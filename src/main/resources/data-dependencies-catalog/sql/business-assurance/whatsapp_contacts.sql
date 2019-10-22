SELECT views.site,
       views.business,
       views.vertical,
       views.platform,
       views.seller_id,
       views.item_id,
       views.listing_type_id,
       views.item_condition,
       views.vips_whit_whatsapp,
       contacts.whatsapp_contact,
       views.ds
FROM (SELECT application.site_id AS site,
             application.business AS business,
             device.platform,
             jest(event_data,'seller_id') AS seller_id,
             jest(event_data,'item_id') AS item_id,
             jest(event_data,'vertical') AS vertical,
             jest(event_data,'listing_type_id') AS listing_type_id,
             jest(event_data,'item_condition') AS item_condition,
             COUNT(1) AS vips_whit_whatsapp,
             substr(ds,1,10) AS ds
      FROM tracks
      WHERE ds >= '@param01'
      AND   ds < '@param02'
      AND   path IN ('/vip')
      AND   application.site_id IN ('MLA')
      AND   device.platform IN ('/web/mobile','/web/mobile/static')
      AND   jest(event_data,'whatsapp_available') = 'true'
      GROUP BY 
      substr (ds,1,10),application.site_id,application.business,jest(event_data,'vertical'),device.platform,jest (event_data,'seller_id'),jest (event_data,'listing_type_id'),jest (event_data,'item_id'),jest (event_data,'item_condition')) views
  LEFT JOIN (SELECT substr(ds,1,10) AS ds,
                    jest(event_data,'item_id') AS item_id,
                    COUNT(1) AS whatsapp_contact
             FROM tracks
             WHERE ds >= '@param01'
             AND   ds < '@param02'
             AND   path IN ('/vip/contact_whatsapp')
             AND   application.site_id IN ('MLA')
             AND   device.platform IN ('/web/mobile','/web/mobile/static')
             AND   jest(event_data,'whatsapp_available') = 'true'
             GROUP BY (jest (event_data,'item_id')),
                      substr(ds,1,10)) contacts
         ON views.ds = contacts.ds
        AND views.item_id = contacts.item_id

