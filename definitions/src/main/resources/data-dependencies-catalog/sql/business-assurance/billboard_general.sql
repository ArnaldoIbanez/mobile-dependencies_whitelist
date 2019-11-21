SELECT
      application.site_id as site,
      application.business AS business,
      substr(jest (event_data, 'category_id'),4,8) as category_id,
      device.platform as plataforma,
      path as path,
      jest (event_data, 'is_new_billboard') as is_new_billboard,
      IF (path = '/search/billboard', jest (event_data, 'position_shown'), jest (event_data, 'action')) AS detail,
      substr(ds,1,10) as ds
FROM tracks
WHERE ds >= '@param01' AND ds < '@param02'
      AND (path = '/search/billboard' OR path = '/search/billboard/resize')
      AND device.platform IN ('/web/desktop', '/web/desktop/forced', '/web/desktop/forced/static', '/web/desktop/static', '/web/mobile', '/web/mobile/forced', '/web/mobile/forced/static', '/web/mobile/static')
      AND application.site_id IN ('MCO', 'MLA', 'MLB', 'MLC', 'MLM', 'MLU', 'MLV')
