package src.test.resources.merch

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    ["mercadolibre", "mercadopago"].each { business ->
		defaultBusiness = business
		test("Merch ${business} tests") {
            
            "/merch"(platform: "/mobile", type: TrackType.View) {
                content_id = "content_id"
                component_id = "component_id"
            }

            "/merch/dismiss"(platform: "/mobile", type: TrackType.Event) {
                content_id = "content_id"
                component_id = "component_id"
            }
        }
    }
}