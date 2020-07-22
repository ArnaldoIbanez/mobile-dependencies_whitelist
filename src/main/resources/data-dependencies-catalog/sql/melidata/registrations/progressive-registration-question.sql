SELECT substr(ds,1,10) as fecha,
CASE experiments['traffic/progressiveRegistrationQuestionV1'] 
  WHEN '522' THEN 'CompleteRegister'
  WHEN '521' THEN 'ProgressiveRegister'
END as variant_description,
count(distinct (CASE WHEN device.platform like '/web/mobile%' THEN id END)) as views_mobile,
count(distinct (CASE WHEN device.platform like '/web/mobile%' THEN usr.uid END)) as sessions_mobile, 
count(distinct (CASE WHEN device.platform like '/web/mobile%' THEN success.uid END)) as success_mobile,
cast(count(distinct (CASE WHEN device.platform like '/web/mobile%' THEN success.uid END)) as Double)/cast(count(distinct (CASE WHEN device.platform like '/web/mobile%' THEN usr.uid END)) as Double) as rate_mobile,
count(distinct (CASE WHEN device.platform like '/web/desktop%' THEN id END)) as views_desktop, 
count(distinct (CASE WHEN device.platform like '/web/desktop%' THEN usr.uid END)) as sessions_desktop, 
count(distinct (CASE WHEN device.platform like '/web/desktop%' THEN success.uid END)) as success_desktop,
cast(count(distinct (CASE WHEN device.platform like '/web/desktop%' THEN success.uid END)) as Double)/cast(count(distinct (CASE WHEN device.platform like '/web/desktop%' THEN usr.uid END)) as Double) as rate_desktop
FROM tracks tracks 
LEFT JOIN 
	(SELECT DISTINCT usr.uid AS uid 
		FROM tracks 
		where ds >='@param01' and ds <'@param02'
		AND path = '/register/success'
	) success
ON success.uid = tracks.usr.uid 
where ds >='@param01' and ds <'@param02'
AND jest(event_data, 'app') like 'registration-question'
AND experiments['traffic/progressiveRegistrationQuestionV1'] is not null
AND application.site_id like 'MLA'
AND path = '/register/form'
group by 1, 2