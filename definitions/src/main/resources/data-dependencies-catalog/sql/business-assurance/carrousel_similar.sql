SELECT 
  p.platform as platform, 
  p.backend_id as backend_id, 
  p.t_without_recos+p.vips_with_recos as total_vips, 
  p.vips_with_recos as vips_with_recos, 
  c.total_clics as total_clics, 
  ((vips_with_recos*100)/(p.t_without_recos+p.vips_with_recos)) as coverage ,
  100*cast(c.total_clics as double)/cast(p.vips_with_recos as double) as ctr, 
  p.site_id as site_id
FROM (
  SELECT 
    jest(data,'device.platform') as platform, jest(data, 'event_data.recommendations.backend_id') as backend_id, jest(data, 'application.site_id') as site_id, 
    SUM(CASE WHEN jest(data, 'event_data.recommendations.track_info.has_recommendations') = 'true' THEN 1 ELSE 0 END) as vips_with_recos,
    SUM(CASE WHEN jest(data, 'event_data.recommendations.track_info.has_recommendations') ='false' THEN 1 ELSE 0 END) as t_without_recos
  FROM 
    recommendations
  WHERE ds >= '@param02' and ds < '@param01'
    and jest(data, 'path') = '/recommendations/print'
    and jest(data, 'application.site_id') IN ('MLA', 'MLB', 'MLM')
    and jest(data, 'event_data.recommendations.client') ='vip'
    and jest(data, 'event_data.recommendations.backend_id') = 'tagging-searchsimilar_fashion'
    group by jest(data,'device.platform'), jest(data, 'application.site_id'), jest(data, 'event_data.recommendations.backend_id')
    ) p LEFT JOIN (
  select 
    device.platform as platform, 
    jest(others['fragment'], 'reco_backend') as backend_id, 
    application.site_id as site_id, 
    count(*) as total_clics
  FROM 
    tracks
  WHERE 
    ds >= '@param02' 
    and ds < '@param01'
    and path = '/vip'
    and application.site_id IN ('MLA', 'MLB', 'MLM') 
    and type = 'view'
    and jest(others['fragment'], 'reco_client') = 'vip'
    and jest(others['fragment'], 'reco_backend') = 'tagging-searchsimilar_fashion'
    group by device.platform, application.site_id, jest(others['fragment'], 'reco_backend')
) c ON (
   p.platform = c.platform 
   and p.site_id = c.site_id 
   and p.backend_id = c.backend_id
);