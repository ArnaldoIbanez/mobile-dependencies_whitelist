package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("Bill Detail") {
        "/myaccount"(platform: "/") {}
        "/myaccount/billing"(platform: "/") {}
        "/myaccount/billing/detail"(platform: "/", type: TrackType.View) {
            userId = 123
            openedBill = true
            siteId = "MLA"
        }
    }

    test("Bill Detail collapsible") {
        "/myaccount"(platform: "/") {}
        "/myaccount/billing"(platform: "/") {}
        "/myaccount/billing/detail"(platform: "/") {}
        "/myaccount/billing/detail/collapsible"(platform: "/", type: TrackType.Event) {
            userId = 123
            openedBill = true
            siteId = "MLA"
        }
    }
}
