SELECT count(1) as quantity,
       CASE WHEN path LIKE '%list%' THEN 'LIST'
            WHEN path LIKE '%update%' THEN 'UPDATE'
            WHEN path LIKE '%catalogwidget%' THEN 'WIDGET'
        END AS source,
       jet(event_data,'domain_id') AS dominio,
       jet(event_data,'attribute_id') AS atributo,
       if  (jet(event_data,'condition')='{}','not_specified',jet(event_data,'condition'))  AS condicion,
       jet(event_data,'option_selected') AS opcion,
       jet(event_data,'hierarchy') AS hierarchy,
       application.site_id AS site,
       substr(ds,1,10) as ds
FROM tracks
WHERE ds >= '@param01'
AND   ds < '@param02'
AND   path IN ('/sell/list/modal_attributes/submit', '/sell/update/modal_attributes/submit', '/catalogwidget/omit_attributes/submit')
GROUP BY CASE WHEN path LIKE '%list%' THEN 'LIST'
            WHEN path LIKE '%update%' THEN 'UPDATE'
            WHEN path LIKE '%catalogwidget%' THEN 'WIDGET'
        END,
       jet(event_data,'domain_id'),
       jet(event_data,'attribute_id'),
       jet(event_data,'option_selected'),
       jet(event_data,'condition'),
       jet(event_data,'hierarchy'),
       application.site_id,
       substr(ds,1,10)