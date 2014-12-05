import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

  test("Search gallery with 10 items, first page" ) {
      "/search"(platform: "/mobile/android") {
          limit = 10
          offset = 0
          category_id="MLA32089"
          query="iphone"
      }
  }
  test("Search core tracking"){

      def defaultSearchInformation = {
          total=5876 
          limit=20
          query="iphone"
          category_path=["MLA1051", "MLA1055", "MLA32089"]
          category_id="MLA32089"
          filter_user_applied=[]
          offset=0
          sort_id="relevance"
      }

      "/search"(platform: "/mobile/android", defaultSearchInformation)
      "/search/refine"(platform: "/mobile/android", defaultSearchInformation)
      "/search/refine/apply"(platform: "/mobile/android", defaultSearchInformation)
      "/search/refine/cancel" (platform: "/mobile/android", defaultSearchInformation)  
      "/search/refine/select_filter" (platform: "/mobile/android"){
        defaultSearchInformation()
        filter_name = "sort"
      }
      "/search/refine/select_filter/apply"(platform: "/mobile/android"){
        defaultSearchInformation()
        filter_name = "sort"
        filter_value = "relevance"
      }
      "/search/change_view" (platform: "/mobile/android", defaultSearchInformation)
      "/search/change_view/apply" (platform: "/mobile/android"){
        defaultSearchInformation()
        list_mode = "mosaic"
      }
      "/search/bookmark" (platform: "/mobile/android"){
        defaultSearchInformation()
        item_id = "MLA32089"
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

  test("Checkout test"){

    def checkout_default = {
      item_id = "MCO412584037"
    }

    "/checkout"(platform:"/") {
      checkout_default()
    }

    def payment_selection_default = {
      current_type="credit_card"
      available_other_methods=true
      available_types=[]
      current_method="visa"
    }

    "/checkout/payment_selection" (platform:"/mobile/android"){
      checkout_default()
      payment_selection_default()
    }

    "/checkout/payment_selection/credit_card" (platform:"/mobile/android"){
      checkout_default()
      payment_selection_default()
    }

    "/checkout/payment_selection/othertype" (platform: "/mobile/android"){
      checkout_default()
      payment_selection_default()
      available_methods=["efecty", "davivienda"]
    }

    def shipping_selection_default = {
      available_types=[]
      current_type="to_agree"
      current_option="to_agree"
    } 

    "/checkout/shipping_selection" (platform:"/mobile/android"){
      checkout_default()
      shipping_selection_default()
    }

    "/checkout/shipping_cost" (platform: "/mobile/android"){
      checkout_default()
    }

    
  }
}
