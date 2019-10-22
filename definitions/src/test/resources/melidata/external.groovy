package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    test("External merchants tracks tests ") {

        "/external/merchants/home"(platform: "/") {
            domain = "www.trocafone.com"
        }

        "/external/merchants/checkout"(platform: "/") {
            domain = "www.trocafone.com"
        }
    }

}
