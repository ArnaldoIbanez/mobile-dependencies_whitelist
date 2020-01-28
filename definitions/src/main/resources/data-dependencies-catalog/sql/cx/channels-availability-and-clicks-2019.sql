SELECT 
       substr(from_unixtime(unix_timestamp(tb.requested_datetime_minute, 'yyyy-MM-dd HH')+3600), 12, 2) AS requested_datetime_hour,
       tb.site_id AS site_id,
       tb.problem_type AS problem_type,
       tb.origin AS origin,
       tb.ml_seller_profile AS ml_seller_profile,
       tb.mp_seller_profile AS mp_seller_profile,
       tb.ml_buyer_profile AS ml_buyer_profile,
       tb.experience_profile AS experience_profile,
       tb.business AS business,
       tb.segment AS segment,
       tb.source_id AS source_id,
       tb.chat_queue_id AS chat_queue_id,
       tb.c2c_queue_id AS c2c_queue_id,
       tb.sac_queue_id AS sac_queue_id,
       tb.mail_queue_id AS mail_queue_id,
       tb.chat_reason AS chat_reason,
       tb.c2c_reason AS c2c_reason,
       tb.sac_reason AS sac_reason,
       tb.mail_reason AS mail_reason,
       tb.mail_click AS mail_click,
       tb.c2c_click AS c2c_click,
       tb.chat_click AS chat_click,
       tb.sac_click AS sac_click,       
       Sum(tb.unique_quantity) AS unique_quantity,
       Sum(tb.quantity) AS quantity,
       tb.process_id AS process_id,
       substr(from_unixtime(unix_timestamp(tb.requested_datetime_minute, 'yyyy-MM-dd HH')+3600), 1, 10) AS requested_datetime_day
       FROM
  (SELECT COALESCE(chattable.requested_datetime_minute, c2ctable.requested_datetime_minute, sactable.requested_datetime_minute, mailtable.requested_datetime_minute) AS requested_datetime_minute,
          COALESCE(chattable.site_id, c2ctable.site_id, sactable.site_id, mailtable.site_id) AS site_id,
          COALESCE(chattable.problem_type, c2ctable.problem_type, sactable.problem_type, mailtable.problem_type) AS problem_type,
          COALESCE(chattable.origin, c2ctable.origin, sactable.origin, mailtable.origin) AS origin,
          COALESCE(chattable.ml_seller_profile, c2ctable.ml_seller_profile, sactable.ml_seller_profile, mailtable.ml_seller_profile) AS ml_seller_profile,
          COALESCE(chattable.mp_seller_profile, c2ctable.mp_seller_profile, sactable.mp_seller_profile, mailtable.mp_seller_profile) AS mp_seller_profile,
          COALESCE(chattable.ml_buyer_profile, c2ctable.ml_buyer_profile, sactable.ml_buyer_profile, mailtable.ml_buyer_profile) AS ml_buyer_profile,
          COALESCE(chattable.experience_profile, c2ctable.experience_profile, sactable.experience_profile, mailtable.experience_profile) AS experience_profile,
          COALESCE(chattable.business, c2ctable.business, sactable.business, mailtable.business) AS business,
          COALESCE(chattable.segment, c2ctable.segment, sactable.segment, mailtable.segment) AS segment,
          COALESCE(chattable.source_id, c2ctable.source_id, sactable.source_id, mailtable.source_id) AS source_id,
          COALESCE(chattable.process_id, c2ctable.process_id, sactable.process_id, mailtable.process_id) AS process_id,
          chattable.queue_id AS chat_queue_id,
          c2ctable.queue_id AS c2c_queue_id,
          sactable.queue_id AS sac_queue_id,
          mailtable.queue_id AS mail_queue_id,
          COALESCE(chattable.reason, 'not_requested') AS chat_reason,
          COALESCE(c2ctable.reason, 'not_requested') AS c2c_reason,
          COALESCE(sactable.reason, 'not_requested') AS sac_reason,
          COALESCE(mailtable.reason, 'not_requested') AS mail_reason,
          COALESCE(tracksidtable.mail_click, 0) AS mail_click,
          COALESCE(tracksidtable.c2c_click, 0) AS c2c_click,
          COALESCE(tracksidtable.chat_click, 0) AS chat_click,
          COALESCE(tracksidtable.sac_click, 0) AS sac_click,
          Count(DISTINCT COALESCE(chattable.id, c2ctable.id, sactable.id, mailtable.id)) AS quantity,
          Count(DISTINCT COALESCE(chattable.user_id, c2ctable.user_id, sactable.user_id, mailtable.user_id, 'aUserId')) AS unique_quantity
   FROM
     (SELECT v1.id AS id,
             From_unixtime(Unix_timestamp(Regexp_replace(v1.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH:mm') AS requested_datetime_minute,
             v3.site_id AS site_id,
             v3.problem_type AS problem_type,
             v3.reason AS reason,
             v3.origin AS origin,
             v3.is_available AS is_available,
             v3.ml_seller_profile AS ml_seller_profile,
             v3.mp_seller_profile AS mp_seller_profile,
             v3.ml_buyer_profile AS ml_buyer_profile,
             v3.experience_profile AS experience_profile,
             v2.business AS business,
             v3.segment AS segment,
             v2.app_id AS app_id,
             v3.queue_id AS queue_id,
             v4.user_id AS user_id,
             v3.track_id AS track_id,
             v3.source_id AS source_id,
             v3.process_id AS process_id
      FROM cx_help_channels tj LATERAL VIEW json_tuple(tj.data, 'application', 'event_data', 'user_timestamp', 'user', 'id', 'path') v1 AS application,
                                            event_data,
                                            user_timestamp,
                                            anuser,
                                            id,
                                            path LATERAL VIEW json_tuple(v1.application, 'app_id', 'business') v2 AS app_id,
                                                              business
                                                              LATERAL VIEW json_tuple(v1.event_data, 'problem_type', 'reason', 'origin', 'is_available', 'ml_seller_profile', 'mp_seller_profile', 'ml_buyer_profile', 'experience_profile', 'process_id', 'queue_id', 'environment', 'track_id', 'segment', 'source_id', 'custom_site_id') v3 AS problem_type,
                                                                                   reason,
                                                                                   origin,
                                                                                   is_available,
                                                                                   ml_seller_profile,
                                                                                   mp_seller_profile,
                                                                                   ml_buyer_profile,
                                                                                   experience_profile, 
                                                                                   process_id,
                                                                                   queue_id,
                                                                                   environment,
                                                                                   track_id,
                                                                                   segment,
                                                                                   source_id,
                                                                                   site_id LATERAL VIEW json_tuple(v1.anuser, 'user_id') v4 AS user_id
      WHERE tj.ds >= '@param01 02'
        AND tj.ds < '@param02 05'
        AND from_unixtime(unix_timestamp(regexp_replace(v1.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH') >= '@param03 23'
        AND from_unixtime(unix_timestamp(regexp_replace(v1.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH') < '@param04 23'
        AND v1.path = '/availability/requested'
        AND v3.environment = 'PRODUCTION'
        AND v2.app_id = 'CHAT') chattable
   FULL OUTER JOIN
     (SELECT v1.id AS id,
             From_unixtime(Unix_timestamp(Regexp_replace(v1.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH:mm') AS requested_datetime_minute,
             v3.site_id AS site_id,
             v3.problem_type AS problem_type,
             v3.reason AS reason,
             v3.origin AS origin,
             v3.is_available AS is_available,
             v3.ml_seller_profile AS ml_seller_profile,
             v3.mp_seller_profile AS mp_seller_profile,
             v3.ml_buyer_profile AS ml_buyer_profile,
             v3.experience_profile AS experience_profile,
             v2.business AS business,
             v3.segment AS segment,
             v2.app_id AS app_id,
             v3.queue_id AS queue_id,
             v4.user_id AS user_id,
             v3.track_id AS track_id,
             v3.source_id AS source_id,
             v3.process_id AS process_id
      FROM cx_help_channels tj LATERAL VIEW json_tuple(tj.data, 'application', 'event_data', 'user_timestamp', 'user', 'id', 'path') v1 AS application,
                                            event_data,
                                            user_timestamp,
                                            anuser,
                                            id,
                                            path LATERAL VIEW json_tuple(v1.application, 'app_id', 'business') v2 AS app_id,
                                                              business
                                                              LATERAL VIEW json_tuple(v1.event_data, 'problem_type', 'reason', 'origin', 'is_available', 'ml_seller_profile', 'mp_seller_profile', 'ml_buyer_profile', 'experience_profile', 'process_id', 'queue_id', 'environment', 'track_id', 'segment', 'source_id', 'custom_site_id') v3 AS problem_type,
                                                                                   reason,
                                                                                   origin,
                                                                                   is_available,
                                                                                   ml_seller_profile,
                                                                                   mp_seller_profile,
                                                                                   ml_buyer_profile,
                                                                                   experience_profile, 
                                                                                   process_id,
                                                                                   queue_id,
                                                                                   environment,
                                                                                   track_id,
                                                                                   segment,
                                                                                   source_id,
                                                                                   site_id LATERAL VIEW json_tuple(v1.anuser, 'user_id') v4 AS user_id
      WHERE tj.ds >= '@param01 02'
        AND tj.ds < '@param02 05'
        AND from_unixtime(unix_timestamp(regexp_replace(v1.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH') >= '@param03 23'
        AND from_unixtime(unix_timestamp(regexp_replace(v1.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH') < '@param04 23'
        AND v1.path = '/availability/requested'
        AND v3.environment = 'PRODUCTION'
        AND v2.app_id = 'CLICKTOCALL') c2ctable ON (c2ctable.track_id = chattable.track_id)
   FULL OUTER JOIN
     (SELECT v1.id AS id,
             From_unixtime(Unix_timestamp(Regexp_replace(v1.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH:mm') AS requested_datetime_minute,
             v3.site_id AS site_id,
             v3.problem_type AS problem_type,
             v3.reason AS reason,
             v3.origin AS origin,
             v3.is_available AS is_available,
             v3.ml_seller_profile AS ml_seller_profile,
             v3.mp_seller_profile AS mp_seller_profile,
             v3.ml_buyer_profile AS ml_buyer_profile,
             v3.experience_profile AS experience_profile,
             v2.business AS business,
             v3.segment AS segment,
             v2.app_id AS app_id,
             v3.queue_id AS queue_id,
             v4.user_id AS user_id,
             v3.track_id AS track_id,
             v3.source_id AS source_id,
             v3.process_id AS process_id
      FROM cx_help_channels tj LATERAL VIEW json_tuple(tj.data, 'application', 'event_data', 'user_timestamp', 'user', 'id', 'path') v1 AS application,
                                            event_data,
                                            user_timestamp,
                                            anuser,
                                            id,
                                            path LATERAL VIEW json_tuple(v1.application, 'app_id', 'business') v2 AS app_id,
                                                              business
                                                              LATERAL VIEW json_tuple(v1.event_data, 'problem_type', 'reason', 'origin', 'is_available', 'ml_seller_profile', 'mp_seller_profile', 'ml_buyer_profile', 'experience_profile', 'process_id', 'queue_id', 'environment', 'track_id', 'segment', 'source_id', 'custom_site_id') v3 AS problem_type,
                                                                                   reason,
                                                                                   origin,
                                                                                   is_available,
                                                                                   ml_seller_profile,
                                                                                   mp_seller_profile,
                                                                                   ml_buyer_profile,
                                                                                   experience_profile, 
                                                                                   process_id,
                                                                                   queue_id,
                                                                                   environment,
                                                                                   track_id,
                                                                                   segment,
                                                                                   source_id,
                                                                                   site_id LATERAL VIEW json_tuple(v1.anuser, 'user_id') v4 AS user_id
      WHERE tj.ds >= '@param01 02'
        AND tj.ds < '@param02 05'
        AND from_unixtime(unix_timestamp(regexp_replace(v1.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH') >= '@param03 23'
        AND from_unixtime(unix_timestamp(regexp_replace(v1.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH') < '@param04 23'
        AND v1.path = '/availability/requested'
        AND v3.environment = 'PRODUCTION'
        AND v2.app_id = 'SAC') sactable ON (sactable.track_id = nvl(c2ctable.track_id, chattable.track_id))
   FULL OUTER JOIN
     (SELECT v1.id AS id,
             From_unixtime(Unix_timestamp(Regexp_replace(v1.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH:mm') AS requested_datetime_minute,
             v3.site_id AS site_id,
             v3.problem_type AS problem_type,
             v3.reason AS reason,
             v3.origin AS origin,
             v3.is_available AS is_available,
             v3.ml_seller_profile AS ml_seller_profile,
             v3.mp_seller_profile AS mp_seller_profile,
             v3.ml_buyer_profile AS ml_buyer_profile,
             v3.experience_profile AS experience_profile,
             v2.business AS business,
             v3.segment AS segment,
             v2.app_id AS app_id,
             'mail_queue' AS queue_id,
             v4.user_id AS user_id,
             v3.track_id AS track_id,
             v3.source_id AS source_id,
             v3.process_id AS process_id
      FROM cx_help_channels tj LATERAL VIEW json_tuple(tj.data, 'application', 'event_data', 'user_timestamp', 'user', 'id', 'path') v1 AS application,
                                            event_data,
                                            user_timestamp,
                                            anuser,
                                            id,
                                            path LATERAL VIEW json_tuple(v1.application, 'app_id', 'business') v2 AS app_id,
                                                              business
                                                              LATERAL VIEW json_tuple(v1.event_data, 'problem_type', 'reason', 'origin', 'is_available', 'ml_seller_profile', 'mp_seller_profile', 'ml_buyer_profile', 'experience_profile', 'process_id', 'queue_id', 'environment', 'track_id', 'segment', 'source_id', 'custom_site_id') v3 AS problem_type,
                                                                                   reason,
                                                                                   origin,
                                                                                   is_available,
                                                                                   ml_seller_profile,
                                                                                   mp_seller_profile,
                                                                                   ml_buyer_profile,
                                                                                   experience_profile, 
                                                                                   process_id,
                                                                                   queue_id,
                                                                                   environment,
                                                                                   track_id,
                                                                                   segment,
                                                                                   source_id,
                                                                                   site_id LATERAL VIEW json_tuple(v1.anuser, 'user_id') v4 AS user_id
      WHERE tj.ds >= '@param01 02'
        AND tj.ds < '@param02 05'
        AND from_unixtime(unix_timestamp(regexp_replace(v1.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH') >= '@param03 23'
        AND from_unixtime(unix_timestamp(regexp_replace(v1.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH') < '@param04 23'
        AND v1.path = '/availability/requested'
        AND v3.environment = 'PRODUCTION'
        AND v2.app_id = 'MAIL') mailtable ON (mailtable.track_id = COALESCE(c2ctable.track_id, chattable.track_id, sactable.track_id))
      LEFT JOIN (
          SELECT COALESCE(chatti.track_id,c2cti.track_id, mailti.track_id, sacti.track_id) as track_id,
          CASE WHEN mailti.track_id IS null then 0 else 1 end mail_click,
          CASE WHEN c2cti.track_id IS null then 0 else 1 end c2c_click,
          CASE WHEN chatti.track_id IS null then 0 else 1 end chat_click,
          CASE WHEN sacti.track_id IS null then 0 else 1 end sac_click
          FROM (
            SELECT distinct v3.track_id AS track_id
            FROM cx_help_channels tj 
            LATERAL VIEW json_tuple(tj.data, 'application', 'event_data', 'path') v1 AS application, event_data, path                                             
            LATERAL VIEW json_tuple(v1.application, 'app_id') v2 AS app_id 
            LATERAL VIEW json_tuple(v1.event_data, 'environment', 'track_id') v3 AS environment, track_id
            WHERE tj.ds >= '@param01 02'
            AND tj.ds < '@param02 07'
            AND v1.path = '/click/registered'
             AND v3.environment = 'PRODUCTION'
            AND v2.app_id = 'MAIL') mailti
          FULL OUTER JOIN (
            SELECT distinct v3.track_id AS track_id
            FROM cx_help_channels tj 
            LATERAL VIEW json_tuple(tj.data, 'application', 'event_data', 'path') v1 AS application, event_data, path                                             
            LATERAL VIEW json_tuple(v1.application, 'app_id') v2 AS app_id 
            LATERAL VIEW json_tuple(v1.event_data, 'environment', 'track_id') v3 AS environment, track_id
            WHERE tj.ds >= '@param01 02'
            AND tj.ds < '@param02 07'
            AND v1.path = '/click/registered'
            AND v3.environment = 'PRODUCTION'
            AND v2.app_id = 'CLICKTOCALL') c2cti
          ON c2cti.track_id = mailti.track_id
          FULL OUTER JOIN (
            SELECT distinct v3.track_id AS track_id
            FROM cx_help_channels tj 
            LATERAL VIEW json_tuple(tj.data, 'application', 'event_data', 'path') v1 AS application, event_data, path                                             
            LATERAL VIEW json_tuple(v1.application, 'app_id') v2 AS app_id 
            LATERAL VIEW json_tuple(v1.event_data, 'environment', 'track_id') v3 AS environment, track_id
            WHERE tj.ds >= '@param01 02'
            AND tj.ds < '@param02 07'
            AND v1.path = '/click/registered'
            AND v3.environment = 'PRODUCTION'
            AND v2.app_id = 'CHAT') chatti
          ON chatti.track_id = COALESCE(c2cti.track_id, mailti.track_id)
          FULL OUTER JOIN (
            SELECT distinct v3.track_id AS track_id
            FROM cx_help_channels tj 
            LATERAL VIEW json_tuple(tj.data, 'application', 'event_data', 'path') v1 AS application, event_data, path                                             
            LATERAL VIEW json_tuple(v1.application, 'app_id') v2 AS app_id 
            LATERAL VIEW json_tuple(v1.event_data, 'environment', 'track_id') v3 AS environment, track_id
            WHERE tj.ds >= '@param01 02'
            AND tj.ds < '@param02 07'
            AND v1.path = '/click/registered'
            AND v3.environment = 'PRODUCTION'
            AND v2.app_id = 'SAC') sacti
          ON sacti.track_id = COALESCE(chatti.track_id,c2cti.track_id, mailti.track_id)   
          
      )tracksidtable ON (COALESCE(c2ctable.track_id, chattable.track_id, sactable.track_id, mailtable.track_id) = tracksidtable.track_id)
  
   GROUP BY COALESCE(chattable.requested_datetime_minute, c2ctable.requested_datetime_minute, sactable.requested_datetime_minute, mailtable.requested_datetime_minute),
            COALESCE(chattable.site_id, c2ctable.site_id, sactable.site_id, mailtable.site_id),
            COALESCE(chattable.problem_type, c2ctable.problem_type, sactable.problem_type, mailtable.problem_type),
            COALESCE(chattable.origin, c2ctable.origin, sactable.origin, mailtable.origin),
            COALESCE(chattable.ml_seller_profile, c2ctable.ml_seller_profile, sactable.ml_seller_profile, mailtable.ml_seller_profile),
            COALESCE(chattable.mp_seller_profile, c2ctable.mp_seller_profile, sactable.mp_seller_profile, mailtable.mp_seller_profile),
            COALESCE(chattable.ml_buyer_profile, c2ctable.ml_buyer_profile, sactable.ml_buyer_profile, mailtable.ml_buyer_profile),
            COALESCE(chattable.experience_profile, c2ctable.experience_profile, sactable.experience_profile, mailtable.experience_profile),
            COALESCE(chattable.business, c2ctable.business, sactable.business, mailtable.business),
            COALESCE(chattable.segment, c2ctable.segment, sactable.segment, mailtable.segment),
            COALESCE(chattable.source_id, c2ctable.source_id, sactable.source_id, mailtable.source_id),
            COALESCE(chattable.process_id, c2ctable.process_id, sactable.process_id, mailtable.process_id),
            chattable.queue_id,
            c2ctable.queue_id,
            sactable.queue_id,
            mailtable.queue_id,
            chattable.reason,
            c2ctable.reason,
            sactable.reason,
            mailtable.reason,
            tracksidtable.mail_click,
            tracksidtable.c2c_click,
            tracksidtable.chat_click,
            tracksidtable.sac_click) tb
GROUP BY 
         substr(from_unixtime(unix_timestamp(tb.requested_datetime_minute, 'yyyy-MM-dd HH')+3600), 1, 10),
         substr(from_unixtime(unix_timestamp(tb.requested_datetime_minute, 'yyyy-MM-dd HH')+3600), 12, 2),
         tb.site_id,
         tb.problem_type,
         tb.origin,
         tb.ml_seller_profile,
         tb.mp_seller_profile,
         tb.ml_buyer_profile,
         tb.experience_profile,
         tb.business,
         tb.segment,
         tb.chat_queue_id,
         tb.c2c_queue_id,
         tb.sac_queue_id,
         tb.mail_queue_id,
         tb.chat_reason,
         tb.c2c_reason,
         tb.sac_reason,
         tb.mail_reason,
         tb.mail_click,
         tb.c2c_click,
         tb.chat_click,
         tb.sac_click,
         tb.source_id,
         tb.process_id