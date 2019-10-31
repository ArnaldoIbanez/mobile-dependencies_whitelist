
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
    when experiments['frontend-core/download-app-banner'] = '3399' then 'Comprá en cualquier momento y lugar'
    when experiments['frontend-core/download-app-banner'] = '3412' then 'Millones de marcas en tu bolsillo'
    when experiments['frontend-core/download-app-banner'] = '3413' then 'Comprá fácil y rápido'
    when experiments['frontend-core/download-app-banner'] = '3414' then 'Entérate de novedades y promociones'
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
    and experiments['frontend-core/download-app-banner'] in ('3399', '3412', '3413', '3414')
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
  when label = '3399' then 'Comprá en cualquier momento y lugar'
  when label = '3412' then 'Millones de marcas en tu bolsillo'
  when label = '3413' then 'Comprá fácil y rápido'
  when label = '3414' then 'Entérate de novedades y promociones'
  else 'ninguna' end as Variante,
  substr(installedat, 1, 10) as Ds
  from melilake.bt_adjust
  where tracker = 'dqndy0v'
  and trim(label) <> ''
  and activitykind = 'install'
  and installedat >= '@param01'
  and installedat < '@param02'
  and country in ('cl', 'mx', 'br', 'ar', 'uy', 'pe', 'co')
  and label in ('3399', '3412', '3413', '3414')
  ) p
group by SiteId, Device, Variante, Ds

) install on install.SiteId = banner.SiteId and install.Variante = banner.Variante and install.Device = banner.Device and install.Ds = banner.Ds
order by SiteId desc, Tipo desc, Device desc, Installs desc





