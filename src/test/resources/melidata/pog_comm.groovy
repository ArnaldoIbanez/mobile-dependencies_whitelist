package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadopago"

    test("Comm registry") {
        "/pog_comm/generic"(platform: "/email") {
            template_id = "testtemp"
            variant_id = "A"
        }
    }
}

