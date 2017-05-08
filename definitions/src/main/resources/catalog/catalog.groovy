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
        include business, "cartCheckout.groovy"
        include business, "cartList.groovy"
        include business, "checkout.groovy"
        include business, "email.groovy"
        include business, "home.groovy"
        include business, "loyalty.groovy"
        include business, "marketplace.groovy"
        include business, "myml.groovy"
        include business, "notifications.groovy"
        include business, "quotation.groovy"
        include business, "search.groovy"
        include business, "sell.groovy"
        include business, "vip.groovy"
    }

    mercadopago.each { business ->
        include business, "mercadopago.groovy"
    }

}
