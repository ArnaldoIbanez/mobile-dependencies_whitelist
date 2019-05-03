SELECT

(CASE WHEN f.siteId NOT IN ('MLB', 'MLA', 'MLM', 'MLV', 'MLU', 'MLC', 'MPE', 'MCO') THEN 'RESTO' ELSE f.siteId  END) as siteId,
f.domainId as domainId,
(CASE WHEN f.clientId IN (1570, 1572, 1573, 1574, 1575, 1576, 1577, 1578, 1754, 6002, 6009, 6010, 7092, 1505, 6808261514773724, 3376461333454861, 1449998327610753,
5689318823430110, 4060709329251625, 1165691498204664, 3942444344910321, 4954751883138633)
THEN 'SYI' ELSE 'OTROS' END) as client,
f.itemCondition as itemCondition,
COUNT(*) as totalItems,
SUM(CASE WHEN f.warrantyText is null AND f.saleTermValueId is null THEN 1 ELSE 0 END) as SinGarantia,
SUM(CASE WHEN f.warrantyText is not null AND f.saleTermValueId is null THEN 1 ELSE 0 END) as Desestructurada,
SUM(CASE WHEN f.saleTermValueId = 2230279 AND f.saleTermValueName is not null THEN 1 ELSE 0 END) as EstructuradaFabrica,
SUM(CASE WHEN f.saleTermValueId = 2230280 AND f.saleTermValueName is not null THEN 1 ELSE 0 END) as EstructuradaVendedor,
SUM(CASE WHEN f.saleTermValueId = 6150835 AND f.saleTermValueName is null THEN 1 ELSE 0 END) as EstructuradaSinGarantia,
substr(itemLastUpdated, 1, 10) as ds
FROM

(SELECT c.siteId, c.itemId, c.domainId, c.itemCondition, c.warrantyText, c.clientId, c.itemLastUpdated, d.saleTermValueId, d.saleTermValueName
FROM

(SELECT sit_site_id as siteId, ite_item_id as itemId, ite_domain_id as domainId, ite_condition as itemCondition, ite_warranty as warrantyText, mapp_app_id as clientId, ite_last_updated as itemLastUpdated
FROM melilake.lk_ite_items
WHERE ite_buying_mode <> 'classified' AND ite_status = 'active' AND is_test = 'false') c

LEFT JOIN

(SELECT a.siteId, a.itemId, a.saleTermValueId, b.saleTermValueName
FROM
  (SELECT sit_site_id as siteId, ite_item_id as itemId, ite_sale_term_value_id as saleTermValueId
  FROM melilake.lk_ite_sale_term
  WHERE ite_sale_term_id = 'WARRANTY_TYPE' AND is_test = 'false') a
LEFT JOIN
  (SELECT sit_site_id as siteId, ite_item_id as itemId, ite_sale_term_value_name as saleTermValueName
  FROM melilake.lk_ite_sale_term
  WHERE ite_sale_term_id = 'WARRANTY_TIME' AND is_test = 'false') b
ON a.siteId = b.siteId AND a.itemId = b.itemId) d

ON c.siteId = d.siteId AND c.itemId = d.itemId) f
WHERE CAST(itemLastUpdated as string) >= '@param01'
AND CAST(itemLastUpdated as string) < '@param02'

GROUP BY substr(itemLastUpdated, 1, 10), siteId, domainId, clientId, itemCondition
