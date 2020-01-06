package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadopago"

    test("user_blocker") {
        "/user_blocker/shield"(platform: "/mobile") {}
        "/user_blocker/webview"(platform: "/mobile") {}
        "/user_blocker/redirect"(platform: "/mobile") {}
    }
}