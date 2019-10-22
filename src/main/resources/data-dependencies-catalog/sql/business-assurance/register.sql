
SELECT 
  substr(ds,1,10) as ds,
   jest(event_data, 'app') as App,
  count(distinct usr.uid) as Sessions,
  count(distinct hub.uid) as Hub,
  count(distinct form.uid) as Form,
  count(distinct formError.uid) as FormError,
  count(distinct anotherEmail.uid) as AnotherEmail,
  count(distinct success.uid) as Success 
FROM tracks tracks 
	

  LEFT JOIN 
		(SELECT DISTINCT usr.uid AS uid, jest(event_data, 'app') AS app
			FROM tracks 
			WHERE ds >= '@param01' AND ds < '@param02'
			AND path = '/register/congrats'
		) success 
	ON success.uid = tracks.usr.uid AND success.app = jest(event_data, 'app')
	

  LEFT JOIN 
		(SELECT DISTINCT usr.uid AS uid, jest(event_data, 'app') AS app 
			FROM tracks 
			WHERE ds >= '@param01' AND ds < '@param02'
			AND path = '/register/hub'
		) hub
	ON hub.uid = tracks.usr.uid AND hub.app = jest(event_data, 'app')
	
  LEFT JOIN 
		(SELECT DISTINCT usr.uid AS uid, jest(event_data, 'app') AS app 
			FROM tracks 
			WHERE ds >= '@param01' AND ds < '@param02'
			AND path = '/register/form'
		) form
	ON form.uid = tracks.usr.uid AND form.app = jest(event_data, 'app')
	
  LEFT JOIN 
		(SELECT DISTINCT usr.uid AS uid, jest(event_data, 'app') AS app 
			FROM tracks 
			WHERE ds >= '@param01' AND ds < '@param02'
			AND path = '/register/form/error'
		) formError
	ON formError.uid = tracks.usr.uid AND formError.app = jest(event_data, 'app')
	
  LEFT JOIN 
		(SELECT DISTINCT usr.uid AS uid, jest(event_data, 'app') AS app 
			FROM tracks 
			WHERE ds >= '@param01' AND ds < '@param02'
			AND path = '/register/form/another-email'
		) anotherEmail
	ON anotherEmail.uid = tracks.usr.uid AND anotherEmail.app = jest(event_data, 'app')

WHERE ds >= '@param01' AND ds < '@param02'
	AND path like '/register%'
	AND device.platform like '/mobile%'

GROUP BY substr(ds,1,10),jest(event_data, 'app')

