SELECT count(1) as cantidad,
    case when path = '/seller_central/sales/list/action/primary' then 'CLICK'
        when path = '/seller_central/sales/list' then 'VIEW_LIST'
        when path = '/seller_central/sales/detail' then 'VIEW_DETAIL'
    end as event,
    get_json_object(event_data, '$.id') as id_type,
    platform.fragment as fragment,
    get_json_object(event_data, '$.seller_profile') as seller_profile,
    get_json_object(event_data, '$.seller_reputation') as seller_reputation,
    get_json_object(event_data, '$.mercado_lider') as mercado_lider,
    get_json_object(event_data, '$.seller_segment') as seller_segment,
    get_json_object(event_data, '$.user_type') as user_type,
    application.site_id as site_id,
    substr(ds,1,10) as ds
FROM melidata.tracks_ml
WHERE ds >= '@param01'
AND ds < '@param02'
AND  bu = 'mercadolibre'
AND path in ('/seller_central/sales/list/action/primary', '/seller_central/sales/list', '/seller_central/sales/detail')
GROUP BY
case when path = '/seller_central/sales/list/action/primary' then 'CLICK'
       when path = '/seller_central/sales/list' then 'VIEW_LIST'
       when path = '/seller_central/sales/detail' then 'VIEW_DETAIL'
  end,
 get_json_object(event_data, '$.id'),
  platform.fragment,
  get_json_object(event_data, '$.seller_profile'),
  get_json_object(event_data, '$.seller_reputation'),
  get_json_object(event_data, '$.mercado_lider'),
  get_json_object(event_data, '$.seller_segment'),
  get_json_object(event_data, '$.user_type'),
  substr(ds,1,10),
  application.site_id

