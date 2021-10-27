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

    def mercadolibre = ["mercadolibre"]

    def mercadopago = ["mercadopago"]

    mercadolibre.each { business ->
        include business, "tracking.groovy"
    }

    mercadopago.each { business ->
        include business, "tracking.groovy"
    }
}