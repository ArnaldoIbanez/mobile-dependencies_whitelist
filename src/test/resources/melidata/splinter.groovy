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
    "/splinter/landing/event"(platform: "/",  type: TrackType.Event) {
        category = "landings"
        action = "test-landings"
        label = "button_4_ver_mas"
        context = 'takeover-landing'
        module = 'core'
        group = 'tier1'
        content = '/black-friday'
    }
  }

  // component_prints
  test("splinter landings - component_prints - event") {
    "/splinter/component"(platform: "/",  type: TrackType.Event) {
      c_original_target = "https = //listado.mercadolibre.com.ar/supermercado/almacen/_Deal_cpg-navidad#DEAL_ID=MLA6107&S=MKT&V=1&T=BHO&L=CPG_CAJAS"
      c_id = "/splinter/special-withoutlabel"
      c_element_order = 1
      c_campaign = "ARMATUCAJA_DEAL-ID=MLA6107"
      c_uid = "9fd3d930-634f-11ec-9e9e-49f56c7fb966"
    }
  }
}