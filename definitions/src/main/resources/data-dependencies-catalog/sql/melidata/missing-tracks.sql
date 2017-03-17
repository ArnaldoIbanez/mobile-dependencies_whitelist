WITH distinct_raw AS (
  SELECT DISTINCT jest(data, 'id') AS id, ds
  FROM raw
  WHERE ds >= '@param01' AND ds < '@param02'  
)

SELECT raw_complete.ds AS ds,
  (total_raw.total - raw_complete.processed) AS missing,
  total_raw.total AS total
FROM (
  SELECT COUNT(distinct_raw.id) AS processed, distinct_raw.ds
  FROM distinct_raw
  INNER JOIN (
    SELECT DISTINCT id, ds
    FROM tracks
    WHERE ds >= '@param01' AND ds < '@param02'
  ) complete
  ON distinct_raw.id = complete.id
  GROUP BY distinct_raw.ds
) raw_complete
LEFT JOIN (
  SELECT ds, count(1) AS total
  FROM distinct_raw
  GROUP BY ds
) total_raw
ON raw_complete.ds = total_raw.ds
