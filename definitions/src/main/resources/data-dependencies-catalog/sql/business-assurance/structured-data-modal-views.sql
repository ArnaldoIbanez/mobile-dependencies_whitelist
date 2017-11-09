SELECT substr(ds,1,10) as ds,
       CASE WHEN path LIKE '%list%' THEN 'LIST'
            WHEN path LIKE '%update%' THEN 'UPDATE'
        END AS source,
       jet(event_data,'empty_attrs_pk') as empty_attrs_pk,
       jet(event_data,'empty_attrs_not_pk') as empty_attrs_not_pk,
       usr.user_id AS seller,
       jet(event_data,'condition') AS condicion,
       application.site_id AS site
FROM tracks
WHERE ds >= '@param01'
AND   ds < '@param02'
AND   path IN ('/sell/list/modal_attributes', '/sell/update/modal_attributes')
ORDER BY source