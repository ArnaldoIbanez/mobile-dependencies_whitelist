package src.test.resources.melidata


import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Test auth card validation ml") {
        "/auth/card/validation"(platform: "/", type:TrackType.View) {}
        "/auth/card/validation"(platform: "/", type:TrackType.Event) {}
    }

    defaultBusiness = "mercadopago"

    test("Test auth card validation mp") {
        "/auth/card/validation"(platform: "/", type:TrackType.View) {}
        "/auth/card/validation"(platform: "/", type:TrackType.Event) {}
    }

}