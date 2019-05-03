SELECT
       SITE, PLATFORM,

       COUNT(DISTINCT case when TYPE = 'view' and path = '/return/potential_resolutions' then USER_ID end) as POTENTIAL_RESOLUTIONS,
       COUNT(DISTINCT case when path = '/return/potential_resolutions/selection' then USER_ID end) as POTENTIAL_RESOLUTIONS_WENT_CLAIMS,
       COUNT(DISTINCT case when TYPE = 'view' and path = '/return/typifications' then USER_ID end) as TYPIFICATIONS,
       COUNT(DISTINCT case when path = '/return/typifications/selection' then USER_ID end) as TYPIFICATIONS_WENT_CLAIMS,
       COUNT(DISTINCT case when path = '/return/conditions' then USER_ID end) as CONDITIONS,
       COUNT(DISTINCT case when path = '/return/payments' then USER_ID end) as PAYMENTS,
       COUNT(DISTINCT case when path = '/return/shipping' then USER_ID end) as SHIPPING,
       COUNT(DISTINCT case when path = '/return/pickup' or path = '/return/delivery' or path = '/return/review' then USER_ID end) as REVIEW_PICKUP_DELIVERY,
       COUNT(DISTINCT case when path = '/return/pickup' then USER_ID end) as PICKUP,
       COUNT(DISTINCT case when path = '/return/delivery' then USER_ID end) as DELIVERY,
       COUNT(DISTINCT case when path = '/return/review' then USER_ID end) as REVIEW,
       COUNT(DISTINCT case when path = '/return/congrats' then USER_ID end) as CONGRATS,

       COUNT(DISTINCT case when path = '/return/potential_resolutions' and REF = 'mediations_init' and TYPE = 'view' then USER_ID end) as POTENTIAL_RESOLUTIONS_FROM_CLAIMS,
       COUNT(DISTINCT case when path = '/return/typifications' and REF = 'mediations_init' and TYPE = 'view' then USER_ID end) as TYPIFICATIONS_FROM_CLAIMS,
       COUNT(DISTINCT case when path = '/return/conditions' and REF = 'mediations_init' then USER_ID end) as CONDITIONS_FROM_CLAIMS,
       COUNT(DISTINCT case when path = '/return/payments' and REF = 'mediations_init' then USER_ID end) as PAYMENTS_FROM_CLAIMS,
       COUNT(DISTINCT case when path = '/return/shipping' and REF = 'mediations_init' then USER_ID end) as SHIPPING_FROM_CLAIMS,
       COUNT(DISTINCT case when path in ('/return/pickup', '/return/delivery', '/return/review') and REF = 'mediations_init' then USER_ID end) as REVIEW_PICKUP_DELIVERY_FROM_CLAIMS,
       COUNT(DISTINCT case when path = '/return/pickup' and REF = 'mediations_init' then USER_ID end) as PICKUP_FROM_CLAIMS,
       COUNT(DISTINCT case when path = '/return/delivery' and REF = 'mediations_init' then USER_ID end) as DELIVERY_FROM_CLAIMS,
       COUNT(DISTINCT case when path = '/return/review' and REF = 'mediations_init' then USER_ID end) as REVIEW_FROM_CLAIMS,
       COUNT(DISTINCT case when path = '/return/congrats' and REF = 'mediations_init' then USER_ID end) as CONGRATS_FROM_CLAIMS,

       COUNT(DISTINCT case when path = '/return/error' and PREVIOUS_STEP is null then USER_ID end) ORDERID_ERROR,
       COUNT(DISTINCT case when path = '/return/error' and PREVIOUS_STEP = 'potential_resolutions' then USER_ID end) POTENTIAL_RESOLUTIONS_ERROR,
       COUNT(DISTINCT case when path = '/return/error' and PREVIOUS_STEP = 'typifications' then USER_ID end) TYPIFICATIONS_ERROR,
       COUNT(DISTINCT case when path = '/return/error' and PREVIOUS_STEP = 'conditions' then USER_ID end) CONDITIONS_ERROR,
       COUNT(DISTINCT case when path = '/return/error' and PREVIOUS_STEP = 'payments' then USER_ID end) PAYMENTS_ERROR,
       COUNT(DISTINCT case when path = '/return/error' and PREVIOUS_STEP = 'shipping' then USER_ID end) SHIPPING_ERROR,
       COUNT(DISTINCT case when path = '/return/error' and PREVIOUS_STEP = 'review' then USER_ID end) REVIEW_ERROR,
       COUNT(DISTINCT case when path = '/return/error' and PREVIOUS_STEP = 'pickup' then USER_ID end) PICKUP_ERROR,
       COUNT(DISTINCT case when path = '/return/error' and PREVIOUS_STEP = 'delivery' then USER_ID end) DELIVERY_ERROR,

       DAY
FROM (
     select
            substr(ds, 1, 10) DAY,
            application.site_id SITE,
            device.platform PLATFORM,
            usr.user_id USER_ID,
            type TYPE,
            path PATH,
            jest(event_data, 'previous_step') PREVIOUS_STEP,
            jest(event_data, 'ref') REF
     from default.tracks
     where path like '/return/%'
       and ds >= '@param01' and ds < '@param02'
       and application.site_id in ('MLM', 'MLA', 'MLB')
       and (type = 'view' or (path='/return/typifications/selection' and (jest(event_data, 'typification') in ('go_to_claim', 'gtc_other_problem', 'other_reaseon_gtc', 'other_reason_gtc') or jest(event_data, 'dictionary_data.typification') in ('go_to_claim', 'gtc_other_problem', 'other_reaseon_gtc', 'other_reason_gtc'))))
     ) Y
GROUP BY DAY, SITE, PLATFORM
