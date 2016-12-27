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
      substr(ds,1,10) AS ds,
      platform_level(device.platform,2) AS platform,
      application.site_id AS site_id,
      backend,
      client,
      COUNT(distinct(id)) AS prints
    FROM tracks
    LATERAL VIEW json_tuple(event_data, 'recommendations') v1 AS recommendations
    LATERAL VIEW json_tuple(v1.recommendations, 'algorithm','context', 'track_info', 'hidden_by_client' ) v2 AS backend, client, track_info, hidden_by_client
    WHERE v2.track_info IS NOT NULL
    AND v2.backend IS NOT NULL
    AND v2.client IS NOT NULL
    AND V2.backend <> 'empty'
    AND CAST(V2.hidden_by_client AS VARCHAR(50)) = 'false'
    AND ds >= '@param01 06' AND ds < '@param02 06'
    GROUP BY
    substr(ds,1,10),
    application.site_id,
    v2.backend,
    v2.client,
    platform_level(device.platform,2)
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
   	AND ds >= '@param03 06' AND ds < '@param02 06'
   )recommendations
INNER JOIN(
       	SELECT
         	substr(ds,1,10) AS ds,
         	usr.user_id AS user_id,
         	order_id,
         	CAST(get_json_object(get_json_object(get_json_object(event_data,'$.order_items[0]'),'$.item'),'$.id')AS varchar(50)) AS item_id,
         	total_amount_usd,
		user_timestamp
       	FROM tracks
       	LATERAL VIEW json_tuple(event_data, 'order_id', 'total_amount_usd', 'recommendations', 'congrats_seq') v1 AS order_id, total_amount_usd, recommendations, congrats_seq
       	WHERE
           	path like '/checkout/congrats%'
            AND ds >= '@param01 06' AND ds < '@param02 06'
           	AND CAST(v1.congrats_seq AS VARCHAR(50)) = '1'
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






