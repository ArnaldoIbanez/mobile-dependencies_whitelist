    
import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"
    
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS MYML Invoices
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Create invoice flow items") {
        "/myml/invoices/review"(platform: "/") {}
        "/myml/invoices/review/create_invoice"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/items/review"(platform: "/") {}
        "/myml/invoices/items/review/save/request"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/items/review/save/response"(platform: "/", type: TrackType.Event) {
            error = "Não conseguimos processar a sua solicitação. Tente Novamente"
        }
        "/myml/invoices/review/help_tooltip"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/items/origin"(platform: "/") {}
        "/myml/invoices/items/origin/help_tooltip"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/items/origin/save/request"(platform: "/", type: TrackType.Event) {
            item_id = "MLB989120833"
            data = {
                origin_detail = "4"
            }
            variationId = "1231"
        }
        "/myml/invoices/items/origin/save/response"(platform: "/", type: TrackType.Event) {
            error = "Não conseguimos processar a sua solicitação. Tente Novamente"
        }
        "/myml/invoices/items/sku"(platform: "/") {}
        "/myml/invoices/items/sku/help_tooltip"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/items/sku/save/request"(platform: "/", type: TrackType.Event) {
            item_id = "MLB989120833"
            sku = "123"
            variationId = null
        }
        "/myml/invoices/items/sku/save/response"(platform: "/", type: TrackType.Event) {
            error = "Não conseguimos processar a sua solicitação. Tente Novamente"
            errorValidation = "O SKU não pode ser vazio"
        }
        "/myml/invoices/items/csosn"(platform: "/") {}
        "/myml/invoices/items/csosn/help_tooltip"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/items/csosn/save/request"(platform: "/", type: TrackType.Event) {
             data = {
                icms_simples = '102'
                itemId = "MLB989120833"
            }
            url = "https://myaccount.mercadolivre.com.br/invoices-app/review"
        }
        "/myml/invoices/items/csosn/save/response"(platform: "/", type: TrackType.Event) {
            error = "Não conseguimos processar a sua solicitação. Tente Novamente"
        }
        "/myml/invoices/items/ean"(platform: "/") {}
        "/myml/invoices/items/ean/help_tooltip"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/items/ean/save/request"(platform: "/", type: TrackType.Event) {
            item_id = "123123"
            data = {
                disabled = false
                ean = "0604095564050"
                meliItemId = "123123"
                variaTionId = 23194473639
            }
        }
        "/myml/invoices/items/ean/save/response"(platform: "/", type: TrackType.Event) {
            url = "https://myaccount.mercadolivre.com.br/invoices-app/review"
            error = "Não conseguimos processar a sua solicitação. Tente Novamente"
        }
        "/myml/invoices/items/ean/validate"(platform: "/", type: TrackType.Event) {
            ean = "1232"
            errorValidation = "O código de EAN precisa ter entre 8 e 14 dígitos"
        }

        "/myml/invoices/items/product-type"(platform: "/") {}
        "/myml/invoices/items/product-type/help_tooltip"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/items/product-type/save/request"(platform: "/", type: TrackType.Event) {
            item_id = "123123"
            data = {
                origin_type = 'Revendedor'
                origin_detail = '1'
            }
            url = "/invoices/items/MLB1017715653/ncm?orderId=1692199884"
            variationId = null
        }
         "/myml/invoices/items/product-type/save/response"(platform: "/", type: TrackType.Event) {
            error = "Não conseguimos processar a sua solicitação. Tente Novamente"
        }

        "/myml/invoices/items/ncm"(platform: "/") {}
        "/myml/invoices/items/ncm/help_tooltip"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/items/ncm/save/request"(platform: "/", type: TrackType.Event) {
            item_id = "MLB1020221729"
            data = {
                ncm = "84011000"
            }
            variationId = "12313"
        }
        "/myml/invoices/items/ncm/save/response"(platform: "/", type: TrackType.Event) {
            error = "Não conseguimos processar a sua solicitação. Tente Novamente"
        }
        "/myml/invoices/items/ncm/search/request"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/items/ncm/search/response"(platform: "/", type: TrackType.Event) {
             data = {
                ncm = "84011000"
            }

            error = "Não conseguimos processar a sua solicitação. Tente Novamente"
        }
    }

    test("Sales list flow") {
        "/myml/invoices/sales_list/create_invoice"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/sales_list/zip"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/sales_list/zip/download"(platform: "/", type: TrackType.Event) {
            pdf = true
        }
    }

    test("Company info export invoice") {
        "/myml/invoices/company-info/zip"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/zip/download"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/zip/download/response"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/zip/download/request"(platform: "/", type: TrackType.Event) {
            pdf = true
            month = 5
            year = 2018
        }
    }

    test("V2 sku pages") {
        "/myml/invoices/sku/sku"(platform: "/") {}
        "/myml/invoices/sku/sku/save/request"(platform: "/", type: TrackType.Event) {
            item_id = "MLB989120833"
            kit = false
            sku = "MLB1064414806"
            redirect_to = '/invoices/sku/review/123'
            variation_id = null
        }
        "/myml/invoices/sku/sku/save/response"(platform: "/", type: TrackType.Event) {
            message = "Não conseguimos processar a sua solicitação. Tente Novamente"
            success = false
            sku_invalid = true
            redirect_to = '/invoices/sku/review/MLB1064414806'
        }

        "/myml/invoices/sku/ean"(platform: "/") {}
        "/myml/invoices/sku/ean/save/request"(platform: "/", type: TrackType.Event) {
            item_id = "MLB989120833"
            ean = "7898357410015"
            redirect_to = '/invoices/sku/review/123'
            variation_id = null
        }
        "/myml/invoices/sku/ean/save/response"(platform: "/", type: TrackType.Event) {
            message = "Não conseguimos processar a sua solicitação. Tente Novamente"
            success = false
            ean_invalid = true
            redirect_to = '/invoices/sku/review/123'
        }

        "/myml/invoices/sku/ncm"(platform: "/") {}
        "/myml/invoices/sku/ncm/save/request"(platform: "/", type: TrackType.Event) {
            item_id = "MLB989120833"
            ncm = "84716052"
            redirect_to = '/invoices/sku/review/123'
            variation_id = '123'
        }
        "/myml/invoices/sku/ncm/save/response"(platform: "/", type: TrackType.Event) {
            message = "Não conseguimos processar a sua solicitação. Tente Novamente"
            success = false
            redirect_to = '/invoices/sku/review/123'
        }
    }

    test("Optin flow") {
        "/myml/invoices/landing"(platform: "/") {}
        "/myml/invoices/landing/optin"(platform: "/", type: TrackType.Event) {
            type = "top"
        }
        "/myml/invoices/company-info/certificate"(platform: "/") {}
        "/myml/invoices/company-info/certificate/help_tooltip"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/certificate/a1"(platform: "/") {}
        "/myml/invoices/company-info/certificate/a1/help_tooltip"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/certificate/a1/save/request"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/certificate/a1/save/response"(platform: "/", type: TrackType.Event) {
            error = "password"
            message = "Password incorrect!"
        }
        "/myml/invoices/company-info/certificate/a3"(platform: "/") {}
        "/myml/invoices/company-info/certificate/a3/handshake/request"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/certificate/a3/handshake/response"(platform: "/", type: TrackType.Event) {
            data = {
                id = 12
                registration_date = 1525439080000
                certificate_expiration_date = 1594575899000
                certificate_serial_number = 154511657922040129596322265878669116287
            }
        }
        "/myml/invoices/company-info/serie"(platform: "/") {}
        "/myml/invoices/company-info/serie/help_tooltip"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/serie/save/request"(platform: "/", type: TrackType.Event) {
            serie = 3
            url = "/invoices/company-info/confirm"
        }
        "/myml/invoices/company-info/serie/save/response"(platform: "/", type: TrackType.Event) {
            error = "Não conseguimos processar a sua solicitação. Tente Novamente"
            errorValidation = "O número de série não pode ser vazio"
        }
        "/myml/invoices/company-info/cst"(platform: "/") {}
        "/myml/invoices/company-info/cst/help_tooltip"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/cst/save/request"(platform: "/", type: TrackType.Event) {
            data = {
                IPI = "53"
                PIS = "07"
                COFINS = "07"
            }
            url = "/invoices/company-info/confirm"
        }
        "/myml/invoices/company-info/cst/save/response"(platform: "/", type: TrackType.Event) {
            error = "Não conseguimos processar a sua solicitação. Tente Novamente"
        }
        "/myml/invoices/company-info/csosn"(platform: "/") {}
        "/myml/invoices/company-info/csosn/help_tooltip"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/csosn/save/request"(platform: "/", type: TrackType.Event) {
            code = "500"
        }
        "/myml/invoices/company-info/csosn/save/response"(platform: "/", type: TrackType.Event) {
            code = "500"
            error = "Não conseguimos processar a sua solicitação. Tente Novamente"
        }
        "/myml/invoices/company-info/ie"(platform: "/") {}
        "/myml/invoices/company-info/ie/save/request"(platform: "/", type: TrackType.Event) {
             data = "492875457119"
        }
        "/myml/invoices/company-info/ie/save/response"(platform: "/", type: TrackType.Event) {
            error = "Não conseguimos processar a sua solicitação. Tente Novamente"
        }
        "/myml/invoices/company-info/confirm"(platform: "/") {}
        "/myml/invoices/company-info/confirm/save/request"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/confirm/save/response"(platform: "/", type: TrackType.Event) {
            error = "Não conseguimos processar a sua solicitação. Tente Novamente"
        }
        "/myml/invoices/company-info/success"(platform: "/") {}
    }

    test("Order pages") {
        "/myml/invoices/order/buyer-info"(platform: "/") {}
        "/myml/invoices/order/buyer-info/save/request"(platform: "/", type: TrackType.Event) {
            data = {
                receiver_address = {
                    isValid = true
                }
                billing_info = {
                    stateRegistry = ""
                    name = "Test"
                }
                order_id = 1709201434
            }
            url = "/invoices/order/1709201434"
        }
        "/myml/invoices/order/buyer-info/save/response"(platform: "/", type: TrackType.Event) {
            error = "Não conseguimos processar a sua solicitação. Tente Novamente"
        }
        "/myml/invoices/order/carrier"(platform: "/") {}
         "/myml/invoices/order/carrier/save/request"(platform: "/", type: TrackType.Event) {
            data = {
                volumes = 1231
                cost = "123123"
                name = "Teste"
                saved_by_seller = true
                paid_by = "recipient"
             }
             url = "/invoices/order/1709201434"
        }
        "/myml/invoices/order/carrier/save/response"(platform: "/", type: TrackType.Event) {
            error = "Não conseguimos processar a sua solicitação. Tente Novamente"
        }
    }


    test("MyML Cart") {

        def dataSet = {

            seller = [
                    [id: "208642594", nickname: "TESTEO_1", mercado_lider: "platinum", raputation_level: "5_green"],
                    [id: "987398333", nickname: "TESTEO_2", mercado_lider: "gold", raputation_level: "4_green"]
            ]

            buyer = [
                    [id: "208642594", nickname: "TESTEO_1", loyalty_level: "4"]
            ]

            CartContent = "Yes"
            cart_content = "No"
            purchase_status = "Paid"
            PurchaseStatus = "Paid"

        }

        "/myml/sales/list"(platform: "/web", type: TrackType.Event) {}

        "/myml/sales/vop"(platform: "/web", type: TrackType.Event) {}

        "/myml/sales/status"(platform: "/web") {}

        "/myml/sales/status/call_to_carrier"(platform: "/web") {}

        "/myml/sales/status/pack_tutorial"(platform: "/web") {}

        "/myml/sales/detail/pack_tutorial"(platform: "/web") {}

        "/myml/sales/detail"(platform: "/web") {}

        "/myml/sales/detail/refund_money"(platform: "/web") {}

        "/myml/sales/detail/print_label"(platform: "/web") {}

        "/myml/sales/order"(platform: "/web") {}

        "/myml/sales/shipping_detail"(platform: "/web") {}

        "/myml/sales/messages"(platform: "/web") {}

        "/myml/sales/questions"(platform: "/web") {}

        "/myml/sales/shipping" (platform:"/", type: TrackType.View) {
            dataSet()
        }

        "/myml/sales/buyer"(platform:"/", type: TrackType.View) {
            dataSet()
        }

        "/myml/sales/item"(platform:"/", type: TrackType.View) {
            dataSet()
        }

        "/myml/purchases/list"(platform: "/web") {}

        "/myml/purchases/list/returns_action"(platform: "/web", type: TrackType.Event) {
            action = 'print_return_label'
        }

        "/myml/purchases/vop"(platform: "/web") {}

        "/myml/purchases/vop/returns_action"(platform: "/web", type: TrackType.Event) {
            action = 'print_return_label'
        }

        "/myml/purchases/detail"(platform: "/web") {}

        "/myml/purchases/detail/delete_purchase"(platform: "/web") {}

        "/myml/purchases/detail/what_do_if_i_pay"(platform: "/web") {}

        "/myml/purchases/detail/call_to_carrier"(platform: "/web") {}

        "/myml/purchases/print_label"(platform: "/web") {}

        "/myml/purchases/print_label/show_stores_map"(platform: "/web") {}

        "/myml/purchases/shipping_detail"(platform: "/web") {}

        "/myml/purchases/shipping_detail/refund_details"(platform: "/web") {}

        "/myml/purchases/messages"(platform: "/web") {}

        "/myml/purchases/questions"(platform: "/web") {}

        "/myml/purchases/canceled"(platform:"/") {}

        "/myml/purchases/order"(platform:"/") {}

        "/myml/purchases/detail/history"(platform:"/") {}

        "/myml/purchases/status" (platform:"/", type: TrackType.View) {
            dataSet()
        }

        "/myml/purchases/item" (platform:"/", type: TrackType.View) {
            dataSet()
        }

        "/myml/purchases/seller" (platform:"/", type: TrackType.View) {
            dataSet()
        }

        "/myml/purchases/shipping" (platform:"/", type: TrackType.View) {
            dataSet()
        }

        "/myml/loyal_discounts" (platform: "/", type: TrackType.View) {}
        "/myml/loyal_discounts/add" (platform: "/web", type: TrackType.Event) {
            item = {
                id = 'MLA713079054'
                price = '300'
                original_price = '1000'
                sale_terms = [
                        {
                            id = "LOYALTY_LEVEL_6"
                            name = "Precio por nivel 6 de loyalty"
                            value_id = null
                            value_name = "25 ARS"
                            value_struct = {
                                number = 25
                                unit = "ARS"
                            }
                        },
                        {
                            id = "LOYALTY_LEVEL_5"
                            name = "Precio por nivel 5 de loyalty"
                            value_id = null
                            value_name = "25 ARS"
                            value_struct = {
                                number = 25
                                unit = "ARS"
                            }
                        },
                        {
                            id = "LOYALTY_LEVEL_4"
                            name = "Precio por nivel 4 de loyalty"
                            value_id = null
                            value_name = "25 ARS"
                            value_struct = {
                                number = 25
                                unit = "ARS"
                            }
                        },
                        {
                            id = "LOYALTY_LEVEL_3"
                            name = "Precio por nivel 3 de loyalty"
                            value_id = null
                            value_name = "25 ARS"
                            value_struct = {
                                number = 25
                                unit = "ARS"
                            }
                        }
                ]
            }
            percentage = 70
            type = "LOW_LOYAL"
        }
        "/myml/loyal_discounts/delete" (platform: "/", type: TrackType.Event) {
            item_id = 'MLA713079054'
            type = "HIGH_LOYAL"
        }


    }


    test("Myml listing active view"){
        "/myml/listings"(platform: "/web"){
            label = "active"
        }
        "/myml/bookmarks"(platform: "/web"){}
        "/myml/questions"(platform: "/web"){}
        "/myml/summary"(platform: "/web"){}
    }

    test("Myml My Data"){
        "/myml/profile"(platform: "/mobile"){}
        "/myml/profile/review_data"(platform: "/mobile"){}
        "/myml/profile/complete_data"(platform: "/mobile"){}
        "/myml/profile/update_form"(platform: "/mobile"){
            has_inferred_data = true
        }
        "/myml/profile/update_success"(platform: "/mobile"){}
        "/myml/profile/review_data/confirm"(platform: "/mobile"){}
        "/myml/company_profile"(platform: "/mobile"){}
        "/myml/fiscal_data_edit"(platform: "/mobile"){}
    }

    test("Myml Suggested Discounts"){
        "/myml/suggested_discounts/landing"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/landing/about"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/landing/start"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/landing/back"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/landing/abandon"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/about"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/about/skip"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/about/start"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/about/abandon"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/about/back"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/select_discount"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/select_discount/apply"(platform: "/mobile"){
            item_id = "MLA123456"
            selected_discount = "1"
        }
        "/myml/suggested_discounts/review_discount"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/review_discount/confirm"(platform: "/mobile"){
            item_id = "MLA123456"
            selected_discount = "1"
        }
        "/myml/suggested_discounts/select_discount/back"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/review_discount/back"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/info"(platform: "/mobile"){
            item_id = "MLA123456"
            discount_status = "on_deal"
        }
        "/myml/suggested_discounts/info/exit"(platform: "/mobile"){
            item_id = "MLA123456"
            discount_status = "on_deal"
            action = "vip"
        }
        "/myml/suggested_discounts/info/back"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/error"(platform: "/mobile"){item_id = "MLA123456"}
        "/myml/suggested_discounts/error/back"(platform: "/mobile"){item_id = "MLA123456"}
    }

    test("Myml account balance") {
        "/myml/account_balance"(platform: "/mobile", type: TrackType.View) {}
        "/myml/account_balance/withdraw"(platform: "/mobile", type: TrackType.Event) {
            mp_installed = true
        }
        "/myml/account_balance/send_money"(platform: "/mobile", type: TrackType.Event) {
            mp_installed = true
        }
        "/myml/account_balance/cellphone_recharge"(platform: "/mobile", type: TrackType.Event) {
            mp_installed = true
        }
        "/myml/account_balance/bill_payments"(platform: "/mobile", type: TrackType.Event) {
            mp_installed = true
        }
        "/myml/account_balance/generic_error"(platform: "/mobile", type: TrackType.View) {
            additional_info = {message="Escanear código QR"
                icon="error"
                description="Solo puedes pagar usando códigos de Mercado Pago"
                message="¿Estas seguro que ese código es para pagar?"
                actions=[{
                             id="try_again"
                             link="meli://mp/scan_qr"
                             label="Intentar nuevamente"
                             type="link"
                         }]}
        }
        "/myml/account_balance/scan_qr"(platform: "/mobile", type: TrackType.View) {}
    }

    test("MyMl new reputation flow seller") {
        "/myml/sales/detail/flow_selector"(platform: "/mobile", type: TrackType.View) {
            flow_selected = "MPA and not ME"
        }
        "/myml/sales/detail/deliver_product"(platform: "/mobile", type: TrackType.View) {}
        "/myml/sales/detail/deliver_product#submit"(platform: "/mobile", type: TrackType.Event) {
            action_label = "send_feedback"
        }
        "/myml/sales/detail/date_will_receive_product"(platform: "/mobile", type: TrackType.View) {}
        "/myml/sales/detail/deliver_product/action"(platform: "/mobile", type: TrackType.Event) {
            action_label = "send_feedback"
            order_id = "12344"
            shipping_id = "1234"
            success = false
        }
        "/myml/sales/detail/send_feedback"(platform: "/mobile", type: TrackType.Event) {
            order_id = "1234"
            success = true
        }
    }

    test("MyMl new reputation flow buyer") {
        "/myml/purchases/feedback/rating"(platform: "/mobile", type: TrackType.View) {}

        "/myml/purchases/feedback/message"(platform: "/mobile", type: TrackType.View) {}

        "/myml/purchases/feedback/congrats"(platform: "/mobile", type: TrackType.View) {}

        "/myml/purchases/feedback/congrats#action"(platform: "/mobile", type: TrackType.Event) {
            target = "meli://home"
        }

        "/myml/purchases/feedback/error"(platform: "/mobile", type: TrackType.View) {}
    }

    test("Myml installation") {
        "/myml/account_balance/install"(platform: "/mobile", type: TrackType.View) {}
        "/myml/account_balance/install/go_to_store"(platform: "/mobile", type: TrackType.Event) {}
    }
    test("Myml invoices preferences"){
        "/myml/sales/list/set_user_fiscal_order_action"(platform: "/web", type: TrackType.Event) {
            option = "add_fiscal_data"
        }
    }
}
