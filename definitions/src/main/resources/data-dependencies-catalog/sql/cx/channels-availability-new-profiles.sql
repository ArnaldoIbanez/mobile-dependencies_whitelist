SELECT Substr(tb.requested_datetime_minute, 1, 13) AS requested_datetime,
       tb.site_id AS site_id,
       tb.problem_type AS problem_type,
       tb.origin AS origin,
       tb.ml_seller_profile AS ml_seller_profile,
       tb.mp_seller_profile AS mp_seller_profile,
       tb.ml_buyer_profile AS ml_buyer_profile,
       tb.business AS business,
       tb.chat_queue_id AS chat_queue_id,
       tb.c2c_queue_id AS c2c_queue_id,
       tb.sac_queue_id AS sac_queue_id,
       tb.chat_reason AS chat_reason,
       tb.c2c_reason AS c2c_reason,
       tb.sac_reason AS sac_reason,
       Sum(tb.unique_quantity) AS unique_quantity,
       Sum(tb.quantity) AS quantity
FROM
  (SELECT COALESCE(chattable.requested_datetime_minute, c2ctable.requested_datetime_minute, sactable.requested_datetime_minute) AS requested_datetime_minute,
          COALESCE(chattable.site_id, c2ctable.site_id, sactable.site_id) AS site_id,
          COALESCE(chattable.problem_type, c2ctable.problem_type, sactable.problem_type) AS problem_type,
          COALESCE(chattable.origin, c2ctable.origin, sactable.origin) AS origin,
          COALESCE(chattable.ml_seller_profile, c2ctable.ml_seller_profile, sactable.ml_seller_profile) AS ml_seller_profile,
          COALESCE(chattable.mp_seller_profile, c2ctable.mp_seller_profile, sactable.mp_seller_profile) AS mp_seller_profile,
          COALESCE(chattable.ml_buyer_profile, c2ctable.ml_buyer_profile, sactable.ml_buyer_profile) AS ml_buyer_profile,
          COALESCE(chattable.business, c2ctable.business, sactable.business) AS business,
          chattable.queue_id AS chat_queue_id,
          c2ctable.queue_id AS c2c_queue_id,
          sactable.queue_id AS sac_queue_id,
          COALESCE(chattable.reason, 'not_requested') AS chat_reason,
          COALESCE(c2ctable.reason, 'not_requested') AS c2c_reason,
          COALESCE(sactable.reason, 'not_requested') AS sac_reason,
          Count(DISTINCT COALESCE(chattable.id, c2ctable.id, sactable.id)) AS quantity,
          Count(DISTINCT COALESCE(chattable.user_id, c2ctable.user_id, sactable.user_id, 'aUserId')) AS unique_quantity
   FROM
     (SELECT v1.id AS id,
             From_unixtime(Unix_timestamp(Regexp_replace(v1.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH:mm') AS requested_datetime_minute,
             v2.site_id AS site_id,
             v3.problem_type AS problem_type,
             v3.reason AS reason,
             v3.origin AS origin,
             v3.is_available AS is_available,
             v3.ml_seller_profile AS ml_seller_profile,
             v3.mp_seller_profile AS mp_seller_profile,
             v3.ml_buyer_profile AS ml_buyer_profile,
             v2.business AS business,
             v2.app_id AS app_id,
             v3.queue_id AS queue_id,
             v4.user_id AS user_id,
             v3.track_id AS track_id
      FROM cx_help_channels tj LATERAL VIEW json_tuple(tj.data, 'application', 'event_data', 'user_timestamp', 'user', 'id', 'path') v1 AS application,
                                            event_data,
                                            user_timestamp,
                                            anuser,
                                            id,
                                            path LATERAL VIEW json_tuple(v1.application, 'app_id', 'business', 'site_id') v2 AS app_id,
                                                              business,
                                                              site_id LATERAL VIEW json_tuple(v1.event_data, 'problem_type', 'reason', 'origin', 'is_available', 'ml_seller_profile', 'mp_seller_profile', 'ml_buyer_profile', 'queue_id', 'environment', 'track_id') v3 AS problem_type,
                                                                                   reason,
                                                                                   origin,
                                                                                   is_available,
                                                                                   ml_seller_profile,
                                                                                   mp_seller_profile,
                                                                                   ml_buyer_profile,
                                                                                   queue_id,
                                                                                   environment,
                                                                                   track_id LATERAL VIEW json_tuple(v1.anuser, 'user_id') v4 AS user_id
      WHERE tj.ds >= '@param01 02'
        AND tj.ds < '@param02 05'
        AND from_unixtime(unix_timestamp(regexp_replace(v1.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH') >= '@param03 23'
        AND from_unixtime(unix_timestamp(regexp_replace(v1.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH') < '@param04 23'
        AND v1.path = '/availability/requested'
        AND v3.environment = 'PRODUCTION'
        AND v2.app_id = 'CHAT') chattable
   FULL OUTER JOIN
     (SELECT v1.id AS id,
             from_unixtime(unix_timestamp(regexp_replace(v1.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH:mm') AS requested_datetime_minute,
             v2.site_id AS site_id,
             v3.problem_type AS problem_type,
             v3.reason AS reason,
             v3.origin AS origin,
             v3.is_available AS is_available,
             v3.ml_seller_profile AS ml_seller_profile,
             v3.mp_seller_profile AS mp_seller_profile,
             v3.ml_buyer_profile AS ml_buyer_profile,
             v2.business AS business,
             v2.app_id AS app_id,
             v3.queue_id AS queue_id,
             v4.user_id AS user_id,
             v3.track_id AS track_id
      FROM cx_help_channels tj LATERAL VIEW json_tuple(tj.data, 'application', 'event_data', 'user_timestamp', 'user', 'id', 'path') v1 AS application,
                                            event_data,
                                            user_timestamp,
                                            anuser,
                                            id,
                                            path LATERAL VIEW json_tuple(v1.application, 'app_id', 'business', 'site_id') v2 AS app_id,
                                                              business,
                                                              site_id LATERAL VIEW json_tuple(v1.event_data, 'problem_type', 'reason', 'origin', 'is_available', 'ml_seller_profile', 'mp_seller_profile', 'ml_buyer_profile', 'queue_id', 'environment', 'track_id') v3 AS problem_type,
                                                                                   reason,
                                                                                   origin,
                                                                                   is_available,

                                                                                   ml_seller_profile,
                                                                                   mp_seller_profile,
                                                                                   ml_buyer_profile,
                                                                                   queue_id,
                                                                                   environment,
                                                                                   track_id LATERAL VIEW json_tuple(v1.anuser, 'user_id') v4 AS user_id
      WHERE tj.ds >= '@param01 02'
        AND tj.ds < '@param02 05'
        AND from_unixtime(unix_timestamp(regexp_replace(v1.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH') >= '@param03 23'
        AND from_unixtime(unix_timestamp(regexp_replace(v1.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH') < '@param04 23'
        AND v1.path = '/availability/requested'
        AND v3.environment = 'PRODUCTION'
        AND v2.app_id = 'CLICKTOCALL') c2ctable ON (c2ctable.track_id = chattable.track_id)
   FULL OUTER JOIN
     (SELECT v1.id AS id,
             from_unixtime(unix_timestamp(regexp_replace(v1.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH:mm') AS requested_datetime_minute,
             v2.site_id AS site_id,
             v3.problem_type AS problem_type,
             v3.reason AS reason,
             v3.origin AS origin,
             v3.is_available AS is_available,
             v3.ml_seller_profile AS ml_seller_profile,
             v3.mp_seller_profile AS mp_seller_profile,
             v3.ml_buyer_profile AS ml_buyer_profile,
             v2.business AS business,
             v2.app_id AS app_id,
             v3.queue_id AS queue_id,
             v4.user_id AS user_id,
             v3.track_id AS track_id
      FROM cx_help_channels tj LATERAL VIEW json_tuple(tj.data, 'application', 'event_data', 'user_timestamp', 'user', 'id', 'path') v1 AS application,
                                            event_data,
                                            user_timestamp,
                                            anuser,
                                            id,
                                            path LATERAL VIEW json_tuple(v1.application, 'app_id', 'business', 'site_id') v2 AS app_id,
                                                              business,
                                                              site_id LATERAL VIEW json_tuple(v1.event_data, 'problem_type', 'reason', 'origin', 'is_available','ml_seller_profile', 'mp_seller_profile', 'ml_buyer_profile', 'queue_id', 'environment', 'track_id') v3 AS problem_type,
                                                                                   reason,
                                                                                   origin,
                                                                                   is_available,
                                                                                   ml_seller_profile,
                                                                                   mp_seller_profile,
                                                                                   ml_buyer_profile,
                                                                                   queue_id,
                                                                                   environment,
                                                                                   track_id LATERAL VIEW json_tuple(v1.anuser, 'user_id') v4 AS user_id
      WHERE tj.ds >= '@param01 02'
        AND tj.ds < '@param02 05'
        AND from_unixtime(unix_timestamp(regexp_replace(v1.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH') >= '@param03 23'
        AND from_unixtime(unix_timestamp(regexp_replace(v1.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH') < '@param04 23'
        AND v1.path = '/availability/requested'
        AND v3.environment = 'PRODUCTION'
        AND v2.app_id = 'SAC') sactable ON (sactable.track_id = nvl(c2ctable.track_id, chattable.track_id))
   GROUP BY COALESCE(chattable.requested_datetime_minute, c2ctable.requested_datetime_minute, sactable.requested_datetime_minute),
            COALESCE(chattable.site_id, c2ctable.site_id, sactable.site_id),
            COALESCE(chattable.problem_type, c2ctable.problem_type, sactable.problem_type),
            COALESCE(chattable.origin, c2ctable.origin, sactable.origin),
            COALESCE(chattable.ml_seller_profile, c2ctable.ml_seller_profile, sactable.ml_seller_profile),
            COALESCE(chattable.mp_seller_profile, c2ctable.mp_seller_profile, sactable.mp_seller_profile),
            COALESCE(chattable.ml_buyer_profile, c2ctable.ml_buyer_profile, sactable.ml_buyer_profile),
            COALESCE(chattable.business, c2ctable.business, sactable.business),
            chattable.queue_id,
            c2ctable.queue_id,
            sactable.queue_id,
            chattable.reason,
            c2ctable.reason,
            sactable.reason) tb
GROUP BY substr(tb.requested_datetime_minute, 1, 13),
         tb.site_id,
         tb.problem_type,
         tb.origin,
         tb.ml_seller_profile,
         tb.mp_seller_profile,
         tb.ml_buyer_profile,
         tb.business,
         tb.chat_queue_id,
         tb.c2c_queue_id,
         tb.sac_queue_id,
         tb.chat_reason,
         tb.c2c_reason,
         tb.sac_reason
