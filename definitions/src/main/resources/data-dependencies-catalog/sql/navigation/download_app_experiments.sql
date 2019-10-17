
select 
  banner.SiteId,
  banner.Tipo,
  banner.Device,
  banner.Variante,
  banner.Cantidad,
  banner.Users,
  install.Installs,
  banner.Ds

from (
  select SiteId, 
  Tipo, 
  Device, 
  Variante, 
  Ds,
  count(distinct UserId) as Users,
  count(*) as Cantidad
  from (
    select application.site_id as SiteId,
    case
    when path = '/navigation/download-app/download'  then 'Descarga'
    when path = '/navigation/download-app/show'  then 'Show'
    when path = '/navigation/download-app/close'  then 'Close'
    else 'None' end as Tipo,
    device.vendor as Device,
    case
    when experiments['frontend-core/download-app-banner'] = '3259' then 'Blanco - Amarillo'
    when experiments['frontend-core/download-app-banner'] = '3260' then 'Negro - Azul'
    when experiments['frontend-core/download-app-banner'] = '3261' then 'Blanco - Azul'
    when experiments['frontend-core/download-app-banner'] = '3262' then 'Nergo - Amarillo'
    else 'ninguna' end as Variante,
    substr(ds, 1, 10) as Ds,
    usr.uid as UserId
    from tracks 
    where ds >= '@param01'
    and ds < '@param02'
    and path in  ('/navigation/download-app/download', '/navigation/download-app/show', '/navigation/download-app/close')
    AND NOT is_bot(device.user_agent)
    and device.platform in ('/web/mobile')
    and application.site_id in ('MLA', 'MLB', 'MLC', 'MLM', 'MLU', 'MPE', 'MCO')
    and experiments['frontend-core/download-app-banner'] in ('3259', '3260', '3261', '3262')
  ) t
  group by SiteId,Tipo,Device,Variante,Ds

) banner

left join (
  select SiteId, 
  Device, 
  Variante, 
  Ds,
  count(*) as Installs
  from (
  select 
  case
  when country = 'cl' then 'MLC'
  when country = 'mx' then 'MLM'
  when country = 'ar' then 'MLA'
  when country = 'br' then 'MLB'
  when country = 'uy' then 'MLU'
  when country = 'co' then 'MCO'
  when country = 'pe' then 'MPE'
  else 'ninguna' end as SiteId,
  case
  when osname = 'ios' then 'apple'
  when osname = 'android' then 'android'
  else 'ninguna' end as Device, 
  case
  when label = '3259' then 'Blanco - Amarillo'
  when label = '3260' then 'Negro - Azul'
  when label = '3261' then 'Blanco - Azul'
  when label = '3262' then 'Nergo - Amarillo'
  else 'ninguna' end as Variante,
  substr(installedat, 1, 10) as Ds
  from melilake.bt_adjust 
  where tracker = 'dqndy0v'
  and trim(label) <> ''
  and activitykind = 'install'
  and installedat >= '@param01'
  and installedat < '@param02'
  and country in ('cl', 'mx', 'br', 'ar', 'uy', 'pe', 'co')
  and label in ('3259', '3260', '3261', '3262')
  ) p
group by SiteId, Device, Variante, Ds

) install on install.SiteId = banner.SiteId and install.Variante = banner.Variante and install.Device = banner.Device and install.Ds = banner.Ds
order by SiteId desc, Tipo desc, Device desc, Installs desc 





