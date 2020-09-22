SELECT
sub_prints.recommendation_category as recommendation_category,
sub_prints.platform as platform,
sub_prints.count_prints as prints,
NVL(sub_clicks.count_clicks, 0) as clicks,
sub_prints.ds as track_date
FROM 
( SELECT prints.ds as ds, prints.platform, prints.recommendation_category, count(prints.recommendation_category) as count_prints
  FROM 
  (
    SELECT
      regexp_replace(recommended_categories, '\\"|\\[|\\]', '') as recommendation_category,
      substr(ds, 1, 10) AS ds,
      device.platform AS platform
    FROM tracks lateral view explode(split(get_json_object(event_data, '$.recommended_categories'), ',')) recommended_categories as recommended_categories
    WHERE
      ds >= '@param01' 
      AND ds < '@param02'
      AND path like '/search/category_recommendations'
      AND application.site_id = 'MLM'
  ) as prints
  GROUP BY prints.ds, prints.platform, prints.recommendation_category
) as sub_prints
LEFT JOIN
( SELECT clicks.ds as ds, clicks.platform, clicks.recommendation_category, count(clicks.recommendation_category) as count_clicks
  FROM
  (
    SELECT
      get_json_object(others['fragment'], '$.recommendation_category') AS recommendation_category,
      substr(ds, 1, 10) AS ds,
      device.platform AS platform
    FROM
      tracks
    WHERE
      ds >= '@param01' 
      AND ds < '@param02'
      AND path like '/search'
      AND application.site_id = 'MLM'
      AND get_json_object(others['fragment'], '$.recommendation_category') is not null
  ) as clicks
  GROUP BY clicks.ds, clicks.platform, clicks.recommendation_category
) as sub_clicks
ON sub_prints.recommendation_category = sub_clicks.recommendation_category AND sub_prints.platform = sub_clicks.platform