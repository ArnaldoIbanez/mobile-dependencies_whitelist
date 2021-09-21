package src.test.resources.melidata
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadopago"

     test("CHO API webpay onelick") {
        "/checkout_api/payment/one_click_stop_landing"(platform:"/", type:TrackType.View) {}
        "/checkout_api/payment/one_click_stop_landing/one_click_redirect"(platform:"/", type:TrackType.Event) {}
        "/checkout_api/payment/one_click_stop_landing/seller_redirect"(platform:"/", type:TrackType.Event) {}

        "/checkout_api/payment/one_click_return"(platform:"/", type:TrackType.View) {}
        "/checkout_api/payment/one_click_return/token_creation_success"(platform:"/", type:TrackType.Event) {}
        "/checkout_api/payment/one_click_return/webpay_error"(platform:"/", type:TrackType.Event) {}
    }

    test("View ticket") {
      "/ticket_render"(platform:"/", type:TrackType.View) {
          is_guest = false
          payment_method_id = "paycash"
          payment_id = 1234
      }
    }

    test("Print ticket") {
      "/ticket_render/print_ticket"(platform:"/", type: TrackType.Event) {
          is_guest = true
          payment_method_id = "boleto"
          payment_id = 2345
      }
    }
}
