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

        "/myml/invoices/sku/detail"(platform: "/") {}
        "/myml/invoices/sku/processing"(platform: "/") {}
        "/myml/invoices/sku/disabled"(platform: "/") {}
        "/myml/invoices/sku/detail/action"(platform: "/", type: TrackType.Event) {
          action = "print_danfe"
        }
    }

    test("Inform NFe flow") {
        "/myml/invoices/inform_nfe"(platform: "/") {}
        "/myml/invoices/inform_nfe/home"(platform: "/", type: TrackType.View) {
            seller_tax_regime="Regime Normal"
            shipments_quantity=1
        }
        "/myml/invoices/inform_nfe/home"(platform: "/", type: TrackType.View) {
            seller_tax_regime="Simples Nacional"
            shipments_quantity=2
        }
        "/myml/invoices/inform_nfe/home/breadcrumb_back_page"(platform: "/", type: TrackType.Event) {
            seller_tax_regime="Regime Normal"
            shipments_quantity=1
        }
        "/myml/invoices/inform_nfe/home/breadcrumb_back_page"(platform: "/", type: TrackType.Event) {
            seller_tax_regime="Simples Nacional"
            shipments_quantity=2
        }
        "/myml/invoices/inform_nfe/home/back_page"(platform: "/", type: TrackType.Event) {
            seller_tax_regime="Regime Normal"
            shipments_quantity=1
        }
        "/myml/invoices/inform_nfe/home/back_page"(platform: "/", type: TrackType.Event) {
            seller_tax_regime="Simples Nacional"
            shipments_quantity=2
        }
        "/myml/invoices/inform_nfe/home/inform"(platform: "/", type: TrackType.Event) {
            seller_tax_regime="Regime Normal"
            shipments_quantity=1
        }
        "/myml/invoices/inform_nfe/home/inform"(platform: "/", type: TrackType.Event) {
            seller_tax_regime="Simples Nacional"
            shipments_quantity=2
        }
        "/myml/invoices/inform_nfe/home/needs_help"(platform: "/", type: TrackType.Event) {
            seller_tax_regime = "Regime Normal"
            shipments_quantity=1
        }
        "/myml/invoices/inform_nfe/home/needs_help"(platform: "/", type: TrackType.Event) {
            seller_tax_regime = "Simples Nacional"
            shipments_quantity=2
        }
        "/myml/invoices/inform_nfe/not_found"(platform: "/", type: TrackType.View) {
            seller_tax_regime="Regime Normal"
        }
        "/myml/invoices/inform_nfe/not_found"(platform: "/", type: TrackType.View) {
            seller_tax_regime="Simples Nacional"
        }
    }

    test("Optin flow") {
        "/myml/invoices/optin"(platform: "/") {}
        "/myml/invoices/optin/home"(platform: "/", type: TrackType.View) {}
        "/myml/invoices/optin/home"(platform: "/", type: TrackType.View) {
            seller_type = "PF"
        }
        "/myml/invoices/optin/home"(platform: "/", type: TrackType.View) {
            seller_type = "PF"
        }
        "/myml/invoices/optin/home"(platform: "/", type: TrackType.View) {
            seller_tax_regime = "Regime Normal"
        }
        "/myml/invoices/optin/home"(platform: "/", type: TrackType.View) {
            seller_tax_regime = "Simples Nacional"
        }
        "/myml/invoices/optin/home/back_page"(platform: "/", type: TrackType.Event) {
            seller_type = "PF"
        }
        "/myml/invoices/optin/home/back_page"(platform: "/", type: TrackType.Event) {
            seller_type = "PJ"
        }
        "/myml/invoices/optin/home/needs_help"(platform: "/", type: TrackType.Event) {
            seller_type = "PF"
        }
        "/myml/invoices/optin/home/needs_help"(platform: "/", type: TrackType.Event) {
            seller_type = "PJ"
        }
        "/myml/invoices/optin/home/modify_data"(platform: "/", type: TrackType.Event) {
            seller_type = "PF"
        }
        "/myml/invoices/optin/home/modify_data"(platform: "/", type: TrackType.Event) {
            seller_type = "PJ"
        }
        "/myml/invoices/optin/home/enabled_for_biller"(platform: "/", type: TrackType.Event) {
            seller_type = "PF"
        }
        "/myml/invoices/optin/home/enabled_for_biller"(platform: "/", type: TrackType.Event) {
            seller_type = "PJ"
        }

        "/myml/invoices/optin/basic_tax_settings"(platform: "/", type: TrackType.View) {
            seller_tax_regime = "Regime Normal"
        }
        "/myml/invoices/optin/basic_tax_settings"(platform: "/", type: TrackType.View) {
            seller_tax_regime = "Simples Nacional"
        }
        "/myml/invoices/optin/blocked_access"(platform: "/", type: TrackType.View) {
            reason = "NOT_OWNER"
        }
        "/myml/invoices/optin/blocked_access"(platform: "/", type: TrackType.View) {
            reason = "NOT_OWNER"
            seller_tax_regime = "Regime Normal"
        }
        "/myml/invoices/optin/blocked_access"(platform: "/", type: TrackType.View) {
            reason = "NOT_OWNER"
            seller_tax_regime = "Simples Nacional"
        }
        "/myml/invoices/optin/blocked_access"(platform: "/", type: TrackType.View) {
            reason = "NO_DOCUMENT_REGISTERED"
        }
        "/myml/invoices/optin/blocked_access"(platform: "/", type: TrackType.View) {
            reason = "NO_DOCUMENT_REGISTERED"
            seller_tax_regime = "Regime Normal"
        }
        "/myml/invoices/optin/blocked_access"(platform: "/", type: TrackType.View) {
            reason = "NO_DOCUMENT_REGISTERED"
            seller_tax_regime = "Simples Nacional"
        }
        "/myml/invoices/optin/certificate"(platform: "/", type: TrackType.View) {
            seller_tax_regime = "Regime Normal"
        }
        "/myml/invoices/optin/certificate"(platform: "/", type: TrackType.View) {
            seller_tax_regime = "Simples Nacional"
        }
        "/myml/invoices/optin/gnre"(platform: "/", type: TrackType.View) {
            seller_tax_regime = "Regime Normal"
        }
        "/myml/invoices/optin/gnre"(platform: "/", type: TrackType.View) {
            seller_tax_regime = "Simples Nacional"
        }
        "/myml/invoices/optin/invoice_data"(platform: "/", type: TrackType.View) {
            seller_tax_regime = "Regime Normal"
        }
        "/myml/invoices/optin/invoice_data"(platform: "/", type: TrackType.View) {
            seller_tax_regime = "Simples Nacional"
        }
        "/myml/invoices/optin/validation"(platform: "/") {}
        "/myml/invoices/optin/validation/activity"(platform: "/", type: TrackType.View) {
            seller_tax_regime = "Regime Normal"
        }
        "/myml/invoices/optin/validation/activity"(platform: "/", type: TrackType.View) {
            seller_tax_regime = "Simples Nacional"
        }
        "/myml/invoices/optin/validation/business_name"(platform: "/", type: TrackType.View) {
            seller_tax_regime = "Regime Normal"
        }
        "/myml/invoices/optin/validation/business_name"(platform: "/", type: TrackType.View) {
            seller_tax_regime = "Simples Nacional"
        }
        "/myml/invoices/optin/validation/state_registry"(platform: "/", type: TrackType.View) {
            seller_tax_regime = "Regime Normal"
        }
        "/myml/invoices/optin/validation/state_registry"(platform: "/", type: TrackType.View) {
            seller_tax_regime = "Simples Nacional"
        }

        "/myml/invoices/not-found"(platform: "/") {}
        "/myml/invoices/landing"(platform: "/") {}
        "/myml/invoices/landing/optin"(platform: "/", type: TrackType.Event) {
            type = "top"
        }
        "/myml/invoices/company-info/certificate"(platform: "/") {}
        "/myml/invoices/company-info/certificate/help_tooltip"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/certificate/a1"(platform: "/") {
            campaign_source = 'banner-sales-list-A3-60'
            campaign = 'adp_A1'
        }
        "/myml/invoices/company-info/certificate/a1/help_tooltip"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/certificate/a1/installer_download"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/certificate/a1/save/request"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/certificate/a1/save/response"(platform: "/", type: TrackType.Event) {
            error = "password"
            message = "Password incorrect!"
            certificateFrom = "local"
            certificateTo = "server"
            campaign_source = 'banner-sales-list-A3-60'
            campaign = 'adp_A1'
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
          campaign_source = 'fiscalData'
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
          campaign_source = 'fiscalData'
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
        "/myml/invoices/company-info/emission-validation"(platform: "/") {}
        "/myml/invoices/company-info/emission-validation/success"(platform: "/") {
            emission_validation_status = "SUCCESS"
        }
        "/myml/invoices/company-info/emission-validation/error"(platform: "/") {
            emission_validation_status = "NOT_MAPPED_ERROR"
        }
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
        "/myml/invoices/order/devolution"(platform: "/") {}
        "/myml/invoices/order/devolution/confirm"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/order/devolution/success"(platform: "/", type: TrackType.Event) {
            devolution_type = "total"
            order_id = '2468239444'
        }
        "/myml/invoices/order/devolution/modal"(platform: "/", type: TrackType.Event) {
            action = "close_modal"
            order_id = '2468239444'
            invoice_id = '549401'
        }
    }

    test("Backoffice pages") {
        "/myml/invoices/backoffice/search/invoice"(platform: "/", type: TrackType.Event) {
            searchType = 'order_id'
            searchValue = '2158279221'
        }

        "/myml/invoices/backoffice/search/reissueinvoice"(platform: "/", type: TrackType.Event) {
            invoiceId = '40503435'
            orderIds = '2146844767'
            userId = '257268611'
            reason = 'outros'
            detailedReason = 'more details'

        }

        "/myml/invoices/backoffice/search/disableinvoice"(platform: "/", type: TrackType.Event) {
            invoiceId = '40503435'
            userId = '257268611'
            reason = 'bug'
            detailedReason = 'bug related to ...'
        }

        "/myml/invoices/backoffice/search/invoiceslist"(platform: "/", type: TrackType.Event) {
            invoiceId = '42563838'
            orderId = '2158279221'
            status = 'authorized'
            inboundId = ''
            shipmentId = '28108719985'
            shipmentLogisticType = 'drop_off'
            invoiceCreationDateFrom = '2019-09-25'
            invoiceCreationDateTo = ''
            invoiceNumber = '2'
            invoiceNumberTo = ''
            invoiceNumberFrom = ''
            recipientCnpj = ''
            recipientCpf = '92869920501'
            recipientName = 'Cléa Dos'
            recipientUf = 'SP'
            invoiceSerie = '2'
            userId = '188419705'
            issuerCnpj = '18891699000133'
            issuerUf = 'SP'
            taxRuleId = '123'
            nickname = 'CLAFERREIRADO'
            email = 'clafer@fer.com'
            transactionType = 'sale'
            externalProductId = 'MLB1113768925'
        }

        "/myml/invoices/backoffice/search/invoiceslist/export_csv"(platform: "/", type: TrackType.Event) {
            seller_id = '191396245'
            status = 'needs_review'
            environment = 'production'
            external_order_id = '2158320980'
            series = ''
            invoice_number = ''
            issuer_cnpj = ''
            shipment_logistic_type = ''
            shipment_fiscal_model = ''
            recipient_cnpj = ''
            invoice_creation_date_from = ''
            invoice_creation_date_to = ''
            invoice_id = '42563835'
            invoice_key = ''
            shipment_id = '28108611041'
            invoice_number_from = '662'
            invoice_number_to = '800'
            tax_rule_id = ''
            transaction_type = 'sale'
            external_product_id = 'MLB709814227'
            issuer_address_state = 'SP'
            recipient_cpf = ''
            recipient_id = ''
            recipient_name = ''
            recipient_address_state = ''
            with_items = ''
            sort = 'DESC'
            limit = ''
            offset = ''
            transaction_status = ''
        }

        "/myml/invoices/backoffice/view/invoiceslist"(platform: "/", type: TrackType.View) {}
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

        "/myml/fiscal_information/tax_substitution"(platform: "/", type: TrackType.View) {
            query_sku = "SKU1234"
            query_item_id = "MLB1234"
            query_inbound_id = "INB1234"
        }

        "/myml/fiscal_information/tax_substitution/btn/backtoinbound"(platform: "/", type: TrackType.Event) {
            query_sku = "SKU1234"
            query_item_id = "MLB1234"
            query_inbound_id = "INB1234"
        }

        "/myml/fiscal_information/tax_substitution/form/save/request"(platform: "/", type: TrackType.Event) {
            query_sku = "SKU1234"
            query_item_id = "MLB1234"
            query_inbound_id = "INB1234"
            data = {
                base_fcp_retained = 0
                base_retained = 0
                fcp_retained = 0
                icms_retained = 0
            }
        }

        "/myml/fiscal_information/tax_substitution/form/save/response"(platform: "/", type: TrackType.Event) {
            query_sku = "SKU1234"
            query_item_id = "MLB1234"
            query_inbound_id = "INB1234"
            error = false
            data = {
                tax_information = {}
                tax_substitution = {
                    base_fcp_retained = 0
                    base_retained = 0
                    fcp_retained = 0
                    icms_retained = 0
                }
            }
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

        "/myml/invoices/opt_in/difal"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/opt_in/difal/button/save"(platform: "/", type: TrackType.Event) {}

        "/myml/invoices/opt_in/rule-composition"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/opt_in/rule-composition/button/save"(platform: "/", type: TrackType.Event) {}

        "/myml/invoices/opt_in/cst-devolution"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/opt_in/cst-devolution/button/save"(platform: "/", type: TrackType.Event) {}

        "/myml/download_invoice_preference"(platform: "/", type: TrackType.Event) {}
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

        "/myml/sales/questions/history"(platform: "/mobile"){}

        "/myml/sales/questions/answer_question"(platform: "/mobile"){}

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

        "/myml/purchases/questions/asked_questions"(platform: "/mobile") {}

        "/myml/purchases/questions/history"(platform: "/mobile") {}

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
            buy_it_again_experiment = 'Yes'
            buy_it_again_lead_checkout = 'No'
        }

        "/myml/purchases/status/shipping_detail"(platform:"/", type: TrackType.Event) {
            dataSet()
        }

        "/myml/purchases/shipping" (platform:"/", type: TrackType.View) {
            dataSet()
        }

        // -------

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
        "/myml/listings/active"(platform: "/mobile") {}
        "/myml/listings/closed"(platform: "/mobile") {}
        "/myml/listings/detail"(platform: "/mobile") {}
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
        "/myml/profile/card_details"(platform: "/mobile") {}
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
        "/myml/account_balance/digital_goods"(platform: "/mobile", type: TrackType.View) {}
        "/myml/account_balance/fund_travel_card"(platform: "/mobile", type: TrackType.View) {}
        "/myml/account_balance/mp"(platform: "/mobile", type: TrackType.View) {}
        "/myml/account_balance/mp/install"(platform: "/mobile", type: TrackType.View) {}
        "/myml/account_balance/my_money"(platform: "/mobile", type: TrackType.View) {}
        "/myml/account_balance/gas_station"(platform: "/mobile", type: TrackType.View) {}
    }

    test("MyMl new reputation flow seller") {
        "/myml/sales/detail/flow_selector"(platform: "/mobile", type: TrackType.View) {
            flow_selected = "MPA and not ME"
        }
        "/myml/sales/detail/deliver_product"(platform: "/mobile", type: TrackType.View) {}
        "/myml/sales/detail/deliver_product#submit"(platform: "/mobile/android", type: TrackType.Event) {
            action_label = "send_feedback"
        }
        "/myml/sales/detail/deliver_product#submit"(platform: "/mobile/ios", type: TrackType.Event) {}
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

    test("Main") {
        "/myml/main"(platform: "/mobile", type: TrackType.Event) {
            messages = "dummy-message"
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

    test("Myml buy_it_again") {
        "/myml/buy_it_again"(platform: "/mobile") {}
    }

    test("Myml buy_it_again") {
        "/myml/account_security"(platform: "/mobile") {}
    }

    test("Myml activity list") {
        "/myml/activity"(platform: "/mobile") {}
        "/myml/activity/list"(platform: "/mobile") {}
    }

    test("Myml bookmarks list") {
        "/myml/bookmarks/list"(platform: "/mobile") {}
    }

    test("Myml portal_ayuda") {
        "/myml/portal_ayuda"(platform: "/mobile") {}
    }

    test("Myml myreputation") {
        "/myml/myreputation"(platform: "/mobile") {}
    }

    test("Myml settings") {
        "/myml/settings"(platform: "/mobile", type: TrackType.View) {}
    }

    test("Myml message activity") {
        "/myml/message"(platform: "/mobile") {}
        "/myml/message/questions"(platform: "/mobile", type: TrackType.View) {}
        "/myml/message/activity"(platform: "/mobile", type: TrackType.View) {}
        "/myml/message/pack_detail"(platform: "/mobile", type: TrackType.View) {}
        "/myml/message/attachments_uploader"(platform: "/mobile", type: TrackType.View) {}
        "/myml/message/attachment_viewer"(platform: "/mobile/ios", type: TrackType.View) {}
    }

    test("Myml Fiscal Rules Page") {
        "/myml/fiscal_rules/message"(platform: "/", type: TrackType.View) {
            code = 404
        }

        "/myml/fiscal_rules/listing"(platform: "/", type: TrackType.View) {
            page = 2
            per_page = 20
            selected = ""
        }

        "/myml/fiscal_rules/listing/button/new_rules"(platform: "/", type: TrackType.Event) {
            page = 2
            per_page = 20
            selected = ""
        }

        "/myml/fiscal_rules/listing/button/edit_rules"(platform: "/", type: TrackType.Event) {
            page = 2
            per_page = 20
            selected = ""
            ids = "MSwyLDU="
        }

        "/myml/fiscal_rules/listing/button/remove_rules"(platform: "/", type: TrackType.Event) {
            page = 2
            per_page = 20
            selected = ""
            id = "5"
        }


        "/myml/fiscal_rules/listing/checkbox/header"(platform: "/", type: TrackType.Event) {
            page = 2
            per_page = 20
            selected = ""
            status = true
        }

        "/myml/fiscal_rules/listing/checkbox/list"(platform: "/", type: TrackType.Event) {
            page = 2
            per_page = 20
            selected = ""
            status = true
            id = 5
        }

        "/myml/fiscal_rules/listing/modal/confirm"(platform: "/", type: TrackType.Event) {
            page = 2
            per_page = 20
            selected = ""
        }

        "/myml/fiscal_rules/listing/modal/cancel"(platform: "/", type: TrackType.Event) {
            page = 2
            per_page = 20
            selected = ""
        }

        "/myml/fiscal_rules/listing/pagination"(platform: "/", type: TrackType.Event) {
            page = 2
            per_page = 20
            selected = ""
            current_page = 2
            next_page = 3
            amount = 4
        }
    }

    test("Myml Fiscal Rules Massive Page") {
        "/myml/fiscal_rules/massive"(platform: "/", type: TrackType.View) {
            action = "edit"
            context = "default"
            callback_url = "https://www.mercadolivre.com.br"
            selected = "1, 2, 3, 4"
        }

        "/myml/fiscal_rules/massive/button/download"(platform: "/", type: TrackType.Event) {
            action = "edit"
            context = "default"
            callback_url = "https://www.mercadolivre.com.br"
            selected = "1, 2, 3, 4"
        }

        "/myml/fiscal_rules/massive/button/upload"(platform: "/", type: TrackType.Event) {
            action = "edit"
            context = "default"
            callback_url = "https://www.mercadolivre.com.br"
        }

        "/myml/fiscal_rules/massive/button/download_error"(platform: "/", type: TrackType.Event) {
            action = "edit"
            context = "default"
            callback_url = "https://www.mercadolivre.com.br"
            id = "1a2b3c4d"
            status = "error"
        }

        "/myml/fiscal_rules/massive/modal/progress"(platform: "/", type: TrackType.Event) {
            action = "edit"
            context = "default"
            callback_url = "https://www.mercadolivre.com.br"
            id = "1a2b3c4d"
            status = "success"
            scope = "download"
        }

        "/myml/fiscal_rules/massive/upload"(platform: "/", type: TrackType.View) {
            action = "edit"
            context = "default"
            callback_url = "https://www.mercadolivre.com.br"
        }

        "/myml/fiscal_rules/massive/upload/uploader/change"(platform: "/", type: TrackType.Event) {
            action = "edit"
            context = "default"
            callback_url = "https://www.mercadolivre.com.br"
            has_files = true
        }

        "/myml/fiscal_rules/massive/upload/uploader/error"(platform: "/", type: TrackType.Event) {
            action = "edit"
            context = "default"
            callback_url = "https://www.mercadolivre.com.br"
            error = "Invalid file type"
        }

        "/myml/fiscal_rules/massive/upload/button/later"(platform: "/", type: TrackType.Event) {
            action = "edit"
            context = "default"
            callback_url = "https://www.mercadolivre.com.br"
        }

        "/myml/fiscal_rules/massive/upload/button/save"(platform: "/", type: TrackType.Event) {
            action = "edit"
            context = "default"
            callback_url = "https://www.mercadolivre.com.br"
            name = "testname"
            type = "xlsx"
            size = 1000
        }

        "/myml/fiscal_rules/massive/upload/status"(platform: "/", type: TrackType.View) {
            action = "edit"
            context = "default"
            callback_url = "https://www.mercadolivre.com.br"
            id = "1a2b3c4d"
        }

        "/myml/fiscal_rules/massive/upload/status/button/fiscal_information"(platform: "/", type: TrackType.Event) {
            action = "edit"
            context = "default"
            callback_url = "https://www.mercadolivre.com.br"
            id = "1a2b3c4d"
        }

        "/myml/fiscal_rules/massive/upload/status/button/advanced_tax_settings"(platform: "/", type: TrackType.Event) {
            action = "edit"
            context = "default"
            callback_url = "https://www.mercadolivre.com.br"
            id = "1a2b3c4d"
        }
    }

    // TRACKS MYML ADVANCED TAX SETTING

    test('Advanced tax settings messa error') {
        "/myml/advanced_tax_settings/message"(platform: "/", type: TrackType.View) {
            code = 400
        }
    }

    test('Advanced tax settings home') {
        "/myml/advanced_tax_settings/home"(platform: "/", type: TrackType.View) {
            context = "optin"
        }

        "/myml/advanced_tax_settings/home/access"(platform: "/", type: TrackType.Event) {
            destination_to = "https://myaccount.mercadolivre.com.br/advanced-tax-settings/cst/sale"
            context = "optin"
        }
    }

    test('Advanced tax setting difal') {
        "/myml/advanced_tax_settings/difal"(platform: "/", type: TrackType.View) {
            context = "optin"
        }

        "/myml/advanced_tax_settings/difal/save"(platform: "/", type: TrackType.Event) {
            context = "optin"
        }
    }

    test('Advanced tax setting csosn') {
        "/myml/advanced_tax_settings/csosn"(platform: "/", type: TrackType.View) {
            context = "optin"
        }

        "/myml/advanced_tax_settings/csosn/save"(platform: "/", type: TrackType.Event) {
            context = "optin"
        }
    }

    test('Advanced tax setting rule composition') {
        "/myml/advanced_tax_settings/rule_composition"(platform: "/", type: TrackType.View) {
            context = "default"
        }

        "/myml/advanced_tax_settings/rule_composition/save"(platform: "/", type: TrackType.Event) {
            context = "default"
        }
    }

    test('Advanced tax setting CSTS') {
        "/myml/advanced_tax_settings/cst_sale"(platform: "/", type: TrackType.View) {
            context = "default"
        }

        "/myml/advanced_tax_settings/cst_sale/save"(platform: "/", type: TrackType.Event) {
            context = "default"
        }

        "/myml/advanced_tax_settings/cst_devolution"(platform: "/", type: TrackType.View) {
            context = "default"
        }

        "/myml/advanced_tax_settings/cst_devolution/save"(platform: "/", type: TrackType.Event) {
            context = "default"
        }
    }

    //TRACKS MYML Search Bookmarks Alerts
    test("Search Alerts List") {
        "/myml/search_alerts/list"(platform: "/", type: TrackType.View) {
            quantity = 2
        }

        "/myml/search_alerts/list"(platform: "/", type: TrackType.View) {
            quantity = 0
        }
    }

    // TRACKS MYML MyContact Section
    test("MyContact Main"){
        "/myml/mycontact/main"(platform: "/", type: TrackType.View){}
    }

    // TRACKS MYML Invoice Detail
    test('Invoices detail view') {
        "/myml/invoices/detail"(platform: "/", type: TrackType.View) {}
        "/myml/invoices/detail/correction_letter_modal_open"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/detail/correction_letter_modal_cancel"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/detail/correction_letter_modal_confirm"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/detail/correction_letter_save"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/detail/correction_letter_click"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/detail/cancel_invoice_modal_open"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/detail/cancel_invoice_modal_cancel"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/detail/cancel_invoice_modal_confirm"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/detail/cancel_invoice_save"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/detail/cancel_invoice_click"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/detail/resend_invoice_save"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/detail/resend_invoice_click"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/detail/fiscal_data_modal_open"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/detail/fiscal_data_modal_close"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/detail/to_send_devolution_invoice_click"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/detail/create_invoice_click"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/detail/print_danfe_click"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/detail/fix_invoice_click"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/detail/download_xml_click"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/detail/re_print_gnre_click"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/detail/print_gnre_click"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/detail/copy_access_key_click"(platform: "/", type: TrackType.Event) {}
    }
}
