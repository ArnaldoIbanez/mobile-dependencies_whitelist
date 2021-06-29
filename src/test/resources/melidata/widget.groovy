package src.test.resources.melidata


import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests


trackTests {

    defaultBusiness = "mercadopago"

    test("User tries to add a new widget") {
        "/widget/collect/config/open" (platform: "/mobile/android", type: TrackType.View) {
            widget_id = 1
            is_collaborator = false
        }
    }

    test("Data service for setup screen response okay") {
        "/widget/collect/config/success"(platform: "/mobile/android", type: TrackType.Event) {
            widget_id = 1
            is_collaborator = true
            collect_methods_count = 0
        }
    }

    test("Data service for setup screen response with error") {
        "/widget/collect/config/error"(platform: "/mobile/android", type: TrackType.Event) {
            widget_id = 1
            is_collaborator = true
        }
    }

    test("User exits config page using back button") {
        "/widget/collect/config/back"(platform: "/mobile/android", type: TrackType.Event) {
            widget_id = 1
            is_collaborator = true
        }
    }

    test("User saves widget configuration") {
        "/widget/collect/config/save"(platform: "/mobile/android", type: TrackType.Event) {
            widget_id = 1
            collect_method = "point"
            is_collaborator = false
        }
    }

    test("User tries tu add a new widget not being logged in") {
        "/widget/collect/config/not_logged"(platform: "/mobile/android", type: TrackType.Event) {
            widget_id = 1
        }
    }

    test("User taps over the widget") {
        "/widget/collect/tap"(platform: "/mobile/android", type: TrackType.Event) {
            widget_id = 1
            collect_method = "point"
            is_collaborator = false
        }
    }

    test("User removes widget from homescreen") {
        "/widget/collect/remove"(platform: "/mobile/android", type: TrackType.Event) {
            widget_id = 1
            collect_method = "qr"
            is_collaborator = false
        }
    }

    test("User taps widget not being logged in") {
        "/widget/collect/not_logged"(platform: "/mobile/android", type: TrackType.Event) {
            widget_id = 1
            collect_method = "point"
        }
    }
}