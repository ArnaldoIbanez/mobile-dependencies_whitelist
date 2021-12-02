package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    test("merchant credits") {
        /******************************************
        *    Start: Self Service
        ******************************************/
        "/credits/self_service/promises/create_form"(platform: "/", type: TrackType.View) {
            user_type = "consumer"
        }

        "/credits/self_service/promises/create_form/submit"(platform: "/", type: TrackType.Event) {
            user_type = "consumer"
            is_partial_amount = true
            bulk_amount = 7000
            promise_amount = 5000
            payment_method = "CASH"
            promise_due_days = 4
        }

        "/credits/self_service/promises/create_form/cancel"(platform: "/", type: TrackType.Event) {
            user_type = "consumer"
        }

        "/credits/self_service/promises/congrats"(platform: "/", type: TrackType.View) {
            user_type = "consumer"
        }

        "/credits/self_service/promises/error"(platform: "/", type: TrackType.View) {
            user_type = "consumer"
        }

        "/credits/self_service/promises/view"(platform: "/", type: TrackType.View) {
            user_type = "consumer"
        }

        "/credits/self_service/debt_relief"(platform: "/", type: TrackType.View) {
            user_type = "consumer"
        }

        "/credits/self_service/debt_relief/summary"(platform: "/", type: TrackType.View) {
            bulk_amount = 7000
            total_amount = 14000
            min_amount = true
            user_type = "consumer"
        }

        "/credits/self_service/debt_relief/accept_summary"(platform: "/", type: TrackType.Event) {
            bulk_amount = 7000
            total_amount = 14000
            installments_id = [ 1002, 1003, 1004]
            user_type = "consumer"
            debt_relief_amount = 6000
        }

        "/credits/self_service/debt_relief/error"(platform: "/", type: TrackType.View) {
            user_type = "merchant"
            error_type = "no_offer"
        }

        /******************************************
        *    End: Self Service
        ******************************************/
    }

    test("Credits Car Loan") {
        "/credits/car_loan/contact"(platform: "/", type: TrackType.View) {
            push_variant = "A"
        }
        "/credits/car_loan/contact/confirm"(platform: "/", type: TrackType.Event) {
            push_variant = "A"
        }
    }
}
