import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

  test("Test track when aplication open" ) {
      "/application_open"(platform: "/mobile", type:TrackType.Event) {}
  }

  test("Search gallery with 10 items, first page" ) {
      "/search"(platform: "/mobile") {
          limit = 10
          offset = 0
          category_id="MLA32089"
          query="iphone"
          deferred_time=122
      }
  }
  test("Search core tracking"){

    def defaultSearchInformation = {
        total=5876 
        limit=20
        query="iphone"
        time=1361
        category_path=["MLA1051", "MLA1055", "MLA32089"]
        category_id="MLA32089"
        filter_user_applied=[]
        offset=0
        sort_id="relevance"
        mode="DEFERRED"
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
      filter_id = "9997262-AMLA_7262_2"
    }
    "/search/refine/select_filter/apply"(platform: "/mobile"){
      defaultSearchInformation()
      filter_id = "9997262-AMLA_7262_2"
      filter_value_id = "9997262-AMLA_7262_1-MMLA6838"
      filter_value_name = "IPod touch"
    }
    "/search/change_view" (platform: "/mobile", defaultSearchInformation)
    "/search/change_view/apply" (platform: "/mobile", type: TrackType.Event){
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
    
    "/vip/color_and_size"(platform:"/mobile", dataSet)     
    "/vip/description"(platform:"/mobile", dataSet) 
    "/vip/description/abort"(platform:"/mobile", dataSet) 
    "/vip/description/back"(platform:"/mobile", dataSet) 
  }
  test("Bookmark tracking in android") {
    "/bookmarks/post" (platform:"/mobile", type: TrackType.Event) {
      item_id = "MLA533657947"
      context = "/search"
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

  test("Checkout Basic Flow test"){

    def defaultCheckoutInformation = {
      item_id = "MCO412584037"
    }

    "/checkout"(platform:"/mobile") {
      defaultCheckoutInformation()
      quantity_pre_selected=1
      order_payment_required=false
      deferred_time=1
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

    "/checkout/payment_selection/apply" (platform:"/mobile", type:TrackType.Event){
      defaultCheckoutInformation()
      defaultCheckoutPaymentInformation()
      type = "cash"
    }

    "/checkout/payment_selection/othertype" (platform: "/mobile"){
      defaultCheckoutInformation()
      defaultCheckoutPaymentInformation()
      available_methods=["efecty", "davivienda"]
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

    "/checkout/shipping_selection/back" (platform:"/mobile", type:TrackType.Event){
      defaultCheckoutInformation()
      defaultCheckoutShippingInformation()
    }

    "/checkout/shipping_selection/address_selection" (platform:"/mobile"){
      defaultCheckoutInformation()
      defaultCheckoutShippingInformation()
      invalid_address = 1
      valid_address = 0
    }

    "/checkout/shipping_selection/address_selection/back" (platform:"/mobile"){
      defaultCheckoutInformation()
      defaultCheckoutShippingInformation()
      invalid_address = 1
      valid_address = 0
    }

    "/checkout/shipping_cost" (platform: "/mobile"){
      defaultCheckoutInformation()
    }
  }

  test("checkout congrats"){

    "/checkout/complete"(platform:"/mobile", type:TrackType.Event) {
        shipping_type="local_pick_up"
        item_id="MLA538444567"
        order_cost=13.00
        selected_card="146872309"
        quantity=1
        variation_id="7570143361"
        financed_order_cost_for_card=13.00
        payment_method="amex"
        payment_type="credit_card"
        installments=3
        shipping_option=1
     }

    "/checkout/congrats"(platform:"/mobile", type:TrackType.View) {
        shipping_type="local_pick_up"
        item_id="MLA538444567"
        order_cost=13.00
        selected_card="146872309"
        quantity=1
        variation_id="7570143361"
        financed_order_cost_for_card=13.00
        payment_method="amex"
        payment_type="credit_card"
        installments=3
        shipping_option=1
     }
  }

  

  test("credit cards"){

    "/credit_cards"(platform:"/mobile", type: TrackType.View) {
      available_cards=["visa", "amex", "master", "diners"]
      context = "/checkout"
      time=1230
      mode="DEFERRED"
    }

    "/credit_cards/new_card"(platform:"/mobile", type: TrackType.View) {
      payment_method_id = "diners"
      context = "/checkout"
    }

    "/credit_cards/new_card/apply"(platform:"/mobile", type: TrackType.Event) {
      payment_method_id = "diners"
      card_number = 123123123123
      context = "/checkout"
    }

    "/credit_cards/new_card/installments" (platform:"/mobile", type: TrackType.View) {
      //payment_method_id = "diners"
      available_installments = [1, 2, 3, 5, 6]
      context = "/checkout"
    }

    "/credit_cards/new_card/installments/apply"(platform:"/mobile", type: TrackType.Event) {
      payment_method_id = "diners"
      available_installments = [1, 2, 3, 5, 6]
      installment=6
      context = "/checkout"
    }
  }

  test("Shipping Mercadoenvios calculate cost") {
    "/shipping/mercadoenvios/shipping_cost"(platform: "/mobile") {
      item_id = "MLA12345"
      context = "/vip"
    }
    "/shipping/mercadoenvios/shipping_cost/get"(platform: "/mobile", type: TrackType.Event) {
      item_id = "MLA12345"
      context = "/vip"
      zip_code="1414"
    }
    "/shipping/mercadoenvios/shipping_cost/apply"(platform: "/mobile", type: TrackType.Event) {
      item_id = "MLA12345"
      context = "/vip"
      shipping_id = "509341521"
      zip_code="1414"
    }
  }

  test("address"){
    "/address/add_address"(platform:"/mobile", type: TrackType.View){
      context = "/checkout"
    }
    "/address/add_address/back"(platform:"/mobile", type: TrackType.Event){
      context = "/checkout"
    }
    "/address/add_address/apply"(platform:"/mobile", type: TrackType.Event){
      context = "/checkout"
    }
  }

  test("payments"){
    "/payments"(platform:"/mobile", type:TrackType.View){
      context = "vip"
      item_id="MLA539399952"
    }
    "/payments/back"(platform:"/mobile", type:TrackType.Event){
      context = "vip"
      item_id="MLA539399952"
    }
  }  

  test("seller reputation"){
    "/seller_reputation"(platform:"/mobile"){
      context = "/vip"
      item_id = "MLA539399952"
    } 
    "/seller_reputation/back"(platform:"/mobile"){
      context = "/vip"
      item_id = "MLA539399952"
    } 
    "/seller_reputation/ratings"(platform:"/mobile"){
      context = "/vip"
      item_id = "MLA539399952"
    }

    "/seller_reputation/ratings/back"(platform:"/mobile"){
      context = "/vip"
      item_id = "MLA539399952"
    } 
  }

  test("statistics"){
    "/melidata/statistics"(platform:"/mobile", type:TrackType.Event){
      errors_counter = ["java.io.EOFException":2, "nullpointer":3]
      last_send_timestamp="2015-01-21T13:14:09.415-0300"
      total_pending_tracks=2
      send_counter=6
      database_size=16384
      tracks_counter=12
    }
  }
}
