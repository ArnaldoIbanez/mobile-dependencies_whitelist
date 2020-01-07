package src.test.resources.melidata
import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadopago"

    test("PDV views") {
        //Onboarding
        "/pdv/onboarding/start"(platform: "/", type: TrackType.View) {}
        "/pdv/onboarding/create_store"(platform: "/", type: TrackType.View) {}
        "/pdv/onboarding/pos_setup"(platform: "/", type: TrackType.View) {}
    }

    test("PDV events") {
        //Onboarding
        "/pdv/onboarding/init_onboarding"(platform: "/", type: TrackType.Event) {}
        "/pdv/onboarding/create_store"(platform: "/", type: TrackType.Event) {}
        "/pdv/onboarding/pos_management"(platform: "/", type: TrackType.Event) {
            pos_management=true
            cash_management=true
        }
        "/pdv/onboarding/end"(platform: "/", type: TrackType.Event) {
            path="/collections/setup/onboarding"
        }
        "/pdv/onboarding/link"(platform: "/", type: TrackType.Event) {}
        "/pdv/onboarding/unlink"(platform: "/", type: TrackType.Event) {}
        "/pdv/onboarding/buy_pos"(platform: "/", type: TrackType.Event) {}
        "/pdv/onboarding/register"(platform: "/", type: TrackType.Event) {}
    }
}
