package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {
    defaultBusiness = "mercadolibre"

    test("Claim creation step") {
        "/claims/create_claim/allow"(platform: "/", type: TrackType.View)  {
            ref="returns"
            returns_loyalty_level=6
            returns_date_delivered="2018-03-26"
            returns_cart_order=false
            returns_item_category="MLB107481"
            returns_refund_account_money=false
            returns_item_category_l1="MLB1574"
            returns_authorized=true
        }
    }

    test("Claim view error") {
        "/claims/error"(platform: "/", type: TrackType.View) {
            type = 'claim_not_found'
        }
    }

    test("Claim detail") {
        "/claims/detail"(platform: "/", type: TrackType.View) {
            status = 'claim_opened'
        }
    }

    test("Contract Claim") {
        "/claims/create_claim/form"(platform: "/") {
            vertical = 'SERVICES'
            order_id = 1703206862
            item_id = 'MLA722247557'
            seller_id = 282439040
            reason = 'undelivered'
            reason_detail = 'undelivered_repentant_buyer'
        }

        "/claims/create_claim/creation"(platform: "/", type: TrackType.Event)  {
            vertical = 'SERVICES'
            order_id = 1703206862
            item_id = 'MLA722247557'
            seller_id = 282439040
            reason = 'undelivered'
            reason_detail = 'undelivered_repentant_buyer'
        }
    }

    test("Init claim steps") {
        "/claims/init"(platform: "/") {
            pageName = "create_claim"
        }
    }

    defaultBusiness = "mercadopago"

    test("Claim creation step") {
        "/claims/create_claim/allow"(platform: "/", type: TrackType.View)  {
            ref="returns"
            returns_loyalty_level=6
            returns_date_delivered="2018-03-26"
            returns_cart_order=false
            returns_item_category="MLB107481"
            returns_refund_account_money=false
            returns_item_category_l1="MLB1574"
            returns_authorized=true
        }
    }

    test("Claim view error") {
        "/claims/error"(platform: "/", type: TrackType.View) {
            type = 'claim_not_found'
        }
    }

    test("Claim detail") {
        "/claims/detail"(platform: "/", type: TrackType.View) {
            status = 'claim_opened'
        }
    }

    test("Contract Claim") {
        "/claims/create_claim/form"(platform: "/") {
            vertical = 'SERVICES'
            order_id = 1703206862
            item_id = 'MLA722247557'
            seller_id = 282439040
            reason = 'undelivered'
            reason_detail = 'undelivered_repentant_buyer'
        }

        "/claims/create_claim/creation"(platform: "/", type: TrackType.Event)  {
            vertical = 'SERVICES'
            order_id = 1703206862
            item_id = 'MLA722247557'
            seller_id = 282439040
            reason = 'undelivered'
            reason_detail = 'undelivered_repentant_buyer'
        }
    }

    test("Init claim steps") {
        "/claims/init"(platform: "/") {
            pageName = "create_claim"
        }
    }
}
