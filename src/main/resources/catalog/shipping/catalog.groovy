package catalog.shipping

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

    def shipping = ["shipping"]

    shipping.each { business ->
        include business, "tracking.groovy"
        include business, "labels.groovy"
        include business, "ssm.groovy"
    }
}
