SELECT substr(ds,1,10) as ds,
       'LIST' AS source,
       get_json_object(event_data,'domain_id') AS dominio,
       get_json_object(event_data,'attribute_id') AS atributo,
       get_json_object(event_data,'option_selected') AS opcion,
       get_json_object(event_data,'value') AS valor,
       get_json_object(event_data,'item_id') AS item,
       usr.user_id AS seller,
       get_json_object(event_data,'condition') AS condicion
FROM tracks
WHERE ds >= '@param01'
AND   ds < '@param02'
AND   path = '/sell/list/modal_attributes/submit'
UNION
SELECT substr(ds,1,10) as ds,
       'UPDATE' AS source,
       get_json_object(event_data,'domain_id') AS dominio,
       get_json_object(event_data,'attribute_id') AS atributo,
       get_json_object(event_data,'option_selected') AS opcion,
       get_json_object(event_data,'value') AS valor,
       get_json_object(event_data,'item_id') AS item,
       usr.user_id AS seller,
       get_json_object(event_data,'condition') AS condicion
FROM tracks
WHERE ds >= '@param01'
AND   ds < '@param02'
AND   path = '/sell/update/modal_attributes/submit'
ORDER BY source, dominio, atributo
