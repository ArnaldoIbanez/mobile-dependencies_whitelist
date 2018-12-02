package src.test.resources.shipping

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "carriers"

    test("Shipping test path") {

        "/shipping/tracking"(platform: "/backend", type: TrackType.Event) {
            status_code = "200"
        }


        "/shipping/tracking/select_status"(platform: "/backend", type: TrackType.Event) {
            status_selected = "rojo"
        }
    }
}
