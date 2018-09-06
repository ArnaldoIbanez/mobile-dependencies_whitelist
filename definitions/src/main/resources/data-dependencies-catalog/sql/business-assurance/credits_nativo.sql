SELECT 
substr(ds,1,10) as Fecha,
sum (case when device.user_agent like 'MercadoPago%' then 1 else 0 end) as User_Agent_MP,
count (distinct usr.user_id) as User_id, 
application.site_id as Site,
device.platform as Platform,
path as Path
FROM tracks
WHERE ds >= '@param01' 
AND ds < '@param02' 
AND  path  like '%/credits/merchant%'
group by  application.site_id,device.platform,substr(ds,1,10),path
