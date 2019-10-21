package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    test("free data") {

        "/free_navigation"(platform:"/mobile", type:TrackType.Event) {
            status = "sponsored"
        }

        "/free_navigation/dialog"(platform:"/mobile", type:TrackType.View) {
        }

        "/free_navigation/snackbar"(platform:"/mobile", type:TrackType.View) {
        }

        "/free_navigation/dialog_dismissed"(platform:"/mobile", type:TrackType.Event) {
            is_checkbox_checked = true
        }

        "/free_navigation/purchase"(platform:"/mobile", type:TrackType.Event) {
            status = "sponsored"
        }
    }

    test("free data ML") {

        "/free_navigation"(platform:"/mobile", type:TrackType.Event, business:"mercadolibre") {
            status = "sponsored"
        }

        "/free_navigation/dialog"(platform:"/mobile", type:TrackType.View,business:"mercadolibre") {
        }

        "/free_navigation/snackbar"(platform:"/mobile", type:TrackType.View,business:"mercadolibre") {
        }

        "/free_navigation/dialog_dismissed"(platform:"/mobile", type:TrackType.Event,business:"mercadolibre") {
            is_checkbox_checked = true
        }

        "/free_navigation/purchase"(platform:"/mobile", type:TrackType.Event,business:"mercadolibre") {
            status = "sponsored"
        }
    }

}
