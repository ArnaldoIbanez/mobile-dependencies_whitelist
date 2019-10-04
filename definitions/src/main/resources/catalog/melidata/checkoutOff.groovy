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
        collector_id(required: false, description: "Seller's id")
        preference_id(required: false, description: "Preference being paid")
        operation_type(required: false, description: "Operation type, e.g: regular_payment")
        is_express(required: false, description: "True if the flow was express")
        payer_id(required: false, description: "Payer id is sent if it is logged")
        payment_method_id(required: false, description: "Current selected payment method")
        payment_type_id(required: false, description: "Current selected payment type")
        is_split(required: true, description: "True if the flow was split", type: PropertyType.Boolean)
        payment_quantity(required: true, description: "Payments quantity selected", type: PropertyType.Numeric)
        available_methods(required: false, description: "Available payment methods types", type: PropertyType.ArrayList(PropertyType.String))
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

    // Split payments paths
    "/checkout_off/payment/card"(platform: "/", isAbstract: true) {}
    "/checkout_off/payment/card/split_first"(platform: "/", type: TrackType.View) {}
    "/checkout_off/payment/card/split_second"(platform: "/", type: TrackType.View) {}

    // Groups consumer credits data collection views
    "/checkout_off/payment/input_credits"(platform: "/", isAbstract: true) {}
    "/checkout_off/payment/input_credits/select_installment"(platform: "/", type: TrackType.View) {}
    "/checkout_off/payment/input_credits/select_installment/terms_conditions"(platform: "/", type: TrackType.View) {}    

    // Tokenizer product final screen.
    "/checkout_off/payment/processing"(platform: "/", type: TrackType.View) {}

    // Groups billing info collection views.
    "/checkout_off/billing"(platform: "/", isAbstract: true) {}

    "/checkout_off/billing/input_info"(platform: "/", type: TrackType.View) {}

    "/checkout_off/review"(platform: "/", type: TrackType.View) {}

    "/checkout_off/agencies"(platform: "/", type: TrackType.View) {}

    // For this path, none is required
    "/checkout_off/error"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        checkout_flow_id(required: false, description: "Unique ID of the current flow")
        product_id(required: false, description: "Unique ID of the current flow")
        productive(required: false, description: "True if productive flow")
        site(required: false, description: "Site of the seller")
        is_split(required: false, description: "True if the flow was split", type: PropertyType.Boolean)
        is_express(required: false, description: "True if the flow was express")
        operation_type(required: false, description: "Operation type, e.g: regular_payment")
        preference_id(required: false, description: "Preference being paid")
        payer_id(required: false, description: "Payer id is sent if it is logged")
        collector_nickname(required: false, description: "Seller's nickname")
        available_methods(required: false, description: "Available payment methods types", type: PropertyType.ArrayList(PropertyType.String))
        payment_method_id(required: false, description: "Current selected payment method")
        payment_amount_local(required: false, description: "Current selected payment amount", type: PropertyType.Numeric)
        payment_quantity(required: false, description: "Payments quantity selected", type: PropertyType.Numeric)
    }

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
