import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("Returns tracks") {

      // STEP 01
      "/return/typifications"(platform: "/", type: TrackType.View)  {
        loyalty_level = "5"
        order_id = "1763279429"
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_id_l1 = "MLB48551"
        ref = "mediations_init"
      }

      "/return/typifications/selection"(platform: "/", type: TrackType.Event)  {
        loyalty_level = "5"
        order_id = "1763279429"
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_id_l1 = "MLB48551"
        ref = "mediations_init"
        typification = "broken_item"
      }

      // STEP 02
      "/return/conditions"(platform: "/", type: TrackType.View) {
        loyalty_level = "4"
        order_id = "1763279429"
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_id_l1 = "MLB48551"
        ref = "mediations_init"
      }

      "/return/conditions/selection"(platform: "/", type: TrackType.Event) {
        loyalty_level = "3"
        order_id = "1763279429"
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_id_l1 = "MLB48551"
        ref = "mediations_init"
        selection = "accepted"
      }

      // STEP 03
      "/return/payments"(platform: "/", type: TrackType.View) {
        loyalty_level = "4"
        order_id = "1763279429"
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_id_l1 = "MLB48551"
        ref = "mediations_init"
        showed_payment_methods = "credit_card"
      }

      "/return/payments/selection"(platform: "/", type: TrackType.Event) {
        loyalty_level = "4"
        order_id = "1763279429"
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_id_l1 = "MLB48551"
        ref = "mediations_init"
        showed_payment_methods = "credit_card"
        payment = "732582934"
      }

      // STEP 04
      "/return/shipping"(platform: "/", type: TrackType.View) {
        loyalty_level = "4"
        order_id = "1763279429"
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_id_l1 = "MLB48551"
      }

      "/return/shipping/selection"(platform: "/", type: TrackType.Event) {
        loyalty_level = "4"
        order_id = "1763279429"
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_id_l1 = "MLB48551"
        shipment_type = "pickup"
      }

      // STEP 05.a
      "/return/pickup"(platform: "/", type: TrackType.View) {
        loyalty_level = "4"
        order_id = "1763279429"
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_id_l1 = "MLB48551"
      }

      "/return/pickup/selection"(platform: "/", type: TrackType.Event) {
        loyalty_level = "4"
        order_id = "1763279429"
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_id_l1 = "MLB48551"
        pickup_time = "2018-01-31 18:00.000"
      }

      // STEP 05.b
      "/return/delivery"(platform: "/", type: TrackType.View) {
        loyalty_level = "4"
        order_id = "1763279429"
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_id_l1 = "MLB48551"
      }

      // STEP 05.c
       "/return/review"(platform: "/", type: TrackType.View) {
        loyalty_level = "4"
        order_id = "1763279429"
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_id_l1 = "MLB48551"
      }

      "/return/review/selection"(platform: "/", type: TrackType.Event) {
        loyalty_level = "4"
        order_id = "1763279429"
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_id_l1 = "MLB48551"
        continue_button = true
        is_shipping_code = true
      }

      // STEP 06
      "/return/congrats"(platform: "/", type: TrackType.View) {
        loyalty_level = "4"
        order_id = "1763279429"
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_id_l1 = "MLB48551"
        typification = "broken_item"
        payment = "732582934"
        shipment_type = "delivery"
        pickup_time = ""
        showed_payment_methods = "credit_card"
        refund_account_money = true
        cart_order = false
        payment_refund_at = "delivered_3"
      }

      "/return/congrats/selection"(platform: "/", type: TrackType.Event) {
        loyalty_level = "4"
        order_id = "1763279429"
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_id_l1 = "MLB48551"
        typification = "broken_item"
        payment = "732582934"
        shipment_type = "delivery"
        pickup_time = ""
        showed_payment_methods = "credit_card"
        refund_account_money = true
        cart_order = false
        payment_refund_at = "shipped"
        selection = "to_myml"
      }

      "/return/congrats_error"(platform: "/", type: TrackType.View) {
        loyalty_level = "4"
        order_id = "1763279429"
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_id_l1 = "MLB48551"
        typification = "broken_item"
        payment = "732582934"
        shipment_type = "delivery"
        pickup_time = ""
        showed_payment_methods = "credit_card"
        cart_order = false
        payment_refund_at = "shipped"
      }

      "/return/congrats_error/selection"(platform: "/", type: TrackType.Event) {
        loyalty_level = "4"
        order_id = "1763279429"
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_id_l1 = "MLB48551"
        typification = "broken_item"
        payment = "732582934"
        shipment_type = "delivery"
        pickup_time = ""
        showed_payment_methods = "credit_card"
        cart_order = false
        payment_refund_at = "shipped"
        selection = "to_myml"
      }

      /*
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
      */
    }
}
