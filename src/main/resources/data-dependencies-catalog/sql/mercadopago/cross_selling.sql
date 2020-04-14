SELECT 
    device.platform AS platform,
    application.site_id AS site_id,application.version as version,
    content_id,
    position,
    audience,
    count(distinct `user`.`uid`) as Usuarios,
    count(`user`.`uid`) as Impressions,
    substr(ds,1,10) as ds
FROM default.component_prints_parquet
lateral view posexplode(json_to_array(jet(event_data, 'cross_selling.content_id'))) pn as pos_content, content_id
lateral view posexplode(json_to_array(jet(event_data, 'cross_selling.position'))) pn as pos_posit, position 
lateral view posexplode(json_to_array(jet(event_data, 'cross_selling.audience'))) pn as pos_audience, audience 
WHERE ds >= '@param01'
AND   ds < '@param02'
AND pos_content == pos_posit
AND pos_content == pos_audience
    AND type='view'
      AND application.site_id IN ('MLA','MLB','MLM','MLC','MCO','MLU','MPE')
      AND application.business = 'mercadopago'
      AND path = '/wallet_home/print'
GROUP BY substr(ds,1,10), device.platform, application.site_id,application.version,content_id,audience,
position