package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("User") {
        "/user"(platform: "/") {}
    }

    test("Delete User") {
        "/user/delete"(platform: "/backend") {
            application_source = "registration"
            reason = "register_not_validated"
        }
    }
}
