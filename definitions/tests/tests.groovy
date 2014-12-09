import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

  test("Search gallery with 10 items, first page" ) {
      "/search"(platform: "/mobile") {
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

	  def defaultEmptySearchInformation = {
		  limit=20
		  query="ipod"
		  offset=0
	  }

      "/search"(platform: "/mobile", defaultSearchInformation)

	  "/search/failure"(platform: "/mobile") {
		defaultSearchInformation()
		error_message = "No connection error"
	  }

	  "/search/back"(platform: "/mobile", defaultSearchInformation)
	  "/search/abort"(platform: "/mobile", defaultEmptySearchInformation)
	  "/search/refine"(platform: "/mobile", defaultSearchInformation)
      "/search/refine/apply"(platform: "/mobile", defaultSearchInformation)
      "/search/refine/back" (platform: "/mobile", defaultSearchInformation)  
      "/search/refine/select_filter" (platform: "/mobile"){
        defaultSearchInformation()
        filter_name = "sort"
      }
      "/search/refine/select_filter/apply"(platform: "/mobile"){
        defaultSearchInformation()
        filter_name = "sort"
        filter_value = "relevance"
      }
      "/search/change_view" (platform: "/mobile", defaultSearchInformation)
      "/search/change_view/apply" (platform: "/mobile"){
        defaultSearchInformation()
        list_mode = "mosaic"
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

    "/vip"(platform:"/mobile", dataSet) 
    "/vip/seller_reputation"(platform:"/mobile", dataSet) 
    "/vip/seller_reputation/ratings"(platform:"/mobile", dataSet) 
    "/vip/color_and_size"(platform:"/mobile", dataSet) 
    "/vip/payments"(platform:"/mobile", dataSet) 
    "/vip/description"(platform:"/mobile", dataSet) 
 }

  test("Bookmark tracking in android") {
    "/bookmarks/post" (platform:"/mobile", type: TrackType.Event) {
      item_id = "MLA533657947"
    }

	"/bookmarks/delete" (platform:"/mobile", type: TrackType.Event) {
	  item_id = "MLA533657947"
  	}
  }

  test("Questions") {
    "/questions/list"(platform: "/mobile") {
      item_id = "MLA12345"
      context = "/vip"
    }
    "/questions/ask"(platform: "/mobile") {
      item_id = "MLA12345"
      context = "/vip"
    }

  }

  test("Checkout test"){

    def defaultCheckoutInformation = {
      item_id = "MCO412584037"
    }

    "/checkout"(platform:"/") {
      defaultCheckoutInformation()
    }

    def defaultCheckoutPaymentInformation = {
      current_type="credit_card"
      available_other_methods=true
      available_types=[]
      current_method="visa"
    }

    "/checkout/payment_selection" (platform:"/mobile"){
      defaultCheckoutInformation()
      defaultCheckoutPaymentInformation()
    }

    "/checkout/payment_selection/credit_card" (platform:"/mobile"){
      defaultCheckoutInformation()
      defaultCheckoutPaymentInformation()
    }

    "/checkout/payment_selection/othertype" (platform: "/mobile"){
      defaultCheckoutInformation()
      defaultCheckoutPaymentInformation()
      available_methods=["efecty", "davivienda"]
    }

    def defaultCheckoutShippingInformation = {
      available_types=[]
      current_type="to_agree"
      current_option="to_agree"
    } 

    "/checkout/shipping_selection" (platform:"/mobile"){
      defaultCheckoutInformation()
      defaultCheckoutShippingInformation()
    }

    "/checkout/shipping_cost" (platform: "/mobile"){
      defaultCheckoutInformation()
    }

    
  }

  test("Shipping Mercadoenvios calculate cost") {
    "/shipping/mercadoenvios/calculate_cost"(platform: "/mobile") {
      item_id = "MLA12345"
      context = "/vip"
    }
    "/shipping/mercadoenvios/calculate_cost/get"(platform: "/mobile", type: TrackType.Event) {
      item_id = "MLA12345"
      context = "/vip"
    }
    "/shipping/mercadoenvios/calculate_cost/apply"(platform: "/mobile", type: TrackType.Event) {
      item_id = "MLA12345"
      context = "/vip"
    }
  }
}
