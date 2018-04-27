SELECT
  DAY, SITE, PLATFORM,

  COUNT(DISTINCT case when TYPE = 'view' and path = '/return/typifications' then USER_ID end) as TYPIFICATIONS,
  COUNT(DISTINCT case when TYPE = 'event_gtc' and path = '/return/typifications' then USER_ID end) as TYPIFICATIONS_WENT_CLAIMS,
  COUNT(DISTINCT case when path = '/return/payments' then USER_ID end) as PAYMENTS,
  COUNT(DISTINCT case when path = '/return/shipping' then USER_ID end) as SHIPPING,
  COUNT(DISTINCT case when path = '/return/pickup' or path = '/return/delivery' or path = '/return/review' then USER_ID end) as REVIEW_PICKUP_DELIVERY,
  COUNT(DISTINCT case when path = '/return/pickup' then USER_ID end) as PICKUP,
  COUNT(DISTINCT case when path = '/return/delivery' then USER_ID end) as DELIVERY,
  COUNT(DISTINCT case when path = '/return/review' then USER_ID end) as REVIEW,
  COUNT(DISTINCT case when path = '/return/congrats' then USER_ID end) as CONGRATS,

  COUNT(DISTINCT case when path = '/return/payments' and REF = 'mediations_init' then USER_ID end) as PAYMENTS_FROM_CLAIMS,
  COUNT(DISTINCT case when path = '/return/shipping' and REF = 'mediations_init' then USER_ID end) as SHIPPING_FROM_CLAIMS,
  COUNT(DISTINCT case when path in ('/return/pickup', '/return/delivery', '/return/review') and REF = 'mediations_init' then USER_ID end) as REVIEW_PICKUP_DELIVERY_FROM_CLAIMS,
  COUNT(DISTINCT case when path = '/return/pickup' and REF = 'mediations_init' then USER_ID end) as PICKUP_FROM_CLAIMS,
  COUNT(DISTINCT case when path = '/return/delivery' and REF = 'mediations_init' then USER_ID end) as DELIVERY_FROM_CLAIMS,
  COUNT(DISTINCT case when path = '/return/review' and REF = 'mediations_init' then USER_ID end) as REVIEW_FROM_CLAIMS,
  COUNT(DISTINCT case when path = '/return/congrats' and REF = 'mediations_init' then USER_ID end) as CONGRATS_FROM_CLAIMS,

  COUNT(DISTINCT case when path = '/return/error' and PREVIOUS_STEP is null then USER_ID end) TYPIFICATIONS_ERROR,
  COUNT(DISTINCT case when path = '/return/error' and PREVIOUS_STEP = 'typification' then USER_ID end) PAYMENTS_ERROR,
  COUNT(DISTINCT case when path = '/return/error' and PREVIOUS_STEP = 'payments' then USER_ID end) SHIPPING_ERROR,
  COUNT(DISTINCT case when path = '/return/error' and PREVIOUS_STEP = 'shipping' then USER_ID end) REVIEW_PICKUP_DELIVERY_ERROR,
  COUNT(DISTINCT case when path = '/return/error' and PREVIOUS_STEP in ('review', 'pickup', 'delivery') then USER_ID end) CONGRATS_ERROR

FROM (
    select
        substr(ds, 1, 10) DAY,
        application.site_id SITE,
        device.platform PLATFORM,
        usr.user_id USER_ID,
        (case type when 'event' then 'event_gtc' else type end) TYPE,
        path PATH,
        jest(event_data, 'previous_step') PREVIOUS_STEP,
        jest(event_data, 'ref') REF
    from default.tracks
    where path like '/return/%'
        and ds >= '@param01' and ds < '@param02'
        and application.site_id in ('MLM', 'MLA', 'MLB')
        and (type = 'view' or (type = 'event' and path='/return/typifications' and (jest(event_data, 'typification') in ('go_to_claim', 'gtc_other_problem', 'other_reaseon_gtc', 'other_reason_gtc') or jest(event_data, 'dictionary_data.typification') in ('go_to_claim', 'gtc_other_problem', 'other_reaseon_gtc', 'other_reason_gtc'))))
) Y
GROUP BY DAY, SITE, PLATFORM
