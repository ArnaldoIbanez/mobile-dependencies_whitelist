package src.test.resources.melidata


import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    defaultBusiness = "mercadolibre"

    test("Test auth card validation ml") {
        "/auth/card/landing"(platform: "/") {}
        "/auth/card/validation"(platform: "/") {
            challenge = "test"
            status = "started"
            site = "mlb"
            marketplace = "on"
            bank = "nubank"
            payment_method_id = "visa"
        }
    }

    defaultBusiness = "mercadopago"

    test("Test auth card validation mp") {
        "/auth/card/landing"(platform: "/") {}
        "/auth/card/validation"(platform: "/") {
            challenge = "test"
            status = "started"
            site = "mlb"
            marketplace = "on"
            bank = "nubank"
            payment_method_id = "visa"
        }
    }

}