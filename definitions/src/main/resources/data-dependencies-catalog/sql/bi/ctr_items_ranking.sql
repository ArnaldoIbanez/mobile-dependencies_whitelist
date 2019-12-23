SELECT *
FROM(
    SELECT *, 
      ROW_NUMBER() OVER (PARTITION BY site_id,category_id_l1,category_name_l2 ORDER BY site_id, category_id_l1, wcr DESC) AS cat_rank
    FROM (
            SELECT
              site_id
              ,category_id_l1
              ,category_name_l1
              ,category_id_l2
              ,category_name_l2
              ,category_id_l3
              ,category_name_l3
              ,order_deal
              ,seller_nickname
              ,order_logistic
              ,item
              ,order_title
              ,SUM(gmv) AS gmv
              ,SUM(si) AS si
              ,SUM(gmv)/SUM(si) AS asp
              ,AVG(position_avg) AS position_avg
              ,MIN(position_min) AS position_min
              ,MAX(position_max) AS position_max
              ,COUNT(DISTINCT user_impresiones) AS impresiones_unicas
              ,SUM(impresiones_totales) AS impresiones_totales
              ,COUNT(DISTINCT user_vip) AS user_vip
              ,SUM(vips_totales) AS vips_totales
              ,COUNT(DISTINCT user_order) AS user_order
              ,SUM(ordenes) AS ordenes
              ,SUM(sale_fee) AS sale_fee
              ,(COUNT(DISTINCT user_vip)*1.00)/(COUNT(DISTINCT user_impresiones)*1.00) AS CTR
              ,(COUNT(DISTINCT user_order)*1.00)/(COUNT(DISTINCT user_vip)*1.00) AS CVR
              ,(COUNT(DISTINCT user_order)*1.00)/(COUNT(DISTINCT user_impresiones)*1.00) AS WCR
              ,fecha
            FROM 
              ctr.ctr_base
            GROUP BY site_id, fecha, category_id_l1, category_name_l1, category_id_l2, category_name_l2, category_id_l3, category_name_l3
              ,device, order_deal, seller_nickname, order_logistic, item, order_title
        ) AS base
    WHERE ordenes>3 AND category_id_l1 IS NOT NULL) AS base 
WHERE cat_rank<101