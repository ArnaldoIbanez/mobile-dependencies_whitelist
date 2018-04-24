import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("registration_company") {
        "/registration"(platform: "/") {}
        "/registration/form"(platform: "/", type: TrackType.Event) {}
        "/registration/congrats"(platform: "/", type: TrackType.Event) {}

        "/registration"(platform: "/", business:"mercadopago") {}
        "/registration/form"(platform: "/", business:"mercadopago", type: TrackType.Event) {}
        "/registration/congrats"(platform: "/", business:"mercadopago", type: TrackType.Event) {}
    }

    test("flow"){
        "/flow"(platform: "/") {}
        "/flow/tax_payer"(platform: "/", type: TrackType.Event) {}
        "/flow/iva"(platform: "/", type: TrackType.Event) {}
        "/flow/load_iva"(platform: "/", type: TrackType.Event) {}
        "/flow/iibb"(platform: "/", type: TrackType.Event) {}
        "/flow/load_iibb"(platform: "/", type: TrackType.Event) {}
        "/flow/province_iibb"(platform: "/", type: TrackType.Event) {}
        "/flow/address"(platform: "/", type: TrackType.Event) {}
        "/flow/summary"(platform: "/", type: TrackType.Event) {}
        "/flow/congrats"(platform: "/", type: TrackType.Event) {}

        "/flow"(platform: "/", business:"mercadopago") {}
        "/flow/tax_payer"(platform: "/", business:"mercadopago", type: TrackType.Event) {}
        "/flow/iva"(platform: "/", business:"mercadopago", type: TrackType.Event) {}
        "/flow/load_iva"(platform: "/", business:"mercadopago", type: TrackType.Event) {}
        "/flow/iibb"(platform: "/", business:"mercadopago", type: TrackType.Event) {}
        "/flow/load_iibb"(platform: "/", business:"mercadopago", type: TrackType.Event) {}
        "/flow/province_iibb"(platform: "/", business:"mercadopago", type: TrackType.Event) {}
        "/flow/address"(platform: "/", business:"mercadopago", type: TrackType.Event) {}
        "/flow/summary"(platform: "/", business:"mercadopago", type: TrackType.Event) {}
        "/flow/congrats"(platform: "/", business:"mercadopago", type: TrackType.Event) {}
    }
}
