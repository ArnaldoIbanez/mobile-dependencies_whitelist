SELECT
  site_id
  ,device
  ,SUM(gmv) AS gmv
  ,SUM(si) AS si
  ,approx_count_distinct(user_impresiones) AS impresiones_unicas
  ,SUM(impresiones_totales) AS impresiones_totales
  ,approx_count_distinct( user_vip) AS user_vip
  ,SUM(vips_totales) AS vips_totales
  ,approx_count_distinct(user_order) AS user_order
  ,SUM(ordenes) AS ordenes
  ,SUM(sale_fee) AS sale_fee
  ,fecha
FROM 
  ctr.ctr_base
GROUP BY site_id, fecha, device;