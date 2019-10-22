SELECT count(1) as quantity,
       CASE WHEN path LIKE '%download%' THEN 'DOWNLOAD'
            WHEN path LIKE '%onboarding%' THEN 'ONBOARDING'
            WHEN path LIKE '%filters%' THEN 'FILTERS'
            WHEN path LIKE '%columns%' THEN 'COLUMNS'
        END AS source,
        jet(event_data,'action') as accion,
        jet(event_data,'columns') as columnas,
        substr(ds,1,10) as ds
FROM tracks
WHERE ds >= '@param01'
AND ds < '@param02'
AND path IN ('/seller_central/bulk/offline/download/error',
  '/seller_central/listings/onboarding/action',
  '/seller_central/listings/filters/action',
  '/seller_central/bulk/columns'
  )
GROUP BY CASE WHEN path LIKE '%download%' THEN 'DOWNLOAD'
            WHEN path LIKE '%onboarding%' THEN 'ONBOARDING'
            WHEN path LIKE '%filters%' THEN 'FILTERS'
            WHEN path LIKE '%columns%' THEN 'COLUMNS'
        END,
        jet(event_data,'action'),
        jet(event_data,'columns'),
        substr(ds,1,10)