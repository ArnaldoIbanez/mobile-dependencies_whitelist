package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadopago"

    test("cards cobranded acquisition") {

        // View
        "/cobranded/acquisition/landing"(platform: "/web/desktop", type: TrackType.View){}
        "/cobranded/acquisition/landing"(platform: "/web/mobile", type: TrackType.View){}
    }


    test("cards cobranded acquisition flow") {

        // View
        "/cobranded/acquisition/main_info"(platform: "/", type: TrackType.View){}
        "/cobranded/acquisition/score_info"(platform: "/", type: TrackType.View){}
        "/cobranded/acquisition/additional_info"(platform: "/", type: TrackType.View){}
        "/cobranded/acquisition/delivery_mode_selection"(platform: "/", type: TrackType.View){}
        "/cobranded/acquisition/delivery_info"(platform: "/", type: TrackType.View){}
        "/cobranded/acquisition/delivery_branch_info"(platform: "/", type: TrackType.View){}
        "/cobranded/acquisition/approved_premium"(platform: "/", type: TrackType.View){}
        "/cobranded/acquisition/premium_details"(platform: "/", type: TrackType.View){}
        "/cobranded/acquisition/confirmed_premium"(platform: "/", type: TrackType.View){}
        "/cobranded/acquisition/approved"(platform: "/", type: TrackType.View){}
    }


    test("cards cobranded error") {

        // View
        "/cobranded/acquisition/error"(platform: "/", type: TrackType.View){}
        "/cobranded/acquisition/error_no_js"(platform: "/", type: TrackType.View){}
        "/cobranded/acquisition/not_allowed_action"(platform: "/", type: TrackType.View){}
        "/cobranded/acquisition/premium_timeout"(platform: "/", type: TrackType.View){}
    }


    test("cards cobranded old pages") {

        // View
        "/cobranded/acquisition/master_info"(platform: "/", type: TrackType.View){}
        "/cobranded/acquisition/master_rejected"(platform: "/", type: TrackType.View){}
        "/cobranded/acquisition/ready_applicant"(platform: "/", type: TrackType.View){}
    }
}
