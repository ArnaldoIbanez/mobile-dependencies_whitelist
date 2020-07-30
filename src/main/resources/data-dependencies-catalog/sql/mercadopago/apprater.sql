SELECT  Jest(event_data, 'type_track') AS type_track,
        application.site_id AS site,
        device.platform AS platform,
        application.version AS version,
        Substr(ds, 1, 10)  AS fecha
FROM tracks_mp
WHERE ds >= '@param01'
AND ds < '@param02'
AND path LIKE '%/apprater%'
