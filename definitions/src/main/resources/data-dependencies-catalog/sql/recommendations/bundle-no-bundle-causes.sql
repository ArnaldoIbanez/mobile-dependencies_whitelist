SELECT
application.site_id as site_id,
COUNT(1) total_vips,
SUM(CASE WHEN jest(event_data, 'recommendations.track_info.empty_result_cause') = 'EMPTY_MODEL_RESPONSE' THEN 1 ELSE 0 END) EMPTY_MODEL_RESPONSE,
SUM(CASE WHEN jest(event_data, 'recommendations.track_info.empty_result_cause') = 'RECOMMENDATION_SIZE_LOWER_THAN_MINIMUM_REQUIRED' THEN 1 ELSE 0 END) RECOMMENDATION_SIZE_LOWER_THAN_MINIMUM_REQUIRED,
SUM(CASE WHEN jest(event_data, 'recommendations.track_info.empty_result_cause') = 'TIMEOUT' THEN 1 ELSE 0 END) TIMEOUT,
SUM(CASE WHEN jest(event_data, 'recommendations.track_info.empty_result_cause') = 'NO_MATCHING_NGRAMS' THEN 1 ELSE 0 END) NO_MATCHING_NGRAMS,
SUM(CASE WHEN jest(event_data, 'recommendations.track_info.empty_result_cause') = 'NO_ITEMS_FOUND_BY_SEARCH' THEN 1 ELSE 0 END) NO_ITEMS_FOUND_BY_SEARCH,
SUM(CASE WHEN jest(event_data, 'recommendations.track_info.empty_result_cause') = 'NO_ITEMS_FOUND_FOR_SELLER' THEN 1 ELSE 0 END) NO_ITEMS_FOUND_FOR_SELLER,
SUM(CASE WHEN jest(event_data, 'recommendations.track_info.empty_result_cause') = 'NO_ITEMS_FOUND_FOR_STORE' THEN 1 ELSE 0 END) NO_ITEMS_FOUND_FOR_STORE,
SUM(CASE WHEN jest(event_data, 'recommendations.track_info.empty_result_cause') = 'UNKNOWN' THEN 1 ELSE 0 END) UNKNOWN,
SUM(CASE WHEN jest(event_data, 'recommendations.track_info.empty_result_cause') = 'TRIGGER_NOT_CART_ELIGIBLE' THEN 1 ELSE 0 END) TRIGGER_NOT_CART_ELIGIBLE,
SUM(CASE WHEN jest(event_data, 'recommendations.track_info.empty_result_cause') = 'TRIGGER_WITH_VARIATION' THEN 1 ELSE 0 END) TRIGGER_WITH_VARIATION,
SUM(CASE WHEN jest(event_data, 'recommendations.track_info.empty_result_cause') = 'TRIGGER_MIN_PRICE_UNREACHED' THEN 1 ELSE 0 END) TRIGGER_MIN_PRICE_UNREACHED,
SUM(CASE WHEN jest(event_data, 'recommendations.track_info.empty_result_cause') = 'ITEMS_NOT_FIT_ONE_BOX' THEN 1 ELSE 0 END) ITEMS_NOT_FIT_ONE_BOX,
SUM(CASE WHEN jest(event_data, 'recommendations.track_info.empty_result_cause') = 'ITEMS_FIT_ONE_BOX_NO_FS_NO_SAVING' THEN 1 ELSE 0 END) ITEMS_FIT_ONE_BOX_NO_FS_NO_SAVING,
SUM(CASE WHEN jest(event_data, 'recommendations.track_info.empty_result_cause') = 'ITEMS_NOT_ELIGIBLE' THEN 1 ELSE 0 END) ITEMS_NOT_ELIGIBLE,
SUM(CASE WHEN jest(event_data, 'recommendations.track_info.empty_result_cause') = 'NOT_QUALITY_PICTURE' THEN 1 ELSE 0 END) NOT_QUALITY_PICTURE,
substr(ds,1,10) AS ds --> partition column needs to be last column
FROM tracks
WHERE path = '/vip'
and ds >= '@param01'
and ds < '@param02'
and type = 'view'
and application.site_id IN ('MLM','MLB','MLA')
and jest(event_data, 'recommendations.client') = 'vip_combo'
and jest(event_data,'cart_content') = 'true'
and jest(event_data, 'item_status') = 'active'
and jest(event_data, 'buying_mode') = 'buy_it_now'
and jest(event_data, 'shipping_mode') = 'me2'
and jest(event_data, 'recommendations.track_info.has_recommendations') = 'false'
and application.business = 'mercadolibre'
and not is_bot(device.user_agent)
GROUP BY application.site_id, ds
ORDER BY substr(ds,1,10)