package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"


    test("Mercadopago profile check landing") {
        "/profile_check/landing" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago profile check landing congrats") {
        "/profile_check/landing/congrats" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago profile check landing tap") {
        "/profile_check/landing/tap" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://profile-engine/mcc"
        }
    }

}