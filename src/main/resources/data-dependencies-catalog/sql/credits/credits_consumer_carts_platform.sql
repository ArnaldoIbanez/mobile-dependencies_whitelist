SELECT count(*) AS Count,
path AS Path,
device.platform AS Platform,
application.site_id AS Site,
substring(ds, 1, 10) AS Fecha
FROM tracks
WHERE path IN ('/checkout/congrats','/cart/checkout/congrats') AND jest(event_data, 'payments[0].payment_method') = 'consumer_credits'
      AND (ds >= '@param01' AND ds < '@param02')
      AND jest(event_data, 'congrats_seq') = '1'
      GROUP BY device.platform, path, application.site_id, SUBSTRING(ds, 1, 10);
