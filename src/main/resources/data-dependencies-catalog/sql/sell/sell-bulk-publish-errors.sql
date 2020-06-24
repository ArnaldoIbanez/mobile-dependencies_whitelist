SELECT
  (application.site_id) site_id,
  (cast(get_json_object(listingsNotPublished,'$.categoryId') as string)) category,
  (cast(get_json_object(errors,'$.code') as string)) error_code,
  (sum(cast(get_json_object(errors,'$.occurrences') as int))) quantity,
  substr(ds,1,10) ds
FROM tracks
LATERAL VIEW EXPLODE(json_to_array(jet(event_data, 'listings_not_published'))) tf AS listingsNotPublished
LATERAL VIEW EXPLODE(json_to_array(jet(listingsNotPublished, 'errors'))) t AS errors
WHERE path = '/seller_central/bulk/publish/publish-callback'
AND ds >= '@param01'
AND ds < '@param02'
GROUP BY application.site_id, get_json_object(listingsNotPublished,'$.categoryId'), get_json_object(errors,'$.code'), substr(ds,1,10)
ORDER BY quantity DESC