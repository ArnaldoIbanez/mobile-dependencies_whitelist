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
    AND type='view'
      AND application.site_id IN ('MLA','MLB','MLM','MLC','MCO','MLU','MPE')
      AND application.business = 'mercadopago'
      AND path = '/wallet_home/print'
GROUP BY substr(ds,1,10), device.platform, application.site_id,application.version,content_id,audience,
position
UNION ALL
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
lateral view posexplode(json_to_array(jet(event_data, 'shortcuts.component_id'))) pn as pos_component, content_id
lateral view posexplode(json_to_array(jet(event_data, 'shortcuts.position'))) pn as pos_position, position
lateral view posexplode(json_to_array(jet(event_data, 'shortcuts.from'))) pn as pos_from, audience
WHERE ds >= '@param01'
AND   ds < '@param02'
    AND type='view'
      AND application.business = 'mercadopago'
      AND application.site_id IN ('MLA','MLB','MLM','MLC','MCO','MLU','MPE')
      AND path = '/wallet_home/print'
      AND pos_component == pos_position
GROUP BY substr(ds,1,10), device.platform, application.site_id,application.version,content_id,audience,
position