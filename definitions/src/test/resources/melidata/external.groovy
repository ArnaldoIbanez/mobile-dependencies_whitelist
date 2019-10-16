package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    test("External tracks tests ") {

        "/external/home"(platform: "/") {
            domain = "https://www.trocafone.com"
        }

        "/external/checkout"(platform: "/") {
            domain = "https://www.trocafone.com/checkout"
        }
    }

}
