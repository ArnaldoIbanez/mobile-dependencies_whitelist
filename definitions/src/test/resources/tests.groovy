import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

  test("Root tracking") {
    "/"(platform: "/mobile") {}

    "/"(platform: "/web/desktop") {}
  }

  test("Home core tracking") {
    "/home"(platform: "/mobile") {}

    "/home/abort"(platform: "/mobile") {}

    "/home/back"(platform: "/mobile") {}

    "/home/failure"(platform: "/mobile", {
      error_message = "error loading home"
    })

    "/home/tap"(platform: "/mobile", {
      position = 1
      section = "history"
      tag_id = "MLB681933310"
    })
  }

  test("Search core tracking"){

    def defaultSearchInformation = {
        total=5876 
        limit=20
        query="iphone"
        deferred_time=1361
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

    "/search/input"(platform: "/mobile") {}

    "/search/input/back"(platform: "/mobile") {}

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

  test("Search gallery with 10 items, first page" ) {
    "/search"(platform: "/mobile") {
      limit = 10
      offset = 0
      category_id="MLA32089"
      query="iphone"
      deferred_time=122
    }
  }

  test("Search category_id ROOT" ) {
    "/search"(platform: "/mobile") {
      limit = 10
      offset = 0
      category_id="ROOT"
      query="iphone"
    }
  }

  //Reviews
  test("Reviews tracks") {
  	def dataSet = {
  		itemId="MLA533657947"
  		reviewerId=18912312
  	}
  	
  	"/reviews/form"(platform:"/", dataSet)
  	
  	"/reviews/error"(platform:"/", dataSet)
  	
  	"/reviews/congrats"(platform:"/", dataSet)
  	
  	"/reviews/email"(platform:"/email", dataSet)
  }

  //VIP FLOW
  test("Vip min core tracking in android") {
    def dataSet = {
      item_id = "MLA533657947"
    }

    "/vip"(platform:"/mobile", dataSet)

    "/vip/abort"(platform:"/mobile", dataSet)

    "/vip/back"(platform:"/mobile", dataSet)

    "/vip/color_and_size"(platform:"/mobile", dataSet)

    "/vip/description"(platform:"/mobile", {
      item_id = "MLA533657947"
      empty_description = false
    })

    "/vip/description/abort"(platform:"/mobile", dataSet)

    "/vip/description/back"(platform:"/mobile", dataSet)

    "/vip/description/failure"(platform:"/mobile", dataSet)

    "/vip/contact_seller"(platform:"/mobile", dataSet)

    "/vip/description/failure"(platform:"/mobile", dataSet)

    "/vip/item_gallery"(platform:"/mobile") {}

    "/vip/item_gallery/back"(platform:"/mobile") {}

    "/vip/map"(platform:"/mobile", dataSet)

    "/vip/seller_reputation"(platform:"/mobile", dataSet)

    "/vip/seller_reputation/ratings"(platform:"/mobile", dataSet)
  }

  test("Vip core tracking in android deprecated") {
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
    
    "/vip/color_and_size"(platform:"/mobile", {
      item_id = "MLA533657947"
    })

    "/vip/description"(platform:"/mobile", {
      item_id = "MLA533657947"
      buying_mode = "buy_it_now"
      category_id = "MLA43718"
      quantity = 3
      currency_id = "ARS"
      price = 15.3
      item_status = "active"
      seller_id = "131662738"
      listing_type_id = "gold_special"
      shipping_mode = "me2"
      free_shipping = true
      local_pick_up = false
      empty_description = false
    })

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
      context = "/search"
    }

    "/bookmarks/action/post" (platform:"/mobile", type: TrackType.Event) {
      item_id = "MLA533657947"
      context = "/search"
    }

    "/bookmarks/action/delete" (platform:"/mobile", type: TrackType.Event) {
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

    "/questions/ask/post"(platform: "/mobile") {
      item_id = "MLA12345"
      context = "/vip"
      failed = false
    }

    "/questions/ask/back"(platform: "/mobile") {
      item_id = "MLA12345"
      context = "/vip"
    }
  }

  test("Checkout Basic Flow test") {

    def defaultCheckoutInformation = {
      item_id = "MCO412584037"
    }

    def defaultCheckoutPaymentInformation = {
      current_type="credit_card"
      available_other_methods=true
      available_types=[]
      current_method="visa"
    }

    "/checkout"(platform:"/mobile") {
      defaultCheckoutInformation()
      quantity_pre_selected=1
      order_payment_required=false
      deferred_time=1
    }

    "/checkout/abort"(platform:"/mobile") {}

    "/checkout/back"(platform:"/mobile") {}

    "/checkout/congrats/back"(platform:"/mobile") {}

    "/checkout/abort"(platform:"/mobile") {}

    "/checkout/failure"(platform:"/mobile") {
      error = "error loading checkout"
      message = "content"
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

    "/checkout/payment_selection/back" (platform:"/mobile"){
      defaultCheckoutInformation()
      defaultCheckoutPaymentInformation()

    }

    "/checkout/payment_selection/othertype" (platform: "/mobile"){
      defaultCheckoutInformation()
      defaultCheckoutPaymentInformation()
      available_methods=["efecty", "davivienda"]
    }

    "/checkout/payment_selection/othertype/back" (platform: "/mobile"){
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

    "/checkout/shipping_selection/apply" (platform:"/mobile"){
      defaultCheckoutInformation()
      defaultCheckoutShippingInformation()
      type = "known_cost"
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

    "/checkout/shipping_cost/apply" (platform: "/mobile"){
      defaultCheckoutInformation()
    }

    "/checkout/shipping_cost/back" (platform: "/mobile"){
      defaultCheckoutInformation()
    }

    "/checkout/contact_add" (platform: "/mobile"){}

    "/checkout/contact_seller_call" (platform: "/mobile"){}

    "/checkout/contact_seller_email" (platform: "/mobile"){}

    "/checkout/order_total" (platform: "/mobile"){}

    "/checkout/order_total/back" (platform: "/mobile"){}

    "/checkout/quantity_changed" (platform: "/mobile"){
      quantity = 10
    }

    "/checkout/screenshot" (platform: "/mobile"){}

    "/checkout/" (platform: "/mobile"){}

    "/checkout/" (platform: "/mobile"){}

    "/checkout/" (platform: "/mobile"){}
  }

  test("checkout congrats"){

    "/checkout/congrats"(platform:"/mobile", type:TrackType.View) {
        shipping_type="local_pick_up"
        item_id="MLA538444567"
        selected_card="146872309"
        financed_order_cost_for_card=13.00
        payment_method="amex"
        payment_type="credit_card"
        installments=3
        shipping_option=1
        order_id=912391
     }

    "/checkout/orderCreated"(platform:"/web/desktop", type:TrackType.Event) {
        congrats_seq = 1
        total_amount = 70
        order_id = 991687837
        status = "payment_required"
        seller = [ id: 135201044, nickname: "JPS PAULO" ]
        first_for_order = true
        errors = false
        buyer = [ id: 75961818, nickname: "CIA51" ]
        order_items = [
              [
                currency_id: "BRL",
                item: [
                  id: "MLB683236263",
                  category_path: [ "MLB1499", "MLB2467", "MLB30216" ],
                  buying_mode: "buy_it_now",
                  category_id: "MLB30216",
                  variation_id: null
                ],
                quantity: 1,
                unit_price: 70
              ]
            ]
        order_api = [
          total_amount: 70,
          tags: [ "not_delivered", "not_paid" ],
          currency_id: "BRL",
          mediations: [],
          status: "payment_required",
          date_created: "2015-08-28T06:44:34.000-04:00",
          status_detail: [ description: "Order only in MercadoLibre Site.", code: "item_price_restriction" ],
          seller: [ "id": 135201044, "nickname": "JPS PAULO" ],
          feedback: [ purchase: null, sale: null ],
          id: 991687837,
          shipping: [ status: "to_be_agreed", receiver_address: null, sender_address: null ],
          expiration_date: null,
          payments: [],
          buyer: [ id: 75961818, nickname: "CIA51" ],
          date_closed: null,
          order_items: [
                  [
                    currency_id: "BRL",
                    item:[
                      id: "MLB683236263",
                      title: "Conector 12 Vias Baquelite - 1,5/6,0mm² - Caixa Com 10",
                      variation_attributes: [],
                      category_id: "MLB30216",
                      variation_id: null ],
                    quantity: 1,
                    unit_price: 70
                  ]
          ],
          total_amount_with_shipping: 70,
          last_updated: "2015-08-28T06:44:34.000-04:00",
          paid_amount: 0,
          coupon: [ "id": null, "amount": 0 ],
          comments :null
        ]
        total_amount_local = 70
        total_amount_usd = 19.72
        mobile = false
      }
    }


  test("credit cards"){

    "/credit_cards"(platform:"/mobile", type: TrackType.View) {
      available_cards=["visa", "amex", "master", "diners"]
      context = "/checkout"
      deferred_time=1230
      mode="DEFERRED"
    }

    "/credit_cards/abort"(platform:"/mobile", type: TrackType.View) {
      available_cards=["visa", "amex", "master", "diners"]
      context = "/checkout"
      deferred_time=1230
      mode="DEFERRED"
    }

    "/credit_cards/back"(platform:"/mobile", type: TrackType.View) {
      available_cards=["visa", "amex", "master", "diners"]
      context = "/checkout"
      deferred_time=1230
      mode="DEFERRED"
    }

    "/credit_cards/new_card"(platform:"/mobile", type: TrackType.View) {
      payment_method_id = "diners"
      context = "/checkout"
    }

    "/credit_cards/new_card/back"(platform:"/mobile", type: TrackType.View) {
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
      destination = "1234"
    }
    "/shipping/mercadoenvios/shipping_cost/apply"(platform: "/mobile", type: TrackType.Event) {
      item_id = "MLA12345"
      context = "/vip"
      shipping_id = "509341521"
      zip_code="1414"
      destination = "1234"
    }
    "/shipping/mercadoenvios/shipping_cost/fail"(platform: "/mobile", type: TrackType.Event) {
      item_id = "MLA12345"
      context = "/vip"
    }
    "/shipping/shipping_cost"(platform: "/mobile", type: TrackType.Event) {
      item_id = "MLA12345"
      context = "/vip"
    }
    "/shipping/shipping_cost/back"(platform: "/mobile", type: TrackType.Event) {
      item_id = "MLA12345"
      context = "/vip"
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

  test("Register") {
    "/register/success"(platform: "/mobile") {
      source = "facebook"
    }

    "/register/failure"(platform: "/mobile") {
      source = "facebook"
    }
  }

  test("external tracking"){

    def defaultSearchInformation = {
      total=5876
      limit=20
      query="iphone"
      deferred_time=1361
      category_path=["MLA1051", "MLA1055", "MLA32089"]
      category_id="MLA32089"
      filter_user_applied=[]
      offset=0
      sort_id="relevance"
      mode="DEFERRED"
    }

    "/external"(platform:"/mobile", type:TrackType.View) { defaultSearchInformation }

    "/external/abort"(platform:"/mobile", type:TrackType.View) { defaultSearchInformation }

    "/external/back"(platform:"/mobile", type:TrackType.View) { defaultSearchInformation }

    "/external/failure"(platform:"/mobile", type:TrackType.View) {
      defaultSearchInformation
      error_message = "error loading search"
    }

    "/external/search"(platform:"/mobile", type:TrackType.View) { defaultSearchInformation }

    "/external/vip"(platform:"/mobile", type:TrackType.View) {
      item_id = "MLA123"
    }
  }


  test("melidata"){
    "/melidata/delete_old_tracks" (platform:"/mobile", type:TrackType.Event) {
      count = 10
    }

    "/melidata/null_track" (platform:"/mobile", type:TrackType.Event) {
      context = "DescriptionFragment"
    }

    "/melidata/statistics"(platform:"/mobile", type:TrackType.Event){
      errors_counter = ["java.io.EOFException":2, "nullpointer":3]
      last_send_timestamp="2015-01-21T13:14:09.415-0300"
      total_pending_tracks=2
      send_counter=6
      database_size=16384
      tracks_counter=12
      average_ok_time=10
      average_error_time=11
    }
  }

  test("Mobile Notifications"){

    "/notification"(platform: "/mobile") {
      news_id = "12332323"
      event_type = "sent"
      context = "notification"
    }

    "/notification/campaigns_deals"(platform: "/mobile") {
      news_id = "12332323"
      event_type = "received"
      deeplink ="meli://search?q=sony"
      deal_id = "mkt_campaign_co"
      context = "notification"
    }

    "/notification/questions_new"(platform: "/mobile") {
      news_id = "12332323"
      event_type = "dismiss"
      deeplink ="meli://seller_question/12221"
      context = "notification"
    }

    "/notification/questions_answered"(platform: "/mobile") {
      news_id = "12332323"
      event_type = "open"
      deeplink ="meli://buyer_questions"
      context = "notification"
    }

    "/notification/orders_new"(platform: "/mobile") {
      news_id = "12332323"
      event_type = "open"
      order_id = 12132
      context = "notification"
    }

    "/notification/shipping_shipped"(platform: "/mobile") {
      news_id = "12332323"
      event_type = "open"
      order_id = 11222
      shipping_id = 1234
      context = "notification"
    }

    "/notification/shipping_agency_withdrawal"(platform: "/mobile") {
      news_id = "12332323"
      event_type = "arrived"
      deeplink = "meli://purchases/sales"
      shipping_id = 1234
      context = "notification"
    }
    
    "/notification/shipping_delayed_bonus"(platform: "/mobile"){
      news_id = "12332323"
      event_type = "arrived"
      deeplink = "meli://purchases/sales"
      shipping_id = 1234
    }
    
    "/notification/collections_approved"(platform: "/mobile") {
      news_id = "12332323"
      event_type = "dismiss"
      order_id = 1234
      context = "notification"
    }

    "/notification/purchases_pending"(platform: "/mobile") {
      news_id = "12332323"
      event_type = "open"
      item_id = "MLA122211"
      context = "notification"
    }

    "/notification/reputation_buyer_in"(platform: "/mobile") {
      news_id = "12332323"
      event_type = "dismiss"
      context = "notification"
    }

    //Buy action
    "/notification/purchases_pending"(platform: "/mobile") {
      news_id = "12332323"
      event_type = "open"
      item_id = "MLA122211"
      action_type = "deeplinking"
      context = "notification"
    }

    //Favorite action
    "/notification/purchases_pending"(platform: "/mobile") {
      news_id = "12332323"
      event_type = "open"
      item_id = "MLA122211"
      action_type = "favorite"
      context = "notification"
    }

    //Notif center tracking
    "/notification/purchases_pending"(platform: "/mobile") {
      news_id = "12332323"
      event_type = "open"
      item_id = "MLA122211"
      action_type = "favorite"
      status = "unread"
      context = "notification_center"
    }
    
    "/notification/mediations_complainant"(platform: "/mobile") {
      news_id = "12332323"
      event_type = "open"
      order_id = 1234
      claim_id = 3123
      action_type = "favorite"
    }

  }


}


