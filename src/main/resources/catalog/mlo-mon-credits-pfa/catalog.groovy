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

    def marketplace = ["mercadolibre"]

    marketplace.each { business ->
        include business, "tracking.groovy"
    }
}