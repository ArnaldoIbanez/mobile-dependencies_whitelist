select substr(ds,1,10) as date_sent,
  application.site_id as site_id,
  device.platform as platform, usr.user_id as user_id, platform.http.http_referer as reference
from tracks
where (ds >= '@param01' and ds <= '@param02')
      and path = '/landing/promotions'
      and platform.http.http_referer like '%Journey_Cobranza%'