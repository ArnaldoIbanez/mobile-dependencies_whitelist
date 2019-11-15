import static com.ml.melidata.catalog.parsers.dsl.CatalogDsl.catalog

/**
 * Main catalog definitions
 */
catalog {

    /**
     * All available platform
     */

    platforms = [
            "/",
            "/web",
            "/web/desktop",
            "/web/desktop/forced",
            "/web/desktop/static",
            "/web/mobile",
            "/web/mobile/forced",
            "/web/mobile/static",
            "/mobile",
            "/mobile/android",
            "/mobile/ios",
            "/email"
    ]

    abPlatforms = [
            "/web/desktop",
            "/web/mobile",
            "/mobile/android",
            "/mobile/ios"
    ]

    abPlatformsSubscriptions = [
            "/",
            "/web",
            "/web/desktop",
            "/web/mobile",
            "/mobile",
            "/mobile/android",
            "/mobile/ios",
    ]


    def marketplace = [
            "mercadolibre",
            "tucarro",
            "tumoto",
            "tulancha",
            "tuinmueble",
            "autoplaza",
            "metroscubicos",
            "portalinmobiliario"
    ]

    def mercadopago = ["mercadopago"]

    def mercadoshops = ["mercadoshops"]

    def mercadoenvios = ["mercadoenvios"]

    def all = marketplace + mercadopago

    all.each { business ->
        include business, "authentication.groovy"
        include business, "bugsnag.groovy"
        include business, "cx.groovy"
        include business, "identity_validation.groovy"
        include business, "remedies.groovy"
        include business, "melidata_sdk.groovy"
        include business, "registrations.groovy"
        include business, "fiscaldata.groovy"
        include business, "chargebacks.groovy"
        include business, "freeData.groovy"
        include business, "wallet.groovy"
        include business, "px.groovy"
        include business, "mobile_commons.groovy"
        include business, "google_connect.groovy"
        include business, "security_settings.groovy"
        include business, "mgm.groovy"
        include business, "mediations.groovy"
        include business, "esc_manager.groovy"
        include business, "traffic.groovy"
        include business, "coupon.groovy"
        include business, "notifications.groovy"
        include business, "dynamic_stop_landing.groovy"
        include business, "payers_growth.groovy"
        include business, "collaborators.groovy"
        include business, "loyalty_v2.groovy"
    }

    marketplace.each { business ->
        include business, "add_to_cart.groovy"
        include business, "bookmarks.groovy"
        include business, "buyIntention.groovy"
        include business, "cards_cobranded_ml.groovy"
        include business, "cards_prepaid.groovy"
        include business, "cartCheckout.groovy"
        include business, "cartList.groovy"
        include business, "cellphone_recharge.groovy"
        include business, "checkout.groovy"
        include business, "credits_marketplace.groovy"
        include business, "moderations.groovy"
        include business, "email.groovy"
        include business, "freeData.groovy"
        include business, "fulfillment.groovy"
        include business, "home.groovy"
        include business, "loyalty.groovy"
        include business, "make_an_offer.groovy"
        include business, "marketplace.groovy"
        include business, "melidata_sdk.groovy"
        include business, "mobile.groovy"
        include business, "myml.groovy"
        include business, "myml_mercadoshops.groovy"
        include business, "seller_central.groovy"
        include business, "onboarding.groovy"
        include business, "orders_feed.groovy"
        include business, "pushNotifications.groovy"
        include business, "quotation.groovy"
        include business, "quote.groovy"
        include business, "questions.groovy"
        include business, "recommendations.groovy"
        include business, "referralprogram.groovy"
        include business, "reviews.groovy"
        include business, "returns.groovy"
        include business, "search.groovy"
        include business, "sell.groovy"
        include business, "structuredData.groovy"
        include business, "subscriptions.groovy"
        include business, "variations.groovy"
        include business, "vip.groovy"
        include business, "advertising.groovy"
        include business, "classifieds_landings.groovy"
        include business, "instore.groovy"
        include business, "qr_discount.groovy"
        include business, "zip_finder.groovy"
        include business, "current_location.groovy"
        include business, "download_app.groovy"
        include business, "supermarket.groovy"
        include business, "contact.groovy"
        include business, "full.groovy"
        include business, "front_core.groovy"
        include business, "dynamic_links.groovy"
        include business, "sube_recharge.groovy"
        include business, "myaccount_billing.groovy"
        include business, "asset_management.groovy"
        include business, "remedy.groovy"
        include business, "pdp.groovy"
        include business, "qadb.groovy"
        include business, "promotions.groovy"
    }

    mercadopago.each { business ->
        include business, "activities.groovy"
        include business, "mpfrontcore.groovy"
        include business, "account_fund.groovy"
        include business, "bulk_payments.groovy"
        include business, "mercadopago.groovy"
        include business, "checkoutOff.groovy"
        include business, "credits_mercadopago.groovy"
        include business, "mercadopago_mails.groovy"
        include business, "mercadopago_devsite.groovy"
        include business, "cards_cobranded.groovy"
        include business, "cards_prepaid.groovy"
        include business, "cellphone_recharge.groovy"
        include business, "asset_management.groovy"
        include business, "single_player.groovy"
        include business, "instore.groovy"
        include business, "sube_recharge.groovy"
        include business, "transport.groovy"
        include business, "remedy.groovy"
        include business, "digital_account.groovy"
        include business, "front_core.groovy"
        include business, "mplayer.groovy"
        include business, "money_in.groovy"
        include business, "money_out.groovy"
        include business, "pos_seller.groovy"
        include business, "preference.groovy"
        include business, "discount_sellers.groovy"
        include business, "profile_engine.groovy"
        include business, "pos_management.groovy"
        include business, "discount_center.groovy"
        include business, "external.groovy"
        include business, "pos_billings.groovy"
    }

    mercadoshops.each { business ->
        include business, "authentication.groovy"
        include business, "notifications.groovy"
    }

    mercadoenvios.each { business ->
        include business, "flex.groovy"
        include business, "full.groovy"
        include business, "wms.groovy"
        include business, "logistics.groovy"
        include business, "places.groovy"
    }

}
