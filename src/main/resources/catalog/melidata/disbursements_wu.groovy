package catalog.melidata
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /**
        Disbursements WU Tracks
    **/
    initiative = '1240'

    "/disbursements/wu"(platform: "/", isAbstract: true) {}

    // Hub 
    "/disbursements/wu/hub"(platform: "/", type: TrackType.View) {}
    "/disbursements/wu/hub/yes"(platform: "/", type: TrackType.Event) {}
    "/disbursements/wu/hub/no"(platform: "/", type: TrackType.Event) {}
    "/disbursements/wu/hub/help"(platform: "/", type: TrackType.Event) {}

    // Onboarding
    "/disbursements/wu/hub/onboarding"(platform: "/") {}
    "/disbursements/wu/hub/onboarding/modal"(platform: "/", type: TrackType.Event) {}
    "/disbursements/wu/hub/onboarding/close"(platform: "/", type: TrackType.Event) {}
    "/disbursements/wu/hub/onboarding/continue"(platform: "/", type: TrackType.Event) {}
    "/disbursements/wu/hub/onboarding/help"(platform: "/", type: TrackType.Event) {}

    // Kyc
    "/disbursements/wu/kyc"(platform: "/", type: TrackType.View) {}
    "/disbursements/wu/kyc/yes"(platform: "/") {}
    "/disbursements/wu/kyc/yes/copy"(platform: "/", type: TrackType.Event) {}
    "/disbursements/wu/kyc/yes/mtcn"(platform: "/", type: TrackType.Event) {}
    "/disbursements/wu/kyc/no"(platform: "/") {}
    "/disbursements/wu/kyc/no/copy"(platform: "/", type: TrackType.Event) {}
    "/disbursements/wu/kyc/no/identity"(platform: "/", type: TrackType.Event) {}

    // Mtcn
    "/disbursements/wu/mtcn"(platform: "/", type: TrackType.View) {}
    "/disbursements/wu/mtcn/continue"(platform: "/", type: TrackType.Event) {
        status(required: false, type: PropertyType.String, description: "MTCN validate status (success, not_fount, time_out, etc)")
    }
        
    "/disbursements/wu/mtcn/help"(platform: "/", type: TrackType.Event) {}
    "/disbursements/wu/mtcn/kyc"(platform: "/") {}
    "/disbursements/wu/mtcn/kyc/modal"(platform: "/", type: TrackType.Event) {}
    "/disbursements/wu/mtcn/kyc/modal/identity"(platform: "/", type: TrackType.Event) {}
    "/disbursements/wu/mtcn/disabled"(platform: "/") {}
    "/disbursements/wu/mtcn/disabled/modal"(platform: "/", type: TrackType.View) {}
    "/disbursements/wu/mtcn/disabled/modal/continue"(platform: "/", type: TrackType.Event) {}

    // Ryc
    "/disbursements/wu/ryc"(platform: "/", type: TrackType.View) {}
    "/disbursements/wu/ryc/terms"(platform: "/", type: TrackType.Event) {}
    "/disbursements/wu/ryc/receive"(platform: "/", type: TrackType.Event) {}

    // Congrats
    "/disbursements/wu/congrats"(platform: "/", type: TrackType.View) {
        status(required: false, type: PropertyType.String, description: "Congrats status (success, error or pending)")
    }

    "/disbursements/wu/congrats/home"(platform: "/", type: TrackType.Event) {}
    "/disbursements/wu/congrats/help"(platform: "/", type: TrackType.Event) {}
    "/disbursements/wu/congrats/copy"(platform: "/", type: TrackType.Event) {}

    // Error
    "/disbursements/wu/error"(platform: "/", type: TrackType.View) {}
    "/disbursements/wu/error/reload"(platform: "/", type: TrackType.Event) {}
}