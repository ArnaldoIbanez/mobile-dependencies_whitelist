WITH
  t1 AS (
    SELECT
      usr.user_id               AS user_id,
      substr(ds, 1, 10)         AS date_sent,
      application.site_id       AS site_id,
      device.platform           AS platform,
      element_at(split_to_map(substr(platform.http.http_referer, position('utm_source=' IN platform.http.http_referer), length(platform.http.http_referer)), '&','='), 'utm_source')    AS utm_source,
      element_at(split_to_map(substr(platform.http.http_referer, position('utm_source=' IN platform.http.http_referer), length(platform.http.http_referer)), '&','='), 'utm_content')   AS utm_content,
      element_at(split_to_map(substr(platform.http.http_referer, position('utm_source=' IN platform.http.http_referer), length(platform.http.http_referer)), '&','='), 'utm_medium')    AS utm_medium
    FROM tracks
    WHERE (ds >= '@param01' and ds < '@param02')
      AND path = '/landing/promotions'
      AND platform.http.http_referer LIKE '%Journey_Cobranza%'
    GROUP BY
      usr.user_id,
      substr(ds, 1, 10),
      application.site_id,
      device.platform,
      element_at(split_to_map(substr(platform.http.http_referer, position('utm_source=' IN platform.http.http_referer), length(platform.http.http_referer)), '&','='), 'utm_source'),
      element_at(split_to_map(substr(platform.http.http_referer, position('utm_source=' IN platform.http.http_referer), length(platform.http.http_referer)), '&','='), 'utm_content'),
      element_at(split_to_map(substr(platform.http.http_referer, position('utm_source=' IN platform.http.http_referer), length(platform.http.http_referer)), '&','='), 'utm_medium')
  )
SELECT
  t1.site_id, t1.platform, t1.utm_source AS reference, count(*) AS total, t1.date_sent
FROM
  t1
GROUP BY
  t1.site_id, t1.date_sent, t1.platform, t1.utm_source
ORDER BY
  t1.site_id, t1.date_sent, t1.platform, t1.utm_source
