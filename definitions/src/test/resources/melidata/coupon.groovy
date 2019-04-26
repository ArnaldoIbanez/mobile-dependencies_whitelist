package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Coupon track ML") {

        // Coupon Input  Screen
        "/coupon/input"(platform: "/mobile", type: TrackType.View) {
            code = "12345678"
        }

        // Coupon Input  Events
        "/coupon/input/continue"(platform: "/mobile", type: TrackType.Event) {
            code = "12345678"
        }

        // Coupon Success Screen
        "/coupon/success"(platform: "/mobile", type: TrackType.View) {
            code = "12345678"
        }

        // Coupon Success Events
        "/coupon/success/button"(platform: "/mobile", type: TrackType.Event) {
            code = "12345678"
            type = "primary"
            action = "reintentar"
        }

        // Coupon Error Screen
        "/coupon/error"(platform: "/mobile", type: TrackType.View) {
            code = "12345678"
            type = "invalid_code"
        }

        // Coupon Error Events
        "/coupon/error/button"(platform: "/mobile", type: TrackType.Event) {
            code = "12345678"
            type = "primary"
            action = "reintentar"
        }
    }

    defaultBusiness = "mercadopago"

    test("Coupon track MP") {

        // MOBILE
        // Coupon Input  Screen
        "/coupon/input"(platform: "/mobile", type: TrackType.View) {
            code = "12345678"
        }

        // Coupon Input  Events
        "/coupon/input/continue"(platform: "/mobile", type: TrackType.Event) {
            code = "12345678"
        }

        // Coupon Success Screen
        "/coupon/success"(platform: "/mobile", type: TrackType.View) {
            code = "12345678"
        }

        // Coupon Success Events
        "/coupon/success/button"(platform: "/mobile", type: TrackType.Event) {
            code = "12345678"
            type = "primary"
            action = "reintentar"
        }

        // Coupon Error Screen
        "/coupon/error"(platform: "/mobile", type: TrackType.View) {
            code = "12345678"
            type = "invalid_code"
        }

        // Coupon Error Events
        "/coupon/error/button"(platform: "/mobile", type: TrackType.Event) {
            code = "12345678"
            type = "primary"
            action = "reintentar"
        }
    }
}
