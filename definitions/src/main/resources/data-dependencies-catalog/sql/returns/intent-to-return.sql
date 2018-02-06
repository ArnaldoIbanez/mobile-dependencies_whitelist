SELECT fecha,
termino_en_claims - otro_problema AS intencion_de_devolver,
termino_en_claims,
otro_problema,
platform,
site,
user_id
FROM (SELECT substr(ds,1,10) AS fecha,
	COUNT (DISTINCT CASE WHEN (path IN ('/return/external', '/return/external/claims') AND type = 'view') THEN usr.uid ELSE NULL END) AS termino_en_claims,
	COUNT (DISTINCT CASE WHEN (path = '/return/typifications' AND (jest(event_data, 'typification') IN ('go_to_claim', 'gtc_other_problem') OR jest(event_data, 'dictionary_data.typification') IN ('go_to_claim', 'gtc_other_problem'))) THEN usr.uid ELSE NULL END) AS otro_problema,
	device.platform as platform,
	application.site_id as site,
	usr.user_id as user_id
FROM tracks 
WHERE ds >= '@param01'
	AND ds < '@param02' 
	AND usr.user_nick not like 'TETE%'
	AND usr.user_nick not like 'TT%'
	AND usr.user_nick not like 'TEST%'
	AND usr.user_nick not like 'BUYER%'
	AND application.site_id IN ('MLM','MLB')
	AND path IN ('/return/external', '/return/external/claims', '/return/typifications')
GROUP BY substr(ds,1,10),
	device.platform,
	application.site_id,
	usr.user_id) A
WHERE (termino_en_claims - otro_problema) > 0