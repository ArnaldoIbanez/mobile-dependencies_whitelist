-- Esta query trae (haciendo llega_a_claims - apreto_el_boton) los casos en los que compradores quisieron
-- iniciar una Devolucion Express y no pudieron porque no tenian caps disponibles.
-- Es necesario tener en cuenta que dicha resta debe ser > 0. Esa restriccion no se agrego a la consulta
-- para minimizar la carga de la misma.

SELECT 
  user_id, --ID del buyer
  MAX(llega_a_claims) AS llega_a_claims, -- Cantidad de veces que llego a claims desde Devoluciones Express
  MAX(apreto_el_boton) AS apreto_el_boton, -- Cantidad de veces que presiono el boton "Otro Problema"
  fecha, -- Fecha en formato 2000-12-31
  platform, -- Android, iOS, web mobile o web desktop.
  site, --Site
  MAX(loyalty_level) AS loyalty_level, --Nivel de Mercado Puntos
  MAX(cart_order)  AS is_cart_order, -- True si es una orden de carrito v2.
  MAX(item_category) AS item_category, -- Categoria del item
  MAX(item_category_l1) AS item_category_l1 -- Categoria L1 del item
FROM (
SELECT -- Veces que se llega a claims desde Returns
    substr(ds,1,10) AS fecha,
  	1 AS llega_a_claims,
  	NULL AS apreto_el_boton,
  	device.platform AS platform,
  	application.site_id AS site,
  	usr.user_id AS user_id,
  	substr(jest(event_data, 'loyalty_level'),1,1) AS loyalty_level,
    jest(event_data, 'cart_order') AS cart_order,
    jest(event_data, 'item_category') AS item_category,
    jest(event_data, 'item_category_l1') AS item_category_l1
  FROM tracks t1
  WHERE ds >= '@param01'
  	AND ds < '@param02'
  	AND application.site_id IN ('MLM', 'MLB', 'MLA')
  	AND path IN ('/return/external', '/return/external/claims')
  	AND type = 'view'
  GROUP BY
    usr.user_id,
    substr(ds,1,10), -- Recortamos la fecha al formato deseado
    application.site_id,
  	device.platform,
    t1.event_data -- Traemos todo event_data, de donde tomamos la informacion contextual de la orden.
UNION ALL
  SELECT -- Veces que se presiona el boton de Otro Problema.
    substr(ds,1,10) AS fecha,
  	NULL AS llega_a_claims,
  	1 AS apreto_el_boton,
  	device.platform AS platform,
  	application.site_id AS site,
  	usr.user_id AS user_id,
  	NULL AS loyalty_level,
    NULL AS cart_order,
    NULL AS item_category,
    NULL AS item_category_l1
  FROM tracks t2
  WHERE ds >= '@param01'
  	AND ds < '@param02'
  	AND application.site_id IN ('MLM', 'MLB', 'MLA')
  	AND t2.path = '/return/typifications'
  	AND (jest(t2.event_data, 'typification') IN ('go_to_claim', 'gtc_other_problem', 'other_reaseon_gtc', 'other_reason_gtc') OR jest(t2.event_data, 'dictionary_data.typification') IN ('go_to_claim', 'gtc_other_problem', 'other_reaseon_gtc', 'other_reason_gtc'))
  	
  GROUP BY
    usr.user_id,
    SUBSTR(ds,1,10),
    application.site_id,
  	device.platform
    ) RS -- Armamos este result set para poder unir luego los valores validos de cada row con los MAX()
GROUP BY
  RS.user_id,
  RS.fecha,
  RS.platform,
  RS.site