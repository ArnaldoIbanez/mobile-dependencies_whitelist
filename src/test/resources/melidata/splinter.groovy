package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

  // page views
  test("splinter landings - view") {
      "/splinter/landing"(platform:"/", type: TrackType.View) {
        deal_print_id = "6de7c870-2e66-11ea-b9de-a199b7428951"
        context = 'takeover-landing'
        module = 'core'
        group = 'tier1'
        content = '/black-friday'
        items_ids = []
        filters = { deal_id = "MLA7763" }
      }

  }

  // events
  test("splinter landings - event") {
    "/splinter/landing"(platform: "/",  type: TrackType.Event) {
        category = "landings"
        action = "test-landings"
        label = "button_4_ver_mas"
        context = 'takeover-landing'
        module = 'core'
        group = 'tier1'
        content = '/black-friday'
    }
  }
}