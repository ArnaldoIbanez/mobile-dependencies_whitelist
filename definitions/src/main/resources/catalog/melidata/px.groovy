import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType


tracks {

    propertyDefinitions {
        flow_detail(required: false, description: "External info")
        flow(required: false, type: PropertyType.String, description: "External flow name")
        collector_id(required: false, description: "Collector external id")
    }

    propertyGroups {
        externalData(flow, flow_detail, collector_id)
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
        preference_amount(required: true, type: PropertyType.Numeric , description: "Total amount")
        discount(required: false, description: "Discount if available")
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
        payment_method_id(required: false, type: PropertyType.String, description: "Payment method id")
        card_id(required: false, type: PropertyType.String , description: "Card id")
        externalData
    }
    "/px_checkout/payments/select_method/debit_card/cvv"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.View) {
        payment_method_id(required: false, type: PropertyType.String, description: "Payment method id")
        card_id(required: false, type: PropertyType.String , description: "Card id")
        externalData
    }
    "/px_checkout/payments/select_method/prepaid_card/cvv"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.View) {
        payment_method_id(required: false, type: PropertyType.String, description: "Payment method id")
        card_id(required: false, type: PropertyType.String , description: "Card id")
        externalData
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
        preference_amount(required: true, type: PropertyType.Numeric , description: "Total amount")
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
        preference_amount(required: true, type: PropertyType.Numeric , description: "Total amount")
        available_methods(required: true, type: PropertyType.ArrayList , description: "Array of available payment methods to pay")
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

    // One tap installments view
    "/px_checkout/review/one_tap/installments"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.View) {
        payment_method_id(required: true, type: PropertyType.String, description: "Payment method id")
        payment_method_type(required: true, type: PropertyType.String, description: "Payment method type id")
        issuer_id(required: true, type: PropertyType.Numeric , description: "Issuer id")
        card_id(required: true, type: PropertyType.String , description: "Card id")
        available_installments(required: true, type: PropertyType.ArrayList , description: "Array of available installments")
        externalData
    }

    // Payment result views
    "/px_checkout/result"(platform: "/mobile", isAbstract: true){
        style(required: true, type: PropertyType.String, description: "Business result or generic", values: ["generic" , "custom"])
        payment_method_id(required: true, type: PropertyType.String, description: "Payment method id")
        payment_method_type(required: true, type: PropertyType.String, description: "Payment method type id")
        extra_info(required: false, description: "Extra payment method info")
        payment_id(required: false, type: PropertyType.Numeric, description: "Payment id")
        payment_status(required: true, type: PropertyType.String, description: "Payment status")
        payment_status_detail(required: true, type: PropertyType.String, description: "Payment status")
    }
    "/px_checkout/result/success"(platform: "/mobile", type: TrackType.View) {}
    "/px_checkout/result/further_action_needed"(platform: "/mobile", type: TrackType.View) {}
    "/px_checkout/result/error"(platform: "/mobile", type: TrackType.View) {}
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
        split_enabled(required: false, type: PropertyType.Boolean, description: "Has split enabled")
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

    // Unknown result
    "/px_checkout/result/unknown/continue"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/result/unknown/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
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

    // In process payment
    "/px_checkout/result/further_action_needed/continue"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    "/px_checkout/result/further_action_needed/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }

    // Rejected payment
    "/px_checkout/result/error/change_payment_method"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
    }
    "/px_checkout/result/error/abort"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        externalData
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
}
