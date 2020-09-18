select id, username, operation, type, user_agent, state, source, schema, table_read, cpu_time, replace(replace(replace(lower(substr(text,1, 5000)), chr(10), ' '), chr(13), ' '), chr(9), ' ') AS text, substr(ds, 1 , 10) AS ds
from presto_queries
lateral view explode(from_tables) tables as table_read
WHERE ds >= '@param01' and ds< '@param02'



