package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"
  
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

    test("Tasas y Plazos Challenge view") {
        "/unified_onboarding/challenge" (platform: "/mobile", type: TrackType.View) {
            session_id = "12345"
            session_id_from = "1234"
            challenge_id = "ou_fees"
            challenge_type = "typ_list"
            from = "tools_for_sellers"
            value = "{ some object }"
        }
    }

    test("Unified Onboarding Brand Name Challenge open") {
        "/unified_onboarding/challenge/open" (platform: "/mobile", type: TrackType.Event) {
            session_id = "12345"
            session_id_from = "1234"
            challenge_id = "brand_name"
            challenge_type = "single_input"
            from = "some initiative"
        }
    }

    test("Tasas y Plazos Challenge open") {
        "/unified_onboarding/challenge/open" (platform: "/mobile", type: TrackType.Event) {
            session_id = "12345"
            session_id_from = "1234"
            challenge_id = "ou_fees"
            challenge_type = "typ_list"
            from = "tools_for_sellers"
            value = "{ some object }"
            progress = "{\"current\": 1, \"total\": 7}"
        }
    }
  
    test("Unified Onboarding Brand Name Challenge Back") {
        "/unified_onboarding/challenge/back" (platform: "/mobile", type: TrackType.Event) {
            session_id = "12345"
            session_id_from = "1234"
            challenge_id = "brand_name"
            challenge_type = "single_input"
            from = "some initiative"
        }
    }

    test("Tasas y plazos Challenge Back") {
        "/unified_onboarding/challenge/error" (platform: "/mobile", type: TrackType.Event) {
            session_id = "12345"
            session_id_from = "1234"
            challenge_id = "brand_name"
            challenge_type = "single_input"
            from = "some initiative"
            value = "The operation couldn’t be completed. (com.mercadolibre.networking error 500."
        }
    }

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

    test("Unified Onboarding Brand Name Component Tap") {
        "/unified_onboarding/challenge/component/tap" (platform: "/mobile", type: TrackType.Event) {
            session_id = "12345"
            session_id_from = "1234"
            challenge_id = "brand_name"
            challenge_type = "single_input"
            from = "some initiative"
            //value = "Continuar"
            component_id = "main_action"
            component_type = "action"
        }
    }   
}
