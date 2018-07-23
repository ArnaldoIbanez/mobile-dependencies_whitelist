import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("Returns tracks") {

      // STEP 01
      "/return/typifications"(platform: "/")  {
        typification = "broken_item"
        action = "selection"
        loyalty_level = 1
        ref = "mediations_init"
        buyer_scoring = "low"
        seller_scoring = "low"
        date_delivered = "2018-05-21"
        cart_order = true
        item_category = "MLB48550"
        item_category_l1 = "MLB1051"
        refund_account_money=false
        order_id=1920434799
        category_path=["MLA1648", "MLA2141", "MLA1676", "MLA1683", "MLA402171", "MLA402176"]
        order_delayed_by_seller = false
        deferred_payment= "shipped"
      }

      // STEP 02
      "/return/conditions"(platform: "/") {
        action = "selection"
        selection = "accepted"
        order_delayed_by_seller = false
        deferred_payment= "shipped"
      }

      // STEP 03
      "/return/payments"(platform: "/") {
        payment = "paymentId"
        action = "selection"
        loyalty_level = 1
        ref = "mediations_init"
        buyer_scoring = "low"
        seller_scoring = "low"
        date_delivered = "2018-05-21"
        cart_order = true
        item_category = "MLB48550"
        item_category_l1 = "MLB1051"
        refund_account_money=false
        order_id=1920434799
        showed_payment_methods = "account_money"
        continue_button = true
        category_path=["MLA1648", "MLA2141", "MLA1676", "MLA1683", "MLA402171", "MLA402176"]
        order_delayed_by_seller = false
        deferred_payment= "shipped"
      }

      // STEP 04
      "/return/shipping"(platform: "/") {
        shipping = "pickup"
        action = "selection"
        loyalty_level = 1
        ref = "mediations_init"
        buyer_scoring = "low"
        seller_scoring = "low"
        date_delivered = "2018-05-21"
        cart_order = true
        item_category = "MLB48550"
        item_category_l1 = "MLB1051"
        refund_account_money=false
        category_path=["MLA1648", "MLA2141", "MLA1676", "MLA1683", "MLA402171", "MLA402176"]
        order_delayed_by_seller = false
        deferred_payment= "shipped"
      }

      // STEP 05.a
      "/return/pickup"(platform: "/") {
        pickup_time = "pickupTime"
        action = "selection"
        loyalty_level = 1
        ref = "mediations_init"
        buyer_scoring = "low"
        seller_scoring = "low"
        date_delivered = "2018-05-21"
        cart_order = true
        item_category = "MLB48550"
        item_category_l1 = "MLB1051"
        refund_account_money=false
        category_path=["MLA1648", "MLA2141", "MLA1676", "MLA1683", "MLA402171", "MLA402176"]
        order_delayed_by_seller = false
        deferred_payment= "shipped"
      }

      // STEP 05.b
      "/return/delivery"(platform: "/") { }

      // STEP 05.c
      "/return/review"(platform: "/") {
        cart_order = false
        date_delivered = "2018-05-30"
        item_category = "MLA1915"
        item_category_l1 = "MLA1051"
        loyalty_level = 6
        order_id = 1722099605
        ref = "myml-listings_primary"
        refund_account_money = false
        showed_payment_methods = "account_money"
        seller_scoring = "low"
        category_path=["MLA1648", "MLA2141", "MLA1676", "MLA1683", "MLA402171", "MLA402176"]
        order_delayed_by_seller = false
        deferred_payment= "shipped"
      }

      // STEP 06
      "/return/congrats"(platform: "/") {
        item_id = "item_id"
        category_id = "category_id"
        officialstore = "officialstore"
        typification = "broken_item"
        payment = "paymentId"
        shipping = "carrier"
        pickup_time = "pickupTime"
        loyalty_level = 1
        ref = "mediations_init"
        buyer_scoring = "low"
        seller_scoring = "low"
        date_delivered = "2018-05-21"
        cart_order = true
        item_category = "MLB48550"
        item_category_l1 = "MLB1051"
        refund_account_money=false
        category_path=["MLA1648", "MLA2141", "MLA1676", "MLA1683", "MLA402171", "MLA402176"]
        order_delayed_by_seller = false
        deferred_payment= "shipped"
      }

      // STEP 06.cta.a
      "/return/congrats/print_label"(platform: "/") {
        print_url = "https://www.mercadolibre.com"
      }

      // STEP 06.cta.b
      "/return/congrats/remedy_label"(platform: "/") { }

      // Modal
      "/return/modal"(platform: "/") {
        action = "modal_action"
        id = "modal_id"
      }

      // Redirect to Claims
      "/return/external"(platform: "/") {
        id = "claims"
        loyalty_level = 1
        date_delivered = "2018-05-21"
        cart_order = true
        item_category = "MLB48550"
        item_category_l1 = "MLB1051"
        refund_account_money=false
        category_path=["MLA1648", "MLA2141", "MLA1676", "MLA1683", "MLA402171", "MLA402176"]
      }

      // Error Page
      "/return/error"(platform: "/") {
        previous_step = "delivery"
      }
    }
}
