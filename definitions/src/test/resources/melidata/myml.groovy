package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"
    
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS MYML Invoices
    //------------------------------------------------------------------------------------------------------------------------------------------------------
       
    test("Sales list flow") {
        "/myml/invoices/sales_list/create_invoice"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/sales_list/zip"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/sales_list/zip/download"(platform: "/", type: TrackType.Event) {
            pdf = true
        }
    }

    test("Message") {
        "/myml/invoices/error"(platform: "/") {
            error = "not_right_tax_regime"
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

        "/myml/invoices/sku/product-origin"(platform: "/") {}
        "/myml/invoices/sku/product-origin/save/request"(platform: "/", type: TrackType.Event) {
            item_id = "MLB989120833"
            code = "1"
            origin_discrimination = "NATIONAL"
            redirect_to = '/invoices/sku/review/123'
            variation_id = null
        }
        "/myml/invoices/sku/product-origin/save/response"(platform: "/", type: TrackType.Event) {
            message = "Não conseguimos processar a sua solicitação. Tente Novamente"
            success = false
            redirect_to = '/invoices/sku/review/123'
        }

        "/myml/invoices/sku/product-type"(platform: "/") {}
        "/myml/invoices/sku/product-type/save/request"(platform: "/", type: TrackType.Event) {
            item_id = "MLB989120833"
            code = "1"
            redirect_to = '/invoices/sku/review/123'
            variation_id = null
        }
        "/myml/invoices/sku/product-type/save/response"(platform: "/", type: TrackType.Event) {
            message = "Não conseguimos processar a sua solicitação. Tente Novamente"
            success = false
            redirect_to = '/invoices/sku/review/123'
        }

        "/myml/invoices/sku/csosn"(platform: "/") {}
        "/myml/invoices/sku/csosn/save/request"(platform: "/", type: TrackType.Event) {
            item_id = "MLB989120833"
            csosn = "5"
            redirect_to = '/invoices/sku/review/123'
            variation_id = null
        }
        "/myml/invoices/sku/csosn/save/response"(platform: "/", type: TrackType.Event) {
            message = "Não conseguimos processar a sua solicitação. Tente Novamente"
            success = false
            redirect_to = '/invoices/sku/review/123'
        }

        "/myml/invoices/sku/review"(platform: "/") {}
        "/myml/invoices/sku/review/help_tooltip"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/sku/review/confirm/request"(platform: "/", type: TrackType.Event) {
            order_id = "MLB989120833"
            comments = "Comments test"
        }
        "/myml/invoices/sku/review/confirm/response"(platform: "/", type: TrackType.Event) {
            message = "Não conseguimos processar a sua solicitação. Tente Novamente"
            error_type = "message"
            error = false
            redirect_to = '/invoices/sku/review/123'
        }

        "/myml/invoices/sku/status"(platform: "/") {}
    }

    test("Optin flow") {
        "/myml/invoices/not-found"(platform: "/") {}
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
        "/myml/invoices/company-info/certificate/a3/handshake/request"(platform: "/", type: TrackType.Event) {
            cnpj = "212121210000155"
            certificateId = 1412444
            callback = "https://www.mercadolivre.com.br"
            editing = true
        }
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
            callback = "https://www.mercadolivre.com.br"
            editing = true
        }
        "/myml/invoices/company-info/serie/save/response"(platform: "/", type: TrackType.Event) {
            error = "Não conseguimos processar a sua solicitação. Tente Novamente"
            errorValidation = "O número de série não pode ser vazio"
            url = "/invoices/company-info/confirm"
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
            editing = true
            callback = "https://www.mercadolivre.com.br"
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
        "/myml/invoices/company-info/ie/save/request"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/ie/save/response"(platform: "/", type: TrackType.Event) {
            error = "Não conseguimos processar a sua solicitação. Tente Novamente"
        }
        "/myml/invoices/company-info/confirm"(platform: "/") {
          source = 'fiscalData'
          campaign = 'adp_xd'
        }
        "/myml/invoices/company-info/confirm/save/request"(platform: "/", type: TrackType.Event) {
            enabled_for_fulfillment = true
            tax_payer_type = "Regime Normal"
            certificate_type = "A1"

        }
        "/myml/invoices/company-info/confirm/save/response"(platform: "/", type: TrackType.Event) {
            error = "Não conseguimos processar a sua solicitação. Tente Novamente"
        }
        "/myml/invoices/company-info/confirm/help_tooltip/serie"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/confirm/help_tooltip/freight"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/confirm-normal"(platform: "/") {
          source = 'fiscalData'
          campaign = 'adp_xd'
        }
        "/myml/invoices/company-info/confirm-normal/save/request"(platform: "/", type: TrackType.Event) {
            serie = 5
            include_freight = true
            url = "/sales/list"
            callback = "https://www.mercadolivre.com.br"

        }
        "/myml/invoices/company-info/confirm-normal/save/response"(platform: "/", type: TrackType.Event) {
            error = "Não conseguimos processar a sua solicitação. Tente Novamente"
        }
        "/myml/invoices/company-info/confirm-normal/help_tooltip"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/confirm-normal/help_tooltip/freight"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/confirm-normal/help_tooltip/serie"(platform: "/", type: TrackType.Event) {}

        "/myml/invoices/company-info/include-freight"(platform: "/") {}
        "/myml/invoices/company-info/include-freight/help_tooltip"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/include-freight/save/request"(platform: "/", type: TrackType.Event) {
            code = "true"
            url = "/invoices/company-info/confirm"
            callback = ""
            editing = true
        }
        "/myml/invoices/company-info/include-freight/save/response"(platform: "/", type: TrackType.Event) {
            success = true
            message = "Não conseguimos processar a sua solicitação. Tente Novamente"
        }
        "/myml/invoices/company-info/success"(platform: "/") {}
        "/myml/invoices/company-info/tax-rules-information"(platform: "/") {}
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

    test("Backoffice pages") {
        "/myml/invoices/backoffice/search/invoice"(platform: "/", type: TrackType.Event) {
            search_filter = {
                invoiceNumber = 234
            }
        }

        "/myml/invoices/backoffice/search/reissueinvoice"(platform: "/", type: TrackType.Event) {
             data = {
                invoiceId = 123123
            }
        }

        "/myml/invoices/backoffice/search/invoiceslist"(platform: "/", type: TrackType.Event) {
             search_filter = {
                recipientCnpj = 123123
            }
        }
    }

    test("Fiscal Information pages") {
        "/myml/fiscal_information/mobile"(platform: "/", type: TrackType.View) {}
        "/myml/fiscal_information/not_found"(platform: "/", type: TrackType.View) {}

        "/myml/fiscal_information/message"(platform: "/", type: TrackType.View) {
            code = "permission"
        }

        "/myml/fiscal_information/tax_information"(platform: "/", type: TrackType.View) {
            url = "/fiscal-information/item/MLB1234/tax-information"
            item_id = "MLB1234"
            order_id = ""
            query_type = "single"
            query_data = ""
        }

        "/myml/fiscal_information/tax_information/form/save/request"(platform: "/", type: TrackType.Event) {
            url = "/fiscal-information/item/MLB1234/tax-information"
            item_id = "MLB1234"
            data = {
                products = [
                    {
                        name = "Tests"
                        sku = "1234"
                    }
                ]
            }
        }

        "/myml/fiscal_information/tax_information/form/save/response"(platform: "/", type: TrackType.Event) {
            url = "/fiscal-information/item/MLB1234/tax-information"
            item_id = "MLB1234"
            callback_url = '/fiscal-information/item/MLB1234/success'
            error = false
            data = {
                products = [
                    {
                        name = "Tests"
                        sku = "1234"
                    }
                ]
            }
        }

        "/myml/fiscal_information/tax_information/modal_price"(platform: "/", type: TrackType.Event) {
            url = "/fiscal-information/item/MLB1234/tax-information"
            item_id = "MLB1234"
            price = 100
            form_percentages = [100, 100]
            rounded_percentages = [50, 50]
        }

        "/myml/fiscal_information/tax_information/modal_price/cancel"(platform: "/", type: TrackType.Event) {
            url = "/fiscal-information/item/MLB1234/tax-information"
            item_id = "MLB1234"
            price = 100
            form_percentages = [100, 100]
            rounded_percentages = [50, 50]
        }

        "/myml/fiscal_information/tax_information/modal_price/confirm"(platform: "/", type: TrackType.Event) {
            url = "/fiscal-information/item/MLB1234/tax-information"
            item_id = "MLB1234"
            query_type = "single"
            user_edited = false
            user_rounded = false
            price = 100
            form_percentages = [100, 100]
            rounded_percentages = [50, 50]
        }

        "/myml/fiscal_information/tax_information/difference"(platform: "/", type: TrackType.View) {
            url = "/fiscal-information/item/MLB1234/tax-information/difference"
            item_id = "MLB1234"
            order_id = ""
            query_data = ""
        }

        "/myml/fiscal_information/tax_information/difference/form/save/request"(platform: "/", type: TrackType.Event) {
            url = "/fiscal-information/item/MLB1234/tax-information/difference"
            item_id = "MLB1234"
            data = {
                products = [
                    {
                        name = "Tests"
                        sku = "1234"
                    }
                ]
            }
        }

        "/myml/fiscal_information/tax_information/difference/form/save/response"(platform: "/", type: TrackType.Event) {
            url = "/fiscal-information/item/MLB1234/tax-information/difference"
            item_id = "MLB1234"
            callback_url = '/fiscal-information/item/MLB1234/success'
            error = false
            data = {
                products = [
                    {
                        name = "Tests"
                        sku = "1234"
                    }
                ]
            }
        }

        "/myml/fiscal_information/tax_information/rejection"(platform: "/", type: TrackType.View) {
            url = "/fiscal-information/item/MLB1234/tax-information/rejection"
            item_id = "MLB1234"
            order_id = ""
            query_data = ""
        }

        "/myml/fiscal_information/tax_information/rejection/form/save/request"(platform: "/", type: TrackType.Event) {
            url = "/fiscal-information/item/MLB1234/tax-information/rejection"
            item_id = "MLB1234"
            data = {
                products = [
                    {
                        name = "Tests"
                        sku = "1234"
                    }
                ]
            }
        }

        "/myml/fiscal_information/tax_information/rejection/form/save/response"(platform: "/", type: TrackType.Event) {
            url = "/fiscal-information/item/MLB1234/tax-information/rejection"
            item_id = "MLB1234"
            callback_url = '/fiscal-information/item/MLB1234/success'
            error = false
            data = {
                products = [
                    {
                        name = "Tests"
                        sku = "1234"
                    }
                ]
            }
        }

        "/myml/fiscal_information/tax_information/success"(platform: "/", type: TrackType.View) {
            url = "/fiscal-information/item/MLB1234/tax-information/success"
            item_id = "MLB1234"
        }

        "/myml/fiscal_information/tax_information/success/btn/listings"(platform: "/", type: TrackType.Event) {
            url = "/fiscal-information/item/MLB1234/tax-information/success"
            item_id = "MLB1234"
        }

        "/myml/fiscal_information/type"(platform: "/", type: TrackType.View) {
            url = "/fiscal-information/item/MLB1234/type"
            item_id = "MLB1234"
            order_id = ""
            query_data = ""
        }

        "/myml/fiscal_information/type/selection"(platform: "/", type: TrackType.Event) {
            url = "/fiscal-information/item/MLB1234/type"
            item_id = "MLB1234"
            order_id = ""
            type = "single"
        }
    }

    test("Invoices Documents pages") {
        "/myml/invoices/documents/mobile"(platform: "/", type: TrackType.View) {}
        "/myml/invoices/documents/not_found"(platform: "/", type: TrackType.View) {}

        "/myml/invoices/documents/message"(platform: "/", type: TrackType.View) {
            code = "permission"
        }

        "/myml/invoices/documents/type"(platform: "/", type: TrackType.View) {}

        "/myml/invoices/documents/type/selection"(platform: "/", type: TrackType.Event) {
            type = "nfe"
        }

        "/myml/invoices/documents/gnre"(platform: "/", type: TrackType.View) {
            start = '20181112'
            end = '20181112'
            printed = true
        }

        "/myml/invoices/documents/gnre/btn/export"(platform: "/", type: TrackType.Event) {
            start = '20181112'
            end = '20181112'
            printed = true
        }

        "/myml/invoices/documents/success"(platform: "/", type: TrackType.View) {
            query_data = ""
        }

        "/myml/invoices/documents/success/btn/listings"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/documents/success/btn/download"(platform: "/", type: TrackType.Event) {}
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

        "/myml/sales/questions/response"(platform: "/") {
            unregistered_contact = false
        }

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

        "/myml/purchases/status/buy_it_again"(platform:"/mobile", type: TrackType.Event) {
            item_id = 'MLA713079054'
        }

        "/myml/purchases/shipping" (platform:"/", type: TrackType.View) {
            dataSet()
        }

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


    test("Myml listing pads"){
        "/myml/listings/show"(platform: "/web"){
            label = "active"
            placement = "publicidad-banner"
            adv_segmentation = "winback"
            reputation_level="yellow"
        }
        "/myml/listings/hide"(platform: "/web"){
            label = "active"
            placement = "publicidad-banner"
            adv_segmentation = "winback"
            reputation_level="yellow"
        }
        "/myml/listings/go"(platform: "/web"){
            label = "active"
            placement = "publicidad-banner"
            adv_segmentation = "winback"
            reputation_level="yellow"
        }
    }

    test("Myml summary pads"){
        "/myml/summary/show"(platform: "/web"){
            placement = "publicidad-banner"
            adv_segmentation = "winback"
            reputation_level="yellow"
        }
        "/myml/summary/hide"(platform: "/web"){
            placement = "publicidad-banner"
            adv_segmentation = "winback"
            reputation_level="yellow"
        }
        "/myml/summary/go"(platform: "/web"){
            placement = "publicidad-banner"
            adv_segmentation = "winback"
            reputation_level="yellow"
        }

        "/myml/summary/show"(platform: "/web"){
            placement = "publicidad-banner"
        }
        "/myml/summary/hide"(platform: "/web"){
            placement = "publicidad-banner"
        }
        "/myml/summary/go"(platform: "/web"){
            placement = "publicidad-banner"
        }

         "/myml/summary/show"(platform: "/web"){
            placement = "publicidad-banner"
            reputation_level="yellow"
        }
        "/myml/summary/hide"(platform: "/web"){
            placement = "publicidad-banner"
            reputation_level="yellow"
        }
        "/myml/summary/go"(platform: "/web"){
            placement = "publicidad-banner"
            reputation_level="yellow"
        }

        "/myml/summary/show"(platform: "/web"){
            placement = "publicidad-banner"
            adv_segmentation = "winback"
        }
        "/myml/summary/hide"(platform: "/web"){
            placement = "publicidad-banner"
            adv_segmentation = "winback"
        }
        "/myml/summary/go"(platform: "/web"){
            placement = "publicidad-banner"
            adv_segmentation = "winback"
        }

        "/myml/summary/show"(platform: "/web"){
        }
        "/myml/summary/hide"(platform: "/web"){
        }
        "/myml/summary/go"(platform: "/web"){
        }
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

    test("Price Parity Massive Editor") {
        "/myml/market_prices_editor"(platform: "/", type: TrackType.View) {}

        "/myml/market_prices_editor/save"(platform: "/", type: TrackType.Event) {
            total_items = 10
        }

        "/myml/market_prices_editor/get_suggested_price"(platform: "/", type: TrackType.Event) {
            total_items = 10
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

    test("Myml loyal discount"){
        "/myml/loyal_discounts"(platform:"/web", type: TrackType.View) {
            item = {
                id = "MLM664051031"
                title= "Item De Testeo, Por Favor No Ofertar --kc:off"
                price= 100
                currency_id= "MXN"
                category_id= "MLM3530"
                available_quantity= 97
                thumbnail= "http=//www.mercadolibre.com/jm/img?s=STC&v=I&f=proccesing_image_es.jpg"
                seller_id= "383653285"
                site_id= "MLM"
                original_price = ""
                sale_terms= []
                deal_ids= [ ]
            }
        }
    }
}
