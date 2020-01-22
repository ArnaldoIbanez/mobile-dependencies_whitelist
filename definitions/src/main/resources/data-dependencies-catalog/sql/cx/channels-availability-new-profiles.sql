SELECT Substr(tb.requested_datetime_minute, 1, 13) AS requested_datetime,
       tb.site_id AS site_id,
       tb.problem_type AS problem_type,
       tb.origin AS origin,
       tb.ml_seller_profile AS ml_seller_profile,
       tb.mp_seller_profile AS mp_seller_profile,
       tb.ml_buyer_profile AS ml_buyer_profile,
       tb.business AS business,
       tb.segment AS segment,
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
          COALESCE(chattable.segment, c2ctable.segment, sactable.segment) AS segment,
          chattable.queue_id AS chat_queue_id,
          c2ctable.queue_id AS c2c_queue_id,
          sactable.queue_id AS sac_queue_id,
          COALESCE(chattable.reason, 'not_requested') AS chat_reason,
          COALESCE(c2ctable.reason, 'not_requested') AS c2c_reason,
          COALESCE(sactable.reason, 'not_requested') AS sac_reason,
          Count(DISTINCT COALESCE(chattable.id, c2ctable.id, sactable.id)) AS quantity,
          Count(DISTINCT COALESCE(chattable.user_id, c2ctable.user_id, sactable.user_id, 'aUserId')) AS unique_quantity
   FROM
     (SELECT tj.id AS id,
             From_unixtime(Unix_timestamp(Regexp_replace(tj.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH:mm') AS requested_datetime_minute,
             jest(tj.event_data, 'custom_site_id') AS site_id,
             jest(tj.event_data, 'problem_type') AS problem_type,
             jest(tj.event_data, 'reason') AS reason,
             jest(tj.event_data, 'origin') AS origin,
             jest(tj.event_data, 'is_available') AS is_available,
             jest(tj.event_data, 'ml_seller_profile') AS ml_seller_profile,
             jest(tj.event_data, 'mp_seller_profile') AS mp_seller_profile,
             jest(tj.event_data, 'ml_buyer_profile') AS ml_buyer_profile,
             tj.application.business AS business,
             jest(tj.event_data, 'segment') AS segment,
             tj.application.app_id AS app_id,
             jest(tj.event_data, 'queue_id') AS queue_id,
             tj.`user`.user_id AS user_id,
             jest(tj.event_data, 'track_id') AS track_id
      FROM cx_help_channels_parquet tj 
      WHERE tj.ds >= '@param01 02'
        AND tj.ds < '@param02 05'
        AND from_unixtime(unix_timestamp(regexp_replace(tj.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH') >= '@param03 23'
        AND from_unixtime(unix_timestamp(regexp_replace(tj.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH') < '@param04 23'
        AND tj.path = '/availability/requested'
        AND jest(tj.event_data, 'environment') = 'PRODUCTION'
        AND tj.application.app_id = 'CHAT') chattable
   FULL OUTER JOIN
     (SELECT tj.id AS id,
             From_unixtime(Unix_timestamp(Regexp_replace(tj.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH:mm') AS requested_datetime_minute,
             jest(tj.event_data, 'custom_site_id') AS site_id,
             jest(tj.event_data, 'problem_type') AS problem_type,
             jest(tj.event_data, 'reason') AS reason,
             jest(tj.event_data, 'origin') AS origin,
             jest(tj.event_data, 'is_available') AS is_available,
             jest(tj.event_data, 'ml_seller_profile') AS ml_seller_profile,
             jest(tj.event_data, 'mp_seller_profile') AS mp_seller_profile,
             jest(tj.event_data, 'ml_buyer_profile') AS ml_buyer_profile,
             tj.application.business AS business,
             jest(tj.event_data, 'segment') AS segment,
             tj.application.app_id AS app_id,
             jest(tj.event_data, 'queue_id') AS queue_id,
             tj.`user`.user_id AS user_id,
             jest(tj.event_data, 'track_id') AS track_id
      FROM cx_help_channels_parquet tj 
      WHERE tj.ds >= '@param01 02'
        AND tj.ds < '@param02 05'
        AND from_unixtime(unix_timestamp(regexp_replace(tj.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH') >= '@param03 23'
        AND from_unixtime(unix_timestamp(regexp_replace(tj.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH') < '@param04 23'
        AND tj.path = '/availability/requested'
        AND jest(tj.event_data, 'environment') = 'PRODUCTION'
        AND tj.application.app_id = 'CLICKTOCALL') c2ctable ON (c2ctable.track_id = chattable.track_id)
   FULL OUTER JOIN
     (SELECT tj.id AS id,
             From_unixtime(Unix_timestamp(Regexp_replace(tj.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH:mm') AS requested_datetime_minute,
             jest(tj.event_data, 'custom_site_id') AS site_id,
             jest(tj.event_data, 'problem_type') AS problem_type,
             jest(tj.event_data, 'reason') AS reason,
             jest(tj.event_data, 'origin') AS origin,
             jest(tj.event_data, 'is_available') AS is_available,
             jest(tj.event_data, 'ml_seller_profile') AS ml_seller_profile,
             jest(tj.event_data, 'mp_seller_profile') AS mp_seller_profile,
             jest(tj.event_data, 'ml_buyer_profile') AS ml_buyer_profile,
             tj.application.business AS business,
             jest(tj.event_data, 'segment') AS segment,
             tj.application.app_id AS app_id,
             jest(tj.event_data, 'queue_id') AS queue_id,
             tj.`user`.user_id AS user_id,
             jest(tj.event_data, 'track_id') AS track_id
      FROM cx_help_channels_parquet tj 
      WHERE tj.ds >= '@param01 02'
        AND tj.ds < '@param02 05'
        AND from_unixtime(unix_timestamp(regexp_replace(tj.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH') >= '@param03 23'
        AND from_unixtime(unix_timestamp(regexp_replace(tj.user_timestamp, 'T', ' ')), 'yyyy-MM-dd HH') < '@param04 23'
        AND tj.path = '/availability/requested'
        AND jest(tj.event_data, 'environment') = 'PRODUCTION'
        AND tj.application.app_id = 'SAC') sactable ON (sactable.track_id = nvl(c2ctable.track_id, chattable.track_id))
   GROUP BY COALESCE(chattable.requested_datetime_minute, c2ctable.requested_datetime_minute, sactable.requested_datetime_minute),
            COALESCE(chattable.site_id, c2ctable.site_id, sactable.site_id),
            COALESCE(chattable.problem_type, c2ctable.problem_type, sactable.problem_type),
            COALESCE(chattable.origin, c2ctable.origin, sactable.origin),
            COALESCE(chattable.ml_seller_profile, c2ctable.ml_seller_profile, sactable.ml_seller_profile),
            COALESCE(chattable.mp_seller_profile, c2ctable.mp_seller_profile, sactable.mp_seller_profile),
            COALESCE(chattable.ml_buyer_profile, c2ctable.ml_buyer_profile, sactable.ml_buyer_profile),
            COALESCE(chattable.business, c2ctable.business, sactable.business),
            COALESCE(chattable.segment, c2ctable.segment, sactable.segment),
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
         tb.segment,
         tb.chat_queue_id,
         tb.c2c_queue_id,
         tb.sac_queue_id,
         tb.chat_reason,
         tb.c2c_reason,
         tb.sac_reason