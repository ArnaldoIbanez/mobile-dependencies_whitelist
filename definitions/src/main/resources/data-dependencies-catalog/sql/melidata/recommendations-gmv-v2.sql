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
   	AND ds >= '@param01 02' AND ds < '@param03 02'
   )recommendations
INNER JOIN(
       	SELECT
         	substr(ds,1,10) AS ds,
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
    	recommendations.backend
