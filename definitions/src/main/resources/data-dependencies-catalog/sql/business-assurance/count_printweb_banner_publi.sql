SELECT                         platform,
                               c_campaign,
                               element_order,
                               prints,
                               usr_unicos,
                               SUBSTR(`dsx`, 1, 10) AS ds
from (

SELECT  
                               from_unixtime(unix_timestamp(ds, 'yyyy-MM-dd HH') - 14400, 'yyyy-MM-dd HH') AS `dsx`,
                               platform,
                               c_campaign,
                               element_order,
                               count(*) as prints,
                               count(distinct (concat(usr3.uid,'-',usr2.userid))) as usr_unicos
                        FROM component_prints
                          LATERAL VIEW json_tuple(`data`,'event_data')      ed        AS event_data
                          LATERAL VIEW json_tuple(`data`,'device')          dev       AS device
                          LATERAL VIEW json_tuple(`data`,'application')     app       AS application
                          LATERAL VIEW json_tuple(`data`,'user')            usr       AS user_data
                          LATERAL VIEW json_tuple(`user_data`,'user_id')         usr2      AS userid
                          LATERAL VIEW json_tuple(`user_data`,'uid')             usr3      AS uid
                          LATERAL VIEW json_tuple(`device`,'platform')      platform  AS platform
                          LATERAL VIEW json_tuple(`event_data`,'c_id')      c_id      AS component
                          LATERAL VIEW json_tuple(`event_data`,'c_campaign')  c_cam        AS c_campaign
                          LATERAL VIEW json_tuple(`event_data`,'c_element_order')  c_elem       AS element_order
                          LATERAL VIEW json_tuple(`event_data`,'c_event')      c_id      AS c_event
                          LATERAL VIEW json_tuple(`data`, 'path')           path      AS path
                        WHERE ds >= '2019-11-22 04'
                          AND ds < '2019-11-23 04'
                          AND component like '/home/exhibitors%'
                          AND path='\/component'
                          AND c_event='print'  
                          AND  c_campaign IS NOT NULL
                        GROUP BY from_unixtime(unix_timestamp(ds, 'yyyy-MM-dd HH') - 14400, 'yyyy-MM-dd HH'),platform,c_campaign,element_order
                        
                        ) t
