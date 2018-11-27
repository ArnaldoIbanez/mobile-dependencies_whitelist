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

    def melidata = ["melidata"]

    melidata.each { business ->
        include business, "track1.groovy"
        include business, "track2.groovy"
    }

}
