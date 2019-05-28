package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    test("Account Balance User Onboarding - views") {
        /**
         * User Onboarding Screen Tracks
         */

        "/anses/user_onboarding/terms_and_conditions"(platform: "/", type: TrackType.View) {}

        "/anses/user_onboarding/webview"(platform: "/", type: TrackType.View) {}

        "/anses/user_onboarding/iv_walkthrough"(platform: "/", type: TrackType.View) {}

        "/anses/congrats"(platform: "/", type: TrackType.View) {
            result_status = "approved"
        }

        /**
         * User Onboarding Events Tracks
         */

        "/anses/user_onboarding/terms_and_conditions"(platform: "/", type: TrackType.Event) {
            terms_and_conditions_row = true
            terms_and_conditions_checkbox = false
        }
    }
}