SELECT 
usr.user_id
FROM tracks
WHERE ds >= '2017-07-01' 
AND ds < '2017-07-27' 
AND  path  like '/myml/summary'