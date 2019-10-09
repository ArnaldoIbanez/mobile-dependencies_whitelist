SELECT tracks.path as path,
application.site_id as siteId,
jest(event_data,'category_domain') as domainId,
jest(event_data,'catalog_product_id') as catalogProductId,
jest(event_data,'new_competition_status') as newCompetitionStatus,
jest(event_data,'competition_status') as competitionStatus,
jest(event_data,'to') as newValue,
jest(event_data,'from') as oldValue,
jest(event_data,'listing_type') as listingType,
jest(event_data,'shipping_local_pickup') as shippingLocalPickup,
jest(event_data,'seller_profile') as sellerProfile,
jest(event_data,'item_id') as itemId,
usr.user_nick as userNick,
jest(event_data,'winner_item_id') as winnerItemId,
jest(event_data,'price_to_win') as priceToWin,
jest(event_data,'session_id') as sessionId,
substr(ds,1,10) as ds
FROM tracks
WHERE (tracks.path = '/seller_central/modify/detail' OR tracks.path LIKE '/seller_central/modify/update_%')
AND jest(event_data,'item_type') = 'product'
AND ds >= '@param01' AND ds < '@param02'
AND application.business='mercadolibre'
AND usr.user_nick NOT LIKE 'TETE%'
AND usr.user_nick NOT LIKE '%TEST%'