package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    // Company registration
    test("/fiscal_data/companies/registration") {
        "/fiscal_data"(platform: "/") {}
        "/fiscal_data/companies"(platform: "/") {}
        "/fiscal_data/companies/registration"(platform: "/") {}
        "/fiscal_data/companies/registration/form"(platform: "/", type: TrackType.View) {}
        "/fiscal_data/companies/registration/congrats"(platform: "/", type: TrackType.View) {}

        "/fiscal_data"(platform: "/", business:"mercadopago") {}
        "/fiscal_data/companies"(platform: "/", business:"mercadopago") {}
        "/fiscal_data/companies/registration"(platform: "/", business:"mercadopago") {}
        "/fiscal_data/companies/registration/form"(platform: "/", business:"mercadopago", type: TrackType.View) {}
        "/fiscal_data/companies/registration/congrats"(platform: "/", business:"mercadopago", type: TrackType.View) {}
    }
    // Fiscal data flow
    test("/fiscal_data/companies/fiscal_data_flow"){
        "/fiscal_data/"(platform: "/") {}
        "/fiscal_data/companies"(platform: "/") {}
        "/fiscal_data/companies/fiscal_data_flow"(platform: "/") {}
        "/fiscal_data/companies/fiscal_data_flow/tax_payer"(platform: "/", type: TrackType.View) {}
        "/fiscal_data/companies/fiscal_data_flow/iva"(platform: "/", type: TrackType.View) {}
        "/fiscal_data/companies/fiscal_data_flow/load_iva"(platform: "/", type: TrackType.View) {}
        "/fiscal_data/companies/fiscal_data_flow/iibb"(platform: "/", type: TrackType.View) {}
        "/fiscal_data/companies/fiscal_data_flow/load_iibb"(platform: "/", type: TrackType.View) {}
        "/fiscal_data/companies/fiscal_data_flow/province_iibb"(platform: "/", type: TrackType.View) {}
        "/fiscal_data/companies/fiscal_data_flow/address"(platform: "/", type: TrackType.View) {}
        "/fiscal_data/companies/fiscal_data_flow/summary"(platform: "/", type: TrackType.View) {}
        "/fiscal_data/companies/fiscal_data_flow/congrats"(platform: "/", type: TrackType.View) {}

        "/fiscal_data"(platform: "/", business:"mercadopago") {}
        "/fiscal_data/companies"(platform: "/", business:"mercadopago") {}
        "/fiscal_data/companies/fiscal_data_flow"(platform: "/", business:"mercadopago") {}
        "/fiscal_data/companies/fiscal_data_flow/tax_payer"(platform: "/", business:"mercadopago", type: TrackType.View) {}
        "/fiscal_data/companies/fiscal_data_flow/iva"(platform: "/", business:"mercadopago", type: TrackType.View) {}
        "/fiscal_data/companies/fiscal_data_flow/load_iva"(platform: "/", business:"mercadopago", type: TrackType.View) {}
        "/fiscal_data/companies/fiscal_data_flow/iibb"(platform: "/", business:"mercadopago", type: TrackType.View) {}
        "/fiscal_data/companies/fiscal_data_flow/load_iibb"(platform: "/", business:"mercadopago", type: TrackType.View) {}
        "/fiscal_data/companies/fiscal_data_flow/province_iibb"(platform: "/", business:"mercadopago", type: TrackType.View) {}
        "/fiscal_data/companies/fiscal_data_flow/address"(platform: "/", business:"mercadopago", type: TrackType.View) {}
        "/fiscal_data/companies/fiscal_data_flow/summary"(platform: "/", business:"mercadopago", type: TrackType.View) {}
        "/fiscal_data/companies/fiscal_data_flow/congrats"(platform: "/", business:"mercadopago", type: TrackType.View) {}
    }
}
