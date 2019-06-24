SELECT
  p.platform AS platform,
  p.backend_id AS backend_id,
  p.cnt AS total_vips,
  p.vips_with_bundle AS vips_with_reco,
  c.total_clics AS total_clicks,
  ((p.vips_with_bundle / CAST(p.cnt AS DOUBLE)) * 100) AS coverage,
  ((c.total_clics / CAST(p.vips_with_bundle AS DOUBLE)) * 100)  AS ctr,
  p.ds AS ds
FROM (
  SELECT
    device.platform AS platform,
    application.site_id AS site_id,
    jest(others['fragment'], 'reco_client') AS client,
    jest(others['fragment'], 'reco_backend') AS backend_id,
    count(1) total_clics,
    substr(t.ds, 1, 10) AS ds
  FROM
    tracks t
  WHERE
    ds >= '@param02'
    AND ds < '@param01'
    AND jest(others['fragment'], 'reco_backend') = 'tagging-searchsimilar_fashion'
    AND path = '/vip'
    AND t.application.site_id = 'MLA'
    AND jest(others['fragment'], 'reco_client') IS NOT NULL
    AND jest(others['fragment'], 'reco_client') = 'vip'
    AND NOT is_bot(device.user_agent)
    AND (device.platform = '/web/desktop' OR device.platform = '/web/mobile')
  GROUP BY device.platform,
    application.site_id,
    jest(others['fragment'], 'reco_client'),
    jest(others['fragment'], 'reco_backend'),
    substr(t.ds, 1, 10)
  ) c 
  JOIN (
    SELECT  substr(ds,1,10) ds,
      application.site_id site_id,
      device.platform platform,
      jest(event_data,'recommendations.client') client, 
      jest(event_data, 'recommendations.backend_id') backend_id,
      SUM(CASE WHEN jest(event_data, 'recommendations.track_info.has_recommendations') = 'true' THEN 1 ELSE 0 END) vips_with_bundle,
      count(1) cnt
    FROM tracks
    WHERE path = '/recommendations'
      AND ds >= '@param02'
      AND ds < '@param01'
      AND type = 'view'
      AND application.site_id IN ('MLA')
      AND application.business = 'mercadolibre'
      AND NOT is_bot(device.user_agent)
      AND jest(event_data, 'recommendations.client') = 'vip'
      AND device.platform in ('/web/desktop','/web/mobile')
      AND jest(event_data, 'recommendations.backend_id') = 'tagging-searchsimilar_fashion'
    GROUP BY  substr(ds,1,10), jest(event_data, 'recommendations.client'), jest(event_data, 'recommendations.backend_id'), device.platform, application.site_id
  ) p 
  ON (
    p.backend_id = c.backend_id 
      AND p.platform = c.platform
      AND p.ds = c.ds
    )