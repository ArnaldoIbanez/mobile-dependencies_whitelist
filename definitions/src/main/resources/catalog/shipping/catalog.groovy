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

    def carriers = ["shipping"]

    carriers.each { business ->
        include business, "status.groovy"
    }
}
