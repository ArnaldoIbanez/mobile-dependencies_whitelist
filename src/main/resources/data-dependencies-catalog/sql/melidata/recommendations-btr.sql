SELECT
 t1.ds AS ds,
 t1.platform AS platform,
 t1.site_id AS site_id,
 t1.backend AS backend,
 t1.client AS client,
 t1.prints AS prints,
 t2.orders AS orders,
 t2.GMV AS GMV
FROM(
   SELECT
         ds,
         platform,
         site_id,
         backend,
         client,
         COUNT(distinct(id)) AS prints
FROM(SELECT
        id,
        '@param02' AS ds,
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
        AND (CAST(v2.hidden_by_client as varchar(50)) = 'false' OR v2.hidden_by_client is null)
        AND (v2.algorithm is not null or v2.backend_id is not null)
        AND (v2.context is not null or v2.client is not null)
        AND NOT is_bot(device.user_agent)
        AND ds >= '@param02 02' AND ds < '@param03 02') a
GROUP BY a.ds,
         a.platform,
         a.site_id,
         a.backend,
         a.client
   )t1
 LEFT JOIN(
 SELECT
 orders.ds AS ds,
 recommendations.platform AS platform,
 recommendations.site_id AS site_id,
 recommendations.client AS client,
 recommendations.backend AS backend,
 COUNT(orders.order_id) AS orders,
 IF(SUM(orders.total_amount_usd) IS NULL, 0, SUM(orders.total_amount_usd))  AS GMV
FROM(
 	SELECT DISTINCT
  substr(ds,1,10) AS ds,
 	platform_level(device.platform,2) AS platform,
 	application.site_id AS site_id,
 	client,
 	backend,
 	get_json_object(event_data, '$.item_id') AS item_id,
 	usr.user_id AS user_id,
	user_timestamp
   FROM tracks
   LATERAL VIEW json_tuple(others['fragment'], 'reco_client', 'reco_backend') v1 AS client, backend
   WHERE
   	path = '/vip'
   	AND v1.client IS NOT NULL
   	AND NOT is_bot(device.user_agent)
   	AND ds >= '@param01 02' AND ds < '@param03 02'
   )recommendations
INNER JOIN(
       	SELECT
         '@param02' AS ds,
         	usr.user_id AS user_id,
         	order_id,
         	CAST(get_json_object(get_json_object(get_json_object(event_data,'$.items[0]'),'$.item'),'$.id')AS varchar(50)) AS item_id,
         	total_amount_usd,
		user_timestamp
       	FROM tracks
       	LATERAL VIEW json_tuple(event_data, 'order_id', 'total_amount_usd', 'recommendations', 'congrats_seq') v1 AS order_id, total_amount_usd, recommendations, congrats_seq
       	WHERE
           	path like '/checkout/congrats%'
            AND ds >= '@param02 02' AND ds < '@param03 02'
           	AND CAST(v1.congrats_seq AS VARCHAR(50)) = '1'
           	AND NOT is_bot(device.user_agent)
           	AND total_amount_usd < 10000
       	) orders
ON  orders.item_id = recommendations.item_id
AND orders.user_id = recommendations.user_id
WHERE orders.user_timestamp > recommendations.user_timestamp
AND datediff(orders.ds, recommendations.ds) <= 7
GROUP BY
      orders.ds,
      recommendations.platform,
    	recommendations.site_id,
    	recommendations.client,
    	recommendations.backend) t2
ON
  t1.ds = t2.ds
  AND t1.platform = t2.platform
  AND t1.site_id = t2.site_id
  AND t1.backend = t2.backend
  AND t1.client = t2.client






