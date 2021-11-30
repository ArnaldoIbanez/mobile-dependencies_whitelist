package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    defaultBusiness = "mercadolibre"

    test("Combos :: Show congrats details tracking") {

        "/combos/print"(platform: "/") {
            backend_id= "machinalis-vip-combos"
            client = "vip-combos"
            track_info = null
            has_errors = false
            item = "MLB1001877141"
            items = []
        }

        "/combos/add_to_cart"(platform: "/") {
            backend_id= "machinalis-vip-combos"
            client = "vip-combos"
            track_info = null
            has_errors = false
            item = "MLB1001877141"
            items = []
            quantity = 1
        }


         "/combos/checked"(platform: "/") {
            backend_id= "machinalis-vip-combos"
            client = "vip-combos"
            track_info = null
            has_errors = false
            item = "MLB1001877141"
            items = []
            quantity = 1
        }

        "/combos/view"(platform: "/") {
            backend_id= "machinalis-vip-combos"
            track_info = null
            has_errors = false
            client = "vip-combos"
            item = "MLB1001877141"
            items = []
            quantity = 1
        }
        
    }
    
}