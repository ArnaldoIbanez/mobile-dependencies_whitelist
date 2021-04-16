package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("Returns tracks") {

      // STEP 01
      "/return/potential_resolutions"(platform: "/", type: TrackType.View)  {
        ref = "mediations_init"
        loyalty_level = 5
        order_id = 1763279429
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_l1_id = "MLB48551"
        category_path = ["MLB1648","MLB1700","MLB5210","MLB9634","MLB277393"]
        flow_version = "return-mobile-0.0.1"
      }

      "/return/potential_resolutions/selection"(platform: "/", type: TrackType.Event)  {
        request_type = "RETURN"
      }

      // STEP 02
      "/return/typifications"(platform: "/", type: TrackType.View)  {
        ref = "mediations_init"
        loyalty_level = 5
        order_id = 1763279429
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_l1_id = "MLB48551"
        category_path = ["MLB1648","MLB1700","MLB5210","MLB9634","MLB277393"]
        flow_version = "return-mobile-0.0.1"
      }

      "/return/typifications/selection"(platform: "/", type: TrackType.Event)  {
        typification = "broken_item"
      }

      // STEP 03
      "/return/conditions"(platform: "/", type: TrackType.View) {
        ref = "mediations_init"
        loyalty_level = 4
        order_id = 1763279429
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_l1_id = "MLB48551"
        category_path = ["MLB1648","MLB1700","MLB5210","MLB9634","MLB277393"]
        flow_version = "return-mobile-0.0.1"
      }

      "/return/conditions/selection"(platform: "/", type: TrackType.Event) {
        selection = "accepted"
        refund_info = "refund_account_money"
      }

      // STEP 04
      "/return/payments"(platform: "/", type: TrackType.View) {
        ref = "mediations_init"
        loyalty_level = 4
        order_id = 1763279429
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_l1_id = "MLB48551"
        category_path = ["MLB1648","MLB1700","MLB5210","MLB9634","MLB277393"]
        showed_payment_methods = "credit_card"
        flow_version = "return-mobile-0.0.1"
      }

      "/return/payments/selection"(platform: "/", type: TrackType.Event) {
        selection = "accepted"
        payment_refund_method = "credit_card"
        refund_info = "refund_account_money"
      }

      // STEP 05
      "/return/shipping"(platform: "/", type: TrackType.View) {
        loyalty_level = 4
        order_id = 1763279429
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_l1_id = "MLB48551"
        category_path = ["MLB1648","MLB1700","MLB5210","MLB9634","MLB277393"]
        flow_version = "return-mobile-0.0.1"
      }

      "/return/shipping/selection"(platform: "/", type: TrackType.Event) {
        shipment_type = "pickup"
      }

      // STEP 06.a
      "/return/pickup"(platform: "/", type: TrackType.View) {
        loyalty_level = 4
        order_id = 1763279429
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_l1_id = "MLB48551"
        category_path = ["MLB1648","MLB1700","MLB5210","MLB9634","MLB277393"]
        flow_version = "return-mobile-0.0.1"
      }

      "/return/pickup/selection"(platform: "/", type: TrackType.Event) {
        pickup_time = "2018-01-31 18:00.000"
      }

      // STEP 06.b
      "/return/delivery"(platform: "/", type: TrackType.View) {
        loyalty_level = 4
        order_id = 1763279429
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_l1_id = "MLB48551"
        category_path = ["MLB1648","MLB1700","MLB5210","MLB9634","MLB277393"]
        flow_version = "return-mobile-0.0.1"
      }

      // STEP 06.c
      "/return/review"(platform: "/", type: TrackType.View) {
        loyalty_level = 4
        order_id = 1763279429
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_l1_id = "MLB48551"
        category_path = ["MLB1648","MLB1700","MLB5210","MLB9634","MLB277393"]
        flow_version = "return-mobile-0.0.1"
      }

      "/return/review/selection"(platform: "/", type: TrackType.Event) {
        review_return_method = 'review_code'
      }

      "/return/review/agencies"(platform: "/", type: TrackType.Event) {
        selection = "view_agencies"
      }

      // STEP 07
      "/return/congrats"(platform: "/", type: TrackType.View) {
        loyalty_level = 4
        order_id = 1763279429
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_l1_id = "MLB48551"
        category_path = ["MLB1648","MLB1700","MLB5210","MLB9634","MLB277393"]
        typification = "broken_item"
        payment_refund_method = "credit_card"
        shipment_type = "delivery"
        pickup_time = ""
        showed_payment_methods = "credit_card"
        refund_account_money = true
        cart_order = false
        payment_refund_at = "delivered"
        flow_version = "return-mobile-0.0.1"
      }

      "/return/congrats/selection"(platform: "/", type: TrackType.Event) {
        selection = "to_myml"
      }

      "/return/congrats/agencies"(platform: "/", type: TrackType.Event) {
        selection = "view_agencies"
      }

      "/return/congrats_error"(platform: "/", type: TrackType.View) {
        loyalty_level = 4
        order_id = 1763279429
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_l1_id = "MLB48551"
        category_path = ["MLB1648","MLB1700","MLB5210","MLB9634","MLB277393"]
        typification = "broken_item"
        payment_refund_method = "credit_card"
        shipment_type = "delivery"
        pickup_time = ""
        showed_payment_methods = "credit_card"
        cart_order = false
        payment_refund_at = "shipped"
        flow_version = "return-mobile-0.0.1"
      }

      "/return/congrats_error/selection"(platform: "/", type: TrackType.Event) {
        selection = "to_myml"
        type = "scoring_high"
      }

      // Redirect to Claims
      "/return/external"(platform: "/") {
        id = "claims"
        loyalty_level = 4
        order_id = 1763279429
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_l1_id = "MLB48551"
        category_path = ["MLB1648","MLB1700","MLB5210","MLB9634","MLB277393"]
        flow_version = "return-mobile-0.0.1"
      }

      // Warning Page for return created (view)
      "/return/warning"(platform: "/") {
        type = "return_created"
        loyalty_level = 4
        order_id = 1763279429
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_l1_id = "MLB48551"
        category_path = ["MLB1648","MLB1700","MLB5210","MLB9634","MLB277393"]
        flow_version = "return-mobile-0.0.1"
      }

      // Warning Page for claim created (event)
      "/return/warning/selection"(platform: "/") {
        selection = "view_details"
      }

      "/return/error"(platform: "/") {
        previous_step = "payments"
        loyalty_level = 4
        order_id = 1763279429
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_l1_id = "MLB48551"
        category_path = ["MLB1648","MLB1700","MLB5210","MLB9634","MLB277393"]
        flow_version = "return-mobile-0.0.1"
      }

      "/return/delivered_confirmation"(platform: "/"){
        ref = "mediations_init"
        loyalty_level = 5
        order_id = 1763279429
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_l1_id = "MLB48551"
        category_path = ["MLB1648","MLB1700","MLB5210","MLB9634","MLB277393"]
        flow_version = "return-mobile-0.0.1"
      }

      "/return/delivered_confirmation/selection"(platform: "/"){
        selection = "accepted"
      }

      "/return/self_dispatch"(platform: "/"){
        ref = "mediations_init"
        loyalty_level = 5
        order_id = 1763279429
        buyer_scoring = "low"
        seller_scoring = "low"
        category_id = "MLB48550"
        category_l1_id = "MLB48551"
        category_path = ["MLB1648","MLB1700","MLB5210","MLB9634","MLB277393"]
        flow_version = "return-mobile-0.0.1"
      }

      "/return/self_dispatch/selection"(platform: "/"){
        selection = "accepted"
      }
    }
}
