package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

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
        total_amount(required: true, description: "Ticket value in local currency, e.g: 250.50", type: PropertyType.Numeric)
        currency_id(required: true, description: "currency according to https://api.mercadolibre.com/currencies", type: PropertyType.String)
        flow_context(required: false, description: "Information about current flow's status, e.g: 'init'", type: PropertyType.String)
        flow_type(required: false, description: "Current flow type, e.g: 'card_express'", type: PropertyType.String)
        is_free_trial(required: false, description: "If the subscription is activated with a free trial, e.g: 'true|false'", type: PropertyType.Boolean)
        subscription_partner(required: false, description: "If it´s a subscription set seller brand, e.g: 'HBO'", type: PropertyType.String)
        loyalty_level(required: false, description: "Payer's loyalty level, e.g: '1|2|3|4|5|6'", type: PropertyType.Numeric)
        discount_type(required: false, description: "Discount type applied, e.g: 'cosmetic'", type: PropertyType.String, values: ["transactional", "cosmetic"])
        discount_percent(required: false, description: "Discount percentage applied, e.g: 10", type: PropertyType.Numeric)
        checkout_open_mode(required: false, description: "Which product and view is being presented to the user, e.g: v2_checkout_redirect", type: PropertyType.String)
        items_quantity(required: false, description: "quantity of items configured in the preference, e.g: 2", type: PropertyType.Numeric)
        app_candidate(required: false, description: "Indicates if this flow could be caught by px", type: PropertyType.Boolean)
        client_id(required: false, description: "Current client id, only available for marketplace flow types", type: PropertyType.Numeric)
        errors(required: false, description: "relevant description of errors that ocurred on the flow, e.g: ['code: 13253, description: Collector user without key enabled for QR render']", type: PropertyType.ArrayList(PropertyType.String))
        visible_components(required: false, description: "Important Components visible on the screen ['qr', 'button', 'none']", type: PropertyType.Map)
    }

    // EVENTS
    "/checkout_off/init"(platform: "/", type: TrackType.Event) {}

    // Event sent when the user confirms it's intention to finish the checkout. Used for converison metrics.
    "/checkout_off/checkout_confirmed"(platform: "/", type: TrackType.Event) {}

    // VIEWS

    // Routing
    "/checkout_off/routing"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        productive(required: true, description: "True if productive flow", type: PropertyType.Boolean)
        collector_id(required: false, description: "Seller's id, e.g: 1010101001", type: PropertyType.Numeric)
        preference_id(required: false, description: "Preference being paid, e.g: '123456-ef5abdf8-6c2f-4f3e-a0b9-56a824203e61'", type: PropertyType.String)
        operation_type(required: false, description: "Operation type, e.g: 'regular_payment'", type: PropertyType.String, values: ["regular_payment", "account_fund", "money_transfer", "pos_payment", "payment_addition"])
        app_candidate(required: false, description: "Indicates if this flow could be caught by px", type: PropertyType.Boolean)
        client_id(required: false, description: "Current client id, only available for marketplace flow types", type: PropertyType.Numeric)
        flow_context(required: false, description: "Information about current flow's status, e.g: 'no_sniffing'", type: PropertyType.String)
    }

    // Login
    "/checkout_off/login"(platform: "/", type: TrackType.View) {}
    "/checkout_off/logout"(platform: "/", type: TrackType.View) {}

    // Groups payment method data collection views
    "/checkout_off/payment"(platform: "/", isAbstract: true) {}

    "/checkout_off/payment/select_type"(platform: "/", type: TrackType.View) {
        opensea_status(required: false, description: "The status of the Open Sea pre approved credit line", type: PropertyType.String, values: ["approved", "cancelled", "pending", "rejected"])
        opensea_message_shown(required: false, description: "Indicates whether or not a user sees a message about its credit line", type: PropertyType.Boolean)
    }

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

    // Paypal tracks
    "/checkout_off/payment/paypal_ftu"(platform: "/", type: TrackType.View) {}
    "/checkout_off/payment/paypal_login"(platform: "/", type: TrackType.View) {}
    "/checkout_off/payment/paypal_login/no_display"(platform: "/", type: TrackType.View) {}

    // OneClick track
    "/checkout_off/payment/one_click_redirect"(platform: "/", type: TrackType.View) {}
    "/checkout_off/payment/one_click_processing"(platform: "/", type: TrackType.View) {}
    "/checkout_off/payment/one_click_return"(platform: "/", type: TrackType.View) {}

    "/checkout_off/payment/review_express"(platform: "/", type: TrackType.View) {}

    // Split payments paths
    "/checkout_off/payment/card"(platform: "/", isAbstract: true) {}
    "/checkout_off/payment/card/split_first"(platform: "/", type: TrackType.View) {}
    "/checkout_off/payment/card/split_second"(platform: "/", type: TrackType.View) {}

    // Groups consumer credits data collection views
    "/checkout_off/payment/input_credits"(platform: "/", isAbstract: true) {}

    "/checkout_off/payment/input_credits/select_installment"(platform: "/", type: TrackType.View) {
        opensea_status(required: false, description: "The status of the Open Sea pre approved credit line", type: PropertyType.String, values: ["approved", "cancelled", "pending", "rejected"])
        opensea_message_shown(required: false, description: "Indicates whether or not a user sees a message about its credit line", type: PropertyType.Boolean)
    }

    "/checkout_off/payment/input_credits/select_installment/terms_conditions"(platform: "/", type: TrackType.View) {}

    // Tokenizer product final screen.
    "/checkout_off/payment/processing"(platform: "/", type: TrackType.View) {}

    // Groups billing info collection views.
    "/checkout_off/billing"(platform: "/", isAbstract: true) {}
    "/checkout_off/billing/input_info"(platform: "/", type: TrackType.View) {}

    "/checkout_off/review"(platform: "/", type: TrackType.View) {}
    "/checkout_off/review/shield_kyc"(platform: "/", type: TrackType.View) {}
    "/checkout_off/review/challenge_kyc"(platform: "/", type: TrackType.View) {}
    "/checkout_off/review/challenge_second_factor_auth"(platform: "/", type: TrackType.View) {}

    "/checkout_off/agencies"(platform: "/", type: TrackType.View) {}

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
        total_amount(required: false, description: "Ticket value in local currency, e.g: 250.50", type: PropertyType.Numeric)
        currency_id(required: false, description: "currency according to https://api.mercadolibre.com/currencies", type: PropertyType.String)
        payment_quantity(required: false, description: "Payments quantity selected, e.g: 1", type: PropertyType.Numeric)
        flow_context(required: false, description: "Information about current flow's status, e.g: 'init'", type: PropertyType.String)
        flow_type(required: false, description: "Current flow type, e.g: 'card_express'", type: PropertyType.String)
        is_free_trial(required: false, description: "If the subscription is activated with a free trial, e.g: 'true|false'", type: PropertyType.Boolean)
        subscription_partner(required: false, description: "If it´s a subscription set seller brand, e.g: 'HBO'", type: PropertyType.String)
        loyalty_level(required: false, description: "Payer's loyalty level, e.g: '1|2|3|4|5|6'", type: PropertyType.Numeric)
        discount_type(required: false, description: "Discount type applied, e.g: 'cosmetic'", type: PropertyType.String, values: ["transactional", "cosmetic"])
        discount_percent(required: false, description: "Discount percentage applied, e.g: 10", type: PropertyType.Numeric)
        checkout_open_mode(required: false, description: "Which product and view is being presented to the user, e.g: v2_checkout_redirect", type: PropertyType.String)
        items_quantity(required: false, description: "quantity of item in preference, e.g: 2", type: PropertyType.Numeric)
        app_candidate(required: false, description: "Indicates if this flow could be caught by px", type: PropertyType.Boolean)
        client_id(required: false, description: "Current client id, only available for marketplace flow types", type: PropertyType.Numeric)
        errors(required: false, description: "relevant description of errors that ocurred on the flow, e.g: ['code: 13253, description: Collector user without key enabled for QR render']", type: PropertyType.ArrayList(PropertyType.String))
        visible_components(required: false, description: "Important Components visible on the screen ['qr', 'button', 'none']", type: PropertyType.Map)
    }

    // For this path, none is required
    "/checkout_off/loading"(platform: "/", type: TrackType.View) {
        checkout_flow_id(required: false, description: "Unique ID of the current flow, e.g: 'b24bcffe-4b26-46c9-8646-61891dbd978b'", type: PropertyType.String)
        product_id(required: false, description: "Unique ID of the current flow, e.g: 'BC32A4JU643001OI3920'", type: PropertyType.String)
        productive(required: false, description: "True if productive flow", type: PropertyType.Boolean)
        payment_quantity(required: false, description: "Payments quantity selected, e.g: 1", type: PropertyType.Numeric)
        is_split(required: false, description: "True if the flow was split", type: PropertyType.Boolean)
        total_amount(required: false, description: "Ticket value in local currency, e.g: 250.50", type: PropertyType.Numeric)
        currency_id(required: false, description: "currency according to https://api.mercadolibre.com/currencies", type: PropertyType.String)
        items_quantity(required: false, description: "quantity of items configured in the preference, e.g: 2", type: PropertyType.Numeric)
    }

    //Final Views
    "/checkout_off/congrats"(platform: "/", type: TrackType.View) {
        payment_installments(required: false, description: "Installments selected")
        payment_status_detail(required: false, description: "Reason for the payment status")
        payment_status(required: false, description: "Reason for the payment status")
        payment_id(required: false, description: "Payment's identification in case that the payment was successful", type: PropertyType.String)
        total_amount_usd(required: true, serverSide:true, description: "payment amount in usd acording to currency conversion", type: PropertyType.Numeric)
        congrats_status(required: true, description: "Reason for the congrats status")
    }

    "/checkout_off/congrats/express_recover"(platform: "/", type: TrackType.View) {
    }

    "/checkout_off/congrats/offline_recover"(platform: "/", type: TrackType.View) {
    }

    "/checkout_off/congrats/no_display"(platform: "/", type: TrackType.View) {
    }

    "/checkout_off/congrats/call_for_auth"(platform: "/", isAbstract: true) {}

    "/checkout_off/congrats/call_for_auth/later"(platform: "/", type: TrackType.View) {}
    "/checkout_off/congrats/call_for_auth/how_to"(platform: "/", type: TrackType.View) {}
    "/checkout_off/congrats/call_for_auth/input_code"(platform: "/", type: TrackType.View) {}

    "/checkout_off/congrats/recovered"(platform: "/", type: TrackType.View) {
    }

    //MP personalFrontend
    "/tools"(platform: "/", isAbstract: true) {}

    "/tools/list"(platform: "/", type: TrackType.View) {}
    "/tools/list/button_create"(platform: "/") {}

    "/tools/create"(platform: "/", type: TrackType.View) {}
    "/tools/confirm_create_edit"(platform: "/") {}

    "/balance"(platform: "/web", isAbstract: true){}
    "/balance/reports"(platform: "/web", type: TrackType.View){}

    //Paypal Views
    "/checkout_off/payment/paypal_ftu"(platform: "/", type: TrackType.View) {}
    "/checkout_off/payment/paypal_login"(platform: "/", type: TrackType.View) {}

    //Open Sea Views
    "/checkout_off/payment/opensea_credits_ftu"(platform: "/", type: TrackType.View) {}
    "/checkout_off/payment/opensea_credits_redirect"(platform: "/", type: TrackType.View) {}

    //One Click Views
    "/checkout_off/payment/one_click_redirect"(platform: "/", type: TrackType.View) {}
    "/checkout_off/payment/one_click_processing"(platform: "/", type: TrackType.View) {}
    "/checkout_off/payment/one_click_return"(platform: "/", type: TrackType.View) {}

    // Shipping tracks
    "/checkout_off/shipping"(platform: "/", isAbstract: true) {}
    "/checkout_off/shipping/select_method"(platform: "/", type: TrackType.View) {}
    "/checkout_off/shipping/review"(platform: "/", type: TrackType.View) {}
    "/checkout_off/shipping/input_zip_code"(platform: "/", type: TrackType.View) {}
    "/checkout_off/shipping/input_address"(platform: "/", type: TrackType.View) {}
    "/checkout_off/shipping/select_user_type"(platform: "/", type: TrackType.View) {}
    "/checkout_off/shipping/select_option"(platform: "/", type: TrackType.View) {}
    "/checkout_off/shipping/select_address"(platform: "/", type: TrackType.View) {}
    "/checkout_off/shipping/zipcode_finder"(platform: "/", type: TrackType.View) {}

    //END -- MP personalFrontend
}
