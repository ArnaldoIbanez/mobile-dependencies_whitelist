package catalog.melidata

import com.ml.melidata.TrackType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /**
        Cash-in Tracks
    **/
    initiative = "1148"

    "/meliplaces"(platform: "/", isAbstract: true) {}
    "/cash_in"(platform: "/", isAbstract: true) {}
    
    // QR Scanner
    "/meliplaces/cash_in/seller/scanner"(platform: "/", type: TrackType.View) {}
    "/meliplaces/cash_in/seller/scanner/enter_code"(platform: "/", type: TrackType.Event) {}
    "/meliplaces/cash_in/seller/scanner/error"(platform: "/", type: TrackType.Event) {
        type (required_:false, description: "QR scanner error type")
    }

    // QR Manual
    "/meliplaces/cash_in/seller/manual_code"(platform: "/", type: TrackType.View) {}
    "/meliplaces/cash_in/seller/manual_code/continue"(platform: "/", type: TrackType.Event) {}
    "/meliplaces/cash_in/seller/manual_code/error"(platform: "/", type: TrackType.Event) {
        type (required_:false, description: "Manual QR error type")
    }

    // Calculator
    "/meliplaces/cash_in/seller/calculator"(platform: "/", type: TrackType.View) {}
    "/meliplaces/cash_in/seller/calculator/continue"(platform: "/", type: TrackType.Event) {
        amount (required_:false, description: "The calculator amount")
    }

    // Review and Confirm
    "/meliplaces/cash_in/seller/review_and_confirm"(platform: "/", type: TrackType.View) {}
    "/meliplaces/cash_in/seller/review_and_confirm/continue"(platform: "/", type: TrackType.Event) {
        amount (required_:false, description: "The amount entered by the user")
    }
    "/meliplaces/cash_in/seller/review_and_confirm/edit"(platform: "/", type: TrackType.Event) {}
    "/meliplaces/cash_in/seller/review_and_confirm/retry"(platform: "/", type: TrackType.Event) {}

    // Meliplaces
    "/cash_in/payer/meliplace"(platform: "/", type: TrackType.View) {}
    "/cash_in/payer/meliplace/qr_error"(platform: "/", type: TrackType.View) {}
    "/cash_in/payer/meliplace/places_error"(platform: "/", type: TrackType.View) {}
    "/cash_in/payer/meliplace/places_permission_denied"(platform: "/", type: TrackType.View) {}
    "/cash_in/payer/meliplace/show_code"(platform: "/", type: TrackType.Event) {}
    "/cash_in/payer/meliplace/show_steps"(platform: "/", type: TrackType.Event) {}
    "/cash_in/payer/meliplace/help"(platform: "/", type: TrackType.Event) {}
    "/cash_in/payer/meliplace/show_map"(platform: "/", type: TrackType.Event) {}
    "/cash_in/payer/meliplace/show_place"(platform: "/", type: TrackType.Event) {
        place_id (required_:false, description: "The selected place id")
    }
    "/cash_in/payer/meliplace/scroll_up"(platform: "/", type: TrackType.Event) {}
    "/cash_in/payer/meliplace/delay_error"(platform: "/", type: TrackType.Event) {}

    // Meliplaces Onboarding
    "/cash_in/payer/meliplace/onboarding"(platform: "/", type: TrackType.View) {}

    // Map
    "/cash_in/payer/map"(platform: "/", type: TrackType.View) {}
    "/cash_in/payer/map/place"(platform: "/", type: TrackType.Event) {
        place_id (required_:false, description: "The selected place id")
    }
    "/cash_in/payer/map/go_external_map"(platform: "/", type: TrackType.Event) {}
    "/cash_in/payer/map/report"(platform: "/", type: TrackType.Event) {
        place_id (required_:false, description: "The id of the selected place to be reported")
    }

    // Reports
    "/cash_in/payer/report"(platform: "/", type: TrackType.View) {}
    "/cash_in/payer/report/send"(platform: "/", type: TrackType.Event) {
        place_id (required_:false, description: "The id of the reported place")
        option_id (required_:false, description: "The id of the report option selected")
    }
    "/cash_in/payer/report/cancel"(platform: "/", type: TrackType.Event) {}

    // Delay
    "/cash_in/payer/delay"(platform: "/", type: TrackType.View) {}
    "/cash_in/payer/delay_error"(platform: "/", type: TrackType.Event) {}

    // Congrats
    "/cash_in/payer/congrats/success"(platform: "/", type: TrackType.View) {}
    "/cash_in/payer/congrats/error"(platform: "/", type: TrackType.View) {}
    "/cash_in/payer/congrats/success/go_home"(platform: "/", type: TrackType.Event) {}
    "/cash_in/payer/congrats/error/retry"(platform: "/", type: TrackType.Event) {}
    "/cash_in/payer/congrats/error/go_home"(platform: "/", type: TrackType.Event) {}
}