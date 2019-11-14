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

    def recommendations = ["recommendations"]

    recommendations.each { business ->
        include business, "tracking.groovy"
    }
}