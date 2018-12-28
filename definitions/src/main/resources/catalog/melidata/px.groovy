import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType


tracks {

    propertyDefinitions {
        flow_detail(required: false, description: "External info")
        flow(required: false, type: PropertyType.String, description: "External flow name")
        collector_id(required: false, type: PropertyType.String, description: "Collector external id")
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
    "/px_checkout/payments/select_method"(platform: "/mobile", isAbstract: true){}
    "/px_checkout/payments/select_method"(platform: "/mobile", type: TrackType.View) {}
    "/px_checkout/payments/select_method/ticket"(platform: "/mobile", type: TrackType.View) {}
    "/px_checkout/payments/select_method/select_card_type"(platform: "/mobile", type: TrackType.View) {}

    // Discount view
    "/px_checkout/payments/select_method/applied_discount"(platform: "/mobile", type: TrackType.View) {}

    // Security code view
    "/px_checkout/payments/select_method/credit_card"(platform: "/mobile", isAbstract: true){}
    "/px_checkout/payments/select_method/debit_card"(platform: "/mobile", isAbstract: true){}
    "/px_checkout/payments/select_method/prepaid_card"(platform: "/mobile", isAbstract: true){}

    "/px_checkout/payments/select_method/credit_card/cvv"(platform: "/mobile", type: TrackType.View) {}
    "/px_checkout/payments/select_method/debit_card/cvv"(platform: "/mobile", type: TrackType.View) {}
    "/px_checkout/payments/select_method/prepaid_card/cvv"(platform: "/mobile", type: TrackType.View) {}

    // Bank deals views
    "/px_checkout/add_payment_method/promotions"(platform: "/mobile", type: TrackType.View) {}
    "/px_checkout/add_payment_method/promotions/terms_and_conditions"(platform: "/mobile", type: TrackType.View) {}

    // Card form views
    "/px_checkout/add_payment_method"(platform: "/mobile", isAbstract: true){}
    "/px_checkout/add_payment_method/credit_card"(platform: "/mobile", isAbstract: true){}
    "/px_checkout/add_payment_method/debit_card"(platform: "/mobile", isAbstract: true){}
    "/px_checkout/add_payment_method/prepaid_card"(platform: "/mobile", isAbstract: true){}

    "/px_checkout/add_payment_method/credit_card/number"(platform: "/mobile", type: TrackType.View) {}
    "/px_checkout/add_payment_method/debit_card/number"(platform: "/mobile", type: TrackType.View) {}
    "/px_checkout/add_payment_method/prepaid_card/number"(platform: "/mobile", type: TrackType.View) {}

    "/px_checkout/add_payment_method/credit_card/number/error_more_info"(platform: "/mobile", type: TrackType.View) {}
    "/px_checkout/add_payment_method/debit_card/number/error_more_info"(platform: "/mobile", type: TrackType.View) {}
    "/px_checkout/add_payment_method/prepaid_card/number/error_more_info"(platform: "/mobile", type: TrackType.View) {}

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
    "/px_checkout/payments/card_issuer"(platform: "/mobile", type: TrackType.View) {}

    // Installments view
    "/px_checkout/payments/installments"(platform: "/mobile", type: TrackType.View) {}

    // Boleto views
    "/px_checkout/select_method"(platform: "/mobile", isAbstract: true){}
    "/px_checkout/select_method/ticket"(platform: "/mobile", isAbstract: true){}
    "/px_checkout/select_method/ticket/cpf"(platform: "/mobile", type: TrackType.View) {}
    "/px_checkout/select_method/ticket/name"(platform: "/mobile", type: TrackType.View) {}
    "/px_checkout/select_method/ticket/lastname"(platform: "/mobile", type: TrackType.View) {}

    // Review and confirm view
    "/px_checkout/review"(platform: "/mobile", isAbstract: true){}
    "/px_checkout/review/traditional"(platform: "/mobile", type: TrackType.View) {}

    // Terms and conditions view
    "/px_checkout/review/traditional/terms_and_conditions"(platform: "/mobile", type: TrackType.View) {}

    // One tap view
    "/px_checkout/review/one_tap"(platform: "/mobile", type: TrackType.View) {
        total_amount(required: true, type: PropertyType.Numeric , description: "Total amount")
        currency_id(required: true, type: PropertyType.String , description: "Currency id")
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
        total_amount(required: true, type: PropertyType.Numeric , description: "Total amount")
        currency_id(required: true, type: PropertyType.String , description: "Currency id")
        available_installments(required: true, type: PropertyType.ArrayList , description: "Array of available installments")
        externalData
    }

    // One tap discount view
    "/px_checkout/review/one_tap/applied_discount"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.View) {
        externalData
    }

    // Payment result views
    "/px_checkout/result"(platform: "/mobile", isAbstract: true){}
    "/px_checkout/result/success"(platform: "/mobile", type: TrackType.View) {}
    "/px_checkout/result/further_action_needed"(platform: "/mobile", type: TrackType.View) {}
    "/px_checkout/result/error"(platform: "/mobile", type: TrackType.View) {}

    // Card association result views
    "/px_checkout/card_association_result"(platform: "/mobile", isAbstract: true){}
    "/px_checkout/card_association_result/success"(platform: "/mobile", type: TrackType.View) {}
    "/px_checkout/card_association_result/error"(platform: "/mobile", type: TrackType.View) {}

    // Events:

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

}