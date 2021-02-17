package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    // All tests here must be done for business:"mercadopago" and business:"mercadolibre"

    test("Loyalty parent track mercadopago") {
        "/loyalty"(platform: "/", type: TrackType.View, business: "mercadopago") {
        }

        "/loyalty"(platform: "/", type: TrackType.View, business: "mercadopago") {
            origin = "vip"
        }
    }

    test("Loyalty parent track mercadolibre") {
        "/loyalty"(platform: "/", type: TrackType.View, business: "mercadolibre") {
        }

        "/loyalty"(platform: "/", type: TrackType.View, business: "mercadolibre") {
            origin = "vip"
        }
    }

    test("Loyalty v2 pageviews mercadopago") {
        "/loyalty/hub"(platform: "/", type: TrackType.View, business: "mercadopago") {}
        "/loyalty/hub/skeleton"(platform: "/", type: TrackType.View, business: "mercadopago") {}
        "/loyalty/status"(platform: "/", type: TrackType.View, business: "mercadopago") {}
        "/loyalty/status/skeleton"(platform: "/", type: TrackType.View, business: "mercadopago") {}
        "/loyalty/milestones_v2"(platform: "/", type: TrackType.View, business: "mercadopago") {}
        "/loyalty/milestone_v2"(platform: "/", type: TrackType.View, business: "mercadopago") {
            milestone_id = "qr"
            is_accomplished = true
        }
    }

    test("Loyalty v2 pageviews mercadolibre") {
        "/loyalty/hub"(platform: "/", type: TrackType.View, business: "mercadolibre") {}
        "/loyalty/hub/skeleton"(platform: "/", type: TrackType.View, business: "mercadolibre") {}
        "/loyalty/status"(platform: "/", type: TrackType.View, business: "mercadolibre") {}
        "/loyalty/status/skeleton"(platform: "/", type: TrackType.View, business: "mercadolibre") {}
        "/loyalty/milestones_v2"(platform: "/", type: TrackType.View, business: "mercadolibre") {}
        "/loyalty/milestone_v2"(platform: "/", type: TrackType.View, business: "mercadolibre") {
            milestone_id = "qr"
            is_accomplished = true
        }
    }

    test("Loyalty v2 events mercadopago") {
        "/loyalty/messages_close"(platform: "/", type: TrackType.Event, business: "mercadopago") {
            id = "info-tooltip-blue"
        }

        "/loyalty/onboarding/open"(platform: "/", type: TrackType.Event, business: "mercadopago") {
            step = "header"
        }
        "/loyalty/onboarding/continue"(platform: "/", type: TrackType.Event, business: "mercadopago") {
            step = "benefits"
        }
        "/loyalty/onboarding/previous"(platform: "/", type: TrackType.Event, business: "mercadopago") {
            step = "header"
        }
        "/loyalty/onboarding/close"(platform: "/", type: TrackType.Event, business: "mercadopago") {
            step = "benefits"
        }

        "/loyalty/card/item_action"(platform: "/", type: TrackType.Event, business: "mercadopago") {
            page = "hub"
            type = "benefits-card"
            position = 0
            id = "MLA123"
            item_position = 1
        }

        "/loyalty/card/action"(platform: "/", type: TrackType.Event, business: "mercadopago") {
            page = "hub"
            type = "benefits-card"
            position = 0
        }

        "/loyalty/card/download"(platform: "/", type: TrackType.Event, business: "mercadopago") {
            page = "status"
            type = "qr-benefits"
            position = 2
        }
        "/loyalty/card/update"(platform: "/", type: TrackType.Event, business: "mercadopago") {
            page = "status"
            type = "qr-benefits"
            position = 2
        }

        "/loyalty/card/benefits_swipe"(platform: "/", type: TrackType.Event, business: "mercadopago") {
            page = "status"
            type = "benefits"
            position = 1
            card_level = 3
        }

        "/loyalty/milestone_v2/action"(platform: "/", type: TrackType.Event, business: "mercadopago") {
            milestone_id = "qr_payment"
            is_accomplished = false
        }
    }

    test("Loyalty v2 events mercadolibre") {
        "/loyalty/messages_close"(platform: "/", type: TrackType.Event, business: "mercadolibre") {
            id = "info-tooltip-blue"
        }

        "/loyalty/onboarding/open"(platform: "/", type: TrackType.Event, business: "mercadolibre") {
            step = "header"
        }
        "/loyalty/onboarding/continue"(platform: "/", type: TrackType.Event, business: "mercadolibre") {
            step = "benefits"
        }
        "/loyalty/onboarding/previous"(platform: "/", type: TrackType.Event, business: "mercadolibre") {
            step = "header"
        }
        "/loyalty/onboarding/close"(platform: "/", type: TrackType.Event, business: "mercadolibre") {
            step = "benefits"
        }

        "/loyalty/card/item_action"(platform: "/", type: TrackType.Event, business: "mercadolibre") {
            page = "hub"
            type = "benefits-card"
            position = 0
            id = "MLA123"
            item_position = 1
        }

        "/loyalty/card/action"(platform: "/", type: TrackType.Event, business: "mercadolibre") {
            page = "hub"
            type = "benefits-card"
            position = 0
        }

        "/loyalty/card/action"(platform: "/", type: TrackType.Event, business: "mercadolibre") {
            page = "offers"
            type = "coupon-offers"
            position = 0
        }

        "/loyalty/card/download"(platform: "/", type: TrackType.Event, business: "mercadolibre") {
            page = "status"
            type = "qr-benefits"
            position = 2
        }
        "/loyalty/card/update"(platform: "/", type: TrackType.Event, business: "mercadolibre") {
            page = "status"
            type = "qr-benefits"
            position = 2
        }

        "/loyalty/card/benefits_swipe"(platform: "/", type: TrackType.Event, business: "mercadolibre") {
            page = "status"
            type = "benefits"
            position = 1
            card_level = 3
        }

        "/loyalty/milestone_v2/action"(platform: "/", type: TrackType.Event, business: "mercadolibre") {
            milestone_id = "qr_payment"
            is_accomplished = false
        }
    }

    test("Loyalty CrossSellingComponent") {
        "/loyalty/crossselling/carousel/action"(platform: "/", type: TrackType.Event, business: "mercadolibre") {
            origin = "home"
            item_number = 2
        }

        "/loyalty/crossselling/action"(platform: "/", type: TrackType.Event, business: "mercadolibre") {
            origin = "central-descuentos"
            title = "HBO"
            level = 3
            button_deeplink = "deeplink"
        }
    }

    test("Loyalty CrossSellingComponent in mercadopago") {
        "/loyalty/crossselling/carousel/action"(platform: "/", type: TrackType.Event, business: "mercadopago") {
            origin = "deals"
            item_number = 2
        }

        "/loyalty/crossselling/carousel/action"(platform: "/", type: TrackType.Event, business: "mercadopago") {
            origin = "deals"
            item_number = 0
            item_link = "meli://loyalty"
        }

        "/loyalty/crossselling/action"(platform: "/", type: TrackType.Event, business: "mercadopago") {
            origin = "central-descuentos"
            title = "Paramount"
            level = 1
            button_deeplink = "deeplink"
        }
    }


    test("Loyalty VDP Content") {

        "/loyalty/partners/vdp"(platform: "/", type: TrackType.View, business: "mercadolibre") {
            subscription_partner = "HBO Go"
            content = "Game of thrones"
            discount_percent = 30
            subscription_status = "freetrial"
            origin = "home"
            plan_id = 123123
        }

        "/loyalty/partners/vdp"(platform: "/", type: TrackType.View, business: "mercadopago") {
            subscription_partner = "HBO Go"
            content = "Game of thrones"
            discount_percent = 30
            subscription_status = "active"
        }

        "/loyalty/partners/vdp/action"(platform: "/", type: TrackType.Event, business: "mercadolibre") {
            subscription_partner = "HBO Go"
            content = "Game of thrones"
            type = "content"
            name = "Game of thrones"
            subscription_type = "pack-6-months"
        }

        "/loyalty/partners/vdp"(platform: "/", type: TrackType.View, business: "mercadolibre") {
            subscription_partner = "HBO Go"
            content = "Game of thrones"
            discount_percent = 30
            subscription_status = "none"
        }

        "/loyalty/partners/vdp/action"(platform: "/", type: TrackType.Event, business: "mercadopago") {
            subscription_partner = "HBO Go"
            content = "Game of thrones"
            type = "content"
            name = "Game of thrones"
            position = 3
        }

        "/loyalty/partners/vdp/action"(platform: "/", type: TrackType.Event, business: "mercadolibre") {
            subscription_partner = "HBO Go"
            content = "Game of thrones"
            type = "tyc"
        }

        "/loyalty/partners/vdp/action"(platform: "/", type: TrackType.Event, business: "mercadopago") {
            subscription_partner = "HBO Go"
            content = "Game of thrones"
            type = "primary"
        }

        "/loyalty/partners/vdp"(platform: "/", type: TrackType.View, business: "mercadopago") {
            subscription_partner = "HBO Go"
            content = "Game of thrones"
            discount_percent = 30
        }

        "/loyalty/partners/vdp/content"(platform: "/", type: TrackType.View, business: "mercadolibre") {
            subscription_partner = "HBO Go"
            content = "Game of thrones"
        }

        "/loyalty/partners/vdp/content"(platform: "/", type: TrackType.View, business: "mercadopago") {
            subscription_partner = "HBO Go"
            content = "Game of thrones"
        }

        "/loyalty/partners/vdp/content/action"(platform: "/", type: TrackType.Event, business: "mercadolibre") {
            subscription_partner = "HBO Go"
            content = "Game of thrones"
            type = "tyc"
        }

        "/loyalty/partners/vdp/content/action"(platform: "/", type: TrackType.Event, business: "mercadopago") {
            subscription_partner = "HBO Go"
            content = "Game of thrones"
            type = "primary"
        }

    }

    test("Loyalty Subscription Congrats") {

        "/loyalty/partners/checkout/congrats"(platform: "/", type: TrackType.View, business: "mercadolibre") {
            loyalty_level = 3
            subscription_partner = "HBO"
            payment_id = "42323"
            payment_status = "success"
            payment_status_detail = "activated"
            is_free_trial = "true"
            discount_percent = 40
            plan_id = 123123
        }

        "/loyalty/partners/checkout/congrats"(platform: "/", type: TrackType.View, business: "mercadopago") {
            loyalty_level = 3
            subscription_partner = "HBO"
            payment_id = "42323"
            payment_status = "success"
            payment_status_detail = "freetrial-activated"
            is_free_trial = "true"
            discount_percent = 40
            subscription_type = "pack-6-months"
        }

        "/loyalty/partners/checkout/congrats/action"(platform: "/", type: TrackType.Event, business: "mercadolibre") {
            loyalty_level = 1
            subscription_partner = "Paramount"
            payment_id = "42323"
            payment_status = "pending"
            payment_status_detail = "contingency"
            is_free_trial = "false"
            discount_percent = 0
            type = "tyc"
            subscription_type = "pack-6-months"
        }

        "/loyalty/partners/checkout/congrats/action"(platform: "/", type: TrackType.Event, business: "mercadopago") {
            loyalty_level = 1
            subscription_partner = "Paramount"
            payment_id = "42323"
            payment_status = "pending"
            payment_status_detail = "manual"
            is_free_trial = "false"
            discount_percent = 0
            type = "action"
            label = "Ir a HBO"
            deeplink = "meli://loyalty"
        }

        "/loyalty/partners/checkout/congrats/info"(platform: "/", type: TrackType.Event, business: "mercadopago") {
            type = "email"
            payment_id = "42323"
            payment_status = "success"
            plan_id = 123123
        }

        "/loyalty/partners/checkout/congrats/info"(platform: "/", type: TrackType.Event, business: "mercadolibre") {
            type = "site"
            payment_id = "42323"
            payment_status = "success"
        }

    }

    test("Loyalty Subscription Login") {

        "/loyalty/partners/login"(platform: "/", type: TrackType.View, business: "mercadolibre") {
            subscription_partner = "HBO"
        }

        "/loyalty/partners/login"(platform: "/", type: TrackType.View, business: "mercadopago") {
            subscription_partner = "HBO"
        }


        "/loyalty/partners/login/action"(platform: "/", type: TrackType.Event, business: "mercadolibre") {
            subscription_partner = "HBO"
        }

        "/loyalty/partners/login/action"(platform: "/", type: TrackType.Event, business: "mercadopago") {
            subscription_partner = "HBO"
        }

        "/loyalty/partners/login/verify"(platform: "/", type: TrackType.View, business: "mercadolibre") {
            subscription_partner = "HBO"
        }

        "/loyalty/partners/login/verify"(platform: "/", type: TrackType.View, business: "mercadopago") {
            subscription_partner = "HBO"
        }

        "/loyalty/partners/login/verify/action"(platform: "/", type: TrackType.Event, business: "mercadolibre") {
            subscription_partner = "HBO"
            type = "push"
        }

        "/loyalty/partners/login/verify/action"(platform: "/", type: TrackType.Event, business: "mercadopago") {
            subscription_partner = "HBO"
            type = "email"
        }


        "/loyalty/partners/login/code"(platform: "/", type: TrackType.View, business: "mercadolibre") {
            subscription_partner = "HBO"
            viewType = "email"
        }

        "/loyalty/partners/login/code"(platform: "/", type: TrackType.View, business: "mercadopago") {
            subscription_partner = "HBO"
            viewType = "notification"
        }

        "/loyalty/partners/login/code/action"(platform: "/", type: TrackType.Event, business: "mercadolibre") {
            subscription_partner = "HBO"
            type = "verify"
        }

        "/loyalty/partners/login/code/action"(platform: "/", type: TrackType.Event, business: "mercadopago") {
            subscription_partner = "HBO"
            type = "resend"
        }

        "/loyalty/partners/login/verified"(platform: "/", type: TrackType.Event, business: "mercadolibre") {
            subscription_partner = "HBO"
            url = "meli://loyalty"
        }

        "/loyalty/partners/login/verified"(platform: "/", type: TrackType.Event, business: "mercadopago") {
            subscription_partner = "HBO"
        }

        "/loyalty/partners/login/invalid"(platform: "/", type: TrackType.Event, business: "mercadopago") {
            subscription_partner = "HBO"
        }

        "/loyalty/partners/login/invalid"(platform: "/", type: TrackType.Event, business: "mercadolibre") {
            subscription_partner = "Paramount"
            server_error = false
        }

    }

    test("Loyalty Subscription Admin") {

        "/loyalty/partners/admin"(platform: "/", type: TrackType.View, business: "mercadolibre") {
            subscription_partner = "HBO"
            level = 4
            subscription_status = "active"
        }

        "/loyalty/partners/admin"(platform: "/", type: TrackType.View, business: "mercadopago") {
            subscription_partner = "Paramount"
            level = 4
        }

        "/loyalty/partners/admin/action"(platform: "/", type: TrackType.Event, business: "mercadolibre") {
            subscription_partner = "HBO"
            subscription_status = "active"
            level = 4
            type = "detail-action"
        }

        "/loyalty/partners/admin/action"(platform: "/", type: TrackType.Event, business: "mercadopago") {
            subscription_partner = "HBO"
            subscription_status = "ended"
            level = 4
            type = "modify-action"
        }

        "/loyalty/partners/summary"(platform: "/", type: TrackType.View, business: "mercadolibre") {
            level = 4
        }

        "/loyalty/partners/summary"(platform: "/", type: TrackType.View, business: "mercadopago") {
        }

        "/loyalty/partners/teaser"(platform: "/", type: TrackType.View, business: "mercadolibre") {
            subscription_partner = "Disney"
            origin = "home"
        }

        "/loyalty/partners/teaser"(platform: "/", type: TrackType.View, business: "mercadopago") {
            subscription_partner = "HBO Go"
            discount_percent = 30
        }
    }
}