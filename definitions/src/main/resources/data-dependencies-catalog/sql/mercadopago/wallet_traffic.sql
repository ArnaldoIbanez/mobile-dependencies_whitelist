select 
	uid.site as site,
	uid.bu as bu,
	uid.app_version as app_version,
	uid.platform as platform,
	uid.flow as flow,
	uid.Init_UID as Init_UID,
	uid.Congrats_UID_Success as Congrats_UID_Success,
	uid.Congrats_UID_Rejected as Congrats_UID_Rejected,
	session.Init_Session as Init_Session,
	session.Congrats_Session_Success as Congrats_Session_Success,
	session.Congrats_Session_Rejected as Congrats_Session_Rejected,
	uid.fecha as fecha
from (
	select 
		fecha,
		site,
		bu,
		app_version,
		platform,
		flow,
		SUM(Init) as Init_UID,
		SUM(Congrats_Success) as Congrats_UID_Success,
		SUM(Congrats_Rejected) as Congrats_UID_Rejected
	from (
		select
			t_init.fecha as fecha,
			upper(t_init.site) as site,
			t_init.bu as bu,
			t_init.app_version as app_version,
			t_init.platform as platform,
			t_init.flow as flow,
			t_init.uid as uid_init,
			IF(SUM(if(length(t_init.uid) > 0, 1, 0)) > 0, 1, 0)     AS Init,
			IF(SUM(if(t_congrat.status = 2, 1, 0)) > 0, 1, 0) As Congrats_Success,
			IF(SUM(if(t_congrat.status = 1, 1, 0)) > 0, 1, 0) As Congrats_Rejected
		from (
		select 
			substr(ds,1,10)           as fecha,
		    lower(application.site_id) as site,
		    application.business       as bu,
		    application.version as app_version,
		    if( device.platform = '/mobile/android', 'android', if(device.platform = '/mobile/ios','ios','other')) as platform,
		    case path
		    	when '/pos_seller/start'  then 'point'
		      	when '/instore/scan_qr' then 'qr'
		      	when '/cellphone_recharge/recents'  then 'cellphone_recharge'
		      	when '/bill_payments/scan' then 'services'
		      	when '/recharge_sube/select_recharge_card' then 'transport'
		      	when '/mplayer/send_money/contact_picker' then 'money_transfer'
		    end as flow, 
		    usr.uid as uid
		from tracks 
		where ds >= '@param01' and ds < '@param02'
			and device.platform like '/mobile/%'
			and application.business  in ('mercadolibre','mercadopago')
			and path in ('/pos_seller/start','/instore/scan_qr','/cellphone_recharge/recents','/bill_payments/scan','/recharge_sube/select_recharge_card','/mplayer/send_money/contact_picker')
		) t_init
		left join (
				select 
					fecha,
					site,
					bu,
					app_version,
					platform,
					flow,
					uid,
					MAX(status) as status
				from (
				select 
					substr(ds,1,10)           as fecha,
				    lower(application.site_id) as site,
				    application.business       as bu,
				    application.version as app_version,
				    if( device.platform = '/mobile/android', 'android', if(device.platform = '/mobile/ios','ios','other')) as platform,
				    case 
				    	when path = '/pos_seller/end'  then 'point'
						when jest(event_data,'flow') = '/instore' then 'qr'
						when jest(event_data,'flow') = 'cellphone_recharge'  then 'cellphone_recharge'
						when jest(event_data,'flow') = 'services' then 'services'
						when jest(event_data,'flow') = 'transport' then 'transport'
						when jest(event_data,'flow') = 'money_transfer' then 'money_transfer'
					end as flow, 
					case 
					    	when path = '/pos_seller/end'  then 2
							when path like '/px_checkout/result/success%' then 2
							else 1
						end as status,
					usr.uid as uid
				from tracks 
				where ds >= '@param01' and ds < '@param02'
					and device.platform like '/mobile/%'
					and application.business  in ('mercadolibre','mercadopago')
					and (path = '/pos_seller/end' or (path like '/px_checkout/result/%' and jest(event_data,'flow') in ('/instore','cellphone_recharge','transport','services','money_transfer')))
				) t_base
				group by fecha, site, bu, app_version, platform, flow, uid
			) t_congrat on t_congrat.fecha = t_init.fecha and t_congrat.site = t_init.site and t_congrat.bu = t_init.bu and t_congrat.app_version =t_init.app_version and t_init.flow=t_congrat.flow and t_congrat.uid = t_init.uid
		group by t_init.fecha, t_init.site, t_init.bu, t_init.flow, t_init.platform, t_init.app_version, t_init.uid
	) t
	group by fecha, site, bu, app_version, platform, flow
) uid 

