package catalog.melidata

import com.ml.melidata.TrackType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /**
        Disbursements Tracks
    **/
    initiative = '1240'

    "/disbursements"(platform: "/", isAbstract: true) {}
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
         reason (required_:false, description: "Indicates why the remittance has been rejected")
    }
    "/disbursements/xoom/rejected/share"(platform: "/", type: TrackType.Event) {}
    "/disbursements/xoom/rejected/change_my_data"(platform: "/", type: TrackType.Event) {}
    "/disbursements/xoom/rejected/go_home"(platform: "/", type: TrackType.Event) {}
    "/disbursements/xoom/information"(platform: "/", type: TrackType.View) {}
}
