package catalog.melidata

import com.ml.melidata.TrackType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.catalog.PropertyType

tracks {

    initiative='1174'

    // CHO API Webpay Oneclick
    "/checkout_api"(platform:"/", isAbstract: true) {}
    "/checkout_api/payment"(platform:"/", isAbstract: true) {}
    "/checkout_api/payment/one_click_stop_landing"(platform:"/", type:TrackType.View) {}
    "/checkout_api/payment/one_click_stop_landing/one_click_redirect"(platform:"/", type:TrackType.Event) {}
    "/checkout_api/payment/one_click_stop_landing/seller_redirect"(platform:"/", type:TrackType.Event) {}

    "/checkout_api/payment/one_click_return"(platform:"/", type:TrackType.View) {}
    "/checkout_api/payment/one_click_return/token_creation_success"(platform:"/", type:TrackType.Event) {}
    "/checkout_api/payment/one_click_return/webpay_error"(platform: "/", type: TrackType.Event){}

    //tickets
    "/ticket_render"(platform:"/", type:TrackType.View) {
        is_guest(required: true, type: PropertyType.Boolean, description: "Wether user is logged as guest")
        payment_method_id(required: true, type: PropertyType.String, description: "Payment method of ticket")
        payment_id(required: true, type: PropertyType.Numeric, description: "Payment id of ticket")
    }

    "/ticket_render/print_ticket"(platform:"/", type: TrackType.Event) {
      is_guest(required: true, type: PropertyType.Boolean, description: "Wether user is logged as guest")
      payment_method_id(required: true, type: PropertyType.String, description: "Payment method of ticket")
      payment_id(required: true, type: PropertyType.Numeric, description: "Payment id of ticket")
    }
}
