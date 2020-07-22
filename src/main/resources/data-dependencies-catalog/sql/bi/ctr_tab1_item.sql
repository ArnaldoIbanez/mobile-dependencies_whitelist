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
    ,stock
    ,SUM(gmv) AS gmv
    ,SUM(si) AS si
    ,SUM(gmv)/SUM(si) AS asp
    ,AVG(position_avg) AS position_avg
    ,MIN(position_min) AS position_min
    ,MAX(position_max) AS position_max
    ,approx_count_distinct(user_impresiones) AS impresiones_unicas
    ,SUM(impresiones_totales) AS impresiones_totales
    ,approx_count_distinct(user_vip) AS user_vip
    ,SUM(vips_totales) AS vips_totales
    ,approx_count_distinct(user_order) AS user_order
    ,SUM(ordenes) AS ordenes
    ,SUM(sale_fee) AS sale_fee
    ,fecha
  FROM ctr.ctr_base
  WHERE category_id_l1 IS NOT NULL
  GROUP BY site_id, fecha, category_id_l1, category_name_l1, category_id_l2, category_name_l2, category_id_l3, category_name_l3
              ,device, order_deal, seller_nickname, order_logistic, item, order_title, stock
  HAVING ordenes>0;
