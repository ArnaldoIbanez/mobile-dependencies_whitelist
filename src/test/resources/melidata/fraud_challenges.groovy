package src.test.resources.melidata


import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("Card challenge mobile android ml") {

        "/auth/card/validation"(platform: "/mobile/android") {}
    }

    test("Card challenge mobile ios ml") {
        
        "/auth/card/validation"(platform: "/mobile/ios") {}
    }

    test("Card challenge mobile web ml") {
        
        "/auth/card/validation"(platform: "/web") {}
    }

    test("Card challenge mobile web desktop ml") {
        
        "/auth/card/validation"(platform: "/web/desktop") {}
    }

    test("Card challenge mobile web desktop ml") {
        
        "/auth/card/validation"(platform: "/web/mobile") {}
    }

    defaultBusiness = "mercadopago"

    test("Card challenge mobile android mp") {

        "/auth/card/validation"(platform: "/mobile/android") {}
    }

    test("Card challenge mobile ios mp") {
        
        "/auth/card/validation"(platform: "/mobile/ios") {}
    }

    test("Card challenge mobile web mp") {
        
        "/auth/card/validation"(platform: "/web") {}
    }

    test("Card challenge mobile web desktop mp") {
        
        "/auth/card/validation"(platform: "/web/desktop") {}
    }

    test("Card challenge mobile web desktop mp") {
        
        "/auth/card/validation"(platform: "/web/mobile") {}
    }

}