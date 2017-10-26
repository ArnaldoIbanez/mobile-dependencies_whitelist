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

    def all = marketplace + mercadopago


    all.each { business ->
        include business, "authentication.groovy"
        include business, "identity_validation.groovy"
        include business, "melidata_sdk.groovy"
        include business, "registrations.groovy"
    }

    marketplace.each { business ->
        include business, "buyIntention.groovy"
        include business, "cartCheckout.groovy"
        include business, "cartList.groovy"
        include business, "checkout.groovy"
        include business, "credits_marketplace.groovy"
        include business, "email.groovy"
        include business, "home.groovy"
        include business, "loyalty.groovy"
        include business, "referralprogram.groovy"
        include business, "marketplace.groovy"
        include business, "myml.groovy"
        include business, "notifications.groovy"
        include business, "onboarding.groovy"
        include business, "quotation.groovy"
        include business, "search.groovy"
        include business, "sell.groovy"
        include business, "vip.groovy"
        include business, "returns.groovy"
        include business, "freeData.groovy"
    }

    mercadopago.each { business ->
        include business, "mercadopago.groovy"
        include business, "checkoutOff.groovy"
        include business, "credits_mercadopago.groovy"
        include business, "mercadopago_mails.groovy"
    }

}
