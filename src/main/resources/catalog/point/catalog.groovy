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
            "/api",
            "/backend"
    ]

    def mercadopago = ["mercadopago"]

    mercadopago.each { business ->
        include business, "tracking.groovy"
    }
}