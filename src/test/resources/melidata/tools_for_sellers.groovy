package src.test.resources.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

  defaultBusiness = "mercadopago"

  test("Release options screen") {
    "/settings/release_options"(platform: "/", type:TrackType.View) {}
  }

  test("Release options lib put") {
    "/settings/release_options/update"(platform: "/", type:TrackType.Event) {
      channel = "point"
      payment_method_type = "credit"
      release_days = "14"
      percentage = "3.09"
    }
  }
}
