SELECT http_user_agent, COUNT(1) as total 
	FROM traffic.access_logs_archive 
	WHERE ds = '@param01' 
	AND scope = 'pubapi' 
	AND http_user_agent LIKE 'MELI-%-SDK-%' 
GROUP BY http_user_agent 
UNION 
SELECT 'Total Requests', COUNT(1) 
	FROM traffic.access_logs_archive 
	WHERE ds = '@param01' 
	AND scope = 'pubapi';