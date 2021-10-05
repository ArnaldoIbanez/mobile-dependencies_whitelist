package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    test("User Onboarding - views") {
        /**
         * User Onboarding Screen Tracks
         */

        "/anses/onboarding/terms_and_conditions"(platform: "/", type: TrackType.View) {}

        "/anses/onboarding/webview"(platform: "/", type: TrackType.View) {}

        "/anses/onboarding/iv_walkthrough"(platform: "/", type: TrackType.View) {}

        "/anses/onboarding/congrats"(platform: "/", type: TrackType.View) {
            result_status = "approved"
        }

        /**
         * Onboarding Events Tracks
         */

        "/anses/onboarding/terms_and_conditions"(platform: "/", type: TrackType.Event) {
            terms_and_conditions_row = true
            terms_and_conditions_checkbox = false
        }
    }
}