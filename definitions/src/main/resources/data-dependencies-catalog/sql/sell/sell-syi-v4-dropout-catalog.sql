SELECT get_json_object(list, '$.id') AS attribute
     , get_json_object(list, '$.value_id') AS value_id
     , get_json_object(list, '$.value_name') AS value_name
     , CASE (WHEN get_json_object(list, '$.value_id') IS NOT NULL AND get_json_object(list, '$.value_id') <> 'OTHERS' THEN 'attribute'
             WHEN get_json_object(list, '$.value_id') = 'OTHERS' OR get_json_object(list, '$.value_name') IS NOT NULL THEN 'custom_attribute'
       END) AS attribute_type
     , jet(event_data, 'parent_product_id') AS parent_product_id
     , jet(event_data, 'seller_segment') AS seller_segment
     , jet(event_data, 'category_id') AS category_id
     , jet(event_data, 'domain_id') AS domain_id
     , jet(event_data, 'seller_reputation') AS reputation
     , jet(event_data, 'product_id') AS product_id
     , jet(event_data, 'seller_profile') AS seller_profile
     , jet(event_data, 'title_predicted') AS title_predicted
     , jet(event_data, 'session_id') AS session_id
     , application.site_id AS site_id
     , substr(ds,1,10) as ds
FROM tracks
LATERAL VIEW EXPLODE(json_to_array(jet(event_data, 'attributes_values'))) tf AS list
WHERE ds >= '@param01'
  AND ds < '@param02'
  AND path = '/sell/item_data/category_breadcrumb/update'
  AND application.site_id IN ('MLM', 'MLA', 'MLB')
GROUP BY get_json_object(list, '$.id')
  , get_json_object(list, '$.value_id')
  , get_json_object(list, '$.value_name')
  , CASE (WHEN get_json_object(list, '$.value_id') IS NOT NULL AND get_json_object(list, '$.value_id') <> 'OTHERS' THEN 'attribute'
          WHEN get_json_object(list, '$.value_id') = 'OTHERS' OR get_json_object(list, '$.value_name') IS NOT NULL THEN 'custom_attribute'
    END)
  , jet(event_data, 'parent_product_id')
  , jet(event_data, 'seller_segment')
  , jet(event_data, 'category_id')
  , jet(event_data, 'domain_id')
  , jet(event_data, 'seller_reputation')
  , jet(event_data, 'product_id')
  , jet(event_data, 'seller_profile')
  , jet(event_data, 'title_predicted')
  , jet(event_data, 'session_id') AS session_id
  , application.site_id
  , substr(ds,1,10)