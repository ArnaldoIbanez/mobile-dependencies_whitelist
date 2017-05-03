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

/*
    all.each { business ->
        def allDirectory = new File(CATALOG_DIR + "/all")
        allDirectory.eachFile { file -> 
            def filepath = file.getPath().split('/')
            include business, filepath[-2..-1].join('/')
        }
    }
*/
    marketplace.each { business ->
        def marketplaceDir = new File(CATALOG_DIR + "/marketplace")
        marketplaceDir.eachFile { file ->
            if (!file.getPath().endsWith('cartList.groovy') && !file.getPath().endsWith('cartCheckout.groovy') && !file.getPath().endsWith('myml.groovy')) {
                def filepath = file.getPath().split('/')
                println(filepath)
                include business, filepath[-2..-1].join('/')
            }
        }
    }
/*
    mercadopago.each { business -> 
        def mercadopagoDir = new File(CATALOG_DIR + '/mercadopago')
        mercadopagoDir.eachFile { file -> 
            def filepath = file.getPath().split('/')
            include business, filepath[-2..-1].join('/')
        }
    }
*/
}
