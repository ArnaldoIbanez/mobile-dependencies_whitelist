SELECT 'complete' AS source,
       substr(ds,1,10) AS ds,
       COUNT(id) AS total,
       COUNT(DISTINCT id) AS distinct_total
FROM tracks
WHERE ds >= '@param01'
AND   ds < '@param02'
GROUP BY substr(ds,1,10)

UNION

SELECT 'part' AS source,
       substr(ds,1,10) AS ds,
       COUNT(id) AS total,
       COUNT(DISTINCT id) AS distinct_total
FROM tracks_part
WHERE ds >= '@param01'
AND   ds < '@param02'
GROUP BY substr(ds,1,10)

UNION

SELECT 'raw' AS source,
       substr(ds,1,10) AS ds,
       COUNT(id) AS total,
       COUNT(DISTINCT id) AS distinct_total
FROM (
       SELECT ds,
              jest(data,'id') AS id
       FROM raw
       WHERE ds >= '@param01'
       AND   ds < '@param02'
) AS raw
GROUP BY substr(ds,1,10)
