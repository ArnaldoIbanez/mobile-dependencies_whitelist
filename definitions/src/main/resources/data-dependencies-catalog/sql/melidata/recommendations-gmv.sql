SELECT
  recommendations.ds AS ds,
  recommendations.platform AS platform,
  recommendations.site_id AS site_id,
  recommendations.client AS client,
  recommendations.backend AS backend,
  COUNT(orders.order_id) AS orders,
  IF(SUM(orders.total_amount_usd) IS NULL, 0, SUM(orders.total_amount_usd))  AS GMV
FROM(
    SELECT DISTINCT
    '@param01' AS ds,
    device.platform AS platform,
    application.site_id AS site_id,
    get_json_object(others['fragment'], '$.reco_client') AS client,
    get_json_object(others['fragment'], '$.reco_backend') AS backend,
    get_json_object(event_data, '$.item_id') AS item_id,
    usr.user_id AS user_id
    FROM tracks
    WHERE
        path = '/vip'
        AND get_json_object(others['fragment'], '$.reco_client') IS NOT NULL
        AND ds >= '@param01 06' AND ds < '@param02 06'
        )recommendations
INNER JOIN(
            SELECT
            '@param01' AS ds,
            usr.user_id AS user_id,
            order_id,
            CAST(get_json_object(get_json_object(get_json_object(event_data,'$.order_items[0]'),'$.item'),'$.id')AS varchar(50)) AS item_id,
            total_amount_usd
            FROM tracks
            LATERAL VIEW json_tuple(event_data, 'order_id', 'total_amount_usd') v1 AS order_id, total_amount_usd
            WHERE
                path = '/checkout/congrats'
                AND ds >= '@param01 06' AND ds < '@param02 06'
                AND CAST(get_json_object(event_data,'$.congrats_seq')AS VARCHAR(50)) = '1'
            ) orders
ON  orders.item_id = recommendations.item_id
AND orders.user_id = recommendations.user_id
AND orders.ds = recommendations.ds
GROUP BY recommendations.platform,
         recommendations.site_id,
         recommendations.client,
         recommendations.backend,
         recommendations.ds