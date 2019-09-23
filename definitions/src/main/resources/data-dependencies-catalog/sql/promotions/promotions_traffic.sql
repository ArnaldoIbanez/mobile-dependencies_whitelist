select 
 device.platform AS platform,
(CASE WHEN platform.fragment RLIKE '.*menu-user.*' THEN 'mobile_navegation_bar'
        WHEN platform.fragment RLIKE '.*nav-header.*' THEN 'desktop_navegation_bar'
        WHEN jest(platform.fragment, 'sp_origin') RLIKE 'footer' THEN 'desktop_footer'
        WHEN jest(platform.fragment, 'sp_origin') RLIKE 'drawer' THEN 'drawer'
        WHEN jest(platform.fragment, 'sp_origin') RLIKE 'quickly-access-primary' THEN 'quickly-access-primary'
        WHEN jest(platform.fragment, 'sp_origin') RLIKE 'quickly-access-see-more' THEN 'quickly-access-see-more'
        WHEN jest(platform.fragment, 'sp_origin') RLIKE 'main-slider' THEN 'main-slider'
        WHEN jest(platform.fragment, 'sp_origin') RLIKE 'home-carrusel' THEN 'desktop_footer'
        WHEN jest(platform.fragment, 'sp_origin') RLIKE 'email' THEN 'email'
        WHEN jest(platform.fragment, 'sp_origin') RLIKE 'push' THEN 'push'
        ELSE 'others' END 
) AS source,
count(*) as total,
substr(ds,1,10) as track_date
        
from tracks
where path = '/promotions'
    AND ds >= '@param01'
    AND ds < '@param02'
GROUP BY substr(ds,1,10) , platform.fragment, device.platform ,
(CASE WHEN platform.fragment RLIKE '.*"menu-user":null.*' THEN 'mobile_navegation_bar'
        WHEN platform.fragment RLIKE '.*"nav-header":null.*' THEN 'desktop_navegation_bar'
        WHEN jest(platform.fragment, 'sp_origin') RLIKE 'footer' THEN 'desktop_footer'
        WHEN jest(platform.fragment, 'sp_origin') RLIKE 'drawer' THEN 'drawer'
        WHEN jest(platform.fragment, 'sp_origin') RLIKE 'quickly-acess-primary' THEN 'quickly-acess-primary'
        WHEN jest(platform.fragment, 'sp_origin') RLIKE 'quickly-acess-see-more' THEN 'quickly-acess-see-more'
        WHEN jest(platform.fragment, 'sp_origin') RLIKE 'main-slider' THEN 'main-slider'
        WHEN jest(platform.fragment, 'sp_origin') RLIKE 'home-carrusel' THEN 'desktop_footer'
        WHEN jest(platform.fragment, 'sp_origin') RLIKE 'email' THEN 'email'
        WHEN jest(platform.fragment, 'sp_origin') RLIKE 'push' THEN 'push'
        ELSE 'others' END ) 
  