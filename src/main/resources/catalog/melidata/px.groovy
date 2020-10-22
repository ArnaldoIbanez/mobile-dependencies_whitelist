package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType


tracks {

    initiative = '1142'

    propertyDefinitions {
        flow_detail(required: false, description: "External info")
        flow(required: true, type: PropertyType.String, description: "External flow name" )
        session_id(required: false, type: PropertyType.String, description: "Internal session id")
        session_time(required: false, type: PropertyType.Numeric, description: "Session time")
        checkout_type(required: false, type: PropertyType.String, description: "Checkout type")
        collector_id(required: false, description: "Collector external id")
        security_enabled(required: false, type: PropertyType.Boolean, description: "If the user has biometric or passcode validation to make a payment")
        experiments(required: false, type: PropertyType.String, description: "Active experiments")

        payment_method_id(required: false, type: PropertyType.String, description: "Payment method id")
        payment_method_type(required: false, type: PropertyType.String, description: "Payment method type")
        card_id(required: false, type: PropertyType.String, description: "Card id")
        issuer_id(required: false, type: PropertyType.String, description: "Issuer id")
        bin(required: false, type: PropertyType.String, description: "Bin")
        reason(required: false, type: PropertyType.String, description: "Why this screen is shown", values: ["esc_cap", "saved_card", "call_for_auth", "disabled_card", "invalid_esc", "invalid_fingerprint", "unexpected_tokenization_error", "esc_disabled", "no_reason"])
    }

    propertyGroups {
        externalData(flow, flow_detail, collector_id, session_id, session_time, checkout_type, security_enabled, experiments)
        securityCodeViewData(payment_method_id, card_id, reason)
        securityCodeData(payment_method_id, payment_method_type, card_id, issuer_id, bin, reason)
    }

    // Views:
    "/px_checkout"(platform: "/mobile", isAbstract: true){
        externalData
    }

    // Payment Selection views
    "/px_checkout/payments"(platform: "/mobile", isAbstract: true){}
    "/px_checkout/payments/select_method"(platform: "/mobile", type: TrackType.View) {
        available_methods(required: true, type: PropertyType.ArrayList , description: "Available payment methods to choose")
        items(required: true, type: PropertyType.ArrayList , description: "Array of items to pay")
        preference_amount(required: false, type: PropertyType.Numeric , description: "Total amount") // TODO Should be deleted when total amount fully implemented
        total_amount(required: true, type: PropertyType.Numeric, description: "Total amount of the payment without any discounts in the indicated currency") // should replace preferend_amount in the near feature
        discount(required: false, description: "Discount if available")
        available_methods_quantity(required: false, type: PropertyType.Numeric , description: "Available methods quantity")
        disabled_methods_quantity(required: false, type: PropertyType.Numeric , description: "Disabled methods quantity")
    }
    "/px_checkout/payments/select_method/ticket"(platform: "/mobile", type: TrackType.View) {

    }
    "/px_checkout/payments/select_method/cards"(platform: "/mobile", type: TrackType.View) {

    }

    // Discount view
    "/px_checkout/payments/applied_discount"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.View) {
        discount(required: false, description: "Discount if available")
        externalData
    }

    // Security code view
    "/px_checkout/payments/select_method/credit_card"(platform: "/mobile", isAbstract: true){}
    "/px_checkout/payments/select_method/debit_card"(platform: "/mobile", isAbstract: true){}
    "/px_checkout/payments/select_method/prepaid_card"(platform: "/mobile", isAbstract: true){}

    "/px_checkout/payments/select_method/credit_card/cvv"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.View) {
        securityCodeViewData
        externalData
    }
    "/px_checkout/payments/select_method/debit_card/cvv"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.View) {
        securityCodeViewData
        externalData
    }
    "/px_checkout/payments/select_method/prepaid_card/cvv"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.View) {
        securityCodeViewData
        externalData
    }

    "/px_checkout/security_code"(platform: "/mobile", type: TrackType.View) {
        securityCodeData
    }
    "/px_checkout/security_code/abort"(platform: "/mobile", type: TrackType.Event) {
        securityCodeData
    }
    "/px_checkout/security_code/confirm"(platform: "/mobile", type: TrackType.Event) {
        securityCodeData
    }

    // Bank deals views
    "/px_checkout/add_payment_method/promotions"(platform: "/mobile", type: TrackType.View) {}
    "/px_checkout/add_payment_method/promotions/terms_and_conditions"(platform: "/mobile", type: TrackType.View) {}

    // Card form views
    "/px_checkout/add_payment_method"(platform: "/mobile", isAbstract: true){}
    "/px_checkout/add_payment_method/credit_card"(platform: "/mobile", isAbstract: true){
        payment_method_id(required: true, type: PropertyType.String, description: "Payment method id")
    }
    "/px_checkout/add_payment_method/debit_card"(platform: "/mobile", isAbstract: true){
        payment_method_id(required: true, type: PropertyType.String, description: "Payment method id")
    }
    "/px_checkout/add_payment_method/prepaid_card"(platform: "/mobile", isAbstract: true){
        payment_method_id(required: true, type: PropertyType.String, description: "Payment method id")
    }

    "/px_checkout/add_payment_method/number"(platform: "/mobile", type: TrackType.View) {}

    "/px_checkout/add_payment_method/number/error_more_info"(platform: "/mobile", type: TrackType.View) {}

    "/px_checkout/add_payment_method/credit_card/name"(platform: "/mobile", type: TrackType.View) {}
    "/px_checkout/add_payment_method/debit_card/name"(platform: "/mobile", type: TrackType.View) {}
    "/px_checkout/add_payment_method/prepaid_card/name"(platform: "/mobile", type: TrackType.View) {}

    "/px_checkout/add_payment_method/credit_card/expiration_date"(platform: "/mobile", type: TrackType.View) {}
    "/px_checkout/add_payment_method/debit_card/expiration_date"(platform: "/mobile", type: TrackType.View) {}
    "/px_checkout/add_payment_method/prepaid_card/expiration_date"(platform: "/mobile", type: TrackType.View) {}

    "/px_checkout/add_payment_method/credit_card/cvv"(platform: "/mobile", type: TrackType.View) {}
    "/px_checkout/add_payment_method/debit_card/cvv"(platform: "/mobile", type: TrackType.View) {}
    "/px_checkout/add_payment_method/prepaid_card/cvv"(platform: "/mobile", type: TrackType.View) {}

    "/px_checkout/add_payment_method/credit_card/document"(platform: "/mobile", type: TrackType.View) {}
    "/px_checkout/add_payment_method/debit_card/document"(platform: "/mobile", type: TrackType.View) {}
    "/px_checkout/add_payment_method/prepaid_card/document"(platform: "/mobile", type: TrackType.View) {}

    // Issuer view
    "/px_checkout/payments/card_issuer"(platform: "/mobile", type: TrackType.View) {
        payment_method_id(required: true, type: PropertyType.String, description: "Payment method id")
        payment_method_type(required: true, type: PropertyType.String, description: "Payment method type id")
        available_banks(required: true, type: PropertyType.ArrayList , description: "Array of available issuers")
    }

    // Installments view
    "/px_checkout/payments/installments"(platform: "/mobile", type: TrackType.View) {
        payment_method_id(required: true, type: PropertyType.String, description: "Payment method id")
        payment_method_type(required: true, type: PropertyType.String, description: "Payment method type id")
        issuer_id(required: true, type: PropertyType.Numeric , description: "Issuer id")
        card_id(required: false, type: PropertyType.String , description: "Card id")
        available_installments(required: true, type: PropertyType.ArrayList , description: "Array of available installments")
        discount(required: false, description: "Discount if available")
    }

    // Boleto views

    "/px_checkout/payments/select_method/ticket/cpf"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.View) {
        payment_method_id(required: false, type: PropertyType.String, description: "Payment method id")
        externalData
    }
    "/px_checkout/payments/select_method/ticket/name"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.View) {
        payment_method_id(required: false, type: PropertyType.String, description: "Payment method id")
        externalData
    }
    "/px_checkout/payments/select_method/ticket/lastname"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.View) {
        payment_method_id(required: false, type: PropertyType.String, description: "Payment method id")
        externalData
    }

    // Review and confirm view
    "/px_checkout/review"(platform: "/mobile", isAbstract: true){}
    "/px_checkout/review/traditional"(platform: "/mobile", type: TrackType.View) {
        payment_method_id(required: true, type: PropertyType.String, description: "Payment method id")
        payment_method_type(required: true, type: PropertyType.String, description: "Payment method type id")
        preference_amount(required: false, type: PropertyType.Numeric , description: "Total amount") // TODO Should be deleted when total amount fully implemented
        total_amount(required: true, type: PropertyType.Numeric, description: "Total amount of the payment without any discounts in the indicated currency") // should replace preferend_amount in the near feature
        extra_info(required: false, description: "Extra payment method info")
        discount(required: false, description: "Discount if available")
        items(required: true, type: PropertyType.ArrayList , description: "Array of items to pay")
    }

    // Terms and conditions view
    "/px_checkout/payments/terms_and_conditions"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.View) {
        url(required: true, type: PropertyType.String, description: "Web view url")
        externalData
    }

    // One tap view
    "/px_checkout/review/one_tap"(platform: "/mobile", type: TrackType.View) {
        preference_amount(required: false, type: PropertyType.Numeric, description: "Total amount") // TODO Should be deleted when total amount fully implemented
        total_amount(required: true, type: PropertyType.Numeric, description: "Total amount of the payment without any discounts in the indicated currency") // should replace preference_amount in the near feature

        available_methods(required: true, type: PropertyType.ArrayList , description: "Array of available payment methods to pay")
        available_methods_quantity(required: false, type: PropertyType.Numeric , description: "Available methods quantity")
        disabled_methods_quantity(required: false, type: PropertyType.Numeric , description: "Disabled methods quantity")
        discount(required: false, description: "Discount if available")
        items(required: true, type: PropertyType.ArrayList , description: "Array of items to pay")

        / * Estructura del item:

        items = [
                {
                    item = {
                        id = "1234"
                        description = "Item de testeo"
                        price = 200
                    }
                    quantity = 3
                    currency_id = "ARS"
                }
        ] */
    }

    // One tap view
    "/px_checkout/review/one_tap/offline_methods"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.View) {
        available_methods(required: true, type: PropertyType.ArrayList , description: "Array of available off payment methods to pay")
        externalData
    }

    // One tap installments view
    "/px_checkout/review/one_tap/installments"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.View) {
        payment_method_id(required: true, type: PropertyType.String, description: "Payment method id")
        payment_method_type(required: true, type: PropertyType.String, description: "Payment method type id")
        issuer_id(required: true, type: PropertyType.Numeric , description: "Issuer id")
        card_id(required: true, type: PropertyType.String , description: "Card id")
        available_installments(required: true, type: PropertyType.ArrayList , description: "Array of available installments")
        externalData
    }

    "/px_checkout/review/one_tap/disabled_payment_method_detail"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.View) {
        externalData
    }

    // Payment result views
    "/px_checkout/result"(platform: "/mobile", isAbstract: true){
        style(required: true, type: PropertyType.String, description: "Business result or generic", values: ["generic" , "custom"])
        payment_method_id(required: true, type: PropertyType.String, description: "Payment method id")
        payment_method_type(required: true, type: PropertyType.String, description: "Payment method type id")
        extra_info(required: false, description: "Extra payment method info")
        payment_id(required: true, type: PropertyType.Numeric, description: "Payment id")
        payment_status(required: true, type: PropertyType.String, description: "Payment status")
        payment_status_detail(required: true, type: PropertyType.String, description: "Payment status")
        preference_amount(required: false, type: PropertyType.Numeric, description: "Total amount") // TODO Should be deleted when total amount fully implemented
        total_amount(required: true, type: PropertyType.Numeric, description: "Total amount of the payment without any discounts in the indicated currency") // should replace preferend_amount in the near feature
        total_amount_usd(required: true, serverSide: true, type: PropertyType.Numeric, description: "Total amount of the payment without any discounts in USD") 
        currency_id(required: true, type: PropertyType.String, description: "Currency id")
        discount_coupon_amount(required: false, type: PropertyType.Numeric, description: "Discount coupon amount")
        has_split_payment(required: true, type: PropertyType.Boolean, description: "Pay with split payment")
        has_bottom_view(required: true, type: PropertyType.Boolean, description: "Result view has bottom view component")
        has_top_view(required: true, type: PropertyType.Boolean, description: "Result view has top view component")
        has_important_view(required: true, type: PropertyType.Boolean, description: "Result view has important view component")
        has_money_split_view(required: true, type: PropertyType.Boolean, description: "Result view has money split view component")
        score_level(required: false, type: PropertyType.Numeric, description: "Payer score level")
        discounts_count(required: false, type: PropertyType.Numeric, description: "Discounts items displayed")
        campaigns_ids(required: false, type: PropertyType.String, description: "Campaigns ids of discounts displayed")
        campaign_id(required: false, type: PropertyType.String, description: "Campaign id of discount applied to payment")
    }
    "/px_checkout/result/success"(platform: "/mobile", type: TrackType.View) {}
    "/px_checkout/result/further_action_needed"(platform: "/mobile", type: TrackType.View) {}
    "/px_checkout/result/error"(platform: "/mobile", type: TrackType.View) {
        remedies(required: true, type: PropertyType.ArrayList, description: "List of remedies")
    }
    "/px_checkout/result/unknown"(platform: "/mobile", type: TrackType.View) {}

    // Card association result views
    "/px_checkout/card_association_result"(platform: "/mobile", isAbstract: true){}
    "/px_checkout/card_association_result/success"(platform: "/mobile", type: TrackType.View) {}
    "/px_checkout/card_association_result/error"(platform: "/mobile", type: TrackType.View) {}

    // Error Screen
    "/px_checkout/generic_error"(platform: "/mobile", type: TrackType.View){
        error_message(required: false, type: PropertyType.String, description: "Screen error message")
        api_error(required: false, description: "Api error description")
    }

    // Events:

    // Init event:
    "/px_checkout/init"(platform: "/mobile", type: TrackType.Event) {
        checkout_preference_id(required: false, type: PropertyType.String, description: "Preference id")
        checkout_preference(required: false, description: "Payment preference")
        esc_enabled(required: true, type: PropertyType.Boolean, description: "Has esc feauture")
        express_enabled(required: true, type: PropertyType.Boolean, description: "Has one tap feauture")
        split_enabled(required: true, type: PropertyType.Boolean, description: "Has split enabled")
    }

    // One Tap Off Methods event
    "/px_checkout/review/one_tap/offline_methods/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/review/one_tap/offline_methods/start_kyc_flow"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    // Payment Selection event
    "/px_checkout/payments/select_method/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/payments/select_method/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/payments/select_method/ticket/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/payments/select_method/ticket/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/payments/select_method/cards/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/payments/select_method/cards/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    // Security code view:
    "/px_checkout/payments/select_method/credit_card/cvv/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/payments/select_method/credit_card/cvv/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/payments/select_method/debit_card/cvv/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/payments/select_method/debit_card/cvv/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/payments/select_method/prepaid_card/cvv/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/payments/select_method/prepaid_card/cvv/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    // Card Form events:

    // Number:
    "/px_checkout/add_payment_method/number/recognized_card"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        payment_method_id(required: true, type: PropertyType.String, description: "Payment method id")
        externalData
    }

    "/px_checkout/add_payment_method/number/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/add_payment_method/number/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    // Name:
    "/px_checkout/add_payment_method/credit_card/name/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/add_payment_method/credit_card/name/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/add_payment_method/debit_card/name/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/add_payment_method/debit_card/name/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/add_payment_method/prepaid_card/name/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/add_payment_method/prepaid_card/name/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    // Date:
    "/px_checkout/add_payment_method/credit_card/expiration_date/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/add_payment_method/credit_card/expiration_date/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/add_payment_method/debit_card/expiration_date/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/add_payment_method/debit_card/expiration_date/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/add_payment_method/prepaid_card/expiration_date/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/add_payment_method/prepaid_card/expiration_date/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    // CVV:
    "/px_checkout/add_payment_method/credit_card/cvv/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/add_payment_method/credit_card/cvv/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/add_payment_method/debit_card/cvv/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/add_payment_method/debit_card/cvv/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/add_payment_method/prepaid_card/cvv/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/add_payment_method/prepaid_card/cvv/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    // Documento:
    "/px_checkout/add_payment_method/credit_card/document/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/add_payment_method/credit_card/document/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/add_payment_method/debit_card/document/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/add_payment_method/debit_card/document/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/add_payment_method/prepaid_card/document/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/add_payment_method/prepaid_card/document/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    // Terms and Conditions:
    "/px_checkout/add_payment_method/promotions/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/add_payment_method/promotions/terms_and_conditions/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/payments/terms_and_conditions/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    // Issuers:
    "/px_checkout/payments/card_issuer/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    // Installments:
    "/px_checkout/payments/installments/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    // Boleto:

    "/px_checkout/payments/select_method/ticket/cpf/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/payments/select_method/ticket/cpf/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/payments/select_method/ticket/name/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/payments/select_method/ticket/name/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/payments/select_method/ticket/lastname/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/payments/select_method/ticket/lastname/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    // Revisa y confirma:
    "/px_checkout/review/traditional/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/review/traditional/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/review/traditional/change_payment_method"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    // One Tap:
    "/px_checkout/review/one_tap/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/review/one_tap/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/review/one_tap/swipe"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    // Review:
    "/px_checkout/review/confirm"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        payment_method_id(required: true, type: PropertyType.String, description: "Payment method id")
        payment_method_type(required: true, type: PropertyType.String, description: "Payment method type id")
        payment_method_selected_index(required: false, type: PropertyType.Numeric , description: "Payment method selected index")
        review_type(required: true, type: PropertyType.String, description: "Review screen type", values: ["one_tap" , "traditional"])
        extra_info(required: false, description: "Extra payment method info")
        externalData
    }

    // Congrats:
    // Approved payment
    "/px_checkout/result/success/continue"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/result/success/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/result/success/tap_score"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/result/success/tap_discount_item"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        index(required: true, type: PropertyType.Numeric , description: "Discount item index")
        campaign_id(required: false, type: PropertyType.String, description: "Discount's campaign id")
        externalData
    }
    "/px_checkout/result/success/tap_see_all_discounts"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/result/success/tap_download_app"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/result/success/tap_cross_selling"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/result/success/tap_view_receipt"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    // Unknown result
    "/px_checkout/result/unknown/continue"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/result/unknown/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/result/unknown/tap_score"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/result/unknown/tap_discount_item"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        index(required: true, type: PropertyType.Numeric , description: "Discount item index")
        campaign_id(required: false, type: PropertyType.String, description: "Discount's campaign id")
        externalData
    }
    "/px_checkout/result/unknown/tap_see_all_discounts"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/result/unknown/tap_download_app"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/result/unknown/tap_cross_selling"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/result/unknown/change_payment_method"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/result/unknown/primary_action"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/result/unknown/secondary_action"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/result/unknown/tap_view_receipt"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    // In process payment
    "/px_checkout/result/further_action_needed/continue"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/result/further_action_needed/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/result/further_action_needed/tap_score"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/result/further_action_needed/tap_discount_item"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        index(required: true, type: PropertyType.Numeric , description: "Discount item index")
        campaign_id(required: false, type: PropertyType.String, description: "Discount's campaign id")
        externalData
    }
    "/px_checkout/result/further_action_needed/tap_see_all_discounts"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/result/further_action_needed/tap_download_app"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/result/further_action_needed/tap_cross_selling"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/result/further_action_needed/tap_view_receipt"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    // Rejected payment
    "/px_checkout/result/error/change_payment_method"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/result/error/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/result/error/remedy"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
        type(required: true, type: PropertyType.String, description: "Remedy type", values: ["payment_method_suggestion" , "cvv_request", "kyc_request"])
        extra_info(required: false, description: "Extra payment method info")
        index(required: true, type: PropertyType.Numeric , description: "Selected remedy index")
        payment_status(required: true, type: PropertyType.String, description: "Payment status")
        payment_status_detail(required: true, type: PropertyType.String, description: "Payment status")
      }

    // Approved business
    "/px_checkout/result/success/primary_action"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/result/success/secondary_action"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    // Pending business
    "/px_checkout/result/further_action_needed/primary_action"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/result/further_action_needed/secondary_action"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    // Rejected business
    "/px_checkout/result/error/primary_action"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/result/error/secondary_action"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    // Generic dialogs
    "/px_checkout/dialog"(platform: "/mobile", isAbstract: true){
        description(required: true, type: PropertyType.String, description: "Description about dialog being shown")
        actions(required: true, type: PropertyType.Numeric, description: "Actions quantity")
    }
    "/px_checkout/dialog/open"(platform: "/mobile", type: TrackType.Event){}
    "/px_checkout/dialog/dismiss"(platform: "/mobile", type: TrackType.Event){}
    "/px_checkout/dialog/action"(platform: "/mobile", type: TrackType.Event){
        type(required: true, type: PropertyType.String, description: "Action type", values: ["main_action" , "secondary_action"])
        deepLink(required: false, type: PropertyType.String, description: "Deeplink being launched, if any")
    }

    // One tap behaviours
    "/px_checkout/review/one_tap/target_behaviour"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
        behaviour(required: true, type: PropertyType.String, description: "Behaviour which stimulate event", values: ["start_checkout" , "switch_split", "tap_card", "tap_pay"])
        deepLink(required: true, type: PropertyType.String, description: "Deeplink being launched")
    }

    // Deep link launched from the congrats success screen
    "/px_checkout/result/success/deep_link"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
        type(required: false, type: PropertyType.String, description: "type deep link launched")
        deep_link(required: false, type: PropertyType.String, description: "deep link launched")
    }
