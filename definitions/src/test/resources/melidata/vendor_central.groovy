package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

  defaultBusiness = "mercadolibre"

  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Vendor Central Summary
  //------------------------------------------------------------------------------------------------------------------------------------------------------
  test("seller central summary hub view") {
    "/vendor_central/summary/hub"(platform: "/web", type: TrackType.View) {}
  }

  //------------------------------------------------------------------------------------------------------------------------------------------------------
  // TRACKS Vendor Central BULK Offering Publish
  //------------------------------------------------------------------------------------------------------------------------------------------------------
  test("seller central bulk publish hub view") {
    "/vendor_central/bulk/publish/hub"(platform: "/web", type: TrackType.View) {}
  }

  test("seller central bulk publish categories view") {
    "/vendor_central/bulk/publish/categories"(platform: "/web", type: TrackType.View) {}
  }

  test("seller central bulk publish upload view") {
    "/vendor_central/bulk/publish/upload"(platform: "/web", type: TrackType.View) {}
  }

  test("seller central bulk publish download congrats view") {
    "/vendor_central/bulk/publish/download/congrats"(platform: "/web", type: TrackType.View) {}
  }

  test("seller central bulk publish upload congrats view") {
    "/vendor_central/bulk/publish/upload/congrats"(platform: "/web", type: TrackType.View) {}
  }

  test("seller central bulk publish download categories event") {
    "/vendor_central/bulk/publish/categories/download_excel"(platform: "/web", type: TrackType.Event) {
      total = 10
      last_published = 5
      most_used = 1
      search_list = 4
      modal = 0
    }
  }

}

