SELECT
  COUNT(*) AS total, t1.event_type, milestone, bucket, t1.date_sent
FROM
 (
    SELECT
      DISTINCT
      jest(event_data, 'email_id')              AS  email_id,
      SUBSTR(ds, 1, 10)                         AS  date_sent,
      path,
      jest(event_data, 'email_template')        AS  template,
      jest(event_data, 'event_type')            AS  event_type,
      jest(event_data, 'milestone')             AS  milestone,
      jest(event_data, 'bucket')                AS  bucket,
      SUBSTR(jest(event_data, 'sent_date'), 1, 10) sent_date
    FROM tracks
    where type = 'event'
          AND path = '/email/generic'
          AND (ds >= '@param01' AND ds < '@param02')
          AND jest(event_data, 'email_template') = 'CONS_COLLECTION'
          AND jest(event_data, 'event_type') = 'send'
          AND application.site_id = 'MLA'

    UNION

    SELECT
      DISTINCT
      jest(event_data, 'email_id')       AS        email_id,
      SUBSTR(ds, 1, 10)                  AS        date_sent,
      path,
      jest(event_data, 'email_template') AS        template,
      jest(event_data, 'event_type')     AS        event_type,
      milestone,
      bucket,
      SUBSTR(jest(event_data, 'sent_date'), 1, 10) sent_date
    FROM tracks
      LEFT JOIN
      (SELECT
         jest(event_data, 'email_id')    AS email_id,
         jest(event_data, 'milestone')   AS milestone,
         jest(event_data, 'bucket')      AS bucket
       FROM tracks
       WHERE
         type = 'event'
         AND path = '/email/generic'
         AND (ds >= '@param03' AND ds < '@param02')
         AND jest(event_data, 'email_template') = 'CONS_COLLECTION'
         AND jest(event_data, 'event_type') = 'send'
         AND application.site_id = 'MLA') TRACKDATA
        ON jest(event_data, 'email_id') = TRACKDATA.email_id
    WHERE
      type = 'event'
      AND path = '/email/generic'
      AND (ds >= '@param01' and ds < '@param02')
      AND jest(event_data, 'email_template') = 'CONS_COLLECTION'
      AND jest(event_data, 'event_type') = 'open'
      AND application.site_id = 'MLA'
  )
 AS t1
GROUP BY
 t1.event_type, t1.date_sent, milestone, bucket