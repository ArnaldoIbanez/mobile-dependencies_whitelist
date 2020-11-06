package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("Home Category Tracking View") {
        "/category_landing"(platform: "/",  type: TrackType.View) {
            category_id='MLA1051'
            category_path=['MLA1051']
            last_modified='2020-06-12T13:12:16.534Z'
        }
    }

    test("Home Category Tracking Event") {
    "/category_landing"(platform: "/",  type: TrackType.Event) {
      category = 'landings'
      action = 'agro'
      label = 'mainslideritem-normal_1_agro'
    }
  }
}
