    
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

    test("Optin flow") {
        "/myml/invoices/landing"(platform: "/") {}
        "/myml/invoices/landing/optin"(platform: "/", type: TrackType.Event) {
            type = "top"
        }
        "/myml/invoices/company-info/certificate"(platform: "/") {}
        "/myml/invoices/company-info/certificate/help_tooltip"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/certificate/a1"(platform: "/") {}
        "/myml/invoices/company-info/certificate/a1/help_tooltip"(platform: "/", type: TrackType.Event) {}
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
}
