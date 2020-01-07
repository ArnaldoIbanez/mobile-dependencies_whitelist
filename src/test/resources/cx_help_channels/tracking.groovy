package src.test.resources.cx_help_channels

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("test mercadolibre") {
        "/"(platform: "/") {}
    }

    defaultBusiness = "mercadopago"

    test("test mercadopago") {
        "/"(platform: "/") {}
    }

    defaultBusiness = "mercadoshops"

    test("test mercadoshops") {
        "/"(platform: "/") {}
    }

}