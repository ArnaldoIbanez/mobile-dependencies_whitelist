SELECT
    ds,
    platform,
    site_id,
    backend,
    client,
    count(id) AS calls
FROM(SELECT
        id,
        substr(ds,1,10) AS ds,
        platform_level(device.platform,2) AS platform,
        application.site_id AS site_id,
        IF(v2.algorithm IS NULL, v2.backend_id, v2.algorithm) AS backend,
        IF(v2.client IS NULL, v2.context, v2.client) AS client
FROM tracks
LATERAL VIEW json_tuple(event_data, 'recommendations') v1 AS recommendations
LATERAL VIEW json_tuple(v1.recommendations, 'hidden_by_client', 'backend_id', 'client', 'algorithm', 'context') v2 AS hidden_by_client, backend_id, client, algorithm, context
WHERE v1.recommendations IS NOT NULL
AND (v2.algorithm is not null or v2.backend_id is not null)
AND (v2.context is not null or v2.client is not null)
AND CAST(v2.hidden_by_client as varchar(50)) = 'false'
AND ds >= '@param01 02' AND ds < '@param02 02'
)a
GROUP BY  a.ds,
          a.site_id,
          a.client,
          a.backend,
          a.platform
