select 
FechaCompleta
,Hora
,eventType,appName, country, deviceType,BrowserInteractionName
,avg(timeToConnectStart) as timeToConnectStart
,avg(timeToConnectEnd) as timeToConnectEnd
,avg(timeToDomComplete) as timeToDomComplete
,avg(timeToDomInteractive)  as timeToDomInteractive
,avg(timeToDomLoading) as timeToDomLoading
,avg(timeToDomainLookupStart)  as timeToDomainLookupStart
,avg(timeToDomainLookupEnd) as timeToDomainLookupEnd
,avg(timeToLoadEventStart)  as timeToLoadEventStart
,avg(timeToLoadEventEnd)  as timeToLoadEventEnd
,avg(timeToRequestStart) as timeToRequestStart
,avg(timeToResponseEnd)as timeToResponseEnd
,Fecha
from (
select
 ds as FechaCompleta
,from_unixtime(CAST(substr(jest(data,'timestamp'),1,10) as BIGINT), 'yyyy-MM-dd') as Fecha
,from_unixtime(CAST(substr(jest(data,'timestamp'),1,10) as BIGINT), 'HH')-3 as Hora,
jest(data,'appName') as appName, 
jest(data,'eventType') as eventType, 
jest(data,'countryCode') as country, 
jest(data,'deviceType') as deviceType,
jest(data,'browserInteractionName') as BrowserInteractionName,
cast(jest(data,'timeToConnectStart') as double)  as timeToConnectStart,
cast(jest(data,'timeToConnectEnd') as double)  as timeToConnectEnd,
cast(jest(data,'timeToDomComplete') as double)  as timeToDomComplete,
cast(jest(data,'timeToDomInteractive') as double)  as timeToDomInteractive,
cast(jest(data,'timeToDomLoading') as double)  as timeToDomLoading,
cast(jest(data,'timeToDomainLookupStart') as double)  as timeToDomainLookupStart,
cast(jest(data,'timeToDomainLookupEnd') as double)  as timeToDomainLookupEnd,
cast(jest(data,'timeToLoadEventStart') as double)  as timeToLoadEventStart,
cast(jest(data,'timeToLoadEventEnd') as double)  as timeToLoadEventEnd,
cast(jest(data,'timeToRequestStart') as double)  as timeToRequestStart,
cast(jest(data,'timeToResponseEnd') as double)  as timeToResponseEnd
from ba.new_relic_data
 where 
 jest(data,'eventType') = 'BrowserInteraction'
 and jest(data,'deviceType') IN ('Desktop','Mobile')
 and substr(ds,1,10) >= '@param01' AND substr(ds,1,10)< '@param02' 
)todo
group by Fecha,FechaCompleta,Hora,eventType,appName, country, deviceType,BrowserInteractionName