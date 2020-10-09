package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

     /**
        Disbursements
    **/

    test("Disbursements") {
    
    "/disbursements"(platform: "/") {}
    "/disbursements/xoom"(platform: "/", type: TrackType.View) {}

    // Onboarding
    "/disbursements/xoom/onboarding"(platform: "/", type: TrackType.View) {}
    "/disbursements/xoom/onboarding/continue"(platform: "/", type: TrackType.Event) {}
    "/disbursements/xoom/onboarding/close"(platform: "/", type: TrackType.Event) {}

    // Congrat Pending Approve (Verde)
    "/disbursements/xoom/pending_approve"(platform: "/", type: TrackType.View) {}
    "/disbursements/xoom/pending_approve/go_home"(platform: "/", type: TrackType.Event) {}

    // Congrat Rejected By beneficiary data error (Roja)
    "/disbursements/xoom/rejected"(platform: "/", type: TrackType.View) {
        reason = "by_data_error"
    }
    "/disbursements/xoom/rejected/share"(platform: "/", type: TrackType.Event) {
        reason = "by_data_error"
    }
    "/disbursements/xoom/rejected/change_my_data"(platform: "/", type: TrackType.Event) {
        reason = "by_data_error"
    }
    "/disbursements/xoom/rejected/go_home"(platform: "/", type: TrackType.Event) {
        reason = "by_data_error"
    }
    "/disbursements/xoom/information"(platform: "/", type: TrackType.View) {}
    "/disbursements/xoom/information/share"(platform: "/", type: TrackType.Event) {}
    "/disbursements/xoom/information/kyc"(platform: "/", type: TrackType.Event) {}

    }
}