// Payment Congrats:
    // Payment Congrats result views
    "/payment_congrats"(platform: "/mobile", isAbstract: true){
        externalData
    }
    
    "/payment_congrats/result"(platform: "/mobile", isAbstract: true){
        style(required: true, type: PropertyType.String, description: "Business result or generic", values: ["generic" , "custom"])
        payment_method_id(required: true, type: PropertyType.String, description: "Payment method id")
        payment_method_type(required: false, type: PropertyType.String, description: "Payment method type id")
        payment_id(required: false, type: PropertyType.Numeric, description: "Payment id")
        payment_status(required: true, type: PropertyType.String, description: "Payment status")
        payment_status_detail(required: true, type: PropertyType.String, description: "Payment status")
        preference_amount(required: false, type: PropertyType.Numeric, description: "Total amount")
        total_amount(required: true, type: PropertyType.Numeric, description: "Total amount") // TODO Should be deleted when total amount fully implemented
        currency_id(required: false, type: PropertyType.String, description: "Currency id")
        discount_coupon_amount(required: false, type: PropertyType.Numeric, description: "Discount coupon amount")
        has_split_payment(required: false, type: PropertyType.Boolean, description: "Pay with split payment")
        has_bottom_view(required: false, type: PropertyType.Boolean, description: "Result view has bottom view component")
        has_top_view(required: false, type: PropertyType.Boolean, description: "Result view has top view component")
        has_important_view(required: false, type: PropertyType.Boolean, description: "Result view has important view component")
        has_money_split_view(required: false, type: PropertyType.Boolean, description: "Result view has money split view component")
        score_level(required: false, type: PropertyType.Numeric, description: "Payer score level")
        discounts_count(required: false, type: PropertyType.Numeric, description: "Discounts items displayed")
        campaign_id(required: false, type: PropertyType.String, description: "Campaign id of discount applied to payment")
        campaigns_ids(required: false, type: PropertyType.String, description: "Campaigns ids of discounts displayed")
        extra_info(required: false, description: "Extra payment method info")
    }
    "/payment_congrats/result/success"(platform: "/mobile", type: TrackType.View) {}
    "/payment_congrats/result/further_action_needed"(platform: "/mobile", type: TrackType.View) {}
    "/payment_congrats/result/error"(platform: "/mobile", type: TrackType.View) {}
    "/payment_congrats/result/unknown"(platform: "/mobile", type: TrackType.View) {}
        
    // Approved payment
    "/payment_congrats/result/success/continue"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/payment_congrats/result/success/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/payment_congrats/result/success/tap_score"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/payment_congrats/result/success/tap_discount_item"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        index(required: true, type: PropertyType.Numeric , description: "Discount item index")
        campaign_id(required: false, type: PropertyType.String, description: "Discount's campaign id")
        externalData
    }
    "/payment_congrats/result/success/tap_see_all_discounts"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/payment_congrats/result/success/tap_download_app"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/payment_congrats/result/success/tap_cross_selling"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/payment_congrats/result/success/tap_view_receipt"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    // Unknown result
    "/payment_congrats/result/unknown/continue"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/payment_congrats/result/unknown/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/payment_congrats/result/unknown/tap_score"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/payment_congrats/result/unknown/tap_discount_item"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        index(required: true, type: PropertyType.Numeric , description: "Discount item index")
        campaign_id(required: false, type: PropertyType.String, description: "Discount's campaign id")
        externalData
    }
    "/payment_congrats/result/unknown/tap_see_all_discounts"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/payment_congrats/result/unknown/tap_download_app"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/payment_congrats/result/unknown/tap_cross_selling"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/payment_congrats/result/unknown/change_payment_method"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/payment_congrats/result/unknown/primary_action"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/payment_congrats/result/unknown/secondary_action"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/payment_congrats/result/unknown/tap_view_receipt"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    // In process payment
    "/payment_congrats/result/further_action_needed/continue"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/payment_congrats/result/further_action_needed/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/payment_congrats/result/further_action_needed/tap_score"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/payment_congrats/result/further_action_needed/tap_discount_item"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        index(required: true, type: PropertyType.Numeric , description: "Discount item index")
        campaign_id(required: false, type: PropertyType.String, description: "Discount's campaign id")
        externalData
    }
    "/payment_congrats/result/further_action_needed/tap_see_all_discounts"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/payment_congrats/result/further_action_needed/tap_download_app"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/payment_congrats/result/further_action_needed/tap_cross_selling"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/payment_congrats/result/further_action_needed/tap_view_receipt"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    // Rejected payment
    "/payment_congrats/result/error/change_payment_method"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/payment_congrats/result/error/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    // Approved business
    "/payment_congrats/result/success/primary_action"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/payment_congrats/result/success/secondary_action"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    // Pending business
    "/payment_congrats/result/further_action_needed/primary_action"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    
    "/payment_congrats/result/further_action_needed/secondary_action"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    // Rejected business
    "/payment_congrats/result/error/primary_action"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/payment_congrats/result/error/secondary_action"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

     // Deep link launched from the congrats success screen
    "/payment_congrats/result/success/deep_link"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
        type(required: false, type: PropertyType.String, description: "type deep link launched")
        deep_link(required: false, type: PropertyType.String, description: "deep link launched")
    }

}

