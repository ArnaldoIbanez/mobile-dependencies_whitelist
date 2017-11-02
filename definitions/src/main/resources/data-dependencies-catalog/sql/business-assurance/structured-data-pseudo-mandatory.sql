SELECT substr(ds,1,10) as ds,
       'LIST' AS source,
       jet(event_data,'domain_id') AS dominio,
       jet(event_data,'attribute_id') AS atributo,
       jet(event_data,'option_selected') AS opcion,
       jet(event_data,'value') AS valor,
       usr.user_id AS seller,
       jet(event_data,'item_id') AS item,
       jet(event_data,'condition') AS condicion
FROM tracks
WHERE ds >= '@param01'
AND   ds < '@param02'
AND   path = '/sell/list/modal_attributes/submit'
UNION
SELECT substr(ds,1,10) as ds,
       'UPDATE' AS source,
       jet(event_data,'domain_id') AS dominio,
       jet(event_data,'attribute_id') AS atributo,
       jet(event_data,'option_selected') AS opcion,
       jet(event_data,'value') AS valor,
       usr.user_id AS seller,
       jet(event_data,'item_id') AS item,
       jet(event_data,'condition') AS condicion
FROM tracks
WHERE ds >= '@param01'
AND   ds < '@param02'
AND   path = '/sell/update/modal_attributes/submit'
ORDER BY source, dominio, atributo
