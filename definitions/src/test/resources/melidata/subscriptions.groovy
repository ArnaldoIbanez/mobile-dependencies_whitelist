package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"


    test("subscriptions") {
        "/subscriptions/frequency" (platform:"/", type: TrackType.View) {
            order_id="1425420000"
            item_id="MLM12345"
            category_id="CAT123"
        }
        "/subscriptions/change_frequency" (platform:"/", type: TrackType.View) {
            frequency = "WEEKS_2"
            frequency_before = "WEEKS_1"
            context = "frequency/buyingflow"
            order_id="1425420000"
            item_id="MLM12345"
            category_id="CAT123"
        }
        "/subscriptions/review"(platform: "/", type: TrackType.View) {
            order_id="1425420000"
            item_id="MLM12345"
            category_id="CAT123"
        }
        "/subscriptions/review/confirm"(platform: "/", type: TrackType.Event) {
            context = "bottom"
            order_id="1425420000"
            item_id="MLM12345"
            category_id="CAT123"
        }

        "/subscriptions/congrats"(platform: "/", type: TrackType.View) {
            order_id="1425420000"
            item_id="MLM12345"
            category_id="CAT123"
        }
        "/subscriptions/congrats/view_subscription"(platform: "/", type: TrackType.Event) {
            order_id="1425420000"
            item_id="MLM12345"
            category_id="CAT123"
        }
        "/subscriptions/congrats/subscribe"(platform: "/", type: TrackType.Event) {}
        "/subscriptions/summary"(platform: "/", type: TrackType.View) {}
        "/subscriptions/detail"(platform: "/", type: TrackType.View) {
            order_id="1425420000"
            item_id="MLM12345"
            category_id="CAT123"
        }
        "/subscriptions/detail/modify_frequency"(platform: "/" ,type: TrackType.View) {}
        "/subscriptions/change_frequency" (platform:"/", type: TrackType.View) {
            frequency = "WEEKS_2"
            frequency_before = "WEEKS_1"
            context = "details/myml"
            order_id="1425420000"
            item_id="MLM12345"
            category_id="CAT123"
        }
        "/subscriptions/address" (platform:"/", type: TrackType.View) {}
        "/subscriptions/change_address" (platform:"/", type: TrackType.Event) {
            context = "details/myml"
        }
        "/subscriptions/delivery/cancel"(platform: "/", type: TrackType.View) {
            context = "now"
            order_id="1425420000"
            item_id="MLM12345"
            category_id="CAT123"
        }
        "/subscriptions/delivery/cancel"(platform: "/", type: TrackType.Event) {
            context = "now"
            order_id="1425420000"
            item_id="MLM12345"
            category_id="CAT123"
        }
        "/subscriptions/detail/cancel"(platform: "/", type: TrackType.View) {
            order_id="1425420000"
            item_id="MLM12345"
            category_id="CAT123"
        }
        "/subscriptions/detail/cancel/subscription"(platform: "/", type: TrackType.Event) {
            order_id="1425420000"
            item_id="MLM12345"
            category_id="CAT123"
        }

        "/subscriptions_landing"(platform: "/", type: TrackType.View) {}

        "/subscriptions_landing/select_item_slide"(platform: "/", type: TrackType.Event) {
            category_id="CAT123"
        }

        "/subscriptions_landing/terms_condition"(platform: "/", type: TrackType.Event) {}
    }

}
