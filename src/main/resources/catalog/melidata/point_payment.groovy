import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1046"

    // MP Mobile Point
    "/point_payment"(platform: "/mobile", type: TrackType.View) {
        flow_id (required: false, type: PropertyType.String, description: "Flow id.")
        from (required: false, type: PropertyType.String, description: "Where the flow start")
        method (required: false, type: PropertyType.String, description: "Card reading method swipe/dip/tap", values: ["swipe", "dip", "tap", "chip"])
        currency (required: false, type: PropertyType.String, description: "Transaction currency")
        amount (required: false, type: PropertyType.String, description: "Transaction amount")
        installments (required: false, type: PropertyType.String, description: "Installments amount")
        payment_status (required: false, type: PropertyType.String, description: "Payment result status")
        payment_detail (required: false, type: PropertyType.String, description: "Payment result detail")
        reason (required: false, type: PropertyType.String, description: "Payment reason")
        poi (required: false, type: PropertyType.String, description: "Device serial number")
        poi_type (required: false, type: PropertyType.String, description: "Type of device")
        payment_method_id (required: false, type: PropertyType.String, description: "Payment Method used")
        operator_id (required: false, type: PropertyType.String, description: "Operator identification")
        flow (required: false, type: PropertyType.String, description: "Flow")
        error_msg (required:false, type: PropertyType.String, description: "Error shown to seller")
    }


    //TODO: The flow_origin field must be changed to mandatory, when all the productive versions send this information
    "/point_payment/main"(platform: "/mobile", type: TrackType.View) {
        flow_origin (required: false, type: PropertyType.String, values: ["point", "qr", "chooser","share_social"])
    }
    "/point_payment/card"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/installments"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/card_type"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/signature"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/security_code"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/identification_number"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/result"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/result/sms"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/error"(platform: "/mobile", type: TrackType.View) {
        from (required:false, type: PropertyType.String, description: "Where the flow start")
        error_msg (required:false, type: PropertyType.String, description: "Error shown to seller")
    }
    "/point_payment/new_payment_entry_point"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/send_bill_congrats"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/send_sms"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/error_i_have_an_issue"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/error/generic"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/error/rejected"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/request_bluetooth"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/ftu_preorder_pax"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/ftu_qr"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/pairing"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/pairing_chooser"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/selector"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/send_bill"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/point_ftu_newland"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/idempotency"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/point"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/qr_ftu"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/bank_selection"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/select_connected_device"(platform: "/mobile", type: TrackType.View) {
        devices (required:false, type: PropertyType.String, description: "paired devices")
    }
    "/point_payment/link_share"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/link"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/qr"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/device_selection"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/qr_show_code"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/request_location"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/user_identification"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/ftu_preorder_bbpos"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/ftu_preorder_newland"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/pairing_pax_turn_on"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/pairing_bbposbt_device_selection"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/pairing_bbposbt_turn_on"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/cart"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/permission_screen"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/deals"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/pairing_newland_device_selection"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/pairing_newland_turn_on"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/error/ownership"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/error/low_battery"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/web_view"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/pairing"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/pairing/problem"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/pairing/problem/help"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/bbpos_connectivity_help_web_view"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/qr_congrats"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/qr_congrats_nofee"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/bank_detail"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/pairing_ftu"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/new_payment"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/new_payment/deals"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/new_payment/deals/finantial_costs"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/buyer_email"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/discount"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/onboarding_how_to_charge"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/onboarding_brandname"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/onboarding_chooser"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/push_mcc"(platform: "/mobile", type: TrackType.View) {}

    "/point_payment/link_share/button"(platform: "/mobile", type: TrackType.Event) {
        flow_id (required: true, type: PropertyType.String, description: "Flow id.")
        action (required: true, values: ["share_link", "copy_link", "copy_to_clipboard"], description: "Type of share button clicked")
        label (required: false, values: ["whatsapp", "facebook", "twitter", "email", "instagram", "other"], description: "Type of share_link event")
        pref_id (required: false, type: PropertyType.String, description: "Preference id")
    }

    "/point_payment/flow_tracker"(platform: "/mobile", type: TrackType.Event, isAbstract: true) {
        flow_id (required: true, type: PropertyType.String, description: "Flow id.")
        user_id (required: false, type: PropertyType.String, description: "User id.")
        level (required: true, type: PropertyType.String, description: "Log level (error|info)", values: ["error", "info"])
        message(required: false, type:  PropertyType.String, description: "message to log")
        data (required: false, type:  PropertyType.String, description: "data to log")
    }

    "/point_payment/flow_tracker/pairing"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/configuration"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/payment_methods_get"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/payment_methods_response"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/card_token_results"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/start"(platform: "/mobile", type: TrackType.Event) {
        description (required: false, type: PropertyType.String, description: "payment description.")
        amount (required: false, type: PropertyType.String, description: "payment amount.")
        discount (required: false, type: PropertyType.String, description: "payment discount")
    }
    "/point_payment/flow_tracker/flow_error"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/card_tokens_request"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/card_tokens_result"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/payment_methods_request"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/payment_methods_response"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/end"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_next_step_after_payment"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_payment_card_tokens_request_put"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_payment_card_tokens_response_put"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_payment_request"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_payment_response"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_pos_sending_online_process"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_notification_request"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_notification_response"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_notification_sms_request"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_notification_sms_response"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/flow_pos_error_message"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/select_qr"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/select_point"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/select_link"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/waiting_card"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/select_connected_device"(platform: "/mobile", type: TrackType.Event) {
        devices (required:false, type: PropertyType.String, description: "paired devices")
    }
    "/point_payment/flow_tracker/cancel_qr_charge"(platform: "/mobile", type: TrackType.Event) {}
    "/point_payment/flow_tracker/auto_reverse_off"(platform: "/mobile", type: TrackType.Event) {
        trx_id (required: true, type: PropertyType.String, description: "trx1234567")
    }
    "/point_payment/write_concept"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/customer_care"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/start_refund"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/customer_care_success"(platform: "/mobile", type: TrackType.View) {}

    "/point_payment_test"(platform: "/mobile", type: TrackType.View, isAbstract: true) {}
    "/point_payment_test/test_payment"(platform: "/mobile", type: TrackType.View) {}


    "/point_payment/cash"(platform: "/mobile", type: TrackType.View, isAbstract: true) {}
    "/point_payment/cash/ftu"(platform: "/mobile", type: TrackType.View) {}
    "/point_payment/cash/congrats"(platform: "/mobile", type: TrackType.View) {}

    "/point_payment/dashboard"(platform: "/mobile", type: TrackType.View) {}
}