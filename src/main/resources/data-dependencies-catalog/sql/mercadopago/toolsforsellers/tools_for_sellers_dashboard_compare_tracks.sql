select
case when event_data = '{}' then 'Comparisons from mobile devices'
else
REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(event_data,'{"section":',''),'"chart_id":',''),'}',''),'"',''),',',' - ') end as event_data,
application.site_id as site_id,
substr(ds,1,10) as ds
from tracks
where path like '%tfs_dashboard/compare'
AND ds >= '@param01'
AND ds < '@param02'