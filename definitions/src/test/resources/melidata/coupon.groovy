package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Coupon track ML") {

        // Coupon Input  Screen
        "/coupon/input"(platform: "/mobile", type: TrackType.View) {
            code = "1234ABCD"
            campaign_brand = "CopaAmerica"
            is_auto_sendable = true
        }

        // Coupon Input  Events
        "/coupon/input/continue"(platform: "/mobile", type: TrackType.Event) {
            code = "1234ABCD"
            campaign_brand = "CopaAmerica"
            is_auto_sendable = true
        }

        // Coupon Success Screen
        "/coupon/success"(platform: "/mobile", type: TrackType.View) {
            flow = "sube"
            entity_id = "1234567"
            entity_type = "invalid_code"
            code = "1234ABCD"
            campaign_brand = "CopaAmerica"
            is_auto_sendable = true
        }

        // Coupon Success Events
        "/coupon/success/button"(platform: "/mobile", type: TrackType.Event) {
            entity_type = "invalid_code"
            code = "1234ABCD"
            type = "primary"
            action = "retry"
            campaign_brand = "CopaAmerica"
            is_auto_sendable = true
        }

        // Coupon Error Screen
        "/coupon/error"(platform: "/mobile", type: TrackType.View) {
            code = "1234ABCD"
            entity_type = "invalid_code"
            campaign_brand = "CopaAmerica"
            is_auto_sendable = true
        }

        // Coupon Error Events
        "/coupon/error/button"(platform: "/mobile", type: TrackType.Event) {
            entity_type = "invalid_code"
            code = "1234ABCD"
            type = "primary"
            action = "retry"
            campaign_brand = "CopaAmerica"
            is_auto_sendable = true
        }
    }

    defaultBusiness = "mercadopago"

    test("Coupon track MP") {

        // MOBILE
        // Coupon Input  Screen
        "/coupon/input"(platform: "/mobile", type: TrackType.View) {
            code = "1234ABCD"
            campaign_brand = "CopaAmerica"
            is_auto_sendable = true
        }

        // Coupon Input  Events
        "/coupon/input/continue"(platform: "/mobile", type: TrackType.Event) {
            code = "1234ABCD"
            campaign_brand = "CopaAmerica"
            is_auto_sendable = true
        }

        // Coupon Success Screen
        "/coupon/success"(platform: "/mobile", type: TrackType.View) {
            flow = "sube"
            entity_id = "1234567"
            entity_type = "invalid_code"
            code = "1234ABCD"
            campaign_brand = "CopaAmerica"
            is_auto_sendable = true
        }

        // Coupon Success Events
        "/coupon/success/button"(platform: "/mobile", type: TrackType.Event) {
            entity_type = "invalid_code"
            code = "1234ABCD"
            type = "primary"
            action = "retry"
            campaign_brand = "CopaAmerica"
            is_auto_sendable = true
        }

        // Coupon Error Screen
        "/coupon/error"(platform: "/mobile", type: TrackType.View) {
            code = "1234ABCD"
            entity_type = "invalid_code"
            campaign_brand = "CopaAmerica"
            is_auto_sendable = true
        }

        // Coupon Error Events
        "/coupon/error/button"(platform: "/mobile", type: TrackType.Event) {
            entity_type = "invalid_code"
            code = "1234ABCD"
            type = "primary"
            action = "retry"
            campaign_brand = "CopaAmerica"
            is_auto_sendable = true
        }
    }
}
