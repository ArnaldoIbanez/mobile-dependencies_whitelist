SELECT
  usr.user_id as user_id,
  count(distinct substr(ds,1,10)) as days
FROM
  tracks
WHERE
  application.business = 'mercadopago'
  AND (path = '/tfs_dashboard/home' OR path = '/tfs_dashboard/detail')
  AND '@param01' <= ds AND ds <= '@param02'
  AND day_of_week(CAST(CONCAT(substr(ds,1,13), ':00:00 -04:00') AS TIMESTAMP)) not in (6,7)
GROUP BY usr.user_id
