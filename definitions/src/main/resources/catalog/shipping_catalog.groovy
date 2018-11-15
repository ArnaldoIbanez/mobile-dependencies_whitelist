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
            "/"
    ]

    def shipping = ["shipping"]

    shipping.each { business ->
        include business, "labels.groovy"
        include business, "tracking.groovy"
    }

}