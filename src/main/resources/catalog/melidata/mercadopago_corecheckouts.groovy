package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative='1174'

    // CHO API Webpay Oneclick
    "/checkout_api/payment/one_click_stop_landing"(platform:"/web/mobile", type:TrackType.View) {}
    "/checkout_api/payment/one_click_stop_landing/one_click_redirect"(platform:"/web/mobile", type:TrackType.Event) {}
    "/checkout_api/payment/one_click_stop_landing/seller_redirect"(platform:"/web/mobile", type:TrackType.Event) {}

    "/checkout_api/payment/one_click_return"(platform:"/web/mobile", type:TrackType.View) {}
    "/checkout_api/payment/one_click_return/token_creation_success"(platform:"/web/mobile", type:TrackType.Event) {}
    "/checkout_api/payment/one_click_return/webpay_error"(platform: "/web/mobile", type: TrackType.Event){}

}