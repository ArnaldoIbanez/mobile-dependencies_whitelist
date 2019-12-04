SELECT 
    device.platform AS Plataforma,
    jest(platform.fragment, 'sellerid') AS SellerID,
    jest(COALESCE(platform.fragment, others['fragment']), 'DEAL_ID') AS	Deals,
    jest(platform.fragment, 'banner_name') as banner,
    jest(platform.fragment, 'c_id') as component,
    jest(platform.fragment, 'c_campaign') as c_campaign,
    count(1) as Clicks,
    substr(ds,1,10) as ds                                        
FROM tracks
WHERE ds >= '@param01' AND ds < '@param02' 
    AND `type` = 'view'
    AND `path` <> '/recommendations' AND  jest(platform.fragment, 'banner_name') like 'ADV%'
    AND application.business = 'mercadolibre'
GROUP BY substr(ds,1,10),
         device.platform,
         jest(platform.fragment, 'sellerid'), 
         jest(COALESCE(platform.fragment, others['fragment']), 'DEAL_ID'),
         jest(platform.fragment, 'banner_name'),
         jest(platform.fragment, 'c_id'),
         jest(platform.fragment, 'c_campaign')
