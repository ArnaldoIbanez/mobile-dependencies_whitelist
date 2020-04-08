select id, username, operation, type, table_read, error_message, query_duration, partitions_read, cpu_time, owner, application_id, substr(ds, 1 , 10) AS ds
from hive_queries
lateral view explode(tables_read) tables as table_read
WHERE ds >= '@param01' and ds< '@param02'