SELECT tracks.path as path,
application.site_id as siteId,
jest(event_data,'category_domain') as domainId,
jest(event_data,'original_catalog_product_id') as fatherProductId,
jest(event_data,'selected_catalog_product_id') as childProductId,
jest(event_data,'task_id') as taskId,
jest(event_data,'to') as newValue,
jest(event_data,'from') as oldValue,
jest(event_data,'invalid_product_cause') as invalidCause,
jest(event_data,'has_variations') as hasVariations,
jest(event_data,'has_variations_already_opt_in') as hasVariationsOptIn,
jest(event_data,'seller_profile') as sellerProfile,
jest(event_data,'reputation_level') as reputationLevel,
COUNT(DISTINCT tracks.path, jest(event_data,'session_id')) as total,
substr(ds,1,10) as ds
FROM tracks
WHERE tracks.path LIKE '/seller_central/catalog/optin%'
AND ds >= '@param01' AND ds < '@param02'
AND application.business='mercadolibre'
AND usr.user_nick NOT LIKE 'TETE%'
AND usr.user_nick NOT LIKE '%TEST%'
GROUP BY ds,
tracks.path,
application.site_id,
jest(event_data,'category_domain'),
jest(event_data,'original_catalog_product_id'),
jest(event_data,'selected_catalog_product_id'),
jest(event_data,'task_id'),
jest(event_data,'to'),
jest(event_data,'from'),
jest(event_data,'invalid_product_cause'),
jest(event_data,'has_variations'),
jest(event_data,'has_variations_already_opt_in'),
jest(event_data,'seller_profile'),
jest(event_data,'reputation_level')
