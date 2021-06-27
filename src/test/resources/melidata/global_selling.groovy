package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

  defaultBusiness = "mercadolibre"

  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Global Selling sections
  //------------------------------------------------------------------------------------------------------------------------------------------------------

  test("Global selling, deposit methods settings section") {
    "/global-selling/deposit-methods"(platform: "/", type: TrackType.View) {}
  }

  test("Global selling, payment reports section") {
    "/global-selling/payment-reports"(platform: "/", type: TrackType.View) {}
  }

  test("Global selling, selling preferences hub") {
    "/global-selling/selling-preferences"(platform: "/", type: TrackType.View) {}
  }

  test("Global selling, shipping methods setting section") {
    "/global-selling/shipping-methods"(platform: "/", type: TrackType.View) {}
  }
}
