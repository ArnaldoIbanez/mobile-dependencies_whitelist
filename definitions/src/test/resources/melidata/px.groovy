package melidata

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

        // One tap + descuento
        "/px_checkout/review/one_tap"(platform: "/mobile", type: TrackType.View) {
            total_amount = 700
            available_methods = [
                    {
                        payment_method_type = "credit_card"
                        payment_method_id = "visa"
                        extra_info = {
                            selected_installment = {
                                quantity = 3
                                installment_amount = 137
                                interest_rate = 10
                            }
                            card_id = "12345"
                            issuer_id = 12
                            has_esc: true
                        }
                    },
                    {
                        payment_method_type = "account_money"
                        payment_method_id = "account_money"

                    }
            ]

            currency_id = "ARS"
            discount = {
                type = "percentage"
                percentage = 0.2
                amount_to_discount = 200
                max_amount_to_discount = 200
                max_redeem_per_user = 1
            }
            items = [
                    {
                        item = {
                            id = 1234
                            description = "Item de testeo"
                            price = 200
                        }
                        quantity = 3
                        currency_id = "ARS"
                    }
            ]
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
        }

        // One tap sin descuento

        "/px_checkout/review/one_tap"(platform: "/mobile", type: TrackType.View) {
            available_methods = [
                    {
                        payment_method_type = "credit_card"
                        payment_method_id = "visa"
                        extra_info = {
                            selected_installment = {
                                quantity = 3
                                installment_amount = 137
                                interest_rate = 10
                            }
                            card_id = "12345"
                            issuer_id = 12
                            has_esc: true
                        }
                    },
                    {
                        payment_method_type = "account_money"
                        payment_method_id = "account_money"

                    }

            ]

            total_amount = 700
            currency_id = "ARS"
            items = [
                    {
                        item = {
                            id = 1234
                            description = "Item de testeo"
                            price = 200
                        }
                        quantity = 3
                        currency_id = "ARS"
                    }
            ]

        }

        "/px_checkout/review/one_tap/installments"(platform: "/mobile", type: TrackType.View) {
            payment_method_type = "credit_card"
            payment_method_id = "visa"
            issuer_id = 1
            card_id = "1234"
            total_amount = 200
            available_installments = [
                    {
                        quantity = 1
                        installment_amount = 200
                        visible_total_price = null
                        interest_rate = 0
                    },
                    {
                        quantity = 3
                        installment_amoun = 200
                        visible_total_price = 279
                        interest_rate = 20
                    }
            ]
            currency_id = "ARS"
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"

        }

        "/px_checkout/review/one_tap/applied_discount"(platform: "/mobile", type: TrackType.View) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
        }

        "/px_checkout/result/success"(platform: "/mobile", type: TrackType.View) {}
        "/px_checkout/result/further_action_needed"(platform: "/mobile", type: TrackType.View) {}
        "/px_checkout/result/error"(platform: "/mobile", type: TrackType.View) {}

        "/px_checkout/card_association_result/success"(platform: "/mobile", type: TrackType.View) {}
        "/px_checkout/card_association_result/error"(platform: "/mobile", type: TrackType.View) {}

    }

    test("PX - Events") {

        "/px_checkout/review/one_tap/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
        }

        "/px_checkout/review/one_tap/swipe"(platform: "/mobile", type: TrackType.Event) {}

        // One tap + credit card
        "/px_checkout/review/confirm"(platform: "/mobile", type: TrackType.Event) {
            payment_method_type = "credit_card"
            payment_method_id = "visa"
            review_type = "one_tap"
            extra_info = {
                selected_installment = {
                    quantity = 3
                    installment_amount = 137
                    interest_rate = 10
                }
                card_id = "12345"
                issuer_id = 12
                has_esc = true
            }
        }

        // One tap + account money
        "/px_checkout/review/confirm"(platform: "/mobile", type: TrackType.Event) {
            payment_method_type = "account_money"
            payment_method_id = "account_money"
            review_type = "one_tap"

            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
        }

        // Review Traditional + credit card
        "/px_checkout/review/confirm"(platform: "/mobile", type: TrackType.Event) {
            payment_method_type = "credit_card"
            payment_method_id = "visa"
            review_type = "traditional"
            extra_info = {
                selected_installment = [
                        quantity = 3,
                        installment_amount = 137,
                        interest_rate = 10
                ]
                card_id = "12345"
                issuer_id = 12
                has_esc = true
            }
        }

    }

    defaultBusiness = "mercadopago"

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

        // One tap + descuento
        "/px_checkout/review/one_tap"(platform: "/mobile", type: TrackType.View) {
            total_amount = 700
            available_methods = [
                    {
                        payment_method_type = "credit_card"
                        payment_method_id = "visa"
                        extra_info = {
                            selected_installment = {
                                quantity = 3
                                installment_amount = 137
                                interest_rate = 10
                            }
                            card_id = "12345"
                            issuer_id = 12
                            has_esc: true
                        }
                    },
                    {
                        payment_method_type = "account_money"
                        payment_method_id = "account_money"

                    }
            ]

            currency_id = "ARS"
            discount = {
                type = "percentage"
                percentage = 0.2
                amount_to_discount = 200
                max_amount_to_discount = 200
                max_redeem_per_user = 1
            }
            items = [
                    {
                        item = {
                            id = 1234
                            description = "Item de testeo"
                            price = 200
                        }
                        quantity = 3
                        currency_id = "ARS"
                    }
            ]
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
        }

        // One tap sin descuento

        "/px_checkout/review/one_tap"(platform: "/mobile", type: TrackType.View) {
            available_methods = [
                    {
                        payment_method_type = "credit_card"
                        payment_method_id = "visa"
                        extra_info = {
                            selected_installment = {
                                quantity = 3
                                installment_amount = 137
                                interest_rate = 10
                            }
                            card_id = "12345"
                            issuer_id = 12
                            has_esc: true
                        }
                    },
                    {
                        payment_method_type = "account_money"
                        payment_method_id = "account_money"

                    }

            ]

            total_amount = 700
            currency_id = "ARS"
            items = [
                    {
                        item = {
                            id = 1234
                            description = "Item de testeo"
                            price = 200
                        }
                        quantity = 3
                        currency_id = "ARS"
                    }
            ]

        }

        "/px_checkout/review/one_tap/installments"(platform: "/mobile", type: TrackType.View) {
            payment_method_type = "credit_card"
            payment_method_id = "visa"
            issuer_id = 1
            card_id = "1234"
            total_amount = 200
            available_installments = [
                    {
                        quantity = 1
                        installment_amount = 200
                        visible_total_price = null
                        interest_rate = 0
                    },
                    {
                        quantity = 3
                        installment_amoun = 200
                        visible_total_price = 279
                        interest_rate = 20
                    }
            ]
            currency_id = "ARS"
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"

        }

        "/px_checkout/review/one_tap/applied_discount"(platform: "/mobile", type: TrackType.View) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
        }

        "/px_checkout/result/success"(platform: "/mobile", type: TrackType.View) {}
        "/px_checkout/result/further_action_needed"(platform: "/mobile", type: TrackType.View) {}
        "/px_checkout/result/error"(platform: "/mobile", type: TrackType.View) {}

        "/px_checkout/card_association_result/success"(platform: "/mobile", type: TrackType.View) {}
        "/px_checkout/card_association_result/error"(platform: "/mobile", type: TrackType.View) {}

    }

    test("PX - Events") {

        "/px_checkout/review/one_tap/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
        }

        "/px_checkout/review/one_tap/swipe"(platform: "/mobile", type: TrackType.Event) {}

        // One tap + credit card
        "/px_checkout/review/confirm"(platform: "/mobile", type: TrackType.Event) {
            payment_method_type = "credit_card"
            payment_method_id = "visa"
            review_type = "one_tap"
            extra_info = {
                selected_installment = {
                    quantity = 3
                    installment_amount = 137
                    interest_rate = 10
                }
                card_id = "12345"
                issuer_id = 12
                has_esc = true
            }
        }

        // One tap + account money
        "/px_checkout/review/confirm"(platform: "/mobile", type: TrackType.Event) {
            payment_method_type = "account_money"
            payment_method_id = "account_money"
            review_type = "one_tap"

            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
        }

        // Review Traditional + credit card
        "/px_checkout/review/confirm"(platform: "/mobile", type: TrackType.Event) {
            payment_method_type = "credit_card"
            payment_method_id = "visa"
            review_type = "traditional"
            extra_info = {
                selected_installment = [
                        quantity = 3,
                        installment_amount = 137,
                        interest_rate = 10
                ]
                card_id = "12345"
                issuer_id = 12
                has_esc = true
            }
        }
    }
}
