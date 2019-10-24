select
denominador.hour_only,
   	denominador.platform,
   	denominador.context as dpto,
   	denominador.app_version,
   	denominador.business,
   	coalesce (numerador.uu_with_crashes_per_hour, 0) as uu_with_crashes_per_hour,
   	coalesce (numerador.crashes_per_hour, 0) as crashes_per_hour,
   	coalesce (numerador.uu_with_warnings_per_hour, 0) as uu_with_warnings_per_hour,
   	coalesce (numerador.warnings_per_hour, 0) as warnings_per_hour,
   	denominador.uu_per_hour,
   	denominador.screenviews_per_hour,
   	denominador.date_only
from (
  select date_only,
      hour_only,
     	platform,
     	context,  app_version, business,
     	sum( if( severity = 'error', coalesce( uu_with_error_per_hour, 0 ), 0 ))   as uu_with_crashes_per_hour,
     	sum( if( severity = 'error', coalesce( errors_per_hour, 0 ), 0 ))          as crashes_per_hour,
     	sum( if( severity = 'warning', coalesce( uu_with_error_per_hour, 0 ), 0 )) as uu_with_warnings_per_hour,
     	sum( if( severity = 'warning', coalesce( errors_per_hour, 0 ), 0 ))   	 as warnings_per_hour
  from (

	select date_only,
	      hour_only,
       	platform, severity ,
       	context,
       	app_version,business,
       	count( uid ) as uu_with_error_per_hour,
       	sum( errors_per_uid ) as errors_per_hour
	from (
   	select substr(ds, 1, 10) as date_only,
   	        substr(ds, 12, 13) as hour_only,
          	regexp_extract(device.platform, '^\/mobile\/(android|ios)$')  as platform,
          	json_extract_scalar(event_data, '$.error_severity')           as severity,
        	  json_extract_scalar(event_data, '$.error_context')         as context,
        	  regexp_extract(application.version, '^(\d+\.\d+\.\d+).*$', 1) as app_version,
        	  application.business as business,
          	usr.uid as uid,
        	  count( 1 ) as errors_per_uid
  	from tracks
        	WHERE
           ds >= '@param01' and ds < '@param02'
 	         and type = 'event'
    	      and path = '/mobile/bugsnag'
  	group by substr(ds, 1, 10),
  	         substr(ds, 12, 13),
           	regexp_extract(device.platform, '^\/mobile\/(android|ios)$'),
           	json_extract_scalar( event_data, '$.error_severity'),
         	  json_extract_scalar(event_data, '$.error_context'),
            regexp_extract(application.version, '^(\d+\.\d+\.\d+).*$', 1),
            application.business,
           	usr.uid
 	)
	group by  date_only,
	          hour_only,
          	platform, severity ,
          	context,
          	app_version,
          	business

   )
   group by  date_only, hour_only, platform, context,  app_version, business

 ) as numerador

right outer join (

   select  date_only,
        hour_only,
       	platform,
       	context,
       	app_version,
        business,
       	count( uid ) as uu_per_hour,
      	sum (screenviews_per_uid) as screenviews_per_hour
   from(
  	select substr(ds, 1, 10)   as date_only,
  	      substr(ds, 12, 13)   as hour_only,
         	regexp_extract(device.platform, '^\/mobile\/(android|ios)$') as platform,
        	application.view_context as context,
          regexp_extract(application.version, '^(\d+\.\d+\.\d+).*$', 1) as app_version,
          application.business,
         	usr.uid as uid,
         	count( 1 ) as screenviews_per_uid
  	from tracks
      WHERE  ds >= '@param01' and ds < '@param02'
    	AND type = 'view'

  	group by substr(ds, 1, 10),
  	      substr(ds, 12, 13),
        	regexp_extract(device.platform, '^\/mobile\/(android|ios)$'),
        	 application.view_context,
        	regexp_extract(application.version, '^(\d+\.\d+\.\d+).*$', 1) ,
       	 application.business ,
        	usr.uid
  	)
   group by date_only, hour_only, platform,  context,  app_version, business


 ) as denominador
on (
	  denominador.date_only = numerador.date_only
	  and denominador.hour_only = numerador.hour_only
  	and numerador.platform	= denominador.platform
    and numerador.context     = denominador.context
   	and numerador.app_version = denominador.app_version
    and numerador.business  = denominador.business
)
