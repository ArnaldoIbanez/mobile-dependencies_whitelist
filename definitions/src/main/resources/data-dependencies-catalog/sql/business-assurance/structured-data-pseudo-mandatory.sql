SELECT substr(ds,1,10) as ds,
       CASE WHEN path LIKE '%list%' THEN 'LIST'
            WHEN path LIKE '%update%' THEN 'UPDATE'
            WHEN path LIKE '%catalogwidget%' THEN 'WIDGET'
        END AS source,
       jet(event_data,'domain_id') AS dominio,
       jet(event_data,'category_id') AS categoria,
       jet(event_data,'attribute_id') AS atributo,
       jet(event_data,'option_selected') AS opcion,
       jet(event_data,'value') AS valor,
       usr.user_id AS seller,
       jet(event_data,'item_id') AS item,
       jet(event_data,'condition') AS condicion,
       jet(event_data,'hierarchy') AS hierarchy,
       application.site_id AS site
FROM tracks
WHERE ds >= '@param01'
AND   ds < '@param02'
AND   path IN ('/sell/list/modal_attributes/submit', '/sell/update/modal_attributes/submit', '/catalogwidget/omit_attributes/submit')
ORDER BY source, dominio, atributo
