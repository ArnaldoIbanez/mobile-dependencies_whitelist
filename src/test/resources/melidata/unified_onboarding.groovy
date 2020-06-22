package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

  defaultBusiness = "mercadopago"
  
  test("Unified Onboarding Brand Name Challenge open") {
        "/unified_onboarding/challenge/open" (platform: "/", type: TrackType.Event) {
            session_id = "12345"
            session_id_from = "1234"
            challenge_id = "brand_name"
            challenge_type = "single_input"
            from = "some initiative"
        }
  }
  
  test("Unified Onboarding Brand Name Challenge view") {
        "/unified_onboarding/challenge" (platform: "/", type: TrackType.View) {
            session_id = "12345"
            session_id_from = "1234"
            challenge_id = "brand_name"
            challenge_type = "single_input"
            from = "some initiative"
            progress = "{"current": 1, "total": 7}"
        }
  }
}
