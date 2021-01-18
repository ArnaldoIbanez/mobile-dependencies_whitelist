package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    ["mercadolibre", "mercadopago"].each { business ->
        defaultBusiness = business

        test("navigation cookie-disclaimer show track") {
            "/navigation/cookie-disclaimer/show"(platform: "/", type: TrackType.View) {}
        }

        test("navigation cookie-disclaimer accept track") {
            "/navigation/cookie-disclaimer/accept"(platform: "/", type: TrackType.Event) {}
        }

    }
}
