SELECT COUNT(DISTINCT t1.usr.user_id) as Quantity
, t1.application.site_id as Site_id
, jest(t1.event_data, 'row_id') as Row_id
, jest(t1.event_data, 'section_id') as Section_id
, (CASE WHEN jest(t1.event_data, 'from') LIKE '' AND jest(t1.event_data, 'to') LIKE 'AMC' THEN '-AMC'
    WHEN jest(t1.event_data, 'from') <> 'AMC' AND jest(t1.event_data, 'from') <> ''  AND jest(t1.event_data, 'to') LIKE 'AMC' THEN 'TDC-AMC'
    WHEN jest(t1.event_data, 'from') LIKE ''  AND jest(t1.event_data, 'to') <> 'AMC' THEN '-TDC'
    WHEN jest(t1.event_data, 'from') LIKE 'AMC' AND jest(t1.event_data, 'to') <> 'AMC' THEN 'AMC-TDC'
    WHEN jest(t1.event_data, 'from') LIKE 'DEFAULT' AND jest(t1.event_data, 'to') LIKE 'THERMAL' THEN 'DEFAULT-THERMAL'
    WHEN jest(t1.event_data, 'from') LIKE 'THERMAL' AND jest(t1.event_data, 'to') LIKE 'DEFAULT' THEN 'THERMAL-DEFAULT'
    WHEN jest(t1.event_data, 'from') LIKE 'add_fiscal_data' AND jest(t1.event_data, 'to') LIKE 'use_myml_invoices' THEN 'FISCAL-MYML'
    WHEN jest(t1.event_data, 'from') LIKE 'use_myml_invoices' AND jest(t1.event_data, 'to') LIKE 'add_fiscal_data' THEN 'FISCAL-MYML'
    ELSE 'NOT_UPDATE' END) AS Action_id
, substr(t1.ds, 1, 10) AS ds
FROM tracks AS t1
WHERE t1.ds >= '@param01'
    AND t1.ds < '@param02'
    AND path = '/seller_central/settings/update_row'
GROUP BY t1.application.site_id
, jest(t1.event_data, 'row_id')
, jest(t1.event_data, 'section_id')
, CASE WHEN jest(t1.event_data, 'from') LIKE '' AND jest(t1.event_data, 'to') LIKE 'AMC' THEN '-AMC'
    WHEN jest(t1.event_data, 'from') <> 'AMC' AND jest(t1.event_data, 'from') <> ''  AND jest(t1.event_data, 'to') LIKE 'AMC' THEN 'TDC-AMC'
    WHEN jest(t1.event_data, 'from') LIKE ''  AND jest(t1.event_data, 'to') <> 'AMC' THEN '-TDC'
    WHEN jest(t1.event_data, 'from') LIKE 'AMC' AND jest(t1.event_data, 'to') <> 'AMC' THEN 'AMC-TDC'
    WHEN jest(t1.event_data, 'from') LIKE 'DEFAULT' AND jest(t1.event_data, 'to') LIKE 'THERMAL' THEN 'DEFAULT-THERMAL'
    WHEN jest(t1.event_data, 'from') LIKE 'THERMAL' AND jest(t1.event_data, 'to') LIKE 'DEFAULT' THEN 'THERMAL-DEFAULT'
    WHEN jest(t1.event_data, 'from') LIKE 'add_fiscal_data' AND jest(t1.event_data, 'to') LIKE 'use_myml_invoices' THEN 'FISCAL-MYML'
    WHEN jest(t1.event_data, 'from') LIKE 'use_myml_invoices' AND jest(t1.event_data, 'to') LIKE 'add_fiscal_data' THEN 'FISCAL-MYML'
    ELSE 'NOT_UPDATE' END
, substr(t1.ds, 1, 10)