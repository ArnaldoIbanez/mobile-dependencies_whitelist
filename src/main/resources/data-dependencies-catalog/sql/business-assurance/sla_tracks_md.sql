SELECT datos.fecha                                                                                         AS fecha,
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
       SELECT fecha, section_path, platformType, platform, version, type, path, total_tracks, valid_tracks, invalid_tracks
       FROM (
             SELECT subQueryTracks.fechaTracks         AS fecha,
                    subQueryTracks.section_path        AS section_path,
                    subQueryTracks.platformType        AS platformType,
                    subQueryTracks.platformTracks      AS platform,
                    subQueryTracks.versionTracks       AS version,
                    subQueryTracks.typeTracks          AS type,
                    subQueryTracks.pathTracks          AS path,
                    SUM(subQueryTracks.total_tracks)   AS total_tracks,
                    SUM(subQueryTracks.valid_tracks)   AS valid_tracks,
                    SUM(subQueryTracks.invalid_tracks) AS invalid_tracks
             FROM (
                   SELECT substr(ds, 1, 10)                                           AS fechaTracks,
                          regexp_extract(path,'^(\/.*?)(\/|$)',1)                     AS section_path,
                          application.business                                        AS businessTracks,  
                          IF(device.platform like '/web%', 'WEB', 'APP')              as platformType,
                          device.platform                                             AS platformTracks, 
                          IF(device.platform like '/web%', null, application.version) AS versionTracks,
                          type                                                        AS typeTracks,
                          path                                                        AS pathTracks,
                          COUNT(1)                                                    AS total_tracks, 
                          SUM(IF(catalog_data.is_valid = TRUE,1,0))                   AS valid_tracks,
                          SUM(IF(catalog_data.is_valid = FALSE,1,0))                  AS invalid_tracks 
                   FROM tracks
                   WHERE ds >= '@param01'
                     AND ds  < '@param02'
                     AND NOT is_bot(device.user_agent)
                     AND (not (application.server_poolname rlike 'checkout-on.+') OR application.server_poolname is null)
                   GROUP BY substr(ds, 1, 10), 
                            regexp_extract(path,'^(\/.*?)(\/|$)',1), 
                            application.business, 
                            device.platform, 
                            IF(device.platform like '/web%', NULL, application.version),
                            type,
                            path
                   ) subQueryTracks  
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
                                                (application.business = 'mercadolibre'  AND device.platform = '/mobile/android')                                       
                                             OR (application.business = 'mercadolibre'  AND device.platform = '/mobile/ios')                                           
                                             OR (application.business = 'mercadopago'   AND device.platform = '/mobile/android')                                       
                                             OR (application.business = 'mercadopago'   AND device.platform = '/mobile/ios')                                           
                                             OR (application.business = 'mercadoenvios' AND device.platform = '/mobile/android' AND NOT application.app_id = 'WMS_APP')
                                            )
                                      GROUP BY application.business, device.platform, application.version 
                                     ) subQueryVersions1
                                WHERE percentage >= 20
                               ) subQueryVersions2
                         ) subQueryVersions3
                    WHERE rnk = 1
                   ) versions ON versions.business = subQueryTracks.businessTracks AND versions.platform = subQueryTracks.platformTracks AND versions.version  = subQueryTracks.versionTracks 
             WHERE (subQueryTracks.platformTracks like '/web%'  OR versions.version IS NOT NULL)
             GROUP BY subQueryTracks.fechaTracks, subQueryTracks.section_path, subQueryTracks.platformType, subQueryTracks.platformTracks, subQueryTracks.versionTracks, subQueryTracks.typeTracks, subQueryTracks.pathTracks
            ) subQueryDatos1
      ) datos
      LEFT JOIN (SELECT jest(data,'Iniciativa') AS iniciative, jest(data,'Section') AS section, jest(data,'PlatformType') AS platformType
                 FROM external_data 
                 WHERE usr = 'amaciel' 
                   AND tb = 'map_project_initiative') iniciatives ON datos.section_path = iniciatives.section
     ) 
WHERE (iniciatives.platformType is NULL OR iniciatives.platformType = '*ALL' OR iniciatives.platformType = datos.platformType)
GROUP BY datos.fecha, IF(iniciatives.iniciative IS NULL, 'SIN DATOS EN EL MAPEO PARA EL SECTION', iniciatives.iniciative), datos.section_path, datos.platform, datos.version, datos.type, datos.path
