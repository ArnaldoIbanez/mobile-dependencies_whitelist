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
        select
      t1.date_only as date_only,
      t1.hour_only as hour_only,
     	t1.platform as platform,
     	t1.context as context,
     	t1.app_version as app_version,
     	t1.business as business,
     	sum(if(t1.severity = 'error', coalesce(t1.uu_with_error_per_hour, 0 ), 0 )) as uu_with_crashes_per_hour,
     	sum(if(t1.severity = 'error', coalesce(t1.errors_per_hour, 0 ), 0 )) as crashes_per_hour,
     	sum(if(t1.severity = 'warning', coalesce(t1.uu_with_error_per_hour, 0 ), 0 )) as uu_with_warnings_per_hour,
     	sum(if(t1.severity = 'warning', coalesce(t1.errors_per_hour, 0 ), 0 )) as warnings_per_hour
  from (
           	select
            	  t. date_only as date_only,
          	    t.hour_only as hour_only,
                t.platform as platform,
                t.severity  as severity,
                t.context as context,
                t.app_version as app_version,
                t.business as business,
                count( t.uid ) as uu_with_error_per_hour,
                sum( t.errors_per_uid ) as errors_per_hour
          	from (
              	(select substr(ds, 1, 10) as date_only,
             	        substr(ds, 12, 13) as hour_only,
                    	regexp_extract(device.platform, '^\/mobile\/(android|ios)$')  as platform,
                    	get_json_object(event_data, '$.error_severity')           as severity,
                  	  get_json_object(event_data, '$.error_context')         as context,
                  	  application.version as app_version,
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
                     	get_json_object( event_data, '$.error_severity'),
                   	  get_json_object(event_data, '$.error_context'),
                      application.version,
                      application.business,
                     	usr.uid)
           	) t
          	group by  date_only,
          	          hour_only,
                    	platform, severity ,
                    	context,
                    	app_version,
                    	business
       )t1
   group by  date_only, hour_only, platform, context,  app_version, business

 ) numerador

right outer join (

   select
        v.date_only as date_only,
        v.hour_only as hour_only,
       	v.platform as platform,
       	v.context as context,
       	v.app_version as app_version,
        v.business as business,
       	count( v.uid ) as uu_per_hour,
      	sum (v.screenviews_per_uid) as screenviews_per_hour
   from(
         	select substr(ds, 1, 10)   as date_only,
  	      substr(ds, 12, 13)   as hour_only,
         	regexp_extract(device.platform, '^\/mobile\/(android|ios)$') as platform,
        	application.view_context as context,
          application.version as app_version,
          application.business,
         	usr.uid as uid,
         	count( 1 ) as screenviews_per_uid
  	from tracks
      WHERE
          ds >= '@param01' and ds < '@param02'
    	    AND type = 'view'
  	group by substr(ds, 1, 10),
  	      substr(ds, 12, 13),
        	regexp_extract(device.platform, '^\/mobile\/(android|ios)$'),
        	application.view_context,
        	application.version,
       	  application.business,
        	usr.uid

  	) v
   group by date_only, hour_only, platform,  context,  app_version, business

 ) denominador
on (
	  denominador.date_only = numerador.date_only
	  and denominador.hour_only = numerador.hour_only
  	and numerador.platform	= denominador.platform
    and numerador.context     = denominador.context
   	and numerador.app_version = denominador.app_version
    and numerador.business  = denominador.business
)
