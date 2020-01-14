package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    defaultBusiness = "mercadolibre"

    test("Search Alerts List") {
        "/myaccount/search_alerts/list"(platform: "/", type: TrackType.View) {
            platform = "ML"
            quantity = 2
        }
    }

    test("Search Alerts List Portalinmobiliario") {
        "/myaccount/search_alerts/list"(platform: "/", type: TrackType.View) {
            platform = "PI"
            quantity = 0
        }
    }
}
