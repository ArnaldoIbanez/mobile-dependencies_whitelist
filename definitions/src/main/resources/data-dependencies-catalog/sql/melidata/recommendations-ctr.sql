SELECT
  t1.ds as ds,
  t1.platform AS platform,
  t1.site_id AS site_id,
  t1.backend AS backend,
  t1.client AS client,
  t1.prints AS prints,
  IF(t2.clicks IS NULL, 0, t2.clicks) AS clicks
FROM(SELECT
         ds,
         platform,
         site_id,
         backend,
         client,
         COUNT(distinct(id)) AS prints
FROM(SELECT
        id,
        substr(ds,1,10) AS ds,
        platform_level(device.platform,2) AS platform,
        application.site_id AS site_id,
        IF(v2.algorithm IS NULL, v2.backend_id, v2.algorithm) AS backend,
        IF(v2.client IS NULL, v2.context, v2.client) AS client
    FROM tracks
    LATERAL VIEW json_tuple(event_data,'recommendations') v1 AS recommendations
    LATERAL VIEW json_tuple(v1.recommendations,'track_info', 'hidden_by_client', 'backend_id', 'client', 'algorithm', 'context' ) v2 AS track_info, hidden_by_client, backend_id, client, algorithm, context
    WHERE
        v2.track_info IS NOT NULL
        AND cast(get_json_object(v2.track_info,'$.has_recommendations') as varchar(50)) = 'true'
        AND CAST(v2.hidden_by_client as varchar(50)) = 'false'
        AND (v2.algorithm is not null or v2.backend_id is not null)
        AND (v2.context is not null or v2.client is not null)
        AND ds >= '@param01 02' AND ds < '@param02 02') a
GROUP BY a.ds,
         a.platform,
         a.site_id,
         a.backend,
         a.client
) t1
LEFT JOIN
(
    SELECT
        substr(ds,1,10) AS ds,
        platform_level(device.platform,2) AS platform,
        application.site_id AS site_id,
        reco_backend AS backend,
        reco_client AS client,
        COUNT(DISTINCT usr.uid, item_id) AS clicks
    FROM tracks
    LATERAL VIEW json_tuple(others['fragment'],'reco_client', 'reco_backend') v1 AS reco_client, reco_backend
    LATERAL VIEW json_tuple(event_data,'item_id')v2 AS item_id
    WHERE
        path = '/vip'
        AND v1.reco_client IS NOT NULL
        AND ds >= '@param01 02' AND ds < '@param02 02'
    GROUP BY
        substr(ds,1,10),
        platform_level(device.platform,2),
        application.site_id,
        v1.reco_backend,
        v1.reco_client
) t2
ON
  t1.ds = t2.ds
  AND t1.platform = t2.platform
  AND t1.site_id = t2.site_id
  AND t1.backend = t2.backend
  AND t1.client = t2.client
