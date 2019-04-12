SELECT vips_view.sit as site, vips_view.dev as device, vips_view.tvip as total_vips, buy_intention.tvip as amount_buy, cart_intention.tvip as amount_cart, grats_common.tvip as amount_buy_real, grats_cart.tvip as amount_cart_real, vips_view.dateS as ds
FROM
        (select application.site_id as sit, device.platform as dev, count(*) as tvip, substr(ds,1,10) as dateS
          from tracks t
          WHERE ds >= '@param01'
          AND   ds < '@param02'
          AND application.business = 'mercadolibre'
          AND application.site_id in ('MLA','MLM','MLB','MPE','MCO','MLC','MLU','MLV')
          and path in ('/vip') and jest(event_data, 'vertical') = 'core'
          and ((application.version rlike '(9\.29[0-9]*\.)|(9\.[3-9][0-9]\.)|(9\.[0-9]{3,}\.)|([1-9][0-9]{1,}\.[0-9]+\.)'
          and device.platform = '/mobile/android') or (application.version rlike '(10\.4[3-9]\.)|(10\.[4-9][3-9]\.)|(10\.[5-9][0-9]\.)|(10\.[0-9]{3,}\.)|([0-9]{3,}\.[0-9]+\.)|([1-9][1-9]\.[0-9]{1,}\.)' and device.platform = '/mobile/ios')
          or (device.platform LIKE '/web/desktop') or (device.platform LIKE '/web/mobile'))
          and type = 'view'
          group by application.site_id, device.platform, substr(ds,1,10)
          ) vips_view
        JOIN
          (select application.site_id as sit, device.platform as dev, count(*) as tvip, substr(ds,1,10) as dateS
          from tracks t
          WHERE ds >= '@param01'
          AND   ds < '@param02'
          AND application.business = 'mercadolibre'
          AND application.site_id in ('MLA','MLM','MLB','MPE','MCO','MLC','MLU','MLV')
          and path in ('/vip/buy_action') and jest(event_data, 'vertical') = 'core'
          and ((application.version rlike '(9\.29[0-9]*\.)|(9\.[3-9][0-9]\.)|(9\.[0-9]{3,}\.)|([1-9][0-9]{1,}\.[0-9]+\.)' and device.platform = '/mobile/android')
          or (application.version rlike '(10\.4[3-9]\.)|(10\.[4-9][3-9]\.)|(10\.[5-9][0-9]\.)|(10\.[0-9]{3,}\.)|([0-9]{3,}\.[0-9]+\.)|([1-9][1-9]\.[0-9]{1,}\.)' and device.platform = '/mobile/ios')
          or (device.platform LIKE '/web/desktop') or (device.platform LIKE '/web/mobile')) group by application.site_id, device.platform, substr(ds,1,10)
          ) buy_intention
        ON (buy_intention.sit = vips_view.sit and buy_intention.dev = vips_view.dev)
        LEFT JOIN
          (select application.site_id as sit, device.platform as dev, count(*) as tvip, substr(ds,1,10) as dateS
          from tracks t
          WHERE ds >= '@param01'
          AND   ds < '@param02'
          AND   application.business = 'mercadolibre'
          AND   application.site_id in ('MLA','MLM','MLB','MPE','MCO','MLC','MLU','MLV')
          and path in ('/vip/add_cart_action')
          and jest(event_data, 'vertical') = 'core'
          and ((application.version rlike '(9\.29[0-9]*\.)|(9\.[3-9][0-9]\.)|(9\.[0-9]{3,}\.)|([1-9][0-9]{1,}\.[0-9]+\.)' and device.platform = '/mobile/android') or (application.version rlike '(10\.4[3-9]\.)|(10\.[4-9][3-9]\.)|(10\.[5-9][0-9]\.)|(10\.[0-9]{3,}\.)|([0-9]{3,}\.[0-9]+\.)|([1-9][1-9]\.[0-9]{1,}\.)' and device.platform = '/mobile/ios') or (device.platform LIKE '/web/desktop') or (device.platform LIKE '/web/mobile'))
          group by application.site_id, device.platform, substr(ds,1,10)
          ) cart_intention
        ON (cart_intention.sit = vips_view.sit and cart_intention.dev = vips_view.dev)
        JOIN
          (select application.site_id as sit, device.platform as dev, count(*) as tvip, substr(ds,1,10) as dateS
          from tracks t
          WHERE ds >= '@param01'
          AND   ds < '@param02'
          AND   application.business = 'mercadolibre'
          AND   application.site_id in ('MLA','MLM','MLB','MPE','MCO','MLC','MLU','MLV')
          and path in ('/checkout/congrats')
          and ((application.version rlike '(9\.29[0-9]*\.)|(9\.[3-9][0-9]\.)|(9\.[0-9]{3,}\.)|([1-9][0-9]{1,}\.[0-9]+\.)' and device.platform = '/mobile/android') or (application.version rlike '(10\.4[3-9]\.)|(10\.[4-9][3-9]\.)|(10\.[5-9][0-9]\.)|(10\.[0-9]{3,}\.)|([0-9]{3,}\.[0-9]+\.)|([1-9][1-9]\.[0-9]{1,}\.)' and device.platform = '/mobile/ios') or (device.platform LIKE '/web/desktop') or (device.platform LIKE '/web/mobile'))
          and type = 'view'
          group by application.site_id, device.platform, substr(ds,1,10)
          ) grats_common
        ON (grats_common.sit = vips_view.sit and grats_common.dev = vips_view.dev)
        LEFT JOIN
          (select application.site_id as sit, device.platform as dev, count(*) as tvip, substr(ds,1,10) as dateS
          from tracks t
          WHERE ds >= '@param01'
          AND   ds < '@param02'
          AND   application.business = 'mercadolibre'
          AND   application.site_id in ('MLA','MLM','MLB','MPE','MCO','MLC','MLU','MLV')
          and path in ('/cart/checkout/congrats')
          and ((application.version rlike '(9\.29[0-9]*\.)|(9\.[3-9][0-9]\.)|(9\.[0-9]{3,}\.)|([1-9][0-9]{1,}\.[0-9]+\.)' and device.platform = '/mobile/android') or (application.version rlike '(10\.4[3-9]\.)|(10\.[4-9][3-9]\.)|(10\.[5-9][0-9]\.)|(10\.[0-9]{3,}\.)|([0-9]{3,}\.[0-9]+\.)|([1-9][1-9]\.[0-9]{1,}\.)' and device.platform = '/mobile/ios') or (device.platform LIKE '/web/desktop') or (device.platform LIKE '/web/mobile'))
          and type = 'view'
          group by application.site_id, device.platform, substr(ds,1,10)
          ) grats_cart
        ON (grats_cart.sit = vips_view.sit and grats_cart.dev = vips_view.dev)