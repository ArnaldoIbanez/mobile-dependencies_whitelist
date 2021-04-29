import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("PX - views") {

        "/px_checkout/payments/select_method"(platform: "/mobile", type: TrackType.View) {
            available_methods = [
                    {
                        payment_method_type = "credit_card"
                        payment_method_id = "visa"
                        extra_info = {
                            selected_installment = null
                            card_id = "12345"
                            has_esc = true
                            issuer_id = 12
                        }
                    },
                    {
                        payment_method_type = "account_money"
                        payment_method_id = "account_money"
                        extra_info = {
                            balance = 12345
                            invested = true
                        }
                    },
                    {
                        payment_method_type = "credit_card"
                    }
            ]
            preference_amount = 1
            total_amount = 1            
            discount =
                    {
                        percent_off = 0.2
                        amount_off = 4
                        coupon_amount = 4
                        max_coupon_amount = 10
                        max_redeem_per_user = 1
                        campaign_id = 1
                        is_available = true
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
            collector_id = 12312412
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/payments/select_method/ticket"(platform: "/mobile", type: TrackType.View) {
            available_methods = [
                    {
                        payment_method_id = "pagofacil"
                        payment_method_type = "ticket"
                        extra_info = null

                    },
                    {
                        payment_method_type = "ticket"
                        extra_info = null
                    }
            ]
            preference_amount = 1
            total_amount = 1
            discount =
                    {
                        percent_off = 0.2
                        amount_off = 4
                        coupon_amount = 4
                        max_coupon_amount = 10
                        max_redeem_per_user = 1
                        campaign_id = 1
                        is_available = true
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
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/cards"(platform: "/mobile", type: TrackType.View) {
            available_methods = [
                    {
                        payment_method_type = "credit_card"
                    }
            ]
            preference_amount = 1
            total_amount = 1
            discount =
                    {
                        percent_off = 0.2
                        amount_off = 4
                        coupon_amount = 4
                        max_coupon_amount = 10
                        max_redeem_per_user = 1
                        campaign_id = 1
                        is_available = true
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
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }


        "/px_checkout/payments/applied_discount"(platform: "/mobile", type: TrackType.View) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }

            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"

            discount = {
                percent_off = 0.2
                amount_off = 4
                coupon_amount = 4
                max_coupon_amount = 10
                max_redeem_per_user = 1
                campaign_id = 1
                is_available = true
            }
        }

        "/px_checkout/payments/select_method/credit_card/cvv"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "mastercard"
            card_id = "1234"

            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            reason = "esc_cap"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/payments/select_method/debit_card/cvv"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "mastercard"
            card_id = "1234"
            reason = "saved_card"
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/payments/select_method/prepaid_card/cvv"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "mastercard"
            card_id = "1234"

            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            reason = "call_for_auth"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/promotions"(platform: "/mobile", type: TrackType.View) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/promotions/terms_and_conditions"(platform: "/mobile", type: TrackType.View) {
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            flow = "/instore"
        }

        "/px_checkout/add_payment_method/number"(platform: "/mobile", type: TrackType.View) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/number/error_more_info"(platform: "/mobile", type: TrackType.View) {
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            flow = "/instore"
        }

        "/px_checkout/add_payment_method/credit_card/name"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "visa"
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/add_payment_method/debit_card/name"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "visa"
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/add_payment_method/prepaid_card/name"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "visa"
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/add_payment_method/credit_card/expiration_date"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "visa"
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/add_payment_method/debit_card/expiration_date"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "visa"
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/add_payment_method/prepaid_card/expiration_date"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "visa"
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/add_payment_method/credit_card/cvv"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "visa"
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/add_payment_method/debit_card/cvv"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "visa"
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/add_payment_method/prepaid_card/cvv"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "visa"
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/add_payment_method/credit_card/document"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "visa"
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/add_payment_method/debit_card/document"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "visa"
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/add_payment_method/prepaid_card/document"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "visa"
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/card_issuer"(platform: "/mobile", type: TrackType.View) {
            payment_method_type = "credit_card"
            payment_method_id = "visa"
            available_banks = [
                    {
                        id = "bbva"
                        name = "BBVA Bancomer"
                    },
                    {
                        id = "banamex"
                        name = "Banamex"
                    }
            ]
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/installments"(platform: "/mobile", type: TrackType.View) {
            payment_method_type = "credit_card"
            payment_method_id = "visa"
            issuer_id = 1
            card_id = "1234"
            available_installments = [
                    {

                        quantity = 1
                        installment_amount = 200
                        visible_total_price = null
                        interest_rate = 10
                    },
                    {

                        quantity = 9
                        installment_amount = 31.10
                        visible_total_price = 279.85
                        interest_rate = 20
                    }
            ]
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"

        }

        "/px_checkout/payments/select_method/ticket/cpf"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "bolbradesco"
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/payments/select_method/ticket/name"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "bolbradesco"
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/payments/select_method/ticket/lastname"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "bolbradesco"
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }


        "/px_checkout/review/traditional"(platform: "/mobile", type: TrackType.View) {
            payment_method_type = "credit_card"
            payment_method_id = "visa"
            extra_info = {
                issuer_id = 1
                card_id = "1234"
                has_esc = true
                selected_installment = {
                    quantity = 3
                    installment_amount = 137
                    interest_rate = 10
                    visible_total_price = 229
                }
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
            preference_amount = 200
            total_amount = 200

            discount =
                    {
                        percent_off = 0.2
                        amount_off = 4
                        coupon_amount = 4
                        max_coupon_amount = 10
                        max_redeem_per_user = 1
                        campaign_id = 1
                        is_available = true
                    }

            collector_id = "12312412"
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/terms_and_conditions"(platform: "/mobile", type: TrackType.View) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }

            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            url = "https://www.mercadopago.com.ar/ayuda/terminos-y-condiciones_299"
        }

        // One tap + descuento
        "/px_checkout/review/one_tap"(platform: "/mobile", type: TrackType.View) {
            preference_amount = 700
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

            discount = {
                percent_off = 0.2
                amount_off = 4
                coupon_amount = 4
                max_coupon_amount = 10
                max_redeem_per_user = 1
                campaign_id = 1
                is_available = true
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
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
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

            preference_amount = 700
            total_amount = 700
            
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
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"

        }

        "/px_checkout/review/one_tap/offline_methods"(platform: "/mobile", type: TrackType.View) {
            available_methods = [
                    {
                        payment_method_type = "ticket"
                        payment_method_id = "rapipago"
                    },
                    {
                        payment_method_type = "bank_transfer"
                        payment_method_id = "redlink"
                    }

            ]

            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/review/one_tap/installments"(platform: "/mobile", type: TrackType.View) {
            payment_method_type = "credit_card"
            payment_method_id = "visa"
            issuer_id = 1
            card_id = "1234"
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
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/review/one_tap/disabled_payment_method_detail"(platform: "/mobile", type: TrackType.View) {
            flow = "/instore"
        }

        "/px_checkout/result/success"(platform: "/mobile", type: TrackType.View) {
            style = "generic"
            payment_method_id = "redlink"
            payment_method_type = "atm"
            payment_id = 1234
            payment_status = "approved"
            payment_status_detail = "approved"

            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            preference_amount = 500
            total_amount = 500
            currency_id = "ARS"
            discount_coupon_amount = 100
            has_split_payment = false
            has_bottom_view = false
            has_top_view = false
            has_important_view = false
            has_money_split_view = true
            score_level = 5
            discounts_count = 6
            campaigns_ids = "1, 2, 3, 4, 5, 6"
            campaign_id = "10"
        }
        "/px_checkout/result/unknown"(platform: "/mobile", type: TrackType.View) {
            style = "generic"
            payment_method_id = "redlink"
            payment_method_type = "atm"
            payment_id = 1234
            payment_status = "approved"
            payment_status_detail = "approved"

            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            preference_amount = 500
            total_amount = 500
            currency_id = "ARS"

            has_split_payment = false
            has_bottom_view = false
            has_top_view = false
            has_important_view = false
            has_money_split_view = false
            score_level = 5
            discounts_count = 6
            campaigns_ids = "1, 2, 3, 4, 5, 6"
            campaign_id = "10"
        }
        "/px_checkout/result/further_action_needed"(platform: "/mobile", type: TrackType.View) {
            style = "generic"
            payment_method_id = "visa"
            payment_method_type = "credit_card"
            payment_id = 1234
            payment_status = "pending"
            payment_status_detail = "pending"
            extra_info = {
                issuer_id = 1
                card_id = "1234"
                has_esc = true
            }
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            preference_amount = 500
            total_amount = 500
            currency_id = "ARS"
            has_split_payment = false
            has_bottom_view = false
            has_top_view = false
            has_important_view = false
            has_money_split_view = false
        }
        "/px_checkout/result/error"(platform: "/mobile", type: TrackType.View) {
            style = "generic"
            payment_method_id = "visa"
            payment_method_type = "credit_card"
            payment_id = 1234
            payment_status = "rejected"
            payment_status_detail = "STATUS_DETAIL_REJECTED_REJECTED_BY_BANK"
            extra_info = {
                issuer_id = 1
                card_id = "1234"
                has_esc = true
            }

            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            preference_amount = 500
            total_amount = 500            
            currency_id = "ARS"
            
            has_split_payment = false
            has_bottom_view = false
            has_top_view = false
            has_important_view = false
            has_money_split_view = false
            remedies = [ "cvv_request" ]
        }

        "/px_checkout/generic_error"(platform: "/mobile", type: TrackType.View) {
            
            error_message = "Hubo un error"
            api_error = {
                status = 400
                causes = [
                        {
                            code = "code"
                            description = "message"
                        }
                ]
                url = "get_preference"
                retry_available = true
            }
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            flow = "/instore"
        }

        "/px_checkout/card_association_result/success"(platform: "/mobile", type: TrackType.View) {
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            flow = "/instore"
        }
        "/px_checkout/card_association_result/error"(platform: "/mobile", type: TrackType.View) {
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            flow = "/instore"
        }
    }

    test("PX - Events") {

      "/px_checkout/review/one_tap/back"(platform: "/mobile", type: TrackType.Event) {
          flow_detail = {
              collector_id = 1234
              brand_name = "YPF"
              store_id = 1234
              pos_id = 1234
          }
          flow = "/instore"
          session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
      }

        "/px_checkout/review/one_tap/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/review/one_tap/swipe"(platform: "/mobile", type: TrackType.Event) {
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            flow = "/instore"
        }

        "/px_checkout/combo_switch"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            option_selected = "debit_card"
        }

        "/px_checkout/program_validation"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            validation_program_used = "STP"
        }

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
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
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
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
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
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Init event + pref id:
        "/px_checkout/init"(platform: "/mobile", type: TrackType.Event) {
            checkout_preference_id = "123"
            esc_enabled = true
            express_enabled = true
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            split_enabled = true
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Init event:
        "/px_checkout/init"(platform: "/mobile", type: TrackType.Event) {
            checkout_preference = {
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
            esc_enabled = true
            express_enabled = true
            split_enabled = false
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Offline Payment Selection event
        "/px_checkout/review/one_tap/offline_methods/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Payment Selection event
        "/px_checkout/payments/select_method/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/ticket/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/ticket/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/cards/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/cards/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Security code view:
        "/px_checkout/payments/select_method/credit_card/cvv/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/credit_card/cvv/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/debit_card/cvv/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/debit_card/cvv/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/prepaid_card/cvv/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/prepaid_card/cvv/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/security_code"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "mastercard"
            payment_method_type = "credit_card"
            card_id = "1234"
            issuer_id = "1234"
            bin = "123456"
            reason = "call_for_auth"
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/security_code/abort"(platform: "/mobile", type: TrackType.Event) {
            payment_method_id = "visa"
            payment_method_type = "credit_card"
            card_id = "1234"
            issuer_id = "123"
            bin = "654321"
            reason = "call_for_auth"
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/security_code/confirm"(platform: "/mobile", type: TrackType.Event) {
            payment_method_id = "visa"
            payment_method_type = "credit_card"
            card_id = "1234"
            issuer_id = "123"
            bin = "654321"
            reason = "call_for_auth"
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Card Form events:

        // Number:
        "/px_checkout/add_payment_method/number/recognized_card"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            payment_method_id = "visa"
        }

        "/px_checkout/add_payment_method/number/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/number/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Name:
        "/px_checkout/add_payment_method/credit_card/name/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/credit_card/name/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/debit_card/name/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/debit_card/name/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/prepaid_card/name/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/prepaid_card/name/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Date:
        "/px_checkout/add_payment_method/credit_card/expiration_date/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/credit_card/expiration_date/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/debit_card/expiration_date/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/debit_card/expiration_date/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/prepaid_card/expiration_date/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/prepaid_card/expiration_date/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // CVV:
        "/px_checkout/add_payment_method/credit_card/cvv/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/credit_card/cvv/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/debit_card/cvv/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/debit_card/cvv/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/prepaid_card/cvv/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/prepaid_card/cvv/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Documento:
        "/px_checkout/add_payment_method/credit_card/document/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/credit_card/document/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/debit_card/document/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/debit_card/document/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/prepaid_card/document/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/prepaid_card/document/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Terms and Conditions:
        "/px_checkout/add_payment_method/promotions/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/promotions/terms_and_conditions/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/terms_and_conditions/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Issuers:
        "/px_checkout/payments/card_issuer/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Installments:
        "/px_checkout/payments/installments/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Boleto:

        "/px_checkout/payments/select_method/ticket/cpf/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/ticket/cpf/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/ticket/name/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/ticket/name/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/ticket/lastname/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/ticket/lastname/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Revisa y confirma:
        "/px_checkout/review/traditional/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/review/traditional/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/review/traditional/change_payment_method"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Congrats:
        // Approved payment
        "/px_checkout/result/success/continue"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/success/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/success/tap_score"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/success/tap_discount_item"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            index = 1
            campaign_id = "1"
        }

        "/px_checkout/result/success/tap_see_all_discounts"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/success/tap_download_app"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/success/tap_cross_selling"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Unknown
          "/px_checkout/result/unknown/continue"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/unknown/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/unknown/tap_score"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/unknown/tap_discount_item"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            index = 1
            campaign_id = "1"
        }

        "/px_checkout/result/unknown/tap_see_all_discounts"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/unknown/tap_download_app"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/unknown/tap_cross_selling"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // In process payment
        "/px_checkout/result/further_action_needed/continue"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/further_action_needed/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/further_action_needed/tap_score"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/further_action_needed/tap_discount_item"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            index = 1
            campaign_id = "1"
        }

        "/px_checkout/result/further_action_needed/tap_see_all_discounts"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/further_action_needed/tap_download_app"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/further_action_needed/tap_cross_selling"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Rejected payment
        "/px_checkout/result/error/change_payment_method"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/error/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/error/remedy"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
              collector_id = 1234
              brand_name = "YPF"
              store_id = 1234
              pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            type = "cvv_request"
            extra_info = {
              payment_method_type = "credit_card"
              payment_method_id = "master"
            }
            index = 1
            payment_status = "rejected"
            payment_status_detail = "cc_rejected_other_reason"
        }

        // Approved business
        "/px_checkout/result/success/primary_action"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/success/secondary_action"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Unknown
        "/px_checkout/result/unknown/primary_action"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/unknown/secondary_action"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

         "/px_checkout/result/unknown/change_payment_method"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }


        // Pending business
        "/px_checkout/result/further_action_needed/primary_action"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/further_action_needed/secondary_action"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Rejected business
        "/px_checkout/result/error/primary_action"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/error/secondary_action"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/error/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/error/remedy"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
              collector_id = 1234
              brand_name = "YPF"
              store_id = 1234
              pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            type = "cvv_request"
            extra_info = {
              payment_method_type = "credit_card"
              payment_method_id = "master"
            }
            index = 1
            payment_status = "rejected"
            payment_status_detail = "cc_rejected_other_reason"
        }

        "/px_checkout/result/success/tap_view_receipt"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/further_action_needed/tap_view_receipt"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/unknown/tap_view_receipt"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/dialog/open"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            description = "suspended_account_money"
            actions = 2
        }

        "/px_checkout/dialog/dismiss"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            description = "suspended_account_money"
            actions = 2
        }

        "/px_checkout/dialog/action"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            description = "suspended_account_money"
            actions = 2
            type = "main_action"
            deepLink = "mercadopago://kyc/"
        }

        "/px_checkout/review/one_tap/offline_methods/start_kyc_flow"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/review/one_tap/target_behaviour"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            behaviour = "tap_pay"
            deepLink = "mercadopago://kyc/"
        }

        "/px_checkout/result/success/deep_link"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
              collector_id = 1234
              brand_name = "YPF"
              store_id = 1234
              pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            type = "money_split"
            deep_link = "mercadopago://mplayer/"
        }
    }

        test("PX - Payment-Congrats- Views") {
        //Payment Congrats:

        "/payment_congrats/result/success"(platform: "/mobile", type: TrackType.View) {
            style = "generic"
            payment_method_id = "redlink"
            payment_method_type = "atm"
            payment_id = 1234
            payment_status = "approved"
            payment_status_detail = "approved"

            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            discount_coupon_amount = 100
            preference_amount = 500
            total_amount = 500
            currency_id = "ARS"
            has_split_payment = false
            has_bottom_view = false
            has_top_view = false
            has_important_view = false
            has_money_split_view = true
            score_level = 5
            discounts_count = 6
            campaign_id = "10"
        }
        "/payment_congrats/result/unknown"(platform: "/mobile", type: TrackType.View) {
            style = "generic"
            payment_method_id = "redlink"
            payment_method_type = "atm"
            payment_id = 1234
            payment_status = "approved"
            payment_status_detail = "approved"

            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            preference_amount = 500
            total_amount = 500
            currency_id = "ARS"
            has_split_payment = false
            has_bottom_view = false
            has_top_view = false
            has_important_view = false
            has_money_split_view = false
            score_level = 5
            discounts_count = 6
            campaign_id = "10"
        }
        "/payment_congrats/result/further_action_needed"(platform: "/mobile", type: TrackType.View) {
            style = "generic"
            payment_method_id = "visa"
            payment_method_type = "credit_card"
            payment_id = 1234
            payment_status = "pending"
            payment_status_detail = "pending"
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            preference_amount = 500
            total_amount = 500
            currency_id = "ARS"
            has_split_payment = false
        }
        "/payment_congrats/result/error"(platform: "/mobile", type: TrackType.View) {
            style = "generic"
            payment_method_id = "visa"
            payment_method_type = "credit_card"
            payment_id = 1234
            payment_status = "rejected"
            payment_status_detail = "STATUS_DETAIL_REJECTED_REJECTED_BY_BANK"

            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            preference_amount = 500
            total_amount = 500
            currency_id = "ARS"
            has_split_payment = false
        }
    }
    test("PX - Payment-Congrats- Events") {
        // Approved payment
        "/payment_congrats/result/success/continue"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/success/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/success/tap_score"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/success/tap_discount_item"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            index = 1
            campaign_id = "1"
        }

        "/payment_congrats/result/success/tap_see_all_discounts"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/success/tap_download_app"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/success/tap_cross_selling"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // In process payment
        "/payment_congrats/result/further_action_needed/continue"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/further_action_needed/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/further_action_needed/tap_score"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/further_action_needed/tap_discount_item"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            index = 1
            campaign_id = "1"
        }

        "/payment_congrats/result/further_action_needed/tap_see_all_discounts"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/further_action_needed/tap_download_app"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/further_action_needed/tap_cross_selling"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Rejected payment
        "/payment_congrats/result/error/change_payment_method"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/error/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Approved business
        "/payment_congrats/result/success/primary_action"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/success/secondary_action"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Pending business
        "/payment_congrats/result/further_action_needed/primary_action"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/further_action_needed/secondary_action"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Rejected business
        "/payment_congrats/result/error/primary_action"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/error/secondary_action"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/success/tap_view_receipt"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/further_action_needed/tap_view_receipt"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/unknown/tap_view_receipt"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/unknown/abort"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

         "/payment_congrats/result/unknown/change_payment_method"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

         "/payment_congrats/result/unknown/continue"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
         "/payment_congrats/result/unknown/primary_action"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

         "/payment_congrats/result/unknown/secondary_action"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

         "/payment_congrats/result/unknown/tap_cross_selling"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

         "/payment_congrats/result/unknown/tap_discount_item"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            index = 1
            campaign_id = "1"
        }

         "/payment_congrats/result/unknown/tap_download_app"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

         "/payment_congrats/result/unknown/tap_score"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

         "/payment_congrats/result/unknown/tap_see_all_discounts"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/success/deep_link"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
              collector_id = 1234
              brand_name = "YPF"
              store_id = 1234
              pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            type = "money_split"
            deep_link = "mercadopago://mplayer/"
        }
      }

    defaultBusiness = "mercadopago"

    test("PX - views") {

        "/px_checkout/payments/select_method"(platform: "/mobile", type: TrackType.View) {
            available_methods = [
                    {
                        payment_method_type = "credit_card"
                        payment_method_id = "visa"
                        extra_info = {
                            selected_installment = null
                            card_id = "12345"
                            has_esc = true
                            issuer_id = 12
                        }
                    },
                    {
                        payment_method_type = "account_money"
                        payment_method_id = "account_money"
                        extra_info = {
                            balance = 12345
                            invested = true
                        }
                    },
                    {
                        payment_method_type = "credit_card"
                    }
            ]
            preference_amount = 1
            total_amount = 1            
            discount =
                    {
                        percent_off = 0.2
                        amount_off = 4
                        coupon_amount = 4
                        max_coupon_amount = 10
                        max_redeem_per_user = 1
                        campaign_id = 1
                        is_available = true

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
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            flow = "/instore"            
        }
        "/px_checkout/payments/select_method/ticket"(platform: "/mobile", type: TrackType.View) {
            available_methods = [
                    {
                        payment_method_id = "pagofacil"
                        payment_method_type = "ticket"
                        extra_info = null

                    },
                    {
                        payment_method_id = "rapipago"
                        payment_method_type = "ticket"
                        extra_info = null
                    }
            ]
            preference_amount = 1
            total_amount = 1            
            discount =
                    {
                        percent_off = 0.2
                        amount_off = 4
                        coupon_amount = 4
                        max_coupon_amount = 10
                        max_redeem_per_user = 1
                        campaign_id = 1
                        is_available = true
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
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/cards"(platform: "/mobile", type: TrackType.View) {
            available_methods = [
                    {
                        payment_method_type = "credit_card"
                    }
            ]
            preference_amount = 1
            total_amount = 500            
            discount =
                    {
                        percent_off = 0.2
                        amount_off = 4
                        coupon_amount = 4
                        max_coupon_amount = 10
                        max_redeem_per_user = 1
                        campaign_id = 1
                        is_available = true
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
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"

            collector_id = "12312412"
        }

        "/px_checkout/payments/applied_discount"(platform: "/mobile", type: TrackType.View) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }

            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"

            discount = {
                percent_off = 0.2
                amount_off = 4
                coupon_amount = 4
                max_coupon_amount = 10
                max_redeem_per_user = 1
                campaign_id = 1
                is_available = true
            }
        }

        "/px_checkout/payments/select_method/credit_card/cvv"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "mastercard"
            card_id = "1234"

            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            reason = "call_for_auth"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/payments/select_method/debit_card/cvv"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "mastercard"
            card_id = "1234"
            reason = "call_for_auth"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            flow = "/instore"
        }
        "/px_checkout/payments/select_method/prepaid_card/cvv"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "mastercard"
            card_id = "1234"

            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            reason = "call_for_auth"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/promotions"(platform: "/mobile", type: TrackType.View) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/promotions/terms_and_conditions"(platform: "/mobile", type: TrackType.View) {
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            flow = "/instore"
        }

        "/px_checkout/add_payment_method/number"(platform: "/mobile", type: TrackType.View) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/number/error_more_info"(platform: "/mobile", type: TrackType.View) {
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            flow = "/instore"
        }

        "/px_checkout/add_payment_method/credit_card/name"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "visa"
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/add_payment_method/debit_card/name"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "visa"
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/add_payment_method/prepaid_card/name"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "visa"
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/add_payment_method/credit_card/expiration_date"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "visa"
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/add_payment_method/debit_card/expiration_date"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "visa"
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/add_payment_method/prepaid_card/expiration_date"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "visa"
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/add_payment_method/credit_card/cvv"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "visa"
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/add_payment_method/debit_card/cvv"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "visa"
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/add_payment_method/prepaid_card/cvv"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "visa"
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/add_payment_method/credit_card/document"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "visa"
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/add_payment_method/debit_card/document"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "visa"
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/add_payment_method/prepaid_card/document"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "visa"

            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/card_issuer"(platform: "/mobile", type: TrackType.View) {
            payment_method_type = "credit_card"
            payment_method_id = "visa"
            available_banks = [
                    {
                        id = "bbva"
                        name = "BBVA Bancomer"
                    },
                    {
                        id = "banamex"
                        name = "Banamex"
                    }
            ]
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/installments"(platform: "/mobile", type: TrackType.View) {
            payment_method_type = "credit_card"
            payment_method_id = "visa"
            issuer_id = 1
            card_id = "1234"
            available_installments = [
                    {

                        quantity = 1
                        installment_amount = 200
                        visible_total_price = null
                        interest_rate = 10
                    },
                    {

                        quantity = 9
                        installment_amount = 31.10
                        visible_total_price = 279.85
                        interest_rate = 20
                    }
            ]
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"

        }

        "/px_checkout/payments/select_method/ticket/cpf"(platform: "/mobile", type: TrackType.View) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/payments/select_method/ticket/name"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "bolbradesco"
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/payments/select_method/ticket/lastname"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "bolbradesco"
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }


        "/px_checkout/review/traditional"(platform: "/mobile", type: TrackType.View) {
            payment_method_type = "credit_card"
            payment_method_id = "visa"
            extra_info = {
                issuer_id = 1
                card_id = "1234"
                has_esc = true
                selected_installment = {
                    quantity = 3
                    installment_amount = 137
                    interest_rate = 10
                    visible_total_price = 229
                }
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
            preference_amount = 200
            total_amount = 200            

            discount =
                    {
                        percent_off = 0.2
                        amount_off = 4
                        coupon_amount = 4
                        max_coupon_amount = 10
                        max_redeem_per_user = 1
                        campaign_id = 1
                        is_available = true
                    }
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            flow = "/instore"
        }

        "/px_checkout/payments/terms_and_conditions"(platform: "/mobile", type: TrackType.View) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }

            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            url = "https://www.mercadopago.com.ar/ayuda/terminos-y-condiciones_299"
        }

        // One tap + descuento
        "/px_checkout/review/one_tap"(platform: "/mobile", type: TrackType.View) {
            preference_amount = 700
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

            discount = {
                percent_off = 0.2
                amount_off = 4
                coupon_amount = 4
                max_coupon_amount = 10
                max_redeem_per_user = 1
                campaign_id = 1
                is_available = true
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
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
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

            preference_amount = 700
            total_amount = 700            
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
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/review/one_tap/offline_methods"(platform: "/mobile", type: TrackType.View) {
            available_methods = [
                    {
                        payment_method_type = "ticket"
                        payment_method_id = "rapipago"
                    },
                    {
                        payment_method_type = "bank_transfer"
                        payment_method_id = "redlink"
                    }

            ]

            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/review/one_tap/installments"(platform: "/mobile", type: TrackType.View) {
            payment_method_type = "credit_card"
            payment_method_id = "visa"
            issuer_id = 1
            card_id = "1234"
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
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"

        }

        "/px_checkout/review/one_tap/disabled_payment_method_detail"(platform: "/mobile", type: TrackType.View) {
            flow = "/instore"
        }

        "/px_checkout/payments/applied_discount"(platform: "/mobile", type: TrackType.View) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }

            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"

            discount = {
                percent_off = 0.2
                amount_off = 4
                coupon_amount = 4
                max_coupon_amount = 10
                max_redeem_per_user = 1
                campaign_id = 1
                is_available = true
            }
        }

        "/px_checkout/result/success"(platform: "/mobile", type: TrackType.View) {
            style = "generic"
            payment_method_id = "redlink"
            payment_method_type = "atm"
            payment_id = 1234
            payment_status = "approved"
            payment_status_detail = "approved"

            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            preference_amount = 500
            total_amount = 500            
            currency_id = "ARS"
            discount_coupon_amount = 100
            has_split_payment = false
            has_bottom_view = false
            has_top_view = false
            has_important_view = false
            has_money_split_view = true
            score_level = 5
            discounts_count = 6
            campaigns_ids = "1, 2, 3, 4, 5, 6"
            campaign_id = "10"
        }
        "/px_checkout/result/unknown"(platform: "/mobile", type: TrackType.View) {
            style = "generic"
            payment_method_id = "redlink"
            payment_method_type = "atm"
            payment_id = 1234
            payment_status = "approved"
            payment_status_detail = "approved"

            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            preference_amount = 500
            total_amount = 500
            currency_id = "ARS"
            discount_coupon_amount = 100
            has_split_payment = false
            has_bottom_view = false
            has_top_view = false
            has_important_view = false
            has_money_split_view = false
            score_level = 5
            discounts_count = 6
            campaigns_ids = "1, 2, 3, 4, 5, 6"
            campaign_id = "10"
        }
        "/px_checkout/result/further_action_needed"(platform: "/mobile", type: TrackType.View) {
            style = "generic"
            payment_method_id = "visa"
            payment_method_type = "credit_card"
            payment_id = 1234
            payment_status = "pending"
            payment_status_detail = "pending"
            extra_info = {
                issuer_id = 1
                card_id = "1234"
                has_esc = true
            }
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            preference_amount = 500
            total_amount = 500
            currency_id = "ARS"
            has_split_payment = false
            has_bottom_view = false
            has_top_view = false
            has_important_view = false
            has_money_split_view = false
        }
        "/px_checkout/result/error"(platform: "/mobile", type: TrackType.View) {
            style = "generic"
            payment_method_id = "visa"
            payment_method_type = "credit_card"
            payment_id = 1234
            payment_status = "rejected"
            payment_status_detail = "STATUS_DETAIL_REJECTED_REJECTED_BY_BANK"
            extra_info = {
                issuer_id = 1
                card_id = "1234"
                has_esc = true
            }

            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            preference_amount = 500
            total_amount = 500
            currency_id = "ARS"
            has_split_payment = false
            has_bottom_view = false
            has_top_view = false
            has_important_view = false
            has_money_split_view = false
            remedies = [ "cvv_request" ]
        }

        "/px_checkout/generic_error"(platform: "/mobile", type: TrackType.View) {
            error_message = "Hubo un error"
            api_error = {
                status = 400
                causes = [
                        {
                            code = "code"
                            description = "message"
                        }
                ]
                url = "get_preference"
                retry_available = true
            }
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            flow = "/instore"
        }


        // Unknown
          "/px_checkout/result/unknown/continue"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/unknown/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/unknown/tap_score"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/unknown/tap_discount_item"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            index = 1
            campaign_id = "1"
        }

        "/px_checkout/result/unknown/tap_see_all_discounts"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/unknown/tap_download_app"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/unknown/tap_cross_selling"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

             // Unknown
        "/px_checkout/result/unknown/primary_action"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
        "/px_checkout/result/unknown/secondary_action"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
         "/px_checkout/result/unknown/change_payment_method"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/card_association_result/success"(platform: "/mobile", type: TrackType.View) {
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            flow = "/instore"
        }
        "/px_checkout/card_association_result/error"(platform: "/mobile", type: TrackType.View) {
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            flow = "/instore"
        }
    }

    test("PX - Events") {

      "/px_checkout/review/one_tap/back"(platform: "/mobile", type: TrackType.Event) {
          flow_detail = {
              collector_id = 1234
              brand_name = "YPF"
              store_id = 1234
              pos_id = 1234
          }
          flow = "/instore"
          session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
      }

        "/px_checkout/review/one_tap/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/review/one_tap/swipe"(platform: "/mobile", type: TrackType.Event) {
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            flow = "/instore"
        }

        "/px_checkout/combo_switch"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            option_selected = "debit_card"
        }

        "/px_checkout/program_validation"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            validation_program_used = "STP"
        }

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
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            flow = "/instore"
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
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
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
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            flow = "/instore"
        }

        // Init event + pref id:
        "/px_checkout/init"(platform: "/mobile", type: TrackType.Event) {
            checkout_preference_id = "123"
            esc_enabled = true
            express_enabled = true
            split_enabled = false
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id="5ff342a5-1437-465e-a6ae-316cd780193a"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Init event:
        "/px_checkout/init"(platform: "/mobile", type: TrackType.Event) {
            checkout_preference = {
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
            esc_enabled = true
            express_enabled = true
            split_enabled = true
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Offline Payment Selection event
        "/px_checkout/review/one_tap/offline_methods/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Payment Selection event
        "/px_checkout/payments/select_method/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/ticket/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/ticket/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/cards/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/cards/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Security code view:
        "/px_checkout/payments/select_method/credit_card/cvv/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/credit_card/cvv/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/debit_card/cvv/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/debit_card/cvv/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/prepaid_card/cvv/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/prepaid_card/cvv/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/security_code"(platform: "/mobile", type: TrackType.View) {
            payment_method_id = "mastercard"
            payment_method_type = "credit_card"
            card_id = "1234"
            issuer_id = "1234"
            bin = "123456"
            reason = "call_for_auth"
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/security_code/abort"(platform: "/mobile", type: TrackType.Event) {
            payment_method_id = "visa"
            payment_method_type = "credit_card"
            card_id = "1234"
            issuer_id = "123"
            bin = "654321"
            reason = "call_for_auth"
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/security_code/confirm"(platform: "/mobile", type: TrackType.Event) {
            payment_method_id = "visa"
            payment_method_type = "credit_card"
            card_id = "1234"
            issuer_id = "123"
            bin = "654321"
            reason = "call_for_auth"
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Card Form events:

        // Number:
        "/px_checkout/add_payment_method/number/recognized_card"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            payment_method_id = "visa"
        }

        "/px_checkout/add_payment_method/number/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/number/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Name:
        "/px_checkout/add_payment_method/credit_card/name/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/credit_card/name/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/debit_card/name/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/debit_card/name/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/prepaid_card/name/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/prepaid_card/name/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Date:
        "/px_checkout/add_payment_method/credit_card/expiration_date/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/credit_card/expiration_date/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/debit_card/expiration_date/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/debit_card/expiration_date/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/prepaid_card/expiration_date/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/prepaid_card/expiration_date/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // CVV:
        "/px_checkout/add_payment_method/credit_card/cvv/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/credit_card/cvv/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/debit_card/cvv/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/debit_card/cvv/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/prepaid_card/cvv/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/prepaid_card/cvv/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Documento:
        "/px_checkout/add_payment_method/credit_card/document/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/credit_card/document/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/debit_card/document/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/debit_card/document/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/prepaid_card/document/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/prepaid_card/document/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Terms and Conditions:
        "/px_checkout/add_payment_method/promotions/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/add_payment_method/promotions/terms_and_conditions/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/terms_and_conditions/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Issuers:
        "/px_checkout/payments/card_issuer/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Installments:
        "/px_checkout/payments/installments/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Boleto:

        "/px_checkout/payments/select_method/ticket/cpf/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/ticket/cpf/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/ticket/name/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/ticket/name/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/ticket/lastname/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/payments/select_method/ticket/lastname/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Revisa y confirma:
        "/px_checkout/review/traditional/back"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/review/traditional/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/review/traditional/change_payment_method"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Congrats:
        // Approved payment
        "/px_checkout/result/success/continue"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/success/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/success/tap_score"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/success/tap_discount_item"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            index = 1
            campaign_id = "1"
        }

        "/px_checkout/result/success/tap_see_all_discounts"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/success/tap_download_app"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/success/tap_cross_selling"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // In process payment
        "/px_checkout/result/further_action_needed/continue"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/further_action_needed/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/further_action_needed/tap_score"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/further_action_needed/tap_discount_item"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            index = 1
            campaign_id = "1"
        }

        "/px_checkout/result/further_action_needed/tap_see_all_discounts"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/further_action_needed/tap_download_app"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/further_action_needed/tap_cross_selling"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Rejected payment
        "/px_checkout/result/error/change_payment_method"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/error/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/error/remedy"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
              collector_id = 1234
              brand_name = "YPF"
              store_id = 1234
              pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            type = "cvv_request"
            extra_info = {
              payment_method_type = "credit_card"
              payment_method_id = "master"
            }
            index = 1
            payment_status = "rejected"
            payment_status_detail = "cc_rejected_other_reason"
        }

        // Approved business
        "/px_checkout/result/success/primary_action"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/success/secondary_action"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Pending business
        "/px_checkout/result/further_action_needed/primary_action"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/further_action_needed/secondary_action"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Rejected business
        "/px_checkout/result/error/primary_action"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/error/secondary_action"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/success/tap_view_receipt"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/further_action_needed/tap_view_receipt"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/result/unknown/tap_view_receipt"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/dialog/open"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            description = "suspended_account_money"
            actions = 2
        }

        "/px_checkout/dialog/dismiss"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            description = "suspended_account_money"
            actions = 2
        }

        "/px_checkout/dialog/action"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            description = "suspended_account_money"
            actions = 2
            type = "main_action"
            deepLink = "mercadopago://kyc/"
        }

        "/px_checkout/review/one_tap/offline_methods/start_kyc_flow"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/px_checkout/review/one_tap/target_behaviour"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            behaviour = "tap_pay"
            deepLink = "mercadopago://kyc/"
        }

        "/px_checkout/result/success/deep_link"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
              collector_id = 1234
              brand_name = "YPF"
              store_id = 1234
              pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            type = "money_split"
            deep_link = "mercadopago://mplayer/"
        }
    }
    test("PX - Payment-Congrats- Views") {
        //Payment Congrats:

        "/payment_congrats/result/success"(platform: "/mobile", type: TrackType.View) {
            style = "generic"
            payment_method_id = "redlink"
            payment_method_type = "atm"
            payment_id = 1234
            payment_status = "approved"
            payment_status_detail = "approved"

            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            preference_amount = 500
            total_amount = 500
            currency_id = "ARS"
            has_split_payment = false
            has_bottom_view = false
            has_top_view = false
            has_important_view = false
            has_money_split_view = true
            score_level = 5
            discounts_count = 6
            campaign_id = "10"
        }
        "/payment_congrats/result/unknown"(platform: "/mobile", type: TrackType.View) {
            style = "generic"
            payment_method_id = "redlink"
            payment_method_type = "atm"
            payment_id = 1234
            payment_status = "approved"
            payment_status_detail = "approved"

            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            preference_amount = 500
            total_amount = 500
            currency_id = "ARS"
            has_split_payment = false
            has_bottom_view = false
            has_top_view = false
            has_important_view = false
            has_money_split_view = false
            score_level = 5
            discounts_count = 6
            campaign_id = "10"
        }
        "/payment_congrats/result/further_action_needed"(platform: "/mobile", type: TrackType.View) {
            style = "generic"
            payment_method_id = "visa"
            payment_method_type = "credit_card"
            payment_id = 1234
            payment_status = "pending"
            payment_status_detail = "pending"
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            preference_amount = 500
            total_amount = 500
            currency_id = "ARS"
            has_split_payment = false
        }
        "/payment_congrats/result/error"(platform: "/mobile", type: TrackType.View) {
            style = "generic"
            payment_method_id = "visa"
            payment_method_type = "credit_card"
            payment_id = 1234
            payment_status = "rejected"
            payment_status_detail = "STATUS_DETAIL_REJECTED_REJECTED_BY_BANK"

            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            preference_amount = 500
            total_amount = 500
            currency_id = "ARS"
            has_split_payment = false
        }
    }
    test("PX - Payment-Congrats- Events") {
        // Approved payment
        "/payment_congrats/result/success/continue"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/success/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/success/tap_score"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/success/tap_discount_item"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            index = 1
            campaign_id = "1"
        }

        "/payment_congrats/result/success/tap_see_all_discounts"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/success/tap_download_app"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/success/tap_cross_selling"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // In process payment
        "/payment_congrats/result/further_action_needed/continue"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/further_action_needed/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/further_action_needed/tap_score"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/further_action_needed/tap_discount_item"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            index = 1
            campaign_id = "1"
        }

        "/payment_congrats/result/further_action_needed/tap_see_all_discounts"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/further_action_needed/tap_download_app"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/further_action_needed/tap_cross_selling"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Rejected payment
        "/payment_congrats/result/error/change_payment_method"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/error/abort"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Approved business
        "/payment_congrats/result/success/primary_action"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/success/secondary_action"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Pending business
        "/payment_congrats/result/further_action_needed/primary_action"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/further_action_needed/secondary_action"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        // Rejected business
        "/payment_congrats/result/error/primary_action"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/error/secondary_action"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
                collector_id = 1234
                brand_name = "YPF"
                store_id = 1234
                pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/success/tap_view_receipt"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/further_action_needed/tap_view_receipt"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/unknown/tap_view_receipt"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/unknown/abort"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

         "/payment_congrats/result/unknown/change_payment_method"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

         "/payment_congrats/result/unknown/continue"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }
         "/payment_congrats/result/unknown/primary_action"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

         "/payment_congrats/result/unknown/secondary_action"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

         "/payment_congrats/result/unknown/tap_cross_selling"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

         "/payment_congrats/result/unknown/tap_discount_item"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            index = 1
            campaign_id = "1"
        }

         "/payment_congrats/result/unknown/tap_download_app"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

         "/payment_congrats/result/unknown/tap_score"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

         "/payment_congrats/result/unknown/tap_see_all_discounts"(platform: "/mobile", type: TrackType.Event) {
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
        }

        "/payment_congrats/result/success/deep_link"(platform: "/mobile", type: TrackType.Event) {
            flow_detail = {
              collector_id = 1234
              brand_name = "YPF"
              store_id = 1234
              pos_id = 1234
            }
            flow = "/instore"
            session_id = "5ff342a5-1437-465e-a6ae-316cd780193"
            type = "money_split"
            deep_link = "mercadopago://mplayer/"
        }
      }

}
