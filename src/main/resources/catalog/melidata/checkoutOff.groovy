package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1066"

    "/checkout_off"(platform: "/", isAbstract: true) {
        checkout_flow_id(required: true, description: "Unique ID of the current flow, e.g: 'b24bcffe-4b26-46c9-8646-61891dbd978b'", type: PropertyType.String)
        product_id(required: true, description: "Unique ID of the current flow, e.g: 'BC32A4JU643001OI3920'", type: PropertyType.String)
        productive(required: true, description: "True if productive flow", type: PropertyType.Boolean)
        collector_id(required: false, description: "Seller's id, e.g: 1010101001", type: PropertyType.Numeric)
        preference_id(required: false, description: "Preference being paid, e.g: '123456-ef5abdf8-6c2f-4f3e-a0b9-56a824203e61'", type: PropertyType.String)
        operation_type(required: false, description: "Operation type, e.g: 'regular_payment'", type: PropertyType.String, values: ["regular_payment", "account_fund", "money_transfer", "pos_payment", "payment_addition"])
        is_express(required: false, description: "True if the flow was express", type: PropertyType.Boolean)
        payer_id(required: false, description: "Payer id is sent if it is logged, e.g: '654321'", type: PropertyType.String)
        payment_method_id(required: false, description: "Current selected payment method, e.g: 'visa'", type: PropertyType.String)
        payment_type_id(required: false, description: "Current selected payment type, e.g: 'credit_card'", type: PropertyType.String)
        is_split(required: true, description: "True if the flow was split", type: PropertyType.Boolean)
        payment_quantity(required: true, description: "Payments quantity selected, e.g: 1", type: PropertyType.Numeric)
        available_methods(required: false, description: "Available payment methods types, e.g: ['credit_card', 'account_money']", type: PropertyType.ArrayList(PropertyType.String))
        payment_amount_local(required: true, description: "Ticket value in local currency, e.g: 250.50", type: PropertyType.Numeric)
        flow_context(required: false, description: "Information about current flow's status, e.g: 'init'", type: PropertyType.String)
        flow_type(required: false, description: "Current flow type, e.g: 'card_express'", type: PropertyType.String)
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

    "/checkout_off/express_recover"(platform: "/", type: TrackType.View) {
        original_payment_id(required: true, description: "Identification of payment that failed and resulted in a recover process", type: PropertyType.String)
    }

    // For this path, none is required
    "/checkout_off/error"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        checkout_flow_id(required: false, description: "Unique ID of the current flow, e.g: 'b24bcffe-4b26-46c9-8646-61891dbd978b'", type: PropertyType.String)
        product_id(required: false, description: "Unique ID of the current flow, e.g: 'BC32A4JU643001OI3920'", type: PropertyType.String)
        productive(required: false, description: "True if productive flow", type: PropertyType.Boolean)
        is_split(required: false, description: "True if the flow was split", type: PropertyType.Boolean)
        is_express(required: false, description: "True if the flow was express", type: PropertyType.Boolean)
        operation_type(required: false, description: "Operation type, e.g: 'regular_payment'", type: PropertyType.String, values: ["regular_payment", "account_fund", "money_transfer", "pos_payment", "payment_addition"])
        preference_id(required: false, description: "Preference being paid, e.g: '123456-ef5abdf8-6c2f-4f3e-a0b9-56a824203e61'", type: PropertyType.String)
        payer_id(required: false, description: "Payer id is sent if it is logged, e.g: '654321'", type: PropertyType.String)
        collector_id(required: false, description: "Seller's id, e.g: 1010101001", type: PropertyType.Numeric)
        available_methods(required: false, description: "Available payment methods types, e.g: ['credit_card', 'account_money']", type: PropertyType.ArrayList(PropertyType.String))
        payment_method_id(required: false, description: "Current selected payment method, e.g: 'visa'", type: PropertyType.String)
        payment_type_id(required: false, description: "Current selected payment type, e.g: 'credit_card'", type: PropertyType.String)
        payment_amount_local(required: false, description: "Ticket value in local currency, e.g: 250.50", type: PropertyType.Numeric)
        payment_quantity(required: false, description: "Payments quantity selected, e.g: 1", type: PropertyType.Numeric)
        flow_context(required: false, description: "Information about current flow's status, e.g: 'init'", type: PropertyType.String)
        flow_type(required: false, description: "Current flow type, e.g: 'card_express'", type: PropertyType.String)
    }

    //Final Views
    "/checkout_off/congrats"(platform: "/", type: TrackType.View) {
        payment_installments(required: false, description: "Installments selected")
        payment_status_detail(required: true, description: "Reason for the payment status")
        payment_status(required: true, description: "Reason for the payment status")
        payment_id(required: false, description: "Payment's identification in case that the payment was successful", type: PropertyType.String)
    }

    "/checkout_off/congrats/call_for_auth"(platform: "/", isAbstract: true) {}

    "/checkout_off/congrats/call_for_auth/later"(platform: "/", type: TrackType.View) {}
    "/checkout_off/congrats/call_for_auth/how_to"(platform: "/", type: TrackType.View) {}
    "/checkout_off/congrats/call_for_auth/input_code"(platform: "/", type: TrackType.View) {}

    //MP personalFrontend
    "/tools"(platform: "/web", isAbstract: true){}

    "/tools/list"(platform: "/web", type: TrackType.View){}
    "/tools/list/button_create"(platform: "/web"){}

    "/tools/create"(platform: "/web", type: TrackType.View){}
    "/tools/confirm_create_edit"(platform: "/web"){}

    "/balance"(platform: "/web", isAbstract: true){}
    "/balance/reports"(platform: "/web", type: TrackType.View){}
    //END -- MP personalFrontend
}
