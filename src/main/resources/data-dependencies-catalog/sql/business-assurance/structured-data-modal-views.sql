SELECT CASE WHEN path LIKE '%list%' THEN 'LIST'
            WHEN path LIKE '%update%' THEN 'UPDATE'
            WHEN path LIKE '%catalogwidget%' THEN 'WIDGET'
        END AS source,
       jet(event_data,'empty_attrs_pk') as empty_attrs_pk,
       jet(event_data,'empty_attrs_not_pk') as empty_attrs_not_pk,
       jet(event_data,'domain_id') AS dominio,
       jet(event_data,'category_id') AS categoria,
       usr.user_id AS seller,
       jet(event_data,'condition') AS condicion,
       application.site_id AS site,
       substr(ds,1,10) as ds
FROM tracks
WHERE ds >= '@param01'
AND   ds < '@param02'
AND   path IN ('/sell/list/modal_attributes', '/sell/update/modal_attributes', '/catalogwidget/omit_attributes')