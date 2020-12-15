package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("Bill Detail") {
        "/myaccount/billing/detail"(platform: "/", type: TrackType.View) {
            bill_exp_date = 20201026
            has_cancelled_payments = true
            has_debt = false
            has_taxes = true
            is_expired_bill = false
            is_open_bill = true
            is_paid_bill = true
            user_can_pay = false
        }

        "/myaccount/billing/detail"(platform: "/", type: TrackType.Event) {
            bill_exp_date = 20201026
            has_cancelled_payments = true
            has_debt = false
            has_taxes = true
            is_expired_bill = false
            is_open_bill = true
            is_paid_bill = true
            user_can_pay = false
            type = "BILL_DETAIL_CARD_CLICK_PAY"
        }
    }

    test("Summary Info") {
            "/myaccount/billing/summary"(platform: "/", type: TrackType.View) {
                bills_to_pay = 2
                total_debt = 2.56
                has_automatic_debit = true
                is_subscription_user =true
            }

            "/myaccount/billing/summary"(platform: "/", type: TrackType.Event) {
                bills_to_pay = 2
                total_debt = 2.56
                has_automatic_debit = true
                is_subscription_user =true
                type = "SUMMARY_AUT_DEBIT_CONFIG"
            }
        }

    test("Reporting Info") {
            "/myaccount/billing/reports"(platform: "/", type: TrackType.View) {
            }

            "/myaccount/billing/reports"(platform: "/", type: TrackType.Event) {
                type = "REPORTING_DOWNLOAD_DETAIL"
            }
        }
}
