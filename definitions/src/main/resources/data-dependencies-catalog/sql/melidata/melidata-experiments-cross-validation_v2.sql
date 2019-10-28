select 'STATS_DATA' AS SOURCE, experiment_name, metric, platform, variant_id, sum(sessions) as sessions, sum(metric_sum) as metric_sum, sum(metric_sum)/sum(sessions) as ratio, substr(ds,1,10) AS ds
from melidata.experiments_by_uid_stats_data
WHERE ds >= '@param01'
AND ds < '@param02'
and (experiment_name in ('homesDummy', 'melidata/homesDummyWeb') or experiment_name like 'search/%')
and metric in ('checkout_congrats', 'checkout_congrats#gmvusd', 'buys', 'buys#gmvusd', 'questions', 'bookmarks', 'search', 'vip')
group by experiment_name, metric, platform, variant_id, substr(ds,1,10)

union all

select 'BUCKETIZED_DATA' AS SOURCE, experiment_name, metrica, platform, cast(variant_id as string) variant_id, sum(valueb) as sessions, sum(valuea) as metric_sum, sum(valuea)/sum(valueb) ,substr(ds,1,10) AS ds
from melidata.experiments_by_uid
WHERE ds >= '@param01'
AND ds < '@param02'
and (experiment_name in ('homesDummy', 'melidata/homesDummyWeb') or experiment_name like 'search/%')
and metrica in ('checkout_congrats', 'checkout_congrats#gmvusd', 'buys', 'buys#gmvusd', 'questions', 'bookmarks', 'search', 'vip')
group by experiment_name, metrica, platform, variant_id, substr(ds,1,10)