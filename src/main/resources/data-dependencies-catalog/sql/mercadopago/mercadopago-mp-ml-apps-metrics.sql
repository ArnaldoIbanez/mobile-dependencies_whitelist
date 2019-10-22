SELECT mp_users.user_id AS mp_user_id,
       ml_users.user_id AS ml_user_id
FROM (SELECT DISTINCT (mp.usr.user_id) AS user_id
      FROM tracks mp
      WHERE mp.ds >= '@param01'
      AND   mp.ds < '@param02'
      AND   mp.device.platform LIKE '/mobile/%'
      AND   mp.TYPE = 'view'
      AND   mp.application.business = 'mercadopago'
      AND   mp.application.site_id IN ('MLA','MLB','MLM')) AS mp_users
  FULL OUTER JOIN (SELECT DISTINCT (ml.usr.user_id) AS user_id
                   FROM tracks ml
                   WHERE ml.ds >= '@param01'
                   AND   ml.ds < '@param02'
                   AND   ml.device.platform LIKE '/mobile/%'
                   AND   ml.application.site_id IN ('MLA','MLB','MLM')
                   AND   ml.TYPE = 'view'
                   AND   ml.application.business = 'mercadolibre') AS ml_users ON mp_users.user_id = ml_users.user_id;