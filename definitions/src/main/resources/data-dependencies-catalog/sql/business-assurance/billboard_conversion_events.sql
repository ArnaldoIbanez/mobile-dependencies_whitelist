SELECT bb.site as Site, bb.business as Business, bb.vertical as Vertical, bb.plataforma as Plataforma, bb.item as Item, bb.path as Path, bb.is_new_billboard as Is_New_Billboard, bb.cantidad as Cant_bb, notbb.cantidad as Cant_notbb, bb.ds as ds FROM
(
  SELECT
    application.site_id as site,
    application.business AS business,
    jest(event_data, 'vertical') as vertical,
    device.platform as plataforma,
    jest(event_data,'item_id') as item, 
    path as path,
    (CASE WHEN jest(event_data, 'vertical') IN ('REAL_ESTATE', 'real_estate', 'realEstate', 'RE')
      THEN jest(event_data, 'domain_id') like '%DEVELOPMENT%'
     WHEN jest(event_data, 'vertical') IN ('MOTOR', 'MOTORCYCLE', 'motors')
       THEN jest(event_data, 'item_condition') = 'new'
     END) as is_new_billboard,
    count(distinct (concat(usr.uid,'-',jest(event_data,'item_id')))) as cantidad,
    count(*) as cantidad_total_bb,
    substr(ds,1,10) as ds
  FROM TRACKS
  WHERE
    jest(event_data, 'vertical') IN ('REAL_ESTATE', 'real_estate', 'realEstate', 'RE', 'MOTOR', 'MOTORCYCLE', 'motors', 'SERVICE', 'services')
    AND others['fragment'] LIKE '%BB:%'
    AND path IN ('/vip','/vip/show_phone', '/vip/call_seller', '/vip/contact_seller', '/quotation/congrats', '/quotation/show_price', '/checkout/congrats')
    AND device.platform LIKE '/web%'
    AND application.site_id IN ('MCO', 'MLA', 'MLB', 'MLC', 'MLM', 'MLU', 'MLV')
    AND ds >= '@param01' and ds < '@param02'
  GROUP BY
    application.site_id,
    application.business,
    jest(event_data, 'vertical'),
    device.platform,
    jest(event_data,'item_id'),
    path,
    (CASE WHEN jest(event_data, 'vertical') IN ('REAL_ESTATE', 'real_estate', 'realEstate', 'RE')
      THEN jest(event_data, 'domain_id') like '%DEVELOPMENT%'
     WHEN jest(event_data, 'vertical') IN ('MOTOR', 'MOTORCYCLE', 'motors')
       THEN jest(event_data, 'item_condition') = 'new'
     END),
    substr(ds,1,10)
) AS bb
LEFT JOIN
(
  SELECT
    application.site_id as site,
    application.business AS business,
    jest(event_data, 'vertical') as vertical,
    device.platform as plataforma,
    jest(event_data,'item_id') as item, 
    path as path,
    count(distinct (concat(usr.uid,'-',jest(event_data,'item_id')))) as cantidad,
    count(*) as cantidad_total_search,
    substr(ds,1,10) as ds
  FROM TRACKS
  WHERE
    jest(event_data, 'vertical') IN ('REAL_ESTATE', 'real_estate', 'realEstate', 'RE', 'MOTOR', 'MOTORCYCLE', 'motors', 'SERVICE', 'services')
    AND path IN ('/vip','/vip/show_phone', '/vip/call_seller', '/vip/contact_seller', '/quotation/congrats', '/quotation/show_price', '/checkout/congrats')
    AND device.platform LIKE '/web%'
    AND application.site_id IN ('MCO', 'MLA', 'MLB', 'MLC', 'MLM', 'MLU', 'MLV')
    AND ds >= '@param01' and ds < '@param02'
  GROUP BY
    application.site_id,
    application.business,
    jest(event_data, 'vertical'),
    device.platform,
    jest(event_data,'item_id'), 
    path,
    substr(ds,1,10)
) AS notbb
ON bb.ds = notbb.ds 
AND bb.item = notbb.item 
AND bb.site = notbb.site
AND bb.business = notbb.business 
AND bb.vertical = notbb.vertical
AND bb.plataforma = notbb.plataforma
AND bb.path = notbb.path