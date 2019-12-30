package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    // All tests here must be done for business:"mercadopago" and business:"mercadolibre"

    test("Loyalty parent track mercadopago") {
        "/loyalty"(platform:"/", type: TrackType.View, business:"mercadopago") {
        }

        "/loyalty"(platform:"/", type: TrackType.View, business:"mercadopago") {
            origin = "vip"
        }
    }

    test("Loyalty parent track mercadolibre") {
        "/loyalty"(platform:"/", type: TrackType.View, business:"mercadolibre") {
        }

        "/loyalty"(platform:"/", type: TrackType.View, business:"mercadolibre") {
            origin = "vip"
        }
    }

    test("Loyalty v2 pageviews mercadopago"){
        "/loyalty/hub"(platform: "/", type: TrackType.View, business:"mercadopago"){}
        "/loyalty/hub/skeleton"(platform: "/", type: TrackType.View, business:"mercadopago"){}
        "/loyalty/status"(platform: "/", type: TrackType.View, business:"mercadopago"){}
        "/loyalty/status/skeleton"(platform: "/", type: TrackType.View, business:"mercadopago"){}
        "/loyalty/milestones_v2"(platform: "/", type: TrackType.View, business:"mercadopago"){}
        "/loyalty/milestone_v2"(platform: "/", type: TrackType.View, business:"mercadopago"){
            milestone_id = "qr"
            is_accomplished = true
        }
    }

    test("Loyalty v2 pageviews mercadolibre"){
        "/loyalty/hub"(platform: "/", type: TrackType.View, business:"mercadolibre"){}
        "/loyalty/hub/skeleton"(platform: "/", type: TrackType.View, business:"mercadolibre"){}
        "/loyalty/status"(platform: "/", type: TrackType.View, business:"mercadolibre"){}
        "/loyalty/status/skeleton"(platform: "/", type: TrackType.View, business:"mercadolibre"){}
        "/loyalty/milestones_v2"(platform: "/", type: TrackType.View, business:"mercadolibre"){}
        "/loyalty/milestone_v2"(platform: "/", type: TrackType.View, business:"mercadolibre"){
            milestone_id = "qr"
            is_accomplished = true
        }
    }

    test("Loyalty v2 events mercadopago") {
        "/loyalty/messages_close"(platform: "/", type: TrackType.Event, business:"mercadopago") {
            id = "info-tooltip-blue"
        }

        "/loyalty/onboarding/open"(platform: "/", type: TrackType.Event, business:"mercadopago") {
            step = "header"
        }
        "/loyalty/onboarding/continue"(platform: "/", type: TrackType.Event, business:"mercadopago") {
            step = "benefits"
        }
        "/loyalty/onboarding/previous"(platform: "/", type: TrackType.Event, business:"mercadopago") {
            step = "header"
        }
        "/loyalty/onboarding/close"(platform: "/", type: TrackType.Event, business:"mercadopago") {
            step = "benefits"
        }

        "/loyalty/card/item_action"(platform: "/", type: TrackType.Event, business:"mercadopago") {
            page = "hub"
            type = "benefits-card"
            position = 0
            id = "MLA123"
            item_position = 1
        }

        "/loyalty/card/action"(platform: "/", type: TrackType.Event, business:"mercadopago") {
            page = "hub"
            type = "benefits-card"
            position = 0
        }

        "/loyalty/card/download"(platform: "/", type: TrackType.Event, business:"mercadopago") {
            page = "status"
            type = "qr-benefits"
            position = 2
        }
        "/loyalty/card/update"(platform: "/", type: TrackType.Event, business:"mercadopago") {
            page = "status"
            type = "qr-benefits"
            position = 2
        }

        "/loyalty/card/benefits_swipe"(platform: "/", type: TrackType.Event, business:"mercadopago") {
            page = "status"
            type = "benefits"
            position = 1
            card_level = 3
        }

        "/loyalty/milestone_v2/action"(platform: "/", type: TrackType.Event, business:"mercadopago") {
            milestone_id = "qr_payment"
            is_accomplished = false
        }
    }

    test("Loyalty v2 events mercadolibre") {
        "/loyalty/messages_close"(platform: "/", type: TrackType.Event, business:"mercadolibre") {
            id = "info-tooltip-blue"
        }

        "/loyalty/onboarding/open"(platform: "/", type: TrackType.Event, business:"mercadolibre") {
            step = "header"
        }
        "/loyalty/onboarding/continue"(platform: "/", type: TrackType.Event, business:"mercadolibre") {
            step = "benefits"
        }
        "/loyalty/onboarding/previous"(platform: "/", type: TrackType.Event, business:"mercadolibre") {
            step = "header"
        }
        "/loyalty/onboarding/close"(platform: "/", type: TrackType.Event, business:"mercadolibre") {
            step = "benefits"
        }

        "/loyalty/card/item_action"(platform: "/", type: TrackType.Event, business:"mercadolibre") {
            page = "hub"
            type = "benefits-card"
            position = 0
            id = "MLA123"
            item_position = 1
        }

        "/loyalty/card/action"(platform: "/", type: TrackType.Event, business:"mercadolibre") {
            page = "hub"
            type = "benefits-card"
            position = 0
        }

        "/loyalty/card/action"(platform: "/", type: TrackType.Event, business:"mercadolibre") {
            page = "offers"
            type = "coupon-offers"
            position = 0
        }

        "/loyalty/card/download"(platform: "/", type: TrackType.Event, business:"mercadolibre") {
            page = "status"
            type = "qr-benefits"
            position = 2
        }
        "/loyalty/card/update"(platform: "/", type: TrackType.Event, business:"mercadolibre") {
            page = "status"
            type = "qr-benefits"
            position = 2
        }

        "/loyalty/card/benefits_swipe"(platform: "/", type: TrackType.Event, business:"mercadolibre") {
            page = "status"
            type = "benefits"
            position = 1
            card_level = 3
        }

        "/loyalty/milestone_v2/action"(platform: "/", type: TrackType.Event, business:"mercadolibre") {
            milestone_id = "qr_payment"
            is_accomplished = false
        }
    }
}
