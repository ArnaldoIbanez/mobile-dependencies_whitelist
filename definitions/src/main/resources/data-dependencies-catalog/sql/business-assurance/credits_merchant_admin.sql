SELECT 
sum (case when device.user_agent like 'MercadoPago%' then 1 else 0 end) as User_Agent_MP,
sum (case when device.user_agent not like 'MercadoPago%' then 1 else 0 end) as User_Agent_Otros,
 application.site_id as Site,
  device.platform as Platform
FROM tracks
WHERE ds >= '@param01' 
AND ds < '@param02' 
AND  path  like '%/credits/merchant%'
group by  application.site_id,device.platform
