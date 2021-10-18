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
            deal_print_id='7a06cfd0-2cf1-11ec-a529-2df53c0c26ef'
        }
    }

    test("Home Category Tracking Event") {
    "/category_landing/tap"(platform: "/",  type: TrackType.Event) {
      category = 'landings'
      action = 'agro'
      label = 'mainslideritem-normal_1_agro'
    }
  }
}