left join (
	select 
		fecha,
		site,
		bu,
		app_version,
		platform,
		flow,
		SUM(Init) as Init_Session,
		SUM(Congrats_Success) as Congrats_Session_Success,
		SUM(Congrats_Rejected) as Congrats_Session_Rejected
	from (
		select
			t_init.fecha as fecha,
			upper(t_init.site) as site,
			t_init.bu as bu,
			t_init.app_version as app_version,
			t_init.platform as platform,
			t_init.flow as flow,
			t_init.session_id as session_id,
			IF(SUM(if(length(t_init.session_id) > 0, 1, 0)) > 0, 1, 0)     AS Init,
			IF(SUM(if(t_congrat.status = 2, 1, 0)) > 0, 1, 0) As Congrats_Success,
			IF(SUM(if(t_congrat.status = 1, 1, 0)) > 0, 1, 0) As Congrats_Rejected
		from (
		select 
			substr(ds,1,10)           as fecha,
		    lower(application.site_id) as site,
		    application.business       as bu,
		    application.version as app_version,
		    if( device.platform = '/mobile/android', 'android', if(device.platform = '/mobile/ios','ios','other')) as platform,
		    case path
		    	when '/pos_seller/start'  then 'point'
		      	when '/instore/scan_qr' then 'qr'
		      	when '/cellphone_recharge/recents'  then 'cellphone_recharge'
		      	when '/bill_payments/scan' then 'services'
		      	when '/recharge_sube/select_recharge_card' then 'transport'
		      	when '/mplayer/send_money/contact_picker' then 'money_transfer'
		    end as flow, 
		    case path
	      		when '/pos_seller/start' then jest(event_data,'flow_id')
	      		when '/instore/scan_qr' then jest(event_data,'session_id')
	      		when '/cellphone_recharge/recents'  then jest(event_data,'session_id')
		      	when '/bill_payments/scan' then jest(event_data,'session_id')
		      	when '/recharge_sube/select_recharge_card' then jest(event_data,'session_id')
		      	when '/mplayer/send_money/contact_picker' then jest(event_data,'session_id')
	      end as session_id
		from tracks 
		where ds >= '@param01' and ds < '@param02'
			and device.platform like '/mobile/%'
			and application.business  in ('mercadolibre','mercadopago')
			and path in ('/pos_seller/start','/instore/scan_qr','/cellphone_recharge/recents','/bill_payments/scan','/recharge_sube/select_recharge_card','/mplayer/send_money/contact_picker')
		) t_init

		left join (
			select
				fecha,
				site,
				bu,
				app_version,
				platform,
				flow,
				session_id,
				MAX(status) as status	
			from(
				select 
					substr(ds,1,10)           as fecha,
				    lower(application.site_id) as site,
				    application.business       as bu,
				    application.version as app_version,
				    if( device.platform = '/mobile/android', 'android', if(device.platform = '/mobile/ios','ios','other')) as platform,
				    case 
				    	when path = '/pos_seller/end'  then 'point'
						when jest(event_data,'flow') = '/instore' then 'qr'
						when jest(event_data,'flow') = 'cellphone_recharge'  then 'cellphone_recharge'
						when jest(event_data,'flow') = 'services' then 'services'
						when jest(event_data,'flow') = 'transport' then 'transport'
						when jest(event_data,'flow') = 'money_transfer' then 'money_transfer'
					end as flow, 
					case 
				    	when path = '/pos_seller/end'  then 2
						when path like '/px_checkout/result/success%' then 2
						else 1
					end as status,
					case 
				    	when path = '/pos_seller/end'  then jest(event_data,'flow_id')
						when jest(event_data,'flow') = '/instore' then coalesce(jest(event_data,'flow_detail.session_id'),jest(event_data,'session_id'))
						when jest(event_data,'flow') = 'cellphone_recharge'  then coalesce(jest(event_data,'flow_detail.session_id'),jest(event_data,'session_id'))
						when jest(event_data,'flow') = 'services' then coalesce(jest(event_data,'flow_detail.session_id'),jest(event_data,'session_id'))
						when jest(event_data,'flow') = 'transport' then coalesce(jest(event_data,'flow_detail.session_id'),jest(event_data,'session_id'))
						when jest(event_data,'flow') = 'money_transfer' then coalesce(jest(event_data,'flow_detail.session_id'),jest(event_data,'session_id'))
					end as session_id
				from tracks 
				where ds >= '@param01' and ds < '@param02'
					and device.platform like '/mobile/%'
					and application.business  in ('mercadolibre','mercadopago')
					and (path = '/pos_seller/end' or (path like '/px_checkout/result/%' and jest(event_data,'flow') in ('/instore','cellphone_recharge','transport','services','money_transfer')))
			) t_base
			group by fecha, site, bu, app_version, platform, flow, session_id
		) t_congrat on t_congrat.fecha = t_init.fecha and t_congrat.site = t_init.site and t_congrat.bu = t_init.bu and t_congrat.app_version =t_init.app_version and t_init.flow=t_congrat.flow and t_congrat.session_id = t_init.session_id
		group by t_init.fecha, t_init.site, t_init.bu, t_init.flow, t_init.platform, t_init.app_version, t_init.session_id
	) t
	group by fecha, site, bu, app_version, platform, flow
) session 
on uid.fecha = session.fecha and uid.site = session.site and uid.bu = session.bu and uid.app_version = session.app_version and uid.platform = session.platform and uid.flow = session.flow
