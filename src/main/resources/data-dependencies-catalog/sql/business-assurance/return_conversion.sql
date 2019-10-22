SELECT DEVOLUCION.Item as Item_id, DEVOLUCION.category_id AS Category_id,DEVOLUCION.Vip AS Visitas_Con_Devo, DEVOLUCION.Congrats AS Compras_Con_Devo,  SIN_DEVO.Vip AS Visitas_Sin_Devo, SIN_DEVO.Congrats AS Compras_Sin_Devo, DEVOLUCION.fecha as Fecha
FROM 
  (SELECT vipR.item AS Item, vipR.category_id as category_id, count(vipR.uid) AS Vip, count(cho.uid) AS Congrats, vipR.fecha AS fecha
    FROM
    (SELECT jest(event_data, 'item_id') AS item, usr.uid AS uid, substr(ds,1,10) AS fecha, jest(event_data, 'category_id') as category_id
      FROM tracks 
      WHERE 
        path = '/vip' 
        AND (application.site_id = 'MLB' OR application.site_id = 'MLM')
        AND ds >= '@param01' AND ds < '@param02'
        AND jest(event_data, 'return_available') = 'Yes'
        AND usr.user_id != ''AND usr.user_id != '0' AND usr.user_nick != '' AND usr.user_nick != '0'
        AND NOT is_bot(device.user_agent)
      GROUP BY jest(event_data, 'item_id'), usr.uid, substr(ds,1,10), jest(event_data, 'category_id')) AS vipR
    LEFT JOIN
    (SELECT jest(event_data, 'items[0].item.id') AS item, usr.uid AS uid, substr(ds,1,10) as fecha
      FROM tracks 
      WHERE
        path = '/orders/ordercreated'
        AND ds >= '@param01' AND ds < '@param02'
        AND NOT is_bot(device.user_agent)
    GROUP BY jest(event_data, 'items[0].item.id'), usr.uid, substr(ds,1,10)) AS cho
  ON vipR.item = cho.item AND vipR.uid = cho.uid AND vipR.fecha = cho.fecha
  GROUP BY vipR.item, vipR.fecha, vipR.category_id) AS DEVOLUCION
INNER JOIN
(SELECT vipR_sin.item AS Item, count(vipR_sin.uid) AS Vip, count(cho_sin.uid) AS Congrats, vipR_sin.fecha AS fecha
  FROM
    (SELECT jest(event_data, 'item_id') AS item, usr.uid AS uid, substr(ds,1,10) AS fecha
    FROM tracks 
    WHERE 
      path = '/vip' 
      AND (application.site_id = 'MLB' OR application.site_id = 'MLM')
      AND ds >= '@param01' AND ds < '@param02'
      AND jest(event_data, 'return_available') = 'No'
      AND usr.user_id != '' AND usr.user_id != '0' AND usr.user_nick != '' AND usr.user_nick != '0'
      AND NOT is_bot(device.user_agent)
    GROUP BY jest(event_data, 'item_id'), usr.uid, substr(ds,1,10)) AS vipR_sin
  LEFT JOIN
  (SELECT jest(event_data, 'items[0].item.id') AS item, usr.uid AS uid, substr(ds,1,10) AS fecha
    FROM tracks 
    WHERE
      path = '/orders/ordercreated'
      AND ds >= '@param01' AND ds < '@param02'
      AND NOT is_bot(device.user_agent)
    GROUP BY jest(event_data, 'items[0].item.id'), usr.uid, substr(ds,1,10)) AS cho_sin
    ON vipR_sin.item = cho_sin.item AND vipR_sin.uid = cho_sin.uid AND vipR_sin.fecha = cho_sin.fecha
GROUP BY vipR_sin.item, vipR_sin.fecha) AS SIN_DEVO
ON DEVOLUCION.item = SIN_DEVO.item AND DEVOLUCION.fecha = SIN_DEVO.fecha