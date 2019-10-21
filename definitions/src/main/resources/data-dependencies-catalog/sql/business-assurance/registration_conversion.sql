SELECT USR.USER_ID AS user_id, APPLICATION.SITE_ID AS site, DEVICE.PLATFORM AS platform, JEST(EVENT_DATA, 'app') AS app, JEST(EVENT_DATA, 'source') AS source, SUBSTR(DS,1,10) AS fecha
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