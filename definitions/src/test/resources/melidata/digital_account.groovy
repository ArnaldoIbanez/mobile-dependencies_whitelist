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

    test("Digital Wallet") {
        /**
         * Digital Wallet Screen Tracks
         */

        "/digital_wallet/index"(platform: "/", type: TrackType.View) {}

        /**
         * Digital Wallet Events Tracks
         */

        "/digital_wallet/show_video"(platform: "/", type: TrackType.Event) {
            show_video_section = "facilities_recharge"
        }

        "/digital_wallet/click_download_app"(platform: "/", type: TrackType.Event) {
            click_download_app_section_store = "hero_playstore"
        }
    }
}