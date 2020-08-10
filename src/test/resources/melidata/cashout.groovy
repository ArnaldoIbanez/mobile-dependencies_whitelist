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
    "/cashout/hub"(platform: "/") {}
    "/cashout/hub/kyc"(platform: "/") {}

    "/cashout/hub/kyc/onboarding"(platform: "/", type: TrackType.View) {}
    "/cashout/hub/kyc/onboarding/continue"(platform: "/", type: TrackType.Event) {}
    "/cashout/hub/kyc/onboarding/close"(platform: "/", type: TrackType.Event) {}

    "/cashout/hub/congrat"(platform: "/") {}
    "/cashout/hub/congrat/success"(platform: "/", type: TrackType.View) {}
    "/cashout/hub/congrat/success/continue"(platform: "/", type: TrackType.Event) {}
    "/cashout/hub/congrat/success/close"(platform: "/", type: TrackType.Event) {}

    "/cashout/extracash"(platform: "/") {}
    "/cashout/extracash/onboarding"(platform: "/", type: TrackType.View) {}
    "/cashout/extracash/onboarding/continue"(platform: "/", type: TrackType.Event) {}
    "/cashout/extracash/onboarding/close"(platform: "/", type: TrackType.Event) {}
    }
}
