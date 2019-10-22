SELECT 
	'@param01' AS request_date, http_user_agent, total 
FROM (
	SELECT 
		a.http_user_agent, COUNT(ds) as total 
	FROM traffic.access_logs_archive a 
	WHERE a.ds >= '@param01T00_00_00'
	AND a.ds <= '@param01T23_00_00' 
	AND a.scope = 'pubapi' 
	AND a.http_user_agent LIKE 'MELI-%-SDK-%' 
	GROUP BY a.http_user_agent
	UNION ALL 
		SELECT 
			'Total Requests', COUNT(http_user_agent) as total 
		FROM traffic.access_logs_archive b
		WHERE b.ds >= '@param01T00_00_00'
		AND b.ds <= '@param01T23_00_00' 
		AND b.scope = 'pubapi'
) c;