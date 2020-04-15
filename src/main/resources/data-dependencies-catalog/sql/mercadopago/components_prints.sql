SELECT 
    device.platform AS platform,
    application.site_id AS site_id,application.version as version,
    component,
    count(distinct `user`.`uid`) as Usuarios,
    count(`user`.`uid`) as Impressions,
    substr(ds,1,10) as ds
FROM default.component_prints_parquet
lateral view explode(json_to_array(jet(event_data, 'banking.component_id'))) tf as component
WHERE ds >= '@param01'
AND   ds < '@param02'
    AND type IN ('view','event')
      AND application.business = 'mercadopago'
      AND application.site_id IN ('MLA','MLB','MLM','MLC','MCO','MLU','MPE')
      AND path = '/wallet_home/print'
GROUP BY substr(ds,1,10), device.platform, application.site_id,application.version,component
UNION ALL
SELECT 
    device.platform AS platform,
    application.site_id AS site_id,application.version as version,
    component,
    count(distinct `user`.`uid`) as Usuarios,
    count(`user`.`uid`) as Impressions,
    substr(ds,1,10) as ds
FROM default.component_prints_parquet
lateral view explode(json_to_array(jet(event_data, 'main_actions.component_id'))) tf as component
WHERE ds >= '@param01'
AND   ds < '@param02'
    AND type IN ('view','event')
      AND application.business = 'mercadopago'
      AND application.site_id IN ('MLA','MLB','MLM','MLC','MCO','MLU','MPE')
      AND path = '/wallet_home/print'
GROUP BY substr(ds,1,10), device.platform, application.site_id,application.version,component
UNION ALL
SELECT 
    device.platform AS platform,
    application.site_id AS site_id,application.version as version,
    component,
    count(distinct `user`.`uid`) as Usuarios,
    count(`user`.`uid`) as Impressions,
    substr(ds,1,10) as ds
FROM default.component_prints_parquet
lateral view explode(json_to_array(jet(event_data, 'secondary_actions.component_id'))) tf as component
WHERE ds >= '@param01'
AND   ds < '@param02'
    AND type IN ('view','event')
      AND application.site_id IN ('MLA','MLB','MLM','MLC','MCO','MLU','MPE')
      AND application.business = 'mercadopago'
      AND path = '/wallet_home/print'
GROUP BY substr(ds,1,10), device.platform, application.site_id,application.version,component
UNION ALL
SELECT 
    device.platform AS platform,
    application.site_id AS site_id,application.version as version,
    component,
    count(distinct `user`.`uid`) as Usuarios,
    count(`user`.`uid`) as Impressions,
    substr(ds,1,10) as ds
FROM default.component_prints_parquet
lateral view explode(json_to_array(jet(event_data, 'discount_center.component_id'))) tf as component
WHERE ds >= '@param01'
AND   ds < '@param02'
    AND type IN ('view','event')
      AND application.site_id IN ('MLA','MLB','MLM','MLC','MCO','MLU','MPE')
      AND application.business = 'mercadopago'
      AND path = '/wallet_home/print'
GROUP BY substr(ds,1,10), device.platform, application.site_id,application.version,component
UNION ALL
SELECT 
    device.platform AS platform,
    application.site_id AS site_id,application.version as version,
    component,
    count(distinct `user`.`uid`) as Usuarios,
    count(`user`.`uid`) as Impressions,
    substr(ds,1,10) as ds
FROM default.component_prints_parquet
lateral view explode(json_to_array(jet(event_data, 'qr_map.component_id'))) tf as component
WHERE ds >= '@param01'
AND   ds < '@param02'
    AND type IN ('view','event')
      AND application.site_id IN ('MLA','MLB','MLM','MLC','MCO','MLU','MPE')
      AND application.business = 'mercadopago'
      AND path = '/wallet_home/print'
GROUP BY substr(ds,1,10), device.platform, application.site_id,application.version,component
UNION ALL
SELECT 
    device.platform AS platform,
    application.site_id AS site_id,application.version as version,
    component,
    count(distinct `user`.`uid`) as Usuarios,
    count(`user`.`uid`) as Impressions,
    substr(ds,1,10) as ds
FROM default.component_prints_parquet
lateral view explode(json_to_array(jet(event_data, 'cross_selling.component_id'))) tf as component
WHERE ds >= '@param01'
AND   ds < '@param02'
    AND type IN ('view','event')
      AND application.site_id IN ('MLA','MLB','MLM','MLC','MCO','MLU','MPE')
      AND application.business = 'mercadopago'
      AND path = '/wallet_home/print'
GROUP BY substr(ds,1,10), device.platform, application.site_id,application.version,component
UNION ALL
SELECT 
    device.platform AS platform,
    application.site_id AS site_id,application.version as version,
    component,
    count(distinct `user`.`uid`) as Usuarios,
    count(`user`.`uid`) as Impressions,
    substr(ds,1,10) as ds
FROM default.component_prints_parquet
lateral view explode(json_to_array(jet(event_data, 'benefits.component_id'))) tf as component
WHERE ds >= '@param01'
AND   ds < '@param02'
    AND type IN ('view','event')
      AND application.site_id IN ('MLA','MLB','MLM','MLC','MCO','MLU','MPE')
      AND application.business = 'mercadopago'
      AND path = '/wallet_home/print'
GROUP BY substr(ds,1,10), device.platform, application.site_id,application.version,component
UNION ALL
SELECT 
    device.platform AS platform,
    application.site_id AS site_id,application.version as version,
    component,
    count(distinct `user`.`uid`) as Usuarios,
    count(`user`.`uid`) as Impressions,
    substr(ds,1,10) as ds
FROM default.component_prints_parquet
lateral view explode(json_to_array(jet(event_data, 'loyalty.component_id'))) tf as component
WHERE ds >= '@param01'
AND   ds < '@param02'
    AND type IN ('view','event')
      AND application.site_id IN ('MLA','MLB','MLM','MLC','MCO','MLU','MPE')
      AND application.business = 'mercadopago'
      AND path = '/wallet_home/print'
GROUP BY substr(ds,1,10), device.platform, application.site_id,application.version,component
UNION ALL
SELECT 
    device.platform AS platform,
    application.site_id AS site_id,application.version as version,
    component,
    count(distinct `user`.`uid`) as Usuarios,
    count(`user`.`uid`) as Impressions,
    substr(ds,1,10) as ds
FROM default.component_prints_parquet
lateral view explode(json_to_array(jet(event_data, 'activities.component_id'))) tf as component
WHERE ds >= '@param01'
AND   ds < '@param02'
    AND type IN ('view','event')
      AND application.site_id IN ('MLA','MLB','MLM','MLC','MCO','MLU','MPE')
      AND application.business = 'mercadopago'
      AND path = '/wallet_home/print'
GROUP BY substr(ds,1,10), device.platform, application.site_id,application.version,component

