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
        include business, "melidata_sdk.groovy"
    }

    all.each { business ->
        include business, "registrations.groovy"
    }

    all.each { business ->
        include business, "authentication.groovy"
    }

    marketplace.each { business ->
        include business, "marketplace.groovy"
    }

    mercadopago.each { business ->
        include business, "mercadopago.groovy"
    }
}
