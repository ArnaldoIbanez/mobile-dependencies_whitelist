package src.test.resources

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Recommendations add to cart tracks") {
        "/recommendations/add_to_cart"(platform: "/web/desktop", type: TrackType.Event) {
            backend_id = "l3_l7-ngrams"
            client = "vip_combo"
            direct = true
            items = ["MLB754486062" , "MLB512313"]
            recommendation_id = "4ifmk4-moprk-mfov0-mroas"
            shipping_benefit = "free"

        }
        "/recommendations/add_to_cart"(platform: "/web/mobile", type: TrackType.Event) {
            backend_id = "l3_l7-ngrams"
            client = "vip_combo"
            direct = false
            items = ["MLB754486062" , "MLB512313"]
            recommendation_id = "4ifmk4-moprk-mfov0-mroas"
            shipping_benefit = "none"
        }
        "/recommendations/add_to_cart"(platform: "/mobile/ios", type: TrackType.Event) {
            backend_id = "l3_l7-ngrams"
            client = "vip_combo"
            direct = true
            items = ["MLB754486062" , "MLB512313"]
            recommendation_id = "4ifmk4-moprk-mfov0-mroas"
            shipping_benefit = "free"
        }

        "/recommendations/add_to_cart"(platform: "/mobile/android", type: TrackType.Event) {
            backend_id = "l3_l7-ngrams"
            client = "vip_combo"
            direct = false
            items = ["MLB754486062" , "MLB512313"]
            recommendation_id = "4ifmk4-moprk-mfov0-mroas"
            shipping_benefit = "none"
        }
    }
}


