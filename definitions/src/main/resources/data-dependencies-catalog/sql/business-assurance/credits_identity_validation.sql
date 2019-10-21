SELECT 
substr(S.DS_1,1,10) as Fecha,  
sum(if(S.PATH_1 IS NOT NULL, 1, 0)) as Start_Validation, 
sum(if(F.PATH_2 IS NOT NULL, 1, 0)) as Finish_Validation ,
'@param03' as Fecha_Actual
FROM 
(SELECT  usr.user_id as USER_1 , substr(ds,1,10)  as DS_1, path AS PATH_1 FROM TRACKS
WHERE PATH = '/identity-validation/start_validation'
and (ds >= '@param01'
and ds < '@param02')
and application.site_id = 'MLA'
and jest(event_data, 'flow') = 'credits' ) as S

LEFT JOIN 

(SELECT  usr.user_id as USER_2, substr(ds,1,10) as DS_2, path AS PATH_2 FROM TRACKS
WHERE PATH = '/identity-validation/finish_validation'
and (ds >= '@param01'
        AND ds < '@param03')
and application.site_id = 'MLA'	
and jest(event_data, 'flow') = 'credits') as F
ON S.USER_1 = F.USER_2

group by substr(S.DS_1,1,10), '@param03'