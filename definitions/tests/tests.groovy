import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {
  test("Search gallery with 10 items, first page" ) {
      "/search"(platform: "/") {
          limit = 10
          offset = 0
      }
  }
  test("Search gallery with 10 items, second page" ) {
      "/search"(platform: "/") {
          limit = 10
          offset = 2
      }
  }
  test("Search gallery with 50 items" ) {
      "/search"(platform:"/mobile") {
          limit = 50
          offset = 10
          position = "horizontal"
      }
  }

  test("Vip core tracking in android") {
    def dataSet = {
      item_id = "MLA533657947"
      buying_mode = "buy_it_now"
      vertical = "code"
      category_id = "MLA43718"
      quantity = 3
      item_condition = "new"
      currency_id = "ARS"
      price = 15.3 
      item_status = "active"
      official_store_id = "1"
      seller_id = "131662738"
      power_seller_status = "platinum"
      listing_type_id = "gold_special"
      start_time = "2014-11-17T14:00:50.000Z"
      stop_time = "2015-01-16T14:00:50.000Z"
      shipping_mode = "me2"
      free_shipping = true
      local_pick_up = false
      category_path = ["MLA1234","MLA6789"]
    }

    "/vip"(platform:"/mobile/android", dataSet) 
    "/vip/seller_reputation"(platform:"/mobile/android", dataSet) 
    "/vip/seller_reputation/ratings"(platform:"/mobile/android", dataSet) 
    "/vip/mercadoenvios"(platform:"/mobile/android", dataSet) 
    "/vip/color_and_size"(platform:"/mobile/android", dataSet) 
    "/vip/questions"(platform:"/mobile/android", dataSet) 
    "/vip/payments"(platform:"/mobile/android", dataSet) 
    "/vip/description"(platform:"/mobile/android", dataSet) 
 }

  test("Vip bookmark tracking in android") {
    "/vip/bookmark/add" (platform:"/mobile/android", type: TrackType.Event) {
      item_id = "MLA533657947"
      buying_mode = "buy_it_now"
      vertical = "code"
      category_id = "MLA43718"
      quantity = 3
      item_condition = "new"
      currency_id = "ARS"
      price = 15.3 
      item_status = "active"
      official_store_id = "1"
      seller_id = "131662738"
      power_seller_status = "platinum"
      listing_type_id = "gold_special"
      start_time = "2014-11-17T14:00:50.000Z"
      stop_time = "2015-01-16T14:00:50.000Z"
      shipping_mode = "me2"
      free_shipping = true
      local_pick_up = false
      category_path = ["MLA1234","MLA6789"]

    }
  }
}
