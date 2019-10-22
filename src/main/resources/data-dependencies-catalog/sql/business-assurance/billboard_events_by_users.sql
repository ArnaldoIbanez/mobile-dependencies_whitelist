SELECT 
    substr(ds,1,10) as Fecha, 
    application.site_id as Site,
    application.business AS Business,
    jest(event_data, 'vertical') as Vertical,
    device.platform as Plataforma,
    jest(event_data,'item_id') as Item, 
    path as Path,
    usr.uid as Uid,
    usr.user_id as User_id,
    usr.user_nick as User_nick,
    count(distinct (concat(usr.uid,'-',jest(event_data,'item_id')))) as Cantidad,
    count(*) as Cantidad_total_bb
  FROM TRACKS
  WHERE
    jest(event_data, 'vertical') IN ('REAL_ESTATE', 'real_estate', 'realEstate', 'RE', 'MOTOR', 'MOTORCYCLE', 'motors', 'SERVICE', 'services')
    AND others['fragment'] LIKE '%BB:%'
    AND path IN ('/vip/show_phone', '/vip/call_seller', '/vip/contact_seller', '/quotation/congrats', '/quotation/show_price', '/checkout/congrats')
    AND device.platform LIKE '/web%'
    AND application.site_id IN ('MCO', 'MLA', 'MLB', 'MLC', 'MLM', 'MLU', 'MLV')
    AND ds >= '@param01' and ds < '@param02'
  GROUP BY substr(ds,1,10),
    application.site_id,
    application.business,
    jest(event_data, 'vertical'),
    device.platform,
    jest(event_data,'item_id'),
    path,
    usr.uid,
    usr.user_id,
    usr.user_nick