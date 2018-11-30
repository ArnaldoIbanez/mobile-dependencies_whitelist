SELECT fecha,
       IF(iniciatives.iniciative IS NULL, 'SIN DATOS EN EL MAPEO PARA EL SECTION', iniciatives.iniciative) AS iniciativa, 
       datos.section_path                                                                                  AS section,
       datos.platform                                                                                      AS platform,
       datos.version                                                                                       AS version,
       datos.type                                                                                          AS type,
       datos.path                                                                                          AS path,
       SUM(datos.total_tracks)                                                                             AS totalTracks,
       SUM(datos.valid_tracks)                                                                             AS validTracks, 
       SUM(datos.invalid_tracks)                                                                           AS invalidTracks 
FROM (
      (
       SELECT *
       FROM (
             SELECT substr(ds, 1, 10)                                           AS fecha,
                    regexp_extract(path,'^(\/.*?)(\/|$)',1)                     AS section_path, 
                    device.platform                                             AS platform, 
                    IF(device.platform like '/web%', null, application.version) AS version,
                    type                                                        AS type,
                    path                                                        AS path,
                    COUNT(1)                                                    AS total_tracks, 
                    SUM(IF(catalog_data.is_valid = TRUE,1,0))                   AS valid_tracks,
                    SUM(IF(catalog_data.is_valid = FALSE,1,0))                  AS invalid_tracks 
             FROM tracks
             LEFT JOIN
             (
              SELECT DISTINCT business, platform, version
              FROM (
                    SELECT business, platform, version, percentage, rank() OVER (PARTITION BY business, platform ORDER BY version DESC) AS rnk
                    FROM (
                          SELECT business, platform, version, percentage
                          FROM (
                                SELECT application.business                                                                         AS business,
                                       device.platform                                                                              AS platform,
                                       application.version                                                                          As version,
                                       (count(*) * 100.0) / sum(count(*)) OVER (PARTITION BY application.business, device.platform) AS percentage
                                FROM tracks
                                WHERE ds >= '@param01'
                                  AND ds  < '@param02'
                                  AND NOT is_bot(device.user_agent)
                                  AND (
                                          (application.business = 'mercadolibre'  AND device.platform = '/mobile/android')                                        --ML Android
                                       OR (application.business = 'mercadolibre'  AND device.platform = '/mobile/ios')                                            --ML iOS
                                       OR (application.business = 'mercadopago'   AND device.platform = '/mobile/android')                                        --Wallet Android
                                       OR (application.business = 'mercadopago'   AND device.platform = '/mobile/ios')                                            --Wallet iOS
                                       OR (application.business = 'mercadoenvios' AND device.platform = '/mobile/android' AND NOT application.app_id = 'WMS_APP') --Flex Android
                                     --OR (application.business = 'mercadoenvios' AND device.platform = '/mobile/android' AND application.app_id = 'WMS_APP')     --Warehouses Android
                                      )
                                GROUP BY application.business, device.platform, application.version 
--                                ORDER BY application.business ASC, device.platform ASC, application.version DESC, percentage DESC
                               ) subQueryVersions1
                          WHERE percentage >= 20 --Threshold de Porcentaje para tener en cuenta las versiones mas usadas
                         ) subQueryVersions2
                   ) subQueryVersions3
              WHERE rnk = 1 --Tomamos la version mas nueva de las que cumplen con el porcentaje
             ) versions ON versions.business = application.business AND versions.platform = device.platform AND versions.version = application.version
             WHERE ds >= '@param01'
               AND ds  < '@param02'
               AND NOT is_bot(device.user_agent)
               AND ((device.platform LIKE '/web%' AND (not (application.server_poolname rlike 'checkout-on.+') OR application.server_poolname is null))
                 OR (versions.version IS NOT NULL AND application.version = versions.version))
             GROUP BY substr(ds, 1, 10), regexp_extract(path,'^(\/.*?)(\/|$)',1), device.platform, if(device.platform like '/web%', null, application.version), type, path
            ) subQueryDatos1
      ) datos
      LEFT JOIN (SELECT jest(data,'Iniciativa') AS iniciative, jest(data,'Section') AS section
                 FROM external_data 
                 WHERE usr = 'nalaimo' 
                   AND tb = 'map_project_initiative') iniciatives ON datos.section_path = iniciatives.section
     )
GROUP BY fecha, iniciatives.iniciative, datos.section_path, datos.platform, datos.version, datos.type, datos.path     
--ORDER BY totalTracks DESC