select 
from_unixtime(CAST(substr(jest(data,'timestamp'),1,10) as BIGINT), 'yyyy-MM-dd HH') as FechaCompleta
,from_unixtime(CAST(substr(jest(data,'timestamp'),1,10) as BIGINT), 'HH')-3 as Hora
,eventType
,applicationId
,appName
,deviceType
,errorClass
,requestUri
,transactionName
,userAgentName
,userAgentOS
,userAgentVersion
,from_unixtime(CAST(substr(jest(data,'timestamp'),1,10) as BIGINT), 'yyyy-MM-dd') as Fecha
from ba.new_relic_data
lateral view json_tuple(data, 'eventType','applicationId','appName','deviceType','errorClass','requestUri','transactionName','userAgentName','userAgentOS','userAgentVersion') t1 
as eventType,applicationId,appName,deviceType,errorClass,requestUri,transactionName,userAgentName,userAgentOS,userAgentVersion
where substr(ds,1,10) >= '@param01' AND substr(ds,1,10)< '@param02' 
and jest(data,'eventType')='JavaScriptError'
