package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    /* -----------------------------------------------------------------------------*/
    /* Componente de tasas y plazos.                                                */
    /* -----------------------------------------------------------------------------*/

    test("Mercadopago fees and installment component view") {
        "/fees_installment/payment_method/view" (platform: "/", type: TrackType.View) {}
    }

    test("Mercadopago fees and installment data loaded successfully") {
        "/fees_installment/payment_method/success" (platform: "/", type: TrackType.Event) {
            payments = [
                [
                    order: 0,
                    channel_id: "point",
                    payment_methods: []
                ],
                [
                    order: 1,
                    channel_id: "qr",
                    payment_methods: [
                        [
                            channel_id: "qr",
                            editable: true,
                            payment_method_id: "qr_online-group_pricing_option_id",
                            release_option_id: "MLB_qr_digital-currency_value_1000",
                            order: 0,
                            release_option_values: [
                                [
                                    order: 0,
                                    fee: "0,99%",
                                    installment: "Na hora"
                                ]
                            ]
                        ],
                        [
                            channel_id: "qr",
                            editable: true,
                            payment_method_id: "qr_credit_pricing_option_id",
                            release_option_id: "MLB_qr_credit_value_1000",
                            order: 1,
                            release_option_values: [
                                [
                                    order: 0,
                                    fee: "1,99%",
                                    installment: "Na hora"
                                ]
                            ]
                        ]
                    ]
                ],
                [
                    order: 2,
                    channel_id: "merchant-services",
                    payment_methods: [
                        [
                            channel_id: "merchant-services",
                            editable: true,
                            payment_method_id: "merchant-svcs_online-group_pricing_option_id",
                            release_option_id: "MLB_merchant-svcs_credit_value_3000",
                            order: 0,
                            release_option_values: [
                                [
                                    order: 0,
                                    fee: "3,99%",
                                    installment: "Em 30 dias"
                                ]
                            ]
                        ],
                        [
                            channel_id: "merchant-services",
                            editable: true,
                            payment_method_id: "merchant-svcs_ticket_pricing_option_id",
                            release_option_id: "MLB_merchant-svcs_ticket_value_1000",
                            order: 1,
                            release_option_values: [
                                [
                                    order: 0,
                                    fee: "R\$ 3,49",
                                    installment: "Em até 3 dias"
                                ]
                            ]
                        ]
                    ]
                ]
            ]
        }
    }

    test("Mercadopago fees and installment payment method selection") {
        "/fees_installment/payment_method/selection_action" (platform: "/", type: TrackType.Event) {
            channel_id = "qr"
            release_option_id = "MLB_qr_credit_value_1000"
            payment_method_id = "qr_credit_pricing_option_id"
            order = 1
            editable = true
            release_option_values = [
                [
                    order: 0,
                    fee: "1,99%",
                    installment: "Na hora"
                ]
            ]
        }
    }

    test("Mercadopago fees and installment data could not be loaded") {
        "/fees_installment/payment_method/error" (platform: "/", type: TrackType.Event) {
            message = "Algo salió mal."
        }
    }

    test("Mercadopago fees and instalmment execute footer action") {
        "/fees_installment/payment_method/footer_action" (platform: "/", type: TrackType.Event) {
            url = "https://www.mercadopago.com.br/ajuda/custo-receber-pagamentos_453"
        }
    }

    /* -----------------------------------------------------------------------------*/
    /* Pantalla de seleción de tasas y plazos.                                      */
    /* -----------------------------------------------------------------------------*/

    test("Mercadopago fees and installment in release option selection view") {
        "/fees_installment/release_option/view" (platform: "/", type: TrackType.View) {}
    }

    test("Mercadopago fees and installment in release option selection view execute footer action") {
        "/fees_installment/release_option/footer_action" (platform: "/", type: TrackType.Event) {
            url = "https://www.mercadopago.com.br/ajuda/custo-receber-pagamentos_453"
        }
    }

    test("Mercadopago fees and installment in release option selection view data updated successfully") {
        "/fees_installment/release_option/update" (platform: "/", type: TrackType.Event) {
            channel_id = "qr"
            release_option_id = "MLB_qr_credit_value_1000"
            payment_method_id = "qr_credit_pricing_option_id"
            order = -1
            editable = true
            release_option_values = [
                [
                    order: 0,
                    fee: "1,99%",
                    installment: "Na hora"
                ]
            ]
        }
    }

    test("Mercadopago fees and installment in release option selection view execute back action") {
        "/fees_installment/release_option/back" (platform: "/", type: TrackType.Event) {}
    }

    test("Mercadopago fees and installment in release option selection view failed to update fees") {
        "/fees_installment/release_option/error" (platform: "/", type: TrackType.Event) {
            message = "Algo salió mal."
        }
    }

    /* -----------------------------------------------------------------------------*/
    /* Pantalla de la Faq.                                                          */
    /* -----------------------------------------------------------------------------*/

    test("Mercadopago fees and installment faq view") {
        "/fees_installment/faq/view" (platform: "/", type: TrackType.View) {
            url = "https://www.mercadopago.com.br/ajuda/custo-receber-pagamentos_453"
        }
    }

    test("Mercadopago fees and installment in faq view the url could not be loaded") {
        "/fees_installment/faq/error" (platform: "/", type: TrackType.Event) {
            message= "Algo salió mal."
            url = "https://www.mercadopago.com.br/ajuda/custo-receber-pagamentos_453"
        }
    }

    test("Mercadopago fees and installment in faq view execute back action") {
        "/fees_installment/faq/back" (platform: "/", type: TrackType.Event) {}
    }

    test("Mercadopago fees and installment in faq view url loaded successfully") {
        "/fees_installment/faq/success" (platform: "/", type: TrackType.Event) {
            url = "https://www.mercadopago.com.br/ajuda/custo-receber-pagamentos_453"
        }
    }

    /* -----------------------------------------------------------------------------*/
    /* Pantalla de tasas y plazos.                                                  */
    /* -----------------------------------------------------------------------------*/

    test("Mercadopago fees and installment view deeplink usage") {
        "/fees_installment/deeplink_usage" (platform: "/", type: TrackType.View) {
            deeplink = "mercadopago://fees_installment/fees"
        }
    }
}