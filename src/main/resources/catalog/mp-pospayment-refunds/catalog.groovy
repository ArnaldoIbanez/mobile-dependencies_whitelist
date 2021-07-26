import static com.ml.melidata.catalog.parsers.dsl.CatalogDsl.catalog

/**
 * Main catalog definitions
 */

catalog {
    /**
     * All available platform
     */

    platforms = [
            '/',
            '/mobile',
    ]

    def marketplace = ['mercadopago']

    marketplace.each { business ->
        include business, 'tracking.groovy'
    }
}
