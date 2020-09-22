select
	site,
	bu,
	app_version,
	platform,
	payment_channel,
	referred,
	Flow_Amount_LC_Ini,
	Flow_Amount_LC_CR,
	Flow_Amount_LC_Congrats,
	Flow_Amount_LC_Ini / cast(c.cco_tc_value as decimal(10,3)) as Flow_Amount_Ini,
	Flow_Amount_LC_CR / cast(c.cco_tc_value as decimal(10,3)) as Flow_Amount_CR,
	Flow_Amount_LC_Congrats / cast(c.cco_tc_value as decimal(10,3)) as Flow_Amount_Congrats,
	time_ini_cr,
	time_cr_con, 
	time_ini_con,
	UID_Init,
	UID_Card_Reader,
	UID_Congrats,
	Sessions_Init,
	Sessions_Card_Reader,
	Sessions_Congrats,
	fecha
from (
	select
		fecha,
		site,
		bu,
		app_version,
		platform,
		payment_channel,
		referred,
		SUM(Flow_Amount_LC_Ini) as Flow_Amount_LC_Ini,
		SUM(Flow_Amount_LC_CR) as Flow_Amount_LC_CR,
		SUM(Flow_Amount_LC_Congrats) as Flow_Amount_LC_Congrats,
		AVG(avg_diff_ini_cr) as time_ini_cr,
		AVG(avg_diff_cr_con) as time_cr_con, 
		AVG(avg_diff_ini_con) as time_ini_con,
		SUM(UID_Init) as UID_Init,
		SUM(UID_Card_Reader) as UID_Card_Reader,
		SUM(UID_Congrats) as UID_Congrats,
		SUM(Sessions_Init) as Sessions_Init,
		SUM(Sessions_Card_Reader) as Sessions_Card_Reader,
		SUM(Sessions_Congrats) as Sessions_Congrats
	from (	
		select 
			fecha,
			site,
			bu,
			app_version,
			platform,
			payment_channel,
			referred,
			uid,
			SUM(amount_lc_ini) as Flow_Amount_LC_Ini,
			SUM(amount_lc_cr) as Flow_Amount_LC_CR,
			SUM(amount_lc_con) as Flow_Amount_LC_Congrats,
			AVG(diff_ini_cr) as avg_diff_ini_cr,
			AVG(diff_cr_con) as avg_diff_cr_con, 
			AVG(diff_ini_con) as avg_diff_ini_con,
			MAX(Sessions_Init) as UID_Init,
			MAX(Sessions_Card_Reader) as UID_Card_Reader,
			MAX(Sessions_Congrats) as UID_Congrats,
			SUM(Sessions_Init) as Sessions_Init,
			SUM(Sessions_Card_Reader) as Sessions_Card_Reader,
			SUM(Sessions_Congrats) as Sessions_Congrats
		from (
			select
				init.fecha as fecha,
				upper(init.site) as site,
				init.bu as bu,
				init.app_version as app_version,
				init.platform as platform,
				init.amount_lc as amount_lc_ini,
				if(length(cr.transaction_id) > 0, init.amount_lc, 0) as amount_lc_cr,
				if(length(con.transaction_id) > 0, init.amount_lc, 0)as amount_lc_con,
				init.referred as referred,
				init.payment_channel as payment_channel,
				init.uid as uid,
	      (unix_timestamp(cr.user_time) - unix_timestamp(init.user_time)) as diff_ini_cr,
	      (unix_timestamp(con.user_time) - unix_timestamp(cr.user_time)) as diff_cr_con,
	      (unix_timestamp(con.user_time) - unix_timestamp(init.user_time)) as diff_ini_con,
				if(length(init.transaction_id) > 0, 1, 0) as Sessions,
				1 as Sessions_Init,
				if(length(cr.transaction_id) > 0, 1, 0) as Sessions_Card_Reader,
			  if(length(con.transaction_id) > 0, 1, 0) as Sessions_Congrats
			from (
				select
					fecha,
					site,
					bu,
					app_version,
					platform,
					referred,
					payment_channel,
					transaction_id,
					uid,
					Min(user_timestamp) as user_time,
					MAX(amount_lc) as amount_lc
				from (
					select 
						substr(ds,1,10)           as fecha,
					    lower(application.site_id) as site,
					    application.business       as bu,
					    application.version as app_version,
					    if( device.platform = '/mobile/android', 'android', if(device.platform = '/mobile/ios','ios','others')) as platform,
					    get_json_object(event_data,'$.flow_origin') as referred,
					    get_json_object(event_data,'$.payment_channel') as payment_channel,
					    get_json_object(event_data,'$.flow_id') as transaction_id,
					    usr.uid as uid,
					    user_timestamp,
					    cast(jest(event_data,'amount') as decimal(10,3)) as amount_lc
					from tracks
					where ds >= '@param01' and ds < '@param02'
						and device.platform like '/mobile/%'
						and application.business  in ('mercadolibre','mercadopago')
						and path = '/pos_seller/start'
						and get_json_object(event_data,'$.payment_channel') = 'point'
				) a1 
				group by fecha, site, bu, app_version, platform, payment_channel, referred, transaction_id, uid 
			) init
			left join (
			select
				fecha,
				site,
				bu,
				app_version,
				platform,
				transaction_id,
				uid,
				Min(user_timestamp) as user_time
			from (	
				select 
					substr(ds,1,10)           as fecha,
				    lower(application.site_id) as site,
				    application.business       as bu,
				    application.version as app_version,
				    if( device.platform = '/mobile/android', 'android', if(device.platform = '/mobile/ios','ios','others')) as platform,
				    get_json_object(event_data,'$.flow_id') as transaction_id,
				    usr.uid as uid,
				    user_timestamp
				from tracks
				where ds >= '@param01' and ds < '@param02'
					and device.platform like '/mobile/%'
					and application.business  in ('mercadolibre','mercadopago')
					and path = '/pos_seller/point/waiting_for_card'
					and get_json_object(event_data,'$.payment_channel') = 'point'
				)a2
				group by fecha, site, bu, app_version, platform, transaction_id, uid 
			) cr on init.fecha = cr.fecha and init.site = cr.site and init.bu = cr.bu and init.app_version = init.app_version 
			and init.platform = cr.platform and init.uid = cr.uid and init.transaction_id = cr.transaction_id
			left join (
				select
					fecha,
					site,
					bu,
					app_version,
					platform,
					transaction_id,
					uid,
					Min(user_timestamp) as user_time
				from (
					select 
						substr(ds,1,10)           as fecha,
					    lower(application.site_id) as site,
					    application.business       as bu,
					    application.version as app_version,
					    if( device.platform = '/mobile/android', 'android', if(device.platform = '/mobile/ios','ios','others')) as platform,
					    get_json_object(event_data,'$.flow_id') as transaction_id,
					    usr.uid as uid,
					    user_timestamp
					from tracks
					where ds >= '@param01' and ds < '@param02'
						and device.platform like '/mobile/%'
						and application.business  in ('mercadolibre','mercadopago')
						and path = '/pos_seller/end'
						and get_json_object(event_data,'$.payment_channel') = 'point'
				)a3
				group by fecha, site, bu, app_version, platform, transaction_id, uid 
			) con on init.fecha = con.fecha and init.site = con.site and init.bu = con.bu and init.app_version = init.app_version 
			and init.platform = con.platform and init.uid = con.uid and init.transaction_id = con.transaction_id
		group by init.fecha, init.site, init.bu, init.app_version, init.platform, init.amount_lc, init.referred, init.payment_channel, init.uid, init.transaction_id, cr.transaction_id, con.transaction_id, init.user_time, cr.user_time, con.user_time
		) t
		group by fecha, site, bu, app_version, platform, payment_channel, referred, uid
	) t1
	group by fecha, site, bu, app_version, platform, payment_channel,referred
) t2
left join melilake.lk_currency_convertion c on c.tim_day = t2.fecha and c.sit_site_id = t2.site 
