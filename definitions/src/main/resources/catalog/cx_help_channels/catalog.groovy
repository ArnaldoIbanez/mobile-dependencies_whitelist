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

    def marketplace = ["mercadolibre"]

    def mercadopago = ["mercadopago"]

    def mercadoshops = ["mercadoshops"]

    def all = marketplace + mercadopago + mercadoshops

    all.each { business ->
        include business, "tracking.groovy"
    }
}