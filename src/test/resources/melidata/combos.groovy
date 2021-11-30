package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    defaultBusiness = "mercadolibre"

    test("Combos :: Show congrats details tracking") {

        "/combos/print"(platform: "/") {
        }


        "/combos/add_to_cart"(platform: "/") {
            backend_id= "machinalis-vip-combos"
            client = "vip-combos"
            item = "MLB1001877141"
            items = []
            quantity = 1
            experiments: null
        }


         "/combos/checked"(platform: "/") {
            backend_id= "machinalis-vip-combos"
            client = "vip-combos"
            item = "MLB1001877141"
            items = []
            quantity = 1
            experiments: null
        }

        "/combos/view"(platform: "/") {
            backend_id= "machinalis-vip-combos"
            client = "vip-combos"
            item = "MLB1001877141"
            items = []
            quantity = 1
            experiments: null
        }
        
    }
    
}