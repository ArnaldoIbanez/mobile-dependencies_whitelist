SELECT ds AS ds,
       jest(event_data,'qr_info') AS qr_info,
       jest(event_data,'_label') AS status,
       usr.user_id AS user_id,
       usr.user_nick AS user_nick,
       device.platform AS platform
FROM tracks
WHERE ds >= '@param01'
AND   ds < '@param02'
AND   application.business = 'mercadopago'
AND   device.platform LIKE '/mobile/%'
AND   (jest(event_data,'qr_info') LIKE 'https://www.mercadopago.com/instore?type=ez&vending_id=%'
        OR jest(event_data,'qr_info') LIKE 'https://pagomovil.axionenergy.com/getSaleInformation%')