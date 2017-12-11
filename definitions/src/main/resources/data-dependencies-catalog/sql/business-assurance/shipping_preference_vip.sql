SELECT vip.fecha as fecha, 
       vip.shipping_preference as shipping_preference, 
       vip.platform as platform, 
       vip.cantidad as cantidad, 
       categories.L1 as L1, 
       categories.L1_name as L1_name, 
       categories.L2 as L2, 
       categories.L2_name as L2_name
FROM
(
  SELECT substr(ds,1,10) as fecha, jest(event_data, 'shipping_preference') AS shipping_preference, device.platform as platform, count(distinct usr.uid) as cantidad, jest(event_data,'category_id') as category 
  FROM tracks
  WHERE 
    jest(event_data, 'shipping_preference') is not null
    AND path = '/vip'
    AND ds >= '2017-11-20'
    AND ds < '2017-11-21'
    AND application.site_id IN ('MCO', 'MLA', 'MLB', 'MLC', 'MLM', 'MLU', 'MLV')
  GROUP BY substr(ds,1,10), jest(event_data, 'shipping_preference'), device.platform, jest(event_data,'category_id')
) as vip
INNER JOIN
(
  select id as id, 
         split(path_from_root,'->')[0] as L1, 
         split(full_name,'->')[0] as L1_name, 
         split(path_from_root,'->')[1] as L2,
         split(full_name,'->')[1] as L2_name
  from default.categories
) AS categories
ON vip.category = categories.id