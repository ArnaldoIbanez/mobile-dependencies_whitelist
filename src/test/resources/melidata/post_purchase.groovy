package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("Post purchase tracks") {

        "/post_purchase/reasons"(platform: "/", type: TrackType.View){
            ref = "mediations_init"
        }

        "/post_purchase/reasons/selection"(platform: "/", type: TrackType.Event)  {
            reason = "PDD6565"
        }

        "/post_purchase/potential_resolutions"(platform: "/", type: TrackType.View) {
            ref = "mediations_init"
        }

        "/post_purchase/potential_resolutions/selection"(platform: "/", type: TrackType.Event) {
            request_type = "change_product"
        }

        "/post_purchase/external"(platform: "/", type: TrackType.View) {
            reason = "PDD6565"
            flow = "claim"
            order_id = "2328726398"
            resolution = "change_product"
        }

        "/post_purchase/kyc_onboarding"(platform: "/", type: TrackType.View){
            ref = "mediations_init"
        }

        "/post_purchase/kyc_onboarding/validate"(platform: "/", type: TrackType.Event){}

        "/post_purchase/kyc_onboarding/back"(platform: "/", type: TrackType.Event){}
    }
}