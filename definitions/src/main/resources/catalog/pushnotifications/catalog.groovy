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

    def pushnotifications = ["pushnotifications"]

    pushnotifications.each { business ->
        include business, "tracking.groovy"
    }
}