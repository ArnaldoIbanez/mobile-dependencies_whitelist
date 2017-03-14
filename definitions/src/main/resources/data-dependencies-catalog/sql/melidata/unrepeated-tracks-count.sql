SELECT substr(distinct_amount.ds,1,10) AS ds,
       distinct_amount.total AS unrepeated,
       total_amount.total AS total
FROM (
    SELECT ds, COUNT(1) AS total
    FROM (
        SELECT DISTINCT id, ds
        FROM tracks
        WHERE ds >= '@param01'
        AND   ds < '@param02'
    ) td
    GROUP BY ds
) distinct_amount
INNER JOIN (
    SELECT ds, COUNT(1) AS total
    FROM tracks
    WHERE ds >= '@param01'
    AND   ds < '@param02'
    GROUP BY ds
) total_amount
ON total_amount.ds = distinct_amount.ds
