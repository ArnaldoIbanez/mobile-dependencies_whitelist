SELECT
      tracks.application.site_id AS siteId,
      json_extract(listingsNotPublished,'$.categoryId') AS category,
      json_extract(errors,'$.code') AS errorCode,
      substr(ds,1,10) AS ds,
      sum(cast(json_extract(errors,'$.occurrences')AS INTEGER)) AS quantity,
      substr(ds,1,10) AS ds
FROM tracks
CROSS JOIN UNNEST(CAST (jet(tracks.event_data,'listings_not_published') AS ARRAY<JSON>)) AS t (listingsNotPublished)
CROSS JOIN UNNEST(CAST (json_extract(listingsNotPublished,'$.errors') AS ARRAY<JSON>)) AS t (errors)
WHERE path = '/seller_central/bulk/publish/publish-callback'
AND ds >= '@param01'
AND ds < '@param02'
GROUP BY 1,2,3,4
ORDER BY quantity DESC
