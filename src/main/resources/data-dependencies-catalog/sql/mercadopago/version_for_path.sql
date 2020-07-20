SELECT DISTINCT( version ),
               path,
               Sum(visited_count) AS visited_count,
               platform,
               fecha
FROM  (SELECT DISTINCT( Concat(Split_part(application.version, '.', 1), '.', Split_part(application.version, '.', 2))) AS version,
                       CASE
                            WHEN path = '/instore/scan_qr'
                                THEN 'Pagos QR'
                            WHEN path = '/bill_payments/home'
                                THEN 'Pago de servicios'
                            WHEN path = '/money_in/payment_methods'
                                THEN 'Ingresar Dinero'
                            WHEN path = '/withdraw/main'
                                OR path = '/money_out/transfers/home'
                                THEN 'Retirar Dinero'
                            WHEN path = '/money_detail/balance'
                                THEN 'Balance'
                            WHEN path = '/cellphone_recharge/recents'
                                OR path = '/single_player/prepaid/companies'
                                THEN 'Recarga de celulares'
                            WHEN path = '/single_player/prepaid/start_flow'
                                THEN 'DirecTv/Sky'
                            WHEN path = '/point_payment/qr_show_code'
                                THEN 'Cobros Qr'
                            WHEN path = '/point_payment/device_selection'
                                THEN 'Cobros Point'
                            WHEN path = '/point_payment/link_share'
                                THEN 'Cobro con Link'
                            WHEN path = '/mplayer/send_money/contact_picker'
                                THEN 'Enviar dinero'
                            WHEN path = '/money_out/cashout/ticket'
                                THEN 'Extracción de dinero'
                            WHEN path = '/asset_management/investment_detail'
                                THEN 'Invertir dinero'
                            WHEN path = '/account_fund/cvu/main'
                                THEN 'CVU'
                            WHEN path = '/listing/activities'
                                THEN 'Actividades'
                            WHEN path = '/wallet_home/home'
                                THEN 'Home Wallet'
                       END AS path,
                       Count(path) AS visited_count,
                       Substring(device.platform, 9, 16) AS platform,
                       Substr(ds, 1, 10) AS fecha
        FROM   default.tracks_mp
        WHERE  ds >= '@param01'
               AND ds < '@param02'
               AND bu = 'mercadopago'
               AND ( device.platform = '/mobile/ios'
                      OR device.platform = '/mobile/android' )
               AND application.version LIKE '2.%.%'
               AND ( path = '/instore/scan_qr'
                      OR path = '/bill_payments/home'
                      OR path = '/money_in/payment_methods'
                      OR path = '/withdraw/main'
                      OR path = '/money_out/transfers/home'
                      OR path = '/money_detail/balance'
                      OR path = '/cellphone_recharge/recents'
                      OR path = '/single_player/prepaid/companies'
                      OR path = '/single_player/prepaid/start_flow'
                      OR path = '/point_payment/qr_show_code'
                      OR path = '/point_payment/device_selection'
                      OR path = '/point_payment/link_share'
                      OR path = '/mplayer/send_money/contact_picker'
                      OR path = '/money_out/cashout/ticket'
                      OR path = '/asset_management/investment_detail'
                      OR path = '/account_fund/cvu/main'
                      OR path = '/listing/activities'
                      OR path = '/wallet_home/home' )
        GROUP  BY application.version,
                  path,
                  device.platform,
                  ds)
GROUP  BY version,
          path,
          fecha,
          platform