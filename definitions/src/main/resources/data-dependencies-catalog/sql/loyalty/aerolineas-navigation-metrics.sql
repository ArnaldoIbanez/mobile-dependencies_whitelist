select
  prints.platform platform,
  count(prints.user_id) prints,
  count(clicks.user_id) clicks,
  cast(count(clicks.user_id) as double)/cast(count(prints.user_id) as double) click_rate,
  prints.ds ds
from (
  select distinct(usr.user_id) user_id, device.platform platform, substr(ds,1,10) ds
  from tracks
  where path = '/loyalty/landing'
  and ds >= '@param01'
  and ds < '@param02'
  and jest(event_data, 'landing_id') = 'aerolineas'
  and not (usr.user_nick RLIKE '^(TETE|TT|TEST)[0-9]*')
  and type = 'view'
) prints
left join (
  select distinct(usr.user_id) user_id, device.platform platform, substr(ds,1,10) ds
  from tracks
  where path = '/loyalty/landing/aerolineas'
  and ds >= '@param01'
  and ds < '@param02'
  and jest(event_data, 'landing_id') = 'aerolineas'
  and not (usr.user_nick RLIKE '^(TETE|TT|TEST)[0-9]*')
  and type = 'event'
) clicks on prints.user_id = clicks.user_id
group by
  prints.ds, prints.platform
