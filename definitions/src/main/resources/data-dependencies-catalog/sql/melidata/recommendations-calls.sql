SELECT '@param01 06' AS ds,
        application.site_id AS site_id,
        backend AS backend,
        client AS client,
        platform_level(device.platform,2) AS platform,
        count(id) AS calls
FROM tracks
LATERAL VIEW json_tuple(event_data, 'recommendations', 'congrats_seq') v1 AS recommendations, congrats_seq
LATERAL VIEW json_tuple(v1.recommendations, 'algorithm','context', 'hidden_by_client') v2 AS backend, client, hidden_by_clientWHERE CAST(v1.congrats_seq AS VARCHAR(50)) = '1'
AND v1.recommendations IS NOT NULL
AND v2.client IS NOT NULL
AND CAST(v2.hidden_by_client as varchar(50)) = 'false'
AND ds >= '@param01 06' AND ds < '@param02 06'
AND application.site_id IN ('MLA','MLB')
GROUP BY '@param01 06',
          application.site_id,
          v2.client,
          v2.backend,
          platform_level(device.platform,2)





