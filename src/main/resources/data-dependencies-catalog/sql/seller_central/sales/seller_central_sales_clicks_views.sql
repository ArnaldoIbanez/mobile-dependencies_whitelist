SELECT count(1) as cantidad,
    case when path = '/seller_central/sales/list/action/primary' then 'CLICK'
        when path = '/seller_central/sales/list' then 'VIEW_LIST'
        when path = '/seller_central/sales/detail' then 'VIEW_DETAIL'
    end as event,
    jest(event_data, 'id') as id_type,
    platform.fragment as fragment,
    usr.user_id as user_id,
    jest(event_data, 'seller_profile') as seller_profile,
    jest(event_data, 'seller_reputation') as seller_reputation,
    jest(event_data, 'mercado_lider') as mercado_lider,
    jest(event_data, 'seller_segment') as seller_segment,
    jest(event_data, 'user_type') as user_type,
    substr(ds,1,10) as ds,
    application.site_id as site_id
FROM tracks
WHERE ds >= '@param01'
AND ds < '@param02'
AND path in ('/seller_central/sales/list/action/primary', '/seller_central/sales/list', '/seller_central/sales/detail')
GROUP BY
case when path = '/seller_central/sales/list/action/primary' then 'CLICK'
       when path = '/seller_central/sales/list' then 'VIEW_LIST'
       when path = '/seller_central/sales/detail' then 'VIEW_DETAIL'
  end,
 jest(event_data, 'id'),
  platform.fragment,
  usr.user_id,
  jest(event_data, 'seller_profile'),
  jest(event_data, 'seller_reputation'),
  jest(event_data, 'mercado_lider'),
  jest(event_data, 'seller_segment'),
  jest(event_data, 'user_type'),
  substr(ds,1,10),
  application.site_id

