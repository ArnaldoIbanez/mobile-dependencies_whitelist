SELECT Count(DISTINCT( usr.user_id ))    AS cant_user,
       Substring(device.platform, 9, 16) AS platform,
       substring_index(application.version, '.',2) AS version,
       Substr(ds, 1, 10)                 AS fecha
FROM   default.tracks
WHERE  ds >= '@param01'
       AND ds < '@param02'
       AND application.business = 'mercadopago'
       AND ( device.platform = '/mobile/ios'
              OR device.platform = '/mobile/android' )
       AND application.version LIKE '2.%.%'
       AND ( path = '/wallet_home/home'
              OR path = '/money_detail/balance'
              OR path = '/instore/scanner_selection'
              OR path = '/money_in/payment_methods'
              OR path = '/withdraw/main'
              OR path = '/asset_management/investment_detail'
              OR path = '/bill_payments/home'
              OR path = '/cellphone_recharge/recent'
              OR path = '/mplayer/send_money/contact_picker'
              OR path = '/single_player/prepaid/start_flow'
              OR path = '/listing/activities'
              OR path = '/accout_fund/cvu/main'
              OR path = '/pos_seller/new_payment' )
GROUP  BY substring_index(application.version, '.',2),
          Substring(device.platform, 9, 16),
          Substr(ds, 1, 10)