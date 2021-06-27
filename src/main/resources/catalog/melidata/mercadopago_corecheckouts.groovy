package catalog.melidata

import com.ml.melidata.TrackType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

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

}