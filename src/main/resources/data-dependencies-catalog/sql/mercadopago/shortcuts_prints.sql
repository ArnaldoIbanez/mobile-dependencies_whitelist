SELECT 
    device.platform AS platform,
    application.version as version,
    application.site_id AS site_id,
    component,
    fromto,
    position,
    count(distinct `user`.`uid`) as Usuarios,
    count(`user`.`uid`) as Impressions,
    substr(ds,1,10) as ds
FROM default.component_prints_parquet
lateral view posexplode(json_to_array(jet(event_data, 'shortcuts.component_id'))) pn as pos_component, component
lateral view posexplode(json_to_array(jet(event_data, 'shortcuts.from'))) pn as pos_from, fromto
lateral view posexplode(json_to_array(jet(event_data, 'shortcuts.position'))) pn as pos_position, position
WHERE ds >= '@param01'
AND   ds < '@param02'
    AND type='view'
      AND application.business = 'mercadopago'
      AND application.site_id IN ('MLA','MLB','MLC','MLM','MCO','MLU','MPE')
      AND path = '/wallet_home/print'
      AND pos_component == pos_position
GROUP BY substr(ds,1,10), device.platform, application.site_id,component,
fromto,position,
application.version