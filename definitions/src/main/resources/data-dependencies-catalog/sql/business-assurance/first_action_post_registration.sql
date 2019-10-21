SELECT REGI.USERS AS user_id, REGI.SITE AS site, REGI.PLATFORM AS platform, REGI.APP AS app, REGI.SOURCE as source, OTHERS.PATH AS primera_accion, REGI.FECHA as fecha_registracion, OTHERS.FECHA AS fecha_primera_accion
FROM
(SELECT USR.USER_ID AS USERS, APPLICATION.SITE_ID AS SITE, DEVICE.PLATFORM AS PLATFORM, JEST(EVENT_DATA, 'app') AS APP, JEST(EVENT_DATA, 'source') AS SOURCE, SUBSTR(DS,1,10) AS FECHA
FROM TRACKS
WHERE PATH = '/register/success'
AND (JEST(EVENT_DATA, 'app') IS NULL OR
(JEST(EVENT_DATA, 'app') LIKE 'registration%' AND JEST(EVENT_DATA, 'app') NOT IN ( 'registration-classi-contact',
'registration-syi',
'registration-update',
'registration-update-mt',
'registration-update-opt',
'registration-update-tc',
'registration-updatephone',
'registration-updatephone-mt',
'registration-updatephone-tc')))
AND DS >= '@param01' AND DS < '@param02'
) REGI
INNER JOIN
(SELECT USR.USER_ID  USERS, PATH, USER_TIMESTAMP AS HORA, rank() over(partition BY usr.user_id ORDER BY user_timestamp) AS RANK, SUBSTR(DS,1,10) AS FECHA
FROM TRACKS
WHERE PATH IN ('/checkout/congrats','/cart/checkout/congrats' , '/sell/list/congrats',
'/sell/list/draft/congrats', '/questions/ask/post', '/quotation/success',
'/make-an-offer/send-offer', '/credits/consumer/enrollment/congrats', '/credits/merchant/enrollment/congrats',
'/money_request/congrats', '/new_withdraw/congrats', '/cellphone_recharge/congrats',
'/asset_management/add_funds', '/bill_payments', '/withdraw/main', '/shortcuts/scan_qr', '/shortcuts/sube_recharge',
'/shortcuts/cellphone_recharge', '/shortcuts/pay_services', '/account_fund/payment_types',
'/bill_payments/help', '/recharge_sube/select_recharge_card', '/cellphone_recharge/recents')
AND DS >= '@param01'
ORDER BY HORA DESC) OTHERS
ON REGI.USERS = OTHERS.USERS
WHERE OTHERS.RANK = 1