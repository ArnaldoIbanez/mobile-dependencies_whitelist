import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    // Company registration
    test("registration_company") {
        "/registration_company"(platform: "/") {}
        "/registration_company/form"(platform: "/", type: TrackType.View) {}
        "/registration_company/congrats"(platform: "/", type: TrackType.View) {}

        "/registration_company"(platform: "/", business:"mercadopago") {}
        "/registration_company/form"(platform: "/", business:"mercadopago", type: TrackType.View) {}
        "/registration_company/congrats"(platform: "/", business:"mercadopago", type: TrackType.View) {}
    }
    // DDFF = Datos fiscales
    test("/flow_ddff"){
        "/flow_ddff"(platform: "/") {}
        "/flow_ddff/tax_payer"(platform: "/", type: TrackType.View) {}
        "/flow_ddff/iva"(platform: "/", type: TrackType.View) {}
        "/flow_ddff/load_iva"(platform: "/", type: TrackType.View) {}
        "/flow_ddff/iibb"(platform: "/", type: TrackType.View) {}
        "/flow_ddff/load_iibb"(platform: "/", type: TrackType.View) {}
        "/flow_ddff/province_iibb"(platform: "/", type: TrackType.View) {}
        "/flow_ddff/address"(platform: "/", type: TrackType.View) {}
        "/flow_ddff/summary"(platform: "/", type: TrackType.View) {}
        "/flow_ddff/congrats"(platform: "/", type: TrackType.View) {}

        "/flow_ddff"(platform: "/", business:"mercadopago") {}
        "/flow_ddff/tax_payer"(platform: "/", business:"mercadopago", type: TrackType.View) {}
        "/flow_ddff/iva"(platform: "/", business:"mercadopago", type: TrackType.View) {}
        "/flow_ddff/load_iva"(platform: "/", business:"mercadopago", type: TrackType.View) {}
        "/flow_ddff/iibb"(platform: "/", business:"mercadopago", type: TrackType.View) {}
        "/flow_ddff/load_iibb"(platform: "/", business:"mercadopago", type: TrackType.View) {}
        "/flow_ddff/province_iibb"(platform: "/", business:"mercadopago", type: TrackType.View) {}
        "/flow_ddff/address"(platform: "/", business:"mercadopago", type: TrackType.View) {}
        "/flow_ddff/summary"(platform: "/", business:"mercadopago", type: TrackType.View) {}
        "/flow_ddff/congrats"(platform: "/", business:"mercadopago", type: TrackType.View) {}
    }
}
