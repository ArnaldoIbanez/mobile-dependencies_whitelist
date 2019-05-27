package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    test("Account Fund - views") {
        "/account_fund/select_method"(platform: "/", type: TrackType.View) {}
        "/account_fund/select_method/selected"(platform: "/", type: TrackType.Event) {
            method = "qr"
        }
        /**
         * User Onboarding Screen Tracks
         */

        "/user_onboarding/terms_and_conditions"(platform: "/", type: TrackType.View) {
            flow = "anses"
        }

        "/user_onboarding/webview"(platform: "/", type: TrackType.View) {
            flow = "anses"
        }

        "/user_onboarding/iv_walkthrough"(platform: "/", type: TrackType.View) {
            flow = "anses"
        }

        "/congrats"(platform: "/", type: TrackType.View) {
            flow = "anses"
            result_status = "SUCCESS"
        }

        /**
         * User Onboarding Events Tracks
         */

        "/user_onboarding/terms_and_conditions"(platform: "/", type: TrackType.Event) {
            terms_and_conditions_row = true
            terms_and_conditions_checkbox = false
        }
    }
}