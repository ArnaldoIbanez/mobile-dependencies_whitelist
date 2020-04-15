package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
  test("Release options screen") {
    "/settings/release-options"(platform: "/", type:TrackType.View) {}
  }

  test("Release options lib put") {
    "/settings/release-options/update"(platform: "/", type:TrackType.event) {
      channel = "point"
      payment_method_type = "credit"
      releaseDays "14"
      percentage "3.09"
    }
  }
}
