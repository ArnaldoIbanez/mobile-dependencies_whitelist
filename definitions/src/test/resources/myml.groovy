    
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
            itemId = "MLB989120833"
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
            itemId = "MLB989120833"
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
            code = "300"
        }
        "/myml/invoices/items/csosn/save/response"(platform: "/", type: TrackType.Event) {
            code = "300"
            error = "Não conseguimos processar a sua solicitação. Tente Novamente"
        }
        "/myml/invoices/items/ean"(platform: "/") {}
        "/myml/invoices/items/ean/help_tooltip"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/items/ean/save/request"(platform: "/", type: TrackType.Event) {
            itemId = "123123"
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
            code = "1232"
        }
         "/myml/invoices/items/product-type/save/response"(platform: "/", type: TrackType.Event) {
            code = "1232"
            error = "Não conseguimos processar a sua solicitação. Tente Novamente"
        }

        "/myml/invoices/items/ncm"(platform: "/") {}
        "/myml/invoices/items/ncm/help_tooltip"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/items/ncm/save/request"(platform: "/", type: TrackType.Event) {
            code = "84716052"
        }
        "/myml/invoices/items/ncm/save/response"(platform: "/", type: TrackType.Event) {
            code = "84716052"
            error = "Não conseguimos processar a sua solicitação. Tente Novamente"
        }
        "/myml/invoices/items/ncm/search/request"(platform: "/", type: TrackType.Event) {
            code = "84716052"
        }
        "/myml/invoices/items/ncm/search/response"(platform: "/", type: TrackType.Event) {
            code = "84716052"
            error = "Não conseguimos processar a sua solicitação. Tente Novamente"
        }
    }

    test("Sales list flow") {
        "/myml/invoices/sales_list/create_invoice"(platform: "/", type: TrackType.Event) {}
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
        "/myml/invoices/company-info/certificate/a3/handshake"(platform: "/", type: TrackType.Event) {
            handshaking = true;
            installer = "https://myaccount.mercadolivre.com.br/invoices-app/instaler.exe"
        }
        "/myml/invoices/company-info/serie"(platform: "/") {}
        "/myml/invoices/company-info/serie/help_tooltip"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/serie/save/request"(platform: "/", type: TrackType.Event) {
            serie = 200
        }
        "/myml/invoices/company-info/serie/save/response"(platform: "/", type: TrackType.Event) {
            serie = 200
            error = "Não conseguimos processar a sua solicitação. Tente Novamente"
            errorValidation = "O número de série não pode ser vazio"
        }
        "/myml/invoices/company-info/cst"(platform: "/") {}
        "/myml/invoices/company-info/cst/help_tooltip"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/cst/save/request"(platform: "/", type: TrackType.Event) {
            ipi_code = "50"
            pis_code = "08"
        }
        "/myml/invoices/company-info/cst/save/response"(platform: "/", type: TrackType.Event) {
            ipi_code = "50"
            pis_code = "08"
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
            code = "492875457119"
        }
        "/myml/invoices/company-info/ie/save/response"(platform: "/", type: TrackType.Event) {
            code = "492875457119"
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
