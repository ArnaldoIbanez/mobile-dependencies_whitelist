import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {
        "/checkout_off"(platform: "/", isAbstract: true){
        checkout_flow_id(required: true, description: "Unique ID of the current flow")
        product_id(required: true, description: "Unique ID of the current flow")
        site(required: true, description: "Site of the seller")
        productive(required: true, description: "True if productive flow")
        collector_nickname(required: false, description: "Seller's nickname")
        preference_id(required: false, description: "Preference being paid")
        operation_type(required: false, description: "Operation type, e.g: regular_payment")
        is_express(required: false, description: "True if the flow was express")
        payer_id(required: false, description: "Payer id is sent if it is logged")
        payment_method_id(required: false, description: "Current selected payment method")
        payment_type_id(required: false, description: "Current selected payment type")
    }

    // EVENTS
    "/checkout_off/init"(platform: "/", type: TrackType.Event) {}

    // Event sent when the user confirms it's intention to finish the checkout. Used for converison metrics.
    "/checkout_off/checkout_confirmed"(platform: "/", type: TrackType.Event) {}

    // VIEWS
    "/checkout_off/login"(platform: "/", type: TrackType.View) {}
    "/checkout_off/logout"(platform: "/", type: TrackType.View) {}

    // Groups payment method data collection views
    "/checkout_off/payment"(platform: "/", isAbstract: true) {}

    "/checkout_off/payment/select_type"(platform: "/", type: TrackType.View) {}
    "/checkout_off/payment/select_stores"(platform: "/", type: TrackType.View) {}
    "/checkout_off/payment/select_transfer"(platform: "/", type: TrackType.View) {}

    // Groups card data collection views
    "/checkout_off/payment/input_card"(platform: "/", isAbstract: true) {}
    "/checkout_off/payment/input_card/main"(platform: "/", type: TrackType.View) {}
    "/checkout_off/payment/input_card/input_document"(platform: "/", type: TrackType.View) {}
    "/checkout_off/payment/input_card/input_card_issuer"(platform: "/", type: TrackType.View) {}
    "/checkout_off/payment/input_card/input_security_code"(platform: "/", type: TrackType.View) {}
    "/checkout_off/payment/input_card/select_installment"(platform: "/", type: TrackType.View) {}

    "/checkout_off/payment/card_express"(platform: "/", type: TrackType.View) {}
    
    // Tokenizer product final screen.
    "/checkout_off/payment/processing"(platform: "/", type: TrackType.View) {}

    // Groups billing info collection views.
    "/checkout_off/billing"(platform: "/", isAbstract: true) {}

    "/checkout_off/billing/input_info"(platform: "/", type: TrackType.View) {}

    "/checkout_off/review"(platform: "/", type: TrackType.View) {}

    "/checkout_off/agencies"(platform: "/", type: TrackType.View) {}

    "/checkout_off/error"(platform: "/", type: TrackType.View) {}

    //Final Views
    "/checkout_off/congrats"(platform: "/", type: TrackType.View) {
        payment_installments(required: false, description: "Installments selected")
        payment_status_detail(required: true, description: "Reason for the payment status")
        payment_status(required: true, description: "Reason for the payment status")
    }

    "/checkout_off/congrats/call_for_auth"(platform: "/", isAbstract: true) {}

    "/checkout_off/congrats/call_for_auth/later"(platform: "/", type: TrackType.View) {}
    "/checkout_off/congrats/call_for_auth/how_to"(platform: "/", type: TrackType.View) {}
    "/checkout_off/congrats/call_for_auth/input_code"(platform: "/", type: TrackType.View) {}
}
