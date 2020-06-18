SELECT site,  platform,  component,  position,  campaign, prints, clicks, fecha
FROM 
    (
     SELECT fecha,  site,  platform,  component,  position,  campaign,
            SUM(IF(prints = 'print',1,0)) AS prints,
            SUM(IF(clicks = 'click',1,0)) AS clicks
     FROM 
         (
          SELECT
                 p_fecha     AS fecha, 
                 p_site      AS site, 
                 p_platform  AS platform, 
                 p_component AS component,
                 CASE 
                   WHEN (p_platform like '/mobile%' AND p_component like '/home/discovery%')   THEN (CAST(COALESCE(regexp_extract(p_component,'[0-9]+',0),0) AS INT) + 1)
                   WHEN (p_platform like '/mobile%' AND p_component like '/home/collection%')  THEN (CAST(COALESCE(regexp_extract(p_component,'[0-9]+',0),0) AS INT) + 1)
                   WHEN (p_platform like '/web%'    AND p_component like '/home/discovery-2%')      THEN (CAST(COALESCE(p_position,0) AS INT) + 2)
                   WHEN (p_platform like '/web%'    AND p_component like '/home/discovery-second%') THEN (CAST(COALESCE(p_position,0) AS INT) + 2)
                   WHEN p_position = '-1' THEN 1
                   ELSE CAST(COALESCE(p_position,1) AS INT)
                 END AS position,
                 CASE
                   WHEN p_campaign = '-1' THEN 'Not_set'
                   WHEN p_campaign = ''   THEN 'Not_set'
                   ELSE IF(regexp_extract(regexp_replace(regexp_replace(regexp_replace(regexp_replace(regexp_replace(p_campaign, '%2F','/'), '%2D','-'),'%3F','?'),'%3D','='),'%23','#'),'(.+)(#.+)',1) <> '', regexp_extract(regexp_replace(regexp_replace(regexp_replace(regexp_replace(regexp_replace(p_campaign, '%2F','/'), '%2D','-'),'%3F','?'),'%3D','='),'%23','#'),'(.+)(#.+)',1), p_campaign)
                 END AS campaign,
                 p_print     AS prints,
                 c_click     AS clicks
          FROM 
               (
                SELECT DataP.*, DataC.*
                FROM 
                     (  
                      SELECT p_fecha, p_site, p_platform, p_component, p_position, p_campaign, p_uid, p_print, count(*) as p_qRcd
                      FROM 
                           (  
                            SELECT 
                                 from_unixtime(unix_timestamp(ds,'yyyy-MM-dd HH') - 14400,'yyyy-MM-dd') AS p_fecha,
                                 site.site_id                                                           AS p_site,
                                 platform.platform                                                      AS p_platform,
                                 c_id.component                                                         AS p_component,
                                 COALESCE(c_e_ord.position,'-1')                                          AS p_position,
                                 COALESCE(c_campaign.campaign,'-1')                                       AS p_campaign,
                                 uid.uid                                                                AS p_uid,
                                 'print'                                                                AS p_print
                            FROM component_prints
                             LATERAL VIEW json_tuple(`data`,'event_data')                       evd             AS `event_data`
                             LATERAL VIEW json_tuple(`data`,'device')                           dev             AS `device`
                             LATERAL VIEW json_tuple(`data`,'application')                      app             AS `application`
                             LATERAL VIEW json_tuple(`data`,'user')                             usr             AS `user_data`
                             LATERAL VIEW json_tuple(`data`,'platform')                         plt             AS `plt`
                             LATERAL VIEW json_tuple(`plt`,'http')                              htp             AS `http`
                             LATERAL VIEW json_tuple(`http`,'intersection_observer_supported')  ios             AS `intersection_observer_supported`
                             LATERAL VIEW json_tuple(`application`,'site_id')                   site            AS `site_id`
                             LATERAL VIEW json_tuple(`device`,'platform')                       platform        AS `platform`
                             LATERAL VIEW json_tuple(`event_data`,'c_id')                       c_id            AS `component` 
                             LATERAL VIEW json_tuple(`event_data`,'c_element_order')            c_e_ord         AS `position` 
                             LATERAL VIEW json_tuple(`event_data`,'c_campaign')                 c_campaign      AS `campaign` 
                             LATERAL VIEW json_tuple(`user_data`,'uid')                         uid             AS `uid`
                            WHERE ds >= '@param01 04' AND ds < '@param02 04'
                              AND c_id.component IS NOT NULL
                              AND COALESCE(ios.intersection_observer_supported,'true') = 'true'
                           ) AS baseP
                      WHERE p_component IS NOT NULL
                        AND (
                             (p_platform = '/mobile/ios'
                          AND (p_component LIKE '/home/exhibitors/element'
                            OR p_component LIKE '/home/discovery-%/element'
                            OR p_component LIKE '/home/collection-items-%')
                             )
                         OR
                             (p_platform = '/mobile/android'
                          AND (p_component LIKE '/home/exhibitors/element'
                            OR p_component LIKE '/home/discovery-%'
                            OR p_component LIKE '/home/collection-items-%')
                             )
                         OR
                             (p_platform = '/web/mobile'
                          AND (p_component LIKE '/home/exhibitors-carousel/element'
                            OR p_component LIKE '/home/discovery-%/element'
                            OR p_component LIKE '/home/collections/item')
                             )
                         OR
                             (p_platform = '/web/desktop'
                          AND (p_component LIKE '/home/exhibitors-carousel/element'
                            OR p_component LIKE '/home/discovery-%/element'
                            OR p_component LIKE '/home/collections/item')
                             )
                            )
                      GROUP BY p_fecha, p_site, p_platform, p_component, p_position, p_campaign, p_uid, p_print
                     ) AS DataP
                LEFT JOIN 
                         (  
                          SELECT c_fecha, c_site, c_platform, c_component, c_position, c_campaign, c_uid, c_click, count(*) as c_qRcd
                          FROM 
                               ( 
                                SELECT
                                     from_unixtime(unix_timestamp(ds,'yyyy-MM-dd HH') - 0,'yyyy-MM-dd')                                   AS c_fecha,
                                     application.site_id                                                                                  AS c_site,
                                     device.platform                                                                                      AS c_platform,
                                     COALESCE(jest(others['fragment'],'c_id'),jest(platform.fragment,'c_id'))                             AS c_component,
                                     COALESCE(jest(others['fragment'],'c_element_order'),jest(platform.fragment,'c_element_order'),'-1')  AS c_position,
                                     COALESCE(jest(others['fragment'],'c_campaign'),jest(platform.fragment,'c_campaign'),'-1')            AS c_campaign,
                                     usr.uid                                                                                              AS c_uid,
                                     'click'                                                                                              AS c_click                    
                                FROM tracks 
                                WHERE ds >= '@param01' AND ds < '@param02'
                                  AND type = 'view'
                                  AND path <> '/recommendations'
                                  AND (
                                       (device.platform LIKE '/mobile/%') 
                                    OR (others['intersection_observer_supported'] = 'true') 
                                    OR (platform.http.intersection_observer_supported)
                                      )
                                  AND (
                                       (device.platform LIKE '/mobile/%')
                                    OR (platform.http.http_referer LIKE '%/www.mercadoli%')
                                      )
                                  AND COALESCE(jest(others['fragment'],'c_id'), jest(platform.fragment,'c_id')) is not null
                                  AND usr.uid IS NOT NULL
                               ) AS baseC
                          WHERE c_component IS NOT NULL
                            AND (
                                 (c_platform = '/mobile/ios'
                              AND (c_component LIKE '/home/exhibitors/element'
                                OR c_component LIKE '/home/discovery-%/element'
                                OR c_component LIKE '/home/collection-items-%')
                                 )
                             OR
                                 (c_platform = '/mobile/android'
                              AND (c_component LIKE '/home/exhibitors/element'
                                OR c_component LIKE '/home/discovery-%'
                                OR c_component LIKE '/home/collection-items-%')
                                 )
                             OR
                                 (c_platform = '/web/mobile'
                              AND (c_component LIKE '/home/exhibitors-carousel/element'
                                OR c_component LIKE '/home/discovery-%/element'
                                OR c_component LIKE '/home/collections/item')
                                 )
                             OR
                                 (c_platform = '/web/desktop'
                              AND (c_component LIKE '/home/exhibitors-carousel/element'
                                OR c_component LIKE '/home/discovery-%/element'
                                OR c_component LIKE '/home/collections/item')
                                 )
                                )
                          GROUP BY c_fecha, c_site, c_platform, c_component, c_position, c_campaign, c_uid, c_click
                         ) AS DataC
                 ON DataP.p_fecha     = DataC.c_fecha
                AND DataP.p_site      = DataC.c_site
                AND DataP.p_platform  = DataC.c_platform
                AND DataP.p_component = DataC.c_component
                AND DataP.p_uid       = DataC.c_uid
                AND DataP.p_position  = DataC.c_position
                AND DataP.p_campaign  = DataC.c_campaign
               ) AS pXc
         ) AS TpXc1
     GROUP BY fecha, site, platform, component, position, campaign
    ) AS FinalData