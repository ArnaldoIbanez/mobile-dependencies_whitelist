package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

  defaultBusiness = "mercadolibre"

  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Vendor Central Summary
  //------------------------------------------------------------------------------------------------------------------------------------------------------
  test("Vendor Central summary hub view") {
    "/vendor_central/summary/hub"(platform: "/web", type: TrackType.View) {}
  }

  test("Vendor Central summary discount view") {
    "/vendor_central/summary/discount"(platform: "/web", type: TrackType.View) {}
  }

  test("Vendor Central summary discount congrats view") {
    "/vendor_central/summary/discount_congrats"(platform: "/web", type: TrackType.View) {}
  }

  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Vendor central BULK Offering offline editor
  //------------------------------------------------------------------------------------------------------------------------------------------------------

  test("Vendor Central offline bulk hub") {
    "/vendor_central/bulk/offline/hub"(platform: "/", type: TrackType.View) {}
  }

  test("Vendor Central offline bulk download") {
    "/vendor_central/bulk/offline/download"(platform: "/", type: TrackType.View) {}
  }

  test("Vendor Central offline bulk upload") {
    "/vendor_central/bulk/offline/upload"(platform: "/", type: TrackType.View) {}
  }


  test("Vendor Central offline bulk download confirm") {
    "/vendor_central/bulk/offline/download/confirm"(platform: "/", type: TrackType.Event) {
      categories = ["Mochilas", "Banquetas", "Bicicletas"]
      filters = ["active", "status"]
      items = 3
    }
  }

  test("Vendor Central offline bulk download congrats") {
    "/vendor_central/bulk/offline/download/congrats"(platform: "/", type: TrackType.View) {
    type = "success"
    }
  }

  test("Vendor Central offline bulk upload congrats") {
    "/vendor_central/bulk/offline/upload/congrats"(platform: "/", type: TrackType.View) {
      type = "SUCCESS"
    }
  }

  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Vendor Central BULK Offering Publish
  //------------------------------------------------------------------------------------------------------------------------------------------------------
  test("Vendor Central bulk publish hub view") {
    "/vendor_central/bulk/publish/hub"(platform: "/web", type: TrackType.View) {}
  }

  test("Vendor Central bulk publish categories view") {
    "/vendor_central/bulk/publish/categories"(platform: "/web", type: TrackType.View) {}
  }

  test("Vendor Central bulk publish upload view") {
    "/vendor_central/bulk/publish/upload"(platform: "/web", type: TrackType.View) {}
  }

  test("Vendor Central bulk publish download congrats view") {
    "/vendor_central/bulk/publish/download/congrats"(platform: "/web", type: TrackType.View) {}
  }

  test("Vendor Central bulk publish upload congrats view") {
    "/vendor_central/bulk/publish/upload/congrats"(platform: "/web", type: TrackType.View) {}
  }

  test("Vendor Central bulk publish download categories event") {
    "/vendor_central/bulk/publish/categories/download_excel"(platform: "/web", type: TrackType.Event) {
      total = 10
      last_published = 5
      most_used = 1
      search_list = 4
      modal = 0
    }
  }

  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Vendor Central Purchase order listing
  //------------------------------------------------------------------------------------------------------------------------------------------------------
  test("Vendor Central purchase order listing view") {
    "/vendor_central/inbound/listing"(platform: "/web", type: TrackType.View) {}
  }

  test("Vendor Central purchase order detail view") {
    "/vendor_central/inbound/detail"(platform: "/web", type: TrackType.View) {}
  }

  test("Vendor Central Contra COGS list search event") {

    "/vendor_central/contra_cogs/list/search"(platform: "/web", type: TrackType.Event) {
    }

    "/vendor_central/contra_cogs/list/search"(platform: "/web", type: TrackType.Event) {
      filters = ["filter_id_1", "filter_id_2"]
      sorts = ["sort_id_1"]
      search_terms = ["term1", "term2"]
      task = "task_id"
    }
  }

}

