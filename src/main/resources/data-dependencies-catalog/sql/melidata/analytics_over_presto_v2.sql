select id, username, operation, type, user_agent, state, source, schema, table_read, cpu_time, replace(lower(text), chr(10), ' ') AS text, substr(ds, 1 , 10) AS ds
from presto_queries
lateral view explode(from_tables) tables as table_read
WHERE ds >= '@param01' and ds< '@param02'



