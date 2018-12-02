package src.test.resources.melidata

import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadolibre"
    test("supermaket") {
        "/supermarket/header"(platform: "/", type: TrackType.View) {
            client_id="test"
            selected_department="test"
            departments=["department"]
        }
        "/supermarket/discovery"(platform: "/", type: TrackType.View) {
            client_id="test"
            selected_department="test"
            departments=["department"]
        }
    }
}