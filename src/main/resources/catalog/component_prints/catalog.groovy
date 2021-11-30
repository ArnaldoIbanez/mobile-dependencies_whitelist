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
            "/web/mobile",
            "/mobile",
            "/mobile/android",
            "/mobile/ios",
    ]

    def marketplace = ["mercadolibre", "portalinmobiliario"]

    def mercadopago = ["mercadopago"]

    def all = marketplace + mercadopago

    all.each { business ->
        include business, "tracking.groovy"
        include business, "front_core.groovy"
    }
}