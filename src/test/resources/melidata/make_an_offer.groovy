package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {
    defaultBusiness = "mercadolibre"

    test("melidata make-an-offer track") {

        "/make-an-offer"(platform: "/", type: TrackType.View) {}

        "/make-an-offer/congrats"(platform: "/", type: TrackType.View) {}

        "/make-an-offer/send-offer"(platform: "/", type: TrackType.Event) {
            offer = 50000
        }
    }
}