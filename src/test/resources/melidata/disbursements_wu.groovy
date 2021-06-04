package src.test.resources.melidata
import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

     /**
        Disbursements WU
    **/

    test("Disbursements_wu") {
    
        "/disbursements/wu"(platform: "/") {}

        // Hub and onboarding
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
        "/disbursements/wu/mtcn/continue"(platform: "/", type: TrackType.View) {
            status = "success"
        }
        "/disbursements/wu/mtcn/continue"(platform: "/", type: TrackType.View) {
            status = "rejected:blocked"
        }
        "/disbursements/wu/mtcn/continue"(platform: "/", type: TrackType.View) {
            status = "rejected:refine_input"
        }
        "/disbursements/wu/mtcn/continue"(platform: "/", type: TrackType.View) {
            status = "rejected:not_found"
        }
        "/disbursements/wu/mtcn/continue"(platform: "/", type: TrackType.View) {
            status = "rejected:wu_refused"
        }
        "/disbursements/wu/mtcn/continue"(platform: "/", type: TrackType.View) {
            status = "rejected:time_out"
        }
        "/disbursements/wu/mtcn/continue"(platform: "/", type: TrackType.View) {
            status = "rejected:paid"
        }
        "/disbursements/wu/mtcn/continue"(platform: "/", type: TrackType.View) {
            status = "rejected:other"
        }
        "/disbursements/wu/mtcn/continue"(platform: "/", type: TrackType.View) {
            status = "rejected:processing"
        }
        "/disbursements/wu/mtcn/continue"(platform: "/", type: TrackType.View) {
            status = "rejected:exceed_limit_amount"
        }
        "/disbursements/wu/mtcn/continue"(platform: "/", type: TrackType.View) {
            status = "rrejected:forbidden_to_process"
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
            status = "success"
        }
        "/disbursements/wu/congrats"(platform: "/", type: TrackType.View) {
            status = "error"
        }
        "/disbursements/wu/congrats"(platform: "/", type: TrackType.View) {
            status = "pending"
        }
        "/disbursements/wu/congrats/home"(platform: "/", type: TrackType.Event) {}
        "/disbursements/wu/congrats/help"(platform: "/", type: TrackType.Event) {}
        "/disbursements/wu/congrats/copy"(platform: "/", type: TrackType.Event) {}

        // Error
        "/disbursements/wu/error"(platform: "/", type: TrackType.View) {}
        "/disbursements/wu/error/reload"(platform: "/", type: TrackType.Event) {}
    }
}
