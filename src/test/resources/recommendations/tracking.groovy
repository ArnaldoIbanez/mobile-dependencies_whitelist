package src.test.resources.recommendations

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("test mercadolibre") {
        "/"(platform: "/") {}
    }

    defaultBusiness = "tucarro"

    test("test tucarro") {
        "/"(platform: "/") {}
    }

    defaultBusiness = "portalinmobiliario"

    test("test portalinmobiliario") {
        "/"(platform: "/") {}
    }

    defaultBusiness = "tumoto"

    test("test tumoto") {
        "/"(platform: "/") {}
    }

    defaultBusiness = "metroscubicos"

    test("test metroscubicos") {
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