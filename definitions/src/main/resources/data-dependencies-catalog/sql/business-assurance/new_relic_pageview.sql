select
from_unixtime(CAST(substr(jest(data,'timestamp'),1,10) as BIGINT), 'yyyy-MM-dd HH') as FechaCompleta
,from_unixtime(CAST(substr(jest(data,'timestamp'),1,10) as BIGINT), 'HH')-3 as Hora
,jest(data,'eventType') as eventType
,jest(data,'countryCode') as countryCode
,jest(data,'city') as city
,jest(data,'appName') as appName
,jest(data,'applicationId') as applicationId
,jest(data,'browserTransactionName') as browserTransactionName
,jest(data,'userAgentName') as userAgentName
,jest(data,'userAgentOS') as userAgentOS
,jest(data,'deviceType') as deviceType
,jest(data,'userAgentVersion') as userAgentVersion
,count(jest(data,'session')) as Cant_Sesiones
,avg(jest(data,'dnsLookupDuration')) as AVG_dns
,avg(jest(data,'duration')) as AVG_Duration
,avg(jest(data,'domProcessingDuration')) as AVG_DOM
,avg(jest(data,'backendDuration')) AS AVG_BACKEND
,avg(jest(data,'pageRenderingDuration')) as AVG_PAGERENDERINGDURATION
,avg(jest(data,'webAppDuration')) AS AVG_WEBAPP
,avg(jest(data,'networkDuration')) AS AVG_NETWORK
,from_unixtime(CAST(substr(jest(data,'timestamp'),1,10) as BIGINT), 'yyyy-MM-dd') as Fecha
from ba.new_relic_data 
where substr(ds,1,10) >= '@param01' AND substr(ds,1,10)< '@param02' 
and jest(data,'eventType') ='PageView'
group by 
from_unixtime(CAST(substr(jest(data,'timestamp'),1,10) as BIGINT), 'yyyy-MM-dd HH')
,from_unixtime(CAST(substr(jest(data,'timestamp'),1,10) as BIGINT), 'yyyy-MM-dd') 
,from_unixtime(CAST(substr(jest(data,'timestamp'),1,10) as BIGINT), 'HH')-3
,jest(data,'eventType') 
,jest(data,'countryCode')
,jest(data,'city')
,jest(data,'appName')
,jest(data,'applicationId')
,jest(data,'browserTransactionName') 
,jest(data,'userAgentName')
,jest(data,'userAgentOS')
,jest(data,'deviceType') 
,jest(data,'userAgentVersion') 