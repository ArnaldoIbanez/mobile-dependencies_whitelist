package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"
  
    //TOOL FOR SELLERS

    //View

    test("Tools for Sellers Challenge view with json value") {
        "/unified_onboarding/challenge" (platform: "/mobile", type: TrackType.View) {
            session_id = "12345"
            session_id_from = "1234"
            challenge_id = "ou_fees"
            challenge_type = "typ_list"
            from = "tools_for_sellers"
            value = "{ some object }"
        }
    }

    test("Tools for Sellers Challenge view with URL value") {
        "/unified_onboarding/challenge" (platform: "/mobile", type: TrackType.View) {
            session_id = "12345"
            session_id_from = "1234"
            challenge_id = "ou_fees"
            challenge_type = "typ_list"
            from = "tools_for_sellers"
            value = "some url"
            progress = "{\"current\": 1, \"total\": 7}"
        }
    }

    test("Tools for Sellers Challenge view without value") {
        "/unified_onboarding/challenge" (platform: "/mobile", type: TrackType.View) {
            session_id = "12345"
            session_id_from = "1234"
            challenge_id = "ou_fees"
            challenge_type = "typ_list"
            from = "tools_for_sellers"
        }
    }

    //Open

    test("Tools for Sellers Challenge open with URL value") {
        "/unified_onboarding/challenge/open" (platform: "/mobile", type: TrackType.Event) {
            session_id = "12345"
            session_id_from = "1234"
            challenge_id = "ou_fees"
            challenge_type = "typ_list"
            from = "tools_for_sellers"
            value = "Some URL"
        }
    }

    test("Tools for Sellers Challenge open without value") {
        "/unified_onboarding/challenge/open" (platform: "/mobile", type: TrackType.Event) {
            session_id = "12345"
            session_id_from = "1234"
            challenge_id = "ou_fees"
            challenge_type = "typ_list"
            from = "tools_for_sellers"
        }
    }

    //Error

    test("Tools for Sellers Challenge Error") {
        "/unified_onboarding/challenge/error" (platform: "/mobile", type: TrackType.Event) {
            session_id = "12345"
            session_id_from = "1234"
            challenge_id = "ou_fees"
            challenge_type = "typ_list"
            from = "tools_for_sellers"
            value = "The operation couldn’t be completed. (com.mercadolibre.networking error 500."
        }
    }

    //Back

    test("Tools for Sellers Challenge Back") {
        "/unified_onboarding/challenge/back" (platform: "/mobile", type: TrackType.Event) {
            session_id = "12345"
            session_id_from = "1234"
            challenge_id = "ou_fees"
            challenge_type = "typ_list"
            from = "tools_for_sellers"
        }
    }

    //Component Tap

    test("Tools for Sellers Component Tap with Json Value") {
        "/unified_onboarding/challenge/component/tap" (platform: "/mobile", type: TrackType.Event) {
            session_id = "12345"
            session_id_from = "1234"
            challenge_id = "update_release_option_button"
            challenge_type = "typ_release_option_selection"
            from = "tools_for_sellers"
            value = "Some Object"
            component_id = "update_release_option_button"
            component_type = "action"
        }
    }

    test("Tools for Sellers Component Tap with URL Value") {
        "/unified_onboarding/challenge/component/tap" (platform: "/mobile", type: TrackType.Event) {
            session_id = "12345"
            session_id_from = "1234"
            challenge_id = "typ"
            challenge_type = "typ_release_option_selection"
            from = "tools_for_sellers"
            value = "Some URL"
            component_id = "footer_cell"
            component_type = "action"
        }
    }

    //Onboarding Unificado

    //View

    test("Unified Onboarding Brand Name Challenge view") {
        "/unified_onboarding/challenge" (platform: "/mobile", type: TrackType.View) {
            session_id = "12345"
            session_id_from = "1234"
            challenge_id = "brand_name"
            challenge_type = "single_input"
            from = "some initiative"
            progress = "{\"current\": 1, \"total\": 7}"
        }
    }    

    //Open

    test("Unified Onboarding Brand Name Challenge open") {
        "/unified_onboarding/challenge/open" (platform: "/mobile", type: TrackType.Event) {
            session_id = "12345"
            session_id_from = "1234"
            challenge_id = "brand_name"
            challenge_type = "single_input"
            from = "some initiative"
        }
    }
  
    //Back

    test("Unified Onboarding Brand Name Challenge Back") {
        "/unified_onboarding/challenge/back" (platform: "/mobile", type: TrackType.Event) {
            session_id = "12345"
            session_id_from = "1234"
            challenge_id = "brand_name"
            challenge_type = "single_input"
            from = "some initiative"
        }
    }

    //Confirm

    test("Unified Onboarding Brand Name Challenge Confirm") {
        "/unified_onboarding/challenge/confirm" (platform: "/mobile", type: TrackType.Event) {
            session_id = "12345"
            session_id_from = "1234"
            challenge_id = "brand_name"
            challenge_type = "single_input"
            from = "some initiative"
            is_last_challenge = true
        }
    }

    //Component Tap

    test("Unified Onboarding Brand Name Component Tap") {
        "/unified_onboarding/challenge/component/tap" (platform: "/mobile", type: TrackType.Event) {
            session_id = "12345"
            session_id_from = "1234"
            challenge_id = "brand_name"
            challenge_type = "single_input"
            from = "some initiative"
            value = "Continuar"
            component_id = "main_action"
            component_type = "action"
        }
    }   
}
