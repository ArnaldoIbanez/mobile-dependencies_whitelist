SELECT
   t1.platform AS platform,
   t1.site_id AS site_id,
   t1.backend AS backend,
   t1.client AS client,
   t1.prints AS prints,
   IF(t2.clicks IS NULL, 0, t2.clicks) AS clicks
FROM
(
  SELECT
       device.platform AS platform,
       application.site_id,
       get_json_object(recommendations,'$.algorithm') AS backend,
       get_json_object(recommendations,'$.context') AS client,
       COUNT(distinct(id)) AS prints
   FROM tracks
   LATERAL VIEW json_tuple(event_data,'recommendations') v1 AS recommendations
   WHERE
        recommendations IS NOT NULL
        AND CAST(get_json_object(
             event_data,'$.recommendations.success_print') AS varchar(50))= "true"        
        AND get_json_object(recommendations,'$.algorithm') IS NOT NULL
        AND get_json_object(recommendations,'$.context') IS NOT NULL
        AND ds >= '@param01' AND ds < '@param02'
    GROUP BY
      device.platform,
        application.site_id,
        get_json_object(recommendations,'$.algorithm'),
        get_json_object(recommendations,'$.context')
) t1
LEFT JOIN
(
    SELECT
        device.platform AS platform,
        application.site_id AS site_id,
        reco_backend AS backend,
        reco_client AS client,
        COUNT(distinct usr.uid, item_id) AS clicks
    FROM tracks
    LATERAL VIEW json_tuple(others['fragment'],'reco_client') v1 AS reco_client
    LATERAL VIEW json_tuple(others['fragment'],'reco_backend') v2 AS reco_backend
    LATERAL VIEW json_tuple(event_data,'item_id')z AS item_id
    WHERE
        path = '/vip'
        AND reco_client IS NOT NULL
        AND ds >= '@param01' AND ds < '@param02'
    GROUP BY
        device.platform,
        application.site_id,
        reco_backend,
        reco_client
) t2
ON
 t1.platform = t2.platform
 AND t1.site_id = t2.site_id
 AND t1.backend = t2.backend
 AND t1.client = t2.client