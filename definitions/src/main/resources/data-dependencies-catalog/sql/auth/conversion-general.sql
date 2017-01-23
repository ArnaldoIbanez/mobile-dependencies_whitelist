select
dia_login_hit,
platform,
site_id,
business,
source,
count(distinct d2id) as c_total,
count(distinct (case when (c_drop_neto > 0 or (c_auth_success_otp_other > 0 and c_auth_success = 0 and c_auth_success_otp_rec = 0 and c_recovery = 0 and c_registration = 0 and c_banner = 0 and c_auth_failure = 0 and c_auth_failure_captcha = 0 and c_auth_failure_captcha_first = 0 )) then d2id else null end)) as c_drops,
count(distinct (case when (c_hits_login > 0 and c_auth_success = 0 and c_auth_success_otp_rec = 0 and c_auth_failure = 0 and c_auth_failure_captcha = 0 and c_auth_failure_captcha_first = 0 and c_recovery > 0 and c_registration = 0 and c_banner = 0) then d2id else null end)) as c_rec_drop,
count(distinct (case when (c_hits_login > 0 and c_auth_success = 0 and c_auth_success_otp_rec = 0 and (c_auth_failure > 0 or c_auth_failure_captcha > 0 or c_auth_failure_captcha_first > 0)) then d2id else null end)) as c_failure_100,
count(distinct (case when (c_hits_login > 0 and c_auth_success > 0 and c_auth_failure = 0 and c_auth_failure_captcha = 0 and c_auth_failure_captcha_first = 0) then d2id else null end)) as c_login_auth_succ_100,
count(distinct (case when (c_hits_login > 0 and c_auth_success > 0 and c_auth_success_otp_rec = 0 and (c_auth_failure_captcha > 0 or c_auth_failure_captcha_first > 0 or c_auth_failure > 0)) then d2id else null end)) as c_login_auth_succ_after_fail,
count(distinct (case when (c_hits_login > 0 and c_auth_success_otp_rec > 0 and c_recovery > 0) then d2id else null end)) as c_login_recovery_succ,
count(distinct (case when (c_hits_login > 0 and c_auth_success_otp_rec > 0 and c_registration = 0 and c_recovery = 0) then d2id else null end)) as c_auth_otp_notrack_rec,
count(distinct (case when (c_hits_login > 0 and (c_banner > 0 or c_registration > 0) and c_auth_success = 0) then d2id else null end)) as c_divert,
count(distinct (case when (c_hits_login > 0 and c_auth_success = 0 and c_auth_success_otp_rec = 0 and c_auth_success_otp_other = 0 and c_auth_failure > 0 and c_auth_failure_captcha = 0 and c_auth_failure_captcha_first = 0 and c_recovery = 0 and c_registration = 0 and c_banner = 0) then d2id else null end)) as c_failure_100_pass,
count(distinct (case when (c_hits_login > 0 and c_auth_success = 0 and c_auth_success_otp_rec = 0 and c_auth_success_otp_other = 0 and c_auth_failure = 0 and (c_auth_failure_captcha > 0 or c_auth_failure_captcha_first > 0) and c_recovery = 0 and c_registration = 0 and c_banner = 0) then d2id else null end)) as c_failure_100_captcha,
count(distinct (case when (c_hits_login > 0 and c_auth_success = 0 and c_auth_success_otp_rec = 0 and c_auth_success_otp_other = 0 and c_auth_failure > 0 and (c_auth_failure_captcha > 0 or c_auth_failure_captcha_first > 0) and c_recovery = 0 and c_registration = 0 and c_banner = 0) then d2id else null end)) as c_failure_100_pass_captcha,
count(distinct (case when (c_hits_login > 0 and c_auth_success = 0 and c_auth_success_otp_rec = 0 and c_auth_success_otp_other = 0 and (c_auth_failure > 0 or c_auth_failure_captcha > 0 or c_auth_failure_captcha_first > 0) and (c_recovery > 0 or c_registration > 0 or c_banner > 0)) then d2id else null end)) as c_failure_100_pass_captcha_drop
from (
	select
	d2id, dia_login_hit, platform, business, site_id,
	case when (path in ('/login/auth/success', '/login/auth/failure') and (instr(lower(parse_url(http_referer, 'HOST')), 'buyingflow') > 0 or instr(lower(parse_url(http_referer, 'PATH')), 'buyingflow') > 0)) then 'CHECKOUT' else source end as source,
	count(distinct (case when path is null then track_id else null end)) as c_drop_neto,
	count(distinct track_id) as c_hits_login,
	count(distinct (case when path = '/login/auth/success' and (get_json_object(event_data, '$.is_otp') = 'false' or get_json_object(event_data, '$.is_otp') is null) then action_track_id else null end)) as c_auth_success,
	count(distinct (case when path = '/login/auth/success' and (get_json_object(event_data, '$.is_otp') = 'true' or get_json_object(event_data, '$.is_otp') is null ) and (get_json_object(event_data, '$.otp_section') <> 'ARF' or get_json_object(event_data, '$.otp_section') is null) then action_track_id else null end)) as c_auth_success_otp_other,
	count(distinct (case when path = '/login/auth/success' and (get_json_object(event_data, '$.is_otp') = 'true' or get_json_object(event_data, '$.is_otp') is null) and (get_json_object(event_data, '$.otp_section') = 'ARF') then action_track_id else null end)) as c_auth_success_otp_rec,
	count(distinct (case when (path = '/login/auth/failure' and get_json_object(get_json_object(event_data, '$.reason'), '$.errorId[0]') != 'captcha_word_required'
	                                                        and get_json_object(get_json_object(event_data, '$.reason'), '$.errorId[0]') != 'captcha_response_invalid') then action_track_id else null end)) as c_auth_failure,
	count(distinct (case when (path = '/login/auth/failure' and get_json_object(get_json_object(event_data, '$.reason'), '$.errorId[0]') = 'captcha_word_required') then action_track_id else null end)) as c_auth_failure_captcha_first,
	count(distinct (case when (path = '/login/auth/failure' and get_json_object(get_json_object(event_data, '$.reason'), '$.errorId[0]') = 'captcha_response_invalid') then action_track_id else null end)) as c_auth_failure_captcha,
	count(distinct (case when path = '/login/recovery' then action_track_id else null end)) as c_recovery,
	count(distinct (case when path = '/login/registration' then action_track_id else null end)) as c_registration,
	count(distinct (case when path = '/login/banner' then action_track_id else null end)) as c_banner,
	count(distinct user_id) as c_accounts
	from
	(
	  select 
	  id as track_id,
	  '@param01' as dia_login_hit,
	  logins.user_timestamp as login_hit_ts,
	  logins.device.platform as platform,
	  get_json_object(logins.event_data, '$.source') as source,
	  application.site_id as site_id,
	  application.business as business,
	  logins.usr.uid as d2id,
	  actions.track_id as action_track_id,
	  actions.user_id,
	  actions.user_nick,
	  actions.path,
	  actions.user_timestamp as action_hit_ts,
	  actions.http_referer as http_referer,
	  actions.event_data  
	  from
	  tracks logins
	  left outer join 
	    (
	      select 
	      id as track_id,
	      path,
	      to_date(user_timestamp) as dia_login_action,
	      user_timestamp as user_timestamp,
	      device.platform as platform,
	      application.site_id as site_id,
	      usr.uid as d2id,
	      usr.user_id,
	      usr.user_nick,
	      event_data as event_data,
	      platform.http.http_referer as http_referer
	      from tracks
	      where
	      ds >= '@param01 02'
	      and ds < '@param02 02'
	      and path <> '/login/form' 
	      and path <> '/login/social/status'
	      and path like '/login%'
	      and path is not null
	      and (get_json_object(event_data, '$.is_admin_otp') = 'false' or get_json_object(event_data, '$.is_admin_otp') is null)
	      and (get_json_object(event_data, '$.flow') is null or get_json_object(event_data, '$.flow') = 'internal')
	      and not is_bot(device.user_agent)
	    ) actions
	  on
	  logins.usr.uid = actions.d2id
	  and to_date(logins.user_timestamp) = actions.dia_login_action
	  and logins.device.platform = actions.platform
	  and logins.application.site_id = actions.site_id
	  where
	  logins.path = '/login/form'
	  and ds >= '@param01 02'
	  and ds < '@param02 02'
	  and (get_json_object(logins.event_data, '$.is_admin_otp') = 'false' or get_json_object(logins.event_data, '$.is_admin_otp') is null)
	  and (logins.user_timestamp <= actions.user_timestamp or actions.user_timestamp is null)
	  and (get_json_object(logins.event_data, '$.flow') is null or get_json_object(logins.event_data, '$.flow') = 'internal')
	  and not is_bot(device.user_agent)
	) t1
	group by 
	d2id, dia_login_hit, platform, site_id, business,
	case when (path in ('/login/auth/success', '/login/auth/failure') and (instr(lower(parse_url(http_referer, 'HOST')), 'buyingflow') > 0 or instr(lower(parse_url(http_referer, 'PATH')), 'buyingflow') > 0)) then 'CHECKOUT' else source end
) t2
where
c_accounts in (0,1)
and lower(source) <> 'checkout'
and platform <> 'unknown'
group by
dia_login_hit,
platform,
site_id,
business,
source
