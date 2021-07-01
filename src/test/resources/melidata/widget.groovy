package src.test.resources.melidata


import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests


trackTests {

    defaultBusiness = "mercadopago"

    test("Widget config screen is accessed") {
        "/widget/seller_collect/config"(platform: "/mobile/android", type: TrackType.View) {
            widget_id = 1
            collect_methods_count = 0
        }
    }

    test("Widget config screen fails to open") {
        "/widget/seller_collect/config/error"(platform: "/mobile/android", type: TrackType.View) {
            widget_id = 1
        }
    }

    test("User tries tu add a new widget not being logged in") {
        "/widget/seller_collect/config/not_logged"(platform: "/mobile/android", type: TrackType.View) {
            widget_id = 1
        }
    }

    test("User exits config page using back button") {
        "/widget/seller_collect/config/back"(platform: "/mobile/android", type: TrackType.Event) {
            widget_id = 1
        }
    }

    test("User saves widget configuration") {
        "/widget/seller_collect/config/save"(platform: "/mobile/android", type: TrackType.Event) {
            widget_id = 1
            collect_method = "point"
        }
    }

    test("User taps over the widget") {
        "/widget/seller_collect/tap"(platform: "/mobile/android", type: TrackType.Event) {
            widget_id = 1
            collect_method = "point"
        }
    }

    test("User removes widget from homescreen") {
        "/widget/seller_collect/remove"(platform: "/mobile/android", type: TrackType.Event) {
            widget_id = 1
            collect_method = "qr"
        }
    }

    test("User taps widget not being logged in") {
        "/widget/seller_collect/not_logged"(platform: "/mobile/android", type: TrackType.Event) {
            widget_id = 1
            collect_method = "point"
        }
    }
}