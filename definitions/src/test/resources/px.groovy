import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("PX - views") {

        "/px_checkout/payments/select_method"(platform: "/mobile", type: TrackType.View) {}
        "/px_checkout/payments/select_method/ticket"(platform: "/mobile", type: TrackType.View) {}
        "/px_checkout/payments/select_method/select_card_type"(platform: "/mobile", type: TrackType.View) {}

        "/px_checkout/payments/select_method/applied_discount"(platform: "/mobile", type: TrackType.View) {}

        "/px_checkout/payments/select_method/credit_card/cvv"(platform: "/mobile", type: TrackType.View) {}
        "/px_checkout/payments/select_method/debit_card/cvv"(platform: "/mobile", type: TrackType.View) {}
        "/px_checkout/payments/select_method/prepaid_card/cvv"(platform: "/mobile", type: TrackType.View) {}

        "/px_checkout/add_payment_method/promotions"(platform: "/mobile", type: TrackType.View) {}

        "/px_checkout/add_payment_method/promotions/terms_and_conditions"(platform: "/mobile", type: TrackType.View) {}

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

        "/px_checkout/payments/card_issuer"(platform: "/mobile", type: TrackType.View) {}

        "/px_checkout/payments/installments"(platform: "/mobile", type: TrackType.View) {}

        "/px_checkout/select_method/ticket/cpf"(platform: "/mobile", type: TrackType.View) {}
        "/px_checkout/select_method/ticket/name"(platform: "/mobile", type: TrackType.View) {}
        "/px_checkout/select_method/ticket/lastname"(platform: "/mobile", type: TrackType.View) {}

        "/px_checkout/review/traditional"(platform: "/mobile", type: TrackType.View) {}

        "/px_checkout/review/traditional/terms_and_conditions"(platform: "/mobile", type: TrackType.View) {}

        "/px_checkout/review/one_tap"(platform: "/mobile", type: TrackType.View) {}

        "/px_checkout/result/success"(platform: "/mobile", type: TrackType.View) {}
        "/px_checkout/result/further_action_needed"(platform: "/mobile", type: TrackType.View) {}
        "/px_checkout/result/error"(platform: "/mobile", type: TrackType.View) {}

    }
}
