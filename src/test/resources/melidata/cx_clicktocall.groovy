package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    defaultBusiness = "mercadolibre"

    test("Console errors") {
        "/cx"(platform: "/web/desktop", type: TrackType.Event) {}
        "/cx/c2c"(platform: "/web/desktop", type: TrackType.Event) {}
        "/cx/c2c/console"(platform: "/web/desktop", type: TrackType.Event) {}
        "/cx/c2c/console/twilio"(platform: "/web/desktop", type: TrackType.Event) {}
        "/cx/c2c/console/twilio/errors"(platform: "/web/desktop", type: TrackType.Event) {
            error_code = "30006"
            error_text = "Error message"
            call_sid = "CA123123XPTO"
            call_id = "1234"
            case_id = "1234"
        }
    }
}
