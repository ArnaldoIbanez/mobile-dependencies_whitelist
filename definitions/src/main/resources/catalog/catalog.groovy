import static com.ml.melidata.catalog.parsers.dsl.CatalogDsl.catalog
import static com.ml.melidata.catalog.parsers.dsl.CatalogDsl.include

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
        include business, "identity_validation.groovy"
        include business, "melidata_sdk.groovy"
        include business, "registrations.groovy"
        include business, "fiscaldata.groovy"
        include business, "chargebacks.groovy"
        include business, "freeData.groovy"
    }

    marketplace.each { business ->
        include business, "add_to_cart.groovy"
        include business, "bookmarks.groovy"
        include business, "buyIntention.groovy"
        include business, "cartCheckout.groovy"
        include business, "cartList.groovy"
        include business, "cellphone_recharge.groovy"
        include business, "checkout.groovy"
        include business, "credits_marketplace.groovy"
        include business, "cx.groovy"
        include business, "moderations.groovy"
        include business, "email.groovy"
        include business, "freeData.groovy"
        include business, "fulfillment.groovy"
        include business, "home.groovy"
        include business, "loyalty.groovy"
        include business, "make_an_offer.groovy"
        include business, "marketplace.groovy"
        include business, "mediations.groovy"
        include business, "melidata_sdk.groovy"
        include business, "mobile.groovy"
        include business, "myml.groovy"
        include business, "notifications.groovy"
        include business, "onboarding.groovy"
        include business, "orders_feed.groovy"
        include business, "pushNotifications.groovy"
        include business, "quotation.groovy"
        include business, "questions.groovy"
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
    }
    
    mercadopago.each { business ->
        include business, "mercadopago.groovy"
        include business, "checkoutOff.groovy"
        include business, "credits_mercadopago.groovy"
        include business, "mercadopago_mails.groovy"
        include business, "mercadopago_devsite.groovy"
        include business, "cards_prepaid.groovy"
        include business, "cellphone_recharge.groovy"
    }

    mercadoshops.each { business ->
        include business, "authentication.groovy"
        include business, "notifications.groovy"
    }

    mercadoenvios.each { business ->
        include business, "flex.groovy"
    }

}
