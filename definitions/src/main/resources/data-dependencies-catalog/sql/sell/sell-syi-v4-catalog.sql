SELECT path
     , jet(event_data, 'parent_product_id') AS parent_product_id
     , jet(event_data, 'seller_segment') AS seller_segment
     , jet(event_data, 'category_id') AS category_id
     , jet(event_data, 'domain_id') AS domain_id
     , jet(event_data, 'seller_reputation') AS reputation
     , jet(event_data, 'product_id') AS product_id
     , jet(event_data, 'seller_profile') AS seller_profile
     , jet(event_data, 'title_predicted') AS title_predicted
     , jet(event_data, 'product_title') AS product_title
     , jet(event_data, 'title') AS title
     , jet(event_data, 'flow_decision') AS is_catalog_selected
     , jet(event_data, 'confirm_category_detail') AS is_product_confirm
     , jet(event_data, 'session_id') AS session_id
     , application.site_id AS site_id
     , substr(ds,1,10) as ds
FROM tracks
WHERE ds >= '@param01'
  AND ds < '@param02'
  AND path IN ('/sell/item_data/category/show'
    , '/sell/item_data/flow_decision/show'
    , '/sell/item_data/product_bullet_resume/show'
    , '/sell/item_data/category/confirm'
    , '/sell/item_data/flow_decision/confirm'
    , '/sell/item_conditions'
    , '/sell/congrats')
  AND application.site_id IN ('MLM', 'MLA', 'MLB')
GROUP BY path
  , jet(event_data, 'parent_product_id')
  , jet(event_data, 'seller_segment')
  , jet(event_data, 'category_id')
  , jet(event_data, 'domain_id')
  , jet(event_data, 'seller_reputation')
  , jet(event_data, 'product_id')
  , jet(event_data, 'seller_profile')
  , jet(event_data, 'title_predicted')
  , jet(event_data, 'product_title')
  , jet(event_data, 'title')
  , jet(event_data, 'flow_decision')
  , jet(event_data, 'confirm_category_detail')
  , jet(event_data, 'session_id')
  , application.site_id
  , substr(ds,1,10)