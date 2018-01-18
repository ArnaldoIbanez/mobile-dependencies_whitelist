SELECT fecha,
	termino_en_claims - otro_problema AS intencion_de_devolver,
	termino_en_claims,
	otro_problema,
	platform,
	site,
	user_id,
	user_nick,
	path,
	typification,
	action
FROM (SELECT ds AS fecha,
  COUNT (DISTINCT CASE WHEN (path IN ('/return/external', '/return/external/claims') AND type = 'view') THEN usr.uid ELSE NULL END) AS termino_en_claims,
  COUNT (DISTINCT CASE WHEN (path = '/return/typifications' AND event_data IN ('{"typification":"go_to_claim","action":"selection"}', 
  '{"path":"\/return\/typifications","dictionary_data":{"typification":"go_to_claim","action":"selection"},"type":"event"}', 
  '{"typification":"gtc_oter_problem","action":"selection"}', 
  '{"path":"\/return\/typifications","dictionary_data":{"typification":"gtc_other_problem","action":"selection"},"type":"event"}') AND type = 'event') THEN usr.uid ELSE NULL END) AS otro_problema,
	device.platform as platform,
	application.site_id as site,
	usr.user_id as user_id,
	usr.user_nick as user_nick,
	path as path,
	jest(event_data, 'typification') as typification,
	jest(event_data, 'action') as action
FROM tracks 
WHERE ds >= '@param01' 
	AND ds < '@param02'
	AND usr.user_nick not like 'TETE%'
	AND usr.user_nick not like 'TT%'
	AND usr.user_nick not like 'TEST%'
	AND usr.user_nick not like 'BUYER%'