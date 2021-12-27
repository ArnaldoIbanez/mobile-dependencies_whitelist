package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

  defaultBusiness = "mercadolibre"

  test("sellers home view") {
    "/sellers/home/main"(platform: "/", type: TrackType.View) {
      session_id = "1d0c94ed-b994-42c3-8eec-49230b5fb1ab"
    }
  }


  test("seller notes view") {
    "/sellers/blog/post"(platform: "/", type: TrackType.View) {
      session_id = "1d0c94ed-b994-42c3-8eec-49230b5fb1ab"
    }
  }
}
