SELECT
    orders.ds AS ds,
    recommendations.platform AS platform,
    recommendations.site_id AS site_id,
    recommendations.client AS client,
    recommendations.backend AS backend,
    COUNT(orders.order_id) AS orders,
    IF(SUM(orders.total_amount_usd) IS NULL, 0, SUM(orders.total_amount_usd))  AS GMV
FROM (
    SELECT DISTINCT
        '@param02' AS ds,
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
        AND NOT is_bot(device.user_agent)
    ) recommendations
INNER JOIN (
    SELECT
        '@param02' AS ds,
        user_id AS user_id,
        order_id AS order_id,
        item_id AS item_id,
        price AS total_amount_usd,
        user_timestamp
    FROM reco_orders
    WHERE
        ds = '@param02'
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
