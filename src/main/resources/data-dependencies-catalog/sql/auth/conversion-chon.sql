select
  t1.dia as dia,
  t1.site_id as site_id,
  t1.platform as platform,
  cantidad_ven_login_form,
  cantidad_ya_logueados,
  total,
  cant_auth_success,
  (cantidad_ven_login_form - cant_auth_success) as drops
from ( 
    select 
      substr(ds,1,10) as dia,
      application.site_id as site_id,
      device.platform as platform,
      count(distinct (case when path = '/checkout/login/confirm_not_authenticated' then usr.uid else null end)) as cantidad_ven_login_form,
      count(distinct (case when (path = '/checkout/login/confirm_authenticated' or (device.platform = '/web/mobile' and path = '/checkout/login/confirm') ) then usr.uid else null end)) as cantidad_ya_logueados,
      count(distinct (case when path = '/checkout/login/confirm_not_authenticated' then usr.uid else null end)) 
            + count(distinct (case when (path = '/checkout/login/confirm_authenticated' or (device.platform = '/web/mobile' and path = '/checkout/login/confirm') ) then usr.uid else null end)) as total
    from tracks
    where
      ds >= '@param01 02'
      and ds < '@param02 02'
      and usr.uid is not null
      and path in ('/checkout/login/confirm_not_authenticated','/checkout/login/confirm_authenticated','/checkout/login/confirm')
      and device.platform in ('/web/desktop','/web/mobile')
      and application.business = 'mercadolibre'
      and not(is_bot(device.user_agent))
    group by
      substr(ds,1,10),
      application.site_id,
      device.platform
  ) t1 left outer join (
    select 
      substr(ds,1,10) as dia,
      application.site_id as site_id,
      device.platform as platform,
      count(distinct usr.uid) as cant_auth_success
    from tracks
    where 
      ds >= '@param01 02'
      and ds < '@param02 02'
      and platform.http.http_referer is not null
      and
        (lower(parse_url(platform.http.http_referer, 'HOST')) like '%buyingflow%'
        or lower(parse_url(platform.http.http_referer, 'PATH')) like '%buyingflow%'
        )
      and path = '/login/auth/success'
      and application.business = 'mercadolibre'
      and device.platform in ('/web/mobile', '/web/desktop')
      and not(is_bot(device.user_agent))
    group by
      substr(ds,1,10),
      application.site_id,
      device.platform
  ) t2
  on t1.dia = t2.dia
  and t1.platform = t2.platform
  and t1.site_id = t2.site_id
	
