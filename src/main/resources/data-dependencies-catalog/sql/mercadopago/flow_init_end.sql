SELECT  MP_FLOW_INIT.user_id as usuario, SUM(FLOW_INIT) AS FLOW_INIT, SUM(FLOW_END) AS FLOW_END,  MP_FLOW_INIT.platform as platform, 
MP_FLOW_INIT.site as site, MP_FLOW_INIT.version as version , MP_FLOW_INIT.flow_name as flow, MP_FLOW_INIT.fecha as fecha 
FROM (
    SELECT substr(ds, 1,10) as fecha,count(distinct usr.user_id) AS FLOW_INIT,  usr.user_id AS user_id, device.platform AS platform, application.site_id AS site,
    application.version AS version, jest(event_data, 'flow_name') as flow_name
    FROM tracks 
WHERE ds >= '@param01'
AND   ds < '@param02'
          AND type = 'event' 
          AND application.business = 'mercadopago' 
          AND application.version >= '2.109.%'
          AND path = '/flow/init'
          AND application.site_id IN ('MLA','MLB','MLC','MLM','MCO','MLU','MPE')
    GROUP BY substr(ds, 1,10), usr.user_id, device.platform, application.site_id, application.version, jest(event_data, 'flow_name') 
) AS MP_FLOW_INIT LEFT JOIN (
    SELECT substr(ds, 1,10) as fecha,count(distinct usr.user_id) AS FLOW_END, usr.user_id AS user_id, device.platform AS platform, application.site_id AS site, application.version AS version,  jest(event_data, 'flow_name') as flow_name
    FROM tracks 
WHERE ds >= '@param01'
AND   ds < '@param02'
          AND type = 'event' 
          AND application.business = 'mercadopago'
          AND application.version  >= '2.109.%'
          AND path = '/flow/end'
          AND application.site_id IN ('MLA','MLB','MLC','MLM','MCO','MLU','MPE')
    GROUP BY substr(ds, 1,10),usr.user_id, device.platform, application.site_id, application.version, jest(event_data, 'flow_name') 
) AS MP_FLOW_END
ON MP_FLOW_INIT.user_id = MP_FLOW_END.user_id
  AND MP_FLOW_INIT.fecha = MP_FLOW_END.fecha
  AND MP_FLOW_INIT.flow_name = MP_FLOW_END.flow_name
  GROUP BY MP_FLOW_INIT.fecha ,MP_FLOW_INIT.user_id, MP_FLOW_INIT.platform, MP_FLOW_INIT.site, MP_FLOW_INIT.version, MP_FLOW_INIT.flow_name