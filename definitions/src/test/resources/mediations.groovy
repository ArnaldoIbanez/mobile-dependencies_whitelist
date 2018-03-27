import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {
    defaultBusiness = "mercadolibre"

    test("Claim creation step") {
        "/claims"(platform: "/") { }
        "/claims/create_claim"(platform: "/") { }
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
        "/claims/create_claim/denied"(platform: "/", type: TrackType.View) {
            reason = 'payment_not_found'
        }
        "/claims/create_claim/creation"(platform: "/", type: TrackType.Event)  {
            reason = 'delivered'
        }
    }

    test("Claim view error") {
        "/claims/error"(platform: "/", type: TrackType.View) {
            type = 'claim_not_found'
        }
    }

    test("Stale flow") {
        "/claims/stale"(platform: "/", type: TrackType.View) {
            reason = 'shipment_on_time'
            expected_resolution = 'refund'
        }
    }

    test("Claim detail") {
        "/claims/detail"(platform: "/", type: TrackType.View) {
            status = 'claim_opened'
        }
    }
}