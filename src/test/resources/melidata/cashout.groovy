package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

     /**
        Cashout Tests
    **/

    test("Cashout") {
    
    "/cashout"(platform: "/") {}
    "/cashout/hub/kyc"(platform: "/") {}
    "/cashout/hub/lighthouses"(platform: "/") {}
    "/cashout/hub/lighthouses/details"(platform: "/") {}

    "/cashout/hub"(platform: "/", type: TrackType.View) {}
    "/cashout/hub/select"(platform: "/", type: TrackType.Event) {
        cashout_method = "rapipago"
    }

    "/cashout/hub/lighthouses"(platform: "/", type: TrackType.View) {}

    "/cashout/hub/lighthouses/details"(platform: "/", type: TrackType.View) {
        id = "8"
    }
    "/cashout/hub/lighthouses/details/scanqr"(platform: "/", type: TrackType.Event) {
        id = "8"
    }

    "/cashout/hub/congrats"(platform: "/") {}
    "/cashout/hub/congrats/success"(platform: "/", type: TrackType.View) {}
    "/cashout/hub/congrats/success/continue"(platform: "/", type: TrackType.Event) {}
    "/cashout/hub/congrats/success/close"(platform: "/", type: TrackType.Event) {}

    "/cashout/modal"(platform: "/", type: TrackType.View) {}
    "/cashout/modal/close"(platform: "/", type: TrackType.Event) {}
    "/cashout/modal/withdraw"(platform: "/", type: TrackType.Event) {}

    "/cashout/extracash"(platform: "/") {}
    "/cashout/extracash/onboarding"(platform: "/", type: TrackType.View) {}
    "/cashout/extracash/onboarding/continue"(platform: "/", type: TrackType.Event) {}
    "/cashout/extracash/onboarding/close"(platform: "/", type: TrackType.Event) {}
    }
}
