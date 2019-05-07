package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("Bill Detail") {
        "/myaccount/billing/detail"(platform: "/", type: TrackType.View) {
            opened_bill = true
        }
    }

    test("Bill Detail collapsible") {
        "/myaccount/billing/detail/collapsible"(platform: "/", type: TrackType.Event) {
            openedBill = true
            row_type = "Charge"
        }
    }
}
