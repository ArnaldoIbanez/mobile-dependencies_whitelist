SELECT * from (
  SELECT 
    CASE WHEN (substr(device.user_agent, 1, 13) = 'MercadoLibre-') THEN IF((substr(device.user_agent, 14, 3) = 'iOS'), '/mobile/ios', '/mobile/android') ELSE device.platform END AS platform,
    application.site_id as site_id, 
    usr.user_id as user_id, 
    jest(event_data, 'returns_loyalty_level') as loyalty_level, 
    jest(event_data, 'returns_cart_order') as is_cart_order, 
    jest(event_data, 'returns_item_category') as item_category, 
    jest(event_data, 'returns_item_category_l1') as item_category_l1,
    substr(ds,1,10) as fecha
  FROM default.tracks 
  WHERE ds >= '@param01' 
  AND ds < '@param02' 
  AND path = '/claims/create_claim/allow' 
  AND application.site_id IN ('MLM', 'MLB', 'MLA') 
  AND type = 'view' 
  AND jest(event_data, 'ref') = 'returns_gtc_myml_nc') RS
GROUP BY
fecha, 
platform, 
user_id, 
item_category,
item_category_l1,
site_id,
loyalty_level,
is_cart_order