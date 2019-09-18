select 'STATS_DATA' AS SOURCE, experiment_name, platform, variant_id, sum(sessions) as sessions, sum(metric_sum) as congrats, substr(ds,1,10) AS ds
from melidata.experiments_by_uid_stats_data
WHERE ds >= '@param01'
AND ds < '@param02'
and (experiment_name = 'homesDummy' or experiment_name like 'search/%')
and metric = 'checkout_congrats'
group by experiment_name, platform, variant_id, substr(ds,1,10)

union all

select 'BUCKETIZED_DATA' AS SOURCE, experiment_name, platform, cast(variant_id as varchar) variant_id, sum(valueb) as sessions, sum(valuea) as congrats, substr(ds,1,10) AS ds
from melidata.experiments_by_uid
WHERE ds >= '@param01'
AND ds < '@param02'
and (experiment_name = 'homesDummy' or experiment_name like 'search/%')
and metrica = 'checkout_congrats'
group by experiment_name, platform, variant_id, substr(ds,1,10)