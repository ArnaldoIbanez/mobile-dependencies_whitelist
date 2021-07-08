package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("Bill Detail") {
        "/billing/detail"(platform: "/", type: TrackType.View) {
            bill_exp_date = 20201026
            has_cancelled_payments = true
            has_debt = false
            has_taxes = true
            is_expired_bill = false
            is_open_bill = true
            is_paid_bill = true
            user_can_pay = false
        }

        "/billing/detail"(platform: "/", type: TrackType.Event) {
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
        "/billing/summary"(platform: "/", type: TrackType.View) {
            bills_to_pay = 2
            total_debt = 2.56
            has_automatic_debit = true
            is_subscription_user =true
        }

        "/billing/summary"(platform: "/", type: TrackType.Event) {
            bills_to_pay = 2
            total_debt = 2.56
            has_automatic_debit = true
            is_subscription_user =true
            type = "SUMMARY_AUT_DEBIT_CONFIG"
        }
    }

    test("Reporting Info") {
        "/billing/reports"(platform: "/", type: TrackType.View) {
        }

        "/billing/reports"(platform: "/", type: TrackType.Event) {
            type = "REPORTING_DOWNLOAD_DETAIL"
        }
    }

    test("Legal Documents") {
        "/billing/legal_documents"(platform: "/", type: TrackType.View) {
        }

        "/billing/legal_documents"(platform: "/", type: TrackType.Event) {
            type = "LEGAL_DOCUMENTS_DOWNLOAD_BUTTON_CLICK"
        }
    }

    test("Payment") {
        "/billing/payment"(platform: "/", type: TrackType.Event) {
          total_debt = 550
          amount_to_pay = 500
          periods_count = 3
          periods_to_pay_count = 2
        }

        "/billing/payment/congrats"(platform: "/", type: TrackType.View) {
          amount = 500
          has_automatic_debit = false
        }
    }
}
