SELECT 
  p.platform as platform, 
  p.backend_id as backend_id, 
  p.t_without_recos+p.vips_with_recos as total_vips, 
  p.vips_with_recos as vips_with_recos, 
  c.total_clics as total_clics, 
  ((vips_with_recos*100)/(p.t_without_recos+p.vips_with_recos)) as coverage ,
  100*cast(c.total_clics as double)/cast(p.vips_with_recos as double) as ctr, 
  p.site_id as site_id,
  p.ds AS ds
FROM (
  SELECT 
    jest(event_data,'device.platform') as platform,
    jest(event_data, 'event_data.recommendations.backend_id') as backend_id,  
    application.site_id as site_id,
    SUM(CASE WHEN jest(event_data, 'event_data.recommendations.track_info.has_recommendations') = 'true' THEN 1 ELSE 0 END) as vips_with_recos,
    SUM(CASE WHEN jest(event_data, 'event_data.recommendations.track_info.has_recommendations') ='false' THEN 1 ELSE 0 END) as t_without_recos,
    substr(ds,1,10) as ds
  FROM 
    recommendations_parquet
  WHERE ds < '@param01'
    and ds >= '@param02'
    and path = '/recommendations/print'
    and application.site_id IN ('MLA','MLB','MLM', 'MLC', 'MLU', 'MCO')
    and jest(event_data, 'event_data.recommendations.client')  ='vip'
    and jest(event_data, 'event_data.recommendations.backend_id')= 'tagging-searchsimilar_fashion'
    group by jest(event_data,'device.platform'), application.site_id, jest(event_data, 'event_data.recommendations.backend_id'), substr(ds,1,10)
) p LEFT JOIN (
  SELECT
    device.platform as platform, 
    jest(platform.fragment, 'reco_backend') as backend_id, 
    application.site_id as site_id, 
    count(*) as total_clics,
    substr(ds, 1, 10) as ds
  FROM 
    tracks
  WHERE ds < '@param01'
    and ds >= '@param02'
    and path = '/vip'
    and application.site_id IN ('MLA' ,'MLB','MLM', 'MLC', 'MLU', 'MCO') 
    and type = 'view'
    and jest(platform.fragment, 'reco_client') = 'vip'
    and jest(platform.fragment, 'reco_backend') = 'tagging-searchsimilar_fashion'
    group by device.platform, application.site_id, jest(platform.fragment, 'reco_backend'), substr(ds,1,10)
) c ON (
   p.platform = c.platform 
   and p.site_id = c.site_id 
   and p.ds = c.ds
   and p.backend_id = c.backend_id
);