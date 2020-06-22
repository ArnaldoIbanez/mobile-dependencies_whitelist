package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

  defaultBusiness = "mercadopago"
  
  test("Unified Onboarding Brand Name Challenge open") {
        "/unified_onboarding/challenge/open" (platform: "/mobile", type: TrackType.Event) {
        }
  }
}
