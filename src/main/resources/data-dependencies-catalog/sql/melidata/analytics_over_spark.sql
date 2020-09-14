select application_id, driver_host, execution_id, job_query, poolname, username, job_id, process_name, manager, result_size, result_serialization_time, executor_run_time, executor_deserialize_time, executor_deserialize_cpu_time, executor_cpu_time, bytes_read, records_read, bytes_written, records_written, case when RLIKE(replace(replace(replace(lower(job_query),chr (10),' '),chr (13),' '),chr (9),' '), 'tracks_ml|tracks_mp|tracks_me|tracks_ms') then 'tracks_optimized' when RLIKE(replace(replace(replace(lower(job_query),chr (10),' '),chr (13),' '),chr (9),' '), 'tracks') then 'tracks' else 'other' end as table_read, failure_reason, substr(ds, 1 , 10) AS ds
from spark_jobs
WHERE ds >= '@param01' and ds< '@param02'