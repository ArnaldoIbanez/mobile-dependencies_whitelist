import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {
    defaultBusiness = "mercadolibre"

    test("Claim creation step") {
        "/claims"(platform: "/") { }
        "/claims/create_claim"(platform: "/") { }
        "/claims/create_claim/allow"(platform: "/", type: TrackType.View)  { }
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

    test("Claims payment already refunded view") {
        "/claims/post_refund"(platform: "/", type: TrackType.View) {
            expected_resolution = 'product'
        }
    }
}
