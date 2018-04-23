    
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
        "/myml/invoices/items/review/save/request"(platform: "/", type: TrackType.Event) {
            orders = ["1690100108", "1690100101"]
        }
        "/myml/invoices/items/review/save/response"(platform: "/", type: TrackType.Event) {
            orders = ["1690100108", "1690100101"]
            data = "{status: 200}"
        }
        "/myml/invoices/review/help"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/items/origin"(platform: "/") {}
        "/myml/invoices/items/origin/help"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/items/origin/save/request"(platform: "/", type: TrackType.Event) {
            origin_detail = "2"
        }
        "/myml/invoices/items/origin/save/response"(platform: "/", type: TrackType.Event) {
            origin_detail = "2"
            data = "{status: 200}"
        }
        "/myml/invoices/items/sku"(platform: "/") {}
        "/myml/invoices/items/sku/help"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/items/sku/save/request"(platform: "/", type: TrackType.Event) {
            seller_sku = "1234"
        }
        "/myml/invoices/items/sku/save/response"(platform: "/", type: TrackType.Event) {
            seller_sku = "1234"
            data = "{status: 404}"
        }
        "/myml/invoices/items/csosn"(platform: "/") {}
        "/myml/invoices/items/csosn/help"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/items/csosn/save/request"(platform: "/", type: TrackType.Event) {
            ICMS_SIMPLES = "300"
            item_id = "MLB989120833"
        }
        "/myml/invoices/items/csosn/save/response"(platform: "/", type: TrackType.Event) {
            ICMS_SIMPLES = "300"
            item_id = "MLB989120833"
            data = "{status: 500}"
        }
        "/myml/invoices/items/ean"(platform: "/") {}
        "/myml/invoices/items/ean/help"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/items/ean/save/request"(platform: "/", type: TrackType.Event) {
            disabled = false
            ean = "7896483002647"
        }
        "/myml/invoices/items/ean/save/response"(platform: "/", type: TrackType.Event) {
            disabled = false
            ean = "7896483002647"
            data = "{status: 200}"
        }
        "/myml/invoices/items/ean/validate"(platform: "/", type: TrackType.Event) {
            ean = "7896483002647"
        }
        "/myml/invoices/items/ncm"(platform: "/") {}
        "/myml/invoices/items/ncm/help"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/items/ncm/save/request"(platform: "/", type: TrackType.Event) {
            ncm = "84716052"
        }
        "/myml/invoices/items/ncm/save/response"(platform: "/", type: TrackType.Event) {
            ncm = "84716052"
            data = "{status: 404}"
        }
        "/myml/invoices/items/ncm/search/request"(platform: "/", type: TrackType.Event) {
            ncm = "84716052"
        }
        "/myml/invoices/items/ncm/search/response"(platform: "/", type: TrackType.Event) {
            ncm = "84716052"
            data = "{status: 404}"
        }
    }

    test("Sales list flow") {
        "/myml/invoices/sales_list/create_invoice"(platform: "/", type: TrackType.Event) {}
    }

    test("Optin flow") {
        "/myml/invoices/landing"(platform: "/") {}
        "/myml/invoices/landing/quero_faturar"(platform: "/", type: TrackType.Event) {
            type = "top"
        }
        "/myml/invoices/company-info/certificate"(platform: "/") {}
        "/myml/invoices/company-info/certificate/help"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/certificate/select_a1"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/certificate/select_a3"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/certificate/a1"(platform: "/") {}
        "/myml/invoices/company-info/certificate/a1/help"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/certificate/a1/save/request"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/certificate/a1/save/response"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/certificate/a3"(platform: "/") {}
        "/myml/invoices/company-info/certificate/a3/download_app"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/certificate/a3/handshake"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/serie"(platform: "/") {}
        "/myml/invoices/company-info/serie/help"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/serie/save/request"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/serie/save/response"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/cst"(platform: "/") {}
        "/myml/invoices/company-info/cst/help"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/cst/save/request"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/cst/save/response"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/csosn"(platform: "/") {}
        "/myml/invoices/company-info/csosn/help"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/csosn/save/request"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/csosn/save/response"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/ie"(platform: "/") {}
        "/myml/invoices/company-info/ie/save/request"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/ie/save/response"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/confirm"(platform: "/") {}
        "/myml/invoices/company-info/confirm/save/request"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/confirm/save/response"(platform: "/", type: TrackType.Event) {}
        "/myml/invoices/company-info/success"(platform: "/") {}
    }
}
