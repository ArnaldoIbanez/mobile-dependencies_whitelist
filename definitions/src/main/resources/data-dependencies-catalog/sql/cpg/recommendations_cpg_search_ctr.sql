WITH clicks AS (
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
),
prints AS (
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
)

SELECT
  sub_prints.recommendation_category as recommendation_category,
  sub_prints.platform as platform,
  sub_prints.count_prints as prints,
  NVL(sub_clicks.count_clicks, 0) as clicks,
  sub_prints.ds as track_date
FROM 
  ( SELECT p.ds as ds, p.platform, p.recommendation_category, count(p.recommendation_category) as count_prints
    FROM prints p
    GROUP BY p.ds, p.platform, p.recommendation_category
  ) as sub_prints
  LEFT JOIN
  ( SELECT c.ds as ds, c.platform, c.recommendation_category, count(c.recommendation_category) as count_clicks
    FROM clicks c
    GROUP BY c.ds, c.platform, c.recommendation_category
  ) as sub_clicks
  ON sub_prints.recommendation_category = sub_clicks.recommendation_category
  ORDER BY recommendation_category