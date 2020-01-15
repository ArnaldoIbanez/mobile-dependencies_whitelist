package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    defaultBusiness = "mercadolibre"

    test("Search Alerts List") {
        "/myaccount/search_alerts/list"(platform: "/", type: TrackType.View) {
            quantity = 2
        }
    }

    test("Search Alerts List Empty") {
        "/myaccount/search_alerts/list"(platform: "/", type: TrackType.View) {
            quantity = 0
        }
    }
}
