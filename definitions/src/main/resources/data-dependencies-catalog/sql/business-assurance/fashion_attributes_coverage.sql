  SELECT 
  attribute_data.site_id as site_id,
  attribute_data.domain_id AS domain_id,
  attribute_data.attribute_id AS attribute_id,
  (CAST(attribute_data.total_with_attribute AS DOUBLE)/CAST(item_data.total_items AS DOUBLE)) AS coverage,
  '@date' AS fecha
  
FROM (

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
      
    GROUP BY attributes.ite_att_attribute_id,
      items.ite_domain_id, categories.sit_site_id
      

  ) attribute_data
  INNER JOIN (

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
      
    GROUP BY items.ite_domain_id, categories.sit_site_id
    
  ) item_data 
    ON item_data.domain_id = attribute_data.domain_id