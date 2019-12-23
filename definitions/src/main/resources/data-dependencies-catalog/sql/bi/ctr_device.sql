SELECT
  site_id
  ,device
  ,SUM(gmv) AS gmv
  ,SUM(si) AS si
  ,SUM(gmv)/SUM(si) AS asp
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
GROUP BY site_id, fecha, device;