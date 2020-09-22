SELECT
 t1.site_id AS site_id, t1.platform AS platform, t1.utm_source AS reference, COUNT(*) AS total, t1.date_sent as date_sent
FROM
 (
   SELECT
     usr.user_id               AS user_id,
     SUBSTR(ds, 1, 10)         AS date_sent,
     application.site_id       AS site_id,
     device.platform           AS platform,
     STR_TO_MAP(substring(platform.http.http_referer, LOCATE('utm_source=', platform.http.http_referer), LENGTH(platform.http.http_referer)), '&','=')["utm_source"] AS utm_source,
     STR_TO_MAP(substring(platform.http.http_referer, LOCATE('utm_content=', platform.http.http_referer), LENGTH(platform.http.http_referer)), '&','=')["utm_content"] AS utm_content,
     STR_TO_MAP(substring(platform.http.http_referer, LOCATE('utm_medium=', platform.http.http_referer), LENGTH(platform.http.http_referer)), '&','=')["utm_medium"]  AS utm_medium
   FROM tracks
   WHERE (ds >= '@param01' and ds < '@param02')
     AND path = '/landing/promotions'
     AND platform.http.http_referer LIKE '%Journey_Cobranza%'
   GROUP BY
     usr.user_id,
     substr(ds, 1, 10),
     application.site_id,
     device.platform,
     STR_TO_MAP(substring(platform.http.http_referer, LOCATE('utm_source=', platform.http.http_referer), LENGTH(platform.http.http_referer)), '&','=')["utm_source"],
     STR_TO_MAP(substring(platform.http.http_referer, LOCATE('utm_content=', platform.http.http_referer), LENGTH(platform.http.http_referer)), '&','=')["utm_content"],
     STR_TO_MAP(substring(platform.http.http_referer, LOCATE('utm_medium=', platform.http.http_referer), LENGTH(platform.http.http_referer)), '&','=')["utm_medium"]
 ) AS t1
GROUP BY
 t1.site_id, t1.date_sent, t1.platform, t1.utm_source