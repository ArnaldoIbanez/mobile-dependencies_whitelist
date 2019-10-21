SELECT
COUNT(distinct usr.user_id) as users,
substr(ds,1,10) as fecha,
COUNT(case when tracks.path = '/catalogwidget/welcome/leaders/show' then 1 end) as show,
COUNT(case when tracks.path = '/catalogwidget/welcome/leaders/continue' then 1 end) as continue_ema,
COUNT(case when tracks.path = '/catalogwidget/welcome/leaders/omit' then 1 end) as omit,
COUNT(case when tracks.path = '/catalogwidget/welcome/leaders/close' then 1 end) as close_swmkt
FROM tracks
WHERE tracks.path LIKE '/catalogwidget/welcome/leaders/%'
AND ds >= '@param01' AND ds < '@param02'
AND application.business='mercadolibre'
GROUP BY substr(ds,1,10)