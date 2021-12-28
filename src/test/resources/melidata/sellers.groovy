package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

  defaultBusiness = "mercadolibre"

  test("sellers home view") {
    "/sellers/home/main"(platform: "/", type: TrackType.View) {}
  }


  test("seller notes view") {
    "/sellers/blog/post"(platform: "/", type: TrackType.View) {}
  }
}
