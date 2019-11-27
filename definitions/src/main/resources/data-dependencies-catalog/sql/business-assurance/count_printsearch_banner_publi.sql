SELECT 
       platform,
       banner_name,
       prints,
       usr_unicos,
       ds 

FROM (

          (SELECT
                  substr(ds,1,10) as ds,
                  device.platform AS platform,
                  exhibitor_id,
                  count(1) as prints,
                  count(distinct (concat(usr.uid,'-',usr.user_id))) as usr_unicos
                  
    
                  from tracks
                  LATERAL VIEW json_tuple(event_data,'banner') v1 as banner
                  LATERAL VIEW json_tuple(banner, 'exhibitor_id') v2 as exhibitor_id
                  
          WHERE
                path='/search' and exhibitor_id IS NOT NULL
                AND
                ds >= '2019-11-19' and ds < '2019-11-21' 
          group by
                  substr(ds,1,10),
                  device.platform,
                  exhibitor_id
                  
          ) impression
    
inner JOIN 

(    SELECT substr(ds,1,10) as ds2,
    device.platform AS platforma,
    SPLIT(jest(platform.fragment, 'banner_name'),'#')[0] as banner_name,
    SPLIT(split(jest(platform.fragment, 'banner_name'),':')[1],']')[0]  as ei
  
FROM tracks
WHERE ds >= '2019-11-19' AND ds < '2019-11-21'  
AND path = '/search'
AND jest(platform.fragment, 'banner_name') like '%TSB%'

) tsb
         
        ON (impression.platform = tsb.platforma and impression.exhibitor_id = tsb.EI )
        
  ) 
        
GROUP BY ds,
         platform,
         banner_name,
         prints,
         usr_unicos
