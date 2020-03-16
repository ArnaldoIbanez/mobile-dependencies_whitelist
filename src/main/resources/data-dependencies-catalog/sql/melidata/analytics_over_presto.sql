select id, username, operation, type, user_agent, state, source, schema, table_read, text, cpu_time, substr(ds, 1 , 10) AS ds
from presto_queries
lateral view explode(from_tables) tables as table_read
WHERE ds >= '@param01'
