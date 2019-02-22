SELECT
    tracks.path AS path,
    jest(tracks.event_data, 'user_action') action,
    jest(tracks.event_data, 'session_id') session,
    jest(tracks.event_data, 'item_id') item,
    jest(tracks.event_data, 'category_domain') domain,
    jest(tracks.event_data, 'attribute') attribute,
    jest(tracks.event_data, 'type') hintType,
    jest(tracks.event_data, 'hint_id') hintId,
    CASE
        WHEN tracks.path LIKE '/seller_central/bulk/technical_specifications/hints/%' THEN 'bulk'
        WHEN tracks.path LIKE '/seller_central/modify/technical_specifications/hints/%' THEN 'modify'
        END AS source,
    application.site_id AS site,
    usr.user_id AS t_user,
    substr(ds,1,10) AS ds
FROM tracks
WHERE jest(tracks.event_data, 'item_id') IN
      (SELECT DISTINCT
          jest(tracks.event_data, 'item_id')
      FROM tracks
      WHERE tracks.path LIKE '/seller_central/%/technical_specifications/hints/available'
          AND ds >= '@param01'
          AND ds < '@param02'
          AND type = 'event'
          AND application.business = 'mercadolibre')
    AND tracks.path LIKE '/seller_central/%/technical_specifications/hints/%'
    AND ds >= '@param01'
    AND ds < '@param02'
    AND type = 'event'
    AND application.business = 'mercadolibre'
