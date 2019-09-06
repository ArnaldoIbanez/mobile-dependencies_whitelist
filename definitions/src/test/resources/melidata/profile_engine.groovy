package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"


    test("Mercadopago profile check landing") {
        "/profile_check/landing" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago profile check image-upload") {
        "/profile_check/image-upload" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago profile check branding") {
        "/profile_check/branding" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago profile check soft-descriptor") {
        "/profile_check/soft-descriptor" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago profile check MCC") {
        "/profile_check/mcc" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago profile check store") {
        "/profile_check/store" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago profile check congrats") {
        "/profile_check/congrats" (platform: "/mobile", type: TrackType.View) {}
    }

    test("Mercadopago profile check landing tap") {
        "/profile_check/landing/tap" (platform: "/mobile", type: TrackType.Event) {
            link = "mercadopago://profile-engine/mcc"
        }
    }

}