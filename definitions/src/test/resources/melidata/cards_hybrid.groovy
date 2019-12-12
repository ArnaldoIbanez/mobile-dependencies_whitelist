package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    //-----------------
    // HYBRID
    //-----------------


    // SHIPPING
    // --------

    //Shipping: Tracking
    test("cards hybrid shipping tracking") {
        "/hybrid/shipping/tracking"(platform: "/", type: TrackType.View) {
            banner_is_present = false
            contact_is_present = true
        }
        "/hybrid/shipping/tracking/tap"(platform:"/", type: TrackType.Event) {
            action = "contact"
        }
        "/hybrid/shipping/tracking/show"(platform:"/", type: TrackType.Event) {
            component_id = "banner_unlock"
        }

    }
    //Shipping: Delayed
    test("cards hybrid shipping delayed") {
        "/hybrid/shipping/delayed"(platform: "/", type: TrackType.View) {}
        "/hybrid/shipping/delayed/tap"(platform:"/", type: TrackType.Event) {
            action = "reissue"
        }
    }
}