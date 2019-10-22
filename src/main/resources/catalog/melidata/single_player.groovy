package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /**
    * Singe player billpayments Screen Tracks
    */

    "/single_player/billpayments"(platform: "/mobile", isAbstract: true) {
        session_id (required:false, type: PropertyType.String, description: "Session Id of flow")
    }

    "/single_player/billpayments/permissions_rationale"(platform: "/mobile", type: TrackType.View) {}
    "/single_player/billpayments/help"(platform: "/mobile", type: TrackType.View) {}
    "/single_player/billpayments/no_money"(platform: "/mobile", type: TrackType.View) {}
    "/single_player/billpayments/manual_barcode"(platform: "/mobile", type: TrackType.View) {
        barcode_valid (required:false, description: "if the barcode is valid")
    }
    "/single_player/billpayments/barcode_reader"(platform: "/mobile", type: TrackType.View) {}
    "/single_player/billpayments/additional_info"(platform: "/mobile", type: TrackType.View) {
        required_additional_info (required:false, description: "info used to populate the screen")
    }
    "/single_player/billpayments/expired_amount"(platform: "/mobile", type: TrackType.View) {}
    "/single_player/billpayments/generic_screen_info"(platform: "/mobile", type: TrackType.View) {
        utility_error (required:true, description: "the error, we need this to identify the error type")
    }

    /**
     *   Events
     */ 
    "/single_player/billpayments/manual_barcode/read"(platform: "/mobile", type: TrackType.Event) {
        barcode (required:true, description: "the barcode")
    }

    //scanning barcode
    "/single_player/billpayments/barcode_reader/read"(platform: "/mobile", type: TrackType.Event) {
        barcode (required:true, description: "the barcode")
        uuid (required:false, description: "the uuid used to identify a set of scans")
        elapsed_time (required:false, description: "the elapsed time between scans")
        barcode_format (required:false, description: "the barcode format")
        multiscanner(required: false, description: "if scan with multiscanner")
    }

    "/single_player/billpayments/barcode_reader/read/success"(platform: "/mobile", type: TrackType.Event) {
        is_manual_input (required:false, description: "if response was from scanner or inserted manually")
        utility_response (required:false, description: "the response, we need this to identify the next screen")
        from_clipboard (required:false, description: "if the barcode was loaded by copy paste")
    }

    "/single_player/billpayments/barcode_reader/read/error"(platform: "/mobile", type: TrackType.Event) {
        is_manual_input (required:false, description: "if response was from scanner or inserted manually")
        utility_response (required:false, description: "the response, we need this to identify the next screen")
        from_clipboard (required:false, description: "If the barcodee was loaded by copy paste")
    }

    //additional info required

    "/single_player/billpayments/additional_info/send"(platform: "/mobile", type: TrackType.Event) {
        additional_info (required:true, description: "the additional_info sended")
    }
    "/single_player/billpayments/additional_info/error"(platform: "/mobile", type: TrackType.Event) {
        utility_response (required:true, description: "the response, we need this to identify the error type")
    }

    "/single_player/billpayments/checkout_px"(platform: "/mobile", isAbstract: true) {}
    "/single_player/billpayments/checkout_px/start"(platform: "/mobile", type: TrackType.Event) {}

    /**
    * Singe player Antenna Screen Tracks
    */
    "/single_player/antenna"(platform: "/mobile", isAbstract: true) {
        session_id (required:false, type: PropertyType.String, description: "Session Id of flow")
    }

    "/single_player/antenna/manual_input"(platform: "/mobile", type: TrackType.View) {
        company (required: false, description: "Name of the company")
    }
    "/single_player/antenna/topup_helper" (platform: "/mobile", type:TrackType.View) {}
}
