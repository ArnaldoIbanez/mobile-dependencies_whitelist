import static com.ml.melidata.catalog.parsers.dsl.CatalogDsl.catalog
import static com.ml.melidata.catalog.parsers.dsl.CatalogDsl.include

def CATALOG_DIR = "src/main/resources/catalog/"

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
            "/web/desktop/forced",
            "/web/mobile",
            "/web/mobile/forced",
            "/web/mobile/static",
            "/mobile",
            "/mobile/android",
            "/mobile/ios",
            "/email"
    ]

    def marketplace = [
           "mercadolibre",
           "tucarro",
           "tumoto",
           "tulancha",
           "tuinmueble",
           "autoplaza",
           "metroscubicos",
           "portalinmobiliario"
    ]

    def mercadopago = ["mercadopago"]

    def all = marketplace + mercadopago


    all.each { business ->
        def allDirectory = new File(CATALOG_DIR + "/all")
        allDirectory.eachFile { file ->
            def filepath = file.getPath().split('/')[-2..-1].join('/')
            include business, filepath
        }
    }

    marketplace.each { business ->
        def marketplaceDir = new File(CATALOG_DIR + "/marketplace")
        marketplaceDir.eachFile { file ->
            def filepath = file.getPath().split('/')[-2..-1].join('/')
            include business, filepath
        }
    }

    mercadopago.each { business ->
        def mercadopagoDir = new File(CATALOG_DIR + '/mercadopago')
        mercadopagoDir.eachFile { file ->
            def filepath = file.getPath().split('/')[-2..-1].join('/')
            include business, filepath
        }
    }

}
