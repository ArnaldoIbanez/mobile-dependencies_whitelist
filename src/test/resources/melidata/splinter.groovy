package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

  defaultBusiness = "mercadolibre"

  // old schema
  test("deals landings") {
      "/deals/landing" (platform:"/web/desktop", type: TrackType.View) {
          deal_id = "mla_1234"
      }

      "/deals/landing" (platform:"/web/desktop", type: TrackType.View) {
          deal_print_id = "6de7c870-2e66-11ea-b9de-a199b7428951"
      }
      
  }

    // pageviews
      
  test("splinter landings - deals") {
    "/splinter/landing/all/deals" (platform: "/",  type: TrackType.View) {
          deal_print_id = "6de7c870-2e66-11ea-b9de-a199b7428951"
      }
  }

  test("splinter landings - T1") {
      "/splinter/landing/all/tier1" (platform: "/",  type: TrackType.View) {
          deal_print_id = "6de7c870-2e66-11ea-b9de-a199b7428951"
      }
  }

  test("splinter landings - video") {
      "/splinter/landing/all/video" (platform: "/",  type: TrackType.View) {
          deal_print_id = "6de7c870-2e66-11ea-b9de-a199b7428951"
      }
  }

  test("splinter landings - discovery") {
      "/splinter/landing/all/discovery" (platform: "/",  type: TrackType.View) {
          deal_print_id = "6de7c870-2e66-11ea-b9de-a199b7428951"
      }
  }

  test("splinter landings - communicationals") {
      "/splinter/landing/all/communicationals" (platform: "/",  type: TrackType.View) {
          deal_print_id = "6de7c870-2e66-11ea-b9de-a199b7428951"
      }
  }

  test("splinter landings - sparkle") {
      "/splinter/landing/all/sparkle" (platform: "/",  type: TrackType.View) {
          deal_print_id = "6de7c870-2e66-11ea-b9de-a199b7428951"
      }
  }

  test("splinter landings - promotions") {
      "/splinter/landing/all/promotions" (platform: "/",  type: TrackType.View) {
          deal_print_id = "6de7c870-2e66-11ea-b9de-a199b7428951"
      }
  }

  test("splinter landings - vertical - moda") {
      "/splinter/landing/all/vertical/moda" (platform: "/",  type: TrackType.View) {
          deal_print_id = "6de7c870-2e66-11ea-b9de-a199b7428951"
      }
  }

  test("splinter landings - vertical - belleza") {
      "/splinter/landing/all/vertical/belleza" (platform: "/",  type: TrackType.View) {
          deal_print_id = "6de7c870-2e66-11ea-b9de-a199b7428951"
      }
  }

  test("splinter landings - vertical - juguetes") {
      "/splinter/landing/all/vertical/juguetes" (platform: "/",  type: TrackType.View) {
          deal_print_id = "6de7c870-2e66-11ea-b9de-a199b7428951"
      }
  }

  test("splinter landings - vertical - deportes") {
      "/splinter/landing/all/vertical/deportes" (platform: "/",  type: TrackType.View) {
          deal_print_id = "6de7c870-2e66-11ea-b9de-a199b7428951"
      }
  }

  test("splinter landings - vertical - electronica") {
      "/splinter/landing/all/vertical/electronica" (platform: "/",  type: TrackType.View) {
          deal_print_id = "6de7c870-2e66-11ea-b9de-a199b7428951"
      }
  }

  test("splinter landings - vertical - hogar") {
      "/splinter/landing/all/vertical/hogar" (platform: "/",  type: TrackType.View) {
          deal_print_id = "6de7c870-2e66-11ea-b9de-a199b7428951"
      }
  }

  test("splinter landings - vertical - servicios") {
      "/splinter/landing/all/vertical/servicios" (platform: "/",  type: TrackType.View) {
          deal_print_id = "6de7c870-2e66-11ea-b9de-a199b7428951"
      }
  }

  // events
  test("splinter landings - deals") {
    "/splinter/landing/all/deals"(platform: "/",  type: TrackType.Event) {
      category = "landings"
      action = "test-landings"
      label = "button_4_ver_mas"
    }
  }

  test("splinter landings - T1") {
    "/splinter/landing/all/tier1"(platform: "/",  type: TrackType.Event) {
      category = "landings"
      action = "test-landings"
      label = "button_4_ver_mas"
    }
  }

  test("splinter landings - video") {
    "/splinter/landing/all/video"(platform: "/",  type: TrackType.Event) {
      category = "landings"
      action = "test-landings"
      label = "button_4_ver_mas"
    }
  }

  test("splinter landings - discovery") {
    "/splinter/landing/all/discovery"(platform: "/",  type: TrackType.Event) {
      category = "landings"
      action = "test-landings"
      label = "button_4_ver_mas"
    }
  }

  test("splinter landings - communicationals") {
    "/splinter/landing/all/communicationals"(platform: "/",  type: TrackType.Event) {
      category = "landings"
      action = "test-landings"
      label = "button_4_ver_mas"
    }
  }

  test("splinter landings - promotions") {
    "/splinter/landing/all/promotions"(platform: "/",  type: TrackType.Event) {
      category = "landings"
      action = "test-landings"
      label = "button_4_ver_mas"
    }
  }

  test("splinter landings - sparkle") {
    "/splinter/landing/all/sparkle"(platform: "/",  type: TrackType.Event) {
      category = "landings"
      action = "test-landings"
      label = "button_4_ver_mas"
    }
  }

  test("splinter landings - vertical - moda") {
    "/splinter/landing/all/vertical/moda"(platform: "/",  type: TrackType.Event) {
      category = "landings"
      action = "test-landings"
      label = "button_4_ver_mas"
    }
  }

  test("splinter landings - vertical - deportes") {
    "/splinter/landing/all/vertical/deportes"(platform: "/",  type: TrackType.Event) {
      category = "landings"
      action = "test-landings"
      label = "button_4_ver_mas"
    }
  }

  test("splinter landings - vertical - belleza") {
    "/splinter/landing/all/vertical/belleza"(platform: "/",  type: TrackType.Event) {
      category = "landings"
      action = "test-landings"
      label = "button_4_ver_mas"
    }
  }

  test("splinter landings - vertical - juguetes") {
    "/splinter/landing/all/vertical/juguetes"(platform: "/",  type: TrackType.Event) {
      category = "landings"
      action = "test-landings"
      label = "button_4_ver_mas"
    }
  }

  test("splinter landings - vertical - electronica") {
    "/splinter/landing/all/vertical/electronica"(platform: "/",  type: TrackType.Event) {
      category = "landings"
      action = "test-landings"
      label = "button_4_ver_mas"
    }
  }

  test("splinter landings - vertical - hogar") {
    "/splinter/landing/all/vertical/hogar"(platform: "/",  type: TrackType.Event) {
      category = "landings"
      action = "test-landings"
      label = "button_4_ver_mas"
    }
  }

  test("splinter landings - vertical - servicios") {
    "/splinter/landing/all/vertical/servicios"(platform: "/",  type: TrackType.Event) {
      category = "landings"
      action = "test-landings"
      label = "button_4_ver_mas"
    }
  }
    
}
