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
            opened_bill = true
            row_type = "Charge"
        }
    }

    test("Summary Info") {
            "/myaccount/billing/summary"(platform: "/", type: TrackType.View) {
                bills_to_pay = 2
                total_debt = 2.56
                has_automatic_debit = true
                completed = true
            }
    }

    test("Search Alerts List") {
        "/myaccount/search_alerts/list"(platform: "/", type: TrackType.View) {
            platform = "ML"
            quantity = 2
        }
    }

    test("Search Alerts List") {
        "/myaccount/search_alerts/list"(platform: "/", type: TrackType.View) {
            platform = "PI"
            quantity = 0
        }
    }
}
