WITH attribute_data AS (
  
  SELECT
    categories.sit_site_id as site_id,
    items.ite_domain_id as domain_id,
    attributes.ite_att_attribute_id as attribute_id,
    COUNT(attributes.ite_att_attribute_id) AS total_with_attribute
  
  FROM melilake.lk_ite_items items
    INNER JOIN melilake.lk_ite_item_attribute attributes
      ON items.ite_item_id = attributes.ite_item_id
        AND items.sit_site_id = attributes.sit_site_id
    INNER JOIN melilake.ag_lk_cat_categories_ph categories
      ON items.sit_site_id = categories.sit_site_id
        AND items.cat_categ_id = categories.cat_categ_id_l7
  
  WHERE categories.cat_categ_id_l1 = '1430'
    AND items.ite_status = 'active'
    AND items.ite_condition = 'new'
    AND SUBSTR(items.ite_domain_id, 5) IN (
       'SHIRTS',
       'T_SHIRTS',
       'DRESSES',
       'PANTS',
       'SHORTS'
    )
    AND attributes.ite_att_attribute_id IN (
      'ONE_SHOULDER',
      'FABRIC_DESIGN',
      'SLEEVE_TYPE',
      'NECK_TYPE',
      'DRESS_LENGTH',
      'BACK_TYPE',
      'LENGTH_TYPE',
      'WITH_POCKETS',
      'T_SHIRT_COLLAR_TYPE'
    )
    
  GROUP BY attributes.ite_att_attribute_id,
    items.ite_domain_id, categories.sit_site_id
    
), item_data AS (

  SELECT
    items.ite_domain_id AS domain_id,
    COUNT(DISTINCT CONCAT(items.sit_site_id, CAST(items.ite_item_id AS STRING))) AS total_items
    
  FROM melilake.lk_ite_items items
    INNER JOIN melilake.lk_ite_item_attribute attributes
      ON items.ite_item_id = attributes.ite_item_id
        AND items.sit_site_id = attributes.sit_site_id
    INNER JOIN melilake.ag_lk_cat_categories_ph categories
      ON items.sit_site_id = categories.sit_site_id
        AND items.cat_categ_id = categories.cat_categ_id_l7
  
  WHERE categories.cat_categ_id_l1 = '1430'
    AND items.ite_status = 'active'
    AND items.ite_condition = 'new'
    AND SUBSTR(items.ite_domain_id, 5) IN (
     'SHIRTS',
     'T_SHIRTS',
     'DRESSES',
     'PANTS',
     'SHORTS'
  )
    
  GROUP BY items.ite_domain_id, categories.sit_site_id
  
)

SELECT 
  attribute_data.site_id as site_id,
  attribute_data.domain_id AS domain_id,
  attribute_data.attribute_id AS attribute_id,
  (CAST(attribute_data.total_with_attribute AS DOUBLE)/CAST(item_data.total_items AS DOUBLE)) AS coverage
  
FROM attribute_data
  INNER JOIN item_data 
    ON item_data.domain_id = attribute_data.domain_id