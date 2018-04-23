import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "fiscaldata"

    test("registration_company") {
        //Registration
        "/registration/form"(platform: "/", type: TrackType.Event) {}
        "/registration/congrats"(platform: "/", type: TrackType.Event) {}
    }

    test("flow"){
        //Flow load and update of Fiscal data.
        "/flow/tax_payer"(platform: "/", type: TrackType.Event) {}
        "/flow/iva"(platform: "/", type: TrackType.Event) {}
        "/flow/load_iva"(platform: "/", type: TrackType.Event) {}
        "/flow/iibb"(platform: "/", type: TrackType.Event) {}
        "/flow/load_iibb"(platform: "/", type: TrackType.Event) {}
        "/flow/province_iibb"(platform: "/", type: TrackType.Event) {}
        "/flow/address"(platform: "/", type: TrackType.Event) {}
        "/flow/summary"(platform: "/", type: TrackType.Event) {}
        "/flow/congrats"(platform: "/", type: TrackType.Event) {}
    }
}
